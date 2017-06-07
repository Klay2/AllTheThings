package allthethings.controller;
import org.springframework.context.annotation.*;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class RestControllerConfig{




  @Bean
  public DataSource getDataSource() throws SQLException{
    @Value("${spring.datasource.url}")//grabs value from application.properties
    String databaseURL;
    @Value("${spring.datasource.username}")
    String databaseUser;
    @Value("${spring.datasource.password}")
    String databasePass;

    if(databaseURL == null){
      throw new SQLException("databaseURL null");
    }
    else if(databaseUser == null){
      throw new SQLException("database username null");
    }
    else if(databasePass == null){
      throw new SQLException("database password null");
    } else{

      HikariConfig hConfig = new Hikariconfig();
      config.setjdbcUrl(dataBaseURL);
      config.setUsername(databaseUser);
      config.setPassword(databasePass);
  //config.addDataSourceProperty("cachePrepStmts", "true"); antipattern
  //  the database itself does this its configurable in postgres

      return newHikariDataSource(hConfig);
    }

  }


}
