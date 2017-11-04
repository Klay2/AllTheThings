package allthethings.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;



//@EnableAutoConfiguration redundant with springbootapplication
//@ComponentScan redundant with springbootapplication
@SpringBootApplication
public class Application{


  @Bean
  public DataSource setDataSource(String databaseURL, String databaseUser, String databasePass) throws SQLException{

    HikariConfig hConfig = new HikariConfig();
    hConfig.setJdbcUrl(databaseURL);
    hConfig.setUsername(databaseUser);
    hConfig.setPassword(databasePass);
  //config.addDataSourceProperty("cachePrepStmts", "true"); antipattern
  //  the database itself does this its configurable in postgres

  //TODO:need to implement an onDestroy for the hikari bean.. close the datasrc


    return new HikariDataSource(hConfig);
  }

  public static void Main(String[] args) throws Exception{
    SpringApplication.run(MainController.class, args);
  }



}
