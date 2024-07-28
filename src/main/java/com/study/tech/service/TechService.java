package com.study.tech.service;

import com.study.tech.model.Technology;
import com.study.tech.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TechService {
    Technology findById(String id);
    List<Technology> findByStudentId(String id);
    List<Technology> findByStudentUsername(String username);
    Technology create(Technology tech, String studentId);
    Technology patchStudied(String id, boolean studied);
    Technology update(String title, LocalDate deadline, String studentId );
    void delete(String id);

}
