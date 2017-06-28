package allthethings.controller;

import java.util.Map;
//endpoint controller that uses a database Query
//may end up using multiple queries at some point..
public class QueryEndpoint  {

  //possibly extend to list of queries
  private Query query;

  public QueryEndpoint(Query queryIn){
    this.query = queryIn;
  }

  public String getResponse(String body, Map<String, String> headers)throws Exception{
    //pump stuff into query object
    //get results and return string result
    return "queryEndpoint";

  }

  protected Query getQuery(){
    return this.query;
  }
}
