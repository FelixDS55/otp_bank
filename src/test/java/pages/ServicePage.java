package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ServicePage {
    private final SelenideElement
            mainMenu = $(".main-menu"),
            checkText = $(".content__right"),
            contentLeft = $(".content__left"),
            contentRight = $(".content__right");

    public ServicePage mainMenuSelect() {
        mainMenu.find(byText("Услуги")).click();
        return this;
    }

    public ServicePage checkTextOnPage() {
        checkText.shouldHave(Condition.text("Банковские услуги"));
        return this;
    }
    public ServicePage checkTextContentLeft() {
        contentLeft.shouldHave(Condition.text("Аренда сейфов"));
        return this;
    }
    public ServicePage selectMenu() {
        contentLeft.find(byText("Аренда сейфов")).click();
        return this;
    }
    public ServicePage checkTextContentRight() {
        contentRight.shouldBe(Condition.text("Аренда сейфов и ячеек"));
        return this;
    }
    public ServicePage selectMenuService() {
        mainMenu.find(byText("Услуги")).click();
        return this;
    }
}
