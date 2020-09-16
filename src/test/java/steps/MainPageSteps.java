package steps;

import core.TestCore;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.MainPage;

public class MainPageSteps extends TestCore {

    @When("I see statistics blocks")
    public void checkStatisticsBlockExists() {
        Assert.assertTrue(isElementExists(new MainPage().statisticsBlock, 10L));
    }

    @Then("I should values greater then {string} studentStatistic {string} groupStatistic {string} teacherStatistic in statistic blocks")
    public void checkStatisticsBlocksValue(String studentsAmount, String groupsAmount, String teachersAmount) {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(Integer.parseInt(getText(mainPage.studentStatistic)
                .replaceAll("[^\\d.]", "")) > Integer.parseInt(studentsAmount));
        Assert.assertTrue(Integer.parseInt(getText(mainPage.groupStatistic)
                .replaceAll("[^\\d.]", "")) > Integer.parseInt(groupsAmount));
        Assert.assertTrue(Integer.parseInt(getText(mainPage.teacherStatistic)
                .replaceAll("[^\\d.]", "")) > Integer.parseInt(teachersAmount));
    }
}
