package com.ejemplo.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class ApiSteps {

    private Response response;
    private int libroId;

    @Given("el servicio está disponible")
    public void el_servicio_esta_disponible() {
        baseURI = "https://personal-takh2lqy.outsystemscloud.com/UnirClase/rest";
    }

    @When("hago una petición GET a {string}")
    public void hago_una_peticion_get_a(String endpoint) {
        response = get(endpoint);
    }

    @Then("el código de respuesta debe ser {int}")
    public void el_codigo_de_respuesta_debe_ser(Integer statusCode) {
        assertThat(response.getStatusCode(), is(statusCode));
    }

    @And("la respuesta debe contener el alumno con nombre {string} y email {string}")
    public void la_respuesta_debe_contener_alumno(String nombre, String email) {
        String body = response.getBody().asString();
        assertThat("La respuesta no contiene el nombre esperado.", body, containsString(nombre));
        assertThat("La respuesta no contiene el email esperado.", body, containsString(email));
    }

}
