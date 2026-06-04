package Inventory;

import static Color_Palette.ColorPalette.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserManagementPanel extends JPanel {
    
    private JPanel pnlMain,tabAdmin,tabDoc,tabNur,pnlSelection,pnlBot,tabUpdate;
    private DefaultTableModel tblModel;
    private JTextField txtName, txtID, txtAge, txtEmail, txtPhone;
    private String currentRole = "Doctor";
    private JTable tblUM;
    private JLabel lblAd, lblDoc, lblNur,lbltitle,lblDT,lblName,lblID,lblAge,lblTitle,lblValue, lblDept,
                   lblEmail, lblPhone, lblStatus;
    private JButton btnDoctor, btnNurse, btnAdmin, btnSave, btnEdit, btnDelete, btnRefresh, btnVProfile, btnSCreds, btnCStatus;
    private JScrollPane srcUM;
    private JComboBox<String> cmbStatus, cmbDept;
    
    public UserManagementPanel() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
        
        lbltitle = new JLabel("User Management Dashboard");
        lbltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lbltitle);
        
        lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
       
        btnAdmin = new JButton("ADMIN");
        btnAdmin.setBackground(darkBlue);
        btnAdmin.setForeground(Color.WHITE);
        btnAdmin.setFont(new Font("Calibri", Font.BOLD, 18));
        btnAdmin.setFocusPainted(false);
        btnAdmin.setBounds(30, 80, 120, 35);
        btnAdmin.addActionListener(e -> switchRole("Admin"));
        pnlMain.add(btnAdmin);
        
        btnDoctor = new JButton("DOCTOR");
        btnDoctor.setBackground(mediumBlue);
        btnDoctor.setForeground(Color.WHITE);
        btnDoctor.setFont(new Font("Calibri", Font.BOLD, 18));
        btnDoctor.setFocusPainted(false);
        btnDoctor.setBounds(160, 80, 120, 35);
        btnDoctor.addActionListener(e -> switchRole("Doctor"));
        pnlMain.add(btnDoctor);
        
        btnNurse = new JButton("NURSE");
        btnNurse.setBackground(lightBlue);
        btnNurse.setForeground(Color.WHITE);
        btnNurse.setFont(new Font("Calibri", Font.BOLD, 18));
        btnNurse.setFocusPainted(false);
        btnNurse.setBounds(290, 80, 120, 35);
        btnNurse.addActionListener(e -> switchRole("Nurse"));
        pnlMain.add(btnNurse);
        
        tabAdmin = createTab("Admin", "0", darkBlue);
        tabAdmin.setBounds(30, 130, 250, 60);
        pnlMain.add(tabAdmin);
        lblAd = (JLabel) tabAdmin.getComponent(1);

        tabDoc = createTab("Doctor", "0", mediumBlue);
        tabDoc.setBounds(300, 130, 250, 60);
        pnlMain.add(tabDoc);
        lblDoc = (JLabel) tabDoc.getComponent(1);

        tabNur = createTab("Nurse", "0", lightBlue);
        tabNur.setBounds(570, 130, 250, 60);
        pnlMain.add(tabNur);
        lblNur = (JLabel) tabNur.getComponent(1);
        
        pnlSelection = new JPanel();
        pnlSelection.setLayout(null);
        pnlSelection.setBackground(Color.WHITE);
        pnlSelection.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlSelection.setBounds(30, 210, 1350, 120);
        pnlMain.add(pnlSelection);

        lblName = new JLabel("Name:");
        lblName.setBounds(15, 28, 100, 25);
        lblName.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(120, 26, 200, 28);
        pnlSelection.add(txtName);

        lblID = new JLabel("ID:");
        lblID.setBounds(340, 28, 100, 25);
        lblID.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblID);

        txtID = new JTextField();
        txtID.setBounds(445, 26, 200, 28);
        pnlSelection.add(txtID);

        lblAge = new JLabel("Age:");
        lblAge.setBounds(665, 28, 100, 25);
        lblAge.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(770, 26, 200, 28);
        pnlSelection.add(txtAge);
        
        lblDept = new JLabel("Department:");
        lblDept.setBounds(15, 70, 100, 25);
        lblDept.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblDept);

        cmbDept = new JComboBox<>(new String[]{"ER","Pediatrics","Surgery","Pharmacy","Radiology","General"});
        cmbDept.setBounds(120, 68, 200, 28);
        pnlSelection.add(cmbDept);
        
        lblStatus = new JLabel("Status:");
        lblStatus.setBounds(340, 70, 100, 25);
        lblStatus.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblStatus);

        cmbStatus = new JComboBox<>(new String[]{"Active","Inactive","On Leave"});
        cmbStatus.setBounds(445, 68, 200, 28);
        pnlSelection.add(cmbStatus);

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(665, 70, 100, 25);
        lblEmail.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(770, 68, 200, 28);
        pnlSelection.add(txtEmail);

        lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(990, 28, 100, 25);
        lblPhone.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(1095, 26, 200, 28);
        pnlSelection.add(txtPhone);

        btnSave = new JButton("Save");
        btnSave.setBounds(990, 65, 150, 35);
        btnSave.setBackground(Green);
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Calibri", Font.BOLD, 14));
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(e -> addUser(cmbDept, txtEmail, txtPhone));
        pnlSelection.add(btnSave);

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(1150, 65, 150, 35);
        btnEdit.setBackground(darkBlue);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(e -> editUser());
        pnlSelection.add(btnEdit);
       
        String[] clm = {"Name", "ID", "Age", "Role", "Status", "Department", "Email", "Phone"};
        tblModel = new DefaultTableModel(clm, 0);
        tblUM = new JTable(tblModel);
        tblUM.setRowHeight(40);
        tblUM.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblUM.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tblUM.getTableHeader().setBackground(lightBlue);
        
        srcUM = new JScrollPane(tblUM);
        srcUM.setBounds(30, 350, 1560, 500);
        pnlMain.add(srcUM);
        
        pnlBot = new JPanel();
        pnlBot.setLayout(null);
        pnlBot.setBackground(Color.WHITE);
        pnlBot.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlBot.setBounds(30, 860, 1560, 50);
        pnlMain.add(pnlBot);

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(LightRed);
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Calibri", Font.BOLD, 14));
        btnDelete.setFocusPainted(false);
        btnDelete.setBounds(20, 10, 120, 30);
        btnDelete.addActionListener(e -> deleteUser());
        pnlBot.add(btnDelete);

        btnRefresh = new JButton("Refresh");
        btnRefresh.setBackground(Blue);
        btnRefresh.setForeground(Color.WHITE);
        btnRefresh.setFont(new Font("Calibri", Font.BOLD, 14));
        btnRefresh.setFocusPainted(false);
        btnRefresh.setBounds(160, 10, 120, 30);
        btnRefresh.addActionListener(e -> refreshTable());
        pnlBot.add(btnRefresh);

        btnVProfile = new JButton("View Profile");
        btnVProfile.setBackground(mediumBlue);
        btnVProfile.setForeground(Color.WHITE);
        btnVProfile.setFont(new Font("Calibri", Font.BOLD, 14));
        btnVProfile.setFocusPainted(false);
        btnVProfile.setBounds(300, 10, 150, 30);
        btnVProfile.addActionListener(e -> viewProfile());
        pnlBot.add(btnVProfile);

        btnSCreds = new JButton("Send Credentials");
        btnSCreds.setBackground(TealGreen);
        btnSCreds.setForeground(Color.WHITE);
        btnSCreds.setFont(new Font("Calibri", Font.BOLD, 14));
        btnSCreds.setFocusPainted(false);
        btnSCreds.setBounds(470, 10, 180, 30);
        btnSCreds.addActionListener(e -> sendCredentials());
        pnlBot.add(btnSCreds);

        btnCStatus = new JButton("Change Status");
        btnCStatus.setBackground(orange);
        btnCStatus.setForeground(Color.WHITE);
        btnCStatus.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCStatus.setFocusPainted(false);
        btnCStatus.setBounds(670, 10, 150, 30);
        btnCStatus.addActionListener(e -> changeStatus());
        pnlBot.add(btnCStatus);

        disableInputs();
        addSampData();
    }
    
    private void disableInputs() {
        txtName.setEnabled(false);
        txtID.setEnabled(false);
        txtAge.setEnabled(false);
        txtEmail.setEnabled(false);
        txtPhone.setEnabled(false);
        cmbDept.setEnabled(false);
        cmbStatus.setEnabled(false);
        btnSave.setEnabled(false);
    }

    private void enableInputs() {
        txtName.setEnabled(true);
        txtID.setEnabled(true);
        txtAge.setEnabled(true);
        txtEmail.setEnabled(true);
        txtPhone.setEnabled(true);
        cmbDept.setEnabled(true);
        cmbStatus.setEnabled(true);
        btnSave.setEnabled(true);
    }

    private void switchRole(String role) {
        currentRole = role;
        enableInputs();

        if (role.equals("Admin")) {
            txtID.setText("ADM");
        } else if (role.equals("Doctor")) {
            txtID.setText("DCT");
        } else if (role.equals("Nurse")) {
            txtID.setText("NRS");
        }
        
        JOptionPane.showMessageDialog(this, "Current Role: " + role);
    }
    
    private JPanel createTab(String title, String value, Color color) {
        tabUpdate = new JPanel();
        tabUpdate.setLayout(null);
        tabUpdate.setBackground(color);

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(20, 20, 200, 25);
        tabUpdate.add(lblTitle);

        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Calibri", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);
        lblValue.setBounds(200, 20, 100, 25);
        tabUpdate.add(lblValue);

        return tabUpdate;
    }
    
    private void addUser(JComboBox<String> cmbDept, JTextField txtEmail, JTextField txtPhone) {
        String name = txtName.getText().trim();
        String id = txtID.getText().trim();
        String age = txtAge.getText().trim();
        String dept = cmbDept.getSelectedItem().toString();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String status = cmbStatus.getSelectedItem().toString();
        
        if (name.isEmpty() || id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NAME and ID!");
            return;
        }
        
        if (currentRole.equals("Admin") && !id.startsWith("ADM")) {
            id = "ADM" + id;
        } else if (currentRole.equals("Doctor") && !id.startsWith("DCT")) {
            id = "DCT" + id;
        } else if (currentRole.equals("Nurse") && !id.startsWith("NRS")) {
            id = "NRS" + id;
        }

        for (int i = 0; i < tblModel.getRowCount(); i++) {
            String existingId = tblModel.getValueAt(i, 1).toString();
                if (existingId.equalsIgnoreCase(id)) {
                    JOptionPane.showMessageDialog(this, "Duplicate ID not allowed!");
                    return;
        }
    }
        
        tblModel.addRow(new Object[]{name, id, age, currentRole, status, dept, email, phone});
        
        txtName.setText("");
        txtID.setText("");
        txtAge.setText("");
        cmbDept.setSelectedIndex(0);
        txtEmail.setText("");
        txtPhone.setText("");
        cmbStatus.setSelectedIndex(0);
        updateSummary();
        
        JOptionPane.showMessageDialog(this, currentRole + " added successfully!");
    }
    
    private void changeStatus() {
        int row = tblUM.getSelectedRow();
            if (row >= 0) {
                String currentStatus = tblModel.getValueAt(row, 4).toString();
                String[] options = {"Active", "Inactive", "On Leave"};
                String newStatus = (String) JOptionPane.showInputDialog(
                                this,
                                "Change status:",
                                "Update Employee Status",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options,
                                currentStatus);
                
        if (newStatus != null) {
            tblModel.setValueAt(newStatus, row, 4);
            JOptionPane.showMessageDialog(this, "Status updated to " + newStatus);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Select an employee to change status!");
    }
}
    
    private void editUser() {
        int row = tblUM.getSelectedRow();
        if (row >= 0) {
            txtName.setText(tblModel.getValueAt(row, 0).toString());
            txtID.setText(tblModel.getValueAt(row, 1).toString());
            txtAge.setText(tblModel.getValueAt(row, 2).toString());
            
            String role = tblModel.getValueAt(row, 3).toString();
            currentRole = role;
            
            cmbStatus.setSelectedItem(tblModel.getValueAt(row, 4).toString());
            cmbDept.setSelectedItem(tblModel.getValueAt(row, 5).toString());
            txtEmail.setText(tblModel.getValueAt(row, 6).toString());
            txtPhone.setText(tblModel.getValueAt(row, 7).toString());
            
            JOptionPane.showMessageDialog(this, "Edit the details and click SAVE");
        } else {
            JOptionPane.showMessageDialog(this, "Select a user to edit!");
        }
    }
    
    private void deleteUser() {
        int row = tblUM.getSelectedRow();
        if (row >= 0) {
            String name = tblModel.getValueAt(row, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this, "Delete " + name + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tblModel.removeRow(row);
                updateSummary();
                JOptionPane.showMessageDialog(this, "User deleted!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a user to delete!");
        }
    }
    
    private void updateSummary() {
        int total = tblModel.getRowCount();
        int admin = 0, doctor = 0, nurse = 0;
        for (int i = 0; i < total; i++) {
            String role = tblModel.getValueAt(i, 3).toString();
                if (role.equals("Admin")) admin++;
                if (role.equals("Doctor")) doctor++;
                if (role.equals("Nurse")) nurse++;
        }
        lblAd.setText(String.valueOf(admin));
        lblDoc.setText(String.valueOf(doctor));
        lblNur.setText(String.valueOf(nurse));
    }
    
    private void refreshTable() {
        tblModel.setRowCount(0);
        addSampData();
        JOptionPane.showMessageDialog(this, "Table refreshed!");
    }
    
    private void viewProfile() {
        int row = tblUM.getSelectedRow();
        if (row >= 0) {
            String profile = 
                "Employee Profile:\n\n" +
                "Name: " + tblModel.getValueAt(row, 0) + "\n" +
                "ID: " + tblModel.getValueAt(row, 1) + "\n" +
                "Age: " + tblModel.getValueAt(row, 2) + "\n" +
                "Role: " + tblModel.getValueAt(row, 3) + "\n" +
                "Status: " + tblModel.getValueAt(row, 4) + "\n" +
                "Department: " + tblModel.getValueAt(row, 5) + "\n" +
                "Email: " + tblModel.getValueAt(row, 6) + "\n" +
                "Phone: " + tblModel.getValueAt(row, 7);

            JOptionPane.showMessageDialog(this, profile,"Profile Details",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Select an employee to view profile!");
        }
    }

    private void sendCredentials() {
        int row = tblUM.getSelectedRow();
        if (row >= 0) {
            String name = tblModel.getValueAt(row, 0).toString();
            String id = tblModel.getValueAt(row, 1).toString();

            JOptionPane.showMessageDialog(this,
                "Employee Credentials:\n\n" +
                "Name: " + name + "\n" +
                "ID: " + id,
                "Send Credentials",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Select an employee to send credentials!");
        }
    }
    
    private void addSampData() {
        tblModel.addRow(new Object[]{"Admin John Smith", "ADM001", "45", "Admin", "Active", "General", "john.smith@hospital.com", "09171234567"});
        tblModel.addRow(new Object[]{"Dr. Sarah Lee", "DCT001", "38", "Doctor", "Active", "Surgery", "sarah.lee@hospital.com", "09181234567"});
        tblModel.addRow(new Object[]{"Nurse Emma Watson", "NRS001", "29", "Nurse", "Active", "Pediatrics", "emma.watson@hospital.com", "09191234567"});
        tblModel.addRow(new Object[]{"Nurse Olivia Brown", "NRS002", "32", "Nurse", "Active", "ER", "olivia.brown@hospital.com", "09201234567"});
        tblModel.addRow(new Object[]{"Admin Mike Ross", "ADM002", "41", "Admin", "Active", "Pharmacy", "mike.ross@hospital.com", "09211234567"});
        tblModel.addRow(new Object[]{"Admin Rachel Green", "ADM003", "35", "Admin", "Active", "Radiology", "rachel.green@hospital.com", "09221234567"});

        updateSummary();
    }
}