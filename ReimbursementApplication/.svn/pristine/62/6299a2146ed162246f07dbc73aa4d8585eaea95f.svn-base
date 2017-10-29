package com.avizva.config;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com")
@Configuration
@PropertySource({ "classpath:application.properties", "classpath:config.properties" })
@EnableTransactionManagement
public class ApplicationContextConfig {
	int port;
	@Autowired
	private Environment env;

	/**
	 * 
	 * for creating connection with database data from property files
	 * 
	 * @return datasource
	 */

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty("db.DriverClassName"));
		dataSource.setUrl(env.getProperty("db.Url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));

		return dataSource;
	}

	/**
	 * set generic hibernate properties
	 * 
	 * @return properties
	 */

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;

	}

	/**
	 * for creating all the beans of package com
	 * 
	 * @param dataSource
	 * @return
	 */
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		// sessionBuilder.addAnnotatedClasses(Categories.class);

		sessionBuilder.scanPackages("com"); // This is used to scan a package
											// for Annotated Classes

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	/**
	 * This method id for setting properties of mail
	 * 
	 * @return mailSender object
	 */
	@Autowired
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(env.getProperty("smtp.host"));
		port = Integer.parseInt(env.getProperty("smtp.port"));
		mailSender.setPort(port);
		mailSender.setUsername(env.getProperty("smtp.username"));
		mailSender.setPassword(env.getProperty("smtp.password"));
		Properties properties = mailSender.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "false");
		return mailSender;
	}

	@Autowired
	@Bean
	public Session getJavaAuth() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "false");

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("contact.acemyride@gmail.com", "#acemyride2017");
			}
		};

		Session session = Session.getInstance(properties, auth);
		return session;
	}

}
