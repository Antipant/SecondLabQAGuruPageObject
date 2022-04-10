package ru.antipant.docs;

public class StringFormatExamples {
    public static void main(String[] args) {
        String name = "username",
                subject = "you";

        System.out.println("Hello, " + name + "! How are " + subject + "?");
        System.out.printf("Hello, %s! How are %s?%n", name, subject);
    }
}
