package f2db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;

public class TestF2DBJDBCBase extends JunitTestSupport {

	@Test
	public void testInitDBoutStreamUpdate() throws SQLException {
		DataSource ds = (DataSource) getTestOject("dataSource");
		F2DBJdbcBase fb = new F2DBJdbcBase(ds);
		String filePath = "test/usr/fileRoot";
		fb.initDBoutStreamUpdate(filePath);

		assertTimeModified(filePath);
	}

	private void assertTimeModified(String filePath) throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@hzhwd103:1521:orcl", "BSMDBA", "BSMDBA");
		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select LAST_MOD_DATE_TIME from BMW_F2DB where FILE_PATH='"
						+ filePath + "'");
		if (rs.next()) {
			Object o = rs.getObject(1);
			System.out.println(o);
			assertNotNull(o);
		}
	}
}
