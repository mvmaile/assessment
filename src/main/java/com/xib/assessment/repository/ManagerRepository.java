package com.xib.assessment.repository;

import com.xib.assessment.model.Manager;
import com.xib.assessment.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author maym
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
Manager findById(long id);
List<Manager> findByTeam(Team team);
   
}
