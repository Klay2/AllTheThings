package allthethings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;


@Controller
public class RestController{

  @Autowired
  private DataSource dataSource;

  @RequestMapping("/")
  String getIndex(){
    return "hello thar it works this far!"
  }

  @RequestMapping("/dbTest")
    String dbTest(){
      String testStmtStr = "SELECT * FROM testing WHERE id = ?";

      try(Connection testConn = dataSource.getConnection()){
        PreparedStatement testStmt = testConn.prepareStatement(testStmtStr);
        testStmt.setString(1, "sammich");
        ResultSet testResults = testStmt.executeQuery();
        return testResults.getString(1);
      } catch (Exception e){
        return e.getMessage();
      }

    }





}
