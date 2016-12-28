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
    
    private String actionName;
    private Integer actionId;
    private HashMap<String, Object> fields = new HashMap<>();

    public Action() {
    }

    
    public Action(String actionName, Integer actionId) {
        this.actionName = actionName;
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }
    
}
