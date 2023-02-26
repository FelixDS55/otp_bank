package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OnLineCreditPage {
    private final SelenideElement
            mainMenuItem = $(".main-menu__item"),
            mainSubMenu = $(".main-submenu");

    public OnLineCreditPage setMainMenuCredit() {
        mainMenuItem.find(byText("Кредиты")).hover();
        return this;
    }

    public OnLineCreditPage setSubMainMenuCredit(){
        mainSubMenu.find(byText("Рассрочка online")).click();
        return this;
    }
}
