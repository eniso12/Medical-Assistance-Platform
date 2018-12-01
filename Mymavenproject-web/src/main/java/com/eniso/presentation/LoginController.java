/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eniso.presentation;
import com.eniso.service.PatientService;
import com.eniso.model.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author roua
 */
@ManagedBean
@SessionScoped

public class LoginController {
    
    
    
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    private Model _model = new Model();
    @EJB
    private PatientService service;

    public String onClick() {
        //View To Model (binding JSF)
        final String login = getModel().getLogin();
        final String password = getModel().getPasssword();

        //Call Business
        Exception ex2 = null;
        User s = null;
        try {
            s = service.login(login, password);
        } catch (Exception ex) {
            ex2 = ex;
        }

        //Model to View
        if (ex2 == null) {
            getModel().setCurrentUser(s);
            return "list";
        } else {
            return null;
        }
    }
    
    public String OnBlur(){
        
        
        return "if you don't have an account please sign up";
    }

    public Model getModel() {
        return _model;
    }

    public static class Model {

        private String login;
        private String passsword;
        private User currentUser;

        public User getCurrentUser() {
            return currentUser;
        }

        public void setCurrentUser(User currentUser) {
            this.currentUser = currentUser;
        }

        
        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPasssword() {
            return passsword;
        }

        public void setPasssword(String passsword) {
            this.passsword = passsword;
        }

    }

}

