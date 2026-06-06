package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTests extends TestBase {

    @BeforeEach
    void toRegistrationPage() {
        open("/automation-practice-form");
    }

    @Test
    void registrationWithAllFieldsTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='userEmail']").setValue("koryaginant@google.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id='userNumber']").setValue("9948581928");
        $("[id='dateOfBirthInput']").click();
        $("[class='react-datepicker__month-select']").selectOption("February");
        $("[class='react-datepicker__year-select']").selectOption("1996");
        $("[class='react-datepicker__month']").$(byText("3")).click();
        $("#subjectsInput").setValue("Bio").pressEnter();
        $("[id='hobbiesWrapper']").$(byText("Sports")).click();
        $("[id='hobbiesWrapper']").$(byText("Reading")).click();
        $("[id='hobbiesWrapper']").$(byText("Music")).click();
        $("input[type='file']").uploadFromClasspath("krolik.jpg");
        $("[id='currentAddress']").setValue("Деревня дедушки, ул.Колотушкина 32");
        $("[id='react-select-3-input']").setValue("Har").pressEnter();
        $("[id='react-select-4-input']").setValue("P").pressEnter();
        $("[id='submit']").click();

        $("[id='example-modal-sizes-title-lg']").shouldHave(text("Thanks for submitting the form"));
        $("[class='table-responsive']")
                .find(byText("Student Name"))
                .parent()
                .shouldHave(text("Антон Корягин"));
        $("[class='table-responsive']")
                .find(byText("Student Email"))
                .parent()
                .shouldHave(text("koryaginant@google.com"));
        $("[class='table-responsive']")
                .find(byText("Gender"))
                .parent()
                .shouldHave(text("Male"));
        $("[class='table-responsive']")
                .find(byText("Mobile"))
                .parent()
                .shouldHave(text("9948581928"));
        $("[class='table-responsive']")
                .find(byText("Date of Birth"))
                .parent()
                .shouldHave(text("03 February,1996"));
        $("[class='table-responsive']")
                .find(byText("Subjects"))
                .parent()
                .shouldHave(text("Biology"));
        $("[class='table-responsive']")
                .find(byText("Hobbies"))
                .parent()
                .shouldHave(text("Sports, Reading, Music"));
        $("[class='table-responsive']")
                .find(byText("Picture"))
                .parent()
                .shouldHave(text("krolik.jpg"));
        $("[class='table-responsive']")
                .find(byText("Address"))
                .parent()
                .shouldHave(text("Деревня дедушки, ул.Колотушкина 32"));
        $("[class='table-responsive']")
                .find(byText("State and City"))
                .parent()
                .shouldHave(text("Haryana Panipat"));

    }

    @Test
    void fillRequiredFieldsTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id='userNumber']").setValue("9948581928");
        $("[id='submit']").click();

        $("[id='example-modal-sizes-title-lg']").shouldHave(text("Thanks for submitting the form"));
        $("[class='table-responsive']")
                .find(byText("Student Name"))
                .parent()
                .shouldHave(text("Антон Корягин"));
        $("[class='table-responsive']")
                .find(byText("Gender"))
                .parent()
                .shouldHave(text("Male"));
        $("[class='table-responsive']")
                .find(byText("Mobile"))
                .parent()
                .shouldHave(text("9948581928"));
    }

    @Test
    void isRequiredPhoneNumberMissingTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id='submit']").click();

        $("input[id='userNumber']")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void isRequiredGenderMissingTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='userNumber']").setValue("9948581928");
        $("[id='submit']").click();

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }

    @Test
    void emailValidationFailedTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='userEmail']").setValue("111");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id='userNumber']").setValue("9948581928");
        $("[id='dateOfBirthInput']").click();
        $("[class='react-datepicker__month-select']").selectOption("February");
        $("[class='react-datepicker__year-select']").selectOption("1996");
        $("[aria-label='Choose Saturday, February 3rd, 1996']").click();
        $("[class='subjects-auto-complete__control css-13cymwt-control']").click();
        $("[class='subjects-auto-complete__input']").setValue("Bio").pressEnter();
        $("[id='hobbiesWrapper']").$(byText("Sports")).click();
        $("[id='hobbiesWrapper']").$(byText("Reading")).click();
        $("[id='hobbiesWrapper']").$(byText("Music")).click();
        $("input[type='file']").uploadFromClasspath("krolik.jpg");
        $("[id='currentAddress']").setValue("Деревня дедушки, ул.Колотушкина 32");
        $("[id='react-select-3-input']").setValue("Har").pressEnter();
        $("[id='react-select-4-input']").setValue("P").pressEnter();
        $("[id='submit']").click();

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }

    @Test
    void tryRegisterWithEmptyFieldsTest() {
        $("[id='submit']").click();

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }
}