package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static resources.SimpleTextBoxTestData.*;

public class SimpleTextBoxFormTests extends TestBase {

    @BeforeEach
    void toTextBoxPage() {open("/text-box");}

    @AfterEach
    void tearDown() {closeWebDriver();
}

    @Test
    void onlyOneFieldTest() {
        $("[id='userName']").setValue(fullName);
        $("[id='submit']").click();

        $("#name").shouldHave(text(fullName));

    }

    @Test
    void invalidEmailFormatTest() {
        $("[id='userName']").setValue(fullName);
        $("[id='userEmail']").setValue(invalidTextBoxEmail);
        $("[id='submit']").click();

        $("[class='border col-md-12 col-sm-12']").shouldNotBe(visible);
    }
}