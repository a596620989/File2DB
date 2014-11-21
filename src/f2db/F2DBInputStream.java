package f2db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * this class is used to open a stream from database and read data from db. you
 * can just use it as java standard io stream.
 * 
 * @author e533268 Liting Zhao.
 * 
 */
public class F2DBInputStream extends InputStream {

	static final Logger LOG = Logger.getLogger("F2DBInputStream");

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private String filePath;

	private F2DBInputStream() {
	}

	public F2DBInputStream getInstance() {
		return Instance.instance;
	}

	public static class Instance {
		static final F2DBInputStream instance = new F2DBInputStream();
	}

	Connection con = null;
	InputStream dbInStream = null;

	@Override
	public void close() throws IOException {
		dbInStream.close();

		try {
			con.commit();
			con.close();
			LOG.info("success ,input stream connection closed.");
		} catch (SQLException e) {
			LOG.warning(this.getClass().getSimpleName()
					+ " close connection occur exception");
			e.printStackTrace();
		}
	}

	// TODO: use GenConnectionPool , and extract param like tableName and ?.
	public void initDBinputStream(final String filePath) throws IOException {
		LOG.info("get input stream for path: " + filePath);

		try {
			con = dataSource.getConnection();
			// con.setAutoCommit(false);

			// String sql =
			// "select FILE_CONTENT from BMW_F2DB where FILE_PATH='" + filePath
			// + "'";

			Blob blob = new F2DBJdbcBase(dataSource)
					.initDBinputStream(filePath);

			if (null != blob) {
				dbInStream = blob.getBinaryStream();
			} else {
				LOG.warning("no file named " + filePath + " exit in db");
				throw new SQLException("no file named " + filePath
						+ " exit in db");
			}
			/*
			 * jdbcTemplate.execute(sql, new CallableStatementCallback<Object>()
			 * {
			 * 
			 * @Override public Object doInCallableStatement(CallableStatement
			 * callablestatement) throws SQLException, DataAccessException {
			 * ResultSet rs = callablestatement.executeQuery(); if (rs.next()) {
			 * dbInStream = rs.getBinaryStream("FILE_CONTENT"); } else {
			 * LOG.warning("no file named " + filePath + " exit in db"); throw
			 * new SQLException("no file named " + filePath + " exit in db"); }
			 * return null; }
			 * 
			 * });
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			LOG.warning(this.getClass().getSimpleName()
					+ "open in stream from db occur error. try to close connection");

			try {
				if (con != null) {
					con.close();
				}
				LOG.warning(this.getClass().getSimpleName()
						+ "close connection finished");
			} catch (SQLException ex) {
				LOG.warning(this.getClass().getSimpleName()
						+ "close connection occur error");
			}

		}
	}

	@Override
	public int read() throws IOException {
		if (dbInStream == null) {
			throw new IOException(
					"db inputStream initilaze fail, may this file don't exit in db");
		}
		return dbInStream.read();
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		try {
			initDBinputStream(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
