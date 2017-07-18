package allthethings;
import allthethings.model.Attribute;
import allthethings.model.DoublAttribute;
import allthethings.model.IntAttribute;
import allthethings.model.StrAttribute;
import allthethings.model.Thing;
import allthethings.model.User;
import allthethings.model.ModelContainer;
import java.util.LinkedList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

public class JacksonTest{

  @Test
public void runTest(){
  ObjectMapper mapper = new ObjectMapper();
  mapper.configure(SerializationFeature.INDENT_OUTPUT, true);


  LinkedList<ModelContainer> thangs = new LinkedList<ModelContainer>();

  User ownerPerson = new User("1337", "failureMan");
  User sharedPerson1 = new User("ACT8", "stinkyface");
  User sharedPerson2 = new User("IBH84N", "facebookperson");
  thangs.add(new ModelContainer(new User("AC849F", "buttface")));
  thangs.add(new ModelContainer(new DoublAttribute(ownerPerson, "moneys", "Big Car",
    2, true, false, 21005.99)));
  thangs.add(new ModelContainer(new Thing("Big Car", ownerPerson,
  new LinkedList<User>(), true, false,
   false, "")));
  LinkedList<User> shared = new LinkedList<User>();
  shared.add(sharedPerson1);
  shared.add(sharedPerson2);
  thangs.add(new ModelContainer(new Thing("kayaking", ownerPerson,
  shared, false, true,
   true, "")));

  String jsonOut = null;
  try{
    jsonOut = mapper.writeValueAsString(thangs);

  }catch(JsonProcessingException e){
    e.printStackTrace();
  }

  System.out.println(jsonOut);

}
}
