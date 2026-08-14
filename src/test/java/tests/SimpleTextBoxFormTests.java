package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SimpleTextBoxPage;
import test_data.SimpleTextBoxTestData;

import static test_data.SimpleTextBoxTestData.invalidTextBoxEmail;

@Story("Simple text box form")
public class SimpleTextBoxFormTests extends TestBase {
    SimpleTextBoxPage simpleTextBoxPage = new SimpleTextBoxPage();
    SimpleTextBoxTestData data = new SimpleTextBoxTestData();

    @Test
    @DisplayName("Only one field test")
    void onlyOneFieldTest() {
        simpleTextBoxPage.openPage()
                .typeUserFullName(data.fullName)
                .submitForm()
                .checkUserRegistrationName(data);
    }

    @Test
    @DisplayName("Invalid email format test")
    void invalidEmailFormatTest() {
        simpleTextBoxPage.openPage()
                .typeUserFullName(data.fullName)
                .typeUserEmail(invalidTextBoxEmail)
                .submitForm()
                .isRegistrationFormHiddenForInvalidData();

    }
}