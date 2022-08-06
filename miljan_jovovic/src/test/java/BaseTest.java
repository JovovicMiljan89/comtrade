import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.ScrollBar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.plugin.javascript.navig.Window;

import java.awt.*;

public class BaseTest {
    // ovde smo deklarisali nasu promenljivu driver koji pokrece nas chrome
    public static WebDriver driver;
    public static WebDriverWait wdWait;
    JavascriptExecutor js;

    // ovo je junit anotacija koja govori da ce se ova metoda izvrsiti pre svih testova
    @Before
    // ovo je metoda cije ime mi pisemo proizvoljno i tu stavljamo sve sto je potrebno izvrsiti pre svih testova
    public void setUp() {
        // ovo automatski skida odgovarajucu verziju drivera
        WebDriverManager.chromedriver().setup();
        // ovde smo nasoj promenljivoj driver dodelili objekat klase Chromedriver
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver,30);
        js = (JavascriptExecutor) driver;
        // ovde smo rekli nasem driveru da ode na google stranicu
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    // ovo je Junit anotacija koja govori da ce se ova metoda izvrsiti posle svih testova
    @After
    // ovo je metoda cije ime mi pisemo proizvoljno i tu stavljamo sve sto je potrebno izvrsiti POSLE svih testova
    public void tearDown() {
        //ova komanda zatvara samo tab koji je trenutno u fokusu
        //driver.close();
        // ova komanda zatvara ceo proces odnosno pretrazivac (driver)
        driver.quit();
    }

    // OVo je metoda cije ime dajemo proizvoljno i tu stavljamo sve korake testa
    @Test
    public void firstTest() {
        driver.get("https://www.yahoo.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().fullscreen();
        driver.close();
        // slozena klasa preko CssSelector-a
        // .gLFyf.gsfi
        //cssSelector preko atributa
        // [maxlenght="2048"]
        //apsoultni xPath NE SMEMO DA KORISTIMO NI POD TACKOM RAZNO
        //html/head/body/table/tbody/tr/th/
        // C:/My documents/my pictures/ more 2019/ grcka/ zalazak sunca.jpg
        //relativni xPath obavezno koristimo ako koristimo xPath
        //*[maxlenght="2048"]
        //xPath po sadrzanom tekstu
        //div[contains(text(),'google offered in')]
        //xPath po tacnom tekstu
        //div[text() = 'google offered in: ']
        //link text
        //partial link text


    }

    @Test
    public void secondTest() {

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Beograd");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.findElement(By.linkText("Gmail"));
    }


    @Test
    public void comTradeSuccessfulRegistrationTest() throws InterruptedException {

        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(20000);
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("firstname")));
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("miljdt");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("lastname")));
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("jovgfm");
        driver.findElement(By.id("email_address")).clear();
        if (driver.findElement(By.id("is_subscribed")).isSelected())
        {
            driver.findElement(By.name("is_subscribed")).click();

        }
        driver.findElement(By.id("email_address")).sendKeys("hvfgxfgu@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("jovovici79");
        driver.findElement(By.id("confirmation")).clear();
        driver.findElement(By.id("confirmation")).sendKeys("jovovici79");
        driver.findElement(By.cssSelector(".button.btn")).click();
    }
    @Test
    public void comTradeSuccessfulRegistrationTestversion2() throws InterruptedException {

        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(20000);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("miljdt");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("jovgfm");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email_address"))).clear();
        if (driver.findElement(By.id("is_subscribed")).isSelected()) {
            driver.findElement(By.name("is_subscribed")).click();

        }
        driver.findElement(By.id("email_address")).sendKeys("hvfgxfgu@gmail.com");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("jovovici79");
        driver.findElement(By.id("confirmation")).clear();
        driver.findElement(By.id("confirmation")).sendKeys("jovovici79");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.btn"))).click();
        //driver.findElement(By.xpath("//span[contains(text() = 'Pošalji']")).click();
        //driver.findElement(By.cssSelector(".button.btn")).click();
//wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.btn"))).click();
//


    }

    @Test public void SelectSeleniumExampleTest()
    {

        driver.get("https://www.ctshop.rs/customer/account/create");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("pravnolice")));
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
//        pravnolice.selectByValue("1");
//        pravnolice.selectByIndex(1);


    }

    @Test public void PravnoLiceRegistracija() throws InterruptedException {

        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(10000);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Miljana");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Jovovicius");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("miadafga19892810@gmail.com");
        if (driver.findElement(By.id("is_subscribed")).isSelected())
        {
            driver.findElement(By.id("is_subscribed")).click();
        }
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("pravnolice")));
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("firma"))).clear();
        driver.findElement(By.id("firma")).sendKeys("Miljanov QA");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("pib"))).clear();
        driver.findElement(By.id("pib")).sendKeys("123456789");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("1234567898");

        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("1234567898");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.btn"))).click();
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".alert-success")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());
        Assert.assertEquals(("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog."),driver.findElement(By.cssSelector(".alert-success")).getText());


    }

    @Test public void PravnoLiceRegistracijaSaNeispravnimPasswordom () throws InterruptedException {
        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(10000);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Miljana");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Jovovicius");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("miljanicshfjsnf19892810@gmail.com");
        if (driver.findElement(By.id("is_subscribed")).isSelected())
        {
            driver.findElement(By.id("is_subscribed")).click();
        }
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("pravnolice")));
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("firma"))).clear();
        driver.findElement(By.id("firma")).sendKeys("Miljanov QA");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("pib"))).clear();
        driver.findElement(By.id("pib")).sendKeys("123456789");
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("1234567898");

        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("12345678998");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.btn"))).click();
        Thread.sleep(5000);
    }

    //ctshop
    //hover bela tehnika
    //izabrati sporeti
    //kombinovani sporeti
    //gorenje filter
    //otvoriti gorenje k51111wg kombinovani sporet
    //proveriti da je boja aparata bela
    //otici korak unazad komandom back
    //kliknuti na ponisti sve filtere
    //izabrati beko filter
    //otvoriti beko fss 54010dw sporet
    //proveriti da je cena na popustu
    //kliknuti na ocene
    //proveriti Zoricin komentar naslov datum text i da ga je postavila Zorica
    //By.xpath("//span[contains(text() = 'Pošalji']")).click();
      @Test
      public void CtshopKupovinaSporeta() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        driver.get("https://www.ctshop.rs/customer/account/create");

        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
//        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.cssSelector(".am-opener"))).perform();
       // Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("(//a[text()='Bela tehnika'])"))).perform();
        //Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("(//a[text()='Kombinovani šporeti'])"))).perform();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Kombinovani šporeti'])"))).click();
        //driver.findElement(By.xpath("(//a[text()='Kombinovani šporeti'])")).click();
        //Thread.sleep(5000);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Gorenje')]"))).click();
 //       wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("/gorenje-k5111wg-kombinovani-sporet.html"))).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='K5111WG kombinovani šporet']"))).click();
      //    driver.findElement(By.xpath("//a[text() = 'K5111WG kombinovani šporet']")).click();
          Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-description-box box-description']//div[1]//p[3]")).isDisplayed());
        //  Assert.assertTrue("Boja aparata: Bela");driver.findElement(By.xpath("//div[@class='product-description-box box-description']//div[1]//p[3]")).isDisplayed();
          Assert.assertEquals(("Boja aparata: Bela"),driver.findElement(By.xpath("//div[@class='product-description-box box-description']//div[1]//p[3]")).getText());
          Thread.sleep(5000);
          driver.navigate().back();
          wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Poništi sve filtere')]"))).click();
          wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='filter_data_brend_42']"))).click();
          wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='FSS54010DW kombinovani šporet']"))).click();
          Assert.assertTrue(driver.findElement(By.xpath("//div[@class='extra-discount-price pull-left']//span[@class='price'][normalize-space()='25.579']")).isDisplayed());
          wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Ocene']"))).click();
          Assert.assertEquals(("Odluka o kupovini ovog sporeta je izmedju ostalog doneta zbog nase velike potrosnje struje, sada nam plinske ringle u tome mnogo pomazu. Rerna je dovoljno velika i za gostinsko spremanje a gril koristim u kombinaciji sa konvencionalnim pecenjem. Ciscenje rerne je prava pesma obzirom da ima Steam Shine program. Sve u svemu PUN POGODAK!"),driver.findElement(By.xpath("//p[contains(text(),'Odluka o kupovini ovog sporeta je izmedju ostalog ')]")).getText());
          Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Zorica']")).isDisplayed());
    }

    @Test public void RegistracijaSaIstomEmailAdresom() throws InterruptedException {

        driver.get("https://www.ctshop.rs/customer/account/create");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstname']"))).sendKeys("Miljancic");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastname']"))).sendKeys("Jovovic");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email_address']"))).sendKeys("algoq@fmaia.com");
        if (driver.findElement(By.xpath("//label[@for='is_subscribed']")).isSelected()) {
            driver.findElement(By.xpath("//label[@for='is_subscribed']")).click();
        }
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firma']"))).sendKeys("Brighties");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pib']"))).sendKeys("123456789");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']"))).sendKeys("Jovovici79");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmation']"))).sendKeys("Jovovici79");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pošalji')]"))).click();

        Thread.sleep(3000);
        Assert.assertEquals(("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!"),driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-warning']")).isDisplayed());
        Assert.assertNotEquals(("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog."),driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-warning']")).isDisplayed());
        Thread.sleep(5000);


    }
    @Test public void RegistracijaSaPibomKojiSadrziSamoSlova() throws InterruptedException {

        driver.get("https://www.ctshop.rs/customer/account/create");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstname']"))).sendKeys("Miljancic");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastname']"))).sendKeys("Jovovic");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email_address']"))).sendKeys("algoq125@fmaia.com");
        if (driver.findElement(By.xpath("//label[@for='is_subscribed']")).isSelected()) {
            driver.findElement(By.xpath("//label[@for='is_subscribed']")).click();
        }
        Select pravnolice = new Select(driver.findElement(By.id("pravnolice")));
        pravnolice.selectByVisibleText("Da");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firma']"))).sendKeys("Brighties");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pib']"))).sendKeys("qwertyuio");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']"))).sendKeys("Jovovici79");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmation']"))).sendKeys("Jovovici79");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pošalji')]"))).click();

        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Hvala na registraciji. Molimo proverite email i ak')]")).isDisplayed());
        Assert.assertEquals(("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog."),driver.findElement(By.xpath("//p[contains(text(),'Hvala na registraciji. Molimo proverite email i ak')]")).getText());
        Assert.assertNotEquals(("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!"),driver.findElement(By.xpath("//p[contains(text(),'Hvala na registraciji. Molimo proverite email i ak')]")).getText());
        //Assert.assertEquals(("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!"),driver.findElement(By.xpath("//p[contains(text(),'Hvala na registraciji. Molimo proverite email i ak')]")).getText());
        //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-warning']")).isDisplayed());
        //Assert.assertNotEquals(("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog."),driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText());
        //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-warning']")).isDisplayed());
        Thread.sleep(5000);

    }
    }
// ovo je kraj nase klase
// i nista ne sme biti posle ove viticaste zagrade}
// otovoriti google stranicu
// otvoriti yahoo stranicu
// vratiti se nazad
// refresh stranicu
// otici napred
// udjemo u fullscreen sa pretrazivacem
// zatvoriti tab