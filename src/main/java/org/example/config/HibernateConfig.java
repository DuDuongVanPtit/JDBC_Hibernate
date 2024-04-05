//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class HibernateConfig {
//
//    @Bean
//    public SessionFactory sessionFactory(DataSource dataSource) {
//        Configuration config = new Configuration();
//        config.addAnnotatedClass(YourEntity.class); // Add your entity classes here
//        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        config.setProperty("hibernate.show_sql", "true");
//        // Add other Hibernate properties...
//
//        config.setDataSource(dataSource);
//        return config.buildSessionFactory();
//    }
//}