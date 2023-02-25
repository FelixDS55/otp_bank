package tests;

import com.codeborne.selenide.CollectionCondition;
import drivers.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static pages.HomePage.*;

public class HeaderLinksTest extends BaseTest {
    HomePage homePage = new HomePage();

    static Stream<Arguments> checkHeaderLinks(){
        return Stream.of(
                Arguments.of("EN", List.of(BANKING, BUSINESS, CLIENTS, ABOUT_US))
        );
    }

    @MethodSource
    @ParameterizedTest (name = "Проверка списка {1} по локали {0}")
    @Tag("Critical")
    void checkHeaderLinks(String locale, List<String> buttons){
        $$(".header-top__link").find(text(locale)).click();
        $$(".header-top__left a").filter(visible).shouldHave(CollectionCondition.texts(buttons));
    }
}
