package com.xib.assessment.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manager")
@Setter
@Getter
public class Manager extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "id_number")
    private String idNumber;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
