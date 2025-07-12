Feature: Agregar un Alumno

  Scenario: Usuario ingresa a la aplicación de alumnos y agrega un nuevo alumno
    Given el usuario abre la aplicación de alumnos
    And el usuario hace clic en el botón "Add Alumno"
    When el usuario ingresa el nombre "Luis Tst" en el campo con id "Input_Nombres"
    And el usuario ingresa el apellido "Tst" en el campo con id "Input_Apellidos"
    And el usuario ingresa el correo "alumno@gmail.com" en el campo con id "Input_Email"
    And el usuario ingresa la fecha "10/07/1993" en el campo con id "Input_FechaNacimiento"
    And el usuario hace clic en el botón "Guardar"
    Then el sistema muestra un mensaje de éxito "Alumno agregado correctamente"