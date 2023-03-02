package Pages;


import commonmethods.Commonfunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SelectingBagFromGear
{
    WebDriver driver;
    public SelectingBagFromGear(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
         this.driver = driver;
        Commonfunctions generics=new Commonfunctions(driver);
    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement geardropdown;
    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bags;
    @FindBy(xpath="//a[@class='action showcart']")
    WebElement cart;
    @FindBy(xpath = "//div[contains(@class,'block block-minicart')]")
    WebElement empty;
       public  void SelectBag() throws InterruptedException {Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.moveToElement(geardropdown).perform();
        Thread.sleep(3000);
        actions.moveToElement(bags).click().perform();
    }
    public void VerifyingCart()
    {
        Commonfunctions.ClickingOnWebElement(cart);
        Assert.assertTrue(empty.isDisplayed());
        System.out.println("empty list");
    }
}
