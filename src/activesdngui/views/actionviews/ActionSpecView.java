/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views.actionviews;

import activesdngui.model.Action;
import activesdngui.model.ActionListData;
import activesdngui.model.GenericSignaturePanel;
import activesdngui.model.ListData;
import activesdngui.model.ListDataModel;
import activesdngui.model.Signature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ActionSpecView extends JPanel {

    public static final String DO = "DO";
    public static final String ON = "ON";
    public static final String OF = "OF";
    public static final String BY = "BY";
    public static final String USING = "USING";
    public static final String FOR = "FOR";
    public static final String OUTCOME = "OUTCOME";

    public static String SIG_NAME = "ACTION";

    public static final String ACTION_TYPE = "ActionType";
    public static final String RATE = "Rate";
    public static final String SWITCH_ID = "SwitchId";
    public static final String TIME = "Time";

    private Action action = null;
    private HashMap<String, ListDataModel> model;
    private AllActions allActions;

    ConfigurationActionView configurationActionView = new ConfigurationActionView();
    InvestigationActionView investigationActionView = new InvestigationActionView();

    ElephantCheckerView elephantCheckerView = new ElephantCheckerView();
    ProtocolCheckerView protocolCheckerView = new ProtocolCheckerView();
    NewComerCheckerView newComerCheckerView = new NewComerCheckerView();

    /**
     * Creates new form ActionView
     */
    public ActionSpecView() {
        this.model = new HashMap<>();
        initComponents();
        customInit();
    }

    public ActionSpecView(AllActions allActions) {
        this.model = new HashMap<>();
        this.allActions = allActions;
        initComponents();
        customInit();
    }

    private void customInit() {
        handleButtons();
        //populate signature model
//        List<ListData> datas = new ArrayList<>();
//        datas.add(new ListData("Configuration Action", configurationActionView));
//        datas.add(new ListData("Investigation Action", investigationActionView));
//        model.setData(datas);
        List<ActionListData> datas;

        ListDataModel doModel = new ListDataModel();
        datas = new ArrayList<>();
        datas.add(new ActionListData(true, "Drop", null));
        datas.add(new ActionListData(true, "Notify", null));
        datas.add(new ActionListData(true, "Migrate", null));
        datas.add(new ActionListData(true, "Drop and Notify", null));

        datas.add(new ActionListData(true, "Check Elephant Flow", elephantCheckerView));
        datas.add(new ActionListData(true, "Check ICMP/UDP", protocolCheckerView));
        datas.add(new ActionListData(true, "Check New Comers", newComerCheckerView));
        doModel.setData(datas);
        model.put(DO, (ListDataModel) doModel);

        ListDataModel onModel = new ListDataModel();
        datas = new ArrayList<>();
        datas.add(new ActionListData(true, "Flows", null));
        datas.add(new ActionListData(true, "Packets", null));
        onModel.setData(datas);
        model.put(ON, (ListDataModel) onModel);
        
        addComboBoxItems();
    }

    private void addComboBoxItems() {
        ListDataModel listDataModel;
        List<ActionListData> datas;
        DefaultComboBoxModel boxModel;

        boxModel = (DefaultComboBoxModel) jcbDo.getModel();
        listDataModel = model.get(DO);
        datas = listDataModel.getData();
        for (ActionListData data : datas) {
            boxModel.addElement(data);
        }
        
        boxModel = (DefaultComboBoxModel) jcbOn.getModel();
        listDataModel = model.get(ON);
        datas = listDataModel.getData();
        for (ActionListData data : datas) {
            boxModel.addElement(data);
        }
    }

    public void loadData(Action e) {
        this.action = e;
        jtfActionName.setText(e.getName());

        for (Map.Entry<String, ListDataModel> entry : model.entrySet()) {
            String key = entry.getKey();
            ListDataModel value = entry.getValue();
            
            for (int i = 0; i < value.getSize(); i++) {
                ListData data = (ListData) value.getData().get(i);
                GenericSignaturePanel gsp = (GenericSignaturePanel) data.getData();
                if (gsp != null) {
                    gsp.loadData(e.getSignatures().get(gsp.getSignatureId()));
                }
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
        jtfActionName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel8 = new javax.swing.JPanel();
        jbtSave = new javax.swing.JButton();
        jbtDelete = new javax.swing.JButton();
        jpActionParamHolder = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbDo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcbOn = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcbOf = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbBy = new javax.swing.JComboBox<>();
        jcbUsing = new javax.swing.JComboBox<>();
        jcbFor = new javax.swing.JComboBox<>();
        jtfOutCome = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(710, 520));

        jSplitPane3.setDividerLocation(35);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setText("Action name:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtfActionName, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 366, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfActionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSplitPane3.setTopComponent(jPanel5);

        jSplitPane4.setDividerLocation(250);

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

        javax.swing.GroupLayout jpActionParamHolderLayout = new javax.swing.GroupLayout(jpActionParamHolder);
        jpActionParamHolder.setLayout(jpActionParamHolderLayout);
        jpActionParamHolderLayout.setHorizontalGroup(
            jpActionParamHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpActionParamHolderLayout.setVerticalGroup(
            jpActionParamHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 280, Short.MAX_VALUE)
                .addComponent(jbtSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtDelete))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpActionParamHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jpActionParamHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSave)
                    .addComponent(jbtDelete))
                .addContainerGap())
        );

        jSplitPane4.setRightComponent(jPanel8);

        jLabel2.setText("DO");

        jcbDo.setModel(new DefaultComboBoxModel<String>());
        jcbDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDoActionPerformed(evt);
            }
        });

        jLabel3.setText("ON");

        jcbOn.setModel(new DefaultComboBoxModel<String>());
        jcbOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOnActionPerformed(evt);
            }
        });

        jLabel4.setText("OF");

        jcbOf.setModel(new DefaultComboBoxModel<String>());
        jcbOf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOfActionPerformed(evt);
            }
        });

        jLabel5.setText("BY");

        jLabel6.setText("USING");

        jLabel7.setText("FOR");

        jLabel8.setText("OUTCOME");

        jcbBy.setModel(new DefaultComboBoxModel<String>());
        jcbBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbByActionPerformed(evt);
            }
        });

        jcbUsing.setModel(new DefaultComboBoxModel<String>());
        jcbUsing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUsingActionPerformed(evt);
            }
        });

        jcbFor.setModel(new DefaultComboBoxModel<String>());
        jcbFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbForActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbDo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbOn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbOf, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbBy, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jcbUsing, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfOutCome)
                            .addComponent(jcbFor, 0, 148, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbDo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbOn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbOf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbBy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbUsing, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbFor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfOutCome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jSplitPane4.setLeftComponent(jPanel1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane4))
        );

        jSplitPane3.setRightComponent(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        String name = jtfActionName.getText();
        System.out.println("Action name: " + name);
        if (action == null) {
            //creating new event
            action = new Action(name, Action.currentActionId);
            Action.currentActionId++;
        }
        action.setName(name);
        
        for (Map.Entry<String, ListDataModel> entry : model.entrySet()) {
            String key = entry.getKey();
            ListDataModel value = entry.getValue();
            for (int i = 0; i < value.getSize(); i++) {
                ListData data = (ListData) value.getData().get(i);
                GenericSignaturePanel gsp = (GenericSignaturePanel) data.getData();
                if (gsp != null) {
                    Signature sig = gsp.parseData();
                    if (sig != null) {
                        action.getSignatures().put(sig.getId(), sig);
                    }
                }
            }
        }
        allActions.actionUpdated(action);
    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
        if (action != null) {
            action.setIsDeleted(Boolean.TRUE);
            allActions.actionUpdated(action);
        } else {
            JOptionPane.showMessageDialog(this, "Cannot delete. Action not saved yet");
        }
    }//GEN-LAST:event_jbtDeleteActionPerformed

    private void jcbDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDoActionPerformed
        int index = jcbDo.getSelectedIndex();
//        ListData data = (ListData) model.getData().get(index);
        ActionListData data = (ActionListData) model.get(DO).getData().get(index);
        if (data.getData() != null) {
            jpActionParamHolder.removeAll();
            jpActionParamHolder.setLayout(new BoxLayout(jpActionParamHolder, BoxLayout.X_AXIS));
            jpActionParamHolder.add((JPanel) data.getData());
            jpActionParamHolder.revalidate();
            jpActionParamHolder.repaint();
        }
    }//GEN-LAST:event_jcbDoActionPerformed

    private void jcbOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOnActionPerformed
    }//GEN-LAST:event_jcbOnActionPerformed

    private void jcbOfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbOfActionPerformed

    private void jcbByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbByActionPerformed

    private void jcbUsingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUsingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbUsingActionPerformed

    private void jcbForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbForActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbForActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jbtSave;
    private javax.swing.JComboBox<String> jcbBy;
    private javax.swing.JComboBox<String> jcbDo;
    private javax.swing.JComboBox<String> jcbFor;
    private javax.swing.JComboBox<String> jcbOf;
    private javax.swing.JComboBox<String> jcbOn;
    private javax.swing.JComboBox<String> jcbUsing;
    private javax.swing.JPanel jpActionParamHolder;
    private javax.swing.JTextField jtfActionName;
    private javax.swing.JTextField jtfOutCome;
    // End of variables declaration//GEN-END:variables

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
                if (jtfActionName.getText().equals("")) {
                    jbtSave.setEnabled(false);
                    jbtDelete.setEnabled(false);
                } else {
                    jbtSave.setEnabled(true);
                    jbtDelete.setEnabled(true);
                }

            }
        });
    }

//    @Override
//    public Signature parseData() {
//        Signature signature = new Signature(SIG_NAME, Signature.ACTION_ID);
//
//        HashMap<String, Object> fields = signature.getFields();
//
//        int index;
//        ListDataModel dataModel = null;
//        ActionListData actionListData;
//
//        index = jcbDo.getSelectedIndex();
//        if (index != -1) {
//            dataModel = model.get(DO);
//            actionListData = (ActionListData) dataModel.getData().get(index);
//            fields.put(DO, actionListData.getName());
//
//            if (actionListData.getData() instanceof NewComerCheckerView) {
//                fields.put(SWITCH_ID, newComerCheckerView.getJtfSwitchId().getText());
//                fields.put(TIME, newComerCheckerView.getJtfTime().getText());
//            } else if (actionListData.getData() instanceof ElephantCheckerView) {
//                fields.put(RATE, elephantCheckerView.getJtfRate().getText());
//            } else {
//                fields.put(RATE, protocolCheckerView.getJtfRate().getText());
//            }
//        }
//
//        index = jcbOn.getSelectedIndex();
//        if (index != -1) {
//            dataModel = model.get(ON);
//            actionListData = (ActionListData) dataModel.getData().get(index);
//            fields.put(ON, actionListData.getName());
//        }
//
//        index = jcbOf.getSelectedIndex();
//        if (index != -1) {
//            dataModel = model.get(OF);
//            actionListData = (ActionListData) dataModel.getData().get(index);
//            fields.put(OF, actionListData.getName());
//        }
//
//        index = jcbBy.getSelectedIndex();
//        if (index != -1) {
//            dataModel = model.get(BY);
//            actionListData = (ActionListData) dataModel.getData().get(index);
//            fields.put(BY, actionListData.getName());
//        }
//
//        index = jcbUsing.getSelectedIndex();
//        if (index != -1) {
//            dataModel = model.get(USING);
//            actionListData = (ActionListData) dataModel.getData().get(index);
//            fields.put(USING, actionListData.getName());
//        }
//
//        index = jcbFor.getSelectedIndex();
//        if (index != -1) {
//            dataModel = model.get(FOR);
//            actionListData = (ActionListData) dataModel.getData().get(index);
//            fields.put(FOR, actionListData.getName());
//        }
//
//        fields.put(OUTCOME, jtfOutCome.getText());
//        return signature;
//    }
//
//    @Override
//    public void loadData(Signature signature) {
////        if (signature != null) {
////            HashMap<String, Object> fields = signature.getFields();
////            int index = jcbInvestigationActionType.getSelectedIndex();
////            ListData data = (ListData) model.getData().get(index);
////
////            if (data.getData() instanceof NewComerCheckerView) {
////                newComerCheckerView.getJtfSwitchId().setText((String) fields.get(SWITCH_ID));
////                newComerCheckerView.getJtfTime().setText((String) fields.get(TIME));
////            } else if (data.getData() instanceof ElephantCheckerView) {
////                elephantCheckerView.getJtfRate().setText((String) fields.get(RATE));
////            } else {
////                protocolCheckerView.getJtfRate().setText((String) fields.get(RATE));
////            }
////        }
//    }
//
//    @Override
//    public Integer getSignatureId() {
//        return Signature.ACTION_ID;
//    }
}
