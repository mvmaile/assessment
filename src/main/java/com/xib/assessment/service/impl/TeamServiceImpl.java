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
import com.xib.assessment.request.TeamRequest;
import com.xib.assessment.service.TeamService;
import java.util.ArrayList;
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
public class TeamServiceImpl implements TeamService{
@Autowired
private TeamRepository teamRepository;
@Autowired
private AgentRepository agentRepository;
    @Override
    public Team saveTeam(TeamRequest teamRequest) throws Exception {
        Team saveTeam = null;
        try {
            if (teamRepository.findbyName(teamRequest.getName()) != null) {
                throw new ResourceNotFoundException("Team with this name " + teamRequest.getName() + " already exist");
            } else {
                Team team = new Team();
                team.setName(teamRequest.getName());
                saveTeam = teamRepository.save(team);
                log.info("Team saved successfully with name {}", saveTeam.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Failed to save Team names {} cause of {} ", teamRequest.getName(), ex.getMessage());
            throw ex;

        }
        return saveTeam;
    }

    @Override
    public List<Team> listOfAllTeam() throws Exception {
        List<Team> allTeam = null;
        try {
            allTeam = teamRepository.findAll();
            log.info("Retrieved all team and size is {} ", allTeam.size());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Failed retrieved all team cause is {} ", ex.getMessage());
        }
        return allTeam;
    }

    @Override
    public Team getTeam(long id) throws Exception {
    Team team = null;
        try {
            team = teamRepository.findById(id);
            log.info("Retrieved an team and with names {} ", team.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Failed retrieved an team cause is {} ", ex.getMessage());
        }
        return team;
    }

    @Override
    public boolean isTeamExist(String name) throws Exception {
        boolean teamExist = false;
        try {
            Team team = teamRepository.findbyName(name.trim());
            if (team != null) {
                teamExist = true;
                log.info("Team already exist is name {}", team.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.info("Error check team already exist cause of {}", ex.getMessage());

        }
        return teamExist;
    }

    @Override
    public Agent assignsAgentToTeam(long id) throws Exception {
        Team team = null;
        Agent agentUpdate = null;
        try {
            team = teamRepository.findById(id);
            agentUpdate = agentRepository.findById(team.getId());
            if (agentUpdate != null) {
                agentUpdate.setTeam(team);
                agentUpdate = agentRepository.save(agentUpdate);
                log.info("Manage to assign a agent to team called {} ",team.getName());
            }else{
                new ResourceNotFoundException("Agent does not exist!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            log.info("Failed to assign an agent to team cause {} ",ex.getMessage());
         throw ex;
        }
        return agentUpdate;
    }

    @Override
    public List<TeamRequest> listOfTeamNoAgent() throws Exception {
        List<TeamRequest> listOfTeam = new ArrayList<>();
        try {
            List<String> names = teamRepository.namesOfTeamWithoutAgent();
            for (String name : names) {
                TeamRequest teamRequest = new TeamRequest();
                log.info("Name without an agent is {} ",name);
                teamRequest.setName(name);
                listOfTeam.add(teamRequest);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.info("Error retrieving team name without an agent cause {} ",ex.getMessage());
        }
        return listOfTeam;
    }

}
