package wang.seamas.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {



    @Bean(name = "masterDatasource")
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource getMasterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDatasource")
    @ConfigurationProperties(prefix = "datasource.slave")
    public DataSource getSlaveDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "datasource")
    public DataSource getDataSource(@Qualifier("masterDatasource")DataSource masterDatasource, @Qualifier("slaveDatasource")DataSource slaveDatasource) {
        ThreadLocalRoutingDataSource dataSource = new ThreadLocalRoutingDataSource();

        dataSource.setDefaultTargetDataSource(masterDatasource);
        Map<Object, Object> targetDatasource = new HashMap<>();
        targetDatasource.put(DataTypes.SLAVE, slaveDatasource);
        targetDatasource.put(DataTypes.MASTER, masterDatasource);
        dataSource.setTargetDataSources(targetDatasource);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);

        sqlSessionFactory.setConfiguration(configuration);

        return sqlSessionFactory.getObject();
    }


    @Bean
    public TransactionManager transactionManager(@Qualifier("datasource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
