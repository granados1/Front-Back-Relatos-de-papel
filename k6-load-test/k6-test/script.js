// k6-test/script.js
import http from "k6/http";
import { group, check, sleep } from "k6";

const BASE_URL = "http://localhost:8081";
const SLEEP_DURATION = 0.1;

export default function() {
    let libroId = null;

    group("Crear libro (POST /books)", () => {
        let body = {
            "titulo": "El Quijote",
            "autor": "Cervantes",
            "fechapublicacion": "1605-01-16",
            "categoria": "Ficción",
            "isbn": "9781234567890",
            "precio": 19.99,
            "calificacion": 5,
            "visible": true,
            "stock": 10
        };
        let params = {headers: {"Content-Type": "application/json", "Accept": "*/*"}};
        let res = http.post(`${BASE_URL}/books`, JSON.stringify(body), params);

        check(res, {
            "Libro creado": (r) => r.status === 200 || r.status === 201
        });

        // Obtener el id del libro creado (ajusta según la respuesta de tu API)
        if (res.status === 200 || res.status === 201) {
            let data = res.json();
            libroId = data.id;
        }
        sleep(SLEEP_DURATION);
    });

    if (libroId) {
        group("Obtener libro (GET /books/{id})", () => {
            let res = http.get(`${BASE_URL}/books/${libroId}`);
            check(res, {
                "GET libro OK": (r) => r.status === 200
            });
            sleep(SLEEP_DURATION);
        });

        group("Actualizar libro (PATCH /books/{id})", () => {
            let patchBody = { "precio": 17.99 };
            let params = {headers: {"Content-Type": "application/json", "Accept": "*/*"}};
            let res = http.patch(`${BASE_URL}/books/${libroId}`, JSON.stringify(patchBody), params);
            check(res, {
                "PATCH libro OK": (r) => r.status === 200
            });
            sleep(SLEEP_DURATION);
        });
    } else {
        console.error("No se pudo obtener el id del libro creado.");
    }
}