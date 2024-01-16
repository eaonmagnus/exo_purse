import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private static WebDriver driver;

    // avant chaque éxécution de scénario, création d'une instance chromeDriver
    @Before
    public void setUp() {
        // Spécifiez le chemin du driver Chrome
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");

        // Spécifiez le port pour ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Instanciez le WebDriver avec les options
        driver = new ChromeDriver(options);
    }

    // Après chaque scénario, fermeture de l'instance chromeDriver
    @After
    public void tearDown() {
        if (driver != null) {
            //Attente de 5s pour permettre une vérification visuelle
            //Non nécessaire en automatisation mais utile pour l'exercice
                    try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
