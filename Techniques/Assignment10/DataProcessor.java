package Assignment10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DataProcessor<T> {

    public double calculateAvearge(List<T> data, Function<T, Double> valueExtractor) {

        return data.stream()
                .mapToDouble(s -> valueExtractor.apply(s))
                .average()
                .orElse(0);

    }

    // demo
    public static void main(String[] args) {

        ArrayList<Product> list = new ArrayList<>();

        Product product1 = new Product("MacBook", 1000);
        Product product2 = new Product("iphone12", 700);
        Product product3 = new Product("Book", 25);
        Product product4 = new Product("BackPack", 30);
        Product product5 = new Product("Mouse", 50);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);

        DataProcessor<Product> processor = new DataProcessor<>();

        Function<Product, Double> calc = s -> {
            return s.getPrice();
        };

        System.out.println(processor.calculateAvearge(list, calc));
    }

}
