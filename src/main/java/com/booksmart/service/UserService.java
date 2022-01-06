package com.booksmart.service;

import com.booksmart.entity.Role;
import com.booksmart.entity.User;

import java.util.Set;

public interface UserService {
    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user, Set<Role> roles);

    User findById(Long id);

    User save(User user);
}