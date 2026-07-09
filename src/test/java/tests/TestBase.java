package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.SimpleTextBoxPage;
import pages.StudentRegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    SimpleTextBoxPage simpleTextBoxPage = new SimpleTextBoxPage();
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}