package com.abdelmegeed.teacherstudentmanegmentsystem.user.usecase;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.converter.RoleConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.converter.UserConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO.UserDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.entity.User;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserUseCase {
    private final UserService userService;
    private final UserConverter userConverter;
    private final RoleConverter roleConverter;

    public UserDTO getUserById(UUID userId) {
        return userConverter.toDTO(userService.findById(userId));
    }

    public UserDTO getUserByUsername(String username) {
        return userConverter.toDTO(userService.findByUserName(username));
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(userConverter::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO user) {
        return userConverter.toDTO(userService.createUser(userConverter.toEntity(user)));
    }

    public void deleteUser(UUID userId) {
        userService.deleteUser(userId);
    }

    public List<RoleDTO> getUserRoles(UUID userId) {
        User user = userService.findById(userId);
        return user.getRoles().stream()
                .map(roleConverter::toDTO)
                .collect(Collectors.toList());
    }
    public UserDTO updateUser(UUID userId, User updatedUser) {
        return userConverter.toDTO(userService.updateUser(userId, updatedUser));
    }

    public UserDTO addRoleToUser(UUID userId, UUID roleId) {
        return userConverter.toDTO(userService.addRoleToUser(userId, roleId));
    }

    public UserDTO removeRoleFromUser(UUID userId, UUID roleId) {
        return userConverter.toDTO(userService.removeRoleFromUser(userId, roleId));
    }
    public UserDTO removeAllRolesFromUser(UUID userId) {
        return userConverter.toDTO(userService.removeAllRolesFromUser(userId));
    }
}
