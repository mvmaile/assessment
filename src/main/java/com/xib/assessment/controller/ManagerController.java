/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.controller;

import com.xib.assessment.model.Agent;
import com.xib.assessment.model.Manager;
import com.xib.assessment.request.AgentRequest;
import com.xib.assessment.request.ManagerRequest;
import com.xib.assessment.service.ManagerService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maym
 */
@RestController
@RequestMapping("api/v1/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
     @PostMapping(path = "", consumes = "application/json")
     
    public @ResponseBody
    ResponseEntity<Object> saveManager(@Valid @RequestBody ManagerRequest managerRequest) throws Exception {
        Manager saveManager = managerService.saveManager(managerRequest);
        return new ResponseEntity<>(saveManager, HttpStatus.CREATED);
    }

}
