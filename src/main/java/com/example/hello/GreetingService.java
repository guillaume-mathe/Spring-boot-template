package com.example.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class GreetingService {

    public Mono<Greeting> greet(String name) {
        return Mono.fromSupplier(() -> new Greeting("Hello " + name))
                .doOnNext(greeting -> log.debug("Greeting: {}", greeting));
    }
}
