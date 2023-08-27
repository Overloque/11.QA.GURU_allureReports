package guru.qa;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsMethods {
    @Step("Открыть страницу github")
    public void openMainPage () {
        open("https://github.com");
    }

}
