/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eniso.service;

/**
 *
 * @author roua
 */
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.eniso.model.User;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Raghda
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserService {

    @PersistenceContext
    private EntityManager em;
    User user = new User();

    public User signUp(
            String FirstName,
            String LastName,
            
            String gender,
            String adress,
            String city,
            String login,
            String password,
            int tel) {

        List<User> users = (List<User>) em.createQuery("Select user from User user where user.FirstName=:FirstName"
                +"and user.FirstName=:FirstName"
                + " and user.adress=:adress "
                + "and user.city=:city and user.gender=:gender "
                + "and user.tel=:tel and user.login=:login "
                + "and user.password=:password").setParameter("FirstName", FirstName).setParameter("LastName", LastName).setParameter("adress", adress)
                .setParameter("city", city).setParameter("gender", gender).setParameter("tel", tel)
                .setParameter("login", login).setParameter("password", password).getResultList();
        em.persist(users);
        user.setAddress(adress);
        user.setCity(city);
        user.setGender(gender);
        user.setLogin(login);
        user.setFirstName(FirstName);
        user.setFirstName(LastName);

        user.setPassword(password);
        user.setTel(tel);
        return user;

    }

}
