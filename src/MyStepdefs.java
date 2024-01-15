import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;  // Ajoutez cette ligne
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import static org.junit.Assert.assertEquals;

public class MyStepdefs {
    private final WebDriver driver;

    // Constructeur sans arguments pour satisfaire Cucumber
    public MyStepdefs() {
        // Récupérez le WebDriver à partir des Hooks
        this.driver = Hooks.getDriver();
    }

    @Given("^I am on the contact form page")
    public void iAmOnTheContactFormPage() {
        // Votre logique de test ici, par exemple :
        String url = "https://testqa.purse.tech/fake-contact";
        driver.get(url);

        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL not as expected", url, actualUrl);
    }

    @When("I fill in the form with mandatory valid data")
    public void iFillInTheFormWithMandatoryValidData() {
        String firstname = "Gregory";
        String lastname = "CHAPITEAU";
        String message = "Lorem Ipsum valoris";

        // Localisez la listbox par son identifiant
        WebElement listBoxElement = driver.findElement(By.id("gender"));

        // Utilisez la classe Select pour interagir avec la listbox
        Select listBox = new Select(listBoxElement);

        // Sélectionnez une option par la valeur
        listBox.selectByValue("female");

        // Localisez l'élément input par son attribut "name"
        WebElement inputFirstName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("first-name")));

        // Saisissez le texte "eaonmagnus" dans le champ de saisie
        inputFirstName.sendKeys(firstname);

        // Localisez l'élément input par son attribut "name"
        WebElement inputLastName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("last-name")));

        // Saisissez le texte "eaonmagnus" dans le champ de saisie
        inputLastName.sendKeys(lastname);

        // Localisez l'élément TextBox par son attribut 'id' (par exemple)
        WebElement textBox = driver.findElement(By.id("message"));

        // Saisissez du texte dans la TextBox
        textBox.sendKeys(message);
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