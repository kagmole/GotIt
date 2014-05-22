package ch.hearc.gotit.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "ch.hearc.gotit.daos.impl")
public class PersistenceConfig {
	
	private final static Properties HIBERNATE_PROPERTIES = new Properties();
	
	static {
		HIBERNATE_PROPERTIES.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		HIBERNATE_PROPERTIES.setProperty("hibernate.hbm2ddl.auto", "update");
		HIBERNATE_PROPERTIES.setProperty("hibernate.show_sql", "true");
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("ch.hearc.gotit.entities");
		sessionFactory.setHibernateProperties(HIBERNATE_PROPERTIES);
		
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		dataSource.setUrl("jdbc:mysql://localhost:3306/gotit");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
}