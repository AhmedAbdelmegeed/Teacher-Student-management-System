package com.abdelmegeed.teacherstudentmanegmentsystem.student.usecase;

import com.abdelmegeed.teacherstudentmanegmentsystem.student.converter.StudentConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.service.StudentService;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.converter.TeacherConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO.TeacherDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentUseCase {
    private final StudentService studentService;
    private final StudentConverter studentConverter;
    private final TeacherConverter teacherConvertor;

    public StudentDTO getStudentById(UUID studentId) {
        Student student = studentService.getStudentById(studentId);
        return studentConverter.toDTO(student);
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students.stream()
                .map(studentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = studentService.addStudent(studentConverter.toEntity(studentDTO));
        return studentConverter.toDTO(student);
    }

    public StudentDTO updateStudent(UUID studentId, StudentDTO studentDTO) {
        Student student = studentService.updateStudent(studentId, studentConverter.toEntity(studentDTO));
        return studentConverter.toDTO(student);
    }

    public void deleteStudent(UUID studentId) {
        studentService.deleteStudent(studentId);
    }

    public List<TeacherDTO> getStudentTeachers(UUID studentId) {
        List<Teacher> teachers = studentService.getStudentTeachers(studentId);
        return teachers.stream()
                .map(teacherConvertor::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO addCourseToStudent(UUID studentId, UUID courseId) {
        return studentConverter.toDTO(studentService.addCourseToStudent(studentId, courseId));
    }

    public void removeCourseFromStudent(UUID studentId, UUID courseId) {
        studentService.removeCourseFromStudent(studentId, courseId);
    }

    public void removeAllCoursesFromStudent(UUID studentId) {
        studentService.removeAllCoursesFromStudent(studentId);
    }
}
