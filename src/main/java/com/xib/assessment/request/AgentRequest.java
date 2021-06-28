/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author maym
 */
@Setter
@Getter
public class AgentRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String teamName;
}
