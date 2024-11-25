package com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO;

import lombok.*;

import java.util.List;
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
    private List<String> teachers;
    private List<String> students;
}
