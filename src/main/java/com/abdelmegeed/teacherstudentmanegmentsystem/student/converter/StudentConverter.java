package com.abdelmegeed.teacherstudentmanegmentsystem.student.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.converter.CourseConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentConverter {
    private final UserConverter userConverter;
    private final CourseConverter courseConverter;
    public StudentDTO toDTO(Student student) {

        Set<CourseDTO> courseDTOs = student.getCourses().stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toSet());

        return StudentDTO.builder()
                .id(student.getId())
                .user(userConverter.toDTO(student.getUser()))
                .major(student.getMajor())
                .courses(courseDTOs)
                .build();
    }

    public Student toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        Set<Course> courses = studentDTO.getCourses().stream()
                .map(courseConverter::toEntity)
                .collect(Collectors.toSet());

        return Student.builder()
                .id(studentDTO.getId())
                .user(userConverter.toEntity(studentDTO.getUser()))
                .major(studentDTO.getMajor())
                .courses(courses)
                .build();
    }
}
