package Inventory;

import static Color_Palette.ColorPalette.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LogisticsPanel extends JPanel {
    
    private JPanel pnlMain, tabPend, tabDel, tabValue, pnlSelection, pnlBot, tabUpdate;
    private DefaultTableModel tblModel;
    private JTextField txtItem, txtAmount;
    private JLabel lbltitle, lblDT, lblItem, lblAmount, lblPending, lblDelivered, lblTValue, lblTitle, lblValue;
    private JTable tblLogis;
    private JButton btnAdd, btnEdit, btnDeliver, btnRemove;
    private JScrollPane srcLog;
    private int ONum = 10000;
    
    public LogisticsPanel() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
      
        lbltitle = new JLabel("Logistics Dashboard");
        lbltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lbltitle);
        
        lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
      
        tabPend = createTab("Pending Orders", "0", Yellow);
        tabPend.setBounds(30, 80, 500, 100);
        pnlMain.add(tabPend);
        lblPending = (JLabel) tabPend.getComponent(1);
        
        tabDel = createTab("Delivered", "0", Green);
        tabDel.setBounds(550, 80, 500, 100);
        pnlMain.add(tabDel);
        lblDelivered = (JLabel) tabDel.getComponent(1);
        
        tabValue = createTab("Total Value", "₱0", mediumBlue);
        tabValue.setBounds(1070, 80, 500, 100);
        pnlMain.add(tabValue);
        lblTValue = (JLabel) tabValue.getComponent(1);
     
        pnlSelection = new JPanel();
        pnlSelection.setLayout(null);
        pnlSelection.setBackground(Color.WHITE);
        pnlSelection.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlSelection.setBounds(30, 210, 1000, 80);
        pnlMain.add(pnlSelection);
        
        lblItem = new JLabel("Item:");
        lblItem.setBounds(15, 28, 80, 25);
        lblItem.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblItem);
        
        txtItem = new JTextField();
        txtItem.setBounds(100, 26, 200, 28);
        pnlSelection.add(txtItem);
        
        lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(330, 28, 100, 25);
        lblAmount.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblAmount);
        
        txtAmount = new JTextField();
        txtAmount.setBounds(420, 26, 200, 28);
        pnlSelection.add(txtAmount);
        
        btnAdd = new JButton("Add Order");
        btnAdd.setBackground(Green);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAdd.setFocusPainted(false);
        btnAdd.setBounds(650, 22, 150, 35);
        btnAdd.addActionListener(e -> addOrder());
        pnlSelection.add(btnAdd);
        
        btnEdit = new JButton("Edit Order");
        btnEdit.setBackground(darkBlue);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Calibri", Font.BOLD, 16));
        btnEdit.setFocusPainted(false);
        btnEdit.setBounds(820, 22, 150, 35);
        btnEdit.addActionListener(e -> editOrder());
        pnlSelection.add(btnEdit);
       
        String[] clm = {"Order ID","Item", "Amount", "Status"};
        tblModel = new DefaultTableModel(clm, 0);
        tblLogis = new JTable(tblModel);
        tblLogis.setRowHeight(35);
        tblLogis.setAutoCreateRowSorter(true);
        tblLogis.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblLogis.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tblLogis.getTableHeader().setBackground(lightBlue);
        
        srcLog = new JScrollPane(tblLogis);
        srcLog.setBounds(30, 310, 1560, 510);
        pnlMain.add(srcLog);
        
        pnlBot = new JPanel();
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
        tabUpdate = new JPanel();
        tabUpdate.setLayout(null);
        tabUpdate.setBackground(color);
        
        lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(20, 20, 200, 25);
        tabUpdate.add(lblTitle);
        
        lblValue = new JLabel(value);
        lblValue.setFont(new Font("Calibri", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);
        lblValue.setBounds(20, 50, 200, 40);
        tabUpdate.add(lblValue);
        
        return tabUpdate;
    }
    
    private void addOrder() {
        String item = txtItem.getText().trim();
        String amtStr = txtAmount.getText().trim();

        if (item.isEmpty() || amtStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter item name and amount!");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amtStr.replace(",", "").trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount!");
            return;
        }

        int row = tblLogis.getSelectedRow();
        if (row >= 0) {
            tblModel.setValueAt(item, row, 1);
            tblModel.setValueAt(amount, row, 2);
            JOptionPane.showMessageDialog(this, "Order updated!");
        } else {
            String orderID = "ORD-" + (++ONum);
            tblModel.addRow(new Object[]{orderID, item, amount, "Pending"});
            JOptionPane.showMessageDialog(this, "Order added!");
        }

        txtItem.setText("");
        txtAmount.setText("");
        updateSummary();
    }
    
    private void editOrder() {
        int row = tblLogis.getSelectedRow();
            if (row >= 0) {
                txtItem.setText(tblModel.getValueAt(row, 1).toString());
                txtAmount.setText(tblModel.getValueAt(row, 2).toString().replace("₱", ""));
                JOptionPane.showMessageDialog(this, "Edit fields and click Add Order to save changes.");
            } else {
                JOptionPane.showMessageDialog(this, "Select an order to edit!");
            }
    }

    private void markDelivered() {
        int row = tblLogis.getSelectedRow();
        if (row >= 0) {
            tblModel.setValueAt("Delivered", row, 3);
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
            String status = tblModel.getValueAt(i, 3).toString();
            if (status.equals("Pending")) pending++;
            if (status.equals("Delivered")) delivered++;

            Object amtObj = tblModel.getValueAt(i, 2);
            if (amtObj instanceof Number) {
                total += ((Number) amtObj).doubleValue();
            }
        }
        lblPending.setText(String.valueOf(pending));
        lblDelivered.setText(String.valueOf(delivered));
        lblTValue.setText("₱" + String.format("%,.2f", total));
    }

    private void addSampData() {
        tblModel.addRow(new Object[]{"ORD-" + (++ONum), "Surgical Masks", 5000.0, "Pending"});
        tblModel.addRow(new Object[]{"ORD-" + (++ONum), "Disposable Gloves", 3000.0, "Delivered"});
        tblModel.addRow(new Object[]{"ORD-" + (++ONum), "Medical Gauze", 5000.0, "Pending"});
        
        updateSummary();
    }
}