import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public class MyThingsStream extends StreamingResponseBody{

  private StreamQuery query;
  private ArrayList<String> parameters;

  public MyThingsStream(StreamQuery queryIn){
    this.query = queryIn;
  }


  public void writeTo(OutputStream out) throws IOException{
      query.getResponse(out, parameters);
      out.flush();
      try{
        Thread.sleep(5);
      } catch(InterruptedExceptioin e){
        e.printStackTrace();
      }
      return;

  }




}
