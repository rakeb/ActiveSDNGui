/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views.eventviews;

import activesdngui.views.eventviews.IgmpView;
import activesdngui.views.eventviews.TcpView;
import activesdngui.views.eventviews.IcmpView;
import activesdngui.views.eventviews.ArpView;
import activesdngui.views.eventviews.IpView;
import activesdngui.model.Event;
import activesdngui.model.GenericSignaturePanel;
import activesdngui.model.ListData;
import activesdngui.model.ListDataModel;
import activesdngui.model.Signature;
import java.util.ArrayList;
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
    private ListDataModel model = new ListDataModel();
    private AllEvent allEventPanel;
    
    TcpView tcpView = new TcpView();
    IpView ipView = new IpView();
    ArpView arpView = new ArpView();
    IgmpView igmpView = new IgmpView();
    IcmpView icmpView = new IcmpView();
    
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
        datas.add(new ListData("IP", ipView));
        datas.add(new ListData("TCP", tcpView));
        datas.add(new ListData("IGMP", igmpView));
        datas.add(new ListData("ARP", arpView));
        datas.add(new ListData("ICMP", icmpView));
        model.setData(datas);
        
        for (ListData data : datas) {
            jcbEventType.addItem(data.getName());
        }
    }
    
    public void loadData(Event e) {
        this.event = e;
        jtfEventName.setText(e.getName());
        
        for(int i=0; i<model.getSize(); i++){
            ListData data = (ListData) model.getData().get(i);
            GenericSignaturePanel gsp = (GenericSignaturePanel) data.getData();
            if(gsp != null){
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

        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jtfEventName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel8 = new javax.swing.JPanel();
        jbtSave = new javax.swing.JButton();
        jbtDelete = new javax.swing.JButton();
        jpSignatureHolder = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbEventType = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(710, 520));

        jSplitPane3.setDividerLocation(35);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setText("Event name:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtfEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 177, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSplitPane3.setTopComponent(jPanel5);

        jSplitPane4.setDividerLocation(150);

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

        javax.swing.GroupLayout jpSignatureHolderLayout = new javax.swing.GroupLayout(jpSignatureHolder);
        jpSignatureHolder.setLayout(jpSignatureHolderLayout);
        jpSignatureHolderLayout.setHorizontalGroup(
            jpSignatureHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpSignatureHolderLayout.setVerticalGroup(
            jpSignatureHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 184, Short.MAX_VALUE)
                .addComponent(jbtSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtDelete))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpSignatureHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jpSignatureHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSave)
                    .addComponent(jbtDelete))
                .addContainerGap())
        );

        jSplitPane4.setRightComponent(jPanel8);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Event Type");

        jcbEventType.setModel(new CustomActions());
        jcbEventType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEventTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jcbEventType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbEventType, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jSplitPane4.setLeftComponent(jPanel1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
        );

        jSplitPane3.setRightComponent(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane3))
        );
    }// </editor-fold>//GEN-END:initComponents

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
            ListData data = (ListData) model.getData().get(i);
            GenericSignaturePanel gsp = (GenericSignaturePanel) data.getData();
            if(gsp!=null){
                Signature sig = gsp.parseData();
                if(sig!=null){
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
        ListData data = (ListData) model.getData().get(index);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jbtSave;
    private javax.swing.JComboBox<String> jcbEventType;
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
    }
}
