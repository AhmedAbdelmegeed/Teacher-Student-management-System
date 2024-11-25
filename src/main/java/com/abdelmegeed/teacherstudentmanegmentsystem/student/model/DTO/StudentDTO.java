package com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.DTO.UserDTO;
import lombok.*;

import java.util.List;
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
    private List<CourseDTO> courses;
}
