/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views;

import activesdngui.model.Action;
import activesdngui.model.Event;
import activesdngui.model.GenericSignaturePanel;
import activesdngui.model.ListData;
import activesdngui.model.ListDataModel;
import activesdngui.model.Signature;
import activesdngui.views.actionviews.ConfigurationActionView;
import activesdngui.views.actionviews.InvestigationActionView;
import activesdngui.views.eventviews.ArpView;
import activesdngui.views.eventviews.IcmpView;
import activesdngui.views.eventviews.IgmpView;
import activesdngui.views.eventviews.IpView;
import activesdngui.views.eventviews.TcpView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author mislam7
 */
public class ActionView extends javax.swing.JPanel {
    
    private Action action = null;
    private ListDataModel model = new ListDataModel();
    private AllActions allActions;
    
    ConfigurationActionView configurationActionView = new ConfigurationActionView();
    InvestigationActionView investigationActionView = new InvestigationActionView();
    
    /**
     * Creates new form ActionView
     */
    public ActionView() {
        initComponents();
        customInit();
    }
    
    public ActionView(AllActions allActions) {
        this.allActions = allActions;
        initComponents();
        customInit();
    }
    
    private void customInit() {
        handleButtons();
        //populate signature model
        List<ListData> datas = new ArrayList<>();
        datas.add(new ListData("Configuration Action", configurationActionView));
        datas.add(new ListData("Investigation Action", investigationActionView));
        model.setData(datas);
        
        for (ListData data : datas) {
            jcbActionType.addItem(data.getName());
        }
    }
    
    public void loadData(Action e) {
        this.action = e;
        jtfActionName.setText(e.getName());
        
         for(int i=0; i<model.getSize(); i++){
            GenericSignaturePanel gsp = (GenericSignaturePanel) model.getData().get(i).getData();
            if(gsp!=null){
                gsp.loadData(e.getSignatures().get(gsp.getSignatureId()));
            }
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

        jpActionParamHolder = new javax.swing.JPanel();
        jbtSave = new javax.swing.JButton();
        jbtDelete = new javax.swing.JButton();
        jtfActionName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbActionType = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jpActionParamHolderLayout = new javax.swing.GroupLayout(jpActionParamHolder);
        jpActionParamHolder.setLayout(jpActionParamHolderLayout);
        jpActionParamHolderLayout.setHorizontalGroup(
            jpActionParamHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jpActionParamHolderLayout.setVerticalGroup(
            jpActionParamHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        jbtSave.setText("Save");
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
            }
        });

        jbtDelete.setText("Delete");
        jbtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Action name:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Action Type");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Action Fields");

        jcbActionType.setModel(new CustomActions());
        jcbActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActionTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfActionName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jbtSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtDelete)
                                .addGap(54, 54, 54))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbActionType, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(261, 261, 261))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpActionParamHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jtfActionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jcbActionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jpActionParamHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSave)
                    .addComponent(jbtDelete))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        String name = jtfActionName.getText();
        System.out.println("Action name: " + name);
        if(action == null){
            //creating new event
            action = new Action(name, Action.currentActionId);
            Action.currentActionId++;
        }
        action.setName(name);
        for(int i=0; i<model.getSize(); i++){
            GenericSignaturePanel gsp = (GenericSignaturePanel) model.getData().get(i).getData();
            if(gsp!=null){
                Signature sig = gsp.parseData();
                if(sig!=null){
                    action.getSignatures().put(sig.getId(), sig);
                }
            }
        }

        allActions.eventUpdated(action);

    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
//        if (event != null) {
//            event.setIsDeleted(Boolean.TRUE);
//            allEventPanel.eventUpdated(event);
//        }
//        else {
//            JOptionPane.showMessageDialog(this, "Cannot delete. Event not saved yet");
//        }
    }//GEN-LAST:event_jbtDeleteActionPerformed

    private void jcbActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActionTypeActionPerformed
        int index = jcbActionType.getSelectedIndex();
        ListData data = model.getData().get(index);
        if(data.getData()!=null){
            jpActionParamHolder.removeAll();
            jpActionParamHolder.setLayout(new BoxLayout(jpActionParamHolder, BoxLayout.X_AXIS));
            jpActionParamHolder.add((JPanel)data.getData());
            jpActionParamHolder.revalidate();
            jpActionParamHolder.repaint();
        }
    }//GEN-LAST:event_jcbActionTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jbtSave;
    private javax.swing.JComboBox<String> jcbActionType;
    private javax.swing.JPanel jpActionParamHolder;
    private javax.swing.JTextField jtfActionName;
    // End of variables declaration//GEN-END:variables
    
    class CustomActions extends DefaultComboBoxModel{

        String [] items; 
        public CustomActions() {
            items = new String[] { "Item 1", "Item 2", "Item 3", "Item 4" };
            DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(items);
        }
    }
    
    private void handleButtons() {
        jbtSave.setEnabled(false);
        jbtDelete.setEnabled(false);
        jtfActionName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
              changed();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
              changed();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
              changed();
            }

            public void changed() {
               if (jtfActionName.getText().equals("")){
                 jbtSave.setEnabled(false);
                 jbtDelete.setEnabled(false);
               }
               else {
                 jbtSave.setEnabled(true);
                 jbtDelete.setEnabled(true);
              }

            }
        });
    }
}