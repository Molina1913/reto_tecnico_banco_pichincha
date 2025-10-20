# 🔍 Reto técnico Saucedemo y Pet store BP

Este proyecto implementa pruebas automatizadas utilizando Serenity BDD, aplicando el patrón de diseño Screenplay, junto con Java 17, Cucumber y Gradle. Incluye automatización de pruebas tanto para interfaz de usuario (UI) como para servicios REST (API).

## 🛠️ Tecnologías y herramientas

- [Java 17](https://www.oracle.com/java/)
- [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/)
- [Gradle](https://gradle.org/)
- Serenity Rest
- JUnit
- Cucumber
- IntelliJ
- Git & GitHub

## 🚀 Cómo ejecutar las pruebas

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Molina1913/reto-t-cnico-banco-pichincha.git

2. Asegúrate de tener Java 17 instalado y JAVA_HOME configurado.

3. Ejecuta las pruebas:
   ```bash
   ./gradlew clean test aggregate

4. Abre el reporte en tu navegador:
    ```bash
    target/site/serenity/index.html

## 📁 Estructura del proyecto

    ```├── src
       │ ├── main
       │ │ │ └── ... (interactions, questions, tasks, util, ui)
       │ ├── test
       │ │ ├── java
       │ │ │ └── ... (tests, steps, features)
       ├── build.gradle
       └──README.md


## ✅ Funcionalidades automatizadas
UI Web (Saucedemo)
- Login
- Selección de productos
- Visualización de carrito de compras
- Realización del checkout

API / Servicios (Pet Store)

- Creación de registros
- Consultas de registros
- Validación de respuesta de servicios
- Verificación de status codes y estructuras de respuesta

## 🧪 Estructura de pruebas para API

La estructura de pruebas para servicios sigue el mismo patrón Screenplay:

- Tasks: Realizan peticiones (GET, POST, etc.).
- Questions: Validan el contenido de las respuestas.
- Models: Representan los datos que se envían o reciben.


---------------------------------------------------------------------------------------------------------------------------------------

# PRUEBA DE CARGA: Servicio de Login

## Tecnologías utilizadas:
- k6 v1.3.0
- Sistema operativo: Windows
- Formato CSV para datos de entrada

## Instrucciones para ejecutar:

1. Clona el repositorio:
   git clone https://github.com/Molina1913/reto_tecnico_banco_pichincha
   cd login-test-k6

2. Instala k6 si no lo tienes:
   Ver instrucciones en: https://k6.io/docs/getting-started/installation/

3. Ejecuta el test:
   k6 run script.js

4. Verifica los resultados en consola o en el archivo `results.json` si usaste `--out`.

## Estructura:
- script.js: Script principal de la prueba
- users.csv: Archivo con usuarios y contraseñas
- conclusiones.txt: Resultados de la prueba