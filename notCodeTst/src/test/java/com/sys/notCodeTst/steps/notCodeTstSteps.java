package com.sys.notCodeTst.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;



import static org.junit.Assert.*;

public class notCodeTstSteps {
    WebDriver driver;

    @Given("el usuario abre la aplicación de alumnos")
    public void abrirFormulario() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://personal-takh2lqy.outsystemscloud.com/UnirClase/Alumnoes");
        /*Esperar po 10 segundos*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Alumno')]")));
    }

    @And("el usuario hace clic en el botón {string}")
    public void el_usuario_hace_clic_en(String textoBoton) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'" + textoBoton + "')]")
        ));
        boton.click();
    }

    @When("el usuario ingresa el nombre {string} en el campo con id {string}")
    public void el_usuario_ingresa_en_el_campo_nombre_con_id(String texto, String idCampo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idCampo)));
        campo.sendKeys(texto);
    }

    @And("el usuario ingresa el apellido {string} en el campo con id {string}")
    public void el_usuario_ingresa_en_el_campo_apellido_con_id(String texto, String idCampo) {
        WebElement campo = driver.findElement(By.id(idCampo));
        campo.sendKeys(texto);
    }

    @And("el usuario ingresa el correo {string} en el campo con id {string}")
    public void el_usuario_ingresa_en_el_campo_correo_con_id(String texto, String idCampo) {
        WebElement campo = driver.findElement(By.id(idCampo));
        campo.sendKeys(texto);
    }

    @And("el usuario ingresa la fecha {string} en el campo con id {string}")
    public void el_usuario_ingresa_en_el_campo_fecha_nacimiento_con_id(String texto, String idCampo) {
        WebElement campo = driver.findElement(By.id(idCampo));
        campo.sendKeys(texto);
    }

    /*@And("el usuario hace clic en {string}")
    public void el_usuario_hace_clic_en_el_boton_guardar(String textoBoton) {
        WebElement boton = driver.findElement(By.xpath("//button[contains(text(),'Guardar')]"));
        boton.click();
    }*/

    @Then("el sistema muestra un mensaje de éxito {string}")
    public void el_sistema_muestra_un_mensaje_de_exito(String textoEsperado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeExito = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".feedback-message-text")
        ));
        assertTrue(mensajeExito.getText().contains(textoEsperado));
        driver.quit();
    }

    @And("el usuario escribe {string} en el campo con id {string}")
    public void el_usuario_escribe_en_el_campo_busqueda_con_id(String texto, String idCampo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idCampo)));
        campo.sendKeys(texto);
    }

    @And("el usuario encuentra y hace en la tabla el nombre {string}")
    public void el_usuario_encuentra_y_hace_en_la_tabla_el_nombre(String texto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement enlaceNombre = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table//a[span[contains(text(), '" + texto + "')]]")
        ));
        enlaceNombre.click();

        /*
        List<WebElement> enlaces = driver.findElements(By.xpath("//table//a[span[contains(text(), '" + texto + "')]]"));
            for (WebElement enlace : enlaces) {
                if (enlace.isDisplayed() && enlace.isEnabled()) {
                    enlace.click();
                    //
                    break;
                }
            }
        * */
    }

    @And("el usuario hace clic el tap {string}")
    public void el_usuario_hace_clic_el_tap(String textoBoton) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'" + textoBoton + "')]")
        ));
        boton.click();
    }

    @And("el usuario ingresa {string} en el campo con id {string}")
    public void el_usuario_ingresa_n_con_id_generico(String texto, String idCampo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idCampo)));
        campo.sendKeys(texto);
    }

    @And("el usuario elige {string} en el campo dropdown con id {string}")
    public void el_usuario_elige_en_el_dropdown_con_id(String texto, String idCampo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idCampo)));
        Select select = new Select(dropdown);
        select.selectByVisibleText(texto);
        //select.selectByValue("2");
        //select.selectByIndex(2);
    }

    @And("el usuario marca aprobado en el campo con id {string}")
    public void el_usuario_marca_aprobado_en_el_campo_con_id(String idCampo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idCampo)));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @And("el usuario encuentra y valida el nombre {string}")
    public void el_usuario_encuentra_y_valida_el_nombre(String texto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enlaceNombre = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table//a[span[contains(text(), '" + texto + "')]]")
        ));
        String textoEnlace = enlaceNombre.getText();
        assertEquals(texto, textoEnlace);
        driver.quit();
    }

    @And("el usuario no encuentra el registro {string}")
    public void el_usuario_encuentra_y_valida_no_encontro_el_nombre(String texto) {
        List<WebElement> enlaces = driver.findElements(By.xpath("//table//a[span[contains(text(), '" + texto + "')]]"));
        assertTrue("El nombre '" + texto + "' no fue encontrado en la tabla.", enlaces.isEmpty());
        driver.quit();
    }

    @Then("el usuario recorre la tabla para encontrar {string}")
    public void el_usuario_recorre_la_tabla(String texto) {
        boolean encontrado = false;
        List<WebElement> enlaces = driver.findElements(By.xpath("//table//a[span[contains(text(), '" + texto + "')]]"));
        for (WebElement enlace : enlaces) {
            if (enlace.isDisplayed() && enlace.isEnabled()) {
                encontrado = true;
                enlace.click();
                break;
            }
        }
        if (!encontrado) {
            assertTrue("No se encontró el registro '" + texto + "' en la tabla.", !encontrado);
            driver.quit();
        }
    }

    @Then("el usuario no encuentra la inscripción {string}")
    public void el_usuario_encuentra_la_inscripcion(String texto) {
        List<WebElement> enlaces = driver.findElements(
                By.xpath("//table//a[span[contains(text(), '" + texto + "')]]")
        );
        assertTrue("El nombre '" + texto + "' no fue encontrado en la tabla.", enlaces.isEmpty());
        WebElement mensaje = driver.findElement(By.xpath("//span[@role='status']"));
        assertEquals("No items to show...", mensaje.getText());
        driver.quit();
    }


    @And("el usuario espera {int} segundos")
    public void esperarSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La espera fue interrumpida", e);
        }
    }

}
