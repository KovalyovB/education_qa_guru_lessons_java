package tests;

import org.junit.jupiter.api.Test;
import pages.SimpleTextBoxPage;

import static resources.SimpleTextBoxTestData.fullName;
import static resources.SimpleTextBoxTestData.invalidTextBoxEmail;

public class SimpleTextBoxFormTests extends TestBase {
    SimpleTextBoxPage simpleTextBoxPage = new SimpleTextBoxPage();

    @Test
    void onlyOneFieldTest() {
        simpleTextBoxPage.openPage()
                .typeUserFullName(fullName)
                .submitForm()
                .checkUserRegistrationName();
    }

    @Test
    void invalidEmailFormatTest() {
        simpleTextBoxPage.openPage()
                .typeUserFullName(fullName)
                .typeUserEmail(invalidTextBoxEmail)
                .submitForm()
                .isRegistrationFormHiddenForInvalidData();

    }
}