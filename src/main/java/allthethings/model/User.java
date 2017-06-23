package allthethings.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS,
  include = JsonTypeInfo.As.PROPERTY,
  property = "type")

public class User{

  private String userID;//combo of letters and numbers
  private String userName;//userName id from facebook or email or whatever
  //more stuff needed?? idk..

  public User(String idIn, String userNameIn){
    this.userID = idIn;
    this.userName = userNameIn;

  }

  public User(String idIn) {
    this.userID = idIn;
    this.userName = "User";
  }


  public void setID(String idIn) {
    this.userID = idIn;
  }

  public void setUserName(String nameIn) {
    this.userName = nameIn;
  }

  public String getUserName() {
    return this.userName;
  }

  public String getId(){
    return this.userID;
  }


}
