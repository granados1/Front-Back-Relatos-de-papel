Feature: Eliminar un curso

  Scenario: Usuario ingresa a la aplicación de alumnos y elimina un nuevo curso
    Given el usuario abre la aplicación de alumnos
    And el usuario hace clic el tap "Cursos"
    And el usuario escribe "MISSI" en el campo con id "Input_TextVar"
    And el usuario encuentra y hace en la tabla el nombre "MISSI"
    When el usuario hace clic en el botón "Eliminar"
    Then el sistema muestra un mensaje de éxito "Curso eliminado"