///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package activesdngui;
//
//import javax.swing.BoxLayout;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
///**
// *
// * @author mislam7
// */
//class CustomListSelectionListner_EX implements ListSelectionListener {
//
//    private javax.swing.JList<String> jlEventList;
//    private MainFrame mainFrame;
//    private javax.swing.JPanel jpEventViewHolder;
//    private ListDataModel model;
//
//    @Override
//    public void valueChanged(ListSelectionEvent e) {
//        int[] indexs = jlEventList.getSelectedIndices();
//        Utilities.pirntArray(indexs);
//        int index = jlEventList.getSelectedIndex();
//        if (index != -1) {
//            ListData data = model.getData().get(index);
//
//            EventView eventView = new EventView(AllEvent.t);
//            eventView.loadData((Event) data.getData());
//            jpEventViewHolder.removeAll();
//            jpEventViewHolder.setLayout(new BoxLayout(jpEventViewHolder, BoxLayout.X_AXIS));
//            jpEventViewHolder.add(eventView);
//            jpEventViewHolder.revalidate();
//            jpEventViewHolder.repaint();
//        }
//    }
//
//    public JList<String> getJlEventList() {
//        return jlEventList;
//    }
//
//    public void setJlEventList(JList<String> jlEventList) {
//        this.jlEventList = jlEventList;
//    }
//
//    public JPanel getJpEventViewHolder() {
//        return jpEventViewHolder;
//    }
//
//    public void setJpEventViewHolder(JPanel jpEventViewHolder) {
//        this.jpEventViewHolder = jpEventViewHolder;
//    }
//
//    public ListDataModel getModel() {
//        return model;
//    }
//
//    public void setModel(ListDataModel model) {
//        this.model = model;
//    }
//
//    public MainFrame getMainFrame() {
//        return mainFrame;
//    }
//
//    public void setMainFrame(MainFrame mainFrame) {
//        this.mainFrame = mainFrame;
//    }
//    
//
//}
