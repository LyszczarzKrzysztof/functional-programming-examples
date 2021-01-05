package com.example.functionalprogrammingexamples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgrammingAttend {

    /**
     * lazy initialization - przyklad z integerem - poniewaz metoda jest uruchamiana dopiero przy wypisywaniu nie
     * mozna zdublac mnoznika - albo musi byc final i bierze do wywolania metody ten finalny
     * */

    @Test
    public void lambdaExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer integer = 2;
        Integer finalInteger = integer;
        Stream<Integer> integerStream = numbers.stream()
                .map(number -> number * finalInteger);

        integer = 22;

        integerStream
                .forEach(System.out::println);
    }

    /**
     * tutaj trzeba uwazac z lazy initialization - tablica jest finalna ale jej elementy nie musza być finalne
     * metoda wywoluje sie przy wypisaniu wartosci foreach'em i bierze tablice finalna ale z podmieniona wartoscia
     * (ostatnia zmiana przed wywolaniem metody) dlatego trzeba uwazac
     * */

    @Test
    public void lambdaExampleWithTables() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final Integer[] integer = {2};
        Stream<Integer> integerStream = numbers.stream()
                .map(number -> number * integer[0]);

        integer[0] = 22;

        integerStream
                .forEach(System.out::println);
    }

    /**
     * ponizej przyklad - ze programowniem funkcyjnym wykonujemy operacje - tutaj na tablicy integerow
     * ale tablicy nie modyfikujemy - czyli stream wyswietla elementy tablicy pomnozone przez 2
     * zas ponizej sout wyswietla tablice, ktora nawet po wykonaniu sie streame sie nie zmienia - cos chyba chodzi
     * o immutable types w programowaniu funkcyjnym, aby stworzyc nowa liste trzeba uzyc collectora - przyklad lambdaExample3a
     * */

    @Test
    public void lambdaExample3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .map(number -> number*2)
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        System.out.println(numbers);
    }

    @Test
    public void lambdaExample3a() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println("----------------------------------");
        System.out.println(collect);

    }
}
