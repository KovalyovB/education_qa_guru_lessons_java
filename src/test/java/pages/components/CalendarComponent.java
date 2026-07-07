package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public SelenideElement month = $("[class='react-datepicker__month-select']");
    public SelenideElement year = $("[class='react-datepicker__year-select']");
    public SelenideElement day = $("[class='react-datepicker__month']");

    public void setDate(String day, String month, String year){
        this.month.selectOption(month);
        this.year.selectOption(year);
        this.day.$(byText(day)).click();
    }

}
