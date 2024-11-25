package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.service;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.repo.CourseRepository;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.repo.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public Teacher getTeacherById(UUID teacher_Id) {
        return teacherRepository.findById(teacher_Id).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(UUID teacherId, Teacher teacher) {
        Teacher existingTeacher = getTeacherById(teacherId);

        if (teacher.getUser() != null) {
            existingTeacher.setUser(teacher.getUser());
        }
        if (teacher.getHireDate() != null) {
            existingTeacher.setHireDate(teacher.getHireDate());
        }
        return teacherRepository.save(existingTeacher);
    }

    @Transactional
    public void deleteTeacher(UUID teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    public List<Course> getTeacherCourses(UUID teacherId) {
        Teacher teacher = getTeacherById(teacherId);
        return teacher.getCourses().stream().toList();
    }

    public List<Student> getTeacherStudents(UUID Teacher_id) {
        List<Course> TeacherCourses = getTeacherCourses(Teacher_id);
        List<Student> TeacherStudents = new ArrayList<>();
        Set<UUID> StudentIds = new HashSet<>();
        for (Course course : TeacherCourses) {
            List<Student> CourseStudents = course.getStudents().stream().toList();
            for (Student student : CourseStudents) {
                if (!StudentIds.contains(student.getStudentId())) {
                    StudentIds.add(student.getStudentId());
                    TeacherStudents.add(student);
                }
            }
        }
        return TeacherStudents;
    }

    public void addCourseToTeacher(UUID teacherId, UUID courseId) {
        Teacher teacher = getTeacherById(teacherId);
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        teacher.getCourses().add(course);
        teacherRepository.save(teacher);
    }

    @Transactional
    public void removeCourseFromTeacher(UUID teacherId, UUID courseId) {
        Teacher teacher = getTeacherById(teacherId);
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        teacher.getCourses().remove(course);
        teacherRepository.save(teacher);
    }

    @Transactional
    public void removeAllCoursesFromTeacher(UUID teacherId) {
        Teacher teacher = getTeacherById(teacherId);
        teacher.getCourses().clear();
        teacherRepository.save(teacher);
    }
}
