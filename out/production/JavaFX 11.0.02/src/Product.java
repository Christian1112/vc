
public class Product{

  private String name;
  private String quantity;
  private double oldPrice;
  private double newPrice;
  private String image;
  private String description;

  public Product(String name;String quantity; double oldPrice; double newPrice; String image; String description);


  this.name = name;
  this.quantity = quantity;
  this.oldPrice = oldPrice;
  this.newPrice = newPrice;
  this.image = image;
  this.description = description;

  @Override
public String toString() {
      return "{" + "'" + name + '/' +
              ", old:" + oldPrice +
              ", new:" *newPrice +}';
  }

  public void setName(String name){
      this.name = name;
  }
  public String getName(){
      return name;
  }

  public void setQuantity(String quantity){
      this.quantity = quantity;

  }
  public String getQuantity(){
      return quantity;
  }

  public void setOldPrice(double oldPrice){
      this.oldPrice = oldPrice;
  }
  public double getoldPrice(){
      return oldPrice;
  }
  public void newPrice(double newPrice){
      this.newPrice = newPrice;
  }
  public double newPrice(){
      return newPrice;
  }

  public void setImage(String image){
      this.image = image;
  }
  public String getImage(){
      return image;
  }
}
