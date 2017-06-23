package allthethings.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")

@JsonSubTypes({
  @Type(value = DoublAttribute.class),
  @Type(value = IntAttribute.class),
  @Type(value = StrAttribute.class),
})

public abstract class Attribute{//declare this as abstract, there are no base
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
    boolean pubIn, boolean collabIn){

      this.owner = ownerIn;
      this.name = nameIn;
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
