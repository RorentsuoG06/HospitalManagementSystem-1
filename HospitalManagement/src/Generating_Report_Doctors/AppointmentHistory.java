package Generating_Report_Doctors;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AppointmentHistory extends JPanel implements ActionListener {

    private JPanel pnlMain;
    private JLabel lblLogo, lblHospital, lblAddress, lblContact, lblRefNo, lblDate,
            lblPName, lblPID, lblFooter, lblStatus, lblApprovedBy;
    private JTable tblApp;
    private JScrollPane scrTable;
    private ImageIcon imgLogo;
    private Image imgLG;
    private JButton btnSave, btnCopy, btnEdit, btnAddRow, btnDeleteRow, btnApprove, btnNewReport, btnEditPatient;
    private DefaultTableModel tableModel;
    private JPanel pnlApprove;
    private boolean isApproved = false;
    private String approvedByName = "";
    private String approvedByRole = "";
    private String status = "Pending";
    private String patientName = "";
    private String patientID = "P-";

    public AppointmentHistory() {
        setLayout(null);
        setBounds(0, 0, 1060, 750);
        setBackground(Color.WHITE);

        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBounds(0, 0, 1020, 750);
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(pnlMain);

        imgLogo = new ImageIcon(getClass().getResource("/resources/eTriage.DOCUMENT.LOGO.png"));
        imgLG = imgLogo.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(imgLG));
        lblLogo.setBounds(30, 25, 90, 90);
        pnlMain.add(lblLogo);

        lblHospital = new JLabel("ETRIAGE HOSPITAL");
        lblHospital.setFont(new Font("Calibri", Font.BOLD, 22));
        lblHospital.setForeground(darkBlue);
        lblHospital.setBounds(140, 30, 350, 25);
        pnlMain.add(lblHospital);

        lblAddress = new JLabel("123 Health St., Wellness City, Medical County");
        lblAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblAddress.setBounds(140, 55, 400, 18);
        pnlMain.add(lblAddress);

        lblContact = new JLabel("Tel No.: (02) 8123-4567");
        lblContact.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblContact.setBounds(140, 73, 300, 18);
        pnlMain.add(lblContact);

        btnNewReport = new JButton("New Report");
        btnNewReport.setBounds(600, 25, 100, 30);
        btnNewReport.setBackground(TealGreen);
        btnNewReport.setForeground(Color.WHITE);
        btnNewReport.addActionListener(this);
        pnlMain.add(btnNewReport);

        btnEditPatient = new JButton("Edit Patient");
        btnEditPatient.setBounds(710, 25, 100, 30);
        btnEditPatient.setBackground(darkBlue);
        btnEditPatient.setForeground(Color.WHITE);
        btnEditPatient.addActionListener(this);
        pnlMain.add(btnEditPatient);
        
        btnSave = new JButton("Save");
        btnSave.setBounds(830, 25, 80, 30);
        btnSave.setBackground(Green);
        btnSave.setForeground(Color.WHITE);
        btnSave.addActionListener(this);
        pnlMain.add(btnSave);
        
        btnCopy = new JButton("Copy");
        btnCopy.setBounds(920, 25, 80, 30);
        btnCopy.setBackground(mediumBlue);
        btnCopy.setForeground(Color.WHITE);
        btnCopy.addActionListener(this);
        pnlMain.add(btnCopy);

        lblRefNo = new JLabel("Ref No.: AP-2026-001");
        lblRefNo.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblRefNo.setBounds(740, 70, 200, 20);
        pnlMain.add(lblRefNo);

        lblDate = new JLabel("Generated: " + java.time.LocalDate.now());
        lblDate.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblDate.setBounds(740, 90, 200, 20);
        pnlMain.add(lblDate);
        
        lblStatus = new JLabel("Status: " + status);
        lblStatus.setFont(new Font("Calibri", Font.BOLD, 14));
        lblStatus.setForeground(orange);
        lblStatus.setBounds(740, 110, 200, 20);
        pnlMain.add(lblStatus);

        JPanel lineTop = new JPanel();
        lineTop.setBounds(30, 130, 940, 2);
        lineTop.setBackground(neutralGray);
        pnlMain.add(lineTop);

        JPanel pnlPatient = new JPanel();
        pnlPatient.setLayout(null);
        pnlPatient.setBounds(30, 150, 940, 80);
        pnlPatient.setBorder(BorderFactory.createTitledBorder("Patient Information"));
        pnlMain.add(pnlPatient);

        lblPName = new JLabel("Patient Name: " + patientName);
        lblPName.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblPName.setBounds(25, 30, 300, 20);
        pnlPatient.add(lblPName);

        lblPID = new JLabel("Patient ID: " + patientID);
        lblPID.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblPID.setBounds(400, 30, 200, 20);
        pnlPatient.add(lblPID);

        JPanel pnlTable = new JPanel();
        pnlTable.setLayout(null);
        pnlTable.setBounds(30, 250, 940, 300);
        pnlTable.setBorder(BorderFactory.createTitledBorder("Appointment Records"));
        pnlMain.add(pnlTable);

        String[] clmApp = {"Date", "Doctor", "Department", "Status", "Remarks"};
        String[][] rwApp = {
            {"04/15/2026", "Dr. Isabella Ramos", "General Medicine", "Completed", "Routine checkup"},
            {"03/28/2026", "Dr. Michael Santos", "Cardiology", "Completed", "BP monitoring"},
            {"03/10/2026", "Dr. Sarah Lopez", "Pediatrics", "Cancelled", "Patient rescheduled"},
            {"02/20/2026", "Dr. Isabella Ramos", "General Medicine", "Completed", "Follow-up"},
            {"01/25/2026", "Dr. John Cruz", "Emergency", "Completed", "Acute Bronchitis"}
        };

        tableModel = new DefaultTableModel(rwApp, clmApp);
        tblApp = new JTable(tableModel);
        tblApp.setRowHeight(35);
        tblApp.setFont(new Font("Calibri", Font.PLAIN, 13));
        tblApp.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 13));

        scrTable = new JScrollPane(tblApp);
        scrTable.setBounds(20, 30, 900, 200);
        pnlTable.add(scrTable);
        
        btnEdit = new JButton("Edit Selected");
        btnEdit.setBounds(20, 250, 120, 30);
        btnEdit.setBackground(darkBlue);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.addActionListener(this);
        pnlTable.add(btnEdit);
        
        btnAddRow = new JButton("Add Row");
        btnAddRow.setBounds(150, 250, 100, 30);
        btnAddRow.setBackground(TealGreen);
        btnAddRow.setForeground(Color.WHITE);
        btnAddRow.addActionListener(this);
        pnlTable.add(btnAddRow);
        
        btnDeleteRow = new JButton("Delete Row");
        btnDeleteRow.setBounds(260, 250, 100, 30);
        btnDeleteRow.setBackground(LightRed);
        btnDeleteRow.setForeground(Color.WHITE);
        btnDeleteRow.addActionListener(this);
        pnlTable.add(btnDeleteRow);

        pnlApprove = new JPanel();
        pnlApprove.setLayout(null);
        pnlApprove.setBounds(30, 580, 940, 80);
        pnlApprove.setBackground(Color.WHITE);
        pnlMain.add(pnlApprove);
        
        btnApprove = new JButton("APPROVE & SIGN");
        btnApprove.setBounds(370, 15, 200, 45);
        btnApprove.setBackground(Green);
        btnApprove.setForeground(Color.WHITE);
        btnApprove.addActionListener(this);
        pnlApprove.add(btnApprove);

        JPanel lineFooter = new JPanel();
        lineFooter.setBounds(30, 680, 940, 2);
        lineFooter.setBackground(neutralGray);
        pnlMain.add(lineFooter);

        lblApprovedBy = new JLabel("");
        lblApprovedBy.setFont(new Font("Calibri", Font.BOLD, 14));
        lblApprovedBy.setForeground(Green);
        lblApprovedBy.setBounds(60, 700, 500, 25);
        pnlMain.add(lblApprovedBy);

        lblFooter = new JLabel("Total Appointments: 5 | Completed: 4 | Cancelled: 1");
        lblFooter.setFont(new Font("Calibri", Font.ITALIC, 12));
        lblFooter.setBounds(300, 730, 400, 20);
        pnlMain.add(lblFooter);
        
        updateApproveButtonState();
    }
    
    private boolean isReportComplete() {
        if (patientName.isEmpty() || patientID.isEmpty()) {
            return false;
        }
        if (tableModel.getRowCount() == 0) {
            return false;
        }
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String date = tableModel.getValueAt(i, 0).toString();
            String doctor = tableModel.getValueAt(i, 1).toString();
            if (date.isEmpty() || doctor.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    private void updateApproveButtonState() {
        if (isApproved) {
            btnApprove.setBackground(new Color(0, 150, 0));
            btnApprove.setText("✓ APPROVED");
            btnApprove.setEnabled(false);
        } else if (!isReportComplete()) {
            btnApprove.setBackground(Color.GRAY);
            btnApprove.setText("INCOMPLETE");
            btnApprove.setEnabled(false);
        } else {
            btnApprove.setBackground(Green);
            btnApprove.setText("APPROVE & SIGN");
            btnApprove.setEnabled(true);
        }
    }
    
    private void saveReport() {
        if (isReportComplete()) {
            status = "Saved";
            lblStatus.setText("Status: Saved");
            lblStatus.setForeground(Green);
            JOptionPane.showMessageDialog(this, "Report saved successfully!", "Save Complete", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cannot save report! Please fill all required fields first.", "Incomplete Report", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void copyReport() {
        StringBuilder data = new StringBuilder("=== ETRIAGE HOSPITAL APPOINTMENT HISTORY ===\n\n");
        data.append("Patient Name: " + patientName + "\n");
        data.append("Patient ID: " + patientID + "\n\n");
        data.append("Date\t\tDoctor\t\tDepartment\t\tStatus\t\tRemarks\n");
        data.append("-------------------------------------------------------------------\n");
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                data.append(tableModel.getValueAt(i, j)).append("\t\t");
            }
            data.append("\n");
        }
        StringSelection ss = new StringSelection(data.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        JOptionPane.showMessageDialog(this, "Report copied to clipboard!", "Copy Complete", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void editSelectedRow() {
        int row = tblApp.getSelectedRow();
        if (row >= 0) {
            JTextField txtDate = new JTextField(tableModel.getValueAt(row, 0).toString());
            JTextField txtDoctor = new JTextField(tableModel.getValueAt(row, 1).toString());
            JTextField txtDept = new JTextField(tableModel.getValueAt(row, 2).toString());
            JComboBox<String> cmbStatus = new JComboBox<>(new String[]{"Scheduled", "Completed", "Cancelled", "Pending"});
            cmbStatus.setSelectedItem(tableModel.getValueAt(row, 3).toString());
            JTextField txtRemarks = new JTextField(tableModel.getValueAt(row, 4).toString());
            
            JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
            panel.add(new JLabel("Date:")); panel.add(txtDate);
            panel.add(new JLabel("Doctor:")); panel.add(txtDoctor);
            panel.add(new JLabel("Department:")); panel.add(txtDept);
            panel.add(new JLabel("Status:")); panel.add(cmbStatus);
            panel.add(new JLabel("Remarks:")); panel.add(txtRemarks);
            
            int result = JOptionPane.showConfirmDialog(this, panel, "Edit Appointment", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if (txtDate.getText().trim().isEmpty() || txtDoctor.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Date and Doctor are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                tableModel.setValueAt(txtDate.getText(), row, 0);
                tableModel.setValueAt(txtDoctor.getText(), row, 1);
                tableModel.setValueAt(txtDept.getText(), row, 2);
                tableModel.setValueAt(cmbStatus.getSelectedItem(), row, 3);
                tableModel.setValueAt(txtRemarks.getText(), row, 4);
                JOptionPane.showMessageDialog(this, "Row updated!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row first!");
        }
    }
    
    private void addRow() {
        tableModel.addRow(new Object[]{"", "", "", "Pending", ""});
        JOptionPane.showMessageDialog(this, "New row added. Click Edit Selected to fill data.");
    }
    
    private void deleteRow() {
        int row = tblApp.getSelectedRow();
        if (row >= 0) {
            tableModel.removeRow(row);
            JOptionPane.showMessageDialog(this, "Row deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Select a row first!");
        }
    }
    
    private void editPatient() {
        JTextField txtPatientName = new JTextField(patientName, 20);
        JTextField txtPatientID = new JTextField(patientID, 20);
        
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Patient Name:")); panel.add(txtPatientName);
        panel.add(new JLabel("Patient ID:")); panel.add(txtPatientID);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Patient Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            if (txtPatientName.getText().trim().isEmpty() || txtPatientID.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Patient Name and ID are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            patientName = txtPatientName.getText().trim();
            patientID = txtPatientID.getText().trim();
            lblPName.setText("Patient Name: " + patientName);
            lblPID.setText("Patient ID: " + patientID);
            isApproved = false;
            approvedByName = "";
            approvedByRole = "";
            lblApprovedBy.setText("");
            status = "Pending";
            lblStatus.setText("Status: Pending");
            lblStatus.setForeground(orange);
            updateApproveButtonState();
            JOptionPane.showMessageDialog(this, "Patient information updated!");
        }
    }
    
    private void approveDocument() {
        if (!isReportComplete()) {
            JOptionPane.showMessageDialog(this, "Cannot approve! Please fill all required fields first.", "Incomplete Report", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JPanel approvePanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField txtName = new JTextField(15);
        JComboBox<String> cmbRole = new JComboBox<>(new String[]{"Doctor", "Department Head"});
        
        approvePanel.add(new JLabel("Approver Name:"));
        approvePanel.add(txtName);
        approvePanel.add(new JLabel("Role:"));
        approvePanel.add(cmbRole);
        
        int result = JOptionPane.showConfirmDialog(this, approvePanel, "Document Approval", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String name = txtName.getText().trim();
            String role = (String) cmbRole.getSelectedItem();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter approver name!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            isApproved = true;
            approvedByName = name;
            approvedByRole = role;
            status = "Approved";
            lblStatus.setText("Status: Approved");
            lblStatus.setForeground(Green);
            lblApprovedBy.setText("✓ APPROVED by: " + name + " (" + role + ") on " + java.time.LocalDate.now());
            btnApprove.setBackground(new Color(0, 150, 0));
            btnApprove.setText("✓ APPROVED");
            btnApprove.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Document Approved and Signed!", "Approval Complete", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void newReport() {
        int confirm = JOptionPane.showConfirmDialog(this, "Create new blank report? Unsaved data will be lost.", "New Report", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.setRowCount(0);
            patientName = "";
            patientID = "";
            lblPName.setText("Patient Name: ________");
            lblPID.setText("Patient ID: ________");
            isApproved = false;
            approvedByName = "";
            approvedByRole = "";
            lblApprovedBy.setText("");
            status = "Pending";
            lblStatus.setText("Status: Pending");
            lblStatus.setForeground(orange);
            updateApproveButtonState();
            JOptionPane.showMessageDialog(this, "New blank report created. Click 'Edit Patient' to fill in information.", "New Report", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewReport) newReport();
        else if (e.getSource() == btnEditPatient) editPatient();
        else if (e.getSource() == btnSave) saveReport();
        else if (e.getSource() == btnCopy) copyReport();
        else if (e.getSource() == btnApprove) approveDocument();
        else if (e.getSource() == btnEdit) editSelectedRow();
        else if (e.getSource() == btnAddRow) addRow();
        else if (e.getSource() == btnDeleteRow) deleteRow();
    }
}