/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.CartItem;
import entities.Products;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ysajid
 */
@Stateless
@LocalBean
public class ManageCart {
    
    CartItemList items = new CartItemList();
    
    @EJB
    ProductsFacade productsFacade;

    public void addItem(int id) {
        Products p = productsFacade.find(id);
        
        if (p != null) {
            CartItem item;
            try{
                item = items.getItem(id);
                
                if(item != null){
                    item.setCount(item.getCount() + 1);
                }
                else {
                    CartItem newItem = new CartItem(p);
                    items.add(newItem);
                }
            }
            catch(IndexOutOfBoundsException e){
                 CartItem newItem = new CartItem(p);
                 items.add(newItem);
            }

        }
    }
    
    public void removeItem(int id) {
        Products p = productsFacade.find(id);

        if (p != null) {
            CartItem item = items.getItem(id);

            if(item != null){
                if(item.getCount() > 1)
                    item.setCount(item.getCount() - 1);
                else 
                    items.remove(item);
            }
            
        }
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
    
    public int getCartSize(){
        int size = 0;
        for(CartItem item : items){
            size += item.getCount();
        }
        return size;
    }
    
    public void removeAll() {
        items.removeAll(items);
    }
    
    class CartItemList extends ArrayList<CartItem> {

        public CartItem getItem(int i) {
            for(CartItem item : this){
                if(item.getId() == i)
                    return item;
            }
            return null;
        }
        
    }
    
}
