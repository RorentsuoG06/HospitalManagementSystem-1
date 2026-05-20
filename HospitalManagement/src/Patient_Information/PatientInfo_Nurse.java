package Patient_Information;

import static Color_Palette.ColorPalette.*;
import javax.swing.*;
import java.awt.*;

public class PatientInfo_Nurse extends JPanel {

    private JPanel pnlMain, profileCard, accent, statusBadge, details, detailsLine, doctorNotes, notesLine,
                   vitals, vitalsLine, emergency, emergencyLine, appointment, appLine;
    private JLabel lbltitle, lblDT, lblPat, name, status, info, lblDetails, lblAdd, lblAddre, lblCnum,
                   lblNum, lblAllergy, lblCondition, lblMed, lblNotes, lblVitals, lblVT, lblval, lblEmergency,
                   lblApp, lblTime, lblT, lblRoom, lblR, lblType, lblTy, lblEditName, lblEditStatus,
                   lblEditBlood;
    private ImageIcon imgP;
    private Image ImgPT;
    private JButton edit, notes, btnSave, btnCancel;
    private JTextArea allergyText, conditionText, medText, notesText, txtCon, eText, lblDate, lblD;
    private JTextField txtName;
    private JFrame editMenu;
    private JComboBox cmbStatus, cmbBlood;
    
    public PatientInfo_Nurse(){
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        //Main Panel
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);

        //page title
        lbltitle = new JLabel("Patient Profile");
        lbltitle.setFont(new Font("Calibri", Font.BOLD, 24));
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setBounds(30, 20, 400, 40);
        pnlMain.add(lbltitle);
        
        lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);

       //patient profile card
        profileCard = new JPanel();
        profileCard.setLayout(null);
        profileCard.setBounds(30, 80, 1550, 140);
        profileCard.setBackground(Color.WHITE);
        profileCard.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlMain.add(profileCard);

        //blue accent on card
        accent = new JPanel();
        accent.setBounds(0, 0, 6, 140);
        accent.setBackground(darkBlue);
        profileCard.add(accent);

        imgP = new ImageIcon(getClass().getResource("/resources/PATIENT.PHOTO.png"));
        ImgPT = imgP.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        lblPat = new JLabel(new ImageIcon(ImgPT));
        lblPat.setBounds(10, 15, 140, 140);
        profileCard.add(lblPat);
        
        name = new JLabel("Joshua Garcia");
        name.setFont(new Font("Calibri", Font.BOLD, 22));
        name.setBounds(150, 20, 300, 30);
        profileCard.add(name);

        //status badge
        statusBadge = new JPanel();
        statusBadge.setBackground(LightRed);
        statusBadge.setBounds(150, 55, 190, 26);
        statusBadge.setLayout(null);
        profileCard.add(statusBadge);

        status = new JLabel("Status: Observation");
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Calibri", Font.BOLD, 18));
        status.setBounds(5, 5, 180, 20);
        statusBadge.add(status);

        info = new JLabel("ID: P-10021   |   Age: 29   |   Blood: O+");
        info.setFont(new Font("Calibri", Font.BOLD, 15));
        info.setForeground(Color.DARK_GRAY);
        info.setBounds(150, 90, 400, 22);
        profileCard.add(info);

        //edit and notes buttons
        edit = new JButton("Edit");
        edit.setBounds(1420, 30, 100, 35);
        edit.setBackground(darkBlue);
        edit.setForeground(Color.WHITE);
        edit.setFont(new Font("Calibri", Font.BOLD, 14));
        profileCard.add(edit);

        notes = new JButton("Notes");
        notes.setBounds(1420, 75, 100, 35);
        notes.setBackground(lightBlue);
        notes.setForeground(Color.BLACK);
        notes.setFont(new Font("Calibri", Font.BOLD, 14));
        profileCard.add(notes);

        //details panel
        details = new JPanel();
        details.setLayout(null);
        details.setBounds(30, 240, 750, 300);
        details.setBackground(Color.WHITE);
        details.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlMain.add(details);

        lblDetails = new JLabel("Patient Details");
        lblDetails.setFont(new Font("Calibri", Font.BOLD, 22));
        lblDetails.setForeground(darkBlue);
        lblDetails.setBounds(20, 10, 200, 25);
        details.add(lblDetails);

        detailsLine = new JPanel();
        detailsLine.setBounds(20, 38, 710, 2);
        detailsLine.setBackground(lightBlue);
        details.add(detailsLine);

        lblAdd = new JLabel("Address: ");
        lblAdd.setFont(new Font("Calibri", Font.BOLD, 22));
        lblAdd.setForeground(darkBlue);
        lblAdd.setBounds(20, 50, 200, 30);
        details.add(lblAdd);
        
        lblAddre = new JLabel("Biñan, Laguna");
        lblAddre.setFont(new Font("Calibri", Font.PLAIN, 22));
        lblAddre.setForeground(darkBlue);
        lblAddre.setBounds(200, 50, 200, 30);
        details.add(lblAddre);
        
        lblCnum = new JLabel("Contact Number: ");
        lblCnum.setFont(new Font("Calibri", Font.BOLD, 22));
        lblCnum.setForeground(darkBlue);
        lblCnum.setBounds(20, 80, 200, 30);
        details.add(lblCnum);
        
        lblNum = new JLabel("+63 923 456 789");
        lblNum.setFont(new Font("Calibri", Font.PLAIN, 22));
        lblNum.setForeground(darkBlue);
        lblNum.setBounds(200, 80, 200, 30);
        details.add(lblNum);

        //patient allergy
        lblAllergy = new JLabel("Allergies");
        lblAllergy.setFont(new Font("Calibri", Font.BOLD, 22));
        lblAllergy.setForeground(LightRed);
        lblAllergy.setBounds(20, 150, 150, 22);
        details.add(lblAllergy);

        allergyText = new JTextArea("- Penicillin\n- Dust Allergy");
        allergyText.setBounds(20, 170, 200, 55);
        allergyText.setEditable(false);
        allergyText.setOpaque(false);
        allergyText.setFont(new Font("Calibri", Font.PLAIN, 22));
        details.add(allergyText);

        // patient conditions
        lblCondition = new JLabel("Conditions");
        lblCondition.setFont(new Font("Calibri", Font.BOLD, 22));
        lblCondition.setForeground(darkBlue);
        lblCondition.setBounds(250, 150, 150, 22);
        details.add(lblCondition);

        conditionText = new JTextArea("- Diabetes\n- Hypertension");
        conditionText.setBounds(250, 170, 200, 55);
        conditionText.setEditable(false);
        conditionText.setOpaque(false);
        conditionText.setFont(new Font("Calibri", Font.PLAIN, 22));
        details.add(conditionText);

        //patient medication
        lblMed = new JLabel("Medication Intake");
        lblMed.setFont(new Font("Calibri", Font.BOLD, 20));
        lblMed.setForeground(darkBlue);
        lblMed.setBounds(480, 150, 200, 22);
        details.add(lblMed);

        medText = new JTextArea("- Metformin (Daily)\n- Ibuprofen (As needed)");
        medText.setBounds(480, 170, 230, 55);
        medText.setEditable(false);
        medText.setOpaque(false);
        medText.setFont(new Font("Calibri", Font.PLAIN, 18));
        details.add(medText);

        // doctor notes
        doctorNotes = new JPanel();
        doctorNotes.setLayout(null);
        doctorNotes.setBounds(30, 560, 750, 340);
        doctorNotes.setBackground(Color.WHITE);
        doctorNotes.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlMain.add(doctorNotes);

        lblNotes = new JLabel("Doctor's Notes");
        lblNotes.setFont(new Font("Calibri", Font.BOLD, 22));
        lblNotes.setForeground(darkBlue);
        lblNotes.setBounds(20, 10, 200, 25);
        doctorNotes.add(lblNotes);

        notesLine = new JPanel();
        notesLine.setBounds(20, 38, 710, 2);
        notesLine.setBackground(lightBlue);
        doctorNotes.add(notesLine);

        notesText = new JTextArea("Patient monitored overnight.\n" 
                                  +"Vital signs stable, no signs of distress.\n\n" 
                                  +"Recommendation:\\nContinue routine monitoring and follow-up next week.");
        notesText.setFont(new Font("Calibri", Font.PLAIN, 22));
        notesText.setBounds(20, 50, 700, 260);
        notesText.setEditable(false);
        notesText.setOpaque(false);
        notesText.setLineWrap(true);
        notesText.setWrapStyleWord(true);
        doctorNotes.add(notesText);
        
        // patient vitals
        vitals = new JPanel();
        vitals.setLayout(null);
        vitals.setBounds(820, 240, 760, 220);
        vitals.setBackground(Color.WHITE);
        vitals.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlMain.add(vitals);

        lblVitals = new JLabel("Vitals Snapshot");
        lblVitals.setFont(new Font("Calibri", Font.BOLD, 22));
        lblVitals.setForeground(darkBlue);
        lblVitals.setBounds(20, 10, 200, 25);
        vitals.add(lblVitals);

        vitalsLine = new JPanel();
        vitalsLine.setBounds(20, 38, 710, 2);
        vitalsLine.setBackground(lightBlue);
        vitals.add(vitalsLine);

        String[][] vitalRows = {
            {"Blood Pressure", "120/80 mmHg"},
            {"Heart Rate", "72 bpm"},
            {"Temperature", "36.8°C"},
            {"SpO2", "98%"}
        };

        int y = 50;
        for (String[] row : vitalRows) {
            lblVT = new JLabel(row[0] + ":");
            lblVT.setFont(new Font("Calibri", Font.BOLD, 20));
            lblVT.setForeground(Color.DARK_GRAY);
            lblVT.setBounds(20, y, 200, 22);
            vitals.add(lblVT);

            lblval = new JLabel(row[1]);
            lblval.setFont(new Font("Calibri", Font.PLAIN, 20));
            lblval.setForeground(darkBlue);
            lblval.setBounds(230, y, 200, 22);
            vitals.add(lblval);
            y += 38;
        }

        // emergency contact
        emergency = new JPanel();
        emergency.setLayout(null);
        emergency.setBounds(820, 470, 760, 220);
        emergency.setBackground(Color.WHITE);
        emergency.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlMain.add(emergency);

        lblEmergency = new JLabel("Emergency Contact");
        lblEmergency.setFont(new Font("Calibri", Font.BOLD, 22));
        lblEmergency.setForeground(darkBlue);
        lblEmergency.setBounds(20, 10, 250, 25);
        emergency.add(lblEmergency);

        emergencyLine = new JPanel();
        emergencyLine.setBounds(20, 38, 710, 2);
        emergencyLine.setBackground(lightBlue);
        emergency.add(emergencyLine);
        
        txtCon = new JTextArea("Contact Name: \n\nRelationship: \n\nContact Number: ");
        txtCon.setFont(new Font("Calibri", Font.BOLD, 20));
        txtCon.setBounds(20, 50, 500, 170);
        txtCon.setEditable(false);
        txtCon.setOpaque(false);
        emergency.add(txtCon);

        eText = new JTextArea("Gabriella Santos\n\nMother\n\n+63 912 345 6789");
        eText.setFont(new Font("Calibri", Font.PLAIN, 20));
        eText.setBounds(250, 50, 500, 170);
        eText.setEditable(false);
        eText.setOpaque(false);
        emergency.add(eText);

        //appointment
        appointment = new JPanel();
        appointment.setLayout(null);
        appointment.setBounds(820, 710, 760, 190);
        appointment.setBackground(Color.WHITE);
        appointment.setBorder(BorderFactory.createLineBorder(borderLBLUE));
        pnlMain.add(appointment);

        lblApp = new JLabel("Next Appointment");
        lblApp.setFont(new Font("Calibri", Font.BOLD, 22));
        lblApp.setForeground(darkBlue);
        lblApp.setBounds(20, 15, 300, 30);
        appointment.add(lblApp);

        appLine = new JPanel();
        appLine.setBounds(20, 50, 1500, 2);
        appLine.setBackground(lightBlue);
        appointment.add(appLine);

        lblDate = new JTextArea("Date:");
        lblDate.setFont(new Font("Calibri", Font.BOLD, 20));
        lblDate.setForeground(Color.BLACK);
        lblDate.setBounds(20, 70, 80, 30);
        appointment.add(lblDate);
        
        lblD = new JTextArea("August 26, 2026");
        lblD.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblD.setForeground(Color.BLACK);
        lblD.setBounds(100, 70, 200, 30);
        appointment.add(lblD);
        
        lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTime.setForeground(Color.BLACK);
        lblTime.setBounds(20, 110, 80, 30);
        appointment.add(lblTime);
        
        lblT = new JLabel("9:00 AM");
        lblT.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblT.setForeground(Color.BLACK);
        lblT.setBounds(100, 110, 200, 30);
        appointment.add(lblT);
        
        lblRoom = new JLabel("Room:");
        lblRoom.setFont(new Font("Calibri", Font.BOLD, 20));
        lblRoom.setForeground(Color.BLACK);
        lblRoom.setBounds(300, 70, 80, 30);
        appointment.add(lblRoom);
        
        lblR = new JLabel("101");
        lblR.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblR.setForeground(Color.BLACK);
        lblR.setBounds(380, 70, 200, 30);
        appointment.add(lblR);

        lblType = new JLabel("Type:");
        lblType.setFont(new Font("Calibri", Font.BOLD, 20));
        lblType.setForeground(Color.BLACK);
        lblType.setBounds(300, 110, 80, 30);
        appointment.add(lblType);
        
        lblTy = new JLabel("General Checkup");
        lblTy.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblTy.setForeground(Color.BLACK);
        lblTy.setBounds(380, 110, 300, 30);
        appointment.add(lblTy);

        //edit menu
        edit.addActionListener(e -> {
            editMenu = new JFrame();
            editMenu.setTitle("Edit Patient Information");
            editMenu.setSize(400, 500);
            editMenu.setLocationRelativeTo(null);
            editMenu.setLayout(null);
            editMenu.setResizable(false);


            lblEditName = new JLabel("Full Name:");
            lblEditName.setBounds(30, 30, 150, 25);
            lblEditName.setFont(new Font("Calibri", Font.BOLD, 14));
            editMenu.add(lblEditName);

            txtName = new JTextField("Joshua Garcia");
            txtName.setBounds(30, 55, 320, 30);
            editMenu.add(txtName);

            lblEditStatus = new JLabel("Status:");
            lblEditStatus.setBounds(30, 100, 150, 25);
            lblEditStatus.setFont(new Font("Calibri", Font.BOLD, 14));
            editMenu.add(lblEditStatus);

            String[] statuses = {"Observation", "Admitted", "Discharged", "Critical", "Stable"};
            cmbStatus = new JComboBox<>(statuses);
            cmbStatus.setBounds(30, 125, 320, 30);
            editMenu.add(cmbStatus);

            lblEditBlood = new JLabel("Blood Type:");
            lblEditBlood.setBounds(30, 170, 150, 25);
            lblEditBlood.setFont(new Font("Calibri", Font.BOLD, 14));
            editMenu.add(lblEditBlood);

            String[] bloodTypes = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
            cmbBlood = new JComboBox<>(bloodTypes);
            cmbBlood.setBounds(30, 195, 320, 30);
            editMenu.add(cmbBlood);

            btnSave = new JButton("Save Changes");
            btnSave.setBounds(30, 380, 150, 35);
            btnSave.setBackground(darkBlue);
            btnSave.setForeground(Color.WHITE);
            editMenu.add(btnSave);

            btnCancel = new JButton("Cancel");
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