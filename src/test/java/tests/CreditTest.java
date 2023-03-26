package tests;

import helpers.MainMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CreditPage;
import static io.qameta.allure.Allure.step;
import static pages.CreditPage.*;

public class CreditTest extends BaseTest {
    CreditPage creditPage = new CreditPage();

    @Test
    @DisplayName("Проверка работы кредитного калькулятора")
    void testService(){
        step("Выбираем в пункте меню Кредиты в выпадающем окне Кредит наличными", () ->{
            creditPage.choiceMainMenuCredits(MainMenu.CREDITS.getTranslation());
            creditPage.setSubMainMenuCredit(cashCredit);
            creditPage.checkTextOnMainPage(credit);
        });
        step("Установка параметров кредитования", () ->{
            creditPage.inputParameterCredit(salary);
            creditPage.inputParameterSumCredit(sumCredit);
            creditPage.setCreditTerm(yearsCredit);
        });
        step("Проверка правильности отражения условий кредитования",() ->{
            creditPage.tableResult(sumCredit, yearsCredit, percent, sumPercent);
        });
        step("Проверка заполнения полей заемщика",() ->{
            creditPage.setPersonalDataClient();
        });
    }
}