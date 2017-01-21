/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views.actionviews;

import activesdngui.model.GenericSignaturePanel;
import activesdngui.model.ListData;
import activesdngui.model.ListDataModel;
import activesdngui.model.Signature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author mislam7
 */
public class InvestigationActionView extends GenericSignaturePanel {

    public static String SIG_NAME = "CONFIG_ACTION";

    public static final String ACTION_TYPE = "ActionType";
    public static final String RATE = "Rate";
    public static final String SWITCH_ID = "SwitchId";
    public static final String TIME = "Time";

    private ListDataModel model = new ListDataModel();
    ElephantCheckerView elephantCheckerView = new ElephantCheckerView();
    ProtocolCheckerView protocolCheckerView = new ProtocolCheckerView();
    NewComerCheckerView newComerCheckerView = new NewComerCheckerView();

    /**
     * Creates new form InvestigationAction
     */
    public InvestigationActionView() {
        initComponents();
        customInit();
    }

    private void customInit() {

        List<ListData> datas = new ArrayList<>();
        datas.add(new ListData("Check Elephant Flow", elephantCheckerView));
        datas.add(new ListData("Check ICMP/UDP", protocolCheckerView));
        datas.add(new ListData("Check New Comers", newComerCheckerView));
        model.setData(datas);

        for (ListData data : datas) {
            jcbInvestigationActionType.addItem(data.getName());
        }
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
        jcbInvestigationActionType = new javax.swing.JComboBox<>();
        jpInvestigationActionParamHolder = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(520, 365));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Action Type");

        jcbInvestigationActionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        jcbInvestigationActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInvestigationActionTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpInvestigationActionParamHolderLayout = new javax.swing.GroupLayout(jpInvestigationActionParamHolder);
        jpInvestigationActionParamHolder.setLayout(jpInvestigationActionParamHolderLayout);
        jpInvestigationActionParamHolderLayout.setHorizontalGroup(
            jpInvestigationActionParamHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpInvestigationActionParamHolderLayout.setVerticalGroup(
            jpInvestigationActionParamHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpInvestigationActionParamHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jcbInvestigationActionType, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 200, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbInvestigationActionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpInvestigationActionParamHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbInvestigationActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInvestigationActionTypeActionPerformed
        int index = jcbInvestigationActionType.getSelectedIndex();
        ListData data = (ListData) model.getData().get(index);
        if (data.getData() != null) {
            jpInvestigationActionParamHolder.removeAll();
            jpInvestigationActionParamHolder.setLayout(new BoxLayout(jpInvestigationActionParamHolder, BoxLayout.X_AXIS));
            jpInvestigationActionParamHolder.add((JPanel) data.getData());
            jpInvestigationActionParamHolder.revalidate();
            jpInvestigationActionParamHolder.repaint();
        }
    }//GEN-LAST:event_jcbInvestigationActionTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcbInvestigationActionType;
    private javax.swing.JPanel jpInvestigationActionParamHolder;
    // End of variables declaration//GEN-END:variables

    @Override
    public Signature parseData() {
//        Signature signature = new Signature(SIG_NAME, Signature.INVESTIG_ID);
//        
//        HashMap<String, Object> fields = signature.getFields();
//        
//        int index = jcbInvestigationActionType.getSelectedIndex();
//        ListData data = (ListData) model.getData().get(index);
//        
//        if (data.getData() instanceof NewComerCheckerView) {
//            fields.put(SWITCH_ID, newComerCheckerView.getJtfSwitchId().getText());
//            fields.put(TIME, newComerCheckerView.getJtfTime().getText());
//        } else if (data.getData() instanceof ElephantCheckerView) {
//            fields.put(RATE, elephantCheckerView.getJtfRate().getText());
//        } else {
//            fields.put(RATE, protocolCheckerView.getJtfRate().getText());
//        }
//        
//        return signature;
        return null;
    }

    @Override
    public void loadData(Signature signature) {
//        if (signature != null) {
//            HashMap<String, Object> fields = signature.getFields();
//            int index = jcbInvestigationActionType.getSelectedIndex();
//            ListData data = (ListData) model.getData().get(index);
//
//            if (data.getData() instanceof NewComerCheckerView) {
//                newComerCheckerView.getJtfSwitchId().setText((String) fields.get(SWITCH_ID));
//                newComerCheckerView.getJtfTime().setText((String) fields.get(TIME));
//            } else if (data.getData() instanceof ElephantCheckerView) {
//                elephantCheckerView.getJtfRate().setText((String) fields.get(RATE));
//            } else {
//                protocolCheckerView.getJtfRate().setText((String) fields.get(RATE));
//            }
//        }
    }

    @Override
    public Integer getSignatureId() {
        return Signature.INVESTIG_ID;
    }
}
