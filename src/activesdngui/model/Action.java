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
    
    public static final String DO = "DO";
    public static final String ON = "ON";
    public static final String OF = "OF";
    public static final String BY = "BY";
    public static final String USING = "USING";
    public static final String FOR = "FOR";
    public static final String OUTCOME = "OUTCOME";
    public static final String ACTION = "ACTION";
    
    public enum ActionType {
        DROP, 
        NOTIFY, 
        DROPANDNOTIFY, 
        MIGRATE, 
        ELEPHANTFLOWCHECKER, 
        NEWCOMERCHECKER,
        UDPICMPCHECKER
    }
    
    public static Integer currentActionId = 0;

    private String name;
    private Integer id;
    private Boolean isDeleted = false;
    private ActionType actionType;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public HashMap<Integer, Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(HashMap<Integer, Signature> signatures) {
        this.signatures = signatures;
    }
}
