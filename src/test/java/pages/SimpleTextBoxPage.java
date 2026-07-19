package pages;

import com.codeborne.selenide.SelenideElement;
import resources.SimpleTextBoxTestData;

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

    public SimpleTextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public SimpleTextBoxPage typeUserFullName (String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public SimpleTextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    public SimpleTextBoxPage typeUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public SimpleTextBoxPage checkUserRegistrationName (SimpleTextBoxTestData data) {
        registrationResultName.shouldHave(text(data.fullName));

        return this;
    }

    public SimpleTextBoxPage isRegistrationFormHiddenForInvalidData()  {
        registrationResultBlock.shouldNotBe(visible);

        return this;
    }
}
