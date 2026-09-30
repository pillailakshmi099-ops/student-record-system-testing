import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class DeleteStudent {
public static void main(String[] args) {
// Set the path to your EdgeDriver executable
// System.setProperty("webdriver.edge.driver", "path_to_your_edgedriver");
// Initialize the EdgeDriver
WebDriver driver = new EdgeDriver();
try {
// Step 1: Open the main page
driver.get("http://localhost/studentrecordms/manage-students.php");
// Step 2: Click on the "View Students" link
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
WebElement viewStudentsLink = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//a[contains(@href, 'manage-students.php') and contains(text(),'View
Students')]")));
viewStudentsLink.click();
// Step 3: Click on the "Delete" button for a specific student
WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//a[contains(@href, 'manage-students.php?del=1') and contains(@class,
'btn-danger')]")));
// Confirm the deletion action
deleteButton.click();
driver.switchTo().alert().accept(); // Handle the confirmation alert if it appears
// Confirmation
System.out.println("Student with ID 1 deleted successfully.");
} catch (Exception e) {
e.printStackTrace(); // Log any exceptions
} finally
{
// Close the browser
driver.quit();
}
}
}