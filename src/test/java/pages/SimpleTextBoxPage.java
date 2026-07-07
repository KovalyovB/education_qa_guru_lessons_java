package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static resources.SimpleTextBoxTestData.fullName;

public class SimpleTextBoxPage {
    private final SelenideElement fullNameInput = $("[id='userName']");
    private final SelenideElement userEmailInput = $("[id='userEmail']");
    private final SelenideElement submitButton = $("[id='submit']");
    private final SelenideElement registrationResultBlock = $("[class='border col-md-12 col-sm-12']");
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

    public SimpleTextBoxPage checkUserRegistrationName () {
        registrationResultName.shouldHave(text(fullName));

        return this;
    }

    public SimpleTextBoxPage isRegistrationFormHiddenForInvalidData()  {
        registrationResultBlock.shouldNotBe(visible);

        return this;
    }
}
