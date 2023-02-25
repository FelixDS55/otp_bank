package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
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

    public CreditPage setMainMenuCredit() {
        mainMenuItem.find(byText("Кредиты")).hover();
        return this;
    }

    public CreditPage setSubMainMenuCredit(){
        mainSubMenu.find(byText("Кредит наличными")).click();
        return this;
    }

    public CreditPage shouldHaveTextMainPage(){
        mainPageText.shouldHave(text("Кредит наличными на любые цели"));
        return this;
    }

    public CreditPage InputParameterCredit() {
        $$("input[inputmode = decimal]").first().sendKeys(Keys.CONTROL + "A");
        $$("input[inputmode = decimal]").first().sendKeys("50000");
        return this;
    }

    public CreditPage InputParameterSumCredit(){
            $$("input[inputmode = decimal]").last().sendKeys(Keys.CONTROL + "A");
            $$("input[inputmode = decimal]").last().sendKeys("350000");
        return this;
    }

    public CreditPage creditTerm(){
        creditYears.find(byText("5 лет")).click();
        return this;
    }
    public CreditPage tableResult(){
        table.shouldHave(text("350 000 ₽"));
        table.shouldHave(text("5 лет"));
        table.shouldHave(text("от 5.9 %"));
        table.shouldHave(text("6 750 ₽"));
        return this;
    }

    public CreditPage personalDataClient(){
        personalData.setValue(NAME).pressEnter();
        personalPhone.setValue(PHONE_NUMBER).pressEnter();
        return this;
    }
}
