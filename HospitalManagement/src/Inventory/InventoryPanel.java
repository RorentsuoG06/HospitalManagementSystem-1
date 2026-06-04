package Inventory;

import static Color_Palette.ColorPalette.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.awt.*;

public class InventoryPanel extends JPanel {
    
    private JPanel pnlMain, tabItem, tabLows, tabValue, pnlSelection, pnlBot, tabUpdate;
    private DefaultTableModel tblModel;
    private JTextField txtItem, txtQty, txtPrice, txtExpiry;
    private JLabel lbltitle, lblDT, lblTItem, lblLStock, lblTValue, lblItem, lblQty, lblPrice, lblTitle, lblValue, lblCat,
                   lblExpiry;
    private JTable tblInve;
    private JButton btnAdd, btnEdit, btnRestock, btnRemove;
    private JScrollPane srcInve;
    private JComboBox<String> cmbCategory;
    
    public InventoryPanel() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
        
        lbltitle = new JLabel("Inventory Management");
        lbltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lbltitle);
        
        lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
   
        tabItem = createTab("Total Items", "0", darkBlue);
        tabItem.setBounds(30, 80, 500, 100);
        pnlMain.add(tabItem);
        lblTItem = (JLabel) tabItem.getComponent(1);
        
        tabLows = createTab("Low Stock", "0", Yellow);
        tabLows.setBounds(550, 80, 500, 100);
        pnlMain.add(tabLows);
        lblLStock = (JLabel) tabLows.getComponent(1);
        
        tabValue = createTab("Total Value", "₱0", mediumBlue);
        tabValue.setBounds(1070, 80, 500, 100);
        pnlMain.add(tabValue);
        lblTValue = (JLabel) tabValue.getComponent(1);
      
        pnlSelection = new JPanel();
        pnlSelection.setLayout(null);
        pnlSelection.setBackground(Color.WHITE);
        pnlSelection.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlSelection.setBounds(30, 210, 1350, 120);
        pnlMain.add(pnlSelection);
        
        lblCat = new JLabel("Category:");
        lblCat.setBounds(15, 28, 100, 25);
        lblCat.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblCat);
        
        cmbCategory = new JComboBox<>(new String[]{"Medicine", "Equipment", "Supplies"});
        cmbCategory.setBounds(120, 26, 200, 28);
        pnlSelection.add(cmbCategory);
        
        lblItem = new JLabel("Item:");
        lblItem.setBounds(340, 28, 100, 25);
        lblItem.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblItem);
        
        txtItem = new JTextField();
        txtItem.setBounds(445, 26, 200, 28);
        pnlSelection.add(txtItem);
        
        lblExpiry = new JLabel("Expiry (YYYY-MM-DD):");
        lblExpiry.setBounds(665, 28, 200, 25);
        pnlSelection.add(lblExpiry);

        txtExpiry = new JTextField();
        txtExpiry.setBounds(840, 26,200, 28);
        pnlSelection.add(txtExpiry);
        
        lblPrice = new JLabel("Price:");
        lblPrice.setBounds(15, 70, 100, 25);
        lblPrice.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblPrice);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(120, 70, 200, 28);
        pnlSelection.add(txtPrice);
        
        lblQty = new JLabel("Qty:");
        lblQty.setBounds(340, 70, 200, 25);
        lblQty.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblQty);
        
        txtQty = new JTextField();
        txtQty.setBounds(445, 70, 200, 28);
        pnlSelection.add(txtQty);
        
        btnAdd = new JButton("Add Item");
        btnAdd.setBackground(Green);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAdd.setFocusPainted(false);
        btnAdd.setBounds(1080, 25, 150, 35);
        btnAdd.addActionListener(e -> addItem());
        pnlSelection.add(btnAdd);
        
        btnEdit = new JButton("Edit Item");
        btnEdit.setBackground(darkBlue);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
        btnEdit.setFocusPainted(false);
        btnEdit.setBounds(1080, 70, 150, 35);
        btnEdit.addActionListener(e -> editItem());
        pnlSelection.add(btnEdit);

        String[] clm = {"Category", "Item", "Quantity", "Price", "Status", "Expiry"};
        tblModel = new DefaultTableModel(clm, 0);
        tblInve = new JTable(tblModel);
        tblInve.setRowHeight(35);
        tblInve.setAutoCreateRowSorter(true);
        tblInve.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblInve.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tblInve.getTableHeader().setBackground(lightBlue);
        
        srcInve = new JScrollPane(tblInve);
        srcInve.setBounds(30, 350, 1560, 500);
        pnlMain.add(srcInve);
        
        pnlBot = new JPanel();
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
        tabUpdate = new JPanel();
        tabUpdate.setLayout(null);
        tabUpdate.setBackground(color);
        
        lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(20, 20, 250, 25);
        tabUpdate.add(lblTitle);
        
        lblValue = new JLabel(value);
        lblValue.setFont(new Font("Calibri", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);
        lblValue.setBounds(20, 50, 150, 40);
        tabUpdate.add(lblValue);
        
        return tabUpdate;
    }
    
    private void addItem() {
        String category = cmbCategory.getSelectedItem().toString();
        String item = txtItem.getText().trim();
        String qtyStr = txtQty.getText().trim();
        String priceStr = txtPrice.getText().trim();
        String expiry = txtExpiry.getText().trim();

        if (item.isEmpty() || qtyStr.isEmpty() || priceStr.isEmpty() || expiry.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        int qty = Integer.parseInt(qtyStr);
        double price = Double.parseDouble(priceStr);

        String status = qty < 50 ? "Low Stock" : "Good";
        try {
            LocalDate expDate = LocalDate.parse(expiry);
            if (expDate.isBefore(LocalDate.now().plusDays(30))) {
                status = "Expiring Soon";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid expiry date format (use YYYY-MM-DD).");
            return;
        }
        
        tblInve.clearSelection();

        int row = tblInve.getSelectedRow();
            if (row >= 0) {
                tblModel.setValueAt(category, row, 0);
                tblModel.setValueAt(item, row, 1);
                tblModel.setValueAt(qty, row, 2);
                tblModel.setValueAt("₱" + price, row, 3);
                tblModel.setValueAt(status, row, 4);
                tblModel.setValueAt(expiry, row, 5);
                JOptionPane.showMessageDialog(this, "Item updated!");
            } else {
                tblModel.addRow(new Object[]{category, item, qty, "₱" + price, status, expiry});
                JOptionPane.showMessageDialog(this, "Item added!");
            }

        txtItem.setText("");
        txtQty.setText("");
        txtPrice.setText("");
        txtExpiry.setText("");
        updateSummary();
    }
    
    private void editItem() {
        int row = tblInve.getSelectedRow();
            if (row >= 0) {
                cmbCategory.setSelectedItem(tblModel.getValueAt(row, 0).toString());
                txtItem.setText(tblModel.getValueAt(row, 1).toString());
                txtQty.setText(tblModel.getValueAt(row, 2).toString());
                txtPrice.setText(tblModel.getValueAt(row, 3).toString().replace("₱", ""));
                txtExpiry.setText(tblModel.getValueAt(row, 5).toString());

                JOptionPane.showMessageDialog(this, "Edit fields and click Add Item to save changes.");
            } else {
                JOptionPane.showMessageDialog(this, "Select an item to edit!");
            }
        }
    
    private void restockItem() {
        int row = tblInve.getSelectedRow();
        if (row >= 0) {
            int current = (int) tblModel.getValueAt(row, 2);
            String addStr = JOptionPane.showInputDialog(this, "Current: " + current + "\nAdd:");
            if (addStr != null) {
                try {
                    int add = Integer.parseInt(addStr);
                    int newQty = current + add;
                        tblModel.setValueAt(newQty, row, 2);
                        tblModel.setValueAt(newQty < 50 ? "Low Stock" : "Good", row, 4);
                    updateSummary();
                    JOptionPane.showMessageDialog(this, "Restocked! New: " + newQty);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Invalid number entered!");
                }
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
            if (tblModel.getValueAt(i, 4).toString().contains("Low")) low++;
                
            String price = tblModel.getValueAt(i, 3).toString().replace("₱", "");
            try { value += Double.parseDouble(price); } catch (Exception e) {}
        }
        lblTItem.setText(String.valueOf(total));
        lblLStock.setText(String.valueOf(low));
        lblTValue.setText("₱" + value);
    }
    
    private void addSampData() {
        tblModel.addRow(new Object[]{"Medicine", "Paracetamol", 500, "₱2500", "Good", "2026-12-31"});
        tblModel.addRow(new Object[]{"Medicine", "Amoxicillin", 300, "₱4500", "Good", "2026-11-15"});
        tblModel.addRow(new Object[]{"Medicine", "Ibuprofen", 45, "₱1500", "Low Stock", "2026-07-01"});
        updateSummary();
    }
}