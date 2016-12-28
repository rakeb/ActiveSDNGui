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
public class Pattern {
    public static final String WINDOW = "WINDOW";
    public static final String COUNT = "COUNT";
    
    private String patternName;
    private Integer patternId;
    
    private HashMap<String, Object> fields = new HashMap<>();

    public Pattern() {
    }

    public Pattern(String patternName, Integer patternId) {
        this.patternName = patternName;
        this.patternId = patternId;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public Integer getPatternId() {
        return patternId;
    }

    public void setPatternId(Integer patternId) {
        this.patternId = patternId;
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }
    
}
