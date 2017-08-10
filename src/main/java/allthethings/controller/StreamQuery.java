package allthethings.controller;
import javax.sql.DataSource;
import java.util.Queue;

public class StreamQuery{

  private DataSource datSrc;


  public StreamQuery(DataSource datSrcIn){
    this.datSrc = datSrcIn;
  }

//TODO: consider a que implemnted by linked lists instead better memory
//efficiency and dont need random access of elements

  public void getResponse(OutputStream streamIn, ArrayList<String> paramsIn){

    //TODO:  finish this method that does database query and returns
    //the json from the db writes it to the streamOut



  }

  protected DataSource getDataSource(){
    return this.datSrc;
  }


}
