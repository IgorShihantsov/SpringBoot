package com.shihantsov.service;

import com.shihantsov.entity.User;
import com.shihantsov.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addOrUpdate(User user) {
        if (user.getName().isEmpty())
            return;
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void removeByName(String name) {

        userRepository.removeByName(name);
    }

    public User getById(Integer id) {
        return userRepository.getOne(id);
    }
}
