package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    public static String cashCredit = "Кредит наличными";
    public static String credit = "Кредит наличными на любые цели";
    public static String salary = "50000";
    public static String sumCredit = "350000";
    public static String yearsCredit = "5 лет";
    public static String percent = "от 5.9 %";
    public static String sumPercent = "6 750 ₽т";


    private final String  NAME = "Иванов Михаил Петрович";
    private final String PHONE_NUMBER = "9256582543";
    private final SelenideElement
        mainMenuItem = $(".main-menu__item"),
        mainSubMenu = $(".main-submenu"),
        mainPageText = $(".credits-main__info"),
        creditYears = $(byXpath("//div[@data-el-list = 'list']")),
        table = $("._17gMlE"),
        personalData = $(byXpath("//input[@name = 'fullName']")),
        personalPhone = $(byXpath("//input[@inputmode= 'tel']"));

    public CreditPage choiceMainMenuCredits(String value) {
        mainMenuItem.find(byText(value)).hover();
        return this;
    }
    public CreditPage setSubMainMenuCredit(String value){
        mainSubMenu.find(byText(value)).click();
        return this;
    }

    public CreditPage checkTextOnMainPage(String value){
        mainPageText.shouldHave(text(value));
        return this;
    }

    public CreditPage inputParameterCredit(String value) {
        $$("input[inputmode = decimal]").first().sendKeys(Keys.CONTROL + "A");
        $$("input[inputmode = decimal]").first().sendKeys(value);
        return this;
    }

    public CreditPage inputParameterSumCredit(String value){
            $$("input[inputmode = decimal]").last().sendKeys(Keys.CONTROL + "A");
            $$("input[inputmode = decimal]").last().sendKeys(value);
        return this;
    }

    public CreditPage setCreditTerm(String value){
        creditYears.find(byText(value)).click();
        return this;
    }
    public CreditPage tableResult(String sumCredit, String years, String percent, String sumPercent){
        table.shouldHave(text(sumCredit));
        table.shouldHave(text(years));
        table.shouldHave(text(percent));
        table.shouldHave(text(sumPercent));
        return this;
    }

    public CreditPage setPersonalDataClient(){
        personalData.setValue(NAME).pressEnter();
        personalPhone.setValue(PHONE_NUMBER).pressEnter();
        return this;
    }
}