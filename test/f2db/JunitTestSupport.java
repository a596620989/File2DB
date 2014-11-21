package f2db;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;

public class JunitTestSupport extends TestCase {
	public static ApplicationContext ctx;

	public static Object getTestOject(String beanId) {
		return ctx.getBean(beanId);
	}

	public static void fail() {
		Assert.fail();
	}

	public static void assertTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	public static void assertFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	public static void assertEquals(Date expected, Date actual) {
		if (expected == null) {
			Assert.assertNull(actual);
		} else if (actual == null) {
			Assert.assertNull(expected);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String d1 = sdf.format(expected);
			String d2 = sdf.format(actual);
			Assert.assertEquals(d1, d2);
		}
	}

	public static void assertEquals(String expected, String actual) {
		if (expected == null) {
			Assert.assertNull(actual);
		} else
			Assert.assertTrue(expected.trim().equals(actual.trim()));
	}

	public static void assertEquals(String expected, Object actual) {
		if (expected == null) {
			Assert.assertNull(actual);
		} else
			Assert.assertTrue(expected.equals(actual.toString()));
	}

	public static void assertEquals(Object expected, Object actual) {
		if (expected == null) {
			Assert.assertNull(actual);
		} else
			assertEquals(expected.toString(), actual.toString());
	}

	public static void assertEquals(int expected, int actual) {
		Assert.assertEquals(expected, actual);
	}
}
