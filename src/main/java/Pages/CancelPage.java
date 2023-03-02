package Pages;

import commonmethods.Commonfunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static commonmethods.Commonfunctions.ClickingOnWebElement;

public class CancelPage
{
    WebDriver driver;
    Commonfunctions commonfunctions;
    public CancelPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        commonfunctions=new Commonfunctions(driver);
    }
    @FindBy(xpath = "//button[@class='button action continue primary']")
    WebElement next;
    @FindBy(xpath = "//button[@type='submit']/span[text()='Place Order']")
    WebElement placeorder;
    @FindBy(xpath = "//div[@ class='checkout-success']/p/a")
    WebElement ordernum;
    @FindBy(xpath = "//div[@class='checkout-success']/p/a")
    WebElement checkout;
    @FindBy(xpath = "//span[@class='base']")
    WebElement ordernumconfirm;
    public void PlacingOrder() throws InterruptedException {
        //ClickingOnWebElement(next);
        Thread.sleep(3000);
        ClickingOnWebElement(placeorder);
        System.out.println("Your Order Num :" + checkout.getText());
        checkout.click();
        commonfunctions.ClickOnElement(ordernum);
    }
}
