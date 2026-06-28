package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static resources.RegistrationTestData.*;

public class StudentRegistrationFormTests extends TestBase {

    @BeforeEach
    void toRegistrationPage() {
        open("/automation-practice-form");
    }

    @Test
    void registrationWithAllFieldsTest() {
        $("[id='firstName']").setValue(firstName);
        $("[id='lastName']").setValue(lastName);
        $("[id='userEmail']").setValue(userRegistrationFormEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("[id='userNumber']").setValue(userNumber);
        $("[id='dateOfBirthInput']").click();
        $("[class='react-datepicker__month-select']").selectOption(monthOfBirth);
        $("[class='react-datepicker__year-select']").selectOption(yearOfBirth);
        $("[class='react-datepicker__month']").$(byText(dayOfBirth)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("[id='hobbiesWrapper']").$(byText(hobbies.get(0))).click();
        $("[id='hobbiesWrapper']").$(byText(hobbies.get(1))).click();
        $("[id='hobbiesWrapper']").$(byText(hobbies.get(2))).click();
        $("input[type='file']").uploadFromClasspath(file);
        $("[id='currentAddress']").setValue(currentAddress);
        $("[id='react-select-3-input']").setValue(state).pressEnter();
        $("[id='react-select-4-input']").setValue(city).pressEnter();
        $("[id='submit']").click();

        $("[id='example-modal-sizes-title-lg']").shouldHave(text(message));
        $("[class='table-responsive']")
                .find(byText("Student Name"))
                .parent()
                .shouldHave(text(firstName + " " + lastName));
        $("[class='table-responsive']")
                .find(byText("Student Email"))
                .parent()
                .shouldHave(text(userRegistrationFormEmail));
        $("[class='table-responsive']")
                .find(byText("Gender"))
                .parent()
                .shouldHave(text(gender));
        $("[class='table-responsive']")
                .find(byText("Mobile"))
                .parent()
                .shouldHave(text(userNumber));
        $("[class='table-responsive']")
                .find(byText("Date of Birth"))
                .parent()
                .shouldHave(text("0" + dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $("[class='table-responsive']")
                .find(byText("Subjects"))
                .parent()
                .shouldHave(text(subject));
        $("[class='table-responsive']")
                .find(byText("Hobbies"))
                .parent()
                .shouldHave(text(hobbies.get(0) + ", " +  hobbies.get(1) + ", " +  hobbies.get(2)));
        $("[class='table-responsive']")
                .find(byText("Picture"))
                .parent()
                .shouldHave(text(file));
        $("[class='table-responsive']")
                .find(byText("Address"))
                .parent()
                .shouldHave(text(currentAddress));
        $("[class='table-responsive']")
                .find(byText("State and City"))
                .parent()
                .shouldHave(text(state + " " + city));

    }

    @Test
    void fillRequiredFieldsTest() {
        $("[id='firstName']").setValue(firstName);
        $("[id='lastName']").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("[id='userNumber']").setValue(userNumber);
        $("[id='submit']").click();

        $("[id='example-modal-sizes-title-lg']").shouldHave(text(message));
        $("[class='table-responsive']")
                .find(byText("Student Name"))
                .parent()
                .shouldHave(text(firstName + " " + lastName));
        $("[class='table-responsive']")
                .find(byText("Gender"))
                .parent()
                .shouldHave(text(gender));
        $("[class='table-responsive']")
                .find(byText("Mobile"))
                .parent()
                .shouldHave(text(userNumber));
    }

    @Test
    void isRequiredPhoneNumberMissingTest() {
        $("[id='firstName']").setValue(firstName);
        $("[id='lastName']").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("[id='submit']").click();

        $("input[id='userNumber']")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void isRequiredGenderMissingTest() {
        $("[id='firstName']").setValue(firstName);
        $("[id='lastName']").setValue(lastName);
        $("[id='userNumber']").setValue(userNumber);
        $("[id='submit']").click();

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }

    @Test
    void emailValidationFailedTest() {
        $("[id='firstName']").setValue(firstName);
        $("[id='lastName']").setValue(lastName);
        $("[id='userEmail']").setValue(invalidRegistrationFormEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("[id='userNumber']").setValue(userNumber);
        $("[id='dateOfBirthInput']").click();
        $("[class='react-datepicker__month-select']").selectOption(monthOfBirth);
        $("[class='react-datepicker__year-select']").selectOption(yearOfBirth);
        $("[aria-label='Choose Saturday, February 3rd, 1996']").click();
        $("[class='subjects-auto-complete__control css-13cymwt-control']").click();
        $("[class='subjects-auto-complete__input']").setValue(subject).pressEnter();
        $("[id='hobbiesWrapper']").$(byText(hobbies.get(0))).click();
        $("[id='hobbiesWrapper']").$(byText(hobbies.get(1))).click();
        $("[id='hobbiesWrapper']").$(byText(hobbies.get(2))).click();
        $("input[type='file']").uploadFromClasspath(file);
        $("[id='currentAddress']").setValue(currentAddress);
        $("[id='react-select-3-input']").setValue(state).pressEnter();
        $("[id='react-select-4-input']").setValue(city).pressEnter();
        $("[id='submit']").click();

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }

    @Test
    void tryRegisterWithEmptyFieldsTest() {
        $("[id='submit']").click();

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }
}