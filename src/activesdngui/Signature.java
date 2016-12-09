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
public class Signature {
    
    //defined IDs
    public static final Integer TCP_ID = 0;
    public static final Integer IP_ID = 1;
    public static final Integer ARP_ID = 2;
    public static final Integer ICMP_ID = 3;
    public static final Integer IGMP_ID = 4;
    
    
    private String name;
    private Integer id;
    private Boolean isValid = false;
    private HashMap<String, Object> fields = new HashMap<String, Object>();

    public Signature(String name, Integer id) {
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

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
    
    
}
