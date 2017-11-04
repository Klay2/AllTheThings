package allthethings.mockcontroller;

import allthethings.controller.queries.QueryCheckToken;
import javax.sql.DataSource;


//mock checktoken returns valid with '6666' as userid
public class MockCheckToken extends QueryCheckToken{

  public MockCheckToken(DataSource datSrcIn){
    super(datSrcIn);
  }

  public String[] getTokenResult(String tokenid, DataSource datSrcIn){
    String[] result = new String[2];
    result[0] = "true";
    result[1] = "6666";
    return result;
  }

}
