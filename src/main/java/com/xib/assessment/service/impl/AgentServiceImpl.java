/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.service.impl;

import com.xib.assessment.exception.ResourceNotFoundException;
import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;
import com.xib.assessment.repository.AgentRepository;
import com.xib.assessment.repository.TeamRepository;
import com.xib.assessment.request.AgentRequest;
import com.xib.assessment.service.AgentService;
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
public class AgentServiceImpl implements AgentService{
@Autowired
private AgentRepository agentRepository;
@Autowired
private TeamRepository teamRepository;
    @Override
    public Agent saveAgent(AgentRequest agentRequest) throws Exception {
        Agent saveAgent = null;
        try {
            Team team = teamRepository.findbyName(agentRequest.getTeamName());
            if(team != null){
             Agent agent = new Agent();
            agent.setFirstName(agentRequest.getFirstName());
            agent.setLastName(agentRequest.getLastName());
            agent.setIdNumber(agentRequest.getIdNumber());
            agent.setTeam(team);
            saveAgent = agentRepository.save(agent);
            log.info("Agent saved successfully with agent name {}", saveAgent.getFirstName() + " " + saveAgent.getLastName());
            }else{
                throw new ResourceNotFoundException("No Team  found");
            }
            } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Failed to save agent names {} cause of {} ", agentRequest.getFirstName() + " " + agentRequest.getLastName(), ex.getMessage());
            throw ex;
        }
        return saveAgent;
    }

    @Override
    public List<Agent> listOfAllAgent() throws Exception {
        List<Agent> allAgent = null;
        try {
          allAgent = agentRepository.findAll();
          log.info("Retrieved all agent and size is {} ",allAgent.size());
        } catch (Exception ex) {
        ex.printStackTrace();
          log.error("Failed retrieved all agent cause is {} ",ex.getMessage());
       }
        return allAgent;
    }

    @Override
    public Agent getAgent(long id) throws Exception {
        Agent agent = null;
        try {
            agent = agentRepository.findById(id);
            log.info("Retrieved an agent and with names {} ", agent.getFirstName() + " " + agent.getLastName());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Failed retrieved an agent cause is {} ", ex.getMessage());
        }
        return agent;
    }
    
}
