import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main  {
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
        secondShoe.click();

        WebElement sizeList = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div/div/div[3]/div[3]/div[2]/div/div[3]/div[2]"));
        sizeList.click();

        WebElement secondSize = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div/div/div[3]/div[3]/div[2]/div/div[3]/div[2]/ul/li[2]"));
        secondSize.click();

        WebElement addToCard = driver.findElement(By.xpath("//*[@id='page']/div[5]/div/div/div[3]/div[3]/div[2]/div/div[4]/button[1]"));
        addToCard.click();

        WebElement checkOut = driver.findElement(By.className("btn-pagar"));
        checkOut.click();

        WebElement myCard = driver.findElement(By.className("cesta-btn"));
        myCard.click();

//        @Test
//        public void assertProducts() {
//            WebElement shoeId = driver.findElement(By.xpath("//*[@id=\"product2351\"]/div/div/a[2]"));
//            WebElement shoeCardId = driver.findElement(By.xpath("//*[@id=\"carrito\"]/div/div/ul/li/div[3]/a/span"));
//            Assert.assertEquals(shoeId, shoeCardId);
//            System.out.print("\n assertProducts() -> Part executed");
//        }

        //Close the browser
        driver.quit();
    }
}