package com.abdelmegeed.teacherstudentmanegmentsystem.user.controller;

import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO.UserDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.entity.User;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.usecase.UserUseCase;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserUseCase userUseCase;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userUseCase.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable UUID userId) {
        return userUseCase.getUserById(userId);
    }

    @GetMapping("/username/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userUseCase.getUserByUsername(username);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userUseCase.createUser(userDTO);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable UUID userId, @RequestBody User updatedUser) {
        return userUseCase.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        userUseCase.deleteUser(userId);
    }

    @GetMapping("/{userId}/roles")
    public List<RoleDTO> getUserRoles(@PathVariable UUID userId) {
        return userUseCase.getUserRoles(userId);
    }

    @PostMapping("/{userId}/roles/{roleId}")
    public UserDTO addRoleToUser(@PathVariable UUID userId, @PathVariable UUID roleId) {
        return userUseCase.addRoleToUser(userId, roleId);
    }

    @DeleteMapping("/{userId}/roles/{roleId}")
    public UserDTO removeRoleFromUser(@PathVariable UUID userId, @PathVariable UUID roleId) {
        return userUseCase.removeRoleFromUser(userId, roleId);
    }
    @DeleteMapping("/{userId}/role")
    public UserDTO removeAllRolesFromUser(@PathVariable UUID userId) {
        return userUseCase.removeAllRolesFromUser(userId);
    }
}
