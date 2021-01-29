package com.base.jdk8.function;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) { 
        /*java.util.function.BiConsumer<Integer, String> consumer = (a, b) -> {
            System.out.println(a + b);
        };
        consumer.accept(5, " Chapters");*/
        BiConsumer<Integer, Integer> addition = (a, b) -> {
            System.out.println(a + b); };
        BiConsumer<Integer, Integer> subtraction = (a, b) -> {
            System.out.println(a - b); };
        // Using andThen()
        addition.andThen(subtraction).accept(10, 6);
    }
}