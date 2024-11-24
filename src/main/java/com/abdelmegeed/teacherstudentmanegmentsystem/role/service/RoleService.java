package com.abdelmegeed.teacherstudentmanegmentsystem.role.service;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.entity.Role;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.repo.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRole(UUID roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role findByRoleName(String roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found with name: " + roleName));
    }

    @Transactional
    public void deleteRole(UUID roleId) {
        roleRepository.deleteById(roleId);
    }

    @Transactional
    public void deleteRole(String roleName) {
        roleRepository.deleteByName(roleName);
    }
}
