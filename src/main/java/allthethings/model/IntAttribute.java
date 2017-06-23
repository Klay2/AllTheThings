package allthethings.model;

public class IntAttribute extends Attribute{


  private int intData;



  public IntAttribute(User ownerIn, String nameIn, String thingNameIn,
  int typeIn, boolean pubIn, boolean collabIn, int intDatIn){



    super(ownerIn, nameIn, thingNameIn, typeIn, pubIn collabIn);
    this.intData = intDatIn;

  }


  public int getIntData(){
    return this.intData;
  }

  public setIntData(int datIn){
    this.intData = datIn;
  }



}
