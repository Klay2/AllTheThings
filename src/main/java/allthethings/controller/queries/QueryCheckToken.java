package allthethings.controller.queries;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
import javax.sql.*;


//handles the jdbc api layer query to get a token result
//there is only 1 result so it returns 1 row which is a string[]
public class QueryCheckToken{


  private static final int MAX_FETCH_SIZE_TOKEN = 1;
  private static final int TIMESTAMP_COLUMN = 3;
  private static final int LOGOUT_COLUMN = 4;
  private static final int USERID_COLUMN = 2;
  private static final long MAX_SESSION_TIME = 28800000000L;//8 hours arbitrary
  private static final int RESULT_SIZE = 3;//userid timestamp isLoggedOut/ add more?

  private static final String checkTokenStr =
    "SELECT userid , datetime " +
    "FROM tokens "+
    "WHERE tokenid = ?";

  private DataSource datSrc;



  public QueryCheckToken(DataSource datSrcIn){
      this.datSrc = datSrcIn;
  }

// need userid, timestamp, boolean isLoggedOut.. maybe more later like facebook token
public LinkedList<String[]> getTokenResult(String tokenid) throws SQLException{


    String[] resultRow;
    LinkedList<String[]> resultList = new LinkedList<String[]>;
    Connection conn = datSrc.getConnection();
    PreparedStatement checkToken = conn.prepareStatement(checkTokenStr);

    checkToken.setString(1,tokenid);

    ResultSet tokenResult = checkToken.executeQuery();
    if(!tokenResult.isBeforeFirst())//no results
    {
      resultRow = new String[RESULT_SIZE];
      resultRow[0] = "";
      resultRow[1] = "invalid";
      resultRow[2] = "";
      resultList.addLast(resultRow);
    }
    else//results
    {
      while(tokenResult.next())
      {
        resultRow = new String[RESULT_SIZE];
        resultList[0] = tokenResult.getString(USERID_COLUMN);
        resultList[1] = tokenResult.getTimestamp(TIMESTAMP_COLUMN).toString();
        resultList[2] = tokenResult.getBoolean(LOGOUT_COLUMN).toString();
        resultList.addLast(resultRow);

      }

    }


      return resultList;

  }
}
