package allthethings.model;

public class StrAttribute extends Attribute{


  private String strData;



  public StrAttribute(User ownerIn, String nameIn, String thingNameIn,
  int typeIn, boolean pubIn, boolean collabIn, String strDatIn){

    super(ownerIn, nameIn, thingNameIn, typeIn, pubIn, collabIn);
    this.strData = strDatIn;

  }


  public String getStrData(){
    return this.strData;
  }

  public void setStrData(String strDatIn){

    this.strData = strDatIn;
  }



}
