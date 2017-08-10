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

  @Autowired
  private QueryCheckToken tokenCheck;


  public void setDataSource(DataSource dataSourceIn){
    this.dataSource = dataSourceIn;
  }

  @RequestMapping("/")
  public String indexEndpoint(@RequestHeader Map<String, String> headers)throws Exception{
    return index.getResponse("getBody", headers );
  }



  @RequestMapping(path = "/mythings", method = RequestMethod.GET )
  public StreamingResponseBody indexEndpoint(@RequestHeader Map<String, String> headers)throws Exception{
    //TODO: try catches and responses

    if(!headers.contains("token") || headers.get("token") == null ){//guard statment does not have sectoken
      //TODO:  error unauthorized do whatever for that
      return null;
    }
    ArrayList<String> tokenResult = tokenCheck.getTokenResult(headers.get("token"), this.dataSource);
    if(tokenResult.get(0).equals("false")){
        //TODO: error unauthorized do whatever
        return null;
    }
    String userId = tokenResult.get(1);
    return new QueryStreamMyThings(this.dataSource , userId);

  }






}
