package com.abdelmegeed.teacherstudentmanegmentsystem.student.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.converter.CourseConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentConverter {
    private final UserConverter userConverter;
    private final CourseConverter courseConverter;
    public StudentDTO toDTO(Student student) {

        List<CourseDTO> courseDTOs = student.getCourses().stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());

        return StudentDTO.builder()
                .id(student.getStudentId())
                .user(userConverter.toDTO(student.getUser()))
                .major(student.getMajor())
                .courses(courseDTOs)
                .build();
    }

    public Student toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        List<Course> courses = studentDTO.getCourses().stream()
                .map(courseConverter::toEntity)
                .collect(Collectors.toList());

        return Student.builder()
                .studentId(studentDTO.getId())
                .user(userConverter.toEntity(studentDTO.getUser()))
                .major(studentDTO.getMajor())
                .courses(courses)
                .build();
    }
}
