class Main {

  public static void main(String[] args) {
    // Create BookSeller instance and print details
    BookSeller shop = new BookSeller("Books 'r' Us", 100.0);
    System.out.println(
        "Starting balance for " + shop.getShopName() + " is $" + shop.getCashBalance());
    System.out.println();

    // Create a few Book instances
    Book hp1 =
        new Book("Harry Potter Philosopher Stone", "J. K. Rowling", 1997, 10.50, 29.95); // ID: 0
    Book hp2a =
        new Book("Harry Potter Chamber Secrets", "J. K. Rowling", 1998, 11.50, 31.95); // ID: 1
    Book hp2b =
        new Book("Harry Potter Chamber Secrets", "J. K. Rowling", 1998, 9.50, 31.95); // ID: 2
    Book phil = new Book("Philosophy 101", "Paul Kleinman", 2013, 8.75, 15.99); // ID: 3

    // System.out.println(hp1.toString());
    // System.out.println(phil.toString());

    shop.purchaseStock(phil);
	shop.purchaseStock(hp1);
	shop.purchaseStock(hp2a);
    shop.purchaseStock(hp2b);
	

    System.out.println(
        "Balance for "
            + shop.getShopName()
            + " after buying first book is $"
            + shop.getCashBalance());

    System.out.println("Total number of books in stock: " + shop.getTotalNumberOfBooks());
    
 // Scan a barcode to find a Book 
      Book result = shop.scanByID(3);
      if (result != null) { 
         System.out.println("Search by ID found: " + result);
      } else {
         System.out.println("Search by ID didn't find anything.");
      }
      // Reduce the selling prices of these books
    //   System.out.println(phil.getTitle()+" 's price is $ "+phil.getSellingPrice());
    //   System.out.println(hp2a.getTitle()+" 's price is $ "+hp2a.getSellingPrice());
      phil.reduceSellPrice(1.1);
      hp2a.reduceSellPrice(50);
    //   System.out.println(phil.getTitle()+" 's price now change to "+phil.getSellingPrice());
    //   System.out.println(hp2a.getTitle()+" 's price now change to "+hp2a.getSellingPrice());
      
    // Try to sell a Book
    boolean success = shop.sellBook(3);
    Book Check = shop.scanByID(3);
    if (success) {
       System.out.println("Sold book: " + Check);
    } else {
       System.out.println("Could not sell: " + Check);
    }
    System.out.println();
    System.out.println("The cash balance after the sell is $ "+ shop.getCashBalance());
    shop.printInventoryDetails();
    System.out.println("The number of unsold books is "+shop.getTotalNumberOfUnsoldBooks());
      
    // Search for a Book that contains the specified keyword
    result = shop.searchKeyword("SeCReTs");
    if (result != null) {
        System.out.println("Search by keyword found: " + result); 
        int num = shop.sellAllCopiesOfBook(result);
    System.out.println("Sold " + num + " copies.");
    } else {
        System.out.println("Could not find something with that keyword." );

    System.out.println("At the end of the day, balance is $" + shop.getCashBalance());
    }
  }
}


