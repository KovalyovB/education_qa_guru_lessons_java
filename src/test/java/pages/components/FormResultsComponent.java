package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static resources.RegistrationTestData.*;

public class FormResultsComponent {

    public SelenideElement formResults = $("[class='table-responsive']");
    public SelenideElement userNumberInputForm =$("input[id='userNumber']");


    public void checkNameComponent(){
        formResults.find(byText("Student Name"))
                .parent()
                .shouldHave(text(firstName + " " + lastName));
    }

    public void checkEmailComponent(){
        formResults.find(byText("Student Email"))
                .parent()
                .shouldHave(text(userRegistrationFormEmail));
    }

    public void checkGenderComponent(){
        formResults.find(byText("Gender"))
                .parent()
                .shouldHave(text(gender));
    }

    public void checkNumberComponent(){
        formResults.find(byText("Mobile"))
                .parent()
                .shouldHave(text(userNumber));
    }

    public void checkDateOfBirthComponent(){
        formResults.find(byText("Date of Birth"))
                .parent()
                .shouldHave(text("0" + dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
    }

    public void checkSubjectsComponent(){
        formResults.find(byText("Subjects"))
                .parent()
                .shouldHave(text(subject));
    }

    public void checkHobbiesComponent(){
        formResults.find(byText("Hobbies"))
                .parent()
                .shouldHave(text(hobbies.get(0) + ", " +  hobbies.get(1) + ", " +  hobbies.get(2)));
    }

    public void checkFileComponent(){
        formResults.find(byText("Picture"))
                .parent()
                .shouldHave(text(file));
    }

    public void checkAddressComponent(){
        formResults.find(byText("Address"))
                .parent()
                .shouldHave(text(currentAddress));
    }

    public void checkStateAndCityComponent(){
        formResults.find(byText("State and City"))
                .parent()
                .shouldHave(text(state + " " + city));
    }

    public void checkPhoneNumberValidationTrigger(){
        userNumberInputForm.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

}
