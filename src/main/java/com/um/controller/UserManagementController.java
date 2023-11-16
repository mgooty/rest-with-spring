package com.um.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.um.resource.UserResource;
import com.um.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    @GetMapping("/{id}")
    public MappingJacksonValue get(@PathVariable Long id) {
        UserResource userResource = userService.get(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userResource);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "email");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping
    public CollectionModel<List<UserResource>> getAll() {
        List<UserResource> allUsers = userService.getAll();

//        hateoas
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
