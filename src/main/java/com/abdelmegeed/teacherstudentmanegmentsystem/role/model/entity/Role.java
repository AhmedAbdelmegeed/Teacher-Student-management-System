package com.abdelmegeed.teacherstudentmanegmentsystem.role.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Table(name="role")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Role {

    @Id
    @GeneratedValue
    private UUID roleId;

    @Column(nullable = false, unique = true)
    private String name;
}
