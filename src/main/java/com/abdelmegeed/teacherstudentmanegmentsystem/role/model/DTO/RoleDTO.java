package com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO {
    private UUID role_id;
    private String name;
}
