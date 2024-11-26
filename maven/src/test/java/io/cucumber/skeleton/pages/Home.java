package io.cucumber.skeleton.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  @FindBy(css = "h1")
  private WebElement title;

  @FindAll({
          @FindBy(css = "li")

  }
  )
private List<WebElement> listItems;
  public WebElement getTitle() {
    return title;
  }

  public List<WebElement> getListItems() { return listItems; }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }
}
