package Inventory;

import static Color_Palette.ColorPalette.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryPanel extends JPanel {
    
    private JPanel pnlMain;
    private DefaultTableModel tblModel;
    private JTextField txtItem, txtQty, txtPrice;
    private JLabel lblTItem, lblLStock, lblTValue;
    private JTable tblInve;
    private JButton btnAdd, btnRestock, btnRemove;
    
    public InventoryPanel() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
        
        JLabel lbltitle = new JLabel("Inventory Management");
        lbltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lbltitle);
        
        JLabel lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
   
        JPanel tabItem = createTab("Total Items", "0", darkBlue);
        tabItem.setBounds(30, 80, 500, 100);
        pnlMain.add(tabItem);
        lblTItem = (JLabel) tabItem.getComponent(1);
        
        JPanel tabLows = createTab("Low Stock", "0", Yellow);
        tabLows.setBounds(550, 80, 500, 100);
        pnlMain.add(tabLows);
        lblLStock = (JLabel) tabLows.getComponent(1);
        
        JPanel tabValue = createTab("Total Value", "₱0", mediumBlue);
        tabValue.setBounds(1070, 80, 500, 100);
        pnlMain.add(tabValue);
        lblTValue = (JLabel) tabValue.getComponent(1);
      
        JPanel pnlSelection = new JPanel();
        pnlSelection.setLayout(null);
        pnlSelection.setBackground(Color.WHITE);
        pnlSelection.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlSelection.setBounds(30, 210, 950, 80);
        pnlMain.add(pnlSelection);
        
        JLabel lblItem = new JLabel("Item:");
        lblItem.setBounds(15, 28, 60, 25);
        lblItem.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblItem);
        
        txtItem = new JTextField();
        txtItem.setBounds(70, 26, 180, 28);
        pnlSelection.add(txtItem);
        
        JLabel lblQty = new JLabel("Qty:");
        lblQty.setBounds(270, 28, 80, 25);
        lblQty.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblQty);
        
        txtQty = new JTextField();
        txtQty.setBounds(310, 26, 180, 28);
        pnlSelection.add(txtQty);
        
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(500, 28, 100, 25);
        lblPrice.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblPrice);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(550, 26, 180, 28);
        pnlSelection.add(txtPrice);
        
        btnAdd = new JButton("Add Item");
        btnAdd.setBackground(Green);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAdd.setFocusPainted(false);
        btnAdd.setBounds(760, 22, 150, 35);
        btnAdd.addActionListener(e -> addItem());
        pnlSelection.add(btnAdd);

        String[] clm = {"Item", "Quantity", "Price", "Status"};
        tblModel = new DefaultTableModel(clm, 0);
        tblInve = new JTable(tblModel);
        tblInve.setRowHeight(35);
        tblInve.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblInve.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tblInve.getTableHeader().setBackground(lightBlue);
        
        JScrollPane srcInve = new JScrollPane(tblInve);
        srcInve.setBounds(30, 310, 1560, 510);
        pnlMain.add(srcInve);
        
        JPanel pnlBot = new JPanel();
        pnlBot.setLayout(null);
        pnlBot.setBackground(Color.WHITE);
        pnlBot.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlBot.setBounds(30, 860, 1560, 50);
        pnlMain.add(pnlBot);
        
        btnRestock = new JButton("Restock");
        btnRestock.setBackground(mediumBlue);
        btnRestock.setForeground(Color.WHITE);
        btnRestock.setFont(new Font("Calibri", Font.BOLD, 14));
        btnRestock.setFocusPainted(false);
        btnRestock.setBounds(20, 10, 120, 30);
        btnRestock.addActionListener(e -> restockItem());
        pnlBot.add(btnRestock);
        
        btnRemove = new JButton("Remove");
        btnRemove.setBackground(LightRed);
        btnRemove.setForeground(Color.WHITE);
        btnRemove.setFont(new Font("Calibri", Font.BOLD, 14));
        btnRemove.setFocusPainted(false);
        btnRemove.setBounds(160, 10, 120, 30);
        btnRemove.addActionListener(e -> removeItem());
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
        lblTitle.setBounds(20, 20, 250, 25);
        tab.add(lblTitle);
        
        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Calibri", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);
        lblValue.setBounds(20, 50, 150, 40);
        tab.add(lblValue);
        
        return tab;
    }
    
    private void addItem() {
        if (txtItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter item name!");
            return;
        }
        int qty = 0;
        try { qty = Integer.parseInt(txtQty.getText()); } catch (Exception e) {}
        double price = 0;
        try { price = Double.parseDouble(txtPrice.getText()); } catch (Exception e) {}
        
        String status = qty < 50 ? "Low Stock" : "Good";
        tblModel.addRow(new Object[]{txtItem.getText(), qty, "₱" + price, status});
        
        txtItem.setText("");
        txtQty.setText("");
        txtPrice.setText("");
        updateSummary();
        JOptionPane.showMessageDialog(this, "Item added!");
    }
    
    private void restockItem() {
        int row = tblInve.getSelectedRow();
        if (row >= 0) {
            int current = (int) tblModel.getValueAt(row, 1);
            String addStr = JOptionPane.showInputDialog(this, "Current: " + current + "\nAdd:");
            if (addStr != null) {
                try {
                    int add = Integer.parseInt(addStr);
                    int newQty = current + add;
                    tblModel.setValueAt(newQty, row, 1);
                    tblModel.setValueAt(newQty < 50 ? "Low Stock" : "Good", row, 3);
                    updateSummary();
                    JOptionPane.showMessageDialog(this, "Restocked! New: " + newQty);
                } catch (Exception e) {}
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select an item first!");
        }
    }
    
    private void removeItem() {
        int row = tblInve.getSelectedRow();
        if (row >= 0) {
            tblModel.removeRow(row);
            updateSummary();
            JOptionPane.showMessageDialog(this, "Item removed!");
        } else {
            JOptionPane.showMessageDialog(this, "Select an item first!");
        }
    }
    
    private void updateSummary() {
        int total = tblModel.getRowCount();
        int low = 0;
        double value = 0;
        for (int i = 0; i < total; i++) {
            if (tblModel.getValueAt(i, 3).toString().contains("Low")) low++;
            String price = tblModel.getValueAt(i, 2).toString().replace("₱", "");
            try { value += Double.parseDouble(price); } catch (Exception e) {}
        }
        lblTItem.setText(String.valueOf(total));
        lblLStock.setText(String.valueOf(low));
        lblTValue.setText("₱" + value);
    }
    
    private void addSampData() {
        tblModel.addRow(new Object[]{"Paracetamol", 500, "₱2500", "Good"});
        tblModel.addRow(new Object[]{"Amoxicillin", 300, "₱4500", "Good"});
        tblModel.addRow(new Object[]{"Ibuprofen", 45, "₱1500", "Low Stock"});
        
        updateSummary();
    }
}