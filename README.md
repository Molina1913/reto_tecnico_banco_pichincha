# 🔍 Reto técnico Saucedemo BP

Este proyecto implementa pruebas automatizadas utilizando **Serenity BDD**, usando el patrón de diseño **Screenplay**, *
*Java**, **Cucumber**  y **Gradle** para validar funcionalidades de Saucedemo.

## 🛠️ Tecnologías y herramientas

- [Java 17](https://www.oracle.com/java/)
- [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/)
- [Gradle](https://gradle.org/)
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
- Login
- Selección de productos
- Visualización de carrito de compras
- Realización del checkout