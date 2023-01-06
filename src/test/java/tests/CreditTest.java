package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class CreditTest {
    String name = "Иванов Михаил Петрович";
    String phoneNumber = "9256582543";
    @BeforeEach
    void setUpPage(){
        Selenide.open("https://www.otpbank.ru/");
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void testService(){
        step("Выбираем в пункте меню Кредиты в выпадающем окне Кредит наличными", () ->{
            $(".main-menu__item").find(byText("Кредиты")).hover();
            $(".main-submenu").find(byText("Кредит наличными")).click();
            $(".credits-main__info").shouldHave(text("Кредит наличными на любые цели"));
        });
        step("Установка параметров кредитования", () ->{
            $$("input[inputmode = decimal]").first().sendKeys(Keys.CONTROL + "A");
            $$("input[inputmode = decimal]").first().sendKeys("50000");
            $$("input[inputmode = decimal]").last().sendKeys(Keys.CONTROL + "A");
            $$("input[inputmode = decimal]").last().sendKeys("350000");
            $(byXpath("//div[@data-el-list = 'list']")).find(byText("5 лет")).click();
        });
        step("Проверка правильности отражения условий кредитования",() ->{
            $("._17gMlE").shouldHave(text("350 000 ₽"));
            $("._17gMlE").shouldHave(text("5 лет"));
            $("._17gMlE").shouldHave(text("от 5.9 %"));
            $("._17gMlE").shouldHave(text("6 750 ₽"));
        });
        step("Проверка заполнения полей заемщика",() ->{
            $(byXpath("//input[@name = 'fullName']")).setValue(name).pressEnter();
            $(byXpath("//input[@inputmode= 'tel']")).setValue(phoneNumber).pressEnter();
        });
    }
}
