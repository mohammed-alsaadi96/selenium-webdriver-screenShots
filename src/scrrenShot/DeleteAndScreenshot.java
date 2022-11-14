package scrrenShot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DeleteAndScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\edge driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("file:///C:/Users/Admin/Desktop/Qa-automation-7thmar/index.html");

		List<WebElement> students = driver.findElements(By.tagName("option"));

		for (int i = 0; i < students.size(); i++) {

			if (i % 2 != 0) {

				students.get(i).click();
				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

			} else {

				System.out.println(" bay bay " + students.get(i + 1).getText());
			}

		}

		driver.findElement(By.xpath("//*[@id=\"selectNow\"]")).click();
		Thread.sleep(2000);
		Date currentDate = new Date();
		String theActualDate = currentDate.toString().replace(":", "-");

		TakesScreenshot src = ((TakesScreenshot) driver);
		File srcFile = src.getScreenshotAs(OutputType.FILE);
		File destination = new File(".//mypictures/" + theActualDate + ".png");
		FileUtils.copyFile(srcFile, destination);

	}

}
