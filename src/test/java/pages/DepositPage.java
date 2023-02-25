package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DepositPage {
    private final SelenideElement
            mainMenu = $(".main-menu"),
            checkText = $(".deposit-accounts__list"),
            findDeposit = $(byXpath("//a[@href ='/retail/deposit/dvoynaya-vygoda/'][1]")),
            checkTextDeposit = $(".deposit-inner-first"),
            depositName = $(".good-to-know__nav"),
            deposinConditions = $(".deposit-inner-rate__table");

    public DepositPage mainMenuSelect() {
        mainMenu.find(byText("Вклады и счета")).click();
        ;
        return this;
    }

    public DepositPage checkTextOnPage() {
        checkText.shouldHave(text("Вклад с оформлением инвестиционного продукта"));
        return this;
    }

    public DepositPage findDepositOnPage() {
        findDeposit.scrollTo().click();
        return this;
    }

    public DepositPage checkTextOnPageDeposit() {
        checkTextDeposit.shouldHave(text("Вклад с оформлением инвестиционного продукта"));
        return this;
    }
    public DepositPage checkNameDeposit() {
        depositName.shouldHave(text("Вклад «Двойная выгода»"));
        return this;
    }

    public DepositPage checkConditionsDeposit() {
        deposinConditions.$(byText("Минимальная сумма вклада")).parent().shouldHave(text("50 000 ₽"));
        deposinConditions.$(byText("Максимальная сумма вклада")).parent().shouldHave(text("100 000 000 ₽"));
        deposinConditions.$(byText("Срок вклада")).parent().shouldHave(text("366 дней"));
        deposinConditions.$(byText("Ставка, если сумма вклада равна сумме, размещенной в инвестиционный продукт НСЖ, ИСЖ, ДУ")).parent().shouldHave(text("9%"));
        deposinConditions.$(byText("Снятие")).parent().shouldHave(text("Не разрешается"));
        deposinConditions.$(byText("Пополнение")).parent().shouldHave(text("Не разрешается"));
        return this;
    }
}
