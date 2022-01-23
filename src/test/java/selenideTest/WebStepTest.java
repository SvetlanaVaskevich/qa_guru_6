package selenideTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static selenideTest.TestData.NUMBER;
import static selenideTest.TestData.REPOSITORY;

public class WebStepTest {

    WebStep steps = new WebStep();

    @Test
    public void annotatedStepTest(){
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldVisibleIssueWithNumber(NUMBER);
    }

    @AfterEach
    public void saveSorces(){
        byte[] screenshot = steps.attachPageSource();
    }

}
