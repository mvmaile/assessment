/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.repository;

import com.xib.assessment.model.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maym
 */
@Repository
public interface AgentFilterRepository extends PagingAndSortingRepository<Agent, Long>{
    
}
