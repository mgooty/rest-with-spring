package com.um.resource;

import jakarta.validation.constraints.*;

public record PrivilegeResource(@NotNull @Size(min = 5, max = 30) String name, String description, @NotEmpty @Min(1) @Max(100) Integer priority) {

}
