package allthethings.controller;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class RestControllerConfig{

  @Value("${spring.datasource.url}")//grabs value from application.properties
  private String databaseURL;
  @Value("${spring.datasource.username}")
  private String databaseUser;
  @Value("${spring.datasource.password}")
  private String databasePass;


  //bean for root endpoint currently set to test endpoint
  /*
  @Bean
  public StaticEndpoint setRootEndpoint(){
    return new TestRoot();
  }
*/

  //bean for setting up hikari cp for Datasource in restController
  @Bean
  public DataSource setDataSource() throws SQLException{


    if(databaseURL == null){
      throw new SQLException("databaseURL null");
    }
    else if(databaseUser == null){
      throw new SQLException("database username null");
    }
    else if(databasePass == null){
      throw new SQLException("database password null");
    } else{

      HikariConfig hConfig = new HikariConfig();
      hConfig.setJdbcUrl(databaseURL);
      hConfig.setUsername(databaseUser);
      hConfig.setPassword(databasePass);
  //config.addDataSourceProperty("cachePrepStmts", "true"); antipattern
  //  the database itself does this its configurable in postgres

      return new HikariDataSource(hConfig);
    }

  }


}
