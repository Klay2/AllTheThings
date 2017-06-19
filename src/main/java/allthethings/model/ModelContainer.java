package allthethings.model;

//container that holds either an attribute or thing or User
//used so that a json response can include different objects
//keeps calls to the server backend low
public class ModelContainer{

  private Attribute attDat;
  private Thing thingDat;
  private User userDat;

  private boolean hasAtt;
  private boolean hasThing;
  private boolean hasUser;

  //constructor takes a thing and sets the appropriate fields
  public ModelContainer(Thing thingIn){
    this.thingDat = thingIn;
    this.hasThing = true;
    this.hasAtt = false;
    this.hasUser = false;
  }
  //constructor takes an attribute and sets the appropriate
  //fields
  public ModelContainer(Attribute attIn){
    this.attDat = attIn;
    this.hasAtt = true;
    this.hasUser = false;
    this.hasThing = false;
  }
  //constructor takesa User and sets the appropriate fields
  public ModelContainer(User userIn){
    this.userDat = userIn;
    this.hasUser = true;
    this.hasThing = false;
    this.hasAtt = false;
  }
  //returns whether or not this container holds an attribute
  public boolean getHasAtt(){

    return this.hasAtt;
  }
  //returns whether or not this container holds a thing
  public boolean getHasThing(){
    return this.hasThing;
  }
  //returns whether or not this container holds a user
  public boolean getHasUser(){
    return this.hasUser;
  }
  //returns attribute in container throws exception if
  //it doesnt, use if has att before get for ultra
  //safety
  public Attribute getAttribute() throws Exception{
    if(!this.hasAtt){throw new Exception e(
      "tried to get a null Attribute ModelContainer");}
    return this.attDat;
  }
  //returns thing in container throws exception if
  //it doesnt, use if has thing before get for ultra
  //safety
  public Thing getThing() throws Exception{
    if(!this.hasThing){throw new Exception e(
      "tried to get a null Thing ModelContainer"
      );}
    return this.thingDat;
  }
  //returns User in container throws exception if
  //it doesnt, use if has user before get for ultra 
  //safety
  public User getUser() throws Exception{
    if(!this.hasUser){throw new Exception e(
      "tried to get a null User ModelContainer"
      );}
    return this.userDat;
  }



}
