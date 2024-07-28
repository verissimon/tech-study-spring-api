package com.study.tech.controller;

import com.study.tech.dto.TechnologyDTO;
import com.study.tech.model.Technology;
import com.study.tech.service.impl.TechnologyServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {
    private final TechnologyServiceImpl techService;

    public TechnologyController(TechnologyServiceImpl techService) {
        this.techService = techService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<TechnologyDTO> save(@RequestBody Technology t, @PathVariable String studentId) {
        var tech = techService.create(t, studentId);
        TechnologyDTO techDTO = new TechnologyDTO();
        techDTO.setId(tech.getId());
        techDTO.setTitle(tech.getTitle());
        techDTO.setDeadline(tech.getDeadline());
        techDTO.setStudentId(studentId);
        return ResponseEntity.ok(techDTO);
    }
}
