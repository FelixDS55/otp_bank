package tests;

import com.codeborne.pdftest.PDF;
import drivers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ServicePage;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ServiceTest extends BaseTest {
    ServicePage servicePage = new ServicePage();
    @Test
    @DisplayName("Проверка возможности выбрать опцию Аренда сейфов и скачать Правила аренды")
    void serviceTest(){
        step("Выбираем вкладку Услуги", () ->{
            servicePage.mainMenuSelect();
            servicePage.checkTextOnPage();
        });
        step("В меню слева убедиться, что есть подменю Аренда сейфов, кликнуть на эту ссылку", () ->{
            servicePage.checkTextContentLeft();
            servicePage.selectMenu();
            servicePage.checkTextContentRight();
        });
    }
    @Test
    void testDownloadFile() throws Exception {
        step("Заходим на вкладку Услуги -> Аренда сейфов", () ->{
            servicePage.selectMenuService();
            servicePage.selectMenu();
        });
        step("Скачиваем файл Правила аренды для физ.лиц, проверяем, что автором является Свиридова Ольга", () ->{
            File fileDownloadedPdf = $(byXpath("//a[@href ='/f/retail/safes/pravila_fl.pdf']")).download();
            PDF content = new PDF(fileDownloadedPdf);
            assertThat(content.author).contains("Sviridova Olga");
        });
    }
}

