package com.abdelmegeed.teacherstudentmanegmentsystem.student.controller;

import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.usecase.StudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentUseCase studentUseCase;

    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@PathVariable UUID studentId) {
        return studentUseCase.getStudentById(studentId);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentUseCase.getAllStudents();
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentUseCase.addStudent(studentDTO);
    }

    @PutMapping("/{studentId}")
    public StudentDTO updateStudent(@PathVariable UUID studentId, @RequestBody StudentDTO studentDTO) {
        return studentUseCase.updateStudent(studentId, studentDTO);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable UUID studentId) {
        studentUseCase.deleteStudent(studentId);
    }
    @PostMapping("/{studentId}/courses/{courseId}")
    public StudentDTO addCourseToStudent(@PathVariable UUID studentId, @PathVariable UUID courseId) {
        return studentUseCase.addCourseToStudent(studentId, courseId);
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public void removeCourseFromStudent(@PathVariable UUID studentId, @PathVariable UUID courseId) {
        studentUseCase.removeCourseFromStudent(studentId, courseId);
    }

    @DeleteMapping("/{studentId}/courses")
    public void removeAllCoursesFromStudent(@PathVariable UUID studentId) {
        studentUseCase.removeAllCoursesFromStudent(studentId);
    }
}
