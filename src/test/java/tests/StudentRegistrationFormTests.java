package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

import static resources.RegistrationTestData.*;

public class StudentRegistrationFormTests extends TestBase {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    void registrationWithAllFieldsTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userRegistrationFormEmail)
                .setGender(gender)
                .typeUserPhoneNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobbies.get(0))
                .setHobbies(hobbies.get(1))
                .setHobbies(hobbies.get(2))
                .uploadFile(file)
                .typeUserAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkModalTitle(message)
                .checkAllFieldsResults();

    }

    @Test
    void fillRequiredFieldsTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserPhoneNumber(userNumber)
                .submitForm()
                .checkModalTitle(message)
                .checkRequiredFieldsResults();
    }

    @Test
    void isPhoneNumberValidationTriggered() {
        studentRegistrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .submitForm()
                .checkPhoneNumberValidationTrigger();
    }

    @Test
    void isRequiredGenderMissingTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserPhoneNumber(userNumber)
                .submitForm()
                .checkRequiredParameters();
    }

    @Test
    void emailValidationFailedTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(invalidRegistrationFormEmail)
                .setGender(gender)
                .typeUserPhoneNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobbies.get(0))
                .setHobbies(hobbies.get(1))
                .setHobbies(hobbies.get(2))
                .uploadFile(file)
                .typeUserAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkRequiredParameters();
    }

    @Test
    void tryRegisterWithEmptyFieldsTest() {
        studentRegistrationPage.openPage()
                .submitForm()
                .checkRequiredParameters();
    }
}