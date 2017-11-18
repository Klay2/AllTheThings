package allthethings.mockcontroller;
import allthethings.controller.queries.QueryStreamMyThings;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.sql.DataSource;


public class MockQueryStreamMyThings extends QueryStreamMyThings{


//can just pass in nulls for data source and any number for userid
  public MockQueryStreamMyThings(DataSource datSrcIn, String userIdIn){
    super(datSrcIn, userIdIn);
  }

  public void writeTo(OutputStream streamIn){

    String thing1 = "{ \"objtype\" : \"thing\", \"userid\" : \"6666\", \"thingname\" : \"sammich\" }";
    String thing2 = "{ \"objtype\" :  \"thing\", \"userid\" : \"6666\", \"thingname\" : \"lasergun\" }";
    String att1Thing1 = "{ \"objtype\" : \"attribute\",\"userid\" : \"6666\", \"attributename\" : \"tastyness\", \"thingname\" : \"sammich\", \"atttype\" : \"int\", \"value\" : \"5\" }";
    String att2Thing1 = "{ \"objtype\" : \"attribute\",\"userid\" : \"6666\", \"attributename\" : \"cost\", \"thingname\" : \"sammich\", \"atttype\" : \"double\", \"value\" : \"7.5\" }";
    String att1Thing2 = "{ \"objtype\" : \"attribute\",\"userid\" : \"6666\", \"attributename\" : \"description\", \"thingname\" : \"lasergun\", \"atttype\" : \"string\", \"value\" : \"a gun that fires a laser\" }";
    String att2Thing2 = "{ \"objtype\" : \"attribute\",\"userid\" : \"6666\", \"attributename\" : \"ammoAmount\", \"thingname\" : \"lasergun\", \"atttype\" : \"int\", \"value\" : \"33\" }";
    String[] deliverables = new String[6];
    deliverables[0] = thing1;
    deliverables[1] = thing2;
    deliverables[2] = att1Thing1;
    deliverables[3] = att2Thing1;
    deliverables[4] = att1Thing2;
    deliverables[5] = att2Thing2;
    try{//try with resources
    OutputStreamWriter out = new OutputStreamWriter(streamIn, "UTF-8");//throws UnsupportedEncodingException
    //exception while writing, attempt to write to stream then close
    out.write("[ \"numthings\": \"2\", \"numattributes\": \"4\", ");//writing can throw IOException
    for(int i = 0; i < 6; i++){// 6 total objects to send
      out.write(deliverables[i]);
      if(i != 5){
        out.write(", ");
      }
    }
    out.write(" ]");
    out.close();
  } catch(Exception e){
    //cant really do anything here
  }
  }

}
