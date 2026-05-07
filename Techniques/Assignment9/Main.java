package Assignment9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // 1. Create Custom Collector
        // Question: Create a custom collector to join strings with a delimiter such as
        // a
        // comma with a space (“, ”).
        List<String> words1 = Arrays.asList("Java", "Stream", "API");
        // Output: Java, Stream, API
        String concatetedString = words1.stream()
                .collect(Collectors.joining(", ")); // joins the words with ", "
        System.out.println(concatetedString);

        // 2. Remove Null Values
        // Question: Remove null values from a list using filter.
        List<String> words2 = Arrays.asList("Java", null, "Stream", null, "API");
        // Output: [Java, Stream, API]
        List<String> nonNullWords2 = words2.stream()
                .filter(w -> w != null) // fileter out all words that are not null
                .collect(Collectors.toList());
        System.out.println(nonNullWords2);

        // 3. Calculate Average of Numbers
        // Question: Calculate the average of a list of integers.
        List<Integer> numbers1 = Arrays.asList(10, 20, 30, 40, 50);
        // Output: 30.0
        double numbers1Sum = numbers1.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println(numbers1Sum);

        // 4. Collect Map from List
        // Question: Convert a list of strings into a map with the string as the key and
        // its length as the value
        List<String> words3 = Arrays.asList("Java", "Stream", "API");
        // Output: {Java=4, Stream=6, API=3}
        Map<Integer, List<String>> wordsLengths = words3.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(wordsLengths);

        // 5. Find Nth Largest Element in a List
        // Question: Find the 3rd largest element in a list.
        List<Integer> numbers2 = Arrays.asList(10, 20, 50, 40, 30);
        // Output: 30
        Integer ThirdLargest = numbers2.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(0);
        System.out.println(ThirdLargest);

        // 6. Find All Palindromic Strings
        // Question: Find all strings that are palindromes in a list.
        List<String> words4 = Arrays.asList("radar", "level", "world", "java");
        // Output: [radar, level]
        List<String> palindramicList = words4.stream()
                .filter(w -> w.equals(new StringBuilder(w).reverse().toString()))
                .toList();
        System.out.println(palindramicList);

        // 7. Reverse Each String in a List
        // Question: Reverse each string in a list.
        List<String> words5 = Arrays.asList("Java", "Stream", "API");
        // Output: [avaJ, maertS, IPA]
        List<String> reversedWordList = words5.stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .toList();
        System.out.println(reversedWordList);

        // 8. Filter and Convert Map to List
        // Question: Given a map, filter entries with values greater than 10 and collect
        // keys into a list.
        Map<String, Integer> map1 = Map.of("A", 5, "B", 15, "C", 10, "D", 20);
        // Output: [B, D]
        List<String> keysList = map1.entrySet().stream()
                .filter(entry -> entry.getValue() > 10)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(keysList);

        // 9. Remove Duplicates Without Collectors
        // Question: Remove duplicates from a list using distinct().
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
        // Output: [1, 2, 3, 4, 5]
        List<Integer> nonDupNumbers = numbers3.stream()
                .distinct()
                .toList();
        System.out.println(nonDupNumbers);

        // 10. Find Common Elements Between Two Lists
        // Question: Find common elements between two lists.
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        // Output: [3, 4, 5]
        List<Integer> commonList = list1.stream()
                .filter(s -> list2.contains(s))
                .toList();
        System.out.println(commonList);

        // 11. Find the Sum of Squares of Even Numbers
        // Question: Calculate the sum of squares of all even numbers in a list.
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        // Output: 56 (56 = 2^2 + 4^2 + 6^2)
        Integer sumOfEvenSquare = numbers4.stream()
                .filter(s -> s % 2 == 0)
                .map(s -> s * s)
                .reduce(0, Integer::sum);
        System.out.println(sumOfEvenSquare);

        // 12. Find the Longest Word from a Sentence
        // Question: Find the longest word in a sentence using Streams.
        String sentence = "Java Stream API is very powerful";
        // Output: powerful
        String LongestWord = Arrays.stream(sentence.split(" "))
                .reduce((w1, w2) -> w1.length() >= w2.length() ? w1 : w2)
                .orElse(" ");
        System.out.println(LongestWord);

        // 13. Find Top N Highest Scoring Students
        // Question: From a list of students, find the top 3 by score.
        class Student {
            String name;
            int score;

            Student(String name, int score) {
                this.name = name;
                this.score = score;
            }
        }
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 88),
                new Student("Dave", 78),
                new Student("Eve", 91));
        // Output: [Bob, Eve, Charlie]
        List<String> top3Students = students.stream()
                .sorted((s1, s2) -> Integer.compare(s1.score, s2.score))
                .limit(3)
                .map(s -> s.name)
                .toList();
        System.out.println(top3Students);

        // 14. Group by First Character
        // Question: Group a list of strings by their first character.
        List<String> words6 = Arrays.asList("apple", "banana", "avocado",
                "blueberry",
                "cherry");
        // Output: {a=[apple, avocado], b=[banana, blueberry], c=[cherry]}
        Map<Character, List<String>> groupByChar = words6.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(groupByChar);

        // 15. Custom Reduce to Concatenate Strings
        // Question: Concatenate strings in reverse order using reduce.
        List<String> words7 = Arrays.asList("Stream", "API", "is", "awesome");
        // Output: awesome is API Stream
        String reverseConcatenate = words7.stream()
                .reduce((s1, s2) -> s2 + " " + s1)
                .orElse("");
        System.out.println(reverseConcatenate);

        // 16. Calculate the Product of All Numbers
        // Question: Calculate the product of all numbers in a list using reduce.
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        // Output: 120
        int productsOfAll = numbers5.stream()
                .reduce(1, (s1, s2) -> s1 * s2);
        System.out.println(productsOfAll);

        // 17. Find Non-RepeaUng Characters in a String
        // Question: Find all non-repeating characters in a string.
        String input = "swiss";
        // Output: [w, i]
        List<String> nonRepeat = Arrays.stream(input.split(""))
                .filter(s -> input.indexOf(s) == input.lastIndexOf(s))
                .toList();
        System.out.println(nonRepeat);

        // 18. Find Duplicate Elements in a List
        // Question: Identify all duplicate elements in a list.
        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);
        // Output: [2, 3]
        List<Integer> nonRepeatNums = numbers6.stream()
                .filter(n -> Collections.frequency(numbers6, n) > 1)
                .distinct()
                .toList();
        System.out.println(nonRepeatNums);

        // 19. Convert Map to List of Key-Value Pairs
        // Question: Convert a map to a list of “key=value” strings.
        Map<String, Integer> map2 = Map.of("A", 1, "B", 2, "C", 3);
        // Output: [A=1, B=2, C=3]
        List<String> keyNValueString = map2.entrySet().stream()
                .map(s -> s.getKey() + "=" + s.getValue())
                .toList();
        System.out.println(keyNValueString);

    }
}
