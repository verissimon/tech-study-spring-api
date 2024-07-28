package com.study.tech.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tb_technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id = "";
    private String title;
    private boolean studied = false;
    private LocalDate deadline;
    @ManyToOne
    private User student;

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

    public boolean isStudied() {
        return studied;
    }

    public void setStudied(boolean studied) {
        this.studied = studied;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
