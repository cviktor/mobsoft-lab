package hu.bme.iemqra.mobsoft.mobsoft.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Food   {
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("details")
  private String details = null;
  
  @SerializedName("allergens")
  private List<Allergene> allergens = new ArrayList<Allergene>();
  
  @SerializedName("ingredients")
  private List<String> ingredients = new ArrayList<String>();
  
  @SerializedName("id")
  private Integer id = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getDetails() {
    return details;
  }
  public void setDetails(String details) {
    this.details = details;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<Allergene> getAllergens() {
    return allergens;
  }
  public void setAllergens(List<Allergene> allergens) {
    this.allergens = allergens;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<String> getIngredients() {
    return ingredients;
  }
  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Food {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    allergens: ").append(toIndentedString(allergens)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
