/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.model;

import javax.swing.JPanel;

/**
 *
 * @author Mazharul
 */
public abstract class GenericSignaturePanel extends JPanel{
    
    public abstract Signature parseData();
    public abstract void loadData(Signature signature);
    public abstract Integer getSignatureId();
}
