package allthethings.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;


//root "/" endpoint controller method=GET
public class Root extends QueryEndpoint{

  public Root(Query queryIn){
    super(queryIn);
  }

  public String getResponse(String body, Map<String, String> headers) throws Exception{

    if(body == null){throw new Exception("null body argument root endpoint");}
    if(headers == null){throw new Exception("null header map root endpoint");}

    if(!headers.containsKey("wat5")){//does not have a session login/intro
        return "html/home";}

    //TODO: lookup session info in database
    List<ArrayList<FieldContainer>> result;
    ArrayList<String> queryParameters = new ArrayList<String>();
    queryParameters.add(headers.get("wat5"));
    result = super.getQuery().getQueryResult(queryParameters);


  }
}
