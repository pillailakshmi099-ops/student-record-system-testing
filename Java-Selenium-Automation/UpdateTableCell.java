import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class UpdateTableCell {
public static void main(String[] args) {
// Set the path to your EdgeDriver executable
// System.setProperty("webdriver.edge.driver", "path_to_your_edgedriver");
// Initialize the EdgeDriver
WebDriver driver = new EdgeDriver();
try {
// Step 1: Open the main page
driver.get("http://localhost/studentrecordms/manage-subjects.php");
// Step 2: Click on the "Subjects" menu item
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
WebElement subjectsMenu = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//a[contains(text(),'Subject')]")));
subjectsMenu.click();
// Step 3: Click on the "View" button in the dropdown
WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//a[contains(@href, 'manage-subjects.php') and text()='View']")));
viewButton.click();
// Step 4: Click the "Edit" button for the specific subject
WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//a[contains(@href, 'edit-subject.php') and text()='Edit']")));
editButton.click();
// Step 5: Wait for the input field to load, clear its value, and enter a new one
WebElement subjectInput = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//input[@name='sub4']"))); // Locate the input by its name
subjectInput.clear(); // Clear the existing value
TYCS A/9165
subjectInput.sendKeys("Kotlin"); // Enter the new value
// Step 6: Locate and click the "Update" button
WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(
By.xpath("//input[@type='submit' and @name='submit' and @value='Update Course']")));
updateButton.click();
// Confirmation
System.out.println("Subject updated successfully to 'Kotlin'.");
} catch (Exception e) {
e.printStackTrace(); // Or log the exception
} finally {
// Close the browser
driver.quit();
}
}
}