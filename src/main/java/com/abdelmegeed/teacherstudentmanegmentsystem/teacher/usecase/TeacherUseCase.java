package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.usecase;

import com.abdelmegeed.teacherstudentmanegmentsystem.student.converter.StudentConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.DTO.StudentDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.converter.TeacherConverter;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.DTO.TeacherDTO;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeacherUseCase {
    private final TeacherService teacherService;
    private final TeacherConverter teacherConverter;
    private final StudentConverter studentConverter;

    public TeacherDTO getTeacherById(UUID teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return teacherConverter.toDTO(teacher);
    }

    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return teachers.stream()
                .map(teacherConverter::toDTO)
                .collect(Collectors.toList());
    }

    public TeacherDTO addTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherConverter.toEntity(teacherDTO);
        Teacher addedTeacher = teacherService.addTeacher(teacher);
        return teacherConverter.toDTO(addedTeacher);
    }

    public TeacherDTO updateTeacher(UUID teacherId, TeacherDTO teacherDTO) {
        Teacher teacher = teacherConverter.toEntity(teacherDTO);
        Teacher updatedTeacher = teacherService.updateTeacher(teacherId, teacher);
        return teacherConverter.toDTO(updatedTeacher);
    }

    public void deleteTeacher(UUID teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    public List<StudentDTO> getTeacherStudents(UUID teacherId) {
        List<Student> students = teacherService.getTeacherStudents(teacherId);
        return students.stream()
                .map(studentConverter::toDTO)
                .collect(Collectors.toList());
    }

    public void addCourseToTeacher(UUID teacherId, UUID courseId) {
        teacherService.addCourseToTeacher(teacherId, courseId);
    }

    public void removeCourseFromTeacher(UUID teacherId, UUID courseId) {
        teacherService.removeCourseFromTeacher(teacherId, courseId);
    }

    public void removeAllCoursesFromTeacher(UUID teacherId) {
        teacherService.removeAllCoursesFromTeacher(teacherId);
    }
}
