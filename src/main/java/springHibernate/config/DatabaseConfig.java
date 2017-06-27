package springHibernate.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by liuyang on 2017/6/24.
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class DatabaseConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.mysql.driver"));
        dataSource.setUrl(environment.getProperty("spring.mysql.url"));
        dataSource.setPassword(environment.getProperty("spring.mysql.password"));
        dataSource.setUsername(environment.getProperty("spring.mysql.username"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean factoryBean(DataSource dataSource){
        LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("springHibernate/domain");
        Properties properties=new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        factoryBean.setHibernateProperties(properties);
        return factoryBean;
    }
}
