package ComTradeShop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GorenjeK5111WG extends BaseTest {
    public GorenjeK5111WG() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[normalize-space()='Ocene']")
    WebElement OceneKlik;
    @FindBy(xpath = "//body/main[@class='sharkskin-content']/section[@class='container']/div[@class='row']/div[@class='col-sm-12']/div[@class='product-page row']/div[@class='col-sm-12 col-xs-12 product-details-box']/div[@class='tab-content']/div[@id='ocene']/div[@class='col-sm-12 col-xs-12 product-reviews-box']/div[@class='user-reviews widget desktop']/div[@class='contain-lg-5 contain-md-4 contain-sm-4 fluid']/div[@class='reviews row']/ul[@class='col-md-12 chevron-list-container']/li[1]/strong[1]")
    WebElement SporetKomentar;
    @FindBy(xpath = "//span[normalize-space()='Jasmina Lakic']")
    WebElement JasminaLakicKomentar;
    @FindBy (xpath = "//p[contains(text(),'Ko zeli da ustedi prostor I struju, odlican izbor.')]")
    WebElement TeloKomentaraJasmine;
    @FindBy(xpath = "/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/p[3]")
    WebElement BojaAparata;
    public void OceneKlik() {
        wdWait.until(ExpectedConditions.elementToBeClickable(OceneKlik)).click();

    }
    public boolean SporetKomentar(){
        return wdWait.until(ExpectedConditions.visibilityOf(SporetKomentar)).isDisplayed();
    }
    public String SporetKomentarText(){
        return wdWait.until(ExpectedConditions.visibilityOf(SporetKomentar)).getText();
    }
    public boolean JasminaLakicKomentarDisplayed(){
        return wdWait.until(ExpectedConditions.visibilityOf(JasminaLakicKomentar)).isDisplayed();
    }
    public String ImePrezimeKomentatora(){
        return wdWait.until(ExpectedConditions.visibilityOf(JasminaLakicKomentar)).getText();
    }
    public boolean TeloKomentaraJasmine(){
        return wdWait.until(ExpectedConditions.visibilityOf(TeloKomentaraJasmine)).isDisplayed();

    }
    public String TeloKometaraJasmineText(){
        return wdWait.until(ExpectedConditions.visibilityOf(TeloKomentaraJasmine)).getText();
    }
    public boolean BojaAparataOpis(){
        return wdWait.until(ExpectedConditions.visibilityOf(BojaAparata)).isDisplayed();
    }
    public String BojaAparataBelaText(){
        return wdWait.until(ExpectedConditions.visibilityOf(BojaAparata)).getText();

    }





}