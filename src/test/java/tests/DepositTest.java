package tests;

import drivers.BaseTest;
import org.junit.jupiter.api.Test;
import pages.DepositPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DepositTest extends BaseTest {
    DepositPage depositPage = new DepositPage();

    @Test
    void depositTestTable(){

        step("Выбираем вкладку Вклады", () ->{
            depositPage.mainMenuSelect();
        });
        step("Проверяем наличие и выбираем Вклад с оформлением инвестиционного продукта", () ->{
            depositPage.checkTextOnPage();
            depositPage.findDepositOnPage();
            switchTo().window(1);
            depositPage.checkTextOnPageDeposit();
        });
        step("Проверка условия вклада", () ->{
            depositPage.checkNameDeposit();
            depositPage.checkConditionsDeposit();
        });
    }
}
