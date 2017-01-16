/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.model;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author mislam7
 */
public class Operator extends DefaultMutableTreeNode {
    
    public enum OperatorType
    {
        IF,
        Else,
        Parallel,
        Sequential
    }
    
    public OperatorType Type;
    String Name;
    
    public Operator(OperatorType t, String name)
    {
        Type = t;
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }
    
    
    
}
