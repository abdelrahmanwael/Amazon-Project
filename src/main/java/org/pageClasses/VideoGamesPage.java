package org.pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoGamesPage extends BasePage {

    private static final By All_Burger_Menu = By.xpath("(//a[@id='nav-hamburger-menu'])[1]");
    private static final By See_All_Btn = By.xpath("(//a[@class='hmenu-item hmenu-compressed-btn'])[1]");
    private static final By VIDEO_GAMES_LINK_LOCATOR = By.xpath("(//a[@class='hmenu-item'])[25]");
    private static final By ALL_VIDEO_GAMES_LINK_LOCATOR = By.xpath("(//a[@class='hmenu-item' and contains(text(), 'Video Games')])[2]");

    public VideoGamesPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllVideoGamesLink() {
        click(All_Burger_Menu);

 //       click(See_All_Btn);
//        click(VIDEO_GAMES_LINK_LOCATOR);
        //click(ALL_VIDEO_GAMES_LINK_LOCATOR);
    }
    public void expandMenu() {
        click(See_All_Btn);
    }
    public void clickOnVideoGamesCategory() {
        click(VIDEO_GAMES_LINK_LOCATOR);
        click(ALL_VIDEO_GAMES_LINK_LOCATOR);
    }
}