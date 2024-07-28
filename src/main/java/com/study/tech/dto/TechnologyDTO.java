package com.study.tech.dto;

import com.study.tech.model.Technology;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TechnologyDTO {
    private String id;
    private String title;
    private LocalDate deadline;
    private String studentId;
    private boolean studied;

    public boolean isStudied() {
        return studied;
    }

    public void setStudied(boolean studied) {
        this.studied = studied;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public static List<TechnologyDTO> buildTechDTO(List<Technology> userTechs) {
        List<TechnologyDTO> techs = new ArrayList<>();
        for (Technology tech : userTechs) {
            TechnologyDTO techDTO = new TechnologyDTO();
            techDTO.setTitle(tech.getTitle());
            techDTO.setStudied(tech.isStudied());
            techDTO.setStudentId(tech.getStudent().getId());
            techDTO.setDeadline(tech.getDeadline());
            techDTO.setId(tech.getId());
            techs.add(techDTO);
        }
        return techs;
    }
}