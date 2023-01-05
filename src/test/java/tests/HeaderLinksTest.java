package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderLinksTest extends BaseTest {
    @BeforeEach
    void setUpPage(){
        Selenide.open("https://www.otpbank.ru/");
        Configuration.holdBrowserOpen = true;
    }

    static Stream<Arguments> checkHeaderLinks(){
        return Stream.of(
                Arguments.of("EN", List.of("Retail banking", "Small business", "Corporate clients", "About us"))
//                Arguments.of("RU", List.of("Частным клиентам", "Малому бизнесу и ИП", "Среднему и крупному бизнесу", "Финансовым организациям", "Premium", "Private", "О банке"))
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
