package Base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public void navigateUrl(String url) {
        webDriver.get(url);
    }

    public WebElement findElement(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }

    public void click(By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(findElement(by)));
        hoverElement(by);
        findElement(by).click();
    }


    public void checkPageUrl(String expectedUrl) {
        webDriverWait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(expectedUrl + " is not equal current url", expectedUrl, webDriver.getCurrentUrl());
    }

    public void containsPageUrl(String containsUrl) {
        webDriverWait.until(ExpectedConditions.urlContains(containsUrl));
        Assert.assertTrue("Url does not contain " + containsUrl, webDriver.getCurrentUrl().contains(containsUrl));
    }

    public void checkElementDisplayed(By by) {
        scrollUntilVisible(by);
        Assert.assertTrue("element is not displayed",findElement(by).isDisplayed());
    }

    public void checkPageTitle(String expectedTitle) {
        webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(expectedTitle + " is not equal the current page title", expectedTitle, webDriver.getTitle());
    }

    public void checkElementText(By by, String elementText) {
        webDriverWait.until(ExpectedConditions.textToBe(by, elementText));
        Assert.assertEquals(elementText + " is not equal the element text", elementText, findElement(by).getText());
    }

    public void checkElementAttribute(By by, String attribute, String expectedValue) {
        webDriverWait.until(ExpectedConditions.attributeToBe(by, attribute, expectedValue));
        Assert.assertEquals(expectedValue, findElement(by).getAttribute(attribute));
    }

    public void scrollUntilVisible(By by) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", findElement(by));
    }

    public List<WebElement> findElements(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return webDriver.findElements(by);
    }

    public void selectByText(By by, String text) {
        Select select = new Select(findElement(by));
        select.selectByVisibleText(text);
    }

    public void checkListText(By by, String expectedText) {
        List<WebElement> elements = findElements(by);
        if (elements.size() == 0) {
            Assert.fail("No such element found");
        }

        for (WebElement element : elements) {
            webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            String elementText = element.getText().trim();
            Assert.assertEquals(elementText, expectedText);
        }

    }

    public void hoverElement(By hoverElement) {
        Actions action = new Actions(webDriver);
        action.moveToElement(findElement(hoverElement)).perform();
    }

    public void switchNewTab() {
        String currentWindowHandle = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }


}
