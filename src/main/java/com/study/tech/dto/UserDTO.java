package com.study.tech.dto;

import java.util.List;

public class UserDTO {
    private String id;
    private String username;
    private List<TechnologyDTO> technologies;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TechnologyDTO> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyDTO> technologies) {
        this.technologies = technologies;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
