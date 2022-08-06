package ComTradeShop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KombinovaniSporeti extends BaseTest {
    public KombinovaniSporeti(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@for='filter_data_brend_142']")
    WebElement GorenjeFilter;
    @FindBy(xpath = "//a[@title='K5111WG kombinovani šporet']")
    WebElement GorennjeK5111WG;
    @FindBy(xpath = "//label[@for='filter_data_brend_42']")
    WebElement BekoFilter;
    @FindBy(xpath = "//a[@title='FSS54010DW kombinovani šporet']")
    WebElement BekoFSS54010DW;
    public void GorenjeFilterKlik(){
        wdWait.until(ExpectedConditions.elementToBeClickable(GorenjeFilter)).click();
    }
    public void GorenjeK5111WG(){
        wdWait.until(ExpectedConditions.elementToBeClickable(GorennjeK5111WG)).click();
    }
    public void BekoFilterKlik(){
        wdWait.until(ExpectedConditions.elementToBeClickable(BekoFilter)).click();
    }
    public void BekoFSS54010DWKlik(){
        wdWait.until(ExpectedConditions.elementToBeClickable(BekoFSS54010DW)).click();
    }







}