package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ServiceTest extends BaseTest {
    @BeforeEach
    void setUpPage(){
        Selenide.open("https://www.otpbank.ru/");
    }
    @Test
    void serviceTest(){
        step("Выбираем вкладку Услуги", () ->{
            $(".main-menu").find(byText("Услуги")).click();
            $(".content__right").shouldHave(Condition.text("Банковские услуги"));
        });
        step("В меню слева убедиться, что есть подменю Аренда сейфов, кликнуть на эту ссылку", () ->{
            $(".content__left").shouldHave(Condition.text("Аренда сейфов"));
            $(".content__left").find(byText("Аренда сейфов")).click();
            $(".content__right").shouldBe(Condition.text("Аренда сейфов и ячеек"));
        });
    }
    @Test
    void testDownloadFile() throws Exception {
        step("Заходим на вкладку Услуги -> Аренда сейфов", () ->{
            $(".main-menu").find(byText("Услуги")).click();
            $(".content__left").find(byText("Аренда сейфов")).click();
        });
        step("Скачиваем файл Правила аренды для физ.лиц, проверяем, что автором является Свиридова Ольга", () ->{
            File fileDownloadedPdf = $(byXpath("//a[@href ='/f/retail/safes/pravila_fl.pdf']")).download();
            PDF content = new PDF(fileDownloadedPdf);
            assertThat(content.author).contains("Sviridova Olga");
        });
    }
}

