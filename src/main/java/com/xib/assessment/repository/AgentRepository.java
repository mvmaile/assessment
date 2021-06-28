package com.xib.assessment.repository;

import com.xib.assessment.model.Agent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
Agent findById(long id);
   
}
