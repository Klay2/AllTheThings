package allthethings.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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
  public DataSource setDataSource() throws SQLException{
    @Value("${spring.datasource.url}")//grabs value from application.properties
    String databaseURL;
    @Value("${spring.datasource.username}")
    String databaseUser;
    @Value("${spring.datasource.password}")
    String databasePass;
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
    SpringApplication.run(RestController.class, args);
  }



}
