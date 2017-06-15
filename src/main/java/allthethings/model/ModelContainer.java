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

  public ModelContainer(Thing thingIn){
    this.thingDat = thingIn;
    this.hasThing = true;
    this.hasAtt = false;
    this.hasUser = false;
  }

  public ModelContainer(Attribute attIn){
    this.attDat = attIn;
    this.hasAtt = true;
    this.hasUser = false;
    this.hasThing = false;
  }

  public ModelContainer(User userIn){
    this.userDat = userIn;
    this.hasUser = true;
    this.hasThing = false;
    this.hasAtt = false;
  }

  public boolean getHasAtt(){
    return this.hasAtt;
  }

  public boolean getHasThing(){
    return this.hasThing;
  }

  public boolean getHasUser(){
    return this.hasUser;
  }

  public Attribute getAttribute(){
    return this.attDat;
  }

  public Thing getThing(){
    return this.thingDat;
  }

  public User getUser(){
    return this.userDat;
  }



}
