package hu.bme.iemqra.mobsoft.mobsoft.network.api;

import hu.bme.iemqra.mobsoft.mobsoft.network.model.User;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserApi {
  
  /**
   * Logs in a user
   * Logs in a user
   * @param userName Username
   * @param password Password
   * @return Call<User>
   */
  
  @POST("login")
  Call<User> loginPost(
    @Query("userName") String userName, @Query("password") String password
  );

  
}
