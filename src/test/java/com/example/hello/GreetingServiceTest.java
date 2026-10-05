package com.example.hello;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class GreetingServiceTest {

    private final GreetingService service = new GreetingService();

    @Test
    void greetsByName() {
        StepVerifier.create(service.greet("Alice"))
                .expectNext(new Greeting("Hello Alice"))
                .verifyComplete();
    }
}
