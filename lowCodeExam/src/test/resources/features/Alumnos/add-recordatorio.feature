Feature: Agregar una Categoria

  Scenario: Usuario ingresa a la aplicación Tareas y agrega una categoria de recordatorio
    Given el usuario abre la aplicación de Tareas
    And el usuario hace clic el tap "Categorias"
    And el usuario hace clic en el botón "Add Categoria"
    And el usuario ingresa el Nombre "Categoria" en el campo con id "Input_Nombre"
    And el usuario elige "Verde" en el campo dropdown con id "Dropdown1"
    When el usuario hace clic en el botón "Save"
    Then el sistema muestra un mensaje de éxito "Categoria guardada"