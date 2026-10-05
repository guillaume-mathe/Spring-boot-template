package com.example.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(GreetingController.class)
@Import(GreetingService.class)
class GreetingControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    void getReturnsHelloWorld() {
        client.get().uri("/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Greeting.class).isEqualTo(new Greeting("Hello World"));
    }

    @Test
    void postReturnsHelloName() {
        client.post().uri("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new GreetingRequest("Alice"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Greeting.class).isEqualTo(new Greeting("Hello Alice"));
    }

    @Test
    void postRejectsBlankName() {
        client.post().uri("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new GreetingRequest(" "))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void postRejectsMissingName() {
        client.post().uri("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{}")
                .exchange()
                .expectStatus().isBadRequest();
    }
}
