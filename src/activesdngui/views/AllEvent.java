/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views;

import activesdngui.controller.EventSpecificationController;
import activesdngui.model.Event;
import activesdngui.model.ListData;
import activesdngui.model.ListDataModel;
import activesdngui.model.Pattern;
import activesdngui.utility.Utilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mislam7
 */
public class AllEvent extends javax.swing.JPanel {

    private HashMap<Integer, Event> events = new HashMap<>();
    private EventSpecificationController controller;

    public AllEvent() {
        initComponents();
        customInit();
    }

    private void customInit() {
        EventView eventView = new EventView(this);
        jlEventList.setSelectedIndex(-1);
        jpEventViewHolder.removeAll();
        jpEventViewHolder.setLayout(new BoxLayout(jpEventViewHolder, BoxLayout.X_AXIS));
        jpEventViewHolder.add(eventView);
        jpEventViewHolder.revalidate();
        jpEventViewHolder.repaint();
    }
    
    public void eventUpdated(Event event) {
        if (event.getIsDeleted()) {
            events.remove(event.getId());
        } else {
            events.put(event.getId(), event);
        }
        List<Integer> ids = new ArrayList<>(events.keySet());
        Collections.sort(ids);
        List<ListData> eventList = new ArrayList<>();

        for (Integer id : ids) {
            Event e = events.get(id);
            System.out.println("Event: " + id + ", name: " + e.getName());
            eventList.add(new ListData(e.getName(), e));
        }

        model.setData(eventList);
        updateEventList();
        //jlEventList = new JList<>(model);
        jlEventList.addListSelectionListener(new CustomListSelectionListner());
        //jpListPanel.removeAll();
        //jpListPanel.setLayout(new BoxLayout(jpListPanel, BoxLayout.X_AXIS));
        //jpListPanel.add(jlEventList);
        if (event.getIsDeleted()) {
            jpEventViewHolder.removeAll();
            jpEventViewHolder.revalidate();
        }
        this.revalidate();
        this.repaint();
        
        customInit();
    }

    private void updateEventList() {
        
//        ListModel<String> modelNames = jlEventList.getModel();
//        ListModel<String> modelNames = jlEventList.getModel();
        
//        DefaultListModel nmodel = (DefaultListModel) jlEventList.getModel();
//        List<ListData> listDatasToBeAdded = model.getData();
//        List<ListData> currentListDatas = new ArrayList<>();
//        for (int i = 0; i < nmodel.getSize(); i++) {
//            currentListDatas.add((ListData) nmodel.getElementAt(i));
//        }
//        
//        
//        for (ListData listData : listDatasToBeAdded) {
//            String name = listData.getName();
//            System.out.println("listdata name: " + name);
//            if (!Utilities.containsLocation(currentListDatas, name)) {
//                nmodel.addElement(listData);
//            }
////            if (modelNames.getSize() == 0) {
////                nmodel.addElement(listData);
////            } else {
////                for (int i = 0; i < modelNames.getSize(); i++) {
////                    System.out.println("hello world  " + modelNames.getElementAt(i));
////                    if (!modelNames.getElementAt(i).equals(name)) {
////                        nmodel.addElement(listData);
////                    } 
////                }
////            }
//            
//        }
        
        DefaultListModel nmodel = (DefaultListModel) jlEventList.getModel();
        nmodel.removeAllElements();
        List<ListData> listDatasToBeAdded = model.getData();
        
        for (ListData listData : listDatasToBeAdded) {
            String name = listData.getName();
            System.out.println("listdata name: " + name);
            nmodel.addElement(listData);
        }

        
        
    }


    class CustomListSelectionListner implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int[] indexs = jlEventList.getSelectedIndices();
            Utilities.pirntArray(indexs);
            int index = jlEventList.getSelectedIndex();
            if (index != -1) {
                ListData data = model.getData().get(index);

                EventView eventView = new EventView(AllEvent.this);
                eventView.loadData((Event) data.getData());
                jpEventViewHolder.removeAll();
                jpEventViewHolder.setLayout(new BoxLayout(jpEventViewHolder, BoxLayout.X_AXIS));
                jpEventViewHolder.add(eventView);
                jpEventViewHolder.revalidate();
                jpEventViewHolder.repaint();
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

        jPanel1 = new javax.swing.JPanel();
        jbCreateEvent = new javax.swing.JButton();
        jpEventViewHolder = new javax.swing.JPanel();
        jpListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlEventList = new javax.swing.JList<>();
        jpPattern = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfWindow = new javax.swing.JTextField();
        jtfCount = new javax.swing.JTextField();
        jbCreateEventExpression = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jbCreateEvent.setText("New event");
        jbCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateEventActionPerformed(evt);
            }
        });

        jpEventViewHolder.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jpEventViewHolderLayout = new javax.swing.GroupLayout(jpEventViewHolder);
        jpEventViewHolder.setLayout(jpEventViewHolderLayout);
        jpEventViewHolderLayout.setHorizontalGroup(
            jpEventViewHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        jpEventViewHolderLayout.setVerticalGroup(
            jpEventViewHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpListPanel.setBackground(new java.awt.Color(255, 255, 255));

        model = new ListDataModel();
        jlEventList.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jlEventList);

        javax.swing.GroupLayout jpListPanelLayout = new javax.swing.GroupLayout(jpListPanel);
        jpListPanel.setLayout(jpListPanelLayout);
        jpListPanelLayout.setHorizontalGroup(
            jpListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jpListPanelLayout.setVerticalGroup(
            jpListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jpPattern.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Define Pattern");

        jLabel3.setText("Window");

        jLabel4.setText("Count");

        javax.swing.GroupLayout jpPatternLayout = new javax.swing.GroupLayout(jpPattern);
        jpPattern.setLayout(jpPatternLayout);
        jpPatternLayout.setHorizontalGroup(
            jpPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPatternLayout.createSequentialGroup()
                .addGroup(jpPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPatternLayout.createSequentialGroup()
                        .addContainerGap(95, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jpPatternLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jpPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfWindow)
                            .addComponent(jtfCount, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
        );
        jpPatternLayout.setVerticalGroup(
            jpPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPatternLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jpPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jbCreateEventExpression.setText("Create Event Expression");
        jbCreateEventExpression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateEventExpressionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Event List");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCreateEventExpression)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpEventViewHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpPattern, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbCreateEvent)
                        .addGap(237, 1040, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCreateEvent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpEventViewHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpPattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jbCreateEventExpression)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1155, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbCreateEventExpressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateEventExpressionActionPerformed
        //pattern
        Pattern pattern = new Pattern();
        HashMap<String, Object> fields = pattern.getFields();
        fields.put(Pattern.WINDOW, jtfWindow.getText());
        fields.put(Pattern.COUNT, jtfCount.getText());
        
        //events
        int[] indexs = jlEventList.getSelectedIndices();
        Utilities.pirntArray(indexs);
        List<Event> eventList = new ArrayList<>();
        
        for (int index : indexs) {
            eventList.add((Event) model.getData().get(index).getData());
        }
        
        controller.setEvents(eventList);
        controller.setPattern(pattern);
        Utilities.printController(controller);
    }//GEN-LAST:event_jbCreateEventExpressionActionPerformed

    private void jbCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateEventActionPerformed
        EventView eventView = new EventView(this);
        jlEventList.setSelectedIndex(-1);
        jpEventViewHolder.removeAll();
        jpEventViewHolder.setLayout(new BoxLayout(jpEventViewHolder, BoxLayout.X_AXIS));
        jpEventViewHolder.add(eventView);
        jpEventViewHolder.revalidate();
        jpEventViewHolder.repaint();
    }//GEN-LAST:event_jbCreateEventActionPerformed



    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCreateEvent;
    private javax.swing.JButton jbCreateEventExpression;
    private javax.swing.JList<String> jlEventList;
    private ListDataModel model;
    private javax.swing.JPanel jpEventViewHolder;
    private javax.swing.JPanel jpListPanel;
    private javax.swing.JPanel jpPattern;
    private javax.swing.JTextField jtfCount;
    private javax.swing.JTextField jtfWindow;
    // End of variables declaration//GEN-END:variables

    public EventSpecificationController getController() {
        return controller;
    }

    public void setController(EventSpecificationController controller) {
        this.controller = controller;
    }

}
