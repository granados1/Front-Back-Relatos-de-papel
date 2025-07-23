package com.out.lowCodeExam.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class notCodeTstSteps {
    WebDriver driver;

    @Given("el usuario abre la aplicación de Tareas")
    public void abrirFormulario() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://personal-takh2lqy.outsystemscloud.com/ExamenUnir/Tareas");
        /*Esperar po 10 segundos*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Tarea')]")));
    }

    @And("el usuario hace clic el tap {string}")
    public void el_usuario_hace_clic_el_tap(String textoBoton) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'" + textoBoton + "')]")
        ));
        boton.click();
    }

    @And("el usuario hace clic en el botón {string}")
    public void el_usuario_hace_clic_en(String textoBoton) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'" + textoBoton + "')]")
        ));
        boton.click();
    }

    @And("el usuario ingresa el Nombre {string} en el campo con id {string}")
    public void el_usuario_ingresa_en_el_campo_nombre_con_id(String texto, String idCampo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idCampo)));
        campo.sendKeys(texto);
    }

    @And("el usuario elige {string} en el campo dropdown con id {string}")
    public void el_usuario_elige_en_el_dropdown_con_id(String texto, String idCampo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idCampo)));
        Select select = new Select(dropdown);
        select.selectByVisibleText(texto);
    }

    @And("el usuario ingresa la fecha {string} en el campo con id {string}")
    public void el_usuario_ingresa_en_el_campo_fecha_nacimiento_con_id(String texto, String idCampo) {
        WebElement campo = driver.findElement(By.id(idCampo));
        campo.sendKeys(texto);
    }

    @Then("el sistema muestra un mensaje de éxito {string}")
    public void el_sistema_muestra_un_mensaje_de_exito(String textoEsperado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeExito = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".feedback-message-text")
        ));
        assertTrue(mensajeExito.getText().contains(textoEsperado));
        driver.quit();
    }

}
