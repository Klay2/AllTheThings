package allthethings.model;


public class User{

  private String userID;
  private String userName;
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
