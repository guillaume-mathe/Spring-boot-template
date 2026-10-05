package com.example.hello;

import jakarta.validation.constraints.NotBlank;

public record GreetingRequest(@NotBlank String name) {
}
