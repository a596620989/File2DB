package f2db;

import util.SpringContenxtHolder;

public class F2DBStreamFactory {

	public static F2DBInputStream getF2DBInputStream(String filePath) {
		F2DBInputStream fins = (F2DBInputStream) SpringContenxtHolder.springContext
				.getBean("f2DBInputStream");
		fins.setFilePath(filePath);

		return fins;
	}

	public static F2DBOutputStream getF2DBOutputStream(String filePath) {
		F2DBOutputStream fous = (F2DBOutputStream) SpringContenxtHolder.springContext
				.getBean("f2DBOutputStream");
		fous.setFilePath(filePath);

		return fous;
	}

}
