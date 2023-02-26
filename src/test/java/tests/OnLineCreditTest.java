package tests;

import drivers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.OnLineCreditPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class OnLineCreditTest extends BaseTest {
    OnLineCreditPage onLineCreditPage = new OnLineCreditPage();

    @Test
    @DisplayName("Проверка перехода на сайт партнера")
    void testOnlineService(){
        step("Выбираем в пункте меню Кредиты в выпадающем окне Рассрочка online", () ->{
            onLineCreditPage.setMainMenuCredit();
            onLineCreditPage.setSubMainMenuCredit();
        });

    }
    @ValueSource(strings = {"Автозапчасти, шины, диски", "Билеты и туры", "Бытовая техника/электроника/мобильные телефоны",
            "Мебель и комплектующие", "Медицинские услуги и товары", "Образовательные услуги", "Одежда/Обувь/Сумки",
            "Охота и рыбалка", "Спорт инвентарь", "Строительство домов/стройматериалы/сельхозтехника/тепло,водо, газооборудование",
            "Тендерные услуги", "Шины и диски"})
    @ParameterizedTest(name = "Проверка наличия в top-panel ссылок {0}")
    void testTopPanelList(String element){
        onLineCreditPage.setMainMenuCredit();
        onLineCreditPage.setSubMainMenuCredit();
        $(".product-partners__categories").$(byText(element)).shouldBe(visible);
    }
}
