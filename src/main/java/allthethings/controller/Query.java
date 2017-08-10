package allthethings.controller;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

//class for handling a query and outputting some result
//result is an array list of rows
//rows are implemented either as lists or arrays of data containers
//dependent upon DataSource
//only class that touches jdbc api
public class Query{

  private DataSource datSrc;

  Query(DataSource datSrcIn){
    this.datSrc = datSrcIn;
  }

  //method that takes an array list of strings for parameters
  //to use with PreparedStatement
  //returns a list of result rows
  //each row is an arraylist of Field Containers
  ArrayList<ArrayList<String>> getQueryResult(ArrayList<String> params){
      return null;

  }

  protected DataSource getDataSource(){
    return this.datSrc;
  }



}
