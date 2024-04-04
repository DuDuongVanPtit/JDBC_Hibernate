package org.example.service.impl;

import org.example.converter.DTOConverter;
import org.example.converter.EntityConverter;
import org.example.model.AssignmentDTO;
import org.example.repository.AssignmentRepository;
import org.example.repository.entity.AssignmentEntity;
import org.example.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public void addAssignment(AssignmentDTO assignmentDTO) {
        assignmentRepository.addAssignment(EntityConverter.toAssignmentEntity(assignmentDTO));
    }

    @Override
    public List<AssignmentDTO> getAll() {
        List<AssignmentEntity> assignmentEntities = assignmentRepository.getAll();
        List<AssignmentDTO> assignmentDTOS = new ArrayList<>();
        for(AssignmentEntity a : assignmentEntities){
            assignmentDTOS.add(DTOConverter.assignmentEntityToAssignmentDTO(a));
        }
        return assignmentDTOS;
    }
}
