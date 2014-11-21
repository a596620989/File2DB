package util;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

public abstract class StoredProcedureBase extends StoredProcedure {
	protected static final Logger LOG = Logger.getLogger("DaoJdbc");

	protected DataSource dataSource;
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	protected JdbcTemplate jdbcTemplate;
	protected SimpleJdbcInsert simpleJdbcInsert;
	protected SimpleJdbcCall simpleJdbcCall;

	public StoredProcedureBase(DataSource ds) {
		super();
		this.setDataSource(ds);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		// this needs to be specified before use
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
		// .withTableName("t_actor").usingGeneratedKeyColumns("id");
		this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
		// add by sjj
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public DataSource getDataSource() {
		return this.dataSource;
	}
	/*
	 * public StoredProcedureBase(String storedProcedureName,RowMapper mapper){
	 * super(ds, storedProcedureName); declareParameter(new
	 * SqlOutParameter("p_cur", OracleTypes.CURSOR, mapper)); compile(); }
	 */
	/*
	 * public Map execute(String para_name,String para_value) { Map inputs = new
	 * HashMap(); inputs.put(para_name, para_value); return
	 * super.execute(inputs); }
	 */

}
