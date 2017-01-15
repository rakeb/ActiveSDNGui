/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.model;

import java.util.HashMap;

/**
 *
 * @author mislam7
 */
public class Action {
    
    public enum ActionList {
        DROP, NOTIFY, DROPANDNOTIFY, MIGRATE
    }
    public static final String ACTION = "ACTION";
    
    private String name;
    private Integer id;
    public static Integer currentActionId = 0;
    private Boolean isDeleted = false;
    private HashMap<Integer, Signature> signatures = new HashMap<>();

    public Action() {
    }

    
    public Action(String actionName, Integer actionId) {
        this.name = actionName;
        this.id = actionId;
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
