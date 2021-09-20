package com.training;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgreEntityManagerFactory",
    transactionManagerRef = "postgreTransactionManager", basePackages = {"com.training.postgre.repo"})

public class PostgreDbConfig {

  @Bean(name = "postgreDataSource")
  @ConfigurationProperties(prefix = "postgre.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "postgreEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean postgreEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("postgreDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.training.postgre.domain").persistenceUnit("postgre")
        .build();
  }

  @Bean(name = "postgreTransactionManager")
  public PlatformTransactionManager postgreTransactionManager(
      @Qualifier("postgreEntityManagerFactory") EntityManagerFactory postgreEntityManagerFactory) {
    return new JpaTransactionManager(postgreEntityManagerFactory);
  }
    
}
