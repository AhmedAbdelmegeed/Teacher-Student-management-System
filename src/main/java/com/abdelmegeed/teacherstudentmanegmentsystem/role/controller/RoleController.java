package com.abdelmegeed.teacherstudentmanegmentsystem.role.controller;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.role.usecase.RoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleUseCase roleUseCase;

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable UUID id) {
        return roleUseCase.getRoleById(id);
    }
    @GetMapping("/name")
    public RoleDTO getRoleByName(@RequestBody String name) {
        return roleUseCase.getRoleByName(name);
    }

    @PostMapping
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
        return roleUseCase.createNewRole(roleDTO);
    }

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleUseCase.fetchAllRoles();
    }

    @DeleteMapping("/{id}")
    public void deleteRoleById(@PathVariable UUID id) {
        roleUseCase.deleteRoleById(id);
    }

    @DeleteMapping
    public void deleteRoleByName(@RequestBody String name) {
        roleUseCase.deleteRoleByName(name);
    }
}
