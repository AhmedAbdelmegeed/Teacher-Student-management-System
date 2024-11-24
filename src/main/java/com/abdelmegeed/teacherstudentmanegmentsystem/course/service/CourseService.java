package com.abdelmegeed.teacherstudentmanegmentsystem.course.service;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.course.repo.CourseRepository;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity.Student;
import com.abdelmegeed.teacherstudentmanegmentsystem.student.service.StudentService;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity.Teacher;
import com.abdelmegeed.teacherstudentmanegmentsystem.teacher.service.TeacherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherService teacherService;
    private final StudentService studentService;

    public Course getCourseById(UUID course_id) {
        return courseRepository.findById(course_id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(UUID Course_id, Course updatedCourse) {
        Course course = getCourseById(Course_id);
        if (updatedCourse.getName() != null) {
            course.setName(updatedCourse.getName());
        }
        if (updatedCourse.getDescription() != null) {
            course.setDescription(updatedCourse.getDescription());
        }
        if (updatedCourse.getCredits() > 0) {
            course.setCredits(updatedCourse.getCredits());
        }
        if (updatedCourse.getCourseUrl() != null) {
            course.setCourseUrl(updatedCourse.getCourseUrl());
        }
        if (updatedCourse.getDuration() > 0) {
            course.setDuration(updatedCourse.getDuration());
        }
        if (updatedCourse.getTeachers() != null && !updatedCourse.getTeachers().isEmpty()) {
            course.setTeachers(updatedCourse.getTeachers());
        }
        if (updatedCourse.getStudents() != null && !updatedCourse.getStudents().isEmpty()) {
            course.setStudents(updatedCourse.getStudents());
        }
        return courseRepository.save(course);
    }

    public Course addTeacherToCourse(UUID courseId, UUID teacherId) {
        Course course = getCourseById(courseId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        course.getTeachers().add(teacher);
        return courseRepository.save(course);
    }

    public Course addStudentToCourse(UUID courseId, UUID studentId) {
        Course course = getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);
        course.getStudents().add(student);
        return courseRepository.save(course);
    }

    public List<Student> getStudentsForCourse(UUID courseId) {
        Course course = getCourseById(courseId);
        return new ArrayList<>(course.getStudents());
    }

    public List<Teacher> getTeachersForCourse(UUID courseId) {
        Course course = getCourseById(courseId);
        return new ArrayList<>(course.getTeachers());
    }

    @Transactional
    public void deleteCourse(UUID courseId) {
        Course course = getCourseById(courseId);
        courseRepository.delete(course);
    }

    @Transactional
    public void removeTeacherFromCourse(UUID courseId, UUID teacherId) {
        Course course = getCourseById(courseId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        course.getTeachers().remove(teacher);
        courseRepository.save(course);
    }

    @Transactional
    public void removeAllTeachersFromCourse(UUID courseId) {
        Course course = getCourseById(courseId);
        course.getTeachers().clear();
        courseRepository.save(course);
    }

    @Transactional
    public void removeStudentFromCourse(UUID courseId, UUID studentId) {
        Course course = getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);
        course.getStudents().remove(student);
        courseRepository.save(course);
    }

    @Transactional
    public void removeAllStudentsFromCourse(UUID courseId) {
        Course course = getCourseById(courseId);
        course.getStudents().clear();
        courseRepository.save(course);
    }

}
