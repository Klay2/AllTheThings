package allthethings.model;

public class DoublAttribute extends Attribute{


  private Double doublData;



  public DoublAttribute(User ownerIn, String nameIn, String thingNameIn,
  int typeIn, boolean pubIn, boolean collabIn, Double doublDatIn){

    super(ownerIn, nameIn, thingNameIn, typeIn, pubIn, collabIn);
    this.doublData = doublDatIn;

  }


  public Double getDoublData(){
    return this.doublData;
  }

  public void setDoublData(Double datIn){

    this.doublData = datIn;
  }



}