package org.example.service;

import org.example.model.AssignmentDTO;

import java.util.List;

public interface AssignmentService {
    void addAssignment(AssignmentDTO assignmentDTO);
    List<AssignmentDTO> getAll();
}
