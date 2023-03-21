public class Book {

  private String title;
  private String author;
  private int year;
  private double costPrice;
  private double sellingPrice;
  private int id;
  private boolean status;

  private static int whateverTheNextBookIdIs = 0;

  public Book(String title, String author, int year, double costPrice, double sellingPrice) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.costPrice = costPrice;
    this.sellingPrice = sellingPrice;
    this.id = whateverTheNextBookIdIs;
    whateverTheNextBookIdIs++;
    this.status=true;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYear() {
    return year;
  }

  public double getCostPrice() {
    return costPrice;
  }

  public double getSellingPrice() {
    return sellingPrice;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "[BOOK: title ="+ title+", id="+id+"]";
  }

  public double reduceSellPrice(double d) {
    double CurrentPrice=this.sellingPrice-d;
    if(CurrentPrice>0){
      this.sellingPrice=CurrentPrice;
    }else{
      this.sellingPrice=0.0;
    }
    return this.sellingPrice;
  }

  public boolean getStatus(){
    return status;
  }

  public void isSold(boolean s){
    this.status = s;
  }

}
