package com.abdelmegeed.teacherstudentmanegmentsystem.service;

import com.abdelmegeed.teacherstudentmanegmentsystem.model.course;
import com.abdelmegeed.teacherstudentmanegmentsystem.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseService {
    @Autowired
    private courseRepository courseRepository;

    public course save(course course) {
        return courseRepository.save(course);
    }

    public List<course> findAll() {
        return courseRepository.findAll();
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
