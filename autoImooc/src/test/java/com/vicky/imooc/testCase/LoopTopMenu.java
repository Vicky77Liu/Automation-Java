package com.vicky.imooc.testCase;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.business.HomePagePro;
import com.vicky.imooc.utility.ProUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoopTopMenu extends CaseBase{

    public DriverBase driver;
    public HomePagePro hpp;
    public ProUtil pro;

    @BeforeClass
    public void startDriver(){
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
    public void testLoopTopMenu(){
        hpp.loopTopMenu();
    }
}
