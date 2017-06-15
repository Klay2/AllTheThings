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
  private StaticEndpoint index;

  @Autowired
  private DataSource dataSource;


  public void setDataSource(DataSource dataSourceIn){
    this.dataSource = dataSourceIn;
  }

  @RequestMapping("/")
  String indexEndpoint(){
    return index.getResponse("getBody", @RequestHeader Map<String, String>);
  }








}
