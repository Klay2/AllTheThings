
//builder for the application can be created and ran outside of the
//Spring framework
// has .build methods for each endpoint and each query
//legit query objects need a datasource
public class AttBuilder{



  AttBuilder(){

  }

  //builds a static testroot endpoint handler
  StaticEndpoint buildTestRoot(){
    return new TestRoot();
  }




}
