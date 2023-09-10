package Page;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Constant.LeverPageConstant.*;

public class LeverPage extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(LeverPage.class);

    public LeverPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void checkLeverPageIsOpened(){
        logger.info("checking lever page is open");
        containsPageUrl("jobs.lever.co/useinsider");
        checkElementText(JOB_LOCATION_TEXT,"Istanbul, Turkey /");
        checkElementText(JOB_DESC_TEXT,"Quality Assurance /");
    }
}
