package com.um.controller;

import com.um.resource.PrivilegeResource;
import com.um.service.PrivilegeService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/um")
public class UserManagementController {

    @Resource
    private PrivilegeService privilegeService;

    @PostMapping(value = "/privileges")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PrivilegeResource privilegeResource) {
        privilegeService.create(privilegeResource);
    }

    @GetMapping(value = "/privileges")
    public List<PrivilegeResource> getAll() {
        return privilegeService.getAll();
    }
}
