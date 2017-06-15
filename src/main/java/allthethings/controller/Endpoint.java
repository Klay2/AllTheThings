
//class for endpoint logic
//extends into staticEndpoint and queryEndpoint
public class Endpoint{

  //logic for and endpoint returns a string so
  //Any logic for converting objects to json
  //should be done in here also.  Moves as much work
  //outside of Spring as possible.
  //may depend on a query controller
  public String getResponse(String body, Map<String, String> headers){
    return "superclass";

  }

}
