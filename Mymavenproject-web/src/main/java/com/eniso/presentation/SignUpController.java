/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eniso.presentation;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;
import com.eniso.model.User;
import com.eniso.service.UserService;
/**
 *
 * @author roua
 */
@ManagedBean
@SessionScoped

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Raghda
 */
public class SignUpController {
     private Model model = new Model();
     @EJB
     private UserService service;
     
      public String onSignUp() {
        //View To Model (binding JSF)
        
         String type = getModel().getType();
         String firstname = getModel().getName();
         String lastname = getModel().getName();
         String gender= getModel().getGender();
         String adress= getModel().getAdress();
         String city= getModel().getCity();
         int tel= getModel().getTel();
         String login= getModel().getLogin();
         String password= getModel().getPassword();

        //Call Business
        Exception ex2 = null;
        User user = null;
        try {
            user = service.signUp(firstname,lastname,gender,adress,city,login,password,tel);
        } catch (Exception ex) {
            ex2 = ex;
        }

        //Model to View
        if (ex2 == null) {
            //getModel().setCurrentUser(s);
            return "list";
        } else {
            return null;
        }
    }

    public Model getModel() {
        return model;
    }
      
      public static class Model {
        
        private String type;
        private String name;
        private String gender;
        private String adress;
        private String city;
        private int tel;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getTel() {
            return tel;
        }

        public void setTel(int tel) {
            this.tel = tel;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        private String login;
        private String password;
        }
}
