package com.um.controller;

import com.um.resource.PrivilegeResource;
import com.um.service.PrivilegeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vm")
public class UserManagementController {

    @Resource
    private PrivilegeService privilegeService;

    @GetMapping(value = "/test")
    public void test(@RequestBody PrivilegeResource privilegeResource) {
        privilegeService.create(privilegeResource);
    }
}
