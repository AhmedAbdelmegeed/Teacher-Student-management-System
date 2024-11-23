package com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO.UserDTO;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private UUID id;
    private UserDTO user;
    private String major;
    private Set<CourseDTO> courses;
}
