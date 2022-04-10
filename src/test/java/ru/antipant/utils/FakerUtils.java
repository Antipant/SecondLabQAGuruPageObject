package ru.antipant.utils;

import com.github.javafaker.*;

public class FakerUtils {

    public static String getFakerName() {
        Faker faker = new Faker();
        return faker.starTrek().specie();
    }

    public static String getFakerEmail() {
        Faker faker = new Faker();
        String emailDomain = "@qa.guru";
        return faker.pokemon().name() + emailDomain;
    }

    public static String getFakerSurName() {
        Faker faker = new Faker();
        return faker.rickAndMorty().character();
    }

    public static String getFakerAddress() {
        Faker faker = new Faker();
        return faker.funnyName().toString();
    }

}
