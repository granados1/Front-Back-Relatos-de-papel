Feature: Agregar un Curso

  Scenario: Usuario ingresa a la aplicación de alumnos y agrega un nuevo curso
    Given el usuario abre la aplicación de alumnos
    And el usuario hace clic el tap "Cursos"
    And el usuario hace clic en el botón "Add Curso"
    And el usuario ingresa "MISSI" en el campo con id "Input_Nombre"
    And el usuario ingresa "60" en el campo con id "Input_DuracionHora"
    And el usuario elige "MASTER3" en el campo dropdown con id "Dropdown1"
    When el usuario hace clic en el botón "Save"
    Then el sistema muestra un mensaje de éxito "Curso agregado"