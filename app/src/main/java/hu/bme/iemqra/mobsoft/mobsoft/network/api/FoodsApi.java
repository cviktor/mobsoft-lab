package hu.bme.iemqra.mobsoft.mobsoft.network.api;



import hu.bme.iemqra.mobsoft.mobsoft.network.model.Food;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FoodsApi {
  
  /**
   * The list of the food on the menu
   * Every food that is currently available in the restaurant.
   * @return Call<List<Food>>
   */
  
  @GET("food")
  Call<List<Food>> foodGet();
    

  
  /**
   * Details of a selected food
   * Gives back the detailed data for a selected food
   * @param id Id of the food
   * @return Call<Food>
   */
  
  @GET("food/{id}")
  Call<Food> foodIdGet(
    @Path("id") BigDecimal id
  );

  
  /**
   * Create or update food
   * Create or updates a food details in the database
   * @param id Id of the food
   * @param food The food
   * @return Call<Food>
   */
  
  @POST("food/{id}")
  Call<Food> foodIdPost(
    @Path("id") BigDecimal id, @Body Food food
  );

  
}
