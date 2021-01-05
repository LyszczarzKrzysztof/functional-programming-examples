package com.example.functionalprogrammingexamples;

import org.junit.jupiter.api.Test;

public class FunctionalProgrammingThreadTest {
    //
    @Test
    public void classicThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });
        thread.start();
    }

    //todo functional programming - done

    /**
     * jedna linijka kodu - bez klamer
     * */
    @Test
    public void functional1Thread() {
        Thread thread = new Thread(() -> System.out.println("Hello"));
        thread.start();
    }

    /**
     * wiecej niz jedna linijka kodu - z klamrami
     * */
    @Test
    public void functional2Thread() {
        Thread thread = new Thread(() -> {
            System.out.println("Hello");
            System.out.println("Hello");
        });
        thread.start();
    }
}
