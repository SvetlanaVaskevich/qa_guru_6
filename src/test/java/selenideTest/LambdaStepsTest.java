package selenideTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsTest extends TestData{

    @Test
    public void lambdaStepTest(){

        step("Открываем главную страницу",() -> {
            open("https://github.com/");
                });
        step("Ищем репозиторий " + REPOSITORY,() -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY,() -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues",() -> {
            Allure.addAttachment("Page Source", "text/html",WebDriverRunner.source(),"html");
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + NUMBER,() -> {
           $(withText("#" + NUMBER)).shouldHave(Condition.visible);
       });
    }
}
