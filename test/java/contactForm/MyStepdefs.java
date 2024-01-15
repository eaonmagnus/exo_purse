import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;  // Ajoutez cette ligne
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

public class MyStepdefs {
    @Given("I am on the contact form page")
    public void iAmOnTheContactFormPage() {
        String firstname = "Gregory";
        String lastname = "CHAPITEAU";
        String message = "Lorem Ipsum valoris";

//        // Spécifiez le chemin du driver Chrome
//        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
//
//        // Spécifiez le port pour ChromeDriver
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        //options.addArguments("--remote-debugging-port=50474"); // Remplacez 50474 par le port de votre choix
//
//        // Instanciez le WebDriver avec les options
//        WebDriver driver = new ChromeDriver(options);

        // Ouvrez une page web
        //driver.get("https://testqa.purse.tech/fake-contact");
    }
}
