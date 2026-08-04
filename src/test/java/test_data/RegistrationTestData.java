package test_data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Map;

public class RegistrationTestData {
    private final Faker fakerEn = new Faker(new Locale("en"));

    public String firstName = fakerEn.name().firstName();
    public String lastName = fakerEn.name().lastName();
    public String userRegistrationFormEmail = fakerEn.internet().emailAddress();
    public String gender = fakerEn.options().option("Male", "Female", "Other");
    public String userNumber = fakerEn.numerify("##########");
    public String monthOfBirth = fakerEn.options()
            .option(
                    "January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October",
                    "November", "December");
    public String yearOfBirth = String.valueOf(fakerEn.random().nextInt(1980, 2026));
    public String dayOfBirth = String.valueOf(fakerEn.random().nextInt(1, 28));
    public String subject = fakerEn.options()
            .option(
                    "English", "Chemistry", "Computer Science", "Commerce",
                    "Social Studies", "Economics");
    public String hobbies = fakerEn.options().option("Sports", "Reading", "Music");
    public String currentAddress = fakerEn.address().fullAddress();
    public String state = fakerEn.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = randomCity(state);
    public String invalidRegistrationFormEmail = "111";
    public String file = "krolik.jpg";
    public String message = "Thanks for submitting the form";

    private static final Map<String, String[]> CITIES = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    private String randomCity(String state) {

        return fakerEn.options().option(CITIES.get(state));
    }
}