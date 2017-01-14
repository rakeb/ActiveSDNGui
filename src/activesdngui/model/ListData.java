/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.model;

/**
 *
 * @author Mazharul
 */
public class ListData {
    private String name;
    private Object data;

    public ListData() {
    }
    
    
    public ListData(String name, Object data){
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    
}
