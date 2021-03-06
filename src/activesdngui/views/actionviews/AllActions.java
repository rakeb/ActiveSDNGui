/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views.actionviews;

import activesdngui.controller.EventSpecificationController;
import activesdngui.model.Action;
import activesdngui.model.ListData;
import activesdngui.model.ListDataModel;
import activesdngui.utility.Utilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mislam7
 */
public class AllActions extends javax.swing.JPanel {
    
    private HashMap<Integer, Action> actions = new HashMap<>();
    private EventSpecificationController controller;

    /**
     * Creates new form AllActions
     */
    public AllActions() {
        initComponents();
        customInit();
    }
    
    private void customInit() {
//        ActionView actionView = new ActionView(this);
        ActionSpecView actionSpecView = new ActionSpecView(this);
        jlActionList.setSelectedIndex(-1);
        jpActionViewHolder.removeAll();
        jpActionViewHolder.setLayout(new BoxLayout(jpActionViewHolder, BoxLayout.X_AXIS));
//        jpActionViewHolder.add(actionView);
        jpActionViewHolder.add(actionSpecView);
        jpActionViewHolder.revalidate();
        jpActionViewHolder.repaint();
    }
    
    public void actionUpdated(Action action) {
        if (action.getIsDeleted()) {
            actions.remove(action.getId());
        } else {
            actions.put(action.getId(), action);
        }
        List<Integer> ids = new ArrayList<>(actions.keySet());
        Collections.sort(ids);
        List<ListData> actionList = new ArrayList<>();

        for (Integer id : ids) {
            Action e = actions.get(id);
            System.out.println("Action: " + id + ", name: " + e.getName());
            actionList.add(new ListData(e.getName(), e));
        }

        model.setData(actionList);
        updateEventList();
        jlActionList.addListSelectionListener(new CustomListSelectionListner());
        
        if (action.getIsDeleted()) {
            jpActionViewHolder.removeAll();
            jpActionViewHolder.revalidate();
        }
        
        this.revalidate();
        this.repaint();
        
        customInit();
    }
    
    private void updateEventList() {
        
        DefaultListModel nmodel = (DefaultListModel) jlActionList.getModel();
        nmodel.removeAllElements();
        List<ListData> listDatasToBeAdded = model.getData();
        
        for (ListData listData : listDatasToBeAdded) {
            String name = listData.getName();
            System.out.println("listdata name: " + name);
            nmodel.addElement(listData);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jbCreateAction = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlActionList = new javax.swing.JList<>();
        jpActionViewHolder = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(250);

        jToolBar1.setRollover(true);

        jbCreateAction.setText("New Actions");
        jbCreateAction.setFocusable(false);
        jbCreateAction.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCreateAction.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCreateAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateActionActionPerformed(evt);
            }
        });
        jToolBar1.add(jbCreateAction);

        model = new ListDataModel();
        jlActionList.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jlActionList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel2);

        javax.swing.GroupLayout jpActionViewHolderLayout = new javax.swing.GroupLayout(jpActionViewHolder);
        jpActionViewHolder.setLayout(jpActionViewHolderLayout);
        jpActionViewHolderLayout.setHorizontalGroup(
            jpActionViewHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        jpActionViewHolderLayout.setVerticalGroup(
            jpActionViewHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jpActionViewHolder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbCreateActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateActionActionPerformed
        customInit();
    }//GEN-LAST:event_jbCreateActionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbCreateAction;
    private javax.swing.JList<String> jlActionList;
    private ListDataModel model;
    private javax.swing.JPanel jpActionViewHolder;
    // End of variables declaration//GEN-END:variables

    class CustomListSelectionListner implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int[] indexs = jlActionList.getSelectedIndices();
            Utilities.pirntArray(indexs);
            int index = jlActionList.getSelectedIndex();
            if (index != -1) {
                ListData data = (ListData) model.getData().get(index);

//                ActionView actionView = new ActionView(AllActions.this);
//                actionView.loadData((Action) data.getData());
                ActionSpecView actionSpecView = new ActionSpecView();
                actionSpecView.loadData((Action) data.getData());
                jpActionViewHolder.removeAll();
                jpActionViewHolder.setLayout(new BoxLayout(jpActionViewHolder, BoxLayout.X_AXIS));
//                jpActionViewHolder.add(actionView);
                jpActionViewHolder.add(actionSpecView);
                jpActionViewHolder.revalidate();
                jpActionViewHolder.repaint();
            }
        }

    }
}
