package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

@Feature("Issue в репозитории")
@Owner("Overloque")
public class SelenideTest extends BaseTest {
    @Test
    @Story("Проверка заголовка Issue в собственном репозитории через Listener")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "GitHub", url = "https://github.com")
    @DisplayName("Проверка названия issue через Listener")
    public void testIssueTitleSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input").click();
        $("#query-builder-test").setValue("Overloque/11.QA.GURU_allureReports").pressEnter();

        $(linkText("Overloque/11.QA.GURU_allureReports")).click();
        $("#issues-tab").click();
        $(withText("Test Issue")).should(exist);
    }
}
