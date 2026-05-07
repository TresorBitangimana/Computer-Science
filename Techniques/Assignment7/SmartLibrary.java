package Assignment7;


import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class SmartLibrary {
    

    public static void main(String[] args) {
        
        Book book1 = new Book("It", "Stephen King", 10, 1138, true);
        Book book2 = new Book("Emma", "June Austen", 25, 474, true);
        Book book3 = new Book("Dracula","Bram Stoker", 15, 418, false);
        Book book4 = new Book("Frankenstein", "Mary Shelly", 12, 280, false);
        Book book5 = new Book("Sula", "Toni Morrison", 22, 174, true);

        //3.1
        Predicate<Book> isAffordable = book -> book.getPrice() < 20; 
        System.out.println(isAffordable.test(book2));

        Predicate<Book> isLongBook = book ->{
            if(book.getPages() > 500){
                return true;
            }
            return false;
        };
        System.out.println(isLongBook.test(book4));

        //3.2
        BiPredicate<Book,Integer>  fitsBudget = (book, budget) ->{
            if(book.getPrice() < budget){
                return true;
            }
            return false;
        };
        System.out.println(fitsBudget.test(book1, 15));

        //3.3
        Consumer<Book> printInfo = book ->{
            System.out.println("Title: "+book.getTitle()+
                                "\nAuthor: "+book.getAuthor()+
                                "\nPrice: "+book.getPrice()+
                                "\nPages: "+book.getPages()+
                                "\nDigital: "+ book.isDigital());
        };
        printInfo.accept(book5);

        //3.4
        BiConsumer<Book, Double> applyDiscount = (book, discountRate) ->{
            double price = book.getPrice();
            double discountedPrice = price * (discountRate / 100);
            System.out.println("Discounted price: "+discountedPrice);
        };

        applyDiscount.accept(book1, 50.0);

        //3.5
        Supplier<Book> defaultBook = () ->{
            return new Book("Title", "Author", 0, 0, false);
        };

        System.out.println(defaultBook.get());

        //3.6
        Function<Book, String> getTitle = book ->{
            return book.getTitle();
        };

        System.out.println(getTitle.apply(book2));

        //3.6 MR
        Function<Book, String> getTitleMR = Book::getTitle;
        System.out.println(getTitleMR.apply(book5));

        Function<Book, String> authorName = book ->{
            return book.getAuthor();
        };

        System.out.println(authorName.apply(book4));

        //MR
        Function<Book, String> authorNameMR = Book::getAuthor;
        System.out.println(authorNameMR.apply(book4));


        //3.7
        BiFunction<Book, Double, Double> calcTax = (book, tax) ->{
            return book.getPrice() * (book.getPrice() * tax);
        };

        System.out.println(calcTax.apply(book2, 2.5));

        //3.8
        UnaryOperator<Book> capitalize = book ->{
            return new Book(book.getTitle().toUpperCase(), book.getAuthor(),book.getPrice(), book.getPages(),book.isDigital());
        };
        System.out.println(capitalize.apply(book3));

        UnaryOperator<Book> applyNewEditionMarkup = book ->{

            String newTitle = book.getTitle().concat(" (2nd Edition)");
            Double newPrice = book.getPrice()* (1.1); 
            return new Book(newTitle, book.getAuthor(),newPrice, book.getPages(),book.isDigital());
        };

        System.out.println(applyNewEditionMarkup.apply(book1));

        UnaryOperator<Book> discountBook = book ->{
            return new Book(book, 10);
        };

        System.out.println(discountBook.apply(book1));

        //3.9
        IntPredicate isThickBook = pages -> {
            if (pages > 600){
                return true;
            }
            return false;
        } ;

        System.out.println(isThickBook.test(book1.getPages()));

        ToDoubleFunction<Book> getPriceRaw = book ->{
            return book.getPrice();
        };

        System.out.println(getPriceRaw.applyAsDouble(book3));

        //MR
        ToDoubleFunction<Book> getPriceRawMR = Book::getPrice;
        System.out.println(getPriceRawMR.applyAsDouble(book3));


    }
}
