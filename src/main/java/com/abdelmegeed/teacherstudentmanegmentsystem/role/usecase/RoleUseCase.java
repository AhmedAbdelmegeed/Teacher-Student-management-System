package com.abdelmegeed.teacherstudentmanegmentsystem.role.usecase;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.converter.RoleConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.entity.Role;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleUseCase {
    private final RoleService roleService;
    private final RoleConverter roleConverter;

    public RoleDTO getRoleById(UUID roleId) {
        return roleConverter.toDTO(roleService.getRole(roleId));
    }

    public RoleDTO createNewRole(RoleDTO role) {
        return roleConverter.toDTO(roleService.createRole(roleConverter.toEntity(role)));
    }

    public List<RoleDTO> fetchAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return roles.stream()
                .map(roleConverter::toDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleByName(String roleName) {
        return roleConverter.toDTO(roleService.findByRoleName(roleName));
    }

    public void deleteRoleById(UUID roleId) {
        roleService.deleteRole(roleId);
    }

    public void deleteRoleByName(String roleName) {
        roleService.deleteRole(roleName);
    }
}
