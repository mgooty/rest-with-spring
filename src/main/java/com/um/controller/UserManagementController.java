package com.um.controller;

import com.um.resource.PrivilegeResource;
import com.um.service.PrivilegeService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/um")
public class UserManagementController {

    @Resource
    private PrivilegeService privilegeService;

    @PostMapping(value = "/test")
    public void test(@RequestBody @Valid PrivilegeResource privilegeResource) {
        privilegeService.create(privilegeResource);
    }
}
