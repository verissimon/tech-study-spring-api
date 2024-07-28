package com.study.tech.repository;

import com.study.tech.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologiesRepository extends JpaRepository<Technology, String> {
    @Query("SELECT t FROM tb_technology t WHERE t.student.username = :username")
    List<Technology> findByStudentUsername(@Param("username") String username);

    @Query("SELECT t FROM tb_technology t WHERE t.student.id = :id")
    List<Technology> findByStudentId(@Param("id") String id);
}
