package ru.antipant.utils;

import com.github.javafaker.*;

public class FakerUtils {

    private static final Faker faker = new Faker();

    public static String getFakerName() {
        return faker.starTrek().specie();
    }

    public static String getFakerEmail() {
        String emailDomain = "@qa.guru";
        return faker.pokemon().name() + emailDomain;
    }

    public static String getFakerSurName() {
        return faker.rickAndMorty().character();
    }

    public static String getFakerAddress() {
        return faker.funnyName().toString();
    }

}
