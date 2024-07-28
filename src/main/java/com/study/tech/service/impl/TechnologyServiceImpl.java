package com.study.tech.service.impl;

import com.study.tech.model.Technology;
import com.study.tech.model.User;
import com.study.tech.repository.TechnologiesRepository;
import com.study.tech.repository.UserRepository;
import com.study.tech.service.TechService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TechnologyServiceImpl implements TechService {
    private final TechnologiesRepository techRepository;
    private final UserRepository userRepository;

    public TechnologyServiceImpl(TechnologiesRepository repository, UserRepository userRepository) {
        this.techRepository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Technology findById(String id) {
        return techRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Technology> findByStudentId(String id) {
        return techRepository.findByStudentId(id);
    }

    @Override
    public List<Technology> findByStudentUsername(String username) {
        return techRepository.findByStudentUsername(username);
    }

    @Override
    public Technology create(Technology tech, String studentId) {
        var student = userRepository.findById(studentId).orElseThrow(NoSuchElementException::new);
        var newTech = techRepository.save(tech);
        student.getTechnologies().add(newTech);
        userRepository.save(student);
        newTech.setStudent(student);
        return techRepository.save(newTech);
    }

    @Override
    public Technology patchStudied(String id, boolean studied) {
        return null;
    }

    @Override
    public Technology update(String title, LocalDate deadline, String studentId) {
        return null;
    }

    @Override
    public void delete(String id) {
        var tech = techRepository.findById(id).orElseThrow(NoSuchElementException::new);
        techRepository.delete(tech);
    }
}
