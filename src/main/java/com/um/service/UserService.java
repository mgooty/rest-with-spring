package com.um.service;

import com.um.model.User;
import com.um.repository.UserRepository;
import com.um.resource.UserResource;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Resource
    private UserRepository repository;

    public void create(UserResource userResource) {
        User user = new User();
        user.setName(userResource.name());
        user.setEmail(userResource.email());
        user.setBirthDate(userResource.birthDate());

        repository.save(user);
    }

    public List<UserResource> getAll() {
        List<User> users = repository.findAll();

        return users.stream()
                    .map(user -> new UserResource(user.getName(), user.getEmail(), user.getBirthDate()))
                    .collect(Collectors.toList());
    }
}
