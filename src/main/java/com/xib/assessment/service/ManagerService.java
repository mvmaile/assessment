/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.service;

import com.xib.assessment.model.Manager;
import com.xib.assessment.request.ManagerRequest;

/**
 *
 * @author maym
 */
public interface ManagerService {
    Manager saveManager(ManagerRequest managerRequest) throws Exception;

    
}
