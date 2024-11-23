package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO.UserDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherDTO {
    private UUID teacher_id;
    private UserDTO userDTO;
    private LocalDate hireDate;
    private Set<CourseDTO> courses;
}
