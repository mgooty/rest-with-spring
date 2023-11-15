package com.um.controller;

import com.um.resource.UserResource;
import com.um.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/um/users")
public class UserManagementController {

    @Resource
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid UserResource userResource) {
        userService.create(userResource);
    }

    @GetMapping
    public List<UserResource> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/greetings", produces = "application/json;charset=utf-8")
    public String greetings() {
        return userService.greetings();
    }
}
