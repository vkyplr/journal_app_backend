package com.vikas.journalApp.service;

import com.vikas.journalApp.entity.User;
import com.vikas.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user) {
        repository.save(user);
    }

    public boolean saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER"));
            repository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Hahahahahahah");
            log.warn("Hahahahahahah");
            log.info("Hahahahahahah");
            log.debug("Hahahahahahah");
            log.trace("Hahahahahahah");
            return false;
        }
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return repository.findById(id);
    }

    public void deleteById(ObjectId id) {
        repository.deleteById(id);
    }

    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("USER", "ADMIN"));
        repository.save(user);
    }
}
