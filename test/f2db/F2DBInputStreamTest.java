package f2db;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class F2DBInputStreamTest extends JunitTestSupport {

	BufferedInputStream instance;
	F2DBInputStream fins;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		fins = F2DBStreamFactory.getF2DBInputStream("test/usr/fileRoot");
		instance = new BufferedInputStream(fins);
	}

	@After
	public void tearDown() {
		instance = null;
	}

	@Test
	public void testRead() {
		int b;
		try {
			while ((b = instance.read()) != -1) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				instance.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void testReadFilenotExit() throws IOException {
		try {
			instance = new BufferedInputStream(
					F2DBStreamFactory.getF2DBInputStream("not exit in db"));
			instance.read();
			fail();
		} catch (Exception e) {
			assertEquals(e.getCause().getMessage(),
					"no file named not exit in db exit in db");
		} finally {
			try {
				instance.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
