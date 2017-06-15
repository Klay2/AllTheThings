public class TestRoot extends StaticEndpoint{

  TestRoot(){

  }

  public String getResponse(String body, Map<String, String> headers){
    //pump stuff into query object
    //get results and return string result
    return "testing static root no parameters ";

  }
}
