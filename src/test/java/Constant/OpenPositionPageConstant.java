package Constant;

import org.openqa.selenium.By;

public class OpenPositionPageConstant {
    public static final String OPEN_POSITION_PAGE_TITLE = "Insider Open Positions | Insider";
    public static final By OPEN_POSITION_H3 = By.cssSelector(".mb-2");
    public static final By DEPARTMENT = By.id("select2-filter-by-department-container");
    public static final By LOCATION_SELECT_MENU = By.id("filter-by-location");
    public static final By POSITION_LOCATION_TEXT = By.cssSelector(".position-location.text-large");
    public static final By POSITION_DEPARTMENT_TEXT = By.cssSelector(".position-department.text-large.font-weight-600.text-primary");
    public static final By JOB_CARD = By.xpath("(//div[@class='position-list-item-wrapper bg-light'])[1]");
    public static final By VIEW_ROLE = By.xpath("(//a[text()='View Role'])[1]");
}
