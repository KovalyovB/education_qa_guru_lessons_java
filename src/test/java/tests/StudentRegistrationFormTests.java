package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import test_data.RegistrationTestData;

import static io.qameta.allure.Allure.step;

@Story("Student registration form")
public class StudentRegistrationFormTests extends TestBase {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    RegistrationTestData data = new RegistrationTestData();

    @Test
    @DisplayName("Registration with all fields test")
    void registrationWithAllFieldsTest() {
        step("Открывается страница регистрации", () -> {
            studentRegistrationPage.openPage();
        });
        step("Заполнение формы регистрации", () -> {
            studentRegistrationPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .typeUserEmail(data.userRegistrationFormEmail)
                    .setGender(data.gender)
                    .typeUserPhoneNumber(data.userNumber)
                    .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                    .setSubjects(data.subject)
                    .setHobbies(data.hobbies)
                    .uploadFile(data.file)
                    .typeUserAddress(data.currentAddress)
                    .setState(data.state)
                    .setCity(data.city)
                    .submitForm();
        });
        step("Проверки заполнения формы регистрации", () -> {
            studentRegistrationPage.checkModalTitle(data.message)
                    .checkAllFieldsResults(data);
        });
    }

    @Test
    @DisplayName("Fill required fields test")
    void fillRequiredFieldsTest() {
        step("Открывается страница регистрации", () -> {
            studentRegistrationPage.openPage();
        });
        step("Заполнение обязательных полей на форме регистрации", () -> {
            studentRegistrationPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .setGender(data.gender)
                    .typeUserPhoneNumber(data.userNumber)
                    .submitForm();
        });
        step("Проверки заполнения формы регистрации", () -> {
            studentRegistrationPage.checkModalTitle(data.message)
                    .checkRequiredFieldsResults(data);
        });
    }

    @Test
    @DisplayName("Is phone number validation triggered")
    void isPhoneNumberValidationTriggered() {
        step("Открывается страница регистрации", () -> {
            studentRegistrationPage.openPage();
        });
        step("Заполнение обязательных полей за исключением номера телефона", () -> {
            studentRegistrationPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .setGender(data.gender)
                    .submitForm();
        });
        step("Проверки валидации поля номера телефона", () -> {
            studentRegistrationPage.checkPhoneNumberValidationTrigger();
        });
    }

    @Test
    @DisplayName("Is required gender missing test")
    void isRequiredGenderMissingTest() {
        step("Открывается страница регистрации", () -> {
            studentRegistrationPage.openPage();
        });
        step("Заполнение обязательных полей за исключением пола", () -> {
            studentRegistrationPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .typeUserPhoneNumber(data.userNumber)
                    .submitForm();
        });
        step("Проверки обязательности поля пола", () -> {
            studentRegistrationPage.checkRequiredParameters();
        });
    }

    @Test
    @DisplayName("Email validation failed test")
    void emailValidationFailedTest() {
        step("Открывается страница регистрации", () -> {
            studentRegistrationPage.openPage();
        });
        step("Заполнение полей с некорректным Email", () -> {
            studentRegistrationPage.typeFirstName(data.firstName)
                    .typeLastName(data.lastName)
                    .typeUserEmail(data.invalidRegistrationFormEmail)
                    .setGender(data.gender)
                    .typeUserPhoneNumber(data.userNumber)
                    .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                    .setSubjects(data.subject)
                    .setHobbies(data.hobbies)
                    .setHobbies(data.hobbies)
                    .setHobbies(data.hobbies)
                    .uploadFile(data.file)
                    .typeUserAddress(data.currentAddress)
                    .setState(data.state)
                    .setCity(data.city)
                    .submitForm();
        });
        step("Проверки валидации поля почты", () -> {
            studentRegistrationPage.checkRequiredParameters();
        });
    }

    @Test
    @DisplayName("Try register with empty fields test")
    void tryRegisterWithEmptyFieldsTest() {
        step("Открывается страница регистрации", () -> {
            studentRegistrationPage.openPage();
        });
        step("Попытка регистрации с пустыми полями", () -> {
            studentRegistrationPage.submitForm();
        });
        step("Проверки валидации по обязательным полям", () -> {
            studentRegistrationPage.checkRequiredParameters();
        });
    }
}