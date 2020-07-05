package com.yunlu.mechanismmodel.wlfac;

import com.yunlu.mechanismmodel.wlfac.util.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {
        HibernateJpaAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class
})
@ServletComponentScan(basePackages = "com.yunlu.mechanismmodel.wlfac")
@Configuration

/**
 *
 * 启动参数 -d 指定端口号（默认7021）
 *
 * @author haozhiqiang 2019/9/9
 **/
public class MainApplication extends Application {

    public static void main(String[] args){
        String[] applicationArgs = getArgs(args);
        if(applicationArgs == null){
            return;
        }
        SpringApplication.run(MainApplication.class, applicationArgs);
    }
}

