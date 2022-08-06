package ComTradeShop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationSuccess extends BaseTest {

    public RegistrationSuccess(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//p[contains(text(),'Hvala na registraciji. Molimo proverite email i ak')]")
    WebElement AlertSuccess;

    public boolean AlertSuccessIsDisplayed(){
        return wdWait.until(ExpectedConditions.visibilityOf(AlertSuccess)).isDisplayed();

    }
    public String AlertSuccessGetText(){
        return wdWait.until(ExpectedConditions.visibilityOf(AlertSuccess)).getText();
    }

}
