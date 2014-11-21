package f2db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

import org.junit.Test;

public class F2DBAssert extends TestCase {

	// /*
	// * to assert one output stream is not exit in db.
	// */
	// public static void assertOutputStreamNotExit(String filePath) throws
	// SQLException{
	// try
	// {
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// }
	// catch (ClassNotFoundException e)
	// {
	// e.printStackTrace();
	// }
	// Connection con =
	// DriverManager.getConnection("jdbc:oracle:thin:@hzhwd103:1521:orcl",
	// "BSMDBA", "BSMDBA");
	// Statement st = con.createStatement();
	// ResultSet rs =
	// st.executeQuery("select FILE_CONTENT from BMW_F2DB where FILE_PATH='"+filePath+"'");
	// if (rs.next()){
	// fail();
	// }
	// }

	/*
	 * to assert one output stream is stored in db.
	 */
	public static void assertOutputStreamExit(String filePath)
			throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@hzhwd103:1521:orcl", "BSMDBA", "BSMDBA");
		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select FILE_CONTENT from BMW_F2DB where FILE_PATH='"
						+ filePath + "'");
		if (!rs.next()) {
			fail();
		}
	}

	@Test
	public void testForNothing() {
		assertTrue(true);
	}

}
