package Generating_Reports_Admin;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;

public class PrescriptionReport extends JPanel implements ActionListener {
    
    private JPanel pnlMain;
    private JLabel lblLogo, lblHospital, lblAddress, lblContact,
            lblPatientName, lblPatientNameValue, lblPatientAddress, lblPatientAddressValue,
            lblAge, lblAgeValue, lblGender, lblGenderValue, lblDate, lblDateValue, 
            lblDoctor, lblDoctorValue, lblDiagnosis, lblDiagnosisValue, 
            lblMed1, lblForm1, lblQty1, lblSig1, lblRefill1,
            lblMed2, lblForm2, lblQty2, lblSig2, lblRefill2,
            lblMed3, lblForm3, lblQty3, lblSig3, lblRefill3,
            lblSignature, lblValidity, lblApprovedBy, lblRxStatus, lblRxStatusValue;
    private JPanel lineTop, lineMeds, lineDA, lineFooter, pnlApprove;
    private JScrollPane scrPrescription;
    private ImageIcon imgLogo;
    private Image imgLG;
    private JButton btnEdit, btnApprove, btnNewReport, btnSave, btnCopy;
    private boolean isApproved = false;
    private String approvedByName = "";
    private String approvedByRole = "";
    private String rxStatus = "Pending";
    
    private String patientName, patientAddress, age, gender, date, doctor, diagnosis;
    private String med1, form1, qty1, sig1, refill1;
    private String med2, form2, qty2, sig2, refill2;
    private String med3, form3, qty3, sig3, refill3;
    
    public PrescriptionReport() {
        setLayout(null);
        setBounds(0, 0, 1060, 750);
        setBackground(Color.WHITE);
        
        loadBlankData();
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setPreferredSize(new Dimension(1010, 900));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        scrPrescription = new JScrollPane(pnlMain);
        scrPrescription.setBounds(0, 0, 1060, 700);
        scrPrescription.setBorder(BorderFactory.createEmptyBorder());
        scrPrescription.setViewportBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrPrescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrPrescription.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrPrescription);

        imgLogo = new ImageIcon(getClass().getResource("/resources/eTriage.DOCUMENT.LOGO.png"));
        imgLG = imgLogo.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(imgLG));
        lblLogo.setBounds(30, 25, 80, 80);
        pnlMain.add(lblLogo);

        lblHospital = new JLabel("ETRIAGE HOSPITAL");
        lblHospital.setFont(new Font("Calibri", Font.BOLD, 22));
        lblHospital.setForeground(darkBlue);
        lblHospital.setBounds(130, 30, 350, 25);
        pnlMain.add(lblHospital);

        lblAddress = new JLabel("123 Health St., Wellness City, Medical County");
        lblAddress.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblAddress.setBounds(130, 55, 400, 18);
        pnlMain.add(lblAddress);

        lblContact = new JLabel("Tel No.: (02) 8123-4567");
        lblContact.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblContact.setBounds(130, 73, 300, 18);
        pnlMain.add(lblContact);

        btnNewReport = new JButton("New Report");
        btnNewReport.setBounds(520, 30, 110, 35);
        btnNewReport.setBackground(TealGreen);
        btnNewReport.setForeground(Color.WHITE);
        btnNewReport.setFont(new Font("Calibri", Font.BOLD, 12));
        btnNewReport.addActionListener(this);
        pnlMain.add(btnNewReport);

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(640, 30, 90, 35);
        btnEdit.setBackground(darkBlue);
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Calibri", Font.BOLD, 12));
        btnEdit.addActionListener(this);
        pnlMain.add(btnEdit);
        
        btnSave = new JButton("Save");
        btnSave.setBounds(740, 30, 90, 35);
        btnSave.setBackground(Green);
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Calibri", Font.BOLD, 12));
        btnSave.addActionListener(this);
        pnlMain.add(btnSave);
        
        btnCopy = new JButton("Copy");
        btnCopy.setBounds(840, 30, 90, 35);
        btnCopy.setBackground(mediumBlue);
        btnCopy.setForeground(Color.WHITE);
        btnCopy.setFont(new Font("Calibri", Font.BOLD, 12));
        btnCopy.addActionListener(this);
        pnlMain.add(btnCopy);

        lineTop = new JPanel();
        lineTop.setBounds(30, 120, 960, 2);
        lineTop.setBackground(neutralGray);
        pnlMain.add(lineTop);

        lblPatientName = new JLabel("Patient Name:");
        lblPatientName.setFont(new Font("Calibri", Font.BOLD, 14));
        lblPatientName.setBounds(30, 145, 110, 25);
        pnlMain.add(lblPatientName);

        lblPatientNameValue = new JLabel(patientName.isEmpty() ? "________" : patientName);
        lblPatientNameValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblPatientNameValue.setBounds(145, 145, 250, 25);
        pnlMain.add(lblPatientNameValue);

        lblPatientAddress = new JLabel("Address:");
        lblPatientAddress.setFont(new Font("Calibri", Font.BOLD, 14));
        lblPatientAddress.setBounds(30, 175, 70, 25);
        pnlMain.add(lblPatientAddress);

        lblPatientAddressValue = new JLabel(patientAddress.isEmpty() ? "________" : patientAddress);
        lblPatientAddressValue.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblPatientAddressValue.setBounds(105, 175, 400, 25);
        pnlMain.add(lblPatientAddressValue);

        lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Calibri", Font.BOLD, 14));
        lblAge.setBounds(550, 145, 40, 25);
        pnlMain.add(lblAge);

        lblAgeValue = new JLabel(age.isEmpty() ? "__" : age);
        lblAgeValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblAgeValue.setBounds(595, 145, 50, 25);
        pnlMain.add(lblAgeValue);

        lblGender = new JLabel("Gender:");
        lblGender.setFont(new Font("Calibri", Font.BOLD, 14));
        lblGender.setBounds(660, 145, 60, 25);
        pnlMain.add(lblGender);

        lblGenderValue = new JLabel(gender.isEmpty() ? "____" : gender);
        lblGenderValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblGenderValue.setBounds(725, 145, 80, 25);
        pnlMain.add(lblGenderValue);

        lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Calibri", Font.BOLD, 14));
        lblDate.setBounds(820, 145, 45, 25);
        pnlMain.add(lblDate);

        lblDateValue = new JLabel(date.isEmpty() ? "________" : date);
        lblDateValue.setFont(new Font("Calibri", Font.PLAIN, 12));
        lblDateValue.setBounds(870, 145, 120, 25);
        pnlMain.add(lblDateValue);
        
        lblRxStatus = new JLabel("Rx Status:");
        lblRxStatus.setFont(new Font("Calibri", Font.BOLD, 14));
        lblRxStatus.setForeground(darkBlue);
        lblRxStatus.setBounds(30, 210, 80, 25);
        pnlMain.add(lblRxStatus);
        
        lblRxStatusValue = new JLabel(rxStatus);
        lblRxStatusValue.setFont(new Font("Calibri", Font.BOLD, 14));
        lblRxStatusValue.setBounds(115, 210, 120, 25);
        updateRxStatusColor();
        pnlMain.add(lblRxStatusValue);

        lblDoctor = new JLabel("Prescribing Physician:");
        lblDoctor.setFont(new Font("Calibri", Font.BOLD, 14));
        lblDoctor.setBounds(30, 245, 155, 25);
        pnlMain.add(lblDoctor);

        lblDoctorValue = new JLabel(doctor.isEmpty() ? "________" : doctor);
        lblDoctorValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblDoctorValue.setBounds(190, 245, 250, 25);
        pnlMain.add(lblDoctorValue);

        lblDiagnosis = new JLabel("Clinical Diagnosis:");
        lblDiagnosis.setFont(new Font("Calibri", Font.BOLD, 14));
        lblDiagnosis.setBounds(30, 280, 125, 25);
        pnlMain.add(lblDiagnosis);

        lblDiagnosisValue = new JLabel(diagnosis.isEmpty() ? "________" : diagnosis);
        lblDiagnosisValue.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblDiagnosisValue.setBounds(160, 280, 300, 25);
        pnlMain.add(lblDiagnosisValue);

        lineMeds = new JPanel();
        lineMeds.setBounds(30, 320, 960, 2);
        lineMeds.setBackground(neutralGray);
        pnlMain.add(lineMeds);

        lblMed1 = new JLabel("1. " + (med1.isEmpty() ? "________" : med1));
        lblMed1.setFont(new Font("Calibri", Font.BOLD, 13));
        lblMed1.setBounds(30, 340, 200, 25);
        pnlMain.add(lblMed1);

        lblForm1 = new JLabel(form1.isEmpty() ? "________" : form1);
        lblForm1.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblForm1.setBounds(50, 360, 220, 20);
        pnlMain.add(lblForm1);

        lblQty1 = new JLabel("Disp: " + (qty1.isEmpty() ? "_" : qty1));
        lblQty1.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblQty1.setBounds(300, 340, 120, 20);
        pnlMain.add(lblQty1);

        lblSig1 = new JLabel("Sig: " + (sig1.isEmpty() ? "________" : sig1));
        lblSig1.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblSig1.setBounds(50, 380, 500, 20);
        pnlMain.add(lblSig1);

        lblRefill1 = new JLabel("Refill: " + (refill1.isEmpty() ? "_" : refill1));
        lblRefill1.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblRefill1.setBounds(300, 360, 100, 20);
        pnlMain.add(lblRefill1);

        lblMed2 = new JLabel("2. " + (med2.isEmpty() ? "________" : med2));
        lblMed2.setFont(new Font("Calibri", Font.BOLD, 13));
        lblMed2.setBounds(30, 420, 200, 25);
        pnlMain.add(lblMed2);

        lblForm2 = new JLabel(form2.isEmpty() ? "________" : form2);
        lblForm2.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblForm2.setBounds(50, 440, 150, 20);
        pnlMain.add(lblForm2);

        lblQty2 = new JLabel("Disp: " + (qty2.isEmpty() ? "_" : qty2));
        lblQty2.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblQty2.setBounds(300, 420, 120, 20);
        pnlMain.add(lblQty2);

        lblSig2 = new JLabel("Sig: " + (sig2.isEmpty() ? "________" : sig2));
        lblSig2.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblSig2.setBounds(50, 460, 400, 20);
        pnlMain.add(lblSig2);

        lblRefill2 = new JLabel("Refill: " + (refill2.isEmpty() ? "_" : refill2));
        lblRefill2.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblRefill2.setBounds(300, 440, 100, 20);
        pnlMain.add(lblRefill2);

        lblMed3 = new JLabel("3. " + (med3.isEmpty() ? "________" : med3));
        lblMed3.setFont(new Font("Calibri", Font.BOLD, 13));
        lblMed3.setBounds(30, 500, 200, 25);
        pnlMain.add(lblMed3);

        lblForm3 = new JLabel(form3.isEmpty() ? "________" : form3);
        lblForm3.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblForm3.setBounds(50, 520, 200, 20);
        pnlMain.add(lblForm3);

        lblQty3 = new JLabel("Disp: " + (qty3.isEmpty() ? "_" : qty3));
        lblQty3.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblQty3.setBounds(300, 500, 120, 20);
        pnlMain.add(lblQty3);

        lblSig3 = new JLabel("Sig: " + (sig3.isEmpty() ? "________" : sig3));
        lblSig3.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblSig3.setBounds(50, 540, 300, 20);
        pnlMain.add(lblSig3);

        lblRefill3 = new JLabel("Refill: " + (refill3.isEmpty() ? "_" : refill3));
        lblRefill3.setFont(new Font("Calibri", Font.PLAIN, 11));
        lblRefill3.setBounds(300, 520, 100, 20);
        pnlMain.add(lblRefill3);

        lineDA = new JPanel();
        lineDA.setBounds(30, 580, 960, 2);
        lineDA.setBackground(neutralGray);
        pnlMain.add(lineDA);
        
        pnlApprove = new JPanel();
        pnlApprove.setLayout(null);
        pnlApprove.setBounds(30, 600, 960, 80);
        pnlApprove.setBackground(Color.WHITE);
        pnlMain.add(pnlApprove);
        
        btnApprove = new JButton("APPROVE & SIGN");
        btnApprove.setBounds(380, 15, 200, 45);
        btnApprove.setBackground(Green);
        btnApprove.setForeground(Color.WHITE);
        btnApprove.setFont(new Font("Calibri", Font.BOLD, 16));
        btnApprove.addActionListener(this);
        pnlApprove.add(btnApprove);
        
        lineFooter = new JPanel();
        lineFooter.setBounds(30, 700, 960, 2);
        lineFooter.setBackground(neutralGray);
        pnlMain.add(lineFooter);
        
        lblApprovedBy = new JLabel("");
        lblApprovedBy.setFont(new Font("Calibri", Font.BOLD, 14));
        lblApprovedBy.setForeground(Green);
        lblApprovedBy.setBounds(60, 720, 500, 25);
        pnlMain.add(lblApprovedBy);
        
        lblSignature = new JLabel("Physician Signature: ____________________");
        lblSignature.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblSignature.setBounds(60, 750, 300, 25);
        pnlMain.add(lblSignature);
        
        lblValidity = new JLabel("This prescription is valid for 30 days from date issued.");
        lblValidity.setFont(new Font("Calibri", Font.ITALIC, 11));
        lblValidity.setForeground(Color.GRAY);
        lblValidity.setBounds(60, 780, 350, 20);
        pnlMain.add(lblValidity);
        
        updateApproveButtonState();
    }
    
    private void updateRxStatusColor() {
        switch (rxStatus) {
            case "Active": lblRxStatusValue.setForeground(Green); break;
            case "Pending": lblRxStatusValue.setForeground(orange); break;
            case "Expired": lblRxStatusValue.setForeground(LightRed); break;
            case "Completed": lblRxStatusValue.setForeground(darkBlue); break;
            default: lblRxStatusValue.setForeground(Color.BLACK);
        }
        lblRxStatusValue.setText(rxStatus);
    }
    
    private void loadBlankData() {
        patientName = ""; patientAddress = ""; age = ""; gender = ""; date = "";
        doctor = ""; diagnosis = "";
        med1 = ""; form1 = ""; qty1 = ""; sig1 = ""; refill1 = "";
        med2 = ""; form2 = ""; qty2 = ""; sig2 = ""; refill2 = "";
        med3 = ""; form3 = ""; qty3 = ""; sig3 = ""; refill3 = "";
        isApproved = false; approvedByName = ""; approvedByRole = "";
        rxStatus = "Pending";
    }
    
    private void refreshDisplay() {
        lblPatientNameValue.setText(patientName.isEmpty() ? "________" : patientName);
        lblPatientAddressValue.setText(patientAddress.isEmpty() ? "________" : patientAddress);
        lblAgeValue.setText(age.isEmpty() ? "__" : age);
        lblGenderValue.setText(gender.isEmpty() ? "____" : gender);
        lblDateValue.setText(date.isEmpty() ? "________" : date);
        lblDoctorValue.setText(doctor.isEmpty() ? "________" : doctor);
        lblDiagnosisValue.setText(diagnosis.isEmpty() ? "________" : diagnosis);
        lblMed1.setText("1. " + (med1.isEmpty() ? "________" : med1));
        lblForm1.setText(form1.isEmpty() ? "________" : form1);
        lblQty1.setText("Disp: " + (qty1.isEmpty() ? "_" : qty1));
        lblSig1.setText("Sig: " + (sig1.isEmpty() ? "________" : sig1));
        lblRefill1.setText("Refill: " + (refill1.isEmpty() ? "_" : refill1));
        lblMed2.setText("2. " + (med2.isEmpty() ? "________" : med2));
        lblForm2.setText(form2.isEmpty() ? "________" : form2);
        lblQty2.setText("Disp: " + (qty2.isEmpty() ? "_" : qty2));
        lblSig2.setText("Sig: " + (sig2.isEmpty() ? "________" : sig2));
        lblRefill2.setText("Refill: " + (refill2.isEmpty() ? "_" : refill2));
        lblMed3.setText("3. " + (med3.isEmpty() ? "________" : med3));
        lblForm3.setText(form3.isEmpty() ? "________" : form3);
        lblQty3.setText("Disp: " + (qty3.isEmpty() ? "_" : qty3));
        lblSig3.setText("Sig: " + (sig3.isEmpty() ? "________" : sig3));
        lblRefill3.setText("Refill: " + (refill3.isEmpty() ? "_" : refill3));
        updateRxStatusColor();
        updateApproveButtonState();
    }
    
    private String getMissingFields() {
        StringBuilder missing = new StringBuilder();
        if (patientName.isEmpty()) missing.append("- Patient Name\n");
        if (patientAddress.isEmpty()) missing.append("- Address\n");
        if (age.isEmpty()) missing.append("- Age\n");
        if (gender.isEmpty()) missing.append("- Gender\n");
        if (date.isEmpty()) missing.append("- Date\n");
        if (doctor.isEmpty()) missing.append("- Doctor\n");
        if (diagnosis.isEmpty()) missing.append("- Diagnosis\n");
        if (med1.isEmpty() && med2.isEmpty() && med3.isEmpty()) missing.append("- At least one medication\n");
        return missing.toString();
    }
    
    private boolean isReportComplete() {
        if (patientName.isEmpty() || patientAddress.isEmpty() || age.isEmpty() || 
            gender.isEmpty() || date.isEmpty() || doctor.isEmpty() || diagnosis.isEmpty()) {
            return false;
        }
        if (med1.isEmpty() && med2.isEmpty() && med3.isEmpty()) return false;
        return true;
    }
    
    private void saveReport() {
        if (isReportComplete()) {
            if (rxStatus.equals("Pending")) {
                rxStatus = "Active";
                updateRxStatusColor();
            }
            JOptionPane.showMessageDialog(this, "✓ Report saved successfully!\n\nRx Status: " + rxStatus, "Save Complete", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "❌ Cannot save report!\n\nMissing required fields:\n" + getMissingFields(), "Incomplete Report", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void copyReport() {
        String reportData = "=== ETRIAGE HOSPITAL PRESCRIPTION REPORT ===\n\n" +
            "Patient Name: " + (patientName.isEmpty() ? "[EMPTY]" : patientName) + "\n" +
            "Address: " + (patientAddress.isEmpty() ? "[EMPTY]" : patientAddress) + "\n" +
            "Age: " + (age.isEmpty() ? "[EMPTY]" : age) + "\n" +
            "Gender: " + (gender.isEmpty() ? "[EMPTY]" : gender) + "\n" +
            "Date: " + (date.isEmpty() ? "[EMPTY]" : date) + "\n" +
            "Doctor: " + (doctor.isEmpty() ? "[EMPTY]" : doctor) + "\n" +
            "Diagnosis: " + (diagnosis.isEmpty() ? "[EMPTY]" : diagnosis) + "\n" +
            "Rx Status: " + rxStatus + "\n\n=== MEDICATIONS ===\n" +
            "1. " + (med1.isEmpty() ? "[EMPTY]" : med1) + " - " + (form1.isEmpty() ? "[EMPTY]" : form1) + "\n   Qty: " + (qty1.isEmpty() ? "[EMPTY]" : qty1) + "\n   Sig: " + (sig1.isEmpty() ? "[EMPTY]" : sig1) + "\n   Refill: " + (refill1.isEmpty() ? "[EMPTY]" : refill1) + "\n\n" +
            "2. " + (med2.isEmpty() ? "[EMPTY]" : med2) + " - " + (form2.isEmpty() ? "[EMPTY]" : form2) + "\n   Qty: " + (qty2.isEmpty() ? "[EMPTY]" : qty2) + "\n   Sig: " + (sig2.isEmpty() ? "[EMPTY]" : sig2) + "\n   Refill: " + (refill2.isEmpty() ? "[EMPTY]" : refill2) + "\n\n" +
            "3. " + (med3.isEmpty() ? "[EMPTY]" : med3) + " - " + (form3.isEmpty() ? "[EMPTY]" : form3) + "\n   Qty: " + (qty3.isEmpty() ? "[EMPTY]" : qty3) + "\n   Sig: " + (sig3.isEmpty() ? "[EMPTY]" : sig3) + "\n   Refill: " + (refill3.isEmpty() ? "[EMPTY]" : refill3) + "\n\n=== APPROVAL ===\n" +
            "Approved: " + (isApproved ? "YES - " + approvedByName + " (" + approvedByRole + ")" : "NOT APPROVED");
        
        StringSelection stringSelection = new StringSelection(reportData);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        JOptionPane.showMessageDialog(this, "Report data copied to clipboard!\n\nYou can now paste (Ctrl+V) anywhere.", "Copy Complete", JOptionPane.INFORMATION_MESSAGE);
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
        JTextField txtPatientAddress = new JTextField(patientAddress, 20);
        JTextField txtAge = new JTextField(age, 10);
        JComboBox<String> cmbGender = new JComboBox<>(new String[]{"", "Male", "Female", "Other"});
        if (!gender.isEmpty()) cmbGender.setSelectedItem(gender);
        JTextField txtDate = new JTextField(date, 15);
        JTextField txtDoctor = new JTextField(doctor, 20);
        JTextField txtDiagnosis = new JTextField(diagnosis, 20);
        
        JTextField txtMed1 = new JTextField(med1, 20);
        JTextField txtForm1 = new JTextField(form1, 25);
        JTextField txtQty1 = new JTextField(qty1, 15);
        JTextField txtSig1 = new JTextField(sig1, 30);
        JTextField txtRefill1 = new JTextField(refill1, 10);
        
        JTextField txtMed2 = new JTextField(med2, 20);
        JTextField txtForm2 = new JTextField(form2, 25);
        JTextField txtQty2 = new JTextField(qty2, 15);
        JTextField txtSig2 = new JTextField(sig2, 30);
        JTextField txtRefill2 = new JTextField(refill2, 10);
        
        JTextField txtMed3 = new JTextField(med3, 20);
        JTextField txtForm3 = new JTextField(form3, 25);
        JTextField txtQty3 = new JTextField(qty3, 15);
        JTextField txtSig3 = new JTextField(sig3, 30);
        JTextField txtRefill3 = new JTextField(refill3, 10);
        
        JComboBox<String> cmbRxStatus = new JComboBox<>(new String[]{"Pending", "Active", "Completed", "Expired"});
        cmbRxStatus.setSelectedItem(rxStatus);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Patient Name:*"), gbc);
        gbc.gridx = 1; panel.add(txtPatientName, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Age:*"), gbc);
        gbc.gridx = 3; panel.add(txtAge, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Address:*"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; panel.add(txtPatientAddress, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Gender:*"), gbc);
        gbc.gridx = 1; panel.add(cmbGender, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Date:*"), gbc);
        gbc.gridx = 3; panel.add(txtDate, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Doctor:*"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; panel.add(txtDoctor, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 4; panel.add(new JLabel("Diagnosis:*"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; panel.add(txtDiagnosis, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 5; panel.add(new JLabel("Rx Status:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; panel.add(cmbRxStatus, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 4; panel.add(new JLabel("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"), gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 7; panel.add(new JLabel("Medication 1:"), gbc);
        gbc.gridx = 1; panel.add(txtMed1, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Form:"), gbc);
        gbc.gridx = 3; panel.add(txtForm1, gbc);
        
        gbc.gridx = 0; gbc.gridy = 8; panel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1; panel.add(txtQty1, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Refill:"), gbc);
        gbc.gridx = 3; panel.add(txtRefill1, gbc);
        
        gbc.gridx = 0; gbc.gridy = 9; panel.add(new JLabel("Instruction:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; panel.add(txtSig1, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 10; panel.add(new JLabel("Medication 2:"), gbc);
        gbc.gridx = 1; panel.add(txtMed2, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Form:"), gbc);
        gbc.gridx = 3; panel.add(txtForm2, gbc);
        
        gbc.gridx = 0; gbc.gridy = 11; panel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1; panel.add(txtQty2, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Refill:"), gbc);
        gbc.gridx = 3; panel.add(txtRefill2, gbc);
        
        gbc.gridx = 0; gbc.gridy = 12; panel.add(new JLabel("Instruction:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; panel.add(txtSig2, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 13; panel.add(new JLabel("Medication 3:"), gbc);
        gbc.gridx = 1; panel.add(txtMed3, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Form:"), gbc);
        gbc.gridx = 3; panel.add(txtForm3, gbc);
        
        gbc.gridx = 0; gbc.gridy = 14; panel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1; panel.add(txtQty3, gbc);
        gbc.gridx = 2; panel.add(new JLabel("Refill:"), gbc);
        gbc.gridx = 3; panel.add(txtRefill3, gbc);
        
        gbc.gridx = 0; gbc.gridy = 15; panel.add(new JLabel("Instruction:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; panel.add(txtSig3, gbc);
        
        JLabel requiredNote = new JLabel("* Required fields");
        requiredNote.setForeground(Color.RED);
        requiredNote.setFont(new Font("Calibri", Font.ITALIC, 11));
        gbc.gridx = 0; gbc.gridy = 16; gbc.gridwidth = 4; panel.add(requiredNote, gbc);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Prescription Report", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            patientName = txtPatientName.getText().trim();
            patientAddress = txtPatientAddress.getText().trim();
            age = txtAge.getText().trim();
            gender = (String) cmbGender.getSelectedItem();
            date = txtDate.getText().trim();
            doctor = txtDoctor.getText().trim();
            diagnosis = txtDiagnosis.getText().trim();
            med1 = txtMed1.getText().trim();
            form1 = txtForm1.getText().trim();
            qty1 = txtQty1.getText().trim();
            sig1 = txtSig1.getText().trim();
            refill1 = txtRefill1.getText().trim();
            med2 = txtMed2.getText().trim();
            form2 = txtForm2.getText().trim();
            qty2 = txtQty2.getText().trim();
            sig2 = txtSig2.getText().trim();
            refill2 = txtRefill2.getText().trim();
            med3 = txtMed3.getText().trim();
            form3 = txtForm3.getText().trim();
            qty3 = txtQty3.getText().trim();
            sig3 = txtSig3.getText().trim();
            refill3 = txtRefill3.getText().trim();
            rxStatus = (String) cmbRxStatus.getSelectedItem();
            
            refreshDisplay();
            isApproved = false;
            approvedByName = "";
            approvedByRole = "";
            lblApprovedBy.setText("");
            updateApproveButtonState();
            
            JOptionPane.showMessageDialog(this, "Report updated successfully!", "Update Complete", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void approveDocument() {
        if (!isReportComplete()) {
            JOptionPane.showMessageDialog(this, "Cannot approve! Please fill all required fields first.", "Incomplete Report", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JPanel approvePanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField txtName = new JTextField(15);
        JComboBox<String> cmbRole = new JComboBox<>(new String[]{"Admin", "Doctor", "Department Head"});
        
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