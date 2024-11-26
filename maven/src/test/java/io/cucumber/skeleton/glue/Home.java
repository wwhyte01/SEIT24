package io.cucumber.skeleton.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.core.Context;
import io.cucumber.skeleton.core.Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static io.cucumber.skeleton.pages.Page.waitForPageLoad;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Home extends Context {

  private static final String NOT_FOUND_MESSAGE = "%s could not be found on page.";

  public Home(Manager manager) {
    super(manager);
  }

  @Given("an example Home Page step")
  public void exampleHomePageStep() {
    System.out.println("printing shared stash :" + getTestStash().toString());
  }

  @Then("the list contains a list item with title {string}")
  public void assertListItem(String expectedTitle) {
    List<WebElement> listItems =  manager.getDriver().findElements(new By.ByCssSelector("li"));
//    boolean matchFound = false;
//    for(WebElement l : listItems) {
//      if(l.getText().equals(expectedTitle)) {
//        matchFound = true;
//      }
//    }
//    assertTrue(matchFound);
    assertTrue(listItems
            .stream()
            .anyMatch(l -> l.getText().equals(expectedTitle)), String.format(NOT_FOUND_MESSAGE, expectedTitle)
    );
  }

  @When("the {string} example is opened")
  public void openExample(String title) {
     List<WebElement> list = manager.getDriver().findElements(new By.ByCssSelector("a"));
     list
            .stream()
            .filter(link -> link.getText().equals(title))
             .findFirst()
             .ifPresentOrElse(this::navigateToPage, () -> fail(String.format(NOT_FOUND_MESSAGE, title)));
  }

  @When("valid credentials are supplied")
  public void supplyCredentials() {
    WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.alertIsPresent());
    manager.getDriver().switchTo().alert();
    manager.getDriver().findElement(By.id("username")).sendKeys("admin");
    manager.getDriver().findElement(By.id("password")).sendKeys("admin");
  }

  @Then("{string} should be displayed")
  public void assertTextDisplayed(String expectedText) {
    WebElement paragraph = manager.getDriver().findElement(new By.ByCssSelector("p"));
    assertTrue(paragraph.getText().contains(expectedText), String.format("Text on page did not contain %s", expectedText));
  }


  private void navigateToPage(WebElement webElement) {
    webElement.click();
    waitForPageLoad();
  }

}