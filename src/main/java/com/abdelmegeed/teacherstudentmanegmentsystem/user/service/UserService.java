package com.abdelmegeed.teacherstudentmanegmentsystem.user.service;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.entity.Role;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.service.RoleService;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.entity.User;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    public User findById(UUID user_id) {
        return userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User findByUserName(String user_name) {
        return userRepository.findByUsername(user_name).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public List<Role> getUserRoles(UUID userId) {
        User user = findById(userId);
        return new ArrayList<>(user.getRoles());
    }

    public User updateUser(UUID userId, User updatedUser) {
        User user = findById(userId);
        if (updatedUser.getUsername() != null) {
            user.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getEmail() != null) {
            user.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getFirstName() != null) {
            user.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null) {
            user.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getPassword() != null) {
            user.setPassword(updatedUser.getPassword());
        }
        return userRepository.save(user);
    }

    public User addRoleToUser(UUID userId, UUID roleId) {
        User user = findById(userId);
        Role role = roleService.getRole(roleId);
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    @Transactional
    public User removeRoleFromUser(UUID userId, UUID roleId) {
        User user = findById(userId);
        Role role = roleService.getRole(roleId);
        user.getRoles().remove(role);
        return userRepository.save(user);
    }
    @Transactional
    public User removeAllRolesFromUser(UUID userId) {
        User user = findById(userId);
        user.getRoles().clear();
        return userRepository.save(user);
    }
}
