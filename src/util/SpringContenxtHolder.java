package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContenxtHolder implements ApplicationContextAware {
	public static transient ApplicationContext springContext;

	@Override
	public void setApplicationContext(ApplicationContext context) {
		if (springContext == null) {
			springContext = context;
		}
	}

}
