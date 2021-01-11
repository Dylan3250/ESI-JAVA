package esi.atl.g54027.td09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBuilders {

    public static void main(String[] args) {
        // Stream with values
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(System.out::println);
        System.out.println();

        // Stream with array
        Stream<Integer> stream2 = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        stream2.forEach(System.out::println);
        System.out.println();

        // Stream with list
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream3 = list.stream();
        stream3.forEach(System.out::println);
        System.out.println();

        // Stream with random values
        Stream<Integer> randomNumbers = Stream
                .generate(() -> (new Random()).nextInt(100));
        randomNumbers.limit(20)
                .forEach(System.out::println);
        System.out.println();

        // Stream convert each char
        IntStream stream4 = "12345_abcdefg".chars();
        stream4.forEach(System.out::println);
        System.out.println();

        // Stream show char with parse
        Stream<String> stream5 = Stream.of("A$B$C".split("\\$"));
        stream5.forEach(System.out::println);
        System.out.println();

        // Stream list with filter
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbersList = stream6.filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.print(evenNumbersList + "\n");

        // Stream array with filter
        Stream<Integer> stream7 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer[] evenNumbersArr = stream7.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(Arrays.toString(evenNumbersArr) + "\n");

        // Stream with filter begin with A
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        memberNames.stream().filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);
        System.out.println();

        // Stream with filter begin with A
        memberNames.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase) // can convert each object with map
                .forEach(System.out::println);
        System.out.println();

        // Stream with filter begin with A sorted
        memberNames.stream().sorted() // here
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();

        // Checks predicate any, all, none
        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A")); // minder one
        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A")); // all
        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A")); // empty
        System.out.println(matchedResult + "\n");

        // Count member with A like first letter
        long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();
        System.out.println(totalMatched + "\n");

        // Reduce the first value
        Optional<String> reduced = memberNames.stream()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        System.out.println();

        // Get the first value
        String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst()
                .get();
        System.out.println(firstMatchedName + "\n");

        // Make parallelStream
        Stream<Integer> stream8 = list.parallelStream();
        Integer[] evenNumbersArr2 = stream8.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(Arrays.toString(evenNumbersArr2));
    }
}
