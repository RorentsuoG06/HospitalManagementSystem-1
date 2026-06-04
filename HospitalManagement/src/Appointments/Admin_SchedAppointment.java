package Appointments;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Admin_SchedAppointment extends JPanel implements ActionListener{

    private JPanel pnlMain, tabPatients, tabAdmitted, tabCompleted, tabPending, tabUr, pnlSelection, pnlBot, tabUpdate;
    private DefaultTableModel tblModel;
    private JTextField txtPatient, txtDoc, txtTreatment;
    private JTable tblAppoint;
    private JLabel lblTitle, lblDT, lblPatient, lblDoc, lblTreatment, lblTPatient, lblUCases, lblPAppointments, 
                   lblTitle2, lblValue, lblAdmitted, lblCompleted;
    private JButton btnAdd, btnEdit, btnRev, btnChangeStatus;
    private JScrollPane srcApp;
    private int PNum = 10000;
    
    public Admin_SchedAppointment() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        //Main Panel
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
        
        lblTitle = new JLabel("Appointment Management");
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lblTitle);
        
        lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
        
        tabPatients = createTab("Today's Patients", "0", Blue);
        tabPatients.setBounds(30, 80, 300, 100);
        pnlMain.add(tabPatients);
        lblTPatient = (JLabel) tabPatients.getComponent(1);

        tabPending = createTab("Pending Appointments", "0", Yellow);
        tabPending.setBounds(350, 80, 300, 100);
        pnlMain.add(tabPending);
        lblPAppointments = (JLabel) tabPending.getComponent(1);
        
        tabAdmitted = createTab("Admitted Appointments", "0", darkBlue);
        tabAdmitted.setBounds(670, 80, 300, 100);
        pnlMain.add(tabAdmitted);
        lblAdmitted = (JLabel) tabAdmitted.getComponent(1);

        tabUr = createTab("Urgent Cases", "0", LightRed);
        tabUr.setBounds(990, 80, 300, 100);
        pnlMain.add(tabUr);
        lblUCases = (JLabel) tabUr.getComponent(1);
        
        tabCompleted = createTab("Completed Appointments", "0", Green);
        tabCompleted.setBounds(1310, 80, 280, 100);
        pnlMain.add(tabCompleted);
        lblCompleted = (JLabel) tabCompleted.getComponent(1);
        
        pnlSelection = new JPanel();
        pnlSelection.setLayout(null);
        pnlSelection.setBackground(Color.WHITE);
        pnlSelection.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlSelection.setBounds(30, 210, 1130, 80);
        pnlMain.add(pnlSelection);
        
        lblPatient = new JLabel("Patient: ");
        lblPatient.setBounds(15, 28, 80, 25);
        lblPatient.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblPatient);
        
        txtPatient = new JTextField();
        txtPatient.setBounds(80, 26, 150, 28);
        pnlSelection.add(txtPatient);
        
        lblDoc = new JLabel("Doctor: ");
        lblDoc.setBounds(260, 28, 80, 25);
        lblDoc.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblDoc);
        
        txtDoc = new JTextField();
        txtDoc.setBounds(320, 26, 150, 28);
        pnlSelection.add(txtDoc);
        
        lblTreatment = new JLabel("Treatment: ");
        lblTreatment.setBounds(500, 28, 100, 25);
        lblTreatment.setFont(new Font("Calibri", Font.BOLD, 16));
        pnlSelection.add(lblTreatment);
        
        txtTreatment = new JTextField();
        txtTreatment.setBounds(580, 26, 150, 28);
        pnlSelection.add(txtTreatment);
        
        btnAdd = new JButton("Add Appointment");
        btnAdd.setBounds(760, 22, 150, 35);
        btnAdd.setBackground(Green);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Calibri", Font.BOLD, 14));
        btnAdd.addActionListener(e -> addAppointment());
        pnlSelection.add(btnAdd);
        
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(940, 20, 150, 35);
        btnEdit.setBackground(darkBlue);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(e -> editAppointment());
        pnlSelection.add(btnEdit);
        
        String[] clm = {"Patient Number", "Patient", "Doctor", "Treatment", "Status"};
        tblModel = new DefaultTableModel(clm, 0);
        tblAppoint = new JTable(tblModel);
        tblAppoint.setRowHeight(35);
        tblAppoint.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblAppoint.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
        tblAppoint.getTableHeader().setBackground(lightBlue);
        
        srcApp = new JScrollPane(tblAppoint);
        srcApp.setBounds(30, 310, 1560, 530);
        pnlMain.add(srcApp);
        
        pnlBot = new JPanel();
        pnlBot.setLayout(null);
        pnlBot.setBounds(30, 860, 1560, 50);
        pnlBot.setBackground(Color.WHITE);
        pnlBot.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlMain.add(pnlBot);
        
        btnChangeStatus = new JButton("Change Status");
        btnChangeStatus.setBounds(20, 10, 150, 30);
        btnChangeStatus.setBackground(orange);
        btnChangeStatus.setForeground(Color.WHITE);
        btnChangeStatus.setFont(new Font("Calibri", Font.BOLD, 14));
        btnChangeStatus.setFocusPainted(false);
        btnChangeStatus.addActionListener(e -> changeStatus());
        pnlBot.add(btnChangeStatus);
        
        btnRev = new JButton("Remove");
        btnRev.setBounds(190, 10, 120, 30);
        btnRev.setBackground(darkBlue);
        btnRev.setForeground(Color.WHITE);
        btnRev.addActionListener(ee -> RemoveApp());
        pnlBot.add(btnRev);
        
        addSampData();
    }
    
    private JPanel createTab(String title, String value, Color color) {
       tabUpdate = new JPanel();
       tabUpdate.setLayout(null);
       tabUpdate.setBackground(color);
       
        lblTitle2 = new JLabel(title);
        lblTitle2.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTitle2.setForeground(Color.WHITE);
        lblTitle2.setBounds(20, 20, 250, 25);
        tabUpdate.add(lblTitle2);
        
       lblValue = new JLabel(value);
        lblValue.setFont(new Font("Calibri", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);
        lblValue.setBounds(20, 50, 200, 40);
        tabUpdate.add(lblValue);
        
        return tabUpdate;
    }
    
    private void addAppointment() {
        String patient = txtPatient.getText().trim();
        String doctor = txtDoc.getText().trim();
        String treatment = txtTreatment.getText().trim();

        if (patient.isEmpty() || doctor.isEmpty() || treatment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Patient, Doctor, and Treatment are required!");
            return;
        }

        doctor = "Dr. " + doctor;

        int row = tblAppoint.getSelectedRow();
            if (row >= 0) {
                tblModel.setValueAt(patient, row, 1);
                tblModel.setValueAt(doctor, row, 2);
                tblModel.setValueAt(treatment, row, 3);
                JOptionPane.showMessageDialog(this, "Appointment updated!");
            } else {
                String patientID = "AP-" + (++PNum);
                tblModel.addRow(new Object[]{patientID, patient, doctor, treatment, "Pending"});
                JOptionPane.showMessageDialog(this, "Appointment added!");
            }

        txtPatient.setText("");
        txtDoc.setText("");
        txtTreatment.setText("");
        updateSummary();
    }
    
    private void editAppointment() {
        int row = tblAppoint.getSelectedRow();
        if (row >= 0) {
            txtPatient.setText(tblModel.getValueAt(row, 1).toString());
            
            String doctor = tblModel.getValueAt(row, 2).toString();
            if (doctor.startsWith("Dr. ")) {
                doctor = doctor.substring(4);
            }
            
            txtDoc.setText(doctor);
            txtTreatment.setText(tblModel.getValueAt(row, 3).toString());

            String status = tblModel.getValueAt(row, 4).toString();
            JOptionPane.showMessageDialog(this, 
                "Edit the details and click 'Add Appointment' to save changes.\nCurrent Status: " + status);
        } else {
            JOptionPane.showMessageDialog(this, "Select an appointment to edit!");
        }
    }

    
    private void RemoveApp() {
        int row = tblAppoint.getSelectedRow();
        if (row >= 0) {
            tblModel.removeRow(row);
            updateSummary();
        }
    }
    
    private void changeStatus() {
        int row = tblAppoint.getSelectedRow();
        if (row >= 0) {
            String currentStatus = tblModel.getValueAt(row, 4).toString();
            String[] options = {"Pending", "Admitted", "Complete", "Urgent"};

            String newStatus = (String) JOptionPane.showInputDialog(this,"Change appointment status:","Update Status",
                JOptionPane.PLAIN_MESSAGE,null,options,currentStatus);

            if (newStatus != null) {
                tblModel.setValueAt(newStatus, row, 4);
                updateSummary();
                JOptionPane.showMessageDialog(this, "Status updated to " + newStatus);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select an appointment to change status!");
        }
    }
    
    private void updateSummary() {
        int total = tblModel.getRowCount();
        int urgent = 0, pending = 0, admitted = 0, completed = 0;

        for (int i = 0; i < total; i++) {
            String status = tblModel.getValueAt(i, 4).toString();
            if (status.equals("Pending")) pending++;
            if (status.equals("Admitted")) admitted++;
            if (status.equals("Urgent")) urgent++;
            if (status.equals("Complete")) completed++;
        }

        lblTPatient.setText(String.valueOf(total));
        lblPAppointments.setText(String.valueOf(pending));
        lblAdmitted.setText(String.valueOf(admitted));
        lblUCases.setText(String.valueOf(urgent));
        lblCompleted.setText(String.valueOf(completed));
    }
    
    private void addSampData() {
        tblModel.addRow(new Object[]{"AP-10001", "Maria Santos", "Dr. Reyes", "Cardiac", "Pending"});
        tblModel.addRow(new Object[]{"AP-10002", "Daniel Cruz", "Dr. Villanueva", "Orthopedia", "Admitted"});
        tblModel.addRow(new Object[]{"AP-10003", "Angela Ramirez", "Dr. Delgado", "Diabetes", "Urgent"});
        tblModel.addRow(new Object[]{"AP-10004", "Roberto Garcia", "Dr. Mendoza", "Dental", "Complete"});
        tblModel.addRow(new Object[]{"AP-10005", "Melvin Mallon", "Dr. Santiago", "General", "Pending"});
        tblModel.addRow(new Object[]{"AP-10006", "Joshua Garcia", "Dr. Santiago", "General", "Pending"});

        updateSummary();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
