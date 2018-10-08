package io.swagger.server.api.model;

import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The root of the customer2 type&#39;s schema.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Customer2   {
  
  private String name = null;
  private String category = null;
  private Integer id = null;
  private String region = null;

  public Customer2 () {

  }

  public Customer2 (String name, String category, Integer id, String region) {
    this.name = name;
    this.category = category;
    this.id = id;
    this.region = region;
  }

    
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

    
  @JsonProperty("category")
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }

    
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

    
  @JsonProperty("region")
  public String getRegion() {
    return region;
  }
  public void setRegion(String region) {
    this.region = region;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer2 customer2 = (Customer2) o;
    return Objects.equals(name, customer2.name) &&
        Objects.equals(category, customer2.category) &&
        Objects.equals(id, customer2.id) &&
        Objects.equals(region, customer2.region);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, category, id, region);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer2 {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
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

  public void test() {

  }

}
