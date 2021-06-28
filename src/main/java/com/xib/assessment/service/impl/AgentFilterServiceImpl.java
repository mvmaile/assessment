/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.service.impl;

import com.xib.assessment.model.Agent;
import com.xib.assessment.repository.AgentFilterRepository;
import com.xib.assessment.service.AgentFilterService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maym
 */
@Service
@Slf4j
public class AgentFilterServiceImpl implements AgentFilterService{
    @Autowired
    private AgentFilterRepository agentFilterRepository;

    @Override
    public List<Agent> getAll(Integer pageNo, Integer pageSize, String sortBy) throws Exception {
    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Agent> pagedResult = agentFilterRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Agent>();
        }
    }

    
    }
    

