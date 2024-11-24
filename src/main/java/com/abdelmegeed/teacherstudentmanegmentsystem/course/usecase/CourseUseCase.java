package com.abdelmegeed.teacherstudentmanegmentsystem.course.usecase;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.converter.CourseConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.service.CourseService;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.converter.StudentConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.converter.TeacherConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseUseCase {
    private final CourseService courseService;
    private final CourseConverter courseConverter;
    private final TeacherConverter teacherConverter;
    private final StudentConverter studentConverter;

    public CourseDTO getCourseById(UUID courseId) {
        return courseConverter.toDTO(courseService.getCourseById(courseId));
    }

    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses().stream()
                .map(courseConverter::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {
        return courseConverter.toDTO(courseService.addCourse(courseConverter.toEntity(courseDTO)));
    }

    public CourseDTO updateCourse(UUID courseId, CourseDTO updatedCourseDTO) {
        return courseConverter.toDTO(courseService.updateCourse(courseId, courseConverter.toEntity(updatedCourseDTO)));
    }

    public CourseDTO addTeacherToCourse(UUID courseId, UUID teacherId) {
        return courseConverter.toDTO(courseService.addTeacherToCourse(courseId, teacherId));
    }

    public CourseDTO addStudentToCourse(UUID courseId, UUID studentId) {
        return courseConverter.toDTO(courseService.addStudentToCourse(courseId, studentId));
    }

    public List<StudentDTO> getStudentsForCourse(UUID courseId) {
        return courseService.getStudentsForCourse(courseId).stream()
                .map(studentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public List<TeacherDTO> getTeachersForCourse(UUID courseId) {
        return courseService.getTeachersForCourse(courseId).stream()
                .map(teacherConverter::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteCourse(UUID courseId) {
        courseService.deleteCourse(courseId);
    }

    public CourseDTO removeTeacherFromCourse(UUID courseId, UUID teacherId) {
        courseService.removeTeacherFromCourse(courseId, teacherId);
        return courseConverter.toDTO(courseService.getCourseById(courseId));
    }

    public CourseDTO removeAllTeachersFromCourse(UUID courseId) {
        courseService.removeAllTeachersFromCourse(courseId);
        return courseConverter.toDTO(courseService.getCourseById(courseId));
    }

    public CourseDTO removeStudentFromCourse(UUID courseId, UUID studentId) {
        courseService.removeStudentFromCourse(courseId, studentId);
        return courseConverter.toDTO(courseService.getCourseById(courseId));
    }

    public CourseDTO removeAllStudentsFromCourse(UUID courseId) {
        courseService.removeAllStudentsFromCourse(courseId);
        return courseConverter.toDTO(courseService.getCourseById(courseId));
    }
}
