package pages.components;

import com.codeborne.selenide.SelenideElement;
import test_data.RegistrationTestData;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormResultsComponent {

    public SelenideElement formResults = $(".table-responsive");
    public SelenideElement userNumberInputForm = $("input[id='userNumber']");


    public void checkNameComponent(RegistrationTestData data) {
        formResults.find(byText("Student Name"))
                .parent()
                .shouldHave(text(data.firstName + " " + data.lastName));

    }

    public void checkEmailComponent(RegistrationTestData data) {
        formResults.find(byText("Student Email"))
                .parent()
                .shouldHave(text(data.userRegistrationFormEmail));
    }

    public void checkGenderComponent(RegistrationTestData data) {
        formResults.find(byText("Gender"))
                .parent()
                .shouldHave(text(data.gender));
    }

    public void checkNumberComponent(RegistrationTestData data) {
        formResults.find(byText("Mobile"))
                .parent()
                .shouldHave(text(data.userNumber));
    }

    public void checkDateOfBirthComponent(RegistrationTestData data) {
        formResults.find(byText("Date of Birth"))
                .parent()
                .shouldHave(text("0" + data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth));
    }

    public void checkSubjectsComponent(RegistrationTestData data) {
        formResults.find(byText("Subjects"))
                .parent()
                .shouldHave(text(data.subject));
    }

    public void checkHobbiesComponent(RegistrationTestData data) {
        formResults.find(byText("Hobbies"))
                .parent()
                .shouldHave(text(data.hobbies));
    }

    public void checkFileComponent(RegistrationTestData data) {
        formResults.find(byText("Picture"))
                .parent()
                .shouldHave(text(data.file));
    }

    public void checkAddressComponent(RegistrationTestData data) {
        formResults.find(byText("Address"))
                .parent()
                .shouldHave(text(data.currentAddress));
    }

    public void checkStateAndCityComponent(RegistrationTestData data) {
        formResults.find(byText("State and City"))
                .parent()
                .shouldHave(text(data.state + " " + data.city));
    }

    public void checkPhoneNumberValidationTrigger() {
        userNumberInputForm.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
