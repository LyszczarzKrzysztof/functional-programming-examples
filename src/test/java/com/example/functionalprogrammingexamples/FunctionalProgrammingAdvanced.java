package com.example.functionalprogrammingexamples;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionalProgrammingAdvanced {

    @Test
    public void mapExample() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia");
        names.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

    /**
     * sortowanie - tylko cos na szaro w przykladzie 2 jest komparator
     */

    @Test
    public void limitAndSort() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia", "Jozia");
        List<String> collect = names.stream()
                .filter(s -> s.length() > 2)
                .limit(7)
                .map(String::toUpperCase)
                .sorted((o1, o2) -> o1.length() - o2.length())
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * sortowanie - tylko cos na szaro w przykladzie 2 jest komparator
     */

    @Test
    public void limitAndSort2() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia", "Jozia");
        List<String> collect = names.stream()
                .filter(s -> s.length() > 2)
                .limit(7)
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * przyklad joining - laczy wszystkie stringi w jeden - mozna dodac separator
     */

    @Test
    public void limitAndSort3() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia", "Jozia");
        String collect = names.stream()
                .filter(s -> s.length() > 2)
                .limit(7)
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }

    @Test
    public void statistics() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalInt optionalInt = numbers.stream()
                .mapToInt(x -> x)
                .min();

        System.out.println(optionalInt.getAsInt());

        System.out.println("-----------------------------");

        OptionalInt optionalInt2 = numbers.stream()
                .mapToInt(x -> x)
                .max();

        System.out.println(optionalInt2.getAsInt());

        System.out.println("-----------------------------");

        IntSummaryStatistics intSummaryStatistics = numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics();

        System.out.println(intSummaryStatistics);
    }
}
