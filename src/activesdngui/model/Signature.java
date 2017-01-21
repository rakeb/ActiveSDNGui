/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.model;

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
    public static final Integer ELEPHANT_FLOW_CHECKER_ID = 5;
    public static final Integer NEW_COMER_CHECKER_ID = 6;
    public static final Integer UDP_ICMP_CHECKER_ID = 7;
    public static final Integer DROP_ID = 8;
    public static final Integer NOTIFY_ID = 9;
    public static final Integer DROP_AND_NOTIFY_ID = 10;
    public static final Integer MIGRATE_ID = 11;
    public static final Integer ACTION_ID = 12;
    public static final Integer CONFIG_ID = 13;
    public static final Integer INVESTIG_ID = 14;

    private String name;
    private Integer id;
    private HashMap<String, Object> fields = new HashMap<>();

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
}
