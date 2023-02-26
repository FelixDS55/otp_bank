package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PremiumPage {
    public static final String MINIMAL_SUM = ("Минимальная сумма вклада");
    public static final String MINIMAL_SUM_COUNT = ("1 500 000 ₽");
    public static final String MAXIMUM_SUM = ("Максимальная сумма вклада");
    public static final String MAXIMUM_SUM_COUNT = ("65 000 000 ₽");
    public static final String DEPOSIT_TERM = ("Срок вклада");
    public static final String DEPOSIT_TERM_DAYS = ("366 дней");
    public static final String DEPOSIT_RATE = ("Ставка");
    public static final String DEPOSIT_RATE_TEXT = ("9% при открытии онлайн, 8,2% при открытии в отделении банка");
    public static final String DEPOSIT_WITHDRAWAL = ("Снятие");
    public static final String DEPOSIT_WITHDRAWAL_CAN = ("Не разрешается");
    public static final String DEPOSIT_REPLENISHMENT = ("Пополнение");
    public static final String DEPOSIT_REPLENISHMENT_CAN = ("Доступно первые 30 календарных дней со дня открытия Вклада, мин.сумма – 100 рублей РФ");
    public static final String DEPOSIT_INTEREST_PAYMENT = ("Выплата процентов");
    public static final String DEPOSIT_INTEREST_PAYMENT_CAN = ("В конце срока вклада");
    private final SelenideElement
        premiumMenu = $(".header-top__left"),
        premiumText = $(".premium-hero__text"),
        depositMenu = $(".main-menu");

    public PremiumPage selectPremiumMenu() {
        premiumMenu.find(byText("Premium")).click();
        return this;
    }

    public PremiumPage checkPremiumText() {
        premiumText.shouldHave(Condition.text("ОТП Premium"));
        return this;
    }

    public PremiumPage selectDepositMenu() {
        depositMenu.find(byText("Вклад")).click();
        return this;
    }

    public void verifyResult(String key, String value){
        $(".deposit-inner-rate__content").$(byText(key)).parent().shouldHave(text(value));
    }
}
