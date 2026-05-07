/**
 * @Author Tresor Bitangimana
 * @Since Mar 5 2026
 * Book class
 */

package Assignment7;

public class Book {
    
    private String title;      //title field
    private String author;     //authors name field
    private double price;      //price of the book field
    private int pages;         //pages field 
    private boolean isDigital; //isDigital field

    /**
     * Constructor method
     * @param title
     * @param author
     * @param price
     * @param pages
     * @param digital
     */
    public Book(String title, String author, double price, int pages, boolean digital){
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.isDigital = digital;
    }

    /**
     * Copy constructor
     * @param book
     */
    public Book(Book book, double newPrice){
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = newPrice * (0.9);
        this.pages = book.getPages();
        this.isDigital = book.isDigital();
    }

    /**
     * Getter method for the title
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the author
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter method for the price
     * @return The price of the book
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter method for pages
     * @return pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * isDigital method
     * @return true if the book is digital
     *          false if the book is not digital
     */
    public boolean isDigital() {
        return isDigital;
    }

    /**
     * ToString method
     * <p>Prints the formated information of the book<p/>
     */
    @Override
    public String toString() {
        return "Title: "+title+"\nAuthor: "+author+"\nPrice: "+price+"\nPages: "+pages+"\nDigital: "+ isDigital;
    }
}
