package com.abdelmegeed.teacherstudentmanegmentsystem.course.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.converter.TeacherConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.converter.StudentConverter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseConverter {
    private final TeacherConverter teacherConverter;
    private final StudentConverter studentConverter;

    public CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .course_id(course.getCourse_id())
                .name(course.getName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .courseUrl(course.getCourseUrl())
                .duration(course.getDuration())
                .teachers(course.getTeachers().stream()
                        .map(teacherConverter::toDTO)
                        .collect(Collectors.toSet()))
                .students(course.getStudents().stream()
                        .map(studentConverter::toDTO)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Course toEntity(CourseDTO courseDTO) {
        return Course.builder()
                .course_id(courseDTO.getCourse_id())
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .credits(courseDTO.getCredits())
                .courseUrl(courseDTO.getCourseUrl())
                .duration(courseDTO.getDuration())
                .teachers(courseDTO.getTeachers().stream()
                        .map(teacherConverter::toEntity)
                        .collect(Collectors.toSet()))
                .students(courseDTO.getStudents().stream()
                        .map(studentConverter::toEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
