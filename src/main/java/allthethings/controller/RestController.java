package allthethings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;


@Controller
public class RestController{

  @Autowired
  private QueryEndpoint index;

  @Autowired
  private DataSource dataSource;


  public void setDataSource(DataSource dataSourceIn){
    this.dataSource = dataSourceIn;
  }

  @RequestMapping("/")
  String indexEndpoint(@RequestHeader Map<String, String> headers)throws Exception{
    return index.getResponse("getBody", headers );
  }








}
