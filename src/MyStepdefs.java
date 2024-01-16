import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyStepdefs {
    private final WebDriver driver;
    private User randomUser;

    // Constructeur sans arguments pour satisfaire Cucumber
    public MyStepdefs() {
        // Récupérez le WebDriver à partir des Hooks
        this.driver = Hooks.getDriver();
    }

    @Given("^I am on the contact form page")
    public void iAmOnTheContactFormPage() {
        String url = "https://testqa.purse.tech/fake-contact";
        driver.get(url);

        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL not as expected", url, actualUrl);
    }

    @When("I fill in the form with only mandatory valid data")
    public void iFillInTheFormWithMandatoryValidData() {

        randomUser = RandomUserApiUtil.getRandomUser();

        String firstname = randomUser.getFirstName();
        String lastname = randomUser.getLastName();
        String gender = randomUser.getGender();
        String message = "Lorem Ipsum valoris";

        // Localiser la listbox par son identifiant
        WebElement listBoxElement = driver.findElement(By.id("gender"));

        // Utiliser la classe Select pour interagir avec la listbox
        Select listBox = new Select(listBoxElement);

        // Sélectionner une option par la valeur gender fournie par l'API
        listBox.selectByValue(gender);

        // Localiser l'élément input par son attribut "name"
        WebElement inputFirstName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("first-name")));

        // Saisie dans input
        inputFirstName.sendKeys(firstname);

        // Localiser l'élément input par son attribut "name"
        WebElement inputLastName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("last-name")));

        // Saisie dans input
        inputLastName.sendKeys(lastname);

        // Localiser l'élément TextBox par son attribut 'id'
        WebElement textBox = driver.findElement(By.id("message"));

        // Saisissez du texte dans la TextBox
        textBox.sendKeys(message);

        //Attente de 5s pour permettre une vérification visuelle de la saisie
        //Non nécessaire en automatisation mais utile pour l'exercice
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I can submit the form")
    public void iCanSubmitTheForm() {
        // Localisez le bouton par son ID
        WebElement boutonMenu = driver.findElement(By.id("submit-button"));

        // Cliquez sur le bouton
        boutonMenu.click();

        // Vérifiez l'existence de la div avec l'ID 'popin-message'
        WebElement divPopinMessage = driver.findElement(By.id("popin-message"));

        // Affichez le texte de la div
        String actualMsg = divPopinMessage.getText();

        assertEquals("Wrong popin message", "Le message a été envoyé.", actualMsg);
        }
}

