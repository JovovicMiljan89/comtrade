package RegistrationPage;

import ComTradeShop.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    WebElement imeInputField;
    @FindBy(id = "lastname")
    WebElement prezimeInputField;
    @FindBy(id = "is_subscribed")
    WebElement checkBoxnewsletter;
    @FindBy(css = ".button.btn")
    WebElement posaljiButton;
    @FindBy(id = "email_address")
    WebElement emailAdress;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(id = "confirmation")
    WebElement passwordConfirmationInputField;
    @FindBy(id = "firma")
    WebElement firmaInputField;
    @FindBy(id = "pib")
    WebElement pibInputField;
    @FindBy(xpath = "//button[text() = 'Prihvatam']")
    WebElement PrihvatamButtonClick;
    @FindBy(id = "pravnolice")
    WebElement PravnoLice;
    @FindBy(css = ".alert-warning")
    WebElement AlertWarningMessageIsDisplayed;
    @FindBy(css = ".am-opener.sharkskin-collapse")
    WebElement SviProizvodi;
    @FindBy(css = "body > header:nth-child(2) > div:nth-child(1) > nav:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(12) > a:nth-child(1)")
    WebElement Belatehnika;
    @FindBy(xpath = "//a[contains(text(),'Kombinovani šporeti')]")
    WebElement KombinovaniSporeti;


    public void SviProizvodi() {
        actions.moveToElement(SviProizvodi).perform();
    }
    public void SviProizvodiKlik() {
        actions.moveToElement(SviProizvodi).click();
    }

    public void BelaTehnika(){
            actions.moveToElement(Belatehnika).perform();
    }


    public void BelaTehnikaKlik() {

        actions.moveToElement(Belatehnika).click();
    }

    public void KombinovaniSporeti(){
        actions.moveToElement(KombinovaniSporeti).perform();
    }
    public void KombinovaniSporetiKlik() {
        wdWait.until(ExpectedConditions.elementToBeClickable(KombinovaniSporeti)).click();
    }


    public void closePopup() throws InterruptedException {

        Thread.sleep(20000);


    }

    public void ImeInputFieldSendKeys(String ime) {
        wdWait.until(ExpectedConditions.visibilityOf(imeInputField)).clear();
        imeInputField.sendKeys(ime);
    }

    public void PrezimeInputFieldSendKeys(String prezime) {

        wdWait.until(ExpectedConditions.visibilityOf(prezimeInputField)).clear();
        prezimeInputField.sendKeys(prezime);
    }

    public void PosaljiButtonClick() {

        wdWait.until(ExpectedConditions.elementToBeClickable(posaljiButton)).click();
    }

    public void EmailAdressSendKeys(String email) {

        wdWait.until(ExpectedConditions.visibilityOf(emailAdress)).clear();
        emailAdress.sendKeys(email);
    }

    public void PasswordInputFieldSendKeys(String password) {

        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).clear();
        passwordInputField.sendKeys(password);
    }

    public void PasswordConfirmationInputField(String password) {

        wdWait.until(ExpectedConditions.visibilityOf(passwordConfirmationInputField)).clear();
        passwordConfirmationInputField.sendKeys(password);

    }

    public void FirmaInputField(String firma) {
        wdWait.until(ExpectedConditions.visibilityOf(firmaInputField)).clear();
        firmaInputField.sendKeys(firma);

    }

    public void pibInputField(String pib) {
        wdWait.until(ExpectedConditions.visibilityOf(pibInputField)).clear();
        pibInputField.sendKeys(pib);
    }

    public void CheckBoxnewsletter() {
        wdWait.until(ExpectedConditions.elementToBeClickable(checkBoxnewsletter));
        if (checkBoxnewsletter.isSelected())
            checkBoxnewsletter.click();


    }

    public void PrihvatamButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();

    }

    public void PravnoLice() {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("pravnolice"))).isSelected();


    }

    public boolean AlertWarningMessageIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(AlertWarningMessageIsDisplayed));
        return AlertWarningMessageIsDisplayed.isDisplayed();
    }

    public String AlertWarningGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(AlertWarningMessageIsDisplayed)).isDisplayed();
        return AlertWarningMessageIsDisplayed.getText();
    }

}