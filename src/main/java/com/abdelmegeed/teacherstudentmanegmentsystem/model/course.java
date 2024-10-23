package com.abdelmegeed.teacherstudentmanegmentsystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user; // Teacher

    private String name;
    private boolean active;
    private LocalDate registrationDate;

    public void setUser(com.abdelmegeed.teacherstudentmanegmentsystem.model.user user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public com.abdelmegeed.teacherstudentmanegmentsystem.model.user getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
