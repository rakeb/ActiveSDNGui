/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views.actionviews;

import activesdngui.model.GenericSignaturePanel;
import activesdngui.model.Signature;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mislam7
 */
public class ElephantCheckerView extends GenericSignaturePanel {
    
    public static String SIG_NAME = "Elephant Flow Checker";
    public static final String RATE = "Rate";

    /**
     * Creates new form ElephantCheckerView
     */
    public ElephantCheckerView() {
        initComponents();
        customInit();
    }
    private void customInit() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        model.addRow(new Object[]{"Id"});
        model.addRow(new Object[]{"Threshold Rate"});
//        model.addRow(new Object[]{"Switch"});
        jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parameter", "Value", "Comments(Optional)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

//    public JTextField getJtfRate() {
//        return jtfRate;
//    }
//
//    public void setJtfRate(JTextField jtfRate) {
//        this.jtfRate = jtfRate;
//    }

    @Override
    public Signature parseData() {
        Signature signature = new Signature(SIG_NAME, Signature.ELEPHANT_FLOW_CHECKER_ID);

        HashMap<String, Object> fields = signature.getFields();
//        fields.put(RATE, jtfRate.getText());
        
        return signature;
    }

    @Override
    public void loadData(Signature signature) {
        if (signature != null) {
            HashMap<String, Object> fields = signature.getFields();
//            jtfRate.setText((String) fields.get(RATE));
        }
    }

    @Override
    public Integer getSignatureId() {
        return Signature.ELEPHANT_FLOW_CHECKER_ID;
    }

}
