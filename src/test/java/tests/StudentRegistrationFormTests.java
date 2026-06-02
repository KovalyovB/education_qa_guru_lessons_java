package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class StudentRegistrationFormTests extends TestBase {

    @Test
    void registrationWithAllFieldsTest() {
        open("/automation-practice-form");
        $("[id='firstName']").setValue("Антон");
        $("[id='lastName']").setValue("Корягин");
        $("[id='userEmail']").setValue("koryaginant@google.com");
        $("[id='genterWrapper'] [value='Male']").click();
        $("[id='userNumber']").setValue("9948581928");
        $("[id='dateOfBirthInput']").click();
        $("[class='react-datepicker__month-select']").selectOption("February");
        $("[class='react-datepicker__year-select']").selectOption("1996");
        $("[class='react-datepicker__day react-datepicker__day--003 react-datepicker__day--weekend']").click();
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
}

