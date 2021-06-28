/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.service;
import com.xib.assessment.model.Agent;
import java.util.List;

/**
 *
 * @author maym
 */
public interface AgentFilterService {
  public List<Agent> getAll(Integer pageNo, Integer pageSize, String sortBy) throws Exception;
}
