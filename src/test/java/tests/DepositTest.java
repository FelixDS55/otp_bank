package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DepositTest extends BaseTest {

    @BeforeEach
    void setUpPage(){
        Selenide.open("https://www.otpbank.ru/");
    }
    @Test
    void depositTestTable(){
        step("Выбираем вкладку Вклады", () ->{
            $(".main-menu").find(byText("Вклады и счета")).click();
        });
        step("Проверяем наличие и выбираем Вклад с оформлением инвестиционного продукта", () ->{
            $(".deposit-accounts__list").shouldHave(text("Вклад с оформлением инвестиционного продукта"));
            $(byXpath("//a[@href ='/retail/deposit/dvoynaya-vygoda/'][1]")).scrollTo().click();
            switchTo().window(1);
            $(".deposit-inner-first").shouldHave(text("Вклад с оформлением инвестиционного продукта"));
        });
        step("Проверка условия вклада", () ->{
            $(".good-to-know__nav").shouldHave(text("Вклад «Двойная выгода»"));
            $(".deposit-inner-rate__table").$(byText("Минимальная сумма вклада")).parent().shouldHave(text("50 000 ₽"));
            $(".deposit-inner-rate__table").$(byText("Максимальная сумма вклада")).parent().shouldHave(text("100 000 000 ₽"));
            $(".deposit-inner-rate__table").$(byText("Срок вклада")).parent().shouldHave(text("366 дней"));
            $(".deposit-inner-rate__table").$(byText("Ставка, если сумма вклада равна сумме, размещенной в инвестиционный продукт НСЖ, ИСЖ, ДУ")).parent().shouldHave(text("9%"));
            $(".deposit-inner-rate__table").$(byText("Снятие")).parent().shouldHave(text("Не разрешается"));
            $(".deposit-inner-rate__table").$(byText("Пополнение")).parent().shouldHave(text("Не разрешается"));
        });
    }
}
