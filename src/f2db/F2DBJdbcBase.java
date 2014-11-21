package f2db;

import java.sql.Blob;
import java.sql.Types;

import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import util.StoredProcedureBase;
import util.StoredProcedureName;

public class F2DBJdbcBase extends StoredProcedureBase implements
		StoredProcedureName {

	public F2DBJdbcBase(DataSource ds) {
		super(ds);
	}

	public Blob initDBinputStream(String p_path) {
		/*
		 * this.simpleJdbcCall.declareParameters(new SqlOutParameter("P_CUR",
		 * OracleTypes.CURSOR), new SqlParameter("P_FILEPATH",Types.VARCHAR));
		 */
		this.simpleJdbcCall.declareParameters(new SqlOutParameter("P_CONTENT",
				OracleTypes.BLOB),
				new SqlParameter("P_FILEPATH", Types.VARCHAR));
		this.simpleJdbcCall.withCatalogName(F2DBInputStreamPackage);
		this.simpleJdbcCall.setProcedureName(INITDBINPUTSTREAM);
		SqlParameterSource in = new MapSqlParameterSource().addValue(
				"P_FILEPATH", p_path);

		return (Blob) this.simpleJdbcCall.execute(in).get("P_CONTENT");

		// ResultSet rs;

	}

	public void initDBoutStreamInsert(String p_path) {
		this.simpleJdbcCall.addDeclaredParameter(new SqlParameter("P_FILEPATH",
				Types.VARCHAR));
		this.simpleJdbcCall.withCatalogName(F2DBInputStreamPackage);
		this.simpleJdbcCall.setProcedureName(INITDBOUTSTREAM_INSERT);
		SqlParameterSource in = new MapSqlParameterSource().addValue(
				"P_FILEPATH", p_path);

		this.simpleJdbcCall.execute(in);
	}

	public void initDBoutStreamUpdate(String p_path) {
		this.simpleJdbcCall.declareParameters(new SqlParameter("P_FILEPATH",
				Types.VARCHAR));
		this.simpleJdbcCall.withCatalogName(F2DBInputStreamPackage);
		this.simpleJdbcCall.setProcedureName(INITDBOUTSTREAM_UPDATE);
		SqlParameterSource in = new MapSqlParameterSource().addValue(
				"P_FILEPATH", p_path);

		this.simpleJdbcCall.execute(in);
	}

	public long initDBoutStreamGetCount(String p_path) {
		this.simpleJdbcCall.declareParameters(new SqlParameter("P_FILEPATH",
				Types.VARCHAR), new SqlOutParameter("P_COUNT", Types.BIGINT));
		this.simpleJdbcCall.withCatalogName(F2DBInputStreamPackage);
		this.simpleJdbcCall.setProcedureName(INITDBOUTSTREAM_GET_COUNT);
		SqlParameterSource in = new MapSqlParameterSource().addValue(
				"P_FILEPATH", p_path);

		return (Long) this.simpleJdbcCall.execute(in).get("P_COUNT");
	}

	public Blob initDBoutStream(String p_path) {
		this.simpleJdbcCall.declareParameters(new SqlOutParameter("P_CONTENT",
				OracleTypes.BLOB),
				new SqlParameter("P_FILEPATH", Types.VARCHAR));
		this.simpleJdbcCall.withCatalogName(F2DBInputStreamPackage);
		this.simpleJdbcCall.setProcedureName(INITDBOUTSTREAM_GET);
		SqlParameterSource in = new MapSqlParameterSource().addValue(
				"P_FILEPATH", p_path);

		Blob blob = (Blob) (this.simpleJdbcCall.execute(in).get("P_CONTENT"));
		return blob;
	}
}
