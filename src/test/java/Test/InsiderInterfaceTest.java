package Test;

import Base.BaseTest;
import Page.CareersPage;
import Page.HomePage;
import Page.LeverPage;
import Page.OpenPositionsPage;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsiderInterfaceTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(InsiderInterfaceTest.class);
    HomePage homePage;
    CareersPage careersPage;
    OpenPositionsPage openPositionsPage;
    LeverPage leverPage;
    @Before
    public void install(){
        homePage = new HomePage(getWebDriver());
        careersPage = new CareersPage(getWebDriver());
        openPositionsPage = new OpenPositionsPage(getWebDriver());
        leverPage = new LeverPage(getWebDriver());

    }
    @Test
    public void goToCareerPageTest(){
        logger.info("Go to career page test is starting");
        homePage.navigateHomePage()
                .checkHomePageIsOpened()
                .acceptCookies()
                .clickCompany()
                .clickCareers();
        careersPage.checkCareerPageIsOpened()
                .isOurLocationsBlockVisible()
                .isLifeAtInsiderBlockVisible()
                .isTeamsBlockVisible();
        logger.info("Go to career page test finished");
    }
    @Test
    public void selectQAJobTest() {
        logger.info("select qa job test is starting");
        careersPage.navigateQualityAssurance();
        homePage.acceptCookies();
        careersPage.checkQACareerPageIsOpen()
                .clickSeeAllQAJobs();
        openPositionsPage.checkOpenPositionPageIsOpen()
                .checkDepartmentIsQualityAssurance()
                .changeLocationToIstanbul()
                .checkAllJobsIsInIstanbul()
                .checkAllDepartmentContainsQA()
                .clickViewRole()
                .switchNewTab();
        leverPage.checkLeverPageIsOpened();
        logger.info("select qa job test finished");
    }

}
