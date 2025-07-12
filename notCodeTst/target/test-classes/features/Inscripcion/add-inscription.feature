Feature: Agregar una inscrpción

  Scenario: Usuario ingresa a la aplicación de alumnos y agrega un nuevo alumno
    Given el usuario abre la aplicación de alumnos
    And el usuario hace clic en el botón "Add Alumno"
    When el usuario ingresa el nombre "Luis Tst" en el campo con id "Input_Nombres"
    And el usuario ingresa el apellido "Tst" en el campo con id "Input_Apellidos"
    And el usuario ingresa el correo "alumno@gmail.com" en el campo con id "Input_Email"
    And el usuario ingresa la fecha "10/07/1993" en el campo con id "Input_FechaNacimiento"
    And el usuario hace clic en el botón "Guardar"
    Then el sistema muestra un mensaje de éxito "Alumno agregado correctamente"

  Scenario: Usuario ingresa a la aplicación de alumnos y agrega un nuevo curso
    Given el usuario abre la aplicación de alumnos
    And el usuario hace clic el tap "Cursos"
    And el usuario hace clic en el botón "Add Curso"
    And el usuario ingresa "MISSI" en el campo con id "Input_Nombre"
    And el usuario ingresa "60" en el campo con id "Input_DuracionHora"
    And el usuario elige "MASTER3" en el campo dropdown con id "Dropdown1"
    When el usuario hace clic en el botón "Save"
    Then el sistema muestra un mensaje de éxito "Curso agregado"

  Scenario: Usuario ingresa a la aplicación de alumnos y agrega una nueva inscripción
    Given el usuario abre la aplicación de alumnos
    And el usuario hace clic el tap "Inscripciones"
    And el usuario hace clic en el botón "Add Inscripcion"
    And el usuario marca aprobado en el campo con id "Checkbox1"
    And el usuario elige "MISSI" en el campo dropdown con id "Dropdown1"
    And el usuario elige "Luis Tst" en el campo dropdown con id "Dropdown2"
    When el usuario hace clic en el botón "Save"
    Then el usuario escribe "Luis Tst" en el campo con id "Input_TextVar"
    And el usuario encuentra y valida el nombre "Luis Tst"