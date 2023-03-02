package Pages;

import commonmethods.Commonfunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPage
{
    WebDriver driver;
  public BagsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        Commonfunctions commonfunctions=new Commonfunctions(driver);
    }
    @FindBy(xpath="//span[text()='Add to Wish List']")
    WebElement Addtowishlist;
    @FindBy(xpath="//span[text()='Impulse Duffle']/../../following-sibling::div/following-sibling::div/div/button[@type='button']")
    WebElement Addtocart;
    @FindBy(xpath="//div[@class='minicart-wrapper']")
    WebElement  selectcart;
    @FindBy(xpath="//button[@class='action primary checkout']")
    WebElement proceding;


    public void GetHighestPrice()  throws InterruptedException //verifying max price product and adding to cart
    {
        List<WebElement> listofallprices=new ArrayList<WebElement>();
        listofallprices = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<Double> allproductsamount=new ArrayList<>();
        for (WebElement webElement:listofallprices)
        {
            allproductsamount.add(Double.parseDouble(webElement.getText().replace("$","")));
        }
        System.out.println(Collections.max(allproductsamount));
        Double MaxProductAmount=Collections.max(allproductsamount);
        System.out.println("max amount" + MaxProductAmount);
        WebElement MaxProductAmountPriceAddToCart=driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'"+MaxProductAmount+"')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
        System.out.println(MaxProductAmountPriceAddToCart.getText());
        MaxProductAmountPriceAddToCart.click();
    }
      public String addToWishList() throws InterruptedException
    {
        Thread.sleep(3000);
       //Commonfunctions.ClickingOnWebElement(Addtowishlist);
        Addtowishlist.click();
        Thread.sleep(3000);
        Commonfunctions.ClickingOnWebElement(Addtocart);
        String actualerrormsg=driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']")).getText();
        return actualerrormsg;
    }
    public void SetAddToCart() throws InterruptedException {
        Thread.sleep(3000);
        Commonfunctions.ClickingOnWebElement(selectcart);
        Commonfunctions.ClickingOnWebElement(proceding);
    }

 }
