package f2db;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class F2DBOutputStreamTest extends JunitTestSupport {

	OutputStream instance;

	@Before
	public void setUp() throws Exception {
		super.setUp();

		instance = new BufferedOutputStream(
				F2DBStreamFactory.getF2DBOutputStream("test/usr/fileRoot"));
	}

	@After
	public void tearDown() {
		instance = null;
	}

	@Test
	public void testWrite() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 10000; i++) {
			sb.append(i);
		}

		try {
			instance.write(sb.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				instance.flush();
				instance.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
