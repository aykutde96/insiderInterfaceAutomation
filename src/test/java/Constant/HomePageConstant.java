package Constant;

import org.openqa.selenium.By;

public class HomePageConstant {
    public static final String BASE_URL = "https://useinsider.com/";
    public static final String HOME_PAGE_TITLE = "#1 Leader in Individualized, Cross-Channel CX — Insider";
    public static final By COMPANY_BUTTON = By.xpath("//a[normalize-space()='Company']");
    public static final By CAREERS_BUTTON = By.cssSelector("a[href='https://useinsider.com/careers/']");
    public static final By ACCEPT_COOKIES = By.id("wt-cli-accept-all-btn");

}
