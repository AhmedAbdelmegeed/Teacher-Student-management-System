package com.abdelmegeed.teacherstudentmanegmentsystem.student.model.entity;

import com.abdelmegeed.teacherstudentmanegmentsystem.course.model.entity.Course;
import com.abdelmegeed.teacherstudentmanegmentsystem.user.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String major;
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

}
