package f2db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;

import org.junit.Test;

public class CopyOfTestF2DBJDBCBase extends JunitTestSupport {

	@Test
	public void testInitDBoutStreamUpdate() throws SQLException {
		// DataSource ds = (DataSource)getTestOject("dataSource");
		// F2DBJdbcBase fb = new F2DBJdbcBase(ds);
		String filePath = "testMail/mailAttachedFile.txt";
		// fb.initDBoutStreamUpdate(filePath);

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
		st.executeUpdate("update BMW_F2DB set LAST_MOD_DATE_TIME =sysdate where FILE_PATH =  '"
				+ filePath + "'");
		ResultSet rs = st
				.executeQuery("select LAST_MOD_DATE_TIME from BMW_F2DB where FILE_PATH='"
						+ filePath + "'");

		if (rs.next()) {
			Object o = rs.getObject(1);
			System.out.println(o);
			Assert.assertNotNull(o);
		}
	}
}
