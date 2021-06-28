/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.service;

import com.xib.assessment.model.Agent;
import com.xib.assessment.request.AgentRequest;
import java.util.List;

/**
 *
 * @author maym
 */
public interface AgentService {
    Agent saveAgent(AgentRequest agentRequest) throws Exception;

    List<Agent> listOfAllAgent() throws Exception;

    Agent getAgent(long id) throws Exception;
}
