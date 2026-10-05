# hello

Reactive Hello World on Spring Boot 4.1.1 / Java 25 (WebFlux, Lombok, records, Actuator, Prometheus).

## Run

```sh
./mvnw spring-boot:run
```

| Request | Response |
|---|---|
| `GET /hello` | `{"message":"Hello World"}` |
| `POST /hello` `{"name":"Alice"}` | `{"message":"Hello Alice"}` (400 if `name` is blank) |
| `GET /actuator/health` | health (plus `/liveness`, `/readiness` probes) |
| `GET /actuator/prometheus` | Prometheus metrics |

## Test

```sh
./mvnw verify
```
