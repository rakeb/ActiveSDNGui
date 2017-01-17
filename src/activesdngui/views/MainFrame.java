/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activesdngui.views;

import activesdngui.views.eventviews.AllEvent;
import activesdngui.views.actionviews.AllActions;
import activesdngui.controller.EventSpecificationController;
import activesdngui.model.Event;
import activesdngui.views.policybuilder.PolicyBuilderView;
import java.util.HashMap;
import javax.swing.BoxLayout;

/**
 *
 * @author Mazharul
 */
public class MainFrame extends javax.swing.JFrame {

    public static EventSpecificationController controller;
    public static MainFrame mainFrame;
    public static AllEvent allEvtPanel;
    public static AllActions allActions;
    public static PolicyBuilderView policyBuilder;
    public static AboutView about;
    private HashMap<Integer, Event> events = new HashMap<>();

    public MainFrame() {
        initComponents();
        customInit();
    }

    private void customInit() {
        controller = new EventSpecificationController();
        allEvtPanel = new AllEvent();
        allActions = new AllActions();
        policyBuilder = new PolicyBuilderView();
        about = new AboutView();
        jtpMainTabbedPan.addTab("Event", allEvtPanel);
        jtpMainTabbedPan.addTab("Action", allActions);
//        jtpMainTabbedPan.addTab("Course Of Action", courseOfAction);
        jtpMainTabbedPan.addTab("Policy Bulider", policyBuilder);
        jtpMainTabbedPan.addTab("About", about);
        
        //sent controller to everyone
        allEvtPanel.setController(controller);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPolicyHolder = new javax.swing.JPanel();
        jtpMainTabbedPan = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpPolicyHolderLayout = new javax.swing.GroupLayout(jpPolicyHolder);
        jpPolicyHolder.setLayout(jpPolicyHolderLayout);
        jpPolicyHolderLayout.setHorizontalGroup(
            jpPolicyHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMainTabbedPan, javax.swing.GroupLayout.DEFAULT_SIZE, 1273, Short.MAX_VALUE)
        );
        jpPolicyHolderLayout.setVerticalGroup(
            jpPolicyHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMainTabbedPan, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPolicyHolder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPolicyHolder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpPolicyHolder;
    private javax.swing.JTabbedPane jtpMainTabbedPan;
    // End of variables declaration//GEN-END:variables
}
