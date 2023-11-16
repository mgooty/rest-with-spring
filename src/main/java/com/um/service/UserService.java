package com.um.service;

import com.um.model.User;
import com.um.repository.UserRepository;
import com.um.resource.UserResource;
import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.i18n.LocaleContextResolver;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Resource
    private UserRepository repository;

    @Resource
    private MessageSource messageSource;

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

    public String greetings() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("user.greetings.message", null, locale);
    }

    public UserResource get(Long id) {
        User user = repository.findById(id).orElseThrow();
        return new UserResource(user.getName(), user.getEmail(), user.getBirthDate());
    }
}
