package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OnLineCreditPage {
    public static final String AUTO_PARTS = "Автозапчасти, шины, диски";
    public static final String TICKETS = "Билеты и туры";
    public static final String ELECTRONICS = "Бытовая техника/электроника/мобильные телефоны";
    public static final String FURNITURE = "Мебель и комплектующие";
    public static final String MEDICINE = "Медицинские услуги и товары";
    public static final String EDUCATION = "Образовательные услуги";
    public static final String CLOTH = "Одежда/Обувь/Сумки";
    public static final String HUNTING_FISHING = "Охота и рыбалка";
    public static final String SPORT = "Спорт инвентарь";
    public static final String CONSTRUCTION = "Строительство домов/стройматериалы/сельхозтехника/тепло,водо, газооборудование";
    public static final String TENDER = "Тендерные услуги";
    public static final String TYRES = "Шины и диски";
    public static final String CHECK_URL = "https://mosautoshina.ru/";
    private final SelenideElement
            mainMenuItem = $(".main-menu__item"),
            mainSubMenu = $(".main-submenu"),
            partners = $(".product-partners__categories"),
            ourPartners = $(".product-partners"),
            partnersCategories = $(".product-partners__categories"),
            partnersList = $(".product-partners__list");

    public OnLineCreditPage setMainMenuCredit() {
        mainMenuItem.find(byText("Кредиты")).hover();
        return this;
    }

    public OnLineCreditPage setSubMainMenuCredit() {
        mainSubMenu.find(byText("Рассрочка online")).click();
        return this;
    }

    public OnLineCreditPage checkPartnersProgramm(String element) {
        partners.$(byText(element)).shouldBe(visible);
        return this;
    }

    public OnLineCreditPage checkPartners() {
        ourPartners.shouldHave(text("Наши партнеры"));
        return this;
    }

    public OnLineCreditPage selectPartners() {
        partnersCategories.find(byText("Автозапчасти, шины, диски")).click();
        return this;
    }

    public OnLineCreditPage selectPartnersFromList() {
        partnersList.find(byText("Мосавтошина")).click();
        return this;
    }
}
