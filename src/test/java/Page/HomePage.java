package Page;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Constant.HomePageConstant.*;

public class HomePage extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage navigateHomePage(){
        logger.info("Navigating to home page");
        navigateUrl(BASE_URL);
        return this;
    }
    public HomePage checkHomePageIsOpened(){
        logger.info("checking the home page is open");
        checkPageUrl(BASE_URL);
        checkPageTitle(HOME_PAGE_TITLE);
        return this;
    }
    public HomePage acceptCookies(){
        logger.info("click the accept cookies");
        click(ACCEPT_COOKIES);
        return this;
    }
    public HomePage clickCompany(){
        logger.info("click the company button");
        click(COMPANY_BUTTON);
        return this;
    }
    public void clickCareers(){
        logger.info("click the careers button");
        click(CAREERS_BUTTON);
    }

}
