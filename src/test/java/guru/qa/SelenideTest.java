package guru.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

public class SelenideTest {
    @Test
    @DisplayName("Проверка названия issue через Listener")
    public void testIssueTitleSearch () {

        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("Overloque/11.QA.GURU_allureReports").pressEnter();

        $(linkText("Overloque/11.QA.GURU_allureReports")).click();
        $("#issues-tab").click();
        $(withText("Test Issue")).should(exist);
    }
}
