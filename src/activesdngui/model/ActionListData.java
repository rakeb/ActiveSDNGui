/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.model;

/**
 *
 * @author mislam7
 */
public class ActionListData extends ListData{
    private boolean show;

    public ActionListData() {
    }

    public ActionListData(boolean show) {
        this.show = show;
    }

    public ActionListData(boolean show, String name, Object data) {
        super(name, data);
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
