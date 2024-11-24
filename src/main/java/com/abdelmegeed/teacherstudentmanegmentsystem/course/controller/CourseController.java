package com.abdelmegeed.teacherstudentmanegmentsystem.course.controller;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.DTO.CourseDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.usecase.CourseUseCase;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseUseCase courseUseCase;

    @GetMapping("/{courseId}")
    public CourseDTO getCourseById(@PathVariable UUID courseId) {
        return courseUseCase.getCourseById(courseId);
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseUseCase.getAllCourses();
    }

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        return courseUseCase.addCourse(courseDTO);
    }

    @PutMapping("/{courseId}")
    public CourseDTO updateCourse(@PathVariable UUID courseId, @RequestBody CourseDTO updatedCourseDTO) {
        return courseUseCase.updateCourse(courseId, updatedCourseDTO);
    }

    @PostMapping("/{courseId}/teachers/{teacherId}")
    public CourseDTO addTeacherToCourse(@PathVariable UUID courseId, @PathVariable UUID teacherId) {
        return courseUseCase.addTeacherToCourse(courseId, teacherId);
    }

    @PostMapping("/{courseId}/student/{studentId}")
    public CourseDTO addStudentToCourse(@PathVariable UUID courseId, @PathVariable UUID studentId) {
        return courseUseCase.addStudentToCourse(courseId, studentId);
    }

    @GetMapping("/{courseId}/student")
    public List<StudentDTO> getStudentsForCourse(@PathVariable UUID courseId) {
        return courseUseCase.getStudentsForCourse(courseId);
    }

    @GetMapping("/{courseId}/teacher")
    public List<TeacherDTO> getTeachersForCourse(@PathVariable UUID courseId) {
        return courseUseCase.getTeachersForCourse(courseId);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable UUID courseId) {
        courseUseCase.deleteCourse(courseId);
    }

    @DeleteMapping("/{courseId}/teacher/{teacherId}")
    public CourseDTO removeTeacherFromCourse(@PathVariable UUID courseId, @PathVariable UUID teacherId) {
        return courseUseCase.removeTeacherFromCourse(courseId, teacherId);
    }

    @DeleteMapping("/{courseId}/teacher")
    public CourseDTO removeAllTeachersFromCourse(@PathVariable UUID courseId) {
        return courseUseCase.removeAllTeachersFromCourse(courseId);
    }

    @DeleteMapping("/{courseId}/student/{studentId}")
    public CourseDTO removeStudentFromCourse(@PathVariable UUID courseId, @PathVariable UUID studentId) {
        return courseUseCase.removeStudentFromCourse(courseId, studentId);
    }

    @DeleteMapping("/{courseId}/student")
    public CourseDTO removeAllStudentsFromCourse(@PathVariable UUID courseId) {
        return courseUseCase.removeAllStudentsFromCourse(courseId);
    }
}
