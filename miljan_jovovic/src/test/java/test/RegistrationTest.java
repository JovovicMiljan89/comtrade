package test;

import ComTradeShop.*;
import RegistrationPage.RegistrationPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage;
    RegistrationSuccess registrationSuccess;
    KombinovaniSporeti kombinovaniSporeti;
    GorenjeK5111WG gorenjeK5111WG;
    BekoKombinovaniSporet bekoKombinovaniSporet;

    @Before
    public void setUpTesting() {

        registrationPage = new RegistrationPage();
        registrationSuccess = new RegistrationSuccess();
        kombinovaniSporeti = new KombinovaniSporeti();
        gorenjeK5111WG = new GorenjeK5111WG();
        bekoKombinovaniSporet = new BekoKombinovaniSporet();
    }


    @Test
    public void SuccessfulRegistrationCtShop() {
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        registrationPage.ImeInputFieldSendKeys("Miljanic");
        registrationPage.PrezimeInputFieldSendKeys("Jovovicius");
        registrationPage.EmailAdressSendKeys("Makngkddgk@gagk.com");
        if (driver.findElement(By.id("is_subscribed")).isSelected()) {
            driver.findElement(By.id("is_subscribed")).click();
        }
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        registrationPage.FirmaInputField("mali jovovici");
        registrationPage.pibInputField("123456789");
        registrationPage.PasswordInputFieldSendKeys("123456789");
        registrationPage.PasswordConfirmationInputField("123456789");
        registrationPage.PosaljiButtonClick();

    }

    @Test
    public void SuccessfulRegistrationWithWrongPassword() {
        registrationPage.PrihvatamButtonClick();
        registrationPage.ImeInputFieldSendKeys("Marko");
        registrationPage.PrezimeInputFieldSendKeys("Djurovic");
        registrationPage.EmailAdressSendKeys("DjukaDjulazoDjurovicius@markoni.com");
        if (driver.findElement(By.id("is_subscribed")).isSelected()) {
            driver.findElement(By.id("is_subscribed")).click();
        }
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        registrationPage.FirmaInputField("Djulazov poludnevni boravak");
        registrationPage.pibInputField("123456789");
        registrationPage.PasswordInputFieldSendKeys("imammalikurac");
        registrationPage.PasswordConfirmationInputField("malimijekurac");
        registrationPage.PosaljiButtonClick();
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-warning")).isDisplayed());
        Assert.assertEquals(("Razlikuju se lozinka i potvrda lozinke!"), driver.findElement(By.cssSelector(".alert-warning")).getText());


    }

    @Test
    public void RegistracijaPravnogLicaSaPravimPodacima() {
        registrationPage.PrihvatamButtonClick();
        registrationPage.ImeInputFieldSendKeys("Jelena");
        registrationPage.PrezimeInputFieldSendKeys("Jovovic");
        registrationPage.EmailAdressSendKeys("jloncarscsvjovo123vic@fgmdgm.com");
        registrationPage.CheckBoxnewsletter();
//       registrationPage.PravnoLice();
//       registrationPage.FirmaInputField("Jelenin Veseli Boravak");
//       registrationPage.pibInputField("123456789");
        registrationPage.PasswordInputFieldSendKeys("sifra123");
        registrationPage.PasswordConfirmationInputField("sifra123");
        registrationPage.PosaljiButtonClick();
        registrationSuccess.AlertSuccessIsDisplayed();
//        registrationPage.AlertWarningMessageIsDisplayed();
//        Assert.assertTrue(registrationPage.AlertWarningMessageIsDisplayed());
//        Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!", registrationPage.AlertWarningGetText());

    }

    @Test
    public void TestMeniKlikaSaHoverom() throws InterruptedException {

        driver.get("https://www.ctshop.rs/customer/account/create");
        registrationPage.PrihvatamButtonClick();
        registrationPage.SviProizvodi();
        registrationPage.BelaTehnika();
        registrationPage.KombinovaniSporetiKlik();
        kombinovaniSporeti.GorenjeFilterKlik();
        registrationPage.PrihvatamButtonClick();
        kombinovaniSporeti.GorenjeK5111WG();
        gorenjeK5111WG.OceneKlik();
        gorenjeK5111WG.BojaAparataOpis();
        Assert.assertEquals("Boja aparata: Bela",gorenjeK5111WG.BojaAparataBelaText());
        Assert.assertTrue(gorenjeK5111WG.JasminaLakicKomentarDisplayed());
        Assert.assertEquals("Ko zeli da ustedi prostor I struju, odlican izbor. Takodje rerna super I ravnomerno pece. Lako se odrzava, ma prezadovoljna sam. Ima 5 godina garanciju, ja se kunem u Gorenje. Takodje, cena je super pristupacna za ovaj kvalitet."
                ,gorenjeK5111WG.TeloKometaraJasmineText());
        driver.navigate().back();
        driver.navigate().back();
        kombinovaniSporeti.GorenjeFilterKlik();
        kombinovaniSporeti.BekoFilterKlik();
        kombinovaniSporeti.BekoFSS54010DWKlik();
        Thread.sleep(2000);
        Assert.assertTrue(bekoKombinovaniSporet.StaraCenaDisplayed());
        Assert.assertTrue(bekoKombinovaniSporet.NovaCenaDisplayed());
        Assert.assertEquals("25.579",bekoKombinovaniSporet.NovaCenaText());
        Assert.assertEquals("30.093 RSD",bekoKombinovaniSporet.StaraCenaText());
        Thread.sleep(2000);

    }

}