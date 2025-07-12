Feature: Eliminar un Alumno

  Scenario: Usuario ingresa a la aplicación de alumnos y agrega un nuevo alumno
    Given el usuario abre la aplicación de alumnos
    And el usuario escribe "Luis Tst" en el campo con id "Input_TextVar"
    And el usuario encuentra y hace en la tabla el nombre "Luis Tst"
    When el usuario hace clic en el botón "Eliminar"
    Then el sistema muestra un mensaje de éxito "Alumno eliminado"