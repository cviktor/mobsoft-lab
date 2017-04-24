package hu.bme.iemqra.mobsoft.mobsoft.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Allergene   {
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("isAllergic")
  private Boolean isAllergic = null;
  

  
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
  public Boolean getIsAllergic() {
    return isAllergic;
  }
  public void setIsAllergic(Boolean isAllergic) {
    this.isAllergic = isAllergic;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Allergene {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isAllergic: ").append(toIndentedString(isAllergic)).append("\n");
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
