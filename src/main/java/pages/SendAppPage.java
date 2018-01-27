package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SendAppPage extends BasesPage {

@FindBy(name = "insured0_surname")
    WebElement insured_surname;

@FindBy(name = "insured0_name")
    WebElement insured_name;

@FindBy(name = "insured0_birthDate")
    WebElement insured_birthDate;

@FindBy(name = "surname")
    WebElement surname;

@FindBy(name = "middlename")
    WebElement middlename;

@FindBy(name = "name")
    WebElement name;

@FindBy(name = "birthDate")
    WebElement birthDate;

@FindBy (xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
public WebElement sendButton;

public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        }

public void fillField(String fieldName, String value){
        switch (fieldName){
        case  "Фамилия":
        fillField(surname, value);
        break;
        case  "Имя":
        fillField(name, value);
        break;
        case  "Отчество":
        fillField(middlename, value);
        break;
        case  "Фамилия2":
        fillField(insured_surname, value);
        break;
        case  "Имя2":
        fillField(insured_name, value);
        break;
        case  "Дата рождения":
        fillField(insured_birthDate, value);
        break;
        case  "Дата рождения2":
        fillField(birthDate, value);
        break;
default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
        }

public void checkFields(){
        assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Иванов", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.name("birthDate")).getAttribute("value"));
        }
public void checkError(){
        assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText());
        }
}
