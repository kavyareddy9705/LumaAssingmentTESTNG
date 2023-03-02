package Pages;

import Pages.com.Json.JsonData;
import commonmethods.Commonfunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    private WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        WebDriver driver1 = this.driver;
        Commonfunctions commonfunctions=new Commonfunctions(driver);
        JsonData jsonData=new JsonData();
    }
    @FindBy(name = "login[username]")
    WebElement Email;
    @FindBy(name = "login[password]")
    WebElement password;
    @FindBy(xpath = "//button[@ class = 'action login primary']")
    WebElement signinbutton;

    public  void LoginCredentials() throws InterruptedException
    {
        Commonfunctions.sendKeysOnWebElement(Email,"kavyareddy970502@gmail.com");
        Commonfunctions.sendKeysOnWebElement(password,"Kavyareddy@9705");
        Commonfunctions.ClickingOnWebElement(signinbutton);
    }
}
