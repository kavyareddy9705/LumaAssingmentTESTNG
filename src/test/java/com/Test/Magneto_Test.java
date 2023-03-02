package com.Test;

import Base.MagnetoApp_Base;
import Pages.*;
//import com.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Magneto_Test extends MagnetoApp_Base {
    public LoginPage loginPage;
    public SelectingBagFromGear clickingGear;
    public BagsPage bagsPage;

    //public WishListPage wishListPage;
    public AddressPage addressPage;
    public CancelPage cancelPage;

    // public CheckOutPage checkOutPage;

    @BeforeClass
    public void SettingLoginPage() throws InterruptedException, FileNotFoundException {
        loginPage = new LoginPage(driver);
        clickingGear = new SelectingBagFromGear(driver);
        bagsPage = new BagsPage(driver);
        addressPage = new AddressPage(driver);
        cancelPage = new CancelPage(driver);
    }

        @Test
        public void Test () throws Exception {

            loginPage.LoginCredentials();
            clickingGear.SelectBag();
            clickingGear.VerifyingCart();
            bagsPage.GetHighestPrice();
            String errormsg = bagsPage.addToWishList();
            bagsPage.SetAddToCart();
            Assert.assertEquals( errormsg , "You have no items in your wish list.");
            addressPage.sendingInfo();
            //addressPage.fillAddress();
            addressPage.addingAddress();
            cancelPage.PlacingOrder();
        }
    }
