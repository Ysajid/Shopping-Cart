/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author ysajid
 */
public class CartItem implements Serializable {
    
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String COUNT = "count";
    
    private int id;
    private String name;
    private String description;
    private int count;

    public CartItem(Products p) {
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.count = 1;
    }

    public void setCount(int count) {
        this.count= count;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        int oldId = id;
        this.id = id;
        propertySupport.firePropertyChange(ID, oldId, id);
    }

    public void setName(String name) {
        String oldName = name;
        this.name = name;
        propertySupport.firePropertyChange(NAME, oldName, name);
    }

    public void setDescription(String description) {
        String oldDescription = description;
        this.description = description;
        propertySupport.firePropertyChange(DESCRIPTION, oldDescription, description);
    }
    
    private PropertyChangeSupport propertySupport;
    
    public CartItem() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
