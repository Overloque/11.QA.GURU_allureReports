package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.*;

@Feature("Issue в репозитории")
@Owner("Overloque")
public class StepsAndAnnotationsTest extends BaseTest {
    private static final String REPOSITORY = "Overloque/11.QA.GURU_allureReports";
    private static final String ISSUE = "Test Issue";

    @Test
    @Story("Проверка заголовка Issue в собственном репозитории через лямбда выражения")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "GitHub", url = "https://github.com")
    @DisplayName("Проверка названия issue через лямбда выражения")
    public void testIssueTitleLambdaSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу github", () -> open("https://github.com"));
        step("Найти репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Кликнуть по ссылке репозитория", () -> $(linkText(REPOSITORY)).click());
        step("Открыть таб Issues", () -> $("#issues-tab").click());
        step("Проверить название issue", () -> {
            $(withText(ISSUE)).should(exist);
        });
    }

    @Test
    @Story("Проверка заголовка Issue в собственном репозитории через аннотации")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "GitHub", url = "https://github.com")
    @DisplayName("Проверка названия issue через аннотации")
    public void testIssueTitleAnnotationsSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsMethods steps = new StepsMethods();

        steps
                .openMainPage()
                .findRepository(REPOSITORY)
                .clickRepoRef(REPOSITORY)
                .openIssuesTab()
                .checkIssueTitle(ISSUE);
    }
}
