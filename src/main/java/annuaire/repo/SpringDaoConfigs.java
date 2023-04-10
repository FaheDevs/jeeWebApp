package annuaire.repo;


import org.springframework.beans.factory.annotation.Autowired;
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
@ComponentScan(basePackageClasses = SpringDaoConfigs.class)
@EnableTransactionManagement
public class SpringDaoConfigs {
    /**
     * Ce code Java crée un bean Spring dataSource qui fournit une source de données pour accéder à une base
     * de données HSQLDB. Le bean utilise la classe DriverManagerDataSource fournie par Spring pour créer une
     * instance de la source
     * de données et configurer les propriétés de connexion, telles que le nom de classe du pilote JDBC, l'URL
     * de la base de données, le nom d'utilisateur et le mot de passe.*/
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUsername("user");
        dataSource.setPassword("user");
        dataSource.setUrl("jdbc:hsqldb:mem:database/finalDb");
        return dataSource;
    }
    /**
     Ce code Java crée un bean Spring entityManagerFactory qui configure un gestionnaire d'entités pour
     interagir avec une base de données. Le bean utilise la classe LocalContainerEntityManagerFactoryBean
     fournie par Spring pour créer l'instance du gestionnaire d'entités et configurer ses propriétés.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[] { "annuaire.model" });
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // Configuration d'hibernate
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        em.setJpaProperties(properties);
        return em;
    }

    /**
     * Construction d'un gestionnaire de transaction
     * en liaison avec l'usine à EM.
     *
     * Ce code Java crée un bean Spring transactionManager qui configure le gestionnaire de transactions pour
     * interagir avec le gestionnaire d'entités créé précédemment.
     * Le bean prend en entrée l'instance EntityManagerFactory créée précédemment et la passe au JpaTransactionManager.
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    /**
     * Activer le traitement des annotations
     * de gestion du contexte de persistence.
     *
     * Ce code Java crée un bean Spring annotationProcessor qui
     *  configure le traitement des annotations de persistance JPA.
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor annotationProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }
}
