package com.um.resource;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserResource(
        @NotNull
        @Size(min = 5, max = 30, message = "name should be at least 5 characters")
        String name,

        @Email
        String email,

        @Past
        LocalDate birthDate) {

}
