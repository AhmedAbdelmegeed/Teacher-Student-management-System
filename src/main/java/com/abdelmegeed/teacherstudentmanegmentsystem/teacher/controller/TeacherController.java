package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.controller;

import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO.TeacherDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.usecase.TeacherUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherUseCase teacherUseCase;

    @GetMapping("/{teacherId}")
    public TeacherDTO getTeacherById(@PathVariable UUID teacherId) {
        return teacherUseCase.getTeacherById(teacherId);
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers() {
        return teacherUseCase.getAllTeachers();
    }

    @PostMapping
    public TeacherDTO addTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherUseCase.addTeacher(teacherDTO);
    }

    @PutMapping("/{teacherId}")
    public TeacherDTO updateTeacher(@PathVariable UUID teacherId, @RequestBody TeacherDTO teacherDTO) {
        return teacherUseCase.updateTeacher(teacherId, teacherDTO);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable UUID teacherId) {
        teacherUseCase.deleteTeacher(teacherId);
    }

    @GetMapping("/{teacherId}/students")
    public List<StudentDTO> getTeacherStudents(@PathVariable UUID teacherId) {
        return teacherUseCase.getTeacherStudents(teacherId);
    }

    @PostMapping("/{teacherId}/courses/{courseId}")
    public void addCourseToTeacher(@PathVariable UUID teacherId, @PathVariable UUID courseId) {
        teacherUseCase.addCourseToTeacher(teacherId, courseId);
    }

    @DeleteMapping("/{teacherId}/courses/{courseId}")
    public void removeCourseFromTeacher(@PathVariable UUID teacherId, @PathVariable UUID courseId) {
        teacherUseCase.removeCourseFromTeacher(teacherId, courseId);
    }

    @DeleteMapping("/{teacherId}/courses")
    public void removeAllCoursesFromTeacher(@PathVariable UUID teacherId) {
        teacherUseCase.removeAllCoursesFromTeacher(teacherId);
    }
}
