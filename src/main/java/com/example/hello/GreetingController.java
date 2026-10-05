package com.example.hello;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping
    public Mono<Greeting> hello() {
        return greetingService.greet("World");
    }

    @PostMapping
    public Mono<Greeting> hello(@Valid @RequestBody Mono<GreetingRequest> request) {
        return request.map(GreetingRequest::name).flatMap(greetingService::greet);
    }
}
