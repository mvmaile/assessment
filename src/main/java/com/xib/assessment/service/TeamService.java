/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.service;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;
import com.xib.assessment.request.TeamRequest;
import java.util.List;

/**
 *
 * @author Falcorp
 */
public interface TeamService {
    Team saveTeam(TeamRequest teamRequest) throws Exception;

    List<Team> listOfAllTeam() throws Exception;

    Team getTeam(long id) throws Exception;

    boolean isTeamExist(String name) throws Exception;
    
    Agent assignsAgentToTeam(long id) throws Exception;
    List<TeamRequest> listOfTeamNoAgent() throws Exception;
}
