package wang.seamas.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.xa.client.OracleXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource primaryDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.slave")
    public DataSource slaveDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate slaveJdbcTemplate(@Qualifier("slaveDataSource")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
