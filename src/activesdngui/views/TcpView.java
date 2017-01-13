/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views;

import activesdngui.model.GenericSignaturePanel;
import activesdngui.model.Signature;
import java.util.HashMap;

/**
 *
 * @author Mazharul
 */
public class TcpView extends GenericSignaturePanel {
    
    public static String sigName = "TCP";
    
    public static final String SEQUENCE_NUMBER = "sequenceNumber";
    public static final String SOURCE_PORT = "sourcePort";
    public static final String DESTINATION_PORT = "destinationPort";
    
    /**
     * Creates new form TcpView
     */
    public TcpView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfSourcePort = new javax.swing.JTextField();
        jckAddSignature = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jtfDestinationPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfSequenceNumber = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(420, 200));

        jLabel1.setText("Source Port");

        jckAddSignature.setText("Add signature");

        jLabel2.setText("Destination Port");

        jLabel3.setText("Sequence Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfSourcePort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jtfDestinationPort, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfSequenceNumber))
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jckAddSignature)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jckAddSignature)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfSourcePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDestinationPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfSequenceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(240, 240, 240))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox jckAddSignature;
    private javax.swing.JTextField jtfDestinationPort;
    private javax.swing.JTextField jtfSequenceNumber;
    private javax.swing.JTextField jtfSourcePort;
    // End of variables declaration//GEN-END:variables

    @Override
    public Signature parseData() {
        Signature signature = new Signature(sigName, Signature.TCP_ID);
        signature.setIsValid(jckAddSignature.isSelected());

        HashMap<String, Object> fields = signature.getFields();
        fields.put(SOURCE_PORT, jtfSourcePort.getText());
        fields.put(DESTINATION_PORT, jtfDestinationPort.getText());
        fields.put(SEQUENCE_NUMBER, jtfSequenceNumber.getText());
        
        return signature;
    }

    @Override
    public void loadData(Signature signature) {
        if (signature != null) {
            jckAddSignature.setSelected(signature.getIsValid());
            if (signature.getIsValid()) {
                HashMap<String, Object> fields = signature.getFields();
                jtfSourcePort.setText((String) fields.get(SOURCE_PORT));
                jtfDestinationPort.setText((String) fields.get(DESTINATION_PORT));
                jtfSequenceNumber.setText((String) fields.get(SEQUENCE_NUMBER));
            }
        }
    }

    @Override
    public Integer getSignatureId() {
        return Signature.TCP_ID;
    }
}
