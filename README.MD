🧪 Proyecto de Automatización de Pruebas Clínicas con Cucumber + Selenium
Este proyecto implementa un framework de automatización de pruebas para un sistema de gestión clínica utilizando Behavior-Driven Development (BDD) con Cucumber, Selenium WebDriver y Java.
Incluye la validación de flujos críticos como inicio de sesión, registro de fichas médicas y validación de reglas de negocio.

📁 Estructura del Proyecto
kibernum-clinica-bdd/
│
├── src/
│   └── test/
│       ├── java/
│       │   └── kibernum/
│       │       └── clinica/
│       │           ├── hooks/
│       │           │   ├── DriverHolder.java
│       │           │   └── Hooks.java
│       │           ├── pages/
│       │           │   ├── BasePage.java
│       │           │   ├── LoginPage.java
│       │           │   └── RegistroPacientePage.java
│       │           ├── steps/
│       │           │   ├── LoginSteps.java
│       │           │   └── RegistroPacienteSteps.java
│       │           └── RunCucumberTest.java
│       │
│       └── resources/
│           └── features/
│               ├── sesion.feature
│               ├── carga.feature
│               └── reglas.feature
│
├── target/
│   └── cucumber-report.html
│
├── pom.xml
└── README.md
🚀 Requisitos
Java 8 o superior

Maven 3.6+

Navegador Firefox (por defecto) o Chrome

⚙️ Configuración y Ejecución
1. Clonar o descomprimir el proyecto
2. Compilar y ejecutar las pruebas con Maven
bash
mvn test
3. Ejecutar por tags específicos
bash
mvn test -Dcucumber.filter.tags="@login"
mvn test -Dcucumber.filter.tags="@ficha"
mvn test -Dcucumber.filter.tags="@reglas"
4. Ver reportes de ejecución
Después de ejecutar las pruebas, se genera un reporte en HTML en:
target/cucumber-report.html

📋 Historias de Usuario Implementadas
1. Inicio de Sesión de Médico
Escenario: Login exitoso con credenciales válidas

Escenario: Mensaje de error con credenciales inválidas

2. Carga de Ficha Clínica
Ingreso de nombre, diagnóstico, edad y tratamiento

Validación de mensaje de confirmación

3. Validación de Reglas Clínicas
Diagnóstico automático "Pediátrico" para menores de 12 años

Tratamiento obligatorio para guardar la ficha

🧩 Características Técnicas Implementadas
✅ Patrón Page Object Model (POM)

✅ WebDriverManager para gestión automática de drivers

✅ Hooks para inicialización y cierre del navegador

✅ Screenshots automáticos en caso de fallo

✅ Tags para organizar y filtrar escenarios

✅ Scenario Outline y DataTable para parametrización

✅ Reportes HTML con Cucumber

🧪 Ejemplos de Escenarios Gherkin
Ejemplo 1: Login exitoso
gherkin
@login
Scenario: Inicio de sesión exitoso
  Given que el médico abre la página de inicio de sesión
  When ingresa el usuario "doctor" y la contraseña "password"
  Then el médico accede a la web "https://clinica-modular.netlify.app/ficha.html"
Ejemplo 2: Regla pediátrica
gherkin
@reglas
Scenario Outline: Validación de reglas clínicas
  Given que el médico inició sesión
  When ingresa el nombre "<name>", el diagnóstico "<diagnosis>", la edad <age> y el tratamiento "<treatment>"
  Then se muestra el mensaje '<message>'
