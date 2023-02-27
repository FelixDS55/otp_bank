package tests;

import drivers.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.OnLineCreditPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;
import static pages.OnLineCreditPage.CHECK_URL;

public class OnLineCreditTest extends BaseTest {
    OnLineCreditPage onLineCreditPage = new OnLineCreditPage();

    @BeforeEach
    void setUp(){
        onLineCreditPage.setMainMenuCredit();
        onLineCreditPage.setSubMainMenuCredit();
    }
    @Test
    @DisplayName("Проверка перехода на сайт партнера")
    void testOnlineService(){
        step("Выбираем в пункте меню Кредиты в выпадающем окне Рассрочка online", () ->{
            onLineCreditPage.checkPartners();
        });

    }
    @ValueSource(strings = {"Автозапчасти, шины, диски", "Билеты и туры", "Бытовая техника/электроника/мобильные телефоны",
            "Мебель и комплектующие", "Медицинские услуги и товары", "Образовательные услуги", "Одежда/Обувь/Сумки",
            "Охота и рыбалка", "Спорт инвентарь", "Строительство домов/стройматериалы/сельхозтехника/тепло,водо, газооборудование",
            "Тендерные услуги", "Шины и диски"})
    @ParameterizedTest(name = "Проверка наличия в top-panel ссылок {0}")
    void testTopPanelList(String element){
        onLineCreditPage.checkPartnersProgramm(element);
    }

    @Test
    @DisplayName("Проверка перехода на сайт партнера по сссылке")
    void checkFollowingLink(){
        step("Выбираем в пункте меню Кредиты в выпадающем окне Рассрочка online", () ->{
            onLineCreditPage.selectPartners();
            onLineCreditPage.selectPartnersFromList();
            switchTo().window(1);
            webdriver().shouldHave(url(CHECK_URL));
        });
    }
}
