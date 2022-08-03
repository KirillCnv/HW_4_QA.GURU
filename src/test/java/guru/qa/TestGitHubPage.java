package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestGitHubPage {

    @BeforeAll
    static void configuration() {
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenide() {
        // Окрыть github
        open("https://github.com/");
        // Ввести в поиск "selenide"
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // Проверить, что в списке есть "selenide/selenide"
        $("ul.repo-list").shouldHave(text("selenide/selenide"));
        // Открыть первый элемент из списка
        $$("ul.repo-list li").first().$("a").click();
        // Открыть раздел Wiki
        $("#wiki-tab").click();
        //Убедитесься, что в списке есть страница SoftAssertions
        $(".markdown-body").shouldHave(text("Soft assertions"));
        // Открвыть страницу SoftAssertions
        $(byText("Soft assertions")).click();
        // Проверить, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
        //sleep(8000);
    }
}
