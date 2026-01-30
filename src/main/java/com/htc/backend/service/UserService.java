package com.htc.backend.service;

import com.htc.backend.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    // Create
    User createUser(User user);

    // Read
    Optional<User> getUserById(Long userId);
    User getUserByEmail(String email);
    User getUserByRole(String role);
    List<User> getAllUsers();

    // Update
    User updateUser(Long userId, User user);

    // Delete
    void deleteUser(Long userId);
    void deleteAllUsers();
}
