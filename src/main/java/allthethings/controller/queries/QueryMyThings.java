import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class QueryMyThings{

  private DataSource datSrc;

  //query to get all things from a user that are not collabs
  private String queryStrThings = "SELECT things.json FROM things LEFT OUTER JOIN collabs ON (things.userid = collabs.ownerid AND things.thingname = collabs.thingname) WHERE things.userid = ? AND collabs.sharedid IS NULL";

  //query to get all a user's attributes excluding attributes
  //from collab things.. MAY OR MAY NOT WORK MUST TEST
  private String queryStrAtts = "SELECT attributes.json FROM attributes JOIN (Select things.thingname FROM things LEFT OUTER JOIN collabs ON (things.userid = collabs.ownerid AND things.thingname = collabs.thingname) WHERE things.userid = ? AND collabs.sharedid IS NULL) ON (things.thingname = attributes.thingname) WHERE attributes.userid = ?";

  private static final int MAX_FETCH_SIZE_THINGS = 150;
  private static final int MAX_FETCH_SIZE_ATTRIBUTES = 1200;
  private static final int THING_JSON_COLUMN = 4;
  private static final int ATTRIBUTE_JSON_COLUMN = 4;
  private String userId;

  public QueryMyThings(DataSource datSrcIn){


  }



}
