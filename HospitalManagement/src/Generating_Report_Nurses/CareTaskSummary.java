package Generating_Report_Nurses;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class CareTaskSummary extends JPanel {
    
    private JPanel pnlMain,lineTop, lineFooter, pnlPatient, pnlTable;
    private JLabel lblLogo, lblHospital, lblAddress, lblContact,lblTitle, lblRefNo, lblDate, 
                   lblPName, lblPID, lblRoom, lblFooter;
    private Image imgLG;
    private JTable tblTask;
    private JScrollPane scrTable,scrCareTask;
    private ImageIcon imgLogo;
    
    public CareTaskSummary() {
        setLayout(null);
        setBounds(0, 0, 1060, 650);
        setBackground(Color.WHITE);
        
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setPreferredSize(new Dimension(1040, 900));
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        scrCareTask = new JScrollPane(pnlMain);
        scrCareTask.setBounds(0, 0, 1060, 650);
        scrCareTask.setBorder(BorderFactory.createEmptyBorder());
        scrCareTask.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrCareTask);

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

        lblTitle = new JLabel("CARE TASK SUMMARY");
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 22));
        lblTitle.setBounds(680, 35, 400, 30);
        pnlMain.add(lblTitle);

        lblRefNo = new JLabel("Ref No.: CT-2026-001");
        lblRefNo.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblRefNo.setBounds(740, 70, 200, 20);
        pnlMain.add(lblRefNo);

        lblDate = new JLabel("Date: April 15, 2026");
        lblDate.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblDate.setBounds(740, 90, 200, 20);
        pnlMain.add(lblDate);

        lineTop = new JPanel();
        lineTop.setBounds(30, 130, 980, 2);
        lineTop.setBackground(neutralGray);
        pnlMain.add(lineTop);

        pnlPatient = new JPanel();
        pnlPatient.setLayout(null);
        pnlPatient.setBounds(30, 150, 980, 80);
        pnlPatient.setBorder(BorderFactory.createTitledBorder("Patient Information"));
        pnlMain.add(pnlPatient);

        lblPName = new JLabel("Patient Name: Joshua Garcia");
        lblPName.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblPName.setBounds(25, 30, 300, 20);
        pnlPatient.add(lblPName);

        lblPID = new JLabel("Patient ID: P-10234");
        lblPID.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblPID.setBounds(400, 30, 200, 20);
        pnlPatient.add(lblPID);

        lblRoom = new JLabel("Room: 101");
        lblRoom.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblRoom.setBounds(700, 30, 150, 20);
        pnlPatient.add(lblRoom);

        pnlTable = new JPanel();
        pnlTable.setLayout(null);
        pnlTable.setBounds(30, 250, 980, 280);
        pnlTable.setBorder(BorderFactory.createTitledBorder("Care Tasks"));
        pnlMain.add(pnlTable);

        String[] clmTask = {"Time", "Task", "Assigned To", "Status", "Completed At"};
        String[][] rwTask = {
            {"08:00 AM", "Check vital signs", "Nurse Angela", "Completed", "08:15 AM"},
            {"09:00 AM", "Administer medication", "Nurse Angela", "Completed", "09:05 AM"},
            {"10:00 AM", "Assist with bathing", "Nurse Angela", "In Progress", "-"},
            {"12:00 PM", "Monitor food intake", "Nurse Angela", "Pending", "-"},
            {"02:00 PM", "Change wound dressing", "Nurse Angela", "Scheduled", "-"}
        };

        tblTask = new JTable(rwTask, clmTask);
        tblTask.setRowHeight(35);
        tblTask.setFont(new Font("Calibri", Font.PLAIN, 13));
        tblTask.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 13));

        scrTable = new JScrollPane(tblTask);
        scrTable.setBounds(20, 30, 940, 220);
        pnlTable.add(scrTable);

        lineFooter = new JPanel();
        lineFooter.setBounds(30, 560, 980, 2);
        lineFooter.setBackground(neutralGray);
        pnlMain.add(lineFooter);

        lblFooter = new JLabel("Total Tasks: 5 | Completed: 2 | In Progress: 1 | Pending: 1 | Scheduled: 1");
        lblFooter.setFont(new Font("Calibri", Font.ITALIC, 12));
        lblFooter.setBounds(280, 580, 550, 20);
        pnlMain.add(lblFooter);
    }
}