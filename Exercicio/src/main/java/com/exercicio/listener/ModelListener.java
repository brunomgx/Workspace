package com.exercicio.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ModelListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// This will be invoked as part of a warmup request, or the first user
	    // request if no warmup request was invoked.
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// App Engine does not currently invoke this method.
	}

}
