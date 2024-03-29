package com.vicky.imooc.testCase;

import com.vicky.imooc.base.DriverBase;
import com.vicky.imooc.business.CoursePagePro;
import com.vicky.imooc.business.HomePagePro;
import com.vicky.imooc.utility.HandleCookie;
import com.vicky.imooc.utility.ProUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PopupBuyFlow extends CaseBase{
    public DriverBase driver;
    public CoursePagePro cpp;
    public ProUtil pro;
    public HandleCookie hc;

    @BeforeClass
    public void openDriver(){
        this.driver = initDriver("chrome");
        driver.waitLoad();
        cpp = new CoursePagePro(driver);
        pro = new ProUtil("test.properties");
        hc = new HandleCookie(driver);
        driver.get(pro.getPro("courseurl"));
        hc.addCookie();
        driver.get(pro.getPro("courseurl"));
    }
    @AfterClass
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
    @Test
    public void testBuyOnPopup(){
        cpp.clickBuyOnPopup(pro.getPro("scrollDown"));
    }
}
