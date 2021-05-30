package com.ihusain;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.ihusain.model.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {}

	static {
		try {
			Configuration configuration = new Configuration();
			
			Properties settings = new Properties();
	        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/learning");
	        settings.put(Environment.USER, "root");
	        settings.put(Environment.PASS, "root");
	        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	        settings.put(Environment.SHOW_SQL, "true");
	        
	        configuration.setProperties(settings);
	        configuration.addAnnotatedClass(Employee.class);		
	
	        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
