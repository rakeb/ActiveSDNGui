/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui;

import java.util.HashMap;

/**
 *
 * @author Mazharul
 */
public class Event {
    private String name;
    private Integer id;
    private Boolean isDeleted = false;
    public static Integer currentEventId = 0;
    private HashMap<Integer, Signature> signatures = new HashMap<Integer, Signature>();

    public Event(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashMap<Integer, Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(HashMap<Integer, Signature> signatures) {
        this.signatures = signatures;
    }
    
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
    
}
