package f2db;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.sql.DataSource;

import oracle.sql.BLOB;

import org.springframework.jdbc.core.JdbcTemplate;

//TODO:TRANSFER INLINE SQL TO SP.
/**
 * this class is used to open a stream from database and write data in db. you
 * can just use it as java standard io stream.
 * 
 * @author e533268 Liting Zhao.
 *
 */
public class F2DBOutputStream extends OutputStream {

	static final Logger LOG = Logger.getLogger("F2DBOutputStream");

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private String filePath;
	Statement st = null;
	ResultSet rs = null;

	Connection con = null;

	OutputStream dbOutStream = null;

	public F2DBOutputStream() {

	}

	@Override
	public void write(int b) throws IOException {
		dbOutStream.write(b);
	}

	@Override
	public void flush() throws IOException {
		dbOutStream.flush();
	}

	@Override
	public void close() throws IOException {
		dbOutStream.close();

		try {
			if (con != null) {
				con.commit();
			}
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null && !con.isClosed()) {
				con.close();
			}
			LOG.info("success ,output stream connection closed.");
		} catch (SQLException e) {
			LOG.warning(this.getClass().getSimpleName()
					+ " close connection occur exception");
			e.printStackTrace();
		}
	}

	public void initDBoutStream(String filePath) {
		LOG.info("open output stream from db for path: " + filePath);
		// get outputStream from database

		try {
			// con = dataSource.getConnection();
			// con.setAutoCommit(false);
			F2DBJdbcBase f2DBJdbcBase = new F2DBJdbcBase(dataSource);
			// int recordNum =
			// jdbcTemplate.queryForInt("select count(*) from BMW_F2DB where FILE_PATH=?",
			// filePath);
			long recordNum = f2DBJdbcBase.initDBoutStreamGetCount(filePath);
			long recordNum2 = f2DBJdbcBase.initDBoutStreamGetCount(filePath);
			long recordNum3 = f2DBJdbcBase.initDBoutStreamGetCount(filePath);
			long recordNum4 = f2DBJdbcBase.initDBoutStreamGetCount(filePath);

			if (recordNum == 0) {
				// jdbcTemplate.update("insert into BMW_F2DB (FILE_PATH,FILE_CONTENT) values ('"+filePath+"',empty_blob())");
				f2DBJdbcBase.initDBoutStreamInsert(filePath);
			} else {
				LOG.info("path exit, override thi file...");
				// jdbcTemplate.update("update BMW_F2DB set LAST_MOD_DATE_TIME =sysdate where FILE_PATH = '"
				// + filePath + "'");
				f2DBJdbcBase.initDBoutStreamUpdate(filePath);

			}

			/*
			 * st = con.createStatement(); rs =
			 * st.executeQuery("select FILE_CONTENT from BMW_F2DB where FILE_PATH='"
			 * +filePath+"' for update");
			 * 
			 * if (rs.next()) { oracle.sql.BLOB blob = (oracle.sql.BLOB)
			 * rs.getBlob(1); dbOutStream = blob.getBinaryOutputStream(); }
			 */

			Blob blob = f2DBJdbcBase.initDBoutStream(filePath);
			if (null != blob) {
				dbOutStream = ((BLOB) blob).getBinaryOutputStream();
			}
			// BLOB blob = (BLOB)
			// jdbcTemplate.queryForObject("select FILE_CONTENT from BMW_F2DB where FILE_PATH='"+filePath+"' for update",
			// Blob.class);
			// dbOutStream = blob.getBinaryOutputStream();
		} catch (SQLException e) {
			e.printStackTrace();

			LOG.warning(this.getClass().getSimpleName()
					+ " open stream from db occur error. try to close connection");

			try {

				con.rollback();

				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
				LOG.warning(this.getClass().getSimpleName()
						+ " close connection finished");
			} catch (SQLException ex) {
				LOG.warning(this.getClass().getSimpleName()
						+ " close connection occur error");
			}

		}
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		initDBoutStream(this.filePath);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

}
