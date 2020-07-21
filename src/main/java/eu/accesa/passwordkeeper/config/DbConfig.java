package eu.accesa.passwordkeeper.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//@Configuration
//public class DbConfig {
//    @Value("${db.default.url}")
//    String dbUrl;
//    @Value("${db.default.user}")
//    String dbUser;
//    @Value("${db.default.password}")
//    String dbPass;
//    @Value("${db.default.driver}")
//    String dbDriver;
//    @Value("${db.default.pool.size}")
//    Integer maxPoolSize;
//
//    private final HikariDataSource hikariDataSource = new HikariDataSource();
//
//    @PostConstruct
//    public void init() {
//        hikariDataSource.setDriverClassName(dbDriver);
//        hikariDataSource.setJdbcUrl(dbUrl);
//        hikariDataSource.setConnectionTestQuery("select 1");
//        hikariDataSource.setUsername(dbUser);
//        hikariDataSource.setPassword(dbPass);
//        hikariDataSource.setMaximumPoolSize(maxPoolSize);
//    }
//    @Bean
//    public DataSource getPostgresDataSource() {
//        return hikariDataSource;
//    }
//}
