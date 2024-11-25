package com.abdelmegeed.teacherstudentmanegmentsystem.teacher.model.entity;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID teacherId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate hireDate;

    @ManyToMany(mappedBy = "teachers")
    private List<Course> courses;
}
