Feature: Validar el endpoint de documentación OpenAPI

  Scenario: Obtener la documentación del API
    Given el servicio está disponible
    When hago una petición GET a "/V1/GetAllAlumnos"
    Then el código de respuesta debe ser 200
    And la respuesta debe contener el alumno con nombre "Alumno 1" y email "a2@gmail.com"