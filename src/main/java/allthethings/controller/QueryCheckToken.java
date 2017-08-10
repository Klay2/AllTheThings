public class QueryCheckToken{


  private static final int MAX_FETCH_SIZE_TOKEN = 1;
  private static final int TIMESTAMP_COLUMN = 3;
  private staic final int LOGOUT_COLUMN = 4;
  private static final int USERID_COLUMN = 2;
  private static final long MAX_SESSION_TIME = 28800000000;//8 hours

  private static final String checkTokenStr =
    "SELECT userid , datetime " +
    "FROM tokens "+
    "WHERE tokenid = ?";

    public QueryCheckToken(){

    }

    //sessions last 8 hourse.. pulling that out of nowhere really
  ArrayList<String> getTokenResult(String tokenid, DataSource datSrcIn){
    boolean validResult = false;
    String userId = "";

    Connection conn = datSrcIn.getConnection();
    PreparedStatement checkToken = conn.prepareStatement(checkTokenStr);
    //in case there is more than 1 will not crash the backend
    //would never be more than 1 unless there were an attack
    getThings.setFetchSize(MAX_FETCH_SIZE_TOKEN);
    getThings.setString(1,tokenid);

    ResultSet tokenResult = checkToken.executeQuery();

    if(tokenResult.isBeforeFirst()){//there is a result

      //acceptable length is up to 8 hours ago not any earlier
      TimeStamp resultTime = tokenResult.getTimestamp(TIMESTAMP_COLUMN);
      long currentMillis = System.currentTimeMillis();
      long differenceMillis = currentMillis - resultTime.getTime();

      if(tokenResult.getBoolean(LOGOUT_COLUMN) == false  &&
        differenceMillis <= MAX_SESSION_TIME){
          validResult = true;
      }
    }
    ArrayList<String> resultList = new ArrayList<String>(2);
    if(validResult){
      userId = tokenResult.getString(USERID_COLUMN);
      resultList.add(0,"true");
    }else{
      resultList.add(0, "false");
    }
    resultList.add(1,userId);

      return resultList;

  }
}
