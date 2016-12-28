/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Mazharul
 */
public class ListDataModel extends AbstractListModel<String>{
    private List<ListData> data =new ArrayList<>();
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public String getElementAt(int index) {
        return data.get(index).getName();
    }

    public List<ListData> getData() {
        return data;
    }

    public void setData(List<ListData> data) {
        this.data = data;
    }
    
    
}
