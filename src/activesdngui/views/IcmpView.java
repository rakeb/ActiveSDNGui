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
 * @author mislam7
 */
public class IcmpView extends GenericSignaturePanel {

    public static String sigName = "ICMP";

    public static final String TOS = "tos";
    public static final String TTL = "ttl";
    public static final String PROTOCOL = "protocol";
    public static final String SOURCE_IP = "sourceIp";
    public static final String DESTINATION_IP = "destinationIp";
    /**
     * Creates new form IcmpView
     */
    public IcmpView() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTos = new javax.swing.JTextField();
        jtfTtl = new javax.swing.JTextField();
        jtfProtocol = new javax.swing.JTextField();
        jtfSourceIp = new javax.swing.JTextField();
        jtfDestinationIp = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(520, 365));

        jLabel1.setText("TOS");

        jLabel2.setText("TTL");

        jLabel3.setText("Protocol");

        jLabel4.setText("Source Ip");

        jLabel5.setText("Destination Ip");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDestinationIp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSourceIp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTtl, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfTos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfTtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfProtocol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfSourceIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfDestinationIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jtfDestinationIp;
    private javax.swing.JTextField jtfProtocol;
    private javax.swing.JTextField jtfSourceIp;
    private javax.swing.JTextField jtfTos;
    private javax.swing.JTextField jtfTtl;
    // End of variables declaration//GEN-END:variables

    @Override
    public Signature parseData() {
        Signature signature = new Signature(sigName, Signature.ICMP_ID);

        HashMap<String, Object> fields = signature.getFields();
        fields.put(TOS, jtfTos.getText());
        fields.put(TTL, jtfTtl.getText());
        fields.put(PROTOCOL, jtfProtocol.getText());
        fields.put(SOURCE_IP, jtfSourceIp.getText());
        fields.put(DESTINATION_IP, jtfDestinationIp.getText());
        
        return signature;
    }

    @Override
    public void loadData(Signature signature) {
        if (signature != null) {
            HashMap<String, Object> fields = signature.getFields();
            jtfTos.setText((String) fields.get(TOS));
            jtfTtl.setText((String) fields.get(TTL));
            jtfProtocol.setText((String) fields.get(PROTOCOL));
            jtfSourceIp.setText((String) fields.get(SOURCE_IP));
            jtfDestinationIp.setText((String) fields.get(DESTINATION_IP));
        }
    }

    @Override
    public Integer getSignatureId() {
        return Signature.ICMP_ID;
    }
}
