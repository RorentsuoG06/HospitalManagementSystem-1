package Inventory;

import static Color_Palette.ColorPalette.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RequestPanel_Doctor extends JPanel {
    
    private JPanel pnlMain;
    private DefaultTableModel tblModel;
    private JTextField txtItem, txtQty, txtPrice;
    private JLabel lblTItem, lblLStock, lblTValue;
    private JTable tblInve;
    private JButton btnAdd, btnQty, btnRemove;
    private JComboBox<String> cmbCate;
    
    public RequestPanel_Doctor() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
        
        JLabel lbltitle = new JLabel("Medical Supply Request");
        lbltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lbltitle);
        
        JLabel lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
   
        JPanel tabItem = createTab("Total Items Requested", "0", darkBlue);
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
        pnlSelection.setBounds(30, 210, 1180, 80);
        pnlMain.add(pnlSelection);
        
        JLabel lblCate = new JLabel("Category:");
        lblCate.setBounds(15, 28, 80, 25);
        lblCate.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblCate);
        
        cmbCate = new JComboBox<>(new String[]{"Medication", "Equipment", "Supplies"});
        cmbCate.setBounds(95, 26, 150, 28);
        pnlSelection.add(cmbCate);
        
        JLabel lblItem = new JLabel("Item:");
        lblItem.setBounds(260, 28, 60, 25);
        lblItem.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblItem);
        
        txtItem = new JTextField();
        txtItem.setBounds(310, 26, 180, 28);
        pnlSelection.add(txtItem);
        
        JLabel lblQty = new JLabel("Qty:");
        lblQty.setBounds(500, 28, 80, 25);
        lblQty.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblQty);
        
        txtQty = new JTextField();
        txtQty.setBounds(540, 26, 180, 28);
        pnlSelection.add(txtQty);
        
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(740, 28, 100, 25);
        lblPrice.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblPrice);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(790, 26, 180, 28);
        pnlSelection.add(txtPrice);
        
        btnAdd = new JButton("Add Item");
        btnAdd.setBackground(Green);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAdd.setFocusPainted(false);
        btnAdd.setBounds(1000, 22, 150, 35);
        btnAdd.addActionListener(e -> addItem());
        pnlSelection.add(btnAdd);

        String[] clm = {"Category", "Item", "Quantity", "Unit Price", "Total Cost", "Status"};
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
        
        btnQty = new JButton("Add Quantity");
        btnQty.setBackground(mediumBlue);
        btnQty.setForeground(Color.WHITE);
        btnQty.setFont(new Font("Calibri", Font.BOLD, 14));
        btnQty.setFocusPainted(false);
        btnQty.setBounds(20, 10, 120, 30);
        btnQty.addActionListener(e -> requestedItem());
        pnlBot.add(btnQty);
        
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
        try { 
        qty = Integer.parseInt(txtQty.getText()); 
        } catch (Exception e) {}
        double price = 0;
        try { 
            price = Double.parseDouble(txtPrice.getText()); 
        } catch (Exception e) {}
        
        String category = cmbCate.getSelectedItem().toString();
        String status = "Requested";
        double tCost = qty * price;
        tblModel.addRow(new Object[]{category, txtItem.getText(), qty, "₱" + price, "₱" + tCost, status});
        
        txtItem.setText("");
        txtQty.setText("");
        txtPrice.setText("");
        updateSummary();
        JOptionPane.showMessageDialog(this, "Item requested!");
    }
    
    private void requestedItem() {
        int row = tblInve.getSelectedRow();
        if (row >= 0) {
            int current = Integer.parseInt(tblModel.getValueAt(row, 2).toString());
            String addStr = JOptionPane.showInputDialog(this, "Current: " + current + "\nAdd:");
            if (addStr != null) {
                try {
                    int add = Integer.parseInt(addStr);
                    int newQty = current + add;
                    tblModel.setValueAt(newQty, row, 2);
                    
                    double UPrice = Double.parseDouble(tblModel.getValueAt(row, 3).toString().replace("₱", ""));
                    double TCost = UPrice * newQty;
                    tblModel.setValueAt("₱" + TCost, row, 4);
                    
                    if (newQty < 50) {
                        tblModel.setValueAt("Requested - Low Stock", row, 5);
                    } else {
                        tblModel.setValueAt("Fulfilled", row, 5);
                    }
                    updateSummary();
                    JOptionPane.showMessageDialog(this, "Restock processed! New Qty: " + newQty);
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
            if (tblModel.getValueAt(i, 5).toString().contains("Low")) low++;
            
            try { 
                String TCosts = tblModel.getValueAt(i, 4).toString().replace("₱", "");
                double totalCost = Double.parseDouble(TCosts);
                value += totalCost; 
            } catch (Exception e) {}
        }
        lblTItem.setText(String.valueOf(total));
        lblLStock.setText(String.valueOf(low));
        lblTValue.setText("₱" + value);
    }
    
    private void addSampData() {
        tblModel.addRow(new Object[]{"Medication", "Paracetamol", 500, "₱5", "₱2500", "Good"});
        tblModel.addRow(new Object[]{"Equipment", "Stethoscope", 20, "₱1000", "₱20000", "Good"});
        tblModel.addRow(new Object[]{"Supplies", "Ibuprofen", 45, "₱50", "₱2250", "Low Stock"});
        
        updateSummary();
    }
}