package allthethings.controller;


//streaming out query(s) for /MyThings endpoint to get all things owned by
//the main user and all attributes owned by the main user
public class QueryStreamMyThings extends StreamingResponseBody{



  //hard limit on user to allow performance client side
  //also keeps memory used per request to ~1MB when holding WHOLE result set
  //150things
  //8 atts per thing max
  //things.. like 8 attributes per thing...
  private static final int MAX_FETCH_SIZE_THINGS = 150;
  private static final int MAX_FETCH_SIZE_ATTRIBUTES = 1200;
  //TODO: CHANGE TO COLUMN OF JSON
  private static final int THING_JSON_COLUMN = 4;
  private static final int ATTRIBUTE_JSON_COLUMN = 4;
  private String userId;
  private DataSource datSrc;

  //query to get things.. modify so that it does NOT include collab things
  //max 150 things each with 8 max attributes will keep under 1mb memory
  //per request... IFF results are streamed out and only result set is kept

  //query to get things from the user which are NOT collabs
  private static final String queryStrThings =
    "SELECT things.json FROM things" +
    " LEFT OUTER JOIN collabs" +
    " ON (things.userid = collabs.ownerid" +
    " AND things.thingname = collabs.thingname)" +
    " WHERE things.userid = ?" +
    " AND collabs.sharedid IS NULL";

  //query to get all a user's attributes excluding attributes
  //from collab things.. MAY OR MAY NOT WORK MUST TEST
  private static final String queryStrAtts =
    "SELECT json FROM attributes WHERE" +
    " user = ? AND collab = false";
    "SELECT attributes.json FROM attributes" +
    " LEFT OUTER JOIN collabs" +
    " ON (attributes.thingname = collabs.thingname)" +
    " WHERE attributes.userid = ?" +
    " AND collabs.sharedid IS NULL";




  public QuerySTreamMyThings(DataSource datSrcIn, String userIdIn){
    this.datSrc = datSrcIn;
    this.userId = userIdIn;

  }



  //Writes out a response from the database for things and attributes
  //that are non collaborated owned by the userid given in the
  //array list argument
  //output format is [ THINGS, ATTRIBUTES ]
  //if there is no thing or attribute a null is printed
  //will end up throwing stuff
  public void writeTo(OutputStream streamIn){

    //TODO:
    //needs try catches
    Connection conn = this.datSrc.getConnection();
    PreparedStatement getThings = conn.prepareStatement(queryStrThings);
    //the fetch size has to be based on max allowed at 1 time determined by
    //the client end I think
    getThings.setFetchSize(MAX_FETCH_SIZE_THINGS);
    getThings.setString(1,this.userId);


    ResultSet thingResult = getThings.executeQuery();

    out.write(new String("[ ").toBytes());//openning of array
    if(thingResult.isBeforeFirst() == false){
      //empty
      out.write(new String("null").toBytes());
    }else{
      boolean first = true;//TODO: CONSIDER DO WHILE OR SOMTHING
      while(thingResult.next()){
        if(!first){
          out.write(new String(", ").toBytes());
        }
        out.write(thingResult.getString(THING_JSON_COLUMN).toBytes());
        first = false;
      }
    }
    PreparedStatement getAttributes = conn.prepareStatement(queryStrAtts);
    getAttributes.setFetchSize(MAX_FETCH_SIZE_ATTRIBUTES);
    getAttributes.setString(1,this.userId);
    getAttributes.setString(2,this.userId);

    ResultSet attResult = getAttributes.executeQuery();

    if(attResult.isBeforeFirst() == false){
      out.write(new String(", null").toBytes());
    }else{
      while(attResult.next()){
        out.write(new String(", ").toBytes());
        out.write(attResult.getString(ATTRIBUTE_JSON_COLUMN).toBytes());
      }
    }
    out.write(new String(" ]").toBytes());

    out.flush();

  }
}
