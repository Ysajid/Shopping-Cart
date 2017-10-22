/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ysajid
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "Shopping-Cart-ejbPU")
    private EntityManager em;
    
    private Users loggedInUser;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    public boolean isAuthenticated(final String username, final String password) {
        Users user = find(username);
        if(user != null && user.getPassword().equals(password)){
            loggedInUser = user;
            return true;
        }
        return false;
    }
    
}
