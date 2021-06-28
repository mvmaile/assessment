/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.repository;

import com.xib.assessment.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maym
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    Team findById(long id);
    @Query(value = "SELECT * from team where name =?1", nativeQuery = true)
    Team findbyName(String name);
    @Query(value = "SELECT te.name FROM AGENT ag,TEAM te,MANAGER mgn where  te.id <> ag.team_id AND te.id <> mgn.team_id",nativeQuery = true)
    List<String> namesOfTeamWithoutAgent();
}
