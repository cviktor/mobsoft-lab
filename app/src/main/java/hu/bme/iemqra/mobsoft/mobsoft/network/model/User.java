package hu.bme.iemqra.mobsoft.mobsoft.network.model;

import java.util.Objects;


import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class User   {
  
  @SerializedName("userName")
  private String userName = null;
  
  @SerializedName("isAdmin")
  private Boolean isAdmin = null;
  
  @SerializedName("session_id")
  private Integer sessionId = null;
  

  
  /**
   * Name of the user.
   **/
  @ApiModelProperty(value = "Name of the user.")
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  
  /**
   * Is the user an admin.
   **/
  @ApiModelProperty(value = "Is the user an admin.")
  public Boolean getIsAdmin() {
    return isAdmin;
  }
  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  
  /**
   * The session of this login.
   **/
  @ApiModelProperty(value = "The session of this login.")
  public Integer getSessionId() {
    return sessionId;
  }
  public void setSessionId(Integer sessionId) {
    this.sessionId = sessionId;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    isAdmin: ").append(toIndentedString(isAdmin)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
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
