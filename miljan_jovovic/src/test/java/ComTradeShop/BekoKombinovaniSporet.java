package ComTradeShop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BekoKombinovaniSporet extends BaseTest {
    public BekoKombinovaniSporet(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='extra-discount-price pull-left']//span[@class='price'][normalize-space()='25.579']")
    WebElement NovaCena;
    @FindBy(xpath = "//span[@data-html='true']")
    WebElement StaraCena;

    public boolean NovaCenaDisplayed(){
        return wdWait.until(ExpectedConditions.visibilityOf(NovaCena)).isDisplayed();
    }
    public String NovaCenaText (){
        return wdWait.until(ExpectedConditions.visibilityOf(NovaCena)).getText();
    }
    public boolean StaraCenaDisplayed(){
        return wdWait.until(ExpectedConditions.visibilityOf(StaraCena)).isDisplayed();

    }
    public String StaraCenaText(){
        return wdWait.until(ExpectedConditions.visibilityOf(StaraCena)).getText();
    }



}
