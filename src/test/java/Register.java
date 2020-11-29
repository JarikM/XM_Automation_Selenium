import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Register extends PageObject{
////////////////////////// WEB FORM STRING VALUES ///////////////////////////////////////////////////////////////////////////
    private final String FIRST_NAME = "Test1";
    private final String LAST_NAME = "Test2";
    private final String CITY = "Belgrade";
    private final String STATE = "Serbia";
    private final String STREET_NAME = "Gramsijeva";
    private final String STREET_NUMBER = "4a";
    private final String POSTAL_CODE = "11070";
    private final String PHONE_NUMBER = "652061264";
    private final String EMAIL = "davidhadzic@test.com";
    private final String PASSWORD = "Test12345";



    ////////////////////////// BUTTONS AND CHECKBOXES ///////////////////////////////////////////////////////////////////////////

    @FindBy (xpath = "//button[text()='CONTINUE']")
    private WebElement btnCookiesContinue;

    @FindBy(xpath = "//a[@href = 'https://partners.xm.com']")
    private WebElement btnPartnerships;

    @FindBy(xpath = "//a[@href = 'https://partners.xm.com/registration']")
    private WebElement btnRegister;

    @FindBy(id = "submit-btn")
    private WebElement submit_button;

    @FindBy(id = "agree_terms")
    private WebElement agreeTerms;

    ////////////////////////// PERSONAL DETAILS ///////////////////////////////////////////////////////////////////////////

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='dob_day']/option[3]")
    private WebElement dobDay;

    @FindBy(xpath = "//*[@id='dob_month']/option[2]")
    private WebElement dobMonth;

    @FindBy(xpath = "//*[@id=\"dob_year\"]/option[8]")
    private WebElement dobYear;

    ////////////////////////// ADDRESS DETAILS ///////////////////////////////////////////////////////////////////////////

    @FindBy(xpath = "//*[@id=\"country\"]/option[175]")
    private WebElement country;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "state_region")
    private WebElement state;

    @FindBy(id = "street_name")
    private WebElement streetName;

    @FindBy(id = "street_number")
    private WebElement streetNumber;

    @FindBy(id = "postal_zip")
    private WebElement postalCode;


    ///////////////////////// CONTACT DETAILS //////////////////////////////////////////////////////////////////////////////

    @FindBy(xpath = "//*[@id=\"phoneNumberCountryPrefix\"]/option[190]")
    private WebElement phoneCode;

    @FindBy(id = "phone_number")
    private WebElement phoneNumber;

    @FindBy(id = "email")
    private WebElement email;

   ////////////////////////// ACCOUNT DETAILS ////////////////////////////////////////////////////////////////////////////////

    @FindBy(xpath = "//*[@id=\"preferred_language\"]/option[2]")
    private WebElement preferredLanguage;

    ///////////////////////// ACCOUNT PASSWORD /////////////////////////////////////////////////////////////////////////////

    @FindBy(id = "account_password")
    private WebElement password;

    @FindBy(id = "account_password_confirmation")
    private WebElement passwordConfirmation;



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public Register(WebDriver driver) {
        super(driver);
    }
    public void btnCookiesContinue(){
        this.btnCookiesContinue.click();
    }

    public void PartnershipsPage(){
        this.btnPartnerships.click();
    }
    public void RegisterPage(){
        this.btnRegister.click();
    }
    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void pageTitle(String expectedTitle){
        String actualTitle = driver.getTitle();

    if (expectedTitle.equals(actualTitle)){
        System.out.println("Page with expected title is visited \n");

    }
    else {
        System.out.println("Page with expected title is NOT visited \n");
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    }

    public void pageUrl(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Page with expected URL is visited \n");
        }
        else {
            System.out.println("Page with expected URL is NOT visited \n");
            System.out.println(actualUrl);
            Assert.assertEquals(actualUrl, expectedUrl);
        }

    }


    public void name(){
        this.firstName.sendKeys(FIRST_NAME);
        this.lastName.sendKeys((LAST_NAME));
    }

    public void BirthDay(){
        this.dobDay.click();
        this.dobMonth.click();
        this.dobYear.click();
    }

    public void Address(){
        this.country.click();
        this.city.sendKeys(CITY);
        this.state.sendKeys(STATE);
        this.streetName.sendKeys(STREET_NAME);
        this.streetNumber.sendKeys(STREET_NUMBER);
        this.postalCode.sendKeys(POSTAL_CODE);
    }

    public void Contact(){
        this.phoneCode.click();
        this.phoneNumber.sendKeys(PHONE_NUMBER);
        this.email.sendKeys(EMAIL);
    }

    public void AccountDetails(){
        this.preferredLanguage.click();
    }

    public void AccountPassword(){
        this.password.sendKeys(PASSWORD);
        this.passwordConfirmation.sendKeys(PASSWORD);
    }


    public void Submit(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit_button);
        this.submit_button.click();
    }

    public void AgreeTerms(){
        this.agreeTerms.click();
    }
}