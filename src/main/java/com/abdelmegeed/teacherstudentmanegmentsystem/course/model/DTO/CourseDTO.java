package com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO;

import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO.TeacherDTO;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDTO {
    private UUID course_id;
    private String name;
    private String description;
    private int credits;
    private String courseUrl;
    private int duration;
    private Set<TeacherDTO> teachers;
    private Set<StudentDTO> students;
}
