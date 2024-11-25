package com.abdelmegeed.teacherstudentmanegmentsystem.user.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.converter.RoleConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.entity.Role;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO.UserDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserConverter {
    private final RoleConverter roleConverter;
    public UserDTO toDTO(User user) {

        List<RoleDTO> rolesDTOs = user.getRoles().stream()
                .map(roleConverter::toDTO)
                .collect(Collectors.toList());

        return UserDTO.builder()
                .user_id(user.getUserId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .RolesDTO(rolesDTOs)
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        List<Role> roles = userDTO.getRolesDTO().stream()
                .map(roleConverter::toEntity)
                .collect(Collectors.toList());

        return User.builder()
                .userId(userDTO.getUser_id())
                .username(userDTO.getUsername())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .Roles(roles)
                .build();
    }
}
