package com.google.imooc.testCase;

import com.google.imooc.base.DriverBase;
import com.google.imooc.business.HomePagePro;
import com.google.imooc.utility.ProUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoBackHomeByImoocLogo extends CaseBase {
    public DriverBase driver;
    public HomePagePro hpp;
    public ProUtil pro;

    @BeforeClass
    public void openDriver(){
        this.driver = initDriver("chrome");
        driver.waitLoad();
        hpp = new HomePagePro(driver);
        pro = new ProUtil("test.properties");
        driver.get(pro.getPro("url"));

    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
    @Test
    public void testBackByImoocLogo(){
        hpp.goBackHomePage();
        hpp.clickEachNavItems();
    }
}
