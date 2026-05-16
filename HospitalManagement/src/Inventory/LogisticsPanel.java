package Inventory;

import static Color_Palette.ColorPalette.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LogisticsPanel extends JPanel {
    
    private JPanel pnlMain;
    private DefaultTableModel tblModel;
    private JTextField txtItem, txtAmount;
    private JLabel lblPending, lblDelivered, lblTValue;
    private JTable tblLogis;
    private JButton btnAdd, btnDeliver, btnRemove;
    
    public LogisticsPanel() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
      
        JLabel lbltitle = new JLabel("Logistics Dashboard");
        lbltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lbltitle);
        
        JLabel lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
      
        JPanel tabPend = createTab("Pending Orders", "0", Yellow);
        tabPend.setBounds(30, 80, 500, 100);
        pnlMain.add(tabPend);
        lblPending = (JLabel) tabPend.getComponent(1);
        
        JPanel tabDel = createTab("Delivered", "0", Green);
        tabDel.setBounds(550, 80, 500, 100);
        pnlMain.add(tabDel);
        lblDelivered = (JLabel) tabDel.getComponent(1);
        
        JPanel tabValue = createTab("Total Value", "₱0", mediumBlue);
        tabValue.setBounds(1070, 80, 500, 100);
        pnlMain.add(tabValue);
        lblTValue = (JLabel) tabValue.getComponent(1);
     
        JPanel pnlSelection = new JPanel();
        pnlSelection.setLayout(null);
        pnlSelection.setBackground(Color.WHITE);
        pnlSelection.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlSelection.setBounds(30, 210, 700, 80);
        pnlMain.add(pnlSelection);
        
        JLabel lblItem = new JLabel("Item:");
        lblItem.setBounds(15, 28, 80, 25);
        lblItem.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblItem);
        
        txtItem = new JTextField();
        txtItem.setBounds(65, 26, 150, 28);
        pnlSelection.add(txtItem);
        
        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(230, 28, 100, 25);
        lblAmount.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblAmount);
        
        txtAmount = new JTextField();
        txtAmount.setBounds(300, 26, 150, 28);
        pnlSelection.add(txtAmount);
        
        btnAdd = new JButton("Add Order");
        btnAdd.setBackground(Green);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAdd.setFocusPainted(false);
        btnAdd.setBounds(480, 22, 150, 35);
        btnAdd.addActionListener(e -> addOrder());
        pnlSelection.add(btnAdd);
       
        String[] clm = {"Item", "Amount", "Status"};
        tblModel = new DefaultTableModel(clm, 0);
        tblLogis = new JTable(tblModel);
        tblLogis.setRowHeight(35);
        tblLogis.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblLogis.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tblLogis.getTableHeader().setBackground(lightBlue);
        
        JScrollPane srcLog = new JScrollPane(tblLogis);
        srcLog.setBounds(30, 310, 1560, 510);
        pnlMain.add(srcLog);
        
        JPanel pnlBot = new JPanel();
        pnlBot.setLayout(null);
        pnlBot.setBackground(Color.WHITE);
        pnlBot.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlBot.setBounds(30, 860, 1560, 50);
        pnlMain.add(pnlBot);
        
        btnDeliver = new JButton("Mark Delivered");
        btnDeliver.setBackground(darkBlue);
        btnDeliver.setForeground(Color.WHITE);
        btnDeliver.setFont(new Font("Calibri", Font.BOLD, 14));
        btnDeliver.setFocusPainted(false);
        btnDeliver.setBounds(20, 10, 140, 30);
        btnDeliver.addActionListener(e -> markDelivered());
        pnlBot.add(btnDeliver);
        
        btnRemove = new JButton("Remove Order");
        btnRemove.setBackground(LightRed);
        btnRemove.setForeground(Color.WHITE);
        btnRemove.setFont(new Font("Calibri", Font.BOLD, 14));
        btnRemove.setFocusPainted(false);
        btnRemove.setBounds(180, 10, 130, 30);
        btnRemove.addActionListener(e -> removeOrder());
        pnlBot.add(btnRemove);
        
        addSampData();
    }
    
    private JPanel createTab(String title, String value, Color color) {
        JPanel tab = new JPanel();
        tab.setLayout(null);
        tab.setBackground(color);
        
        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(20, 20, 200, 25);
        tab.add(lblTitle);
        
        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Calibri", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);
        lblValue.setBounds(20, 50, 200, 40);
        tab.add(lblValue);
        
        return tab;
    }
    
    private void addOrder() {
        if (txtItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter item name!");
            return;
        }
        tblModel.addRow(new Object[]{txtItem.getText(), "₱" + txtAmount.getText(), "Pending"});
        txtItem.setText("");
        txtAmount.setText("");
        updateSummary();
        JOptionPane.showMessageDialog(this, "Order added!");
    }
    
    private void markDelivered() {
        int row = tblLogis.getSelectedRow();
        if (row >= 0) {
            tblModel.setValueAt("Delivered", row, 2);
            updateSummary();
            JOptionPane.showMessageDialog(this, "Order delivered!");
        } else {
            JOptionPane.showMessageDialog(this, "Select an order first!");
        }
    }
    
    private void removeOrder() {
        int row = tblLogis.getSelectedRow();
        if (row >= 0) {
            tblModel.removeRow(row);
            updateSummary();
            JOptionPane.showMessageDialog(this, "Order removed!");
        } else {
            JOptionPane.showMessageDialog(this, "Select an order first!");
        }
    }
    
    private void updateSummary() {
        double total = 0.0;
        int pending = 0, delivered = 0;
        
        for (int i = 0; i < tblModel.getRowCount(); i++) {
            String status = tblModel.getValueAt(i, 2).toString();
            if (status.equals("Pending")) pending++;
            if (status.equals("Delivered")) delivered++;
            
            String amt = tblModel.getValueAt(i, 1).toString()
            .replace("₱", "").replace(",", "").trim();
                    
            try { total += Double.parseDouble(amt); } catch (NumberFormatException e) {}
        }
        lblPending.setText(String.valueOf(pending));
        lblDelivered.setText(String.valueOf(delivered));
        lblTValue.setText("₱" + String.format("%,.2f", total));
    }
    
    private void addSampData() {
        tblModel.addRow(new Object[]{"Surgical Masks", "₱5,000", "Pending"});
        tblModel.addRow(new Object[]{"Disposable Gloves", "₱3,000", "Delivered"});
        tblModel.addRow(new Object[]{"Medical Gauze", "₱5,000", "Pending"});
        
        updateSummary();
    }
}