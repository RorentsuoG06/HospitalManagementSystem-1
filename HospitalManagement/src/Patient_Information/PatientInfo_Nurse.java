package Patient_Information;


import javax.swing.*;
import java.awt.*;


public class PatientInfo_Nurse extends JPanel {

    public PatientInfo_Nurse(){

        setLayout(null);
        setBounds(0, 0, 1620, 930);

        Font titleFont = new Font("Calibri", Font.BOLD, 18);
        Font bodyFont = new Font("Calibri", Font.PLAIN, 15);

        //page title
        JLabel lblPage = new JLabel("Patient Information");
        lblPage.setFont(new Font("Calibri", Font.BOLD, 28));
        lblPage.setForeground(new Color(57, 90, 127));
        lblPage.setBounds(30, 20, 400, 35);
        add(lblPage);

        JPanel titleLine = new JPanel();
        titleLine.setBounds(30, 52, 220, 3);
        titleLine.setBackground(new Color(57, 90, 127));
        add(titleLine);

       //patient profile card
        JPanel profileCard = new JPanel();
        profileCard.setLayout(null);
        profileCard.setBounds(30, 65, 1550, 140);
        profileCard.setBackground(Color.WHITE);
        profileCard.setBorder(BorderFactory.createLineBorder(new Color(208, 216, 232)));
        add(profileCard);

        //blue accent on card
        JPanel accent = new JPanel();
        accent.setBounds(0, 0, 6, 140);
        accent.setBackground(new Color(57, 90, 127));
        profileCard.add(accent);

        ImageIcon img = new ImageIcon(getClass().getResource("/resources/PATIENT.PHOTO.png"));
        Image imgScaled = img.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);

        JLabel pic = new JLabel(new ImageIcon(imgScaled));
        pic.setBounds(20, 15, 110, 110);
        profileCard.add(pic);

        
        JLabel name = new JLabel("Joshua Santos");
        name.setFont(new Font("Calibri", Font.BOLD, 22));
        name.setBounds(150, 15, 300, 30);
        profileCard.add(name);

        //status badge
        JPanel statusBadge = new JPanel();
        statusBadge.setBackground(new Color(255, 224, 224));
        statusBadge.setBounds(150, 52, 190, 26);
        statusBadge.setLayout(null);
        profileCard.add(statusBadge);

        JLabel status = new JLabel("Status: Observation");
        status.setForeground(Color.RED);
        status.setFont(new Font("Calibri", Font.BOLD, 14));
        status.setBounds(5, 3, 180, 20);
        statusBadge.add(status);

        JLabel info = new JLabel("ID: P-10021   |   Age: 29   |   Blood: O+");
        info.setFont(new Font("Calibri", Font.PLAIN, 15));
        info.setForeground(Color.LIGHT_GRAY);
        info.setBounds(150, 85, 400, 22);
        profileCard.add(info);

        //edit and notes buttons
        JButton edit = new JButton("Edit");
        edit.setBounds(1420, 30, 100, 35);
        edit.setBackground(new Color(57, 90, 127));
        edit.setForeground(Color.WHITE);
        edit.setFont(new Font("Calibri", Font.BOLD, 14));
        profileCard.add(edit);

        JButton notes = new JButton("Notes");
        notes.setBounds(1420, 75, 100, 35);
        notes.setBackground(new Color(163, 202, 233));
        notes.setForeground(Color.BLACK);
        notes.setFont(new Font("Calibri", Font.BOLD, 14));
        profileCard.add(notes);

        //details panel
        JPanel details = new JPanel();
        details.setLayout(null);
        details.setBounds(30, 225, 750, 220);
        details.setBackground(Color.WHITE);
        details.setBorder(BorderFactory.createLineBorder(new Color(208, 216, 232)));
        add(details);

        JLabel lblDetails = new JLabel("Patient Details");
        lblDetails.setFont(titleFont);
        lblDetails.setForeground(new Color(57, 90, 127));
        lblDetails.setBounds(20, 10, 200, 25);
        details.add(lblDetails);

        JPanel detailsLine = new JPanel();
        detailsLine.setBounds(20, 38, 710, 2);
        detailsLine.setBackground(new Color(163, 202, 233));
        details.add(detailsLine);

        JTextArea detailText = new JTextArea("Address: Binan, Laguna\n" + "Phone: +63 923 456 789");
        detailText.setFont(bodyFont);
        detailText.setBounds(20, 48, 700, 45);
        detailText.setEditable(false);
        detailText.setOpaque(false);
        details.add(detailText);

        //patient allergy
        JLabel lblAllergy = new JLabel("Allergies");
        lblAllergy.setFont(new Font("Calibri", Font.BOLD, 15));
        lblAllergy.setForeground(new Color(57, 90, 127));
        lblAllergy.setBounds(20, 100, 150, 22);
        details.add(lblAllergy);

        JTextArea allergyText = new JTextArea("- Penicillin\n- Dust Allergy");
        allergyText.setBounds(20, 125, 200, 55);
        allergyText.setEditable(false);
        allergyText.setOpaque(false);
        allergyText.setFont(bodyFont);
        details.add(allergyText);

        // patient conditions
        JLabel lblCondition = new JLabel("Conditions");
        lblCondition.setFont(new Font("Calibri", Font.BOLD, 15));
        lblCondition.setForeground(new Color(57, 90, 127));
        lblCondition.setBounds(250, 100, 150, 22);
        details.add(lblCondition);

        JTextArea conditionText = new JTextArea("- Diabetes\n- Hypertension");
        conditionText.setBounds(250, 125, 200, 55);
        conditionText.setEditable(false);
        conditionText.setOpaque(false);
        conditionText.setFont(bodyFont);
        details.add(conditionText);

        //patient medication
        JLabel lblMed = new JLabel("Medication Intake");
        lblMed.setFont(new Font("Calibri", Font.BOLD, 15));
        lblMed.setForeground(new Color(57, 90, 127));
        lblMed.setBounds(480, 100, 200, 22);
        details.add(lblMed);

        JTextArea medText = new JTextArea("- Metformin (Daily)\n- Ibuprofen (As needed)");
        medText.setBounds(480, 125, 230, 55);
        medText.setEditable(false);
        medText.setOpaque(false);
        medText.setFont(bodyFont);
        details.add(medText);

        // doctor notes
        JPanel doctorNotes = new JPanel();
        doctorNotes.setLayout(null);
        doctorNotes.setBounds(30, 465, 750, 240);
        doctorNotes.setBackground(Color.WHITE);
        doctorNotes.setBorder(BorderFactory.createLineBorder(new Color(208, 216, 232)));
        add(doctorNotes);

        JLabel lblNotes = new JLabel("Doctor's Notes");
        lblNotes.setFont(titleFont);
        lblNotes.setForeground(new Color(57, 90, 127));
        lblNotes.setBounds(20, 10, 200, 25);
        doctorNotes.add(lblNotes);

        JPanel notesLine = new JPanel();
        notesLine.setBounds(20, 38, 710, 2);
        notesLine.setBackground(new Color(163, 202, 233));
        doctorNotes.add(notesLine);

        JTextArea notesText = new JTextArea("Patient recovering well post consultation.\n" +"Blood pressure stabilizing.\n\n" +"Recommendation:\nContinue medication and follow-up next week.");
        notesText.setFont(bodyFont);
        notesText.setBounds(20, 48, 700, 170);
        notesText.setEditable(false);
        notesText.setOpaque(false);
        notesText.setLineWrap(true);
        notesText.setWrapStyleWord(true);
        doctorNotes.add(notesText);

        
        // patient vitals
        JPanel vitals = new JPanel();
        vitals.setLayout(null);
        vitals.setBounds(820, 225, 750, 220);
        vitals.setBackground(Color.WHITE);
        vitals.setBorder(BorderFactory.createLineBorder(new Color(163, 202, 233), 2));
        add(vitals);

        JLabel lblVitals = new JLabel("Vitals Snapshot");
        lblVitals.setFont(titleFont);
        lblVitals.setForeground(new Color(57, 90, 127));
        lblVitals.setBounds(20, 10, 200, 25);
        vitals.add(lblVitals);

        JPanel vitalsLine = new JPanel();
        vitalsLine.setBounds(20, 38, 710, 2);
        vitalsLine.setBackground(new Color(163, 202, 233));
        vitals.add(vitalsLine);

        String[][] vitalRows = {
            {"Blood Pressure", "120/80 mmHg"},
            {"Heart Rate", "72 bpm"},
            {"Temperature", "36.8°C"},
            {"SpO2", "98%"}
        };

        int y = 50;
        for (String[] row : vitalRows) {
            JLabel lbl = new JLabel(row[0] + ":");
            lbl.setFont(new Font("Calibri", Font.BOLD, 15));
            lbl.setForeground(Color.LIGHT_GRAY);
            lbl.setBounds(20, y, 200, 22);
            vitals.add(lbl);

            JLabel val = new JLabel(row[1]);
            val.setFont(new Font("Calibri", Font.BOLD, 15));
            val.setForeground(new Color(57, 90, 127));
            val.setBounds(230, y, 200, 22);
            vitals.add(val);
            y += 38;
        }

        // emergency contact
        JPanel emergency = new JPanel();
        emergency.setLayout(null);
        emergency.setBounds(820, 465, 750, 240);
        emergency.setBackground(Color.WHITE);
        emergency.setBorder(BorderFactory.createLineBorder(new Color(208, 216, 232)));
        add(emergency);

        JLabel lblEmergency = new JLabel("Emergency Contact");
        lblEmergency.setFont(titleFont);
        lblEmergency.setForeground(new Color(57, 90, 127));
        lblEmergency.setBounds(20, 10, 250, 25);
        emergency.add(lblEmergency);

        JPanel emergencyLine = new JPanel();
        emergencyLine.setBounds(20, 38, 710, 2);
        emergencyLine.setBackground(new Color(163, 202, 233));
        emergency.add(emergencyLine);

        JTextArea eText = new JTextArea("Gabriella Santos\nMother\n+63 912 345 6789");
        eText.setFont(bodyFont);
        eText.setBounds(20, 50, 700, 170);
        eText.setEditable(false);
        eText.setOpaque(false);
        emergency.add(eText);

        //appointment
        JPanel appointment = new JPanel();
        appointment.setLayout(null);
        appointment.setBounds(820, 465, 750, 240);
        appointment.setBackground(Color.WHITE);
        appointment.setBorder(BorderFactory.createLineBorder(new Color(163, 202, 233), 2));
        add(appointment);

        JLabel lblApp = new JLabel("Next Appointment");
        lblApp.setFont(titleFont);
        lblApp.setForeground(new Color(57, 90, 127));
        lblApp.setBounds(20, 10, 200, 25);
        appointment.add(lblApp);

        JPanel appLine = new JPanel();
        appLine.setBounds(20, 38, 710, 2);
        appLine.setBackground(new Color(163, 202, 233));
        appointment.add(appLine);

        JTextArea appText = new JTextArea("Aug 27 - 10:00 AM\nGeneral Checkup");
        appText.setFont(bodyFont);
        appText.setBounds(20, 50, 700, 170);
        appText.setEditable(false);
        appText.setOpaque(false);
        appointment.add(appText);

        
       
        
        //edit menu
        edit.addActionListener(e -> {
            JFrame editMenu = new JFrame();
            editMenu.setTitle("Edit Patient Information");
            editMenu.setSize(400, 500);
            editMenu.setLocationRelativeTo(null);
            editMenu.setLayout(null);
            editMenu.setResizable(false);


            JLabel lblEditName = new JLabel("Full Name:");
            lblEditName.setBounds(30, 30, 150, 25);
            lblEditName.setFont(new Font("Calibri", Font.BOLD, 14));
            editMenu.add(lblEditName);

            JTextField txtName = new JTextField("Joshua Santos");
            txtName.setBounds(30, 55, 320, 30);
            editMenu.add(txtName);

            JLabel lblEditStatus = new JLabel("Status:");
            lblEditStatus.setBounds(30, 100, 150, 25);
            lblEditStatus.setFont(new Font("Calibri", Font.BOLD, 14));
            editMenu.add(lblEditStatus);

            String[] statuses = {"Observation", "Admitted", "Discharged", "Critical", "Stable"};
            JComboBox<String> cmbStatus = new JComboBox<>(statuses);
            cmbStatus.setBounds(30, 125, 320, 30);
            editMenu.add(cmbStatus);

            JLabel lblEditBlood = new JLabel("Blood Type:");
            lblEditBlood.setBounds(30, 170, 150, 25);
            lblEditBlood.setFont(new Font("Calibri", Font.BOLD, 14));
            editMenu.add(lblEditBlood);

            String[] bloodTypes = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
            JComboBox<String> cmbBlood = new JComboBox<>(bloodTypes);
            cmbBlood.setBounds(30, 195, 320, 30);
            editMenu.add(cmbBlood);

            JButton btnSave = new JButton("Save Changes");
            btnSave.setBounds(30, 380, 150, 35);
            btnSave.setBackground(new Color(57, 90, 127));
            btnSave.setForeground(Color.WHITE);
            editMenu.add(btnSave);

            JButton btnCancel = new JButton("Cancel");
            btnCancel.setBounds(200, 380, 150, 35);
            btnCancel.setBackground(Color.GRAY);
            btnCancel.setForeground(Color.WHITE);
            editMenu.add(btnCancel);

            btnSave.addActionListener(save -> {
                name.setText(txtName.getText());
                status.setText("Status: " + cmbStatus.getSelectedItem());
                info.setText("ID: P-10021   |   Age: 29   |   Blood: " + cmbBlood.getSelectedItem());
                editMenu.dispose();
            });

            btnCancel.addActionListener(cancel -> editMenu.dispose());
            editMenu.setVisible(true);
        });
    }
}