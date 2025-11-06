package com.service.user.user.service.service;

import com.service.user.user.service.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServiceUser {
    User createUser(User user);
    boolean deleteUserById(Long id);
    User getUserById(Long id);
    User getUserByName(String name);
    List<User> getAllUsers();
    User updateUser(Long id,User user);
}
