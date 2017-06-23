package allthethings.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")

public class Thing{
  private String name;
  private String strDat;
  private User owner;
  private List<User> sharedWith;//or collab with
  private boolean shared;//true if shared with anyone or more
  private boolean pub;//true if public
  private boolean collab;//true if collaborative

  //owner cannot be null
  //name cannot be null
  //shared cannot be null
  //pub cannot be null
  //collaborative cannot be null
  //sharedWith CAN be null
  //strDat CAN be null


  //constructor for a shared/collab thing
  public Thing(String nameIn, User ownerIn,
  List<User>sharedWithIn, boolean pubIn, boolean sharedIn,
   boolean collabIn, String strDatIn){
    this.name = nameIn;
    this.strDat = strDatIn;
    this.owner = ownerIn;
    this.sharedWith = sharedWithIn;
    this.shared =sharedIn;
    this.pub = pubIn;
    this.collab = collabIn;
  }
  //for setting possibly null strDat
  public void setStrDat(String strIn){
    this.strDat = strIn;
  }
  //for later setting shareing with full list
  public void setSharedWith(List<User> userListIn,
  boolean sharedIn, boolean collabIn){
    this.sharedWith = userListIn;
    this.shared = sharedIn;
    this.collab = collabIn;
  }

  public String getName(){
    return this.name;
  }

  public String getStrDat(){
    return this.strDat;
  }

  public Owner getOwner(){
    return this.owner;
  }

  public List<User> getSharedList(){
    return this.sharedWith;
  }

  public boolean getPublic(){
    return this.pub;
  }

  public boolean getShared(){
    return this.shared;
  }

  public boolean getCollab(){
    return this.collab;
  }




}
