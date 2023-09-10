package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Constant.OpenPositionPageConstant.*;

public class OpenPositionsPage extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(OpenPositionsPage.class);

    public OpenPositionsPage(WebDriver webDriver) {
        super(webDriver);
    }
    public OpenPositionsPage checkOpenPositionPageIsOpen(){
        logger.info("checking open positions page is open");
        checkPageTitle(OPEN_POSITION_PAGE_TITLE);
        checkElementText(OPEN_POSITION_H3,"All open positions");
        return this;
    }
    public OpenPositionsPage checkDepartmentIsQualityAssurance(){
        logger.info("checking the department select menu value is quality assurance");
        checkElementAttribute(DEPARTMENT,"title","Quality Assurance");
        return this;
    }
    public OpenPositionsPage changeLocationToIstanbul(){
        logger.info("changing the location to Istanbul, Turkey");
        selectByText(LOCATION_SELECT_MENU,"Istanbul, Turkey");
        return this;
    }
    public OpenPositionsPage checkAllJobsIsInIstanbul(){
        logger.info("checking all listed jobs are in Istanbul");
        scrollUntilVisible(POSITION_LOCATION_TEXT);
        checkElementText(POSITION_LOCATION_TEXT,"Istanbul, Turkey");
        checkListText(POSITION_LOCATION_TEXT,"Istanbul, Turkey");
        return this;
    }
    public OpenPositionsPage checkAllDepartmentContainsQA(){
        logger.info("checking all listed jobs are in quality assurance department");
        //scrollUntilVisible(POSITION_DEPARTMENT_TEXT);
        checkElementText(POSITION_DEPARTMENT_TEXT,"Quality Assurance");
        checkListText(POSITION_DEPARTMENT_TEXT,"Quality Assurance");
        return this;
    }
    public OpenPositionsPage clickViewRole() {
        logger.info("clicking the view role");
        hoverElement(JOB_CARD);
        click(VIEW_ROLE);
        return this;
    }
    public OpenPositionsPage redirectToLeverPage(){
        logger.info("redirect to the lever page");
        switchNewTab();
        return this;
    }


}
