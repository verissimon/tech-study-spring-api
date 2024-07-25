package com.study.tech.repository;

import com.study.tech.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologiesRepository extends JpaRepository<Technology, String> {
}
