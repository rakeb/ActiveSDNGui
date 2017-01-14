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
//import activesdngui.model.ListDataModel;
import activesdngui.model.Signature;
import activesdngui.utility.Utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Mazharul
 */
public class EventView extends javax.swing.JPanel {

    private Event event = null;
    
    TcpView tcpView = new TcpView();
    IpView ipView = new IpView();
    ArpView arpView = new ArpView();
    IgmpView igmpView = new IgmpView();
    IcmpView icmpView = new IcmpView();
    
    
    private AllEvent allEventPanel;
        
    public EventView() {
        initComponents();
        customInit();
    }

    public EventView(AllEvent mainFrame){
        this.allEventPanel = mainFrame;
        initComponents();
        customInit();
    }
    
    private void customInit(){
        
        handleButtons();
        //populate signature model
        List<ListData> datas = new ArrayList<>();
        datas.add(new ListData("IGMP", igmpView));
        datas.add(new ListData("TCP", tcpView));
        datas.add(new ListData("IP", ipView));
        datas.add(new ListData("ARP", arpView));
        datas.add(new ListData("ICMP", icmpView));
        model.setData(datas);
        
        for (ListData data : datas) {
            jcbEventType.addItem(data.getName());
        }
        
//        String[] openFlowActions = {"Drop", "Notify", "Drop and Notify", "Migrate"};
//
//        //Create the combo box, select item at index 4.
//        //Indices start at 0, so 4 specifies the pig.
//        for (String openFlowAction : openFlowActions) {
//            jcbOpenFlowActions.addItem(openFlowAction);
//        }
//        jcbOpenFlowActions.setSelectedIndex(0);
    }
    
    public void loadData(Event e) {
        this.event = e;
        jtfEventName.setText(e.getName());
        
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

        jpSignatureHolder = new javax.swing.JPanel();
        jbtSave = new javax.swing.JButton();
        jbtDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlSignature = new javax.swing.JList<>();
        jtfEventName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbEventType = new javax.swing.JComboBox<>();

        jpSignatureHolder.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jpSignatureHolderLayout = new javax.swing.GroupLayout(jpSignatureHolder);
        jpSignatureHolder.setLayout(jpSignatureHolderLayout);
        jpSignatureHolderLayout.setHorizontalGroup(
            jpSignatureHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jpSignatureHolderLayout.setVerticalGroup(
            jpSignatureHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        model = new ListDataModel();
        jlSignature.setModel(model);
        jlSignature.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlSignatureValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlSignature);

        jLabel1.setText("Event name:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Event Type");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Event Fields");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Define Signature");

        jcbEventType.setModel(new CustomActions());
        jcbEventType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEventTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(jcbEventType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpSignatureHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2)
                                .addGap(208, 208, 208)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel4)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtDelete)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpSignatureHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jcbEventType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSave)
                    .addComponent(jbtDelete))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlSignatureValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlSignatureValueChanged
        int index = jlSignature.getSelectedIndex();
        ListData data = model.getData().get(index);
        if(data.getData()!=null){
            jpSignatureHolder.removeAll();
            jpSignatureHolder.setLayout(new BoxLayout(jpSignatureHolder, BoxLayout.X_AXIS));
            jpSignatureHolder.add((JPanel)data.getData());
            jpSignatureHolder.revalidate();
            jpSignatureHolder.repaint();
        }
    }//GEN-LAST:event_jlSignatureValueChanged

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        String name = jtfEventName.getText();
        System.out.println("Event name: "+name);
        if(event == null){
            //creating new event
            event = new Event(name, Event.currentEventId);
            Event.currentEventId++;
        }
        event.setName(name);
        for(int i=0; i<model.getSize(); i++){
            GenericSignaturePanel gsp = (GenericSignaturePanel) model.getData().get(i).getData();
            if(gsp!=null){
                Signature sig = gsp.parseData();
                if(sig!=null && sig.getIsValid()){
                    event.getSignatures().put(sig.getId(), sig);
                }
            }
        }
        
        allEventPanel.eventUpdated(event);
        
    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
        if (event != null) {
            event.setIsDeleted(Boolean.TRUE);
            allEventPanel.eventUpdated(event);
        }
        else {
            JOptionPane.showMessageDialog(this, "Cannot delete. Event not saved yet");
        }
    }//GEN-LAST:event_jbtDeleteActionPerformed

    private void jcbEventTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEventTypeActionPerformed
        int index = jcbEventType.getSelectedIndex();
        ListData data = model.getData().get(index);
        if(data.getData()!=null){
            jpSignatureHolder.removeAll();
            jpSignatureHolder.setLayout(new BoxLayout(jpSignatureHolder, BoxLayout.X_AXIS));
            jpSignatureHolder.add((JPanel)data.getData());
            jpSignatureHolder.revalidate();
            jpSignatureHolder.repaint();
        }
    }//GEN-LAST:event_jcbEventTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jbtSave;
    private javax.swing.JComboBox<String> jcbEventType;
    private javax.swing.JList<String> jlSignature;
    private ListDataModel model;
    private javax.swing.JPanel jpSignatureHolder;
    private javax.swing.JTextField jtfEventName;
    // End of variables declaration//GEN-END:variables

    private void handleButtons() {
        jbtSave.setEnabled(false);
        jbtDelete.setEnabled(false);
        jtfEventName.getDocument().addDocumentListener(new DocumentListener() {
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
               if (jtfEventName.getText().equals("")){
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
    
    class CustomActions extends DefaultComboBoxModel{

        String [] items; 
        public CustomActions() {
            items = new String[] { "Item 1", "Item 2", "Item 3", "Item 4" };
            DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(items);
        }
        
//    jComboBox1 = new javax.swing.JComboBox<>();
//    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      
    }
}
