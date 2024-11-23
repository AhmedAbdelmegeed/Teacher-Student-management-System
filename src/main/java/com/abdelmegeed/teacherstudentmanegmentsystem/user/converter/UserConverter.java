package com.abdelmegeed.teacherstudentmanegmentsystem.user.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.converter.RoleConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.entity.Role;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO.UserDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserConverter {
    private final RoleConverter roleConverter;
    public UserDTO toDTO(User user) {

        Set<RoleDTO> rolesDTOs = user.getRoles().stream()
                .map(roleConverter::toDTO)
                .collect(Collectors.toSet());

        return UserDTO.builder()
                .user_id(user.getUser_id())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .RolesDTO(rolesDTOs)
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        Set<Role> roles = userDTO.getRolesDTO().stream()
                .map(roleConverter::toEntity)
                .collect(Collectors.toSet());

        return User.builder()
                .user_id(userDTO.getUser_id())
                .username(userDTO.getUsername())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .Roles(roles)
                .build();
    }
}
