package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class ServicesTest {
    @FindBy(className = "34dufh")
    private WebElement sum;
    String name = "Иванов Иван Иванович";
    String phoneNumber = "9552360102";
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
//            $$("input[inputmode = decimal]").first().sendKeys(Keys.BACK_SPACE);
            $$("input[inputmode = decimal]").first().sendKeys("50000");
            $$("input[inputmode = decimal]").last().sendKeys(Keys.CONTROL + "A");
//            $$("input[inputmode = decimal]").last().sendKeys(Keys.BACK_SPACE);
            $$("input[inputmode = decimal]").last().sendKeys("1500000");
        });
    }


}
