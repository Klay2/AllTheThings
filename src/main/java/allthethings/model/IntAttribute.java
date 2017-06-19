public class IntAttribute extends Attribute{


  private int intData;



  public IntAttribute(User ownerIn, String nameIn, String thingNameIn,
  int typeIn, boolean pubIn, boolean collabIn, int intDatIn)throws Exception){

    if(intDatIn < 0){throw new Exception e("invalid intData attribute" +
      " creation");}
    if(typeIn != 1){throw new Exception e("invalid type intData attribute" +
        " creation");}

    super(ownerIn, nameIn, thingNameIn, typeIn, pubIn collabIn);
    this.intData = intDatIn;

  }


  public int getIntData(){
    return this.intData;
  }

  public setIntData(int datIn)throws Exception{
    if(datIn <0){throw new Exception e("invalid int data setInt attribute");}
    this.intData = datIn;
  }



}
