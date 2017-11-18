package allthethings.controller;
import java.io.OutputStream;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import java.io.OutputStreamWriter;


//streaming out query(s) for /MyThings endpoint to get all things owned by
//the main user and all attributes owned by the main user
public class QueryStreamMyThings implements StreamingResponseBody{


private String[] thingResult;//only needs to be 1 dimensional, just getting json
private String[] attResult;

QueryStreamMyThings(String[][] thingResultIn, String[][] attResultIn){
  super();
  thingResult = thingResultIn;
  attResult = attResultIn;

}

public void writeTo(OutputStream streamIn) {

  //try catch for the writer? dunno

  out.write("[ ");//openning of array

  //write things
  if(thingResult == null || thingResult.length == 0)
  {
    out.write("null, ");
  }
  else{

    for(int i = 0; i < thingResult.length; i++)
    {
        out.write(thingResult[i]);
        if(i < thingResult.length -1)//while its not the last element
        {
          out.write(", ");
        }
    }
  }

  if(attResult == null || attResult.length == 0)
  {
    out.write("null");
  }
  else{
    for(int i = 0; i < attResult.length; i++)
    {
      out.write(attResult[i]);
      if(i < attResult.length -1)
      {
          out.write(", ");
      }
    }
  }

  out.write(" ]");
  out.close();//includes flush

}




}
