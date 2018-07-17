package com.vivek.informationmodule;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.config.ResultType;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableJpaRepositories("com.vivek.informationmodule.repositories")
public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration{
	
	
	
	protected EclipseLinkJpaConfiguration(DataSource dataSource, JpaProperties properties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManager,
			ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
		super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder, @Autowired DataSource dataSource) {
	    final LocalContainerEntityManagerFactoryBean ret = builder.dataSource(dataSource)
	            .packages("com.vivek.informationmodule.models")
	            .persistenceUnit("pu")
	            .properties(getVendorProperties())
	            .build();

	    return ret;
	}

	@Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() { 
        return new EclipseLinkJpaVendorAdapter(); 
    }
	
	@Override
	protected Map<String, Object> getVendorProperties() {
	    HashMap<String, Object> map = new HashMap<>();
	    map.put(PersistenceUnitProperties.WEAVING, "false");
//	    map.put(QueryHints.RESULT_TYPE, ResultType.Map);
	    map.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
	    return map;
	}
	
}