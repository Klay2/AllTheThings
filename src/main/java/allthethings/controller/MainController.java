//local packages
package allthethings.controller;
import allthethings.controller.exceptions.*;
import allthethings.controller.queries.*;

//spring stuff
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

//java stuff
import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;
import java.util.ArrayList;


@RestController
public class MainController{

  //@Autowired
//  private QueryEndpoint index;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private QueryCheckToken tokenCheck;


  public void setDataSource(DataSource dataSourceIn){
    this.dataSource = dataSourceIn;
  }

  @RequestMapping("/")
  public String indexEndpoint(@RequestHeader Map<String, String> headers)throws Exception{
    return "index here";
  }



  @RequestMapping(value = "/mythings", method = RequestMethod.GET )
  public StreamingResponseBody mythingsEndpoint(@RequestHeader Map<String, String> headers)throws Exception{
    //TODO: try catches and responses.. need to be thrown up to the controller here..

    if(headers.containsKey("token") == false || headers.get("token") == null ){//guard statment does not have sectoken
      //no security token in headers
      throw new Forbidden403Exception();
    }
    String[] tokenResult = tokenCheck.getTokenResult(headers.get("token"));
    if(tokenResult[0].equals("false")){
        //token not in database
        throw new Forbidden403Exception();
    }
    String userId = tokenResult[1];//get userid from token
    QueryStreamMyThings myThingsQ = new QueryStreamMyThings(this.dataSource , userId);
    return myThingsQ;

  }






}
