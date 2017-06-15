
//endpoint that doesn't do any database Queries
public  class StaticEndpoint extends Endpoint{

  //response to return may be multiple responses
  Endpoint(){

  }

  public String getResponse(String body, Map<String, String> headers){
    //pump stuff into query object
    //get results and return string result
    return "staticEndpoint";

  }



}
