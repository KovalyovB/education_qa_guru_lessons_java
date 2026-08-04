package test_data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class SimpleTextBoxTestData {
    private final Faker fakerRu = new Faker(new Locale("ru"));

    public String fullName = fakerRu.name().fullName();
    public static String invalidTextBoxEmail = "myemail123";
}