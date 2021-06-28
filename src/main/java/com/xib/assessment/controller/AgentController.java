package com.xib.assessment.controller;

import com.xib.assessment.model.Agent;
import com.xib.assessment.request.AgentRequest;
import com.xib.assessment.service.AgentFilterService;
import com.xib.assessment.service.AgentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;
    @Autowired
    private AgentFilterService agentFilterService;

    @PostMapping(path = "", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Object> saveAgent(@Valid @RequestBody AgentRequest agentRequest) throws Exception {
        Agent saveAgent = agentService.saveAgent(agentRequest);
        return new ResponseEntity<>(saveAgent, HttpStatus.CREATED);
    }

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<Object> getAllAgent() throws Exception {
        List<Agent> listOfAllAgent = agentService.listOfAllAgent();
        return new ResponseEntity<>(listOfAllAgent, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Object> getAgent(@PathVariable("id") long id) throws Exception {
        Agent agent = agentService.getAgent(id);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody ResponseEntity<Object> listAgent(@RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy) throws Exception {
           return new ResponseEntity<>(agentFilterService.getAll(pageNo, pageSize, sortBy), HttpStatus.OK);
	}
}
