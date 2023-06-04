package shop.demoqa.webPages;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static shop.demoqa.configuration.ConfigProvider.BASE_URL;

@Slf4j
public class BasePageTest{

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        log.info("Initialize web driver.");
            driver = WebDriverManager.chromedriver().create();
                driver.manage().window().maximize();
    }

    public void open(String path){
        driver.get(BASE_URL + path);
    }

    @AfterMethod
    public void tearDown(){
        log.info("Initialise driver quit.");
            driver.quit();
    }
}