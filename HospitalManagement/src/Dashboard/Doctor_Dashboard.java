package Dashboard;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class Doctor_Dashboard extends JPanel{

    private JPanel pnlMain, pnlPatients, pnlAppointment, pnlPrescription, pnlCritical, pnlRecent, pnlSchedule, pnlSummary, pnlSelection;
    private JLabel lblView, lblDashboard, lblDT, lblPatients, lblPCount, lblATitle, lblACount, lblPrCount, lblPrTitle, lblCTitle, lblCCount,
                   lblPatientIcon, lblPatientName, lblPatientID, lblPatientAge, lblSchedule, lblStatusAct, lblSummary, lblQuick;
    private ImageIcon imgPatient;
    private JButton btnViewProfile, btnEditProfile, btnViewSched, btnPatientRecord, btnAddAppointment, btnWriteNote;
    private JTable tblActivities, tblSummary;
    private JTableHeader HActivities, summaryHeader;
    private DefaultTableCellRenderer centerRenderer, center;
    private JScrollPane scrActivities, scrSummary;
    
    public Doctor_Dashboard() {
        setLayout(null);
        
        //Main Panel
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
        
        lblDashboard = new JLabel("DOCTOR Dashboard");
        lblDashboard.setBounds(50, 45, 300, 30);
        lblDashboard.setFont(new Font("Calibri", Font.BOLD, 28));
        pnlMain.add(lblDashboard);
        
        lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
        
        pnlPatients = new JPanel();
        pnlPatients.setLayout(null);
        pnlPatients.setBounds(70, 100, 280, 120);
        pnlPatients.setBackground(LightRed);
        pnlMain.add(pnlPatients);
        
        lblPatients = new JLabel("Total Patients");
        lblPatients.setBounds(15, 15, 200, 20);
        lblPatients.setFont(new Font("Calibri", Font.BOLD, 22));
        lblPatients.setForeground(Color.WHITE);
        pnlPatients.add(lblPatients);
        
        lblPCount = new JLabel("85");
        lblPCount.setBounds(190, 65, 200, 40);
        lblPCount.setForeground(Color.WHITE);
        lblPCount.setFont(new Font("Calibri", Font.BOLD, 32));
        pnlPatients.add(lblPCount);
        
        pnlAppointment = new JPanel();
        pnlAppointment.setLayout(null);
        pnlAppointment.setBounds(370, 100, 280, 120);
        pnlAppointment.setBackground(Blue);
        pnlMain.add(pnlAppointment);

        lblATitle = new JLabel("Today's Appointments");
        lblATitle.setBounds(15, 15, 200, 20);
        lblATitle.setForeground(Color.WHITE);
        lblATitle.setFont(new Font("Calibri", Font.BOLD, 20));
        pnlAppointment.add(lblATitle);

        lblACount = new JLabel("8");
        lblACount.setBounds(190,65, 200, 40);
        lblACount.setForeground(Color.WHITE);
        lblACount.setFont(new Font("Calibri", Font.BOLD, 32));
        pnlAppointment.add(lblACount);
        
        pnlPrescription = new JPanel();
        pnlPrescription.setLayout(null);
        pnlPrescription.setBounds(670, 100, 280, 120);
        pnlPrescription.setBackground(Yellow);
        pnlMain.add(pnlPrescription);

        lblPrTitle = new JLabel("Active Prescriptions");
        lblPrTitle.setBounds(15, 15, 200, 20);
        lblPrTitle.setForeground(Color.WHITE);
        lblPrTitle.setFont(new Font("Calibri", Font.BOLD, 22));
        pnlPrescription.add(lblPrTitle);

        lblPrCount = new JLabel("42");
        lblPrCount.setBounds(190,65, 200, 40);
        lblPrCount.setForeground(Color.WHITE);
        lblPrCount.setFont(new Font("Calibri", Font.BOLD, 28));
        pnlPrescription.add(lblPrCount);
        
        pnlCritical = new JPanel();
        pnlCritical.setLayout(null);
        pnlCritical.setBounds(970, 100, 280, 120);
        pnlCritical.setBackground(Green);
        pnlMain.add(pnlCritical);

        lblCTitle = new JLabel("Critical Patients Today");
        lblCTitle.setBounds(15, 15, 200, 20);
        lblCTitle.setForeground(Color.WHITE);
        lblCTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        pnlCritical.add(lblCTitle);

        lblCCount = new JLabel("2");
        lblCCount.setBounds(190, 65, 200, 40);
        lblCCount.setForeground(Color.WHITE);
        lblCCount.setFont(new Font("Calibri", Font.BOLD, 28));
        pnlCritical.add(lblCCount);
        
        pnlRecent = new JPanel();
        pnlRecent.setLayout(null);
        pnlRecent.setBounds(70, 240, 400, 380);
        pnlRecent.setBackground(Color.WHITE);
        pnlMain.add(pnlRecent);
        
        imgPatient = new ImageIcon(getClass().getResource("/resources/PATIENT.PHOTO.png"));
        Image imgPat = imgPatient.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        lblPatientIcon = new JLabel(new ImageIcon(imgPat));
        lblPatientIcon.setBounds(110, 20, 180, 180);
        pnlRecent.add(lblPatientIcon);
        
        lblPatientName = new JLabel("Joshua Garcia", SwingConstants.CENTER);
        lblPatientName.setFont(new Font("Calibri", Font.BOLD, 24));
        lblPatientName.setBounds(70, 175, 260, 30);
        pnlRecent.add(lblPatientName);
        
        lblPatientID = new JLabel("Patient ID: P-10234", SwingConstants.CENTER);
        lblPatientID.setFont(new Font("Calibri", Font.PLAIN, 18));
        lblPatientID.setBounds(70, 210, 260, 25);
        pnlRecent.add(lblPatientID);

        lblPatientAge = new JLabel("Age: 29", SwingConstants.CENTER);
        lblPatientAge.setFont(new Font("Calibri", Font.PLAIN, 18));
        lblPatientAge.setBounds(70, 235, 260, 25);
        pnlRecent.add(lblPatientAge);
        
        btnViewProfile = new JButton("View Profile");
        btnViewProfile.setFont(new Font("Calibri", Font.BOLD, 16));
        btnViewProfile.setBounds(70, 300, 120, 35);
        pnlRecent.add(btnViewProfile);

        btnEditProfile = new JButton("Edit Profile");
        btnEditProfile.setFont(new Font("Calibri", Font.BOLD, 16));
        btnEditProfile.setBounds(210, 300, 120, 35);
        pnlRecent.add(btnEditProfile);
        
        pnlSchedule = new JPanel();
        pnlSchedule.setLayout(null);
        pnlSchedule.setBounds(490, 240, 1030, 380);
        pnlSchedule.setBackground(Color.WHITE);
        pnlMain.add(pnlSchedule);
        
        lblSchedule = new JLabel("Today's Schedule");
        lblSchedule.setBounds(20, 20, 300, 30);
        lblSchedule.setFont(new Font("Calibri", Font.BOLD, 24));
        pnlSchedule.add(lblSchedule);
        
        String[] clmSchedule = {"Time", "Patient Name", "Room", "Reason", "Last Visit", "Status"};
        
        String[][] RwSchedule = {
            {"09:00 AM", "Joshua Garcia", "Room 101", "Routine Checkup", "03/05/2026", "Completed"},
            {"10:30 AM", "Maria Santos", "Room 102", "Follow-up Consultation", "02/20/2026", "Pending"},
            {"01:00 PM", "Daniel Cruz", "Room 103", "Lab Results Review", "01/15/2026", "In Progress"},
            {"03:15 PM", "Angela Reyes", "Room 104", "General Consultation", "04/01/2026", "Scheduled"},
            {"04:45 PM", "Michael Tan", "Room 105", "Prescription Renewal", "03/28/2026", "Completed"},
            {"08:30 AM", "Sophia Lim", "Room 106", "Annual Physical Exam", "04/10/2026", "Scheduled"},
            {"11:15 AM", "Carlos Dela Cruz", "Room 107", "Blood Pressure Check", "03/22/2026", "Completed"},
            {"02:30 PM", "Isabella Ramos", "Room 108", "Diabetes Follow-up", "02/18/2026", "Pending"},
            {"05:00 PM", "John Bautista", "Room 109", "Post-Surgery Check", "03/30/2026", "In Progress"},
            {"06:15 PM", "Emily Flores", "Room 110", "Vaccination", "04/05/2026", "Completed"}
            };
        
        tblActivities = new JTable(RwSchedule, clmSchedule);
        tblActivities.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblActivities.setRowHeight(30);
        tblActivities.setGridColor(Color.LIGHT_GRAY);
        tblActivities.setBackground(Color.WHITE);
        
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblActivities.getColumnCount() - 1; i++) {
            tblActivities.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        tblActivities.getColumnModel().getColumn(5).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
        lblStatusAct = new JLabel(value.toString(), SwingConstants.CENTER);
        lblStatusAct.setOpaque(true);
        lblStatusAct.setFont(new Font("Calibri", Font.PLAIN, 16));
        
        switch (value.toString()) {
        case "In Progress":
            lblStatusAct.setBackground(lightBlue);
            break;
        case "Scheduled":
            lblStatusAct.setBackground(MintGreen);
            break;
        case "Pending":
            lblStatusAct.setBackground(PaleYellow);
            break;
        case "Not Confirmed":
            lblStatusAct.setBackground(Lavender);
            break;
        case "Completed":
            lblStatusAct.setBackground(Teal);
            break;
        case "Urgent":
            lblStatusAct.setBackground(SoftPink);
            lblStatusAct.setFont(new Font("Calibri", Font.BOLD, 16));
            break;
        default:
            lblStatusAct.setBackground(Color.WHITE);
            break;
        }

        if (isSelected) {
            lblStatusAct.setBackground(HighBlue);
            lblStatusAct.setForeground(Color.BLACK);
        }
        
        return lblStatusAct;
        });
        
        HActivities = tblActivities.getTableHeader();
        HActivities.setFont(new Font("Calibri", Font.BOLD, 14));
        HActivities.setForeground(Color.BLACK);
        
        scrActivities = new JScrollPane(tblActivities);
        scrActivities.setBounds(20, 70, 1000, 280);
        pnlSchedule.add(scrActivities);
        
        lblView = new JLabel("View All");
        lblView.setFont(new Font("Calibri", Font.PLAIN, 18));
        lblView.setForeground(Color.BLUE);
        lblView.setBounds(940, 20, 80, 30);
        lblView.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlSchedule.add(lblView);
        
        pnlSummary = new JPanel();
        pnlSummary.setLayout(null);
        pnlSummary.setBounds(70, 650, 900, 230);
        pnlSummary.setBackground(Color.WHITE);
        pnlMain.add(pnlSummary);

        lblSummary = new JLabel("Room Assignment Summary");
        lblSummary.setBounds(20, 15, 400, 30);
        lblSummary.setFont(new Font("Calibri", Font.BOLD, 24));
        pnlSummary.add(lblSummary);
        
        lblView = new JLabel("View All");
        lblView.setFont(new Font("Calibri", Font.PLAIN, 18));
        lblView.setForeground(Color.BLUE);
        lblView.setBounds(820, 15, 80, 30);
        lblView.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlSummary.add(lblView);

        String[] clmSummary = {"Room Number", "Doctor", "Nurse", "Equipment"};

        String[][] RwSummary = {
            {"Room 101", "Dr. Santos", "Nurse Cruz", "ECG Monitor"},
            {"Room 102", "Dr. Reyes", "Nurse Lopez", "Oxygen Tank"},
            {"Room 103", "Dr. Garcia", "Nurse Mendoza", "Infusion Pump"},
            {"Room 104", "Dr. Ramos", "Nurse Villanueva", "Wheelchair"}
        };

        tblSummary = new JTable(RwSummary, clmSummary);
        tblSummary.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblSummary.setRowHeight(35);
        tblSummary.setGridColor(Color.LIGHT_GRAY);
        tblSummary.setBackground(Color.WHITE);

        summaryHeader = tblSummary.getTableHeader();
        summaryHeader.setFont(new Font("Calibri", Font.BOLD, 14));

        center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < 4; i++) {
            tblSummary.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        scrSummary = new JScrollPane(tblSummary);
        scrSummary.setBounds(20, 50, 860, 150);
        scrSummary.setBorder(BorderFactory.createEmptyBorder());
        pnlSummary.add(scrSummary);

        pnlSelection = new JPanel();
        pnlSelection.setLayout(null);
        pnlSelection.setBounds(990, 650, 530, 230);
        pnlSelection.setBackground(Color.WHITE);
        pnlMain.add(pnlSelection);
        
        lblQuick = new JLabel("Quick Actions");
        lblQuick.setBounds(20, 15, 300, 30);
        lblQuick.setFont(new Font("Calibri", Font.BOLD, 24));
        lblQuick.setForeground(Color.BLACK);
        pnlSelection.add(lblQuick);

        btnViewSched = new JButton("View Schedule");
        btnViewSched.setBounds(15, 60, 240, 70);
        btnViewSched.setFont(new Font("Calibri", Font.BOLD, 18));
        btnViewSched.setBackground(Green);
        btnViewSched.setForeground(Color.BLACK);
        btnViewSched.setFocusPainted(false);
        pnlSelection.add(btnViewSched);

        btnPatientRecord = new JButton("Patient Record");
        btnPatientRecord.setBounds(275, 60, 240, 70);
        btnPatientRecord.setFont(new Font("Calibri", Font.BOLD, 18));
        btnPatientRecord.setBackground(Blue);
        btnPatientRecord.setForeground(Color.BLACK);
        btnPatientRecord.setFocusPainted(false);
        pnlSelection.add(btnPatientRecord);

        btnAddAppointment = new JButton("Add Appointment");
        btnAddAppointment.setBounds(15, 140, 240, 70);
        btnAddAppointment.setFont(new Font("Calibri", Font.BOLD, 18));
        btnAddAppointment.setBackground(Yellow);
        btnAddAppointment.setForeground(Color.BLACK);
        btnAddAppointment.setFocusPainted(false);
        pnlSelection.add(btnAddAppointment);

        btnWriteNote = new JButton("Write Note");
        btnWriteNote.setBounds(275, 140, 240, 70);
        btnWriteNote.setFont(new Font("Calibri", Font.BOLD, 18));
        btnWriteNote.setBackground(LightRed);
        btnWriteNote.setForeground(Color.BLACK);
        btnWriteNote.setFocusPainted(false);
        pnlSelection.add(btnWriteNote);

        setVisible(true);
    }
}