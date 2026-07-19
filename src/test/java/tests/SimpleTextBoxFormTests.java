package tests;

import org.junit.jupiter.api.Test;
import pages.SimpleTextBoxPage;
import resources.SimpleTextBoxTestData;

import static resources.SimpleTextBoxTestData.invalidTextBoxEmail;

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