import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.zatro.es/");

        WebElement searchButton = driver.findElement(By.className("buscar-btn"));
        searchButton.click();

        WebElement writeInput = driver.findElement(By.className("iBuscar"));
        writeInput.sendKeys("adidas");
        writeInput.submit();

        // I HAD TO MAKE IT WAIT BECAUSE THE SITE WAS SLOWER THAN THE BOT
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@id=\'product2351\']/div/a"));
            }
        });

        WebElement secondShoe = driver.findElement(By.xpath("//*[@id=\'product2351\']/div/a"));
        WebElement shoeId = driver.findElement(By.xpath("//*[@id=\'product2351\']/div/div/a[2]"));
        shoeId.getText();
        String shoeIdText = shoeId.getText();
        secondShoe.click();

        WebElement sizeList = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div/div/div[3]/div[3]/div[2]/div/div[3]/div[2]"));
        sizeList.click();

        WebElement secondSize = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div/div/div[3]/div[3]/div[2]/div/div[3]/div[2]/ul/li[2]"));
        secondSize.click();

        WebElement addToCard = driver.findElement(By.xpath("//*[@id='page']/div[5]/div/div/div[3]/div[3]/div[2]/div/div[4]/button[1]"));
        addToCard.click();

        //AGAIN I HAD TO MAKE IT WAIT BECAUSE SOMETIMES IT GAVE AN ERROR
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("btn-pagar"));
            }
        });

        WebElement checkOut = driver.findElement(By.className("btn-pagar"));
        checkOut.click();

        //AGAIN I HAD TO MAKE IT WAIT BECAUSE SOMETIMES IT GAVE AN ERROR
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@id=\'page\']/div[4]/nav/div[8]/span[1]"));
            }
        });

        WebElement myCart = driver.findElement(By.xpath("//*[@id=\'page\']/div[4]/nav/div[8]/span[1]"));
        myCart.click();
        WebElement shoeCartId = driver.findElement(By.xpath("//*[@id=\'carrito\']/div/div/ul/li/div[3]/a/span"));
        shoeCartId.getText();
        String shoeCartIdText = shoeCartId.getText();

        Assert.assertEquals(shoeIdText, shoeCartIdText);
        System.out.println(shoeIdText + " = " + shoeCartIdText);

        //Close the browser
//        driver.quit();
    }
}