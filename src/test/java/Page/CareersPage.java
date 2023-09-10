package Page;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Constant.CareersPageConstant.*;

public class CareersPage extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(CareersPage.class);

    public CareersPage(WebDriver webDriver) {
        super(webDriver);
    }
    public CareersPage checkCareerPageIsOpened(){
        logger.info("checking career page is open");
        checkPageUrl(CAREERS_PAGE_URL);
        checkPageTitle(CAREERS_PAGE_TITLE);
        return this;
    }
    public CareersPage isOurLocationsBlockVisible(){
        logger.info("checking our locations block is visible");
        checkElementDisplayed(OUR_LOCATIONS_SECTION);
        checkElementDisplayed(OUR_LOCATION_SECTION_TITLE);
        checkElementDisplayed(LOCATION_SLIDER);
        return this;
    }
    public CareersPage isLifeAtInsiderBlockVisible(){
        logger.info("checking life at insider block is visible");
        checkElementDisplayed(LIFE_AT_INSIDER_SECTION);
        checkElementDisplayed(LIFE_AT_INSIDER_SECTION_TITLE);
        return this;
    }
    public void isTeamsBlockVisible(){
        logger.info("checking team block is visible");
        checkElementDisplayed(TEAM_SECTION);

    }
    public CareersPage navigateQualityAssurance(){
        navigateUrl(QA_CAREER_PAGE_URL);
        return this;
    }
    public CareersPage checkQACareerPageIsOpen(){
        checkPageTitle(QA_CAREER_PAGE_TITLE);
        checkElementDisplayed(QA_PAGE_H1_ELEMENT);
        return this;
    }
    public void clickSeeAllQAJobs(){
        click(SEE_ALL_QA_JOBS_BUTTON);
    }

}
