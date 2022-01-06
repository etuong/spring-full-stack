package com.booksmart.service.impl;

import com.booksmart.entity.Role;
import com.booksmart.entity.ShoppingCart;
import com.booksmart.entity.User;
import com.booksmart.repository.RoleRepository;
import com.booksmart.repository.UserRepository;
import com.booksmart.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User user, Set<Role> roles) {
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User {} already exists!", user.getUsername());
        } else {
            for (Role role : roles) {
                roleRepository.save(role);
            }

            user.setRoles(new HashSet<>());
            user.getRoles().addAll(roles);

            ShoppingCart shoppingCart = ShoppingCart.builder().user(user).build();
            user.setShoppingCart(shoppingCart);

            localUser = save(user);
        }

        return localUser;
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

