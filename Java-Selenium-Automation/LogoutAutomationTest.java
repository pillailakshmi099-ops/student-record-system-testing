import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
public class LogoutAutomationTest {
public static void main(String[] args) {
// Set path to your EdgeDriver executable
// System.setProperty("webdriver.edge.driver", "path_to_your_edge_driver");
// Initialize the EdgeDriver
WebDriver driver = new EdgeDriver();
try {
// Open the website
driver.get("http://localhost/studentrecordms/dashboard.php");
// Wait for the Logout link to be present and clickable
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Increased
timeout
WebElement logoutLink =
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Logout')]")));
// Optionally, use JavaScript to click the element if it's not interactable
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", logoutLink);
// Wait for the logout to complete (optional)
Thread.sleep(2000); // Pause for 2 seconds
System.out.println("Successfully logged out.");
} catch (Exception e) {
e.printStackTrace();
} finally {
// Close the browser
driver.quit();
}
}
}