package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormResultsComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    FormResultsComponent formResultsComponent = new FormResultsComponent();

    private SelenideElement firstNameInput = $("[id='firstName']");
    private SelenideElement lastNameInput = $("[id='lastName']");
    private SelenideElement userEmailInput = $("[id='userEmail']");
    private SelenideElement genderTypeContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("[id='userNumber']");
    private SelenideElement dataOfBirthInput = $("[id='dateOfBirthInput']");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesContainer = $("[id='hobbiesWrapper']");
    private SelenideElement uploadFileButton = $("input[type='file']");
    private SelenideElement currentAddressInput = $("[id='currentAddress']");
    private SelenideElement stateSelect = $("[id='react-select-3-input']");
    private SelenideElement citySelect = $("[id='react-select-4-input']");
    private SelenideElement submitButton = $("[id='submit']");
    private SelenideElement modalWindowMessage = $("[id='example-modal-sizes-title-lg']");

    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public StudentRegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setGender(String value) {
        genderTypeContainer.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationPage typeUserPhoneNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setDateOfBirth(String day, String month, String year) {
        dataOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public StudentRegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationPage setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationPage uploadFile(String value) {
        uploadFileButton.uploadFromClasspath(value);

        return this;
    }

    public StudentRegistrationPage typeUserAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setState(String value) {
        stateSelect.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationPage setCity(String value) {
        citySelect.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    public StudentRegistrationPage checkModalTitle(String value) {
        modalWindowMessage.shouldHave(text(value));

        return this;
    }

    public StudentRegistrationPage checkAllFieldsResults() {
        formResultsComponent.checkNameComponent();
        formResultsComponent.checkEmailComponent();
        formResultsComponent.checkGenderComponent();
        formResultsComponent.checkNumberComponent();
        formResultsComponent.checkDateOfBirthComponent();
        formResultsComponent.checkSubjectsComponent();
        formResultsComponent.checkHobbiesComponent();
        formResultsComponent.checkFileComponent();
        formResultsComponent.checkAddressComponent();
        formResultsComponent.checkStateAndCityComponent();

        return this;
    }

    public StudentRegistrationPage checkRequiredFieldsResults() {
        formResultsComponent.checkNameComponent();
        formResultsComponent.checkGenderComponent();
        formResultsComponent.checkNumberComponent();

        return this;
    }

    public StudentRegistrationPage checkPhoneNumberValidationTrigger() {
        formResultsComponent.checkPhoneNumberValidationTrigger();

        return this;
    }

    public StudentRegistrationPage checkRequiredParameters() {
        modalWindowMessage.shouldNot(exist);

        return this;
    }
}



