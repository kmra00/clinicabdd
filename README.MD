ACTIVIDAD MODULAR 5 - CLINICA

KEVIN MORENO ROMAN

# Proyecto de Automatización - Sistema de Gestión Clínica

## Requisitos
- Java 11 o superior
- Maven 3.6 o superior
- Navegador Firefox

## Ejecución de Pruebas

### Todas las pruebas
```bash
mvn test

# Solo pruebas de login
mvn test -Dcucumber.filter.tags="@login"

# Solo pruebas de fichas clínicas
mvn test -Dcucumber.filter.tags="@ficha"

# Solo pruebas de reglas clínicas
mvn test -Dcucumber.filter.tags="@reglas"