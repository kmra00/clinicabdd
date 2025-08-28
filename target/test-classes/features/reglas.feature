Feature: Validación de reglas clínicas
  @reglas
  Scenario Outline: Validación de reglas clínicas
    Given que el médico inició sesión
    When ingresa el nombre "<name>", el diagnóstico "<diagnosis>", la edad <age> y el tratamiento "<treatment>"
    Then se muestra el mensaje '<message>'

    Examples:
      | name        | diagnosis   | age | treatment   | message                                                        |
      | Eliza Gonzalez | Otro        | 9  | Medicamento | Los menores de 12 años, el diagnóstico debe ser "Pediátrico". |
      | Eliza Gonzalez | Pediátrico  | 11  |             | El tratamiento es obligatorio para guardar la ficha.           |