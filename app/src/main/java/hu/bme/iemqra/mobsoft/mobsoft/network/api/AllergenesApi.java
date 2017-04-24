package hu.bme.iemqra.mobsoft.mobsoft.network.api;

import hu.bme.iemqra.mobsoft.mobsoft.network.model.Allergene;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AllergenesApi {
  
  /**
   * The list of the allergenes for the user
   * The allergene settins for the current user.
   * @param sessionId Session id
   * @return Call<List<Allergene>>
   */
  
  @GET("allergenes")
  Call<List<Allergene>> allergenesGet(
    @Query("sessionId") String sessionId
  );

  
  /**
   * Updates the allergene list
   * Updates the allergene settins for the current user.
   * @param sessionId Session id
   * @param allergenes An array of Allergenes
   * @return Call<List<Allergene>>
   */
  
  @POST("allergenes")
  Call<List<Allergene>> allergenesPost(
    @Query("sessionId") String sessionId, @Body List<Allergene> allergenes
  );

  
}
