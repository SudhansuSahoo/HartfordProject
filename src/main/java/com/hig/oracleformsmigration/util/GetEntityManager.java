package com.hig.oracleformsmigration.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;


@Component
public class GetEntityManager {
	
	public EntityManager fetchEntityManager() {
			
			final Properties persistenceProperties = new Properties();
			InputStream is = null;
			try {
				is = getClass().getClassLoader().getResourceAsStream("application.properties");
				try {
					persistenceProperties.load(is);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException ignored) {
					}
				}
			}
			//@SuppressWarnings("unused")
			//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("generated", persistenceProperties);
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Hardford_Entity", persistenceProperties);    
			EntityManager entitymanager = emfactory.createEntityManager();
			return entitymanager;
		}

}
