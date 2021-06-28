/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.service.impl;

import com.xib.assessment.exception.ResourceNotFoundException;
import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Manager;
import com.xib.assessment.model.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.ManagerRepository;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.request.AgentRequest;
import com.xib.assessment.request.ManagerRequest;
import com.xib.assessment.service.AgentService;
import com.xib.assessment.service.ManagerService;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maym
 */
@Service
@Transactional
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Manager saveManager(ManagerRequest managerRequest) throws Exception {
        Manager saveManager = null;
        try {

            Team team = teamRepository.findbyName(managerRequest.getTeamName());
            if (team != null) {
            List<Manager> findIfTeamIsNotMoreThanTwo = managerRepository.findByTeam(team);
            if (findIfTeamIsNotMoreThanTwo.size() < 2) {
              Manager manager = new Manager();
                manager.setFirstName(managerRequest.getFirstName());
                manager.setLastName(managerRequest.getLastName());
                manager.setIdNumber(managerRequest.getIdNumber());
                manager.setTeam(team);
                saveManager = managerRepository.save(manager);
                log.info("Manager saved successfully with manager name {}", saveManager.getFirstName() + " " + saveManager.getLastName());
            } else {
                 throw new ResourceNotFoundException("Team can only manager by not more than two managers");
            }
            }else{
                   throw new ResourceNotFoundException("No Team  found");
              
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Failed to save manager names {} cause of {} ", managerRequest.getFirstName() + " " + managerRequest.getLastName(), ex.getMessage());
           throw ex;
        }
        return saveManager;
    }

}
