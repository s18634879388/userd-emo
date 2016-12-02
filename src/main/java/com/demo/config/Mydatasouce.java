package com.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by Administrator on 2016/12/2.
 */
@Configuration
public class Mydatasouce {
    @Value("${myjdbc.driverClass}")
    private String driverclass;
    @Value("${myjdbc.url}")
    private String url;
    @Value("${myjdbc.user}")
    private String user;
    @Value("${myjdbc.password}")
    private String password;

    @Bean(name="mydatabase")
    public DataSource getDataSouce() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driverclass);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setInitialPoolSize(5);
        comboPooledDataSource.setMinPoolSize(2);
        comboPooledDataSource.setMaxPoolSize(10);
        comboPooledDataSource.setIdleConnectionTestPeriod(3000);
        return comboPooledDataSource;
    }

}
