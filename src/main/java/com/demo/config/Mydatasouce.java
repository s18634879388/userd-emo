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
        comboPooledDataSource.setInitialPoolSize(5);//初始化获取5个连接
        comboPooledDataSource.setMinPoolSize(2);//最小连接数
        comboPooledDataSource.setMaxPoolSize(10);//最大连接数
        comboPooledDataSource.setIdleConnectionTestPeriod(3000);//每3000秒检查连接池中的空闲连接
        return comboPooledDataSource;
    }

}
