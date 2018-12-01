package com.eniso.service;
import com.eniso.model.Consultation;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roua
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)

public class DoctorService extends UserService{
     @PersistenceContext
     EntityManager em;
     Consultation consult=new Consultation();
    
        private void Write_presciption(Consultation consult,List<String> medicine){

            consult.setMedicine(medicine);
}
        
        
        
        
}