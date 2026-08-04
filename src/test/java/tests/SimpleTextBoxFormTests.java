package tests;

import org.junit.jupiter.api.Test;
import pages.SimpleTextBoxPage;
import test_data.SimpleTextBoxTestData;

import static test_data.SimpleTextBoxTestData.invalidTextBoxEmail;

public class SimpleTextBoxFormTests extends TestBase {
    SimpleTextBoxPage simpleTextBoxPage = new SimpleTextBoxPage();
    SimpleTextBoxTestData data = new SimpleTextBoxTestData();

    @Test
    void onlyOneFieldTest() {
        simpleTextBoxPage.openPage()
                .typeUserFullName(data.fullName)
                .submitForm()
                .checkUserRegistrationName(data);
    }

    @Test
    void invalidEmailFormatTest() {
        simpleTextBoxPage.openPage()
                .typeUserFullName(data.fullName)
                .typeUserEmail(invalidTextBoxEmail)
                .submitForm()
                .isRegistrationFormHiddenForInvalidData();

    }
}