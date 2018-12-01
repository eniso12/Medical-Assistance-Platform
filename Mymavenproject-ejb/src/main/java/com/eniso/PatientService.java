/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eniso.service;

import com.eniso.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author roua
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PatientService extends UserService {
    @PersistenceContext
    private EntityManager em;
    
    public User login(String login, String password) throws Exception {

        // SQL !
//        // insert
//        em.persist(login);
//        // update
//        em.merge();
//        // delete
//        em.remove();
//        ///select
//        em.createQuery(deleteQuery);
        // JPQL 
        /*  // SQL / JPQL Injection
         *   login = "' or '1'='1"
         *   password = "toto"
         *  Select hamadi from User hamadi 
         * where hamadi.login='' or '1'='1' and password='toto'
         */
        List<User> u = em.createQuery("Select hamadi from User hamadi "
                + " where hamadi.login=:log"
                + " and  hamadi.password=:pas"
        ).setParameter("log", login)
                .setParameter("pas", password)
                //exec
                .getResultList();
        if (!u.isEmpty()) {
            return u.get(0);
        }
        throw new Exception();
    }
    
    public void askConsultation(){
    
    
    }
    
    
    
    
    
    
    
    
}
