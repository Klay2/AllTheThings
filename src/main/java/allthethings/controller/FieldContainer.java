package allthethings.controller;

//class for holding the value of a field for a database result
//each result will be an arrayList of these
//this allows any query handler to take in just a map of strings
//for its query parameters
//and output an array of these.. this makes any query handler easy to mock
//a mock query handler doesnt have to touch any jdbc api
//also each endpoint controller doesnt have to touch any jdbc api
class FieldContainer{

  private String strDat;
  private boolean boolDat;

  FieldContainer(){
    this.strDat = null;
    this.boolDat = false;
  }

  void setStrDat(String strIn){
    this.strDat = strIn;
  }

  void setBoolDat(boolean boolIn){
    this.boolDat = boolIn;
  }

  String getStrDat(){
    return strDat;
  }

  boolean getBoolDat(){
    return boolDat;
  }



}
