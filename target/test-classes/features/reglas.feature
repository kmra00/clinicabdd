Feature: Validación de reglas clínicas
  @reglas
  Scenario Outline: Validación de reglas clínicas
    Given que el médico inició sesión
    When ingresa el nombre "<name>", el diagnóstico "<diagnosis>", la edad <age> y el tratamiento "<treatment>"
    Then se muestra el mensaje '<message>'

    Examples:
      | name        | diagnosis   | age | treatment   | message                                                        |
      | Pepa Gonzalez | Otro        | 11  | Medicamento | Para menores de 12 años, el diagnóstico debe ser "Pediátrico". |
      | Pepa Gonzalez | Pediátrico  | 10  |             | El tratamiento es obligatorio para guardar la ficha.           |