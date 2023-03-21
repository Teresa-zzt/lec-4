import java.security.Key;
import java.util.ArrayList;

public class BookSeller {

    private String shopName;
    private double cashBalance;

    private ArrayList<Book> stock = new ArrayList<Book>();

    public BookSeller(String shopName, double initialBalance) {
        this.shopName = shopName;
        this.cashBalance = initialBalance;
    }

    public String getShopName() {
        return shopName;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public int getTotalNumberOfBooks() {
        return stock.size();
    }

    public void purchaseStock(Book book) {
        if (bookIsInStockAlready(book)) {
            System.out.println("Book already in stock, therefore won't add it again.");
        } else {
            stock.add(book);
            cashBalance -= book.getCostPrice();
            System.out.println("Added book to stock: " + book.toString());
        }
    }

    private boolean bookIsInStockAlready(Book bookCheckingToSeeIfItsInTheStockAlready) {
        for (Book bookInTheStock : stock) {
            if (bookInTheStock == bookCheckingToSeeIfItsInTheStockAlready) {
                return true;
            }
        }
        return false;
    }

    public Book scanByID(int id) {
        for(int i=0;i<stock.size();i++){
            Book Checking = stock.get(i);
            if(id == Checking.getId()){
                return Checking;
            }
        }
        return null;
    }

    public boolean sellBook(int id) {
        Book sell = this.scanByID(id);
        if(sell != null && sell.getStatus()){
            sell.isSold(false);
            this.cashBalance=this.cashBalance+sell.getSellingPrice();
            return true;
        }else{        
            return false;
        }
        
    }
    public void printInventoryDetails(){
        for(int i =0; i<stock.size();i++){
            Book PrintOut = stock.get(i);
            if(PrintOut.getStatus()){
                System.out.println(i+": "+ "AVALIABLE  "+ PrintOut.toString());
            }else{
                System.out.println(i+": "+ "***SOLD*** "+PrintOut.toString());
            }
        }
    }

    public int getTotalNumberOfUnsoldBooks(){
        int NumberOfUnsold =0;
        for(int i =0; i<stock.size();i++){
            Book PrintOut = stock.get(i);
            if(PrintOut.getStatus()){
                NumberOfUnsold++;
            }
        }
        return NumberOfUnsold;
    }

    public Book searchKeyword(String string) {
        for(int i =0; i<stock.size();i++){
            Book Checking = stock.get(i);
            String Title=Checking.getTitle().toLowerCase();
            if(Title.contains(string.toLowerCase())){
                return Checking;
                }
            }
        return null;
    }

    public int sellAllCopiesOfBook(Book result) {
        return 0;
    }
}
