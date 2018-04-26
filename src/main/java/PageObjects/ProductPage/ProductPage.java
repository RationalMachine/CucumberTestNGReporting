package PageObjects.ProductPage;

import PageObjects.CommercePage.CommercePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends CommercePage {

    private WebDriver driver;
    private WebElement elementName;
    private String printedMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@id='dataVoice-ethernet']")
    public WebElement ethernet;

    @FindBy(xpath = "//a[contains(text(),'Ethernet Hub')]")
    public WebElement ethernetHub;

    @FindBy(xpath = "//td[contains(text(),'Cancel Configuration')]")
    public WebElement cancelConfiguration;

    @FindBy(xpath = "//input[@id='siteAddressAEnd']")
    public WebElement addressEntry;

    @FindBy(xpath = "//td[contains(text(),'Check Connectivity')]")
    public WebElement checkConnectivity;

    @FindBy(xpath = "//span[@class='collapsed']")
    public WebElement collapseAddressDetails;

    @FindBy(xpath = "(//input[contains(@id,'premiseNumberAEnd')])[2]")
    public WebElement buildingNumberField;

    @FindBy(xpath = "//a[@id='update']")
    public WebElement updateButton;

    @FindBy(xpath = "(//p)[2]")
    public WebElement warningMsgBuildingNumber;

    public void clearFieldEntry(WebElement element){
        this.elementName = element;
        element.clear();
    }

    public String getWarningMessage(WebElement element){
        this.printedMessage = element.getAttribute("textContent");
        return printedMessage;
    }

    public void addProductPageProduct(String productName){
        switch (productName){
            case "hub":
                Actions actions = new Actions(driver);
                actions.moveToElement(ethernet).moveToElement(ethernetHub).click().perform();
                break;
        }
    }
}