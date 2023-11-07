package com.um.service;

import com.um.model.Privilege;
import com.um.repository.PrivilegeRepository;
import com.um.resource.PrivilegeResource;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService {

    @Resource
    private PrivilegeRepository repository;

    public void create(PrivilegeResource privilegeResource) {
        Privilege privilege = new Privilege();
        privilege.setName(privilegeResource.name());
        privilege.setDescription(privilegeResource.description());

        repository.save(privilege);
    }
}
