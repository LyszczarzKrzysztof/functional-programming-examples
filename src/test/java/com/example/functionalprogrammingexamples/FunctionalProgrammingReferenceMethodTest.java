package com.example.functionalprogrammingexamples;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalProgrammingReferenceMethodTest {
    @Test
    public void onsumerFull() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia");

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    @Test
    public void consumerShort() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia");

        names.forEach((String s) -> System.out.println(s));
    }

    @Test
    public void consumerShorter() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia");

        names.forEach((s) -> System.out.println(s));
    }

    @Test
    public void consumerSuperShort() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia");

        names.forEach(s -> System.out.println(s));
    }

    @Test
    public void referenceMethod() {
        List<String> names = Arrays.asList("Przemek", "Dorota", "łukasz", "Karol", "Anna", "Marcysia");

        names.forEach(System.out::println);
    }
}
