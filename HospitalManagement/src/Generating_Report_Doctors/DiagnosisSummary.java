package Generating_Report_Doctors;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;

public class DiagnosisSummary extends JPanel implements ActionListener {

    private JPanel pnlMain;
    private JLabel lblLogo, lblHospital, lblAddress, lblContact, lblRefNo, lblDate,
            lblPName, lblAge, lblGender, lblDiagnosis, lblSymptoms, lblTreatment, lblFollowUp, 
            lblFooter, lblStatus, lblDiagnosisValue, lblSymptomsValue, lblTreatmentValue, lblFollowUpValue,
            lblApprovedBy;
    private JPanel lineTop, lineFooter, pnlPatient, pnlDiagnosisDetails, pnlApprove;
    private Image imgLG;
    private ImageIcon imgLogo;
    private JButton btnSave, btnCopy, btnEdit, btnApprove, btnNewReport;
    private String patientName = "";
    private String age = "";
    private String gender = "";
    private String diagnosis = "";
    private String symptoms = "";
    private String treatment = "";
    private String followUp = "";
    private String status = "Pending";
    private boolean isApproved = false;
    private String approvedByName = "";
    private String approvedByRole = "";

    public DiagnosisSummary() {
        setLayout(null);
        setBounds(0, 0, 1060, 750);
        setBackground(Color.WHITE);

        loadBlankData();

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

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(710, 25, 100, 30);
        btnEdit.setBackground(darkBlue);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.addActionListener(this);
        pnlMain.add(btnEdit);
        
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

        lblRefNo = new JLabel("Ref No.: DX-2026-001");
        lblRefNo.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblRefNo.setBounds(740, 70, 200, 20);
        pnlMain.add(lblRefNo);

        lblDate = new JLabel("Date: " + java.time.LocalDate.now());
        lblDate.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblDate.setBounds(740, 90, 200, 20);
        pnlMain.add(lblDate);
        
        lblStatus = new JLabel("Status: " + status);
        lblStatus.setFont(new Font("Calibri", Font.BOLD, 14));
        lblStatus.setForeground(orange);
        lblStatus.setBounds(740, 110, 200, 20);
        pnlMain.add(lblStatus);

        lineTop = new JPanel();
        lineTop.setBounds(30, 130, 940, 2);
        lineTop.setBackground(neutralGray);
        pnlMain.add(lineTop);

        pnlPatient = new JPanel();
        pnlPatient.setLayout(null);
        pnlPatient.setBounds(30, 150, 940, 100);
        pnlPatient.setBorder(BorderFactory.createTitledBorder("Patient Information"));
        pnlMain.add(pnlPatient);

        lblPName = new JLabel("Patient Name: " + (patientName.isEmpty() ? "________" : patientName));
        lblPName.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblPName.setBounds(25, 30, 300, 20);
        pnlPatient.add(lblPName);

        lblAge = new JLabel("Age: " + (age.isEmpty() ? "__" : age));
        lblAge.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblAge.setBounds(400, 30, 100, 20);
        pnlPatient.add(lblAge);

        lblGender = new JLabel("Gender: " + (gender.isEmpty() ? "____" : gender));
        lblGender.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblGender.setBounds(550, 30, 150, 20);
        pnlPatient.add(lblGender);

        pnlDiagnosisDetails = new JPanel();
        pnlDiagnosisDetails.setLayout(null);
        pnlDiagnosisDetails.setBounds(30, 270, 940, 200);
        pnlDiagnosisDetails.setBorder(BorderFactory.createTitledBorder("Diagnosis Details"));
        pnlMain.add(pnlDiagnosisDetails);

        lblDiagnosis = new JLabel("Primary Diagnosis:");
        lblDiagnosis.setFont(new Font("Calibri", Font.BOLD, 14));
        lblDiagnosis.setBounds(25, 30, 150, 20);
        pnlDiagnosisDetails.add(lblDiagnosis);
        
        lblDiagnosisValue = new JLabel(diagnosis.isEmpty() ? "________" : diagnosis);
        lblDiagnosisValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblDiagnosisValue.setBounds(180, 30, 500, 20);
        pnlDiagnosisDetails.add(lblDiagnosisValue);

        lblSymptoms = new JLabel("Symptoms:");
        lblSymptoms.setFont(new Font("Calibri", Font.BOLD, 14));
        lblSymptoms.setBounds(25, 60, 100, 20);
        pnlDiagnosisDetails.add(lblSymptoms);
        
        lblSymptomsValue = new JLabel(symptoms.isEmpty() ? "________" : symptoms);
        lblSymptomsValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblSymptomsValue.setBounds(180, 60, 600, 20);
        pnlDiagnosisDetails.add(lblSymptomsValue);

        lblTreatment = new JLabel("Treatment Plan:");
        lblTreatment.setFont(new Font("Calibri", Font.BOLD, 14));
        lblTreatment.setBounds(25, 90, 120, 20);
        pnlDiagnosisDetails.add(lblTreatment);
        
        lblTreatmentValue = new JLabel(treatment.isEmpty() ? "________" : treatment);
        lblTreatmentValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblTreatmentValue.setBounds(180, 90, 650, 20);
        pnlDiagnosisDetails.add(lblTreatmentValue);

        lblFollowUp = new JLabel("Follow-up Date:");
        lblFollowUp.setFont(new Font("Calibri", Font.BOLD, 14));
        lblFollowUp.setBounds(25, 120, 120, 20);
        pnlDiagnosisDetails.add(lblFollowUp);
        
        lblFollowUpValue = new JLabel(followUp.isEmpty() ? "________" : followUp);
        lblFollowUpValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblFollowUpValue.setBounds(180, 120, 200, 20);
        pnlDiagnosisDetails.add(lblFollowUpValue);

        pnlApprove = new JPanel();
        pnlApprove.setLayout(null);
        pnlApprove.setBounds(30, 500, 940, 80);
        pnlApprove.setBackground(Color.WHITE);
        pnlMain.add(pnlApprove);
        
        btnApprove = new JButton("APPROVE & SIGN");
        btnApprove.setBounds(370, 15, 200, 45);
        btnApprove.setBackground(Green);
        btnApprove.setForeground(Color.WHITE);
        btnApprove.addActionListener(this);
        pnlApprove.add(btnApprove);

        lineFooter = new JPanel();
        lineFooter.setBounds(30, 600, 940, 2);
        lineFooter.setBackground(neutralGray);
        pnlMain.add(lineFooter);

        lblApprovedBy = new JLabel("");
        lblApprovedBy.setFont(new Font("Calibri", Font.BOLD, 14));
        lblApprovedBy.setForeground(Green);
        lblApprovedBy.setBounds(60, 620, 500, 25);
        pnlMain.add(lblApprovedBy);

        lblFooter = new JLabel("Diagnosed by: ____________________");
        lblFooter.setFont(new Font("Calibri", Font.ITALIC, 14));
        lblFooter.setBounds(60, 650, 300, 20);
        pnlMain.add(lblFooter);

        updateApproveButtonState();
    }

    private void loadBlankData() {
        patientName = "";
        age = "";
        gender = "";
        diagnosis = "";
        symptoms = "";
        treatment = "";
        followUp = "";
        status = "Pending";
        isApproved = false;
        approvedByName = "";
        approvedByRole = "";
    }

    private void refreshDisplay() {
        lblPName.setText("Patient Name: " + (patientName.isEmpty() ? "________" : patientName));
        lblAge.setText("Age: " + (age.isEmpty() ? "__" : age));
        lblGender.setText("Gender: " + (gender.isEmpty() ? "____" : gender));
        lblDiagnosisValue.setText(diagnosis.isEmpty() ? "________" : diagnosis);
        lblSymptomsValue.setText(symptoms.isEmpty() ? "________" : symptoms);
        lblTreatmentValue.setText(treatment.isEmpty() ? "________" : treatment);
        lblFollowUpValue.setText(followUp.isEmpty() ? "________" : followUp);
        updateApproveButtonState();
    }

    private String getMissingFields() {
        StringBuilder missing = new StringBuilder();
        if (patientName.isEmpty()) missing.append("- Patient Name\n");
        if (age.isEmpty()) missing.append("- Age\n");
        if (gender.isEmpty()) missing.append("- Gender\n");
        if (diagnosis.isEmpty()) missing.append("- Diagnosis\n");
        if (symptoms.isEmpty()) missing.append("- Symptoms\n");
        if (treatment.isEmpty()) missing.append("- Treatment Plan\n");
        if (followUp.isEmpty()) missing.append("- Follow-up Date\n");
        return missing.toString();
    }

    private boolean isReportComplete() {
        if (patientName.isEmpty() || age.isEmpty() || gender.isEmpty() || 
            diagnosis.isEmpty() || symptoms.isEmpty() || treatment.isEmpty() || followUp.isEmpty()) {
            return false;
        }
        return true;
    }

    private void saveReport() {
        if (isReportComplete()) {
            status = "Saved";
            lblStatus.setText("Status: Saved");
            lblStatus.setForeground(Green);
            JOptionPane.showMessageDialog(this, "✓ Diagnosis Summary saved successfully!", "Save Complete", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "❌ Cannot save report!\n\nMissing required fields:\n" + getMissingFields(), "Incomplete Report", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void copyReport() {
        String data = "=== ETRIAGE HOSPITAL DIAGNOSIS SUMMARY ===\n\n" +
            "Patient Name: " + (patientName.isEmpty() ? "[EMPTY]" : patientName) + "\n" +
            "Age: " + (age.isEmpty() ? "[EMPTY]" : age) + "\n" +
            "Gender: " + (gender.isEmpty() ? "[EMPTY]" : gender) + "\n\n" +
            "Primary Diagnosis: " + (diagnosis.isEmpty() ? "[EMPTY]" : diagnosis) + "\n" +
            "Symptoms: " + (symptoms.isEmpty() ? "[EMPTY]" : symptoms) + "\n" +
            "Treatment Plan: " + (treatment.isEmpty() ? "[EMPTY]" : treatment) + "\n" +
            "Follow-up Date: " + (followUp.isEmpty() ? "[EMPTY]" : followUp) + "\n\n" +
            "Status: " + status + "\n" +
            "Approved: " + (isApproved ? "YES - " + approvedByName + " (" + approvedByRole + ")" : "NOT APPROVED");
        
        StringSelection ss = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        JOptionPane.showMessageDialog(this, "Report copied to clipboard!", "Copy Complete", JOptionPane.INFORMATION_MESSAGE);
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

    private void showEditDialog() {
        JTextField txtPatientName = new JTextField(patientName, 20);
        JTextField txtAge = new JTextField(age, 10);
        JComboBox<String> cmbGender = new JComboBox<>(new String[]{"", "Male", "Female", "Other"});
        if (!gender.isEmpty()) cmbGender.setSelectedItem(gender);
        JTextField txtDiagnosis = new JTextField(diagnosis, 30);
        JTextField txtSymptoms = new JTextField(symptoms, 40);
        JTextField txtTreatment = new JTextField(treatment, 50);
        JTextField txtFollowUp = new JTextField(followUp, 20);
        
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.add(new JLabel("Patient Name:*")); panel.add(txtPatientName);
        panel.add(new JLabel("Age:*")); panel.add(txtAge);
        panel.add(new JLabel("Gender:*")); panel.add(cmbGender);
        panel.add(new JLabel("Diagnosis:*")); panel.add(txtDiagnosis);
        panel.add(new JLabel("Symptoms:*")); panel.add(txtSymptoms);
        panel.add(new JLabel("Treatment Plan:*")); panel.add(txtTreatment);
        panel.add(new JLabel("Follow-up Date:*")); panel.add(txtFollowUp);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Diagnosis Summary", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String newPatientName = txtPatientName.getText().trim();
            String newAge = txtAge.getText().trim();
            String newGender = (String) cmbGender.getSelectedItem();
            String newDiagnosis = txtDiagnosis.getText().trim();
            String newSymptoms = txtSymptoms.getText().trim();
            String newTreatment = txtTreatment.getText().trim();
            String newFollowUp = txtFollowUp.getText().trim();
            
            if (newPatientName.isEmpty() || newAge.isEmpty() || newGender == null || newGender.isEmpty() ||
                newDiagnosis.isEmpty() || newSymptoms.isEmpty() || newTreatment.isEmpty() || newFollowUp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields (*)", "Incomplete Data", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            patientName = newPatientName;
            age = newAge;
            gender = newGender;
            diagnosis = newDiagnosis;
            symptoms = newSymptoms;
            treatment = newTreatment;
            followUp = newFollowUp;
            
            refreshDisplay();
            isApproved = false;
            approvedByName = "";
            approvedByRole = "";
            lblApprovedBy.setText("");
            status = "Pending";
            lblStatus.setText("Status: Pending");
            lblStatus.setForeground(orange);
            updateApproveButtonState();
            
            JOptionPane.showMessageDialog(this, "Diagnosis Summary updated successfully!", "Update Complete", JOptionPane.INFORMATION_MESSAGE);
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
            loadBlankData();
            refreshDisplay();
            JOptionPane.showMessageDialog(this, "New blank report created. Click 'Edit' to fill in information.", "New Report", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean isApproved() { return isApproved; }
    public String getApprovedBy() { return isApproved ? approvedByName + " (" + approvedByRole + ")" : ""; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewReport) newReport();
        else if (e.getSource() == btnEdit) showEditDialog();
        else if (e.getSource() == btnSave) saveReport();
        else if (e.getSource() == btnCopy) copyReport();
        else if (e.getSource() == btnApprove) approveDocument();
    }
}