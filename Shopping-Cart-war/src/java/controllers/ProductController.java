/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import sessionbeans.ManageCart;
import sessionbeans.ProductsFacade;
import sessionbeans.UsersFacade;

/**
 *
 * @author ysajid
 */
@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    String username = "";
    String password = "";
    
    @EJB
    private ProductsFacade productsFacade;
    @EJB
    private ManageCart manageCart;
    @EJB
    private UsersFacade usersFacade;

    public List<entities.Products> allProducts() {
        return productsFacade.findAll();
    }
    
    public ProductController() {
    }
    
    public void addItemToCart(int id){
        manageCart.addItem(id);
    }
    
    public void removeItemFromCart(int id){
        manageCart.removeItem(id);
    }
    
    public List<entities.CartItem> allItemsInCart() {
        return manageCart.getItems();
    }
    
    public int cartSize() {
        return manageCart.getCartSize();
    }
    
    public void checkout() {
        manageCart.removeAll();
    }
    
    public String authenticate() {
        if(usersFacade.isAuthenticated(username, password)){
            return "cart";
        }
        return "login";
    }
    
    
}
