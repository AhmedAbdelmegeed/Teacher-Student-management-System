package com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO;

import com.abdelmegeed.teacherstudentmanegmentsystem.role.model.DTO.RoleDTO;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID user_id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Set<RoleDTO> RolesDTO;
}
