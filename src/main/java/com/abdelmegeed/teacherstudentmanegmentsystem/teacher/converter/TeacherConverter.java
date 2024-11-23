package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.converter.CourseConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO.TeacherDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeacherConverter {
    private final UserConverter userConverter;
    private final CourseConverter courseConverter;
    public TeacherDTO toDTO(Teacher teacher) {
        Set<CourseDTO> courseDTOs = teacher.getCourses().stream()
                .map(courseConverter::toDTO) // Convert each Course entity to CourseDTO
                .collect(Collectors.toSet());

        return TeacherDTO.builder()
                .teacher_id(teacher.getTeacher_id())
                .userDTO(userConverter.toDTO(teacher.getUser()))
                .hireDate(teacher.getHireDate())
                .courses(courseDTOs)
                .build();
    }

    public Teacher toEntity(TeacherDTO teacherDTO) {

        Set<Course> courses = teacherDTO.getCourses().stream()
                .map(courseConverter::toEntity)
                .collect(Collectors.toSet());

        return Teacher.builder()
                .teacher_id(teacherDTO.getTeacher_id())
                .user(userConverter.toEntity(teacherDTO.getUserDTO()))
                .hireDate(teacherDTO.getHireDate())
                .courses(courses)
                .build();
    }
}
