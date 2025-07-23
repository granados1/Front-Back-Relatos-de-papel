package com.out.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

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
