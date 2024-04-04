package org.example.repository;

import org.example.repository.entity.AssignmentEntity;

import java.util.List;

public interface AssignmentRepository {
    void addAssignment(AssignmentEntity assignmentEntity);
    List<AssignmentEntity> getAll();
}

