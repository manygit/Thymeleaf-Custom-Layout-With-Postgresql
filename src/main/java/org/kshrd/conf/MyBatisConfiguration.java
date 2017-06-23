package org.kshrd.conf;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("org.kshrd.repositories")
public class MyBatisConfiguration {
	private DataSource dataSource;
	
	@Autowired
	public MyBatisConfiguration(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(){
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public SqlSessionFactoryBean sessionFactory(){
		SqlSessionFactoryBean sessionBean = new SqlSessionFactoryBean();
		sessionBean.setDataSource(dataSource);
		return sessionBean;
	}
}
