package com.abdelmegeed.teacherstudentmanegmentsystem.student.service;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.service.CourseService;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.repo.StudentRepository;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseService courseService;

    public Student getStudentById(UUID student_id) {
        return studentRepository.findById(student_id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(UUID student_id, Student student) {
        Student existingStudent = getStudentById(student_id);

        if (student.getMajor() != null) {
            existingStudent.setMajor(student.getMajor());
        }
        if (student.getUser() != null) {
            existingStudent.setUser(student.getUser());
        }
        return studentRepository.save(existingStudent);
    }

    @Transactional
    public void deleteStudent(UUID student_id) {
        studentRepository.deleteById(student_id);
    }

    public List<Course> getStudentCourses(UUID student_id) {
        Student student = getStudentById(student_id);
        return student.getCourses().stream().toList();
    }

    public List<Teacher> getStudentTeachers(UUID student_id) {
        List<Course> StudentCourses = getStudentCourses(student_id);
        List<Teacher> StudentTeachers = new ArrayList<>();
        Set<UUID> TeacherIds = new HashSet<>();
        for (Course course : StudentCourses) {
            List<Teacher> CourseTeachers = course.getTeachers().stream().toList();
            for (Teacher teacher : CourseTeachers) {
                if (!TeacherIds.contains(teacher.getTeacher_id())) {
                    TeacherIds.add(teacher.getTeacher_id());
                    StudentTeachers.add(teacher);
                }
            }
        }
        return StudentTeachers;
    }

    public void addCourseToStudent(UUID studentId, UUID courseId) {
        Student student = getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        student.getCourses().add(course);
        studentRepository.save(student);
    }
    @Transactional
    public void removeCourseFromStudent(UUID studentId, UUID courseId) {
        Student student = getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        student.getCourses().remove(course);
        studentRepository.save(student);
    }
    @Transactional
    public void removeAllCoursesFromStudent(UUID studentId) {
        Student student = getStudentById(studentId);
        student.getCourses().clear();
        studentRepository.save(student);
    }
}
