package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import test_data.RegistrationTestData;

public class StudentRegistrationFormTests extends TestBase {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    RegistrationTestData data = new RegistrationTestData();

    @Test
    void registrationWithAllFieldsTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(data.firstName)
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
                .submitForm()
                .checkModalTitle(data.message)
                .checkAllFieldsResults(data);
    }

    @Test
    void fillRequiredFieldsTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .typeUserPhoneNumber(data.userNumber)
                .submitForm()
                .checkModalTitle(data.message)
                .checkRequiredFieldsResults(data);
    }

    @Test
    void isPhoneNumberValidationTriggered() {
        studentRegistrationPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .submitForm()
                .checkPhoneNumberValidationTrigger();
    }

    @Test
    void isRequiredGenderMissingTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeUserPhoneNumber(data.userNumber)
                .submitForm()
                .checkRequiredParameters();
    }

    @Test
    void emailValidationFailedTest() {
        studentRegistrationPage.openPage()
                .typeFirstName(data.firstName)
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