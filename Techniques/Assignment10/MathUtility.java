package Assignment10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class MathUtility {

    public static <T> T processAndReduce(List<T> items, UnaryOperator<T> transformer, BinaryOperator<T> reducer) {

        return items.stream()
                .map(s -> transformer.apply(s))
                .reduce(reducer)
                .orElse(null);

    }

    // demo
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(1);
        numbers.add(8);
        numbers.add(6);
        numbers.add(9);

        UnaryOperator<Integer> UO = s -> {
            return s * 2;
        };

        BinaryOperator<Integer> BO = (s1, s2) -> {
            return s1 + s2;
        };

        System.out.println(MathUtility.processAndReduce(numbers, UO, BO));

    }

}
