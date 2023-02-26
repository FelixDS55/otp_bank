package tests;

import drivers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CreditPage;
import static io.qameta.allure.Allure.step;

public class CreditTest extends BaseTest {
    CreditPage creditPage = new CreditPage();

    @Test
    @DisplayName("Проверка работы кредитного калькулятора")
    void testService(){
        step("Выбираем в пункте меню Кредиты в выпадающем окне Кредит наличными", () ->{
            creditPage.setMainMenuCredit();
            creditPage.setSubMainMenuCredit();
            creditPage.shouldHaveTextMainPage();
        });
        step("Установка параметров кредитования", () ->{
            creditPage.InputParameterCredit();
            creditPage.InputParameterSumCredit();
            creditPage.creditTerm();
        });
        step("Проверка правильности отражения условий кредитования",() ->{
            creditPage.tableResult();
        });
        step("Проверка заполнения полей заемщика",() ->{
            creditPage.personalDataClient();
        });
    }
}
