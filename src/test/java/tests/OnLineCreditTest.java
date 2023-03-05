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
import static pages.OnLineCreditPage.*;

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
    @ValueSource(strings = {AUTO_PARTS, TICKETS, ELECTRONICS, FURNITURE, MEDICINE, EDUCATION, CLOTH, HUNTING_FISHING, SPORT, CONSTRUCTION,
            TENDER, TYRES})
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
