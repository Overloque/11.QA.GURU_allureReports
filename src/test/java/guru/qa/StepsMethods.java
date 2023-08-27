package guru.qa;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsMethods {
    @Step("Открыть страницу github")
    public StepsMethods openMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Найти репозиторий {repository}")
    public StepsMethods findRepository(String repository) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repository).pressEnter();
        return this;
    }

    @Step("Кликнуть по ссылке репозитория {repository}")
    public StepsMethods clickRepoRef(String repository) {
        $(linkText(repository)).click();
        return this;
    }

    @Step("Открыть таб Issues")
    public StepsMethods openIssuesTab() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверить название {title} в issue ")
    public StepsMethods checkIssueTitle(String title) {
        $(withText(title)).should(exist);
        return this;
    }
}
