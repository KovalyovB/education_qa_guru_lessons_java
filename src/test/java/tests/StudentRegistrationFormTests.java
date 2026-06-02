package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests extends TestBase {

    @BeforeEach
    void toRegistrationPage() {
        open("/automation-practice-form");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    void registrationWithAllFieldsTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='userEmail']").setValue("koryaginant@google.com");
        $("[id='genterWrapper'] [value='Male']").click();
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

        $("[id='example-modal-sizes-title-lg']").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void fillRequiredFieldsTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='genterWrapper'] [value='Male']").click();
        $("[id='userNumber']").setValue("9948581928");

        $(By.xpath("//*[@id='firstName']")).shouldHave(value("Антон"));
        $(By.xpath("//*[@id='lastName']")).shouldHave(value("Корягин"));
        $(By.xpath("//input[@id='gender-radio-1' and @value='Male']")).isSelected();
        $(By.xpath("//*[@id='userNumber']")).shouldHave(value("9948581928"));
    }

    @Test
    void isRequiredPhoneNumberMissingTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='genterWrapper'] [value='Male']").click();
        $("[id='submit']").click();

        $("input[id='userNumber']")
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void isRequiredGenderMissingTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='userNumber']").setValue("9948581928");

        $("#example-modal-sizes-title-lg").shouldNot(exist);
    }

    @Test
    void emailValidationFailedTest() {
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='userEmail']").setValue("111");
        $("[id='genterWrapper'] [value='Male']").click();
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