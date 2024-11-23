package com.abdelmegeed.teacherstudentmanegmentsystem.role.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleConverter {
    public RoleDTO toDTO(Role role) {
        return RoleDTO.builder()
                .name(role.getName())
                .build();
    }

    public Role toEntity(RoleDTO roleDTO) {
        return Role.builder()
                .role_id(null)
                .name(roleDTO.getName())
                .build();

    }
}
