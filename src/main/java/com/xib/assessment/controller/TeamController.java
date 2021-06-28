/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.controller;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Team;
import com.xib.assessment.request.TeamRequest;
import com.xib.assessment.service.TeamService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maym
 */
@RestController
@RequestMapping("api/v1/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(path = "", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Object> saveTeam(@Valid @RequestBody TeamRequest teamRequest) throws Exception {
        Team saveTeam = teamService.saveTeam(teamRequest);
        return new ResponseEntity<>(saveTeam, HttpStatus.CREATED);
    }

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<Object> getAllTeam() throws Exception {
        List<Team> listOfAllTeam = teamService.listOfAllTeam();
        return new ResponseEntity<>(listOfAllTeam, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Object> getTeam(@PathVariable("id") long id) throws Exception {
        Team team = teamService.getTeam(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}/agent", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Object> saveUpdateAgent(@PathVariable("id") long id) throws Exception {
        Agent assignAgentToTeam = teamService.assignsAgentToTeam(id);
        return new ResponseEntity<>(assignAgentToTeam, HttpStatus.OK);
    }

    @GetMapping(path = "/noagent", produces = "application/json")
    public @ResponseBody
    ResponseEntity<Object> teamWithoutAgent() throws Exception {
        List<TeamRequest> teamWithoutAgent = teamService.listOfTeamNoAgent();
        return new ResponseEntity<>(teamWithoutAgent, HttpStatus.OK);
    }
}
