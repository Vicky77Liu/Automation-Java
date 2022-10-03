
package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.http.impl.execchain.TunnelRefusedException;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class PredefinedStepDefs {
    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("I resize window to {int} and {int}")
    public void iResizeWindowToAnd(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        getDriver().manage().window().setSize(dimension);
    }

    @Then("I wait for {int} sec")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000L);
    }

    @When("I maximize window")
    public void iMaximizeWindow() {
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Dimension maxWindowSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        getDriver().manage().window().setPosition(new Point(0,0));
        getDriver().manage().window().setSize(maxWindowSize);
    }

    @Then("element with xpath {string} should be present")
    public void elementWithXpathShouldBePresent(String xpath) {
        assertThat(getDriver().findElements(By.xpath(xpath))).hasSize(1);
    }

    @Then("element with xpath {string} should not be present")
    public void elementWithXpathShouldNotBePresent(String xpath) {
        assertThat(getDriver().findElements(By.xpath(xpath))).hasSize(0);
    }

    @Then("I wait for element with xpath {string} to be present")
    public void iWaitForElementWithXpathToBePresent(String xpath) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    @Then("I wait for element with xpath {string} to not be present")
    public void iWaitForElementWithXpathToNotBePresent(String xpath) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
    }

    @Then("element with xpath {string} should be displayed")
    public void elementWithXpathShouldBeDisplayed(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
    }

    @Then("element with xpath {string} should not be displayed")
    public void elementWithXpathShouldNotBeDisplayed(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isFalse();
    }

    @Then("element with xpath {string} should be enabled")
    public void elementWithXpathShouldBeEnabled(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isEnabled()).isTrue();
    }

    @Then("element with xpath {string} should be disabled")
    public void elementWithXpathShouldBeDisabled(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isEnabled()).isFalse();
    }

    @Then("element with xpath {string} should be selected")
    public void elementWithXpathShouldBeSelected(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isSelected()).isTrue();
    }

    @Then("element with xpath {string} should not be selected")
    public void elementWithXpathShouldNotBeSelected(String xpath) {
        assertThat(getDriver().findElement(By.xpath(xpath)).isSelected()).isFalse();
    }

    @When("I type {string} into element with xpath {string}")
    public void iTypeIntoElementWithXpath(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Then("I click on element with xpath {string}")
    public void iClickOnElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("I click on element using JavaScript with xpath {string}")
    public void iClickOnElementUsingJavaScriptWithXpath(String xpath) {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @Then("I take screenshot")
    public void iTakeScreenshot() throws Exception {
        TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("target/screenshot " + new Date() + ".png"));
    }

    @Then("element with xpath {string} should have text as {string}")
    public void elementWithXpathShouldHaveTextAs(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isEqualTo(text);
    }

    @Then("element with xpath {string} should not have text as {string}")
    public void elementWithXpathShouldNotHaveTextAs(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isNotEqualTo(text);
    }

    @Then("element with xpath {string} should contain text {string}")
    public void elementWithXpathShouldContainText(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).containsIgnoringCase(text);
    }

    @Then("element with xpath {string} should not contain text {string}")
    public void elementWithXpathShouldNotContainText(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).doesNotContain(text);
    }

    @Then("element with xpath {string} should have attribute {string} as {string}")
    public void elementWithXpathShouldHaveAttributeAs(String xpath, String attribute, String attributeValue) {
        assertThat(getDriver().findElement(By.xpath(xpath)).getAttribute(attribute)).isEqualTo(attributeValue);
    }

    @Then("element with xpath {string} should not have attribute {string} as {string}")
    public void elementWithXpathShouldNotHaveAttributeAs(String xpath, String attribute, String attributeValue) {
        assertThat(getDriver().findElement(By.xpath(xpath)).getAttribute(attribute)).isNotEqualTo(attributeValue);
    }

    @Then("I switch to iframe with xpath {string}")
    public void iSwitchToIframeWithXpath(String xpath) {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath(xpath)));
    }

    @Then("I switch to default content")
    public void iSwitchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    @Then("I switch to new window")
    public void iSwitchToNewWindow() {
        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
        String newWindow = iterator.next();
        while(iterator.hasNext()) {
            newWindow = iterator.next();
        }
        getDriver().switchTo().window(newWindow);
    }

    @Then("I switch to first window")
    public void iSwitchToFirstWindow() {
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
    }

    @Then("I switch to base window and close current window")
    public void iSwitchToFirstAndCloseCurrentWindow(){
        getDriver().close();
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
    }

    @Then("I accept alert")
    public void iAcceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    @Then("I dismiss alert")
    public void iDismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    @When("I clear element with xpath {string}")
    public void iClearElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).clear();
    }

    @Then("I should see page title as {string}")
    public void iShouldSeePageTitleAs(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }

    @Then("I should see page title as not {string}")
    public void iShouldNotSeePageTitleAsNot(String title) {
        assertThat(getDriver().getTitle()).isNotEqualTo(title);
    }

    @Then("I should see page title contains {string}")
    public void iShouldSeePageTitleContains(String title) {
        assertThat(getDriver().getTitle()).contains(title);
    }

    @Then("I should see page title does not contain {string}")
    public void iShouldSeePageTitleDoesNotContain(String title) {
        assertThat(getDriver().getTitle()).doesNotContain(title);
    }

    @Then("I scroll to the element with xpath {string} with offset {int}")
    public void iScrollToTheElementWithXpathWithOffset(String xpath, int offset) throws Exception {
        WebElement element = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(false);", element);
        executor.executeScript("window.scrollBy(0, " + offset + ");", element);
        Thread.sleep(500);
    }

    @When("I mouse over element with xpath {string}")
    public void iMouseOverElementWithXpath(String xpath) {
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath(xpath))).perform();
    }

    @When("I enter element with xpath {string}")
    public void iReturnKeys(String xpath){
        getDriver().findElement(By.xpath(xpath)).sendKeys(Keys.RETURN);
    }

    @When("I upload {string} to element with xpath {string}")
    public void iUploadFile(String filePath, String xpath){
        WebElement uploadFile = getDriver().findElement(By.xpath(xpath));
        uploadFile.sendKeys(filePath);
    }

    private boolean downLoadFile(String fileName){
        String downLoadPath = System.getProperty("user.dir") + "/src/test/resources/downloads";
        File dir = new File(downLoadPath);
        File[] dirContents = dir.listFiles();
        if (dirContents != null){
            for (File dirContent : dirContents) {
                String dirContentName = dirContent.getName();
                if (dirContentName.equals(fileName)){
                    return true;
                }
            }
        }
        return false;
    }

    @Then("I wait to download file {string} is on download directory")
    public void iWaitForTheExcelFileToDownload(String fileName){
        boolean result = downLoadFile(fileName);
        assertThat(result).isEqualTo(true);
    }

    @Then("I delete file {string} on download directory")
    public void iDeleteFileOnDownloadDir(String fileName) throws IOException {
        String downLoadPath = System.getProperty("user.dir") + "/src/test/resources/downloads";
        File file = new File(downLoadPath+ "/" +fileName);
        System.out.println(file);
        if (file.exists()){
            Files.deleteIfExists(file.toPath());
        }
    }

    /*** write into the properties file ***/
    private void writePro(String key, String value) {
        Properties properties = new Properties();
        try {
            FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/support/text.properties",true);
            properties.setProperty(key,value);
            properties.store(file, key);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /*** read properties by filepath ***/
    private Properties readProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream inputstream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/support/text.properties");
            BufferedInputStream bufferedinput = new BufferedInputStream(inputstream);
            properties.load(bufferedinput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /*** get properties by key ***/
    private String getPro(String key) {
        String result = " ";
        Properties prop = readProperties();
        if(prop.containsKey(key)) {
            result = prop.getProperty(key);

        }else {
            System.out.println(key + "is not exist!!");
        }
        return result;
    }

    @Then("text which key is {string} is same as text of element with xpath {string}")
    public void iCheckText(String key,String xpath) {
        String textOnSubmission = getDriver().findElement(By.xpath(xpath)).getText();
        String textOnForm = getPro(key);
        if (textOnForm != null && textOnSubmission != null) {
            assertThat(textOnSubmission).isEqualTo(textOnForm);
        }
    }


    @When("I save key is element with {string} and text of element with xpath {string}")
    public void iSaveKeyIsElementWithAndTextOfElementWithXpath(String xpathKey, String xpath) {
        String text = getDriver().findElement(By.xpath(xpath)).getText();
        String key = getDriver().findElement(By.xpath(xpathKey)).getText();
        writePro(key,text);
    }

    @When("I save key is {string} and text of element with xpath {string}")
    public void iSaveKeyAndTextOfElementWithXpath(String key,String xpath) {
        String text = getDriver().findElement(By.xpath(xpath)).getText();
        writePro(key,text);
    }

    @When("I clear properties content")
    public void iClearPropertiesContent() throws IOException {
        Properties prop = new Properties();
        File myFile = new File(System.getProperty("user.dir") + "/src/test/resources/support/text.properties");
        prop.load(new FileInputStream(myFile));
        prop.clear();
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/support/text.properties");
        prop.store(file, "Text Information");

    }
}
