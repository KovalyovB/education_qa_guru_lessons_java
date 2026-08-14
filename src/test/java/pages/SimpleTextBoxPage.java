package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import test_data.SimpleTextBoxTestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTextBoxPage {

    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement registrationResultBlock = $("#output");
    private final SelenideElement registrationResultName = $("#name");

    @Step("Открывается страница /text-box")
    public SimpleTextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    @Step("Ввод имени пользователя \"{value}\"")
    public SimpleTextBoxPage typeUserFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    @Step("Клик по кнопке Submit")
    public SimpleTextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    @Step("Ввод пользовательского Email \"{value}\"")
    public SimpleTextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Проверка введенного пользовательского имени")
    public SimpleTextBoxPage checkUserRegistrationName(SimpleTextBoxTestData data) {
        registrationResultName.shouldHave(text(data.fullName));

        return this;
    }

    @Step("Проверка пустого блока при отказе в регистрации")
    public SimpleTextBoxPage isRegistrationFormHiddenForInvalidData() {
        registrationResultBlock.shouldNotBe(visible);

        return this;
    }
}
