# Puebas de carga con K6
Aplicación que se encarga de probar el rendimiento del sistema.

**Pasos:**
1. **Crear carpeta k6-load-test:**
    - En la terminal, navega a la carpeta donde deseas crear el proyecto.
    - Ejecuta el comando: `mkdir k6-load-test && cd k6-load-test`.
2. **Ejecutar comado para crear el script de pruebas**
    - Ejecuta el comando: `java -jar C:\tools\openapi-generator-cli-5.4.0.jar generate -i http://localhost:8081/v3/api-docs -g k6 -o ./k6-test --skip-validate-spec`.
    - Valor de `-i` debe ser la URL del API que se desea probar.
    - Valor de `-o` es la carpeta donde se guardará el script de pruebas.
    - Valor de `-g` es el generador que se utilizará, en este caso, `k6`.
    - Valor de `--skip-validate-spec` es para omitir la validación del especificación OpenAPI.
    - El comando generará un script de pruebas en la carpeta `k6-test`.
3. **Ejecutar pruebas de carga**
    - En la terminal, navega a la carpeta `k6-test`.
    - Ejecuta el comando: `k6 run script.js`.
    - Esto ejecutará las pruebas de carga definidas en el script generado y mostrará los resultados en la terminal.
    - Desde la raíz del proyecto, puedes ejecutar el comando: `k6 run k6-test/script.js` para ejecutar las pruebas de carga desde cualquier ubicación.
    - Si deseas ejecutar las pruebas de carga con un número específico de usuarios, puedes usar el comando: `k6 run --vus 10 --duration 30s k6-test/script.js`.
    - Esto ejecutará las pruebas con 10 usuarios virtuales durante 30 segundos.
    - Si desea exportar los resultados a un archivo, puedes usar el comando: `k6 run --vus 100 --duration 30s ./k6-test/script.js --out csv=./k6-test/salida.csv`.
    - Esto ejecutará las pruebas con 100 usuarios virtuales durante 30 segundos y exportará los resultados a un archivo CSV llamado `salida.csv` en la carpeta `k6-test`.
    - Puedes cambiar csv por json.