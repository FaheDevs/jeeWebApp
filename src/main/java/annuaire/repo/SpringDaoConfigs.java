package annuaire.repo;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SpringDaoConfigs {
    @Bean
    public DataSource myDatasource(//
                @Value("${spring.datasource.url}") String url, //
                @Value("${spring.datasource.username}") String user, //
                @Value("${spring.datasource.password}") String password//
    ) {
            System.out.println("--- my datasource");
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(user);
            config.setPassword(password);
            // le pool de connexion doit gérer
            // entre 5 et 10 connections prêtes.
            config.setMinimumIdle(5);
            config.setMaximumPoolSize(10);
            return new HikariDataSource(config);
        };



}
