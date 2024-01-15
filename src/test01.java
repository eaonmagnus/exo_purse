//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;  // Ajoutez cette ligne
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;
//import java.time.Duration;
//import org.openqa.selenium.NoSuchElementException;
//
//public class test01 {
//    public static void main(String[] args) {
//        String firstname = "Gregory";
//        String lastname = "CHAPITEAU";
//        String message = "Lorem Ipsum valoris";
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
//
//        // Ouvrez une page web
//        driver.get("https://testqa.purse.tech/fake-contact");
//
//        // Localisez la listbox par son identifiant
//        WebElement listBoxElement = driver.findElement(By.id("gender"));
//
//        // Utilisez la classe Select pour interagir avec la listbox
//        Select listBox = new Select(listBoxElement);
//
//        // Sélectionnez une option par la valeur
//        listBox.selectByValue("female");
//
//        // Localisez l'élément input par son attribut "name"
//        WebElement inputFirstName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("first-name")));
//
//        // Saisissez le texte "eaonmagnus" dans le champ de saisie
//        inputFirstName.sendKeys(firstname);
//
//        // Localisez l'élément input par son attribut "name"
//        WebElement inputLastName = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.name("last-name")));
//
//        // Saisissez le texte "eaonmagnus" dans le champ de saisie
//        inputLastName.sendKeys(lastname);
//
//        // Localisez l'élément TextBox par son attribut 'id' (par exemple)
//        WebElement textBox = driver.findElement(By.id("message"));
//
//        // Saisissez du texte dans la TextBox
//        textBox.sendKeys(message);
//
//        // Localisez le bouton par son ID
//        WebElement boutonMenu = driver.findElement(By.id("submit-button"));
//
//        // Cliquez sur le bouton
//        boutonMenu.click();
//
//        // Vérifiez l'existence de la div avec l'ID 'popin-message'
//        try {
//            WebElement divPopinMessage = driver.findElement(By.id("popin-message"));
//
//            // Affichez le texte de la div
//            String textePopinMessage = divPopinMessage.getText();
//            System.out.println("La div 'popin-message' existe. Contenu : " + textePopinMessage);
//        } catch (NoSuchElementException e) {
//            // La div n'existe pas, affichez un message ou effectuez d'autres actions si nécessaire
//            System.out.println("Le formulaire n'a pas été validé");
//        }
//
//
//
//        // Fermez le navigateur
//        //driver.quit();
//    }
//}
