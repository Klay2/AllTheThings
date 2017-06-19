package allthethings.model;

public class Attribute{//declare this as abstract, there are no base
  //attributes

  private String name;
  private User owner;
  private String parentThingName;
  //for type: 0 is unset shouldnt happen, 1 is int, 2 is double, 3 is String
  //and 4 is boolean, 5 if/when implemented can be date .. date seperate?
  private int type;
  private boolean pub;//public
  private boolean collab;//collaborative



  //constructor if nameIn or thingNameIn is null or "" exception is thrown
  //if typeIn does not fit type exception is thrown, enforces rules on creation
  //int type constructor
  public Attribute(User ownerIn, String nameIn, String thingNameIn, int typeIn,
    boolean pubIn, boolean collabIn)throws Exception{
      //guard statements
      if(ownerIn == null){
        throw new Exception e("null owner Attribute Creation");
      }
      if(nameIn == null || nameIn.length() <1){
        throw new Exception e("null or empty name Attribute Creation");
      }
      if(thingNameIn == null || thingNameIn.length() < 1){
        throw new Exception e("null or empty thingName Attribute Creation");
      }
      if(typeIn < 1 || typeIn > 4){
        throw new Exception e("incorrect type range Attribute Creation");
      }

      this.name = nameIn;
      this.owner = ownerIn;
      this.parentThingName = thingNameIn;
      this.type = typeIn;
      this.pub = pubIn;
      this.collab = collabIn;

  }

  public String getAttName(){
    return this.name;
  }

  public Owner getAttOwner(){
    return this.owner;
  }

  public String getThingName(){
    return this.parentThingName;
  }

  public int getType(){
    return this.type;
  }

  public boolean getPublic(){
    return this.pub;
  }

  public boolean getCollab(){
    return this.collab;
  }

  public setPublic(boolean pubIn){
    this.pub = pubIn;
  }

  public setCollab(boolean collabIn){
    this.collab = collabIn;
  }






}
