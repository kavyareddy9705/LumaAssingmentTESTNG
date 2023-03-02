package Pages;


import Pages.com.Json.JsonData;
import commonmethods.Commonfunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class AddressPage
{
    Commonfunctions commonfunctions;
    WebDriver driver;
//JsonData jsonData=new JsonData();
JsonData jsonData=new JsonData();
public AddressPage(WebDriver driver)
{
    PageFactory.initElements(driver,this);
    this.driver=driver;
    commonfunctions=new Commonfunctions(driver);

    }
       @FindBy(name = "company")
    WebElement  companyname;
    @FindBy (xpath ="//input[@ name='street[0]']")
    WebElement addressline1;
    @FindBy(xpath = "//input[@ name='street[1]']")
    WebElement addressline2;
    @FindBy(xpath = "//input[@ name='street[2]']")
    WebElement addressline3;
    @FindBy(xpath = "//input[@ name='city']")
    WebElement citytextfield;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postcodetextfield;
    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phonenumbertextfield;
    @FindBy(xpath="//span[text()='Ship here']")
    WebElement shipherebutton;

    @FindBy(xpath = "//select[@name='country_id']")
    WebElement country;
    @FindBy(xpath = "//button//span[text()='Next']")
    WebElement next;
    @FindBy(xpath = "//select[@name='region_id']")
    WebElement statedropdown;

    public void addingAddress() throws InterruptedException{
        Thread.sleep(10000);
    }
    //this is for filling address

  public void sendingInfo() throws Exception{
      try {
          companyname.sendKeys("MotivityLabs");
          // addingnewaddress.sendKeys("Dallas centre");
          addressline1.sendKeys("Dallas centre"); //select//option[text()='Telangana']
          addressline2.sendKeys("Knowledge city road");
          addressline3.sendKeys("Rai Durg");
          citytextfield.sendKeys("Hyderabad");
          //statedropdown.sendKeys("Telangana");
          commonfunctions.selectFromDropDown(country, "India");
          commonfunctions.selectFromDropDown(statedropdown, "Telangana");
          postcodetextfield.sendKeys("508004");
          //country.click();
          phonenumbertextfield.sendKeys("9876543210");

      }
      catch(ElementNotInteractableException nse){
          next.click();
      }
  }
}
