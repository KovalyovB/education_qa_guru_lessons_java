package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormResultsComponent;
import resources.RegistrationTestData;

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
    private final  SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dataOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement uploadFileButton = $("input[type='file']");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#react-select-3-input");
    private final SelenideElement citySelect = $("#react-select-4-input");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalWindowMessage = $("#example-modal-sizes-title-lg");

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

    public StudentRegistrationPage checkRequiredFieldsResults(RegistrationTestData data) {
        formResultsComponent.checkNameComponent(data);
        formResultsComponent.checkGenderComponent(data);
        formResultsComponent.checkNumberComponent(data);

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



