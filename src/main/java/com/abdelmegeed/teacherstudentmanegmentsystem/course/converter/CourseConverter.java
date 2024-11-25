package com.abdelmegeed.teacherstudentmanegmentsystem.course.converter;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.repo.StudentRepository;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseConverter {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public CourseDTO toDTO(Course course) {
        List<String> students = course.getStudents()
                .stream()
                .map(student -> student.getUser().getUsername())
                .toList();
        List<String> teachers = course.getTeachers()
                .stream()
                .map(teacher -> teacher.getUser().getUsername())
                .toList();
        return CourseDTO.builder()
                .course_id(course.getCourseId())
                .name(course.getName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .courseUrl(course.getCourseUrl())
                .duration(course.getDuration())
                .teachers(teachers)
                .students(students)
                .build();
    }

    public Course toEntity(CourseDTO courseDTO) {

        return Course.builder()
                .courseId(courseDTO.getCourse_id())
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .credits(courseDTO.getCredits())
                .courseUrl(courseDTO.getCourseUrl())
                .duration(courseDTO.getDuration())
                .teachers(Optional.ofNullable(courseDTO.getTeachers())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .map(userName -> teacherRepository.findByUser_Username(userName).orElse(null))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .students(Optional.ofNullable(courseDTO.getTeachers())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .map(userName -> studentRepository.findByUser_Username(userName).orElse(null))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .build();
    }
}
