package hellocucumber.action.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }
    public String getDynamicXpath(String xpathLocator, String... dynamicValues) {
        if(xpathLocator.startsWith("")){
            xpathLocator = String.format(xpathLocator,(Object[]) dynamicValues);
        }
        return xpathLocator;
    }
    public WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }
    public WebElement getWebElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return driver.findElement(getByXpath(getDynamicXpath(xpathLocator, dynamicValues)));
    }
    public void clickToElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    public void clickToElement(WebDriver driver, String xpathLocator, String... dynamicValue) {
        getWebElement(driver, xpathLocator, dynamicValue).click();
    }
    public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue, String... dynamicValue){
        WebElement element = getWebElement(driver, xpathLocator, dynamicValue);
        element.clear();
        element.sendKeys(textValue);
    }
    public void waitForElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait expliciWait = new WebDriverWait(driver, longTimeout);
        expliciWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));

    }
    public void waitForElementVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicXpath(xpathLocator, dynamicValues))));
    }
    public boolean isElementDisplay(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(xpathLocator, dynamicValues)).isDisplayed();
    }
    public boolean isElementDisplay(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isDisplayed();
    }
    private long longTimeout = 30;
    private short shortTimeout = (short) 5;
}
