package Constant;

import org.openqa.selenium.By;

public class CareersPageConstant {
    public static final String CAREERS_PAGE_URL = "https://useinsider.com/careers/";
    public static final String CAREERS_PAGE_TITLE = "Insider Careers";
    public static final By OUR_LOCATIONS_SECTION = By.id("career-our-location");
    public static final By OUR_LOCATION_SECTION_TITLE = By.xpath("//h3[normalize-space()='Our Locations']");
    public static final By LOCATION_SLIDER = By.id("location-slider");
    public static final By LIFE_AT_INSIDER_SECTION = By.cssSelector("section[data-id='a8e7b90']");
    public static final By LIFE_AT_INSIDER_SECTION_TITLE = By.xpath("//h2[normalize-space()='Life at Insider']");
    //THERE IS NO TEAM SECTION IN THIS PAGE! Since this field is not available, a random locator value is given.
    public static final By TEAM_SECTION = By.id("team-section");
    public static final String QA_CAREER_PAGE_URL = "https://useinsider.com/careers/quality-assurance/";
    public static final String QA_CAREER_PAGE_TITLE = "Insider quality assurance job opportunities";
    public static final By QA_PAGE_H1_ELEMENT = By.xpath("//h1[normalize-space()='Quality Assurance']");
    public static final By SEE_ALL_QA_JOBS_BUTTON = By.cssSelector("a[href='https://useinsider.com/careers/open-positions/?department=qualityassurance']");


}
