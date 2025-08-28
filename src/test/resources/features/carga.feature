Feature: Registro de fichas clínicas
  @ficha
  Scenario: Carga de ficha clínica
    Given que el médico inició sesión
    When ingresa los datos de la ficha:
      | nombre      | Juan Perez                     |
      | diagnostico | Paralisis de la parálisis múltiple |
      | edad        | 66                           |
      | tratamiento | electro shock              |
    Then se muestra el mensaje "Ficha registrada con éxito."