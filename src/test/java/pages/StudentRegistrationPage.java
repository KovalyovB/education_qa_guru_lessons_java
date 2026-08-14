package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.FormResultsComponent;
import test_data.RegistrationTestData;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    FormResultsComponent formResultsComponent = new FormResultsComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderTypeContainer = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dataOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement uploadFileButton = $("input[type='file']");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#react-select-3-input");
    private final SelenideElement citySelect = $("#react-select-4-input");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalWindowMessage = $("#example-modal-sizes-title-lg");

    @Step("Открывается страница /automation-practice-form")
    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    @Step("Ввод пользовательского имени \"{value}\"")
    public StudentRegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Ввод пользовательской фамилии \"{value}\"")
    public StudentRegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Ввод пользовательского Email \"{value}\"")
    public StudentRegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Выбор пола \"{value}\"")
    public StudentRegistrationPage setGender(String value) {
        genderTypeContainer.$(byText(value)).click();

        return this;
    }

    @Step("Ввод пользовательского номера телефона \"{value}\"")
    public StudentRegistrationPage typeUserPhoneNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Выбор даты рождения: день \"{day}\", месяц \"{month}\", год \"{year}\"")
    public StudentRegistrationPage setDateOfBirth(String day, String month, String year) {
        dataOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбор изучаемой дисциплины \"{value}\"")
    public StudentRegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбор хобби \"{value}\"")
    public StudentRegistrationPage setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    @Step("Загрузка файла \"{value}\"")
    public StudentRegistrationPage uploadFile(String value) {
        uploadFileButton.uploadFromClasspath(value);
        uploadFileButton.shouldBe(Condition.enabled).uploadFromClasspath(value);

        return this;
    }

    @Step("Ввод адреса \"{value}\"")
    public StudentRegistrationPage typeUserAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Выбор штата \"{value}\"")
    public StudentRegistrationPage setState(String value) {
        stateSelect.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбор города \"{value}\"")
    public StudentRegistrationPage setCity(String value) {
        citySelect.setValue(value).pressEnter();

        return this;
    }

    @Step("Клик по кнопке регистрации")
    public StudentRegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    @Step("Проверка отображения итоговой формы регистрации")
    public StudentRegistrationPage checkModalTitle(String value) {
        modalWindowMessage.shouldHave(text(value));

        return this;
    }

    @Step("Проверка заполнения всех полей на итоговой форме регистрации")
    public StudentRegistrationPage checkAllFieldsResults(RegistrationTestData data) {
        formResultsComponent.checkNameComponent(data);
        formResultsComponent.checkEmailComponent(data);
        formResultsComponent.checkGenderComponent(data);
        formResultsComponent.checkNumberComponent(data);
        formResultsComponent.checkDateOfBirthComponent(data);
        formResultsComponent.checkSubjectsComponent(data);
        formResultsComponent.checkHobbiesComponent(data);
        formResultsComponent.checkFileComponent(data);
        formResultsComponent.checkAddressComponent(data);
        formResultsComponent.checkStateAndCityComponent(data);

        return this;
    }

    @Step("Проверка заполнения обязательных полей на итоговой форме регистрации")
    public StudentRegistrationPage checkRequiredFieldsResults(RegistrationTestData data) {
        formResultsComponent.checkNameComponent(data);
        formResultsComponent.checkGenderComponent(data);
        formResultsComponent.checkNumberComponent(data);

        return this;
    }

    @Step("Проверка наличия валидации по полю ввода номера телефона")
    public StudentRegistrationPage checkPhoneNumberValidationTrigger() {
        formResultsComponent.checkPhoneNumberValidationTrigger();

        return this;
    }

    @Step("Проверка валидации по заполнению обязательных полей")
    public StudentRegistrationPage checkRequiredParameters() {
        modalWindowMessage.shouldNot(exist);

        return this;
    }
}