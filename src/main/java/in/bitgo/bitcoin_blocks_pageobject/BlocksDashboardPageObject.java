package in.bitgo.bitcoin_blocks_pageobject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlocksDashboardPageObject {

	WebDriver driver;
	WebDriverWait wait;
	String actualHeadingValue;

	@FindBy(css = ".transactions > h3")
	private WebElement heading;

	@FindBy(css = ".transaction-box> .ins-and-outs")
	private List<WebElement> tnxClassElemenst;

	@FindBy(css = ".vins")
	private List<WebElement> inputElements;

	@FindBy(css = ".vouts")
	private List<WebElement> outputElemts;

	public BlocksDashboardPageObject(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);

	}

	public void fetchAndValidateHeading() {

		actualHeadingValue = heading.getText();
		assertEquals(actualHeadingValue, "25 of 2875 Transactions");

	}

	public void fetchAndValidateTnxHashMatch() {

		for (WebElement element : tnxClassElemenst) {

			List<WebElement> inputs = element.findElements(By.cssSelector(".vins> .vin"));
			List<WebElement> outputs = element.findElements(By.cssSelector(".vouts> .vout"));

			int inputCount = inputs.size();
			int outputCount = outputs.size();

			
			if (inputCount == 1 && outputCount == 2) {
				System.out.println(inputCount + "  " + outputCount);
				System.out.println("Please find the transaction hash of the transactions which has exactly 1 input and 2 outputs ");
						
				  System.out.println("Input Value: " + inputs.get(0).getText());
			        System.out.println("Output Values:");
			        for (WebElement output : outputs) {
			            System.out.println(output.getText());
			        }
			  	
			
			
			}

		}
		long tnxCounts = tnxClassElemenst.stream().count();
		System.out.println("total tnxs are : " + tnxCounts);

	}

}
