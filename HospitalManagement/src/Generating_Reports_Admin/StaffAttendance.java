package Generating_Reports_Admin;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class StaffAttendance extends JPanel {

    private JPanel pnlSA, pnlLine, pnlFilters, pnlSummary, pnlTotal, pnlPresent, pnlLate, pnlAbsent, pnlFooter;
    private JScrollPane scrSA;
    private ImageIcon imgDlogo;
    private Image imgLG;
    private JLabel lblLogo, lblHospital, lblAddress, lblContact, lblReportTitle, lblReportNo, lblDate,
                   lblDept, lblStatus, lblDateRange, lblStats, lblTotalTitle, lblTotalCount, lblPresentTitle,
                   lblPresentCount, lblLateTitle, lblLateCount, lblAbsentTitle, lblACount, lblPrepared, lblApproved;
    private JComboBox cmbDept, cmbStatus, cmbStaffStatus;
    private JTextField txtDate;
    private JButton btnSearch;
    private JTable tblStaff;
    private JScrollPane scrStaff;
    
    
    public StaffAttendance() {
        setLayout(null);
        setBounds(0, 0, 1060, 900);
        setBackground(Color.WHITE);

        pnlSA = new JPanel();
        pnlSA.setLayout(null);
        pnlSA.setPreferredSize(new Dimension(1040, 900));
        pnlSA.setBackground(Color.WHITE);
        pnlSA.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        scrSA = new JScrollPane(pnlSA);
        scrSA.setBounds(0, 0, 1060, 650);
        scrSA.setBorder(BorderFactory.createEmptyBorder());
        scrSA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrSA.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrSA);

        imgDlogo = new ImageIcon(getClass().getResource("/resources/eTriage.DOCUMENT.LOGO.png"));
        imgLG = imgDlogo.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(imgLG));
        lblLogo.setBounds(20, 10, 90, 90);
        pnlSA.add(lblLogo);

        lblHospital = new JLabel("ETRIAGE HOSPITAL");
        lblHospital.setFont(new Font("Calibri", Font.BOLD, 22));
        lblHospital.setBounds(120, 15, 400, 25);
        pnlSA.add(lblHospital);

        lblAddress = new JLabel("123 Health St., Wellness City, Medical County");
        lblAddress.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblAddress.setBounds(120, 45, 400, 18);
        pnlSA.add(lblAddress);

        lblContact = new JLabel("Tel No.: (02) 8123-4567");
        lblContact.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblContact.setBounds(120, 65, 300, 18);
        pnlSA.add(lblContact);

        lblReportTitle = new JLabel("STAFF ATTENDANCE REPORT");
        lblReportTitle.setFont(new Font("Calibri", Font.BOLD, 18));
        lblReportTitle.setBounds(120, 88, 350, 22);
        pnlSA.add(lblReportTitle);

        lblReportNo = new JLabel("Report No.: SAR-2026-0415-001");
        lblReportNo.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblReportNo.setBounds(730, 25, 260, 20);
        pnlSA.add(lblReportNo);

        lblDate = new JLabel("Date: April 15, 2026");
        lblDate.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblDate.setBounds(730, 50, 260, 20);
        pnlSA.add(lblDate);

        pnlLine = new JPanel();
        pnlLine.setBounds(20, 110, 960, 2);
        pnlSA.add(pnlLine);

        pnlFilters = new JPanel();
        pnlFilters.setLayout(null);
        pnlFilters.setBounds(20, 160, 980, 85);
        pnlFilters.setBackground(Color.WHITE);
        pnlFilters.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(neutralGray),
                "Report Filters", TitledBorder.LEFT,TitledBorder.TOP, new Font("Calibri", 
                     Font.BOLD, 14),darkBlue));
        pnlSA.add(pnlFilters);

        lblDept = new JLabel("Department:");
        lblDept.setFont(new Font("Calibri", Font.BOLD, 14));
        lblDept.setBounds(25, 35, 100, 25);
        pnlFilters.add(lblDept);

        cmbDept = new JComboBox<>(new String[]{
            "Department: All", "General Medicine", "Pediatrics", "Internal Medicine", "Cardiology",
            "Endocrinology", "Gastroenterology", "Neurology", "Pulmonology", "Nephrology", "Orthopedics",
            "Surgery", "Physical Therapy", "Rehabilitation", "Ophthalmology", "ENT", "Dermatology", "OB-GYN",
            "Family Medicine", "Psychiatry", "Emergency", "Dentistry", "Radiology", "Anesthesiology"
        });
        cmbDept.setBounds(120, 35, 180, 25);
        pnlFilters.add(cmbDept);

        lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Calibri", Font.BOLD, 14));
        lblStatus.setBounds(340, 35, 80, 25);
        pnlFilters.add(lblStatus);

        cmbStatus = new JComboBox<>(new String[]{
            "All", "Present", "Late", "Absent"
        });
        cmbStatus.setBounds(400, 35, 140, 25);
        pnlFilters.add(cmbStatus);

        lblDateRange = new JLabel("Date:");
        lblDateRange.setFont(new Font("Calibri", Font.BOLD, 14));
        lblDateRange.setBounds(580, 35, 60, 25);
        pnlFilters.add(lblDateRange);

        txtDate = new JTextField("April 15, 2026");
        txtDate.setBounds(630, 35, 160, 25);
        pnlFilters.add(txtDate);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(830, 33, 110, 30);
        btnSearch.setBackground(darkBlue);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFocusPainted(false);
        pnlFilters.add(btnSearch);

        String[] clmStaff = {
            "No.", "Staff ID", "Staff Name", "Department",
            "Role", "Time In", "Time Out", "Status", "Remarks"
        };

        String[][] rwStaff = {
            {"1", "S-0001", "Angela Cruz", "Nursing", "Nurse", "08:00 AM", "04:00 PM", "Present", "-"},
            {"2", "S-0002", "Mark Dela Pena", "Laboratory", "Lab Technician", "08:05 AM", "04:10 PM", "Present", "-"},
            {"3", "S-0003", "Isabella Ramos", "Doctors", "Physician", "07:50 AM", "04:30 PM", "Present", "-"},
            {"4", "S-0004", "John Rivera", "Pharmacy", "Pharmacist", "08:20 AM", "04:15 PM", "Late", "20 mins late"},
            {"5", "S-0005", "Maria Santos", "Nursing", "Nurse", "-", "-", "Absent", "Sick Leave"},
            {"6", "S-0006", "Kevin Garcia", "Maintenance", "Technician", "08:00 AM", "04:00 PM", "Present", "-"}
        };

        tblStaff = new JTable(rwStaff, clmStaff);
        tblStaff.setFont(new Font("Calibri", Font.PLAIN, 14));
        tblStaff.setRowHeight(30);
        tblStaff.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 14));

        scrStaff = new JScrollPane(tblStaff);
        scrStaff.setBounds(20, 270, 980, 220);
        pnlSA.add(scrStaff);
        
        String[] staffStatuses = {"Present", "Late", "Absent"};

        cmbStaffStatus = new JComboBox<>(staffStatuses);
        tblStaff.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(cmbStaffStatus));

        tblStaff.getColumnModel().getColumn(7).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {

            lblStats = new JLabel(value.toString(), SwingConstants.CENTER);
            lblStats.setOpaque(true);
            lblStats.setFont(new Font("Calibri", Font.BOLD, 14));

            switch (value.toString()) {
                case "Present":
                    lblStats.setBackground(MintGreen);
                    lblStats.setForeground(Color.BLACK);
                    break;

                case "Late":
                    lblStats.setBackground(PaleYellow);
                    lblStats.setForeground(Color.BLACK);
                    break;

                case "Absent":
                    lblStats.setBackground(SoftPink);
                    lblStats.setForeground(Color.BLACK);
                    break;

                default:
                    lblStats.setBackground(Color.WHITE);
                    lblStats.setForeground(Color.BLACK);
            }

            if (isSelected) {
                lblStats.setBackground(veryLightBlue);
            }

            return lblStats;
        });

        pnlSummary = new JPanel();
        pnlSummary.setLayout(null);
        pnlSummary.setBounds(20, 510, 980, 95);
        pnlSummary.setBackground(Color.WHITE);
        pnlSummary.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(neutralGray), "Attendance Summary",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.BOLD, 14), darkBlue));
        pnlSA.add(pnlSummary);

        pnlTotal = new JPanel();
        pnlTotal.setLayout(null);
        pnlTotal.setBounds(40, 30, 200, 50);
        pnlTotal.setBackground(darkBlue);
        pnlSummary.add(pnlTotal);

        lblTotalTitle = new JLabel("Total Staff");
        lblTotalTitle.setBounds(10, 5, 150, 18);
        lblTotalTitle.setForeground(Color.WHITE);
        lblTotalTitle.setFont(new Font("Calibri", Font.BOLD, 14));
        pnlTotal.add(lblTotalTitle);

        lblTotalCount = new JLabel("6");
        lblTotalCount.setBounds(140, 18, 50, 30);
        lblTotalCount.setForeground(Color.WHITE);
        lblTotalCount.setFont(new Font("Calibri", Font.BOLD, 22));
        pnlTotal.add(lblTotalCount);

        pnlPresent = new JPanel();
        pnlPresent.setLayout(null);
        pnlPresent.setBounds(260, 30, 200, 50);
        pnlPresent.setBackground(Green);
        pnlSummary.add(pnlPresent);

        lblPresentTitle = new JLabel("Present");
        lblPresentTitle.setBounds(10, 5, 150, 18);
        lblPresentTitle.setForeground(Color.WHITE);
        lblPresentTitle.setFont(new Font("Calibri", Font.BOLD, 14));
        pnlPresent.add(lblPresentTitle);

        lblPresentCount = new JLabel("4");
        lblPresentCount.setBounds(140, 18, 50, 30);
        lblPresentCount.setForeground(Color.WHITE);
        lblPresentCount.setFont(new Font("Calibri", Font.BOLD, 22));
        pnlPresent.add(lblPresentCount);

        pnlLate = new JPanel();
        pnlLate.setLayout(null);
        pnlLate.setBounds(480, 30, 200, 50);
        pnlLate.setBackground(Color.ORANGE);
        pnlSummary.add(pnlLate);

        lblLateTitle = new JLabel("Late");
        lblLateTitle.setBounds(10, 5, 150, 18);
        lblLateTitle.setForeground(Color.WHITE);
        lblLateTitle.setFont(new Font("Calibri", Font.BOLD, 14));
        pnlLate.add(lblLateTitle);

        lblLateCount = new JLabel("1");
        lblLateCount.setBounds(140, 18, 50, 30);
        lblLateCount.setForeground(Color.WHITE);
        lblLateCount.setFont(new Font("Calibri", Font.BOLD, 22));
        pnlLate.add(lblLateCount);

        pnlAbsent = new JPanel();
        pnlAbsent.setLayout(null);
        pnlAbsent.setBounds(700, 30, 200, 50);
        pnlAbsent.setBackground(Color.RED);
        pnlSummary.add(pnlAbsent);

        lblAbsentTitle = new JLabel("Absent");
        lblAbsentTitle.setBounds(10, 5, 150, 18);
        lblAbsentTitle.setForeground(Color.WHITE);
        lblAbsentTitle.setFont(new Font("Calibri", Font.BOLD, 14));
        pnlAbsent.add(lblAbsentTitle);

        lblACount = new JLabel("1");
        lblACount.setBounds(140, 18, 50, 30);
        lblACount.setForeground(Color.WHITE);
        lblACount.setFont(new Font("Calibri", Font.BOLD, 22));
        pnlAbsent.add(lblACount);

        pnlFooter = new JPanel();
        pnlFooter.setBounds(30, 820, 980, 2);
        pnlFooter.setBackground(neutralGray);
        pnlSA.add(pnlFooter);

        lblPrepared = new JLabel("Prepared by: Admin User");
        lblPrepared.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblPrepared.setBounds(60, 845, 350, 20);
        pnlSA.add(lblPrepared);

        lblApproved = new JLabel("Approved by: ____________________");
        lblApproved.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblApproved.setBounds(650, 845, 400, 20);
        pnlSA.add(lblApproved);

    }
}