package Dashboard;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class Admin_Dashboard extends JPanel{
    
    private JPanel pnlMain, tabItem, pnlActivity, pnlSummary, tabUpdate, tabLows, tabValue, tabSup, tabEq, tabMed;
    private JLabel lblOverview, lblDT, lblMonth, lblTitle, lblValue, lblTValue, lblActive, lblSup, lblEq, lblMed,
                   lblActivity, lblFilter, lblSummary, lblTItem, lblLStock;
    private JTable tblCalendar, tblActivities, tblSummary;
    private JTableHeader HActivities;
    private JScrollPane scrCalendar, scrActivities, scrSummary;
    private DefaultTableCellRenderer RwLeft, RwRight;
    JComboBox<String> cmbActivity;
    private JButton btnPrev, btnNext;
    
    public Admin_Dashboard() {
        setLayout(null);
        setBounds(0, 0, 1620, 930);
        
        //Main Panel
        pnlMain = new JPanel();
        pnlMain.setLayout(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);
        
        lblOverview = new JLabel("Hospital Overview");
        lblOverview.setBounds(30, 20, 400, 40);
        lblOverview.setFont(new Font("Calibri", Font.BOLD, 24));
        lblOverview.setForeground(Color.BLACK);
        pnlMain.add(lblOverview);
        
        lblDT = new JLabel("May 21, 2026 | 10:00 AM");
        lblDT.setFont(new Font("Calibri", Font.BOLD, 18));
        lblDT.setForeground(Color.darkGray);
        lblDT.setBounds(1390, 20, 400, 40);
        pnlMain.add(lblDT);
        
        tabItem = createTab("Total Patients", "0", darkBlue);
        tabItem.setBounds(30, 80, 350, 120);
        pnlMain.add(tabItem);
        lblTItem = (JLabel) tabItem.getComponent(1);
        
        tabLows = createTab("Today's Appointment", "0", Yellow);
        tabLows.setBounds(400, 80, 350, 120);
        pnlMain.add(tabLows);
        lblLStock = (JLabel) tabLows.getComponent(1);
        
        tabMed = createTab("Critical Patients","0", LightRed);
        tabMed.setBounds(770, 80, 350, 120);
        pnlMain.add(tabMed);
        lblMed = (JLabel) tabMed.getComponent(1);
        
        tabSup = createTab("Total number of Doctors", "0", Blue);
        tabSup.setBounds(30, 220, 350, 120);
        pnlMain.add(tabSup);
        lblSup = (JLabel) tabSup.getComponent(1);
        
        tabEq = createTab("Total number of Nurses", "0", orange);
        tabEq.setBounds(400, 220, 350, 120);
        pnlMain.add(tabEq);
        lblEq = (JLabel) tabEq.getComponent(1);
        
        tabValue = createTab("Pending Deliveries", "0", Green);
        tabValue.setBounds(770, 220, 350, 120);
        pnlMain.add(tabValue);
        lblActive = (JLabel) tabValue.getComponent(1);
        
        btnPrev = new JButton("<");
        btnPrev.setBounds(1140, 80, 50, 50);
        btnPrev.setFont(new Font("Calibri", Font.BOLD, 18));
        btnPrev.setBackground(darkBlue);
        btnPrev.setForeground(Color.WHITE);
        btnPrev.setFocusPainted(false);
        pnlMain.add(btnPrev);
                
        lblMonth = new JLabel("May 2026", SwingConstants.CENTER);
        lblMonth.setFont(new Font("Calibri", Font.BOLD, 24));
        lblMonth.setBounds(1190, 80, 350, 50);
        lblMonth.setOpaque(true);
        lblMonth.setBackground(darkBlue);
        lblMonth.setForeground(Color.WHITE);
        pnlMain.add(lblMonth);
        
        btnNext = new JButton(">");
        btnNext.setBounds(1540, 80, 50, 50);
        btnNext.setFont(new Font("Calibri", Font.BOLD, 18));
        btnNext.setBackground(darkBlue);
        btnNext.setForeground(Color.WHITE);
        btnNext.setFocusPainted(false);
        pnlMain.add(btnNext);
        
        String [] days = {"Mon", "Tues", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String[][] DateNum = {{"", "", "", "", "1", "2", "3"},
                              {"4", "5", "6", "7", "8", "9", "10"},
                              {"11", "12", "13", "14", "15", "16", "17"},
                              {"18", "19", "20", "21", "22", "23", "24"},
                              {"25", "26", "27", "28", "29", "30", "31"}};
        
        tblCalendar = new JTable(DateNum, days);
        tblCalendar.setRowHeight(60);
        tblCalendar.setFont(new Font("Calibri", Font.PLAIN, 18));
        tblCalendar.setGridColor(Color.LIGHT_GRAY);
        tblCalendar.setBackground(Color.WHITE);
        tblCalendar.setSelectionBackground(SBlue);
        tblCalendar.setSelectionForeground(Color.WHITE);
        
        scrCalendar = new JScrollPane(tblCalendar);
        scrCalendar.setBounds(1140, 130, 450, 300);
        pnlMain.add(scrCalendar);
        
        pnlActivity = new JPanel();
        pnlActivity.setLayout(null);
        pnlActivity.setBounds(30, 360, 1090, 550);
        pnlActivity.setBackground(Color.WHITE);
        pnlMain.add(pnlActivity);
        
        lblActivity = new JLabel("Inventory");
        lblActivity.setBounds(20, 20, 300, 30);
        lblActivity.setFont(new Font("Calibri", Font.BOLD, 24));
        pnlActivity.add(lblActivity);
        
        String[] clmActivities = {"Category", "Item", "Quantity", "Status"};
        
        String[][] RwActivities = {
            {"Medicine", "Paracetamol", "200", "Delivered"},
            {"Supplies", "Surgical Masks", "100", "Requested"},
            {"Equipment", "IV Stand", "5", "Pending"},
            {"Medicine", "IV Fluids", "50", "Requested"},
            {"Supplies", "Gloves", "500", "Delivered"},
            {"Medicine", "Antibiotics", "120", "Pending"}
            };
        
        tblActivities = new JTable(RwActivities, clmActivities);
        tblActivities.setFont(new Font("Calibri", Font.PLAIN, 16));
        tblActivities.setRowHeight(30);
        tblActivities.setGridColor(Color.LIGHT_GRAY);
        tblActivities.setBackground(Color.WHITE);
        
        HActivities = tblActivities.getTableHeader();
        HActivities.setBackground(lightBlue);
        HActivities.setFont(new Font("Calibri", Font.BOLD, 14));
        HActivities.setForeground(Color.BLACK);
        
        scrActivities = new JScrollPane(tblActivities);
        scrActivities.setBounds(20, 70, 1050, 460);
        pnlActivity.add(scrActivities);
        
        pnlSummary = new JPanel();
        pnlSummary.setLayout(null);
        pnlSummary.setBounds(1140, 450, 450, 460);
        pnlSummary.setBackground(Color.WHITE);
        pnlMain.add(pnlSummary);

        lblSummary = new JLabel("Staff Status");
        lblSummary.setBounds(20, 20, 300, 30);
        lblSummary.setFont(new Font("Calibri", Font.BOLD, 24));
        pnlSummary.add(lblSummary);

        String[] clmStaff = {"Role", "Name", "Status"};

        String[][] RwStaff = {
            {"Doctor", "Dr. Santos", "Active"},
            {"Doctor", "Dr. Ramirez", "On Leave"},
            {"Doctor", "Dr. Cruz", "Inactive"},
            {"Nurse", "Nurse Maria Lopez", "Active"},
            {"Nurse", "Nurse John Reyes", "On Leave"},
            {"Nurse", "Nurse Angela Torres", "Inactive"}
        };

        tblSummary = new JTable(RwStaff, clmStaff);
        tblSummary.setFont(new Font("Calibri", Font.PLAIN, 18));
        tblSummary.setRowHeight(40);
        tblSummary.setGridColor(Color.LIGHT_GRAY);
        tblSummary.setBackground(Color.WHITE);

        tblSummary.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 16));
        tblSummary.setBackground(lightBlue);
        tblSummary.getTableHeader().setForeground(Color.BLACK);

        DefaultTableCellRenderer RwLeft = new DefaultTableCellRenderer();
        RwLeft.setHorizontalAlignment(SwingConstants.LEFT);

        DefaultTableCellRenderer RwCenter = new DefaultTableCellRenderer();
        RwCenter.setHorizontalAlignment(SwingConstants.CENTER);
        RwCenter.setFont(new Font("Calibri", Font.BOLD, 20));

        tblSummary.getColumnModel().getColumn(0).setCellRenderer(RwLeft);
        tblSummary.getColumnModel().getColumn(1).setCellRenderer(RwLeft);
        tblSummary.getColumnModel().getColumn(2).setCellRenderer(RwCenter);

        tblSummary.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int col) {
                JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                cell.setFont(new Font("Calibri", Font.BOLD, 20));
                String val = value.toString();
                if (val.equalsIgnoreCase("Active")) {
                    cell.setForeground(new Color(0x2E8B57));
                } else if (val.equalsIgnoreCase("Inactive")) {
                    cell.setForeground(Color.RED);
                } else if (val.equalsIgnoreCase("On Leave")) {
                    cell.setForeground(Color.ORANGE);
                } else {
                    cell.setForeground(Color.GRAY);
                }
                return cell;
            }
        });

        scrSummary = new JScrollPane(tblSummary);
        scrSummary.setBounds(20, 70, 400, 350);
        scrSummary.setBorder(BorderFactory.createEmptyBorder());
        pnlSummary.add(scrSummary);

        setVisible(true);
    }
    
    private JPanel createTab(String title, String value, Color color) {
        tabUpdate = new JPanel();
        tabUpdate.setLayout(null);
        tabUpdate.setBackground(color);
        
        lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(20, 20, 250, 25);
        tabUpdate.add(lblTitle);
        
        lblValue = new JLabel(value);
        lblValue.setFont(new Font("Calibri", Font.BOLD, 28));
        lblValue.setForeground(Color.WHITE);
        lblValue.setBounds(20, 50, 150, 40);
        tabUpdate.add(lblValue);
        
        return tabUpdate;
    }
    
}
