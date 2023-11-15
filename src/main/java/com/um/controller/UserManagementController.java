package com.um.controller;

import com.um.resource.UserResource;
import com.um.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<List<UserResource>> getAll() {
        List<UserResource> allUsers = userService.getAll();
        CollectionModel entityModel = CollectionModel.of(allUsers);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
        entityModel.add(link.withRel("create-user"));

        return entityModel;
    }

    @GetMapping(value = "/greetings", produces = "application/json;charset=utf-8")
    public String greetings() {
        return userService.greetings();
    }

    @GetMapping(value = "/greetings", headers = "x-api-version=1")
    public String versioningV1() {
        return "header based version #1";
    }

    @GetMapping(value = "/greetings", headers = "x-api-version=2")
    public String versioningV2() {
        return "header based version #2";
    }
}
