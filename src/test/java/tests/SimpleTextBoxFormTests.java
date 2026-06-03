package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTextBoxFormTests extends TestBase {

    @BeforeEach
    void toTextBoxPage() {open("/text-box");}

    @AfterEach
    void tearDown() {closeWebDriver();
}

    @Test
    void onlyOneFieldTest() {
        $("[id='userName']").setValue("Марченко Анатолий Викторович");
        $("[id='submit']").click();

        $("#name").shouldHave(text("Марченко Анатолий Викторович"));

    }

    @Test
    void invalidEmailFormatTest() {
        $("[id='userName']").setValue("Марченко Анатолий Викторович");
        $("[id='userEmail']").setValue("myemail123");
        $("[id='submit']").click();

        $("[class='border col-md-12 col-sm-12']").shouldNotBe(visible);
    }
}