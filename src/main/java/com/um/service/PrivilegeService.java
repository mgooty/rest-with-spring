package com.um.service;

import com.um.model.Privilege;
import com.um.repository.PrivilegeRepository;
import com.um.resource.PrivilegeResource;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegeService {

    @Resource
    private PrivilegeRepository repository;

    public void create(PrivilegeResource privilegeResource) {
        Privilege privilege = new Privilege();
        privilege.setName(privilegeResource.name());
        privilege.setDescription(privilegeResource.description());
        privilege.setPriority(privilegeResource.priority());

        repository.save(privilege);
    }

    public List<PrivilegeResource> getAll() {
        List<Privilege> privileges = repository.findAll();

        return privileges.stream()
                    .map(privilege -> new PrivilegeResource(privilege.getName(), privilege.getDescription(), privilege.getPriority()))
                    .collect(Collectors.toList());
    }
}
