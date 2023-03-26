package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PremiumPage;

import static io.qameta.allure.Allure.step;
import static pages.PremiumPage.*;

public class PremiumBank extends BaseTest {
    PremiumPage premiumPage = new PremiumPage();

    @Test
    @DisplayName("Check Premium conditions")
    void premiumTest() {
        step("Выбор в главном меню Премиум", () -> {
            premiumPage.selectPremiumMenu();
            premiumPage.checkPremiumText();
        });
    }

    @Test
    @DisplayName("Check Premium conditions")
    void premiumConditions() {
        step("Переход по ссылке Вклады", () -> {
            premiumPage.selectPremiumMenu();
            premiumPage.selectDepositMenu();
        });

        step("Проверка условий Премиум для вклада", () -> {
            premiumPage.verifyResult(MINIMAL_SUM, MINIMAL_SUM_COUNT);
            premiumPage.verifyResult(MAXIMUM_SUM, MAXIMUM_SUM_COUNT);
            premiumPage.verifyResult(DEPOSIT_TERM, DEPOSIT_TERM_DAYS);
            premiumPage.verifyResult(DEPOSIT_RATE, DEPOSIT_RATE_TEXT);
            premiumPage.verifyResult(DEPOSIT_WITHDRAWAL, DEPOSIT_WITHDRAWAL_CAN);
            premiumPage.verifyResult(DEPOSIT_REPLENISHMENT, DEPOSIT_REPLENISHMENT_CAN);
            premiumPage.verifyResult(DEPOSIT_INTEREST_PAYMENT, DEPOSIT_INTEREST_PAYMENT_CAN);
        });
    }
}
