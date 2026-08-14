package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import test_data.RegistrationTestData;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormResultsComponent {

    public SelenideElement formResults = $(".table-responsive");
    public SelenideElement userNumberInputForm = $("input[id='userNumber']");

    @Step("Проверка имени на итоговой форме регистрации")
    public void checkNameComponent(RegistrationTestData data) {
        formResults.find(byText("Student Name"))
                .parent()
                .shouldHave(text(data.firstName + " " + data.lastName));

    }

    @Step("Проверка Email на итоговой форме регистрации")
    public void checkEmailComponent(RegistrationTestData data) {
        formResults.find(byText("Student Email"))
                .parent()
                .shouldHave(text(data.userRegistrationFormEmail));
    }

    @Step("Проверка пола на итоговой форме регистрации")
    public void checkGenderComponent(RegistrationTestData data) {
        formResults.find(byText("Gender"))
                .parent()
                .shouldHave(text(data.gender));
    }

    @Step("Проверка номера телефона на итоговой форме регистрации")
    public void checkNumberComponent(RegistrationTestData data) {
        formResults.find(byText("Mobile"))
                .parent()
                .shouldHave(text(data.userNumber));
    }

    @Step("Проверка даты рождения на итоговой форме регистрации")
    public void checkDateOfBirthComponent(RegistrationTestData data) {
        formResults.find(byText("Date of Birth"))
                .parent()
                .shouldHave(text("Date of Birth " + data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth));
    }

    @Step("Проверка дисциплины на итоговой форме регистрации")
    public void checkSubjectsComponent(RegistrationTestData data) {
        formResults.find(byText("Subjects"))
                .parent()
                .shouldHave(text(data.subject));
    }

    @Step("Проверка хобби на итоговой форме регистрации")
    public void checkHobbiesComponent(RegistrationTestData data) {
        formResults.find(byText("Hobbies"))
                .parent()
                .shouldHave(text(data.hobbies));
    }

    @Step("Проверка имени файла на итоговой форме регистрации")
    public void checkFileComponent(RegistrationTestData data) {
        formResults.find(byText("Picture"))
                .parent()
                .shouldHave(text(data.file));
    }

    @Step("Проверка адреса на итоговой форме регистрации")
    public void checkAddressComponent(RegistrationTestData data) {
        formResults.find(byText("Address"))
                .parent()
                .shouldHave(text(data.currentAddress));
    }

    @Step("Проверка штата и города на итоговой форме регистрации")
    public void checkStateAndCityComponent(RegistrationTestData data) {
        formResults.find(byText("State and City"))
                .parent()
                .shouldHave(text(data.state + " " + data.city));
    }

    @Step("Проверка номера телефона на итоговой форме регистрации")
    public void checkPhoneNumberValidationTrigger() {
        userNumberInputForm.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
