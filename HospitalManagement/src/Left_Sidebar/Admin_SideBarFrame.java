/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Left_Sidebar;

import static Color_Palette.ColorPalette.*;
import Dashboard.Admin_Dashboard;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jm's Laptop
 */
public class Admin_SideBarFrame extends JFrame{
     
    private JPanel window;
    private JPanel header;
    private JTextField txtSearch;
    private JLabel lblAdminName, lblAdminIcon;
    private ImageIcon imgAdmin;
    
     public Admin_SideBarFrame() {
        setTitle("eTriage | Hospital Management System");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
     
        // Sidebar
        Admin_Sidebar sidebar = new Admin_Sidebar(this);
        sidebar.setBounds(0, 0, 300, 1080); 
        add(sidebar);
        
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(300, 0, 1620, 70);
        header.setBackground(lightBlue);
        add(header);
        
        txtSearch = new JTextField("Search...");
        txtSearch.setBounds(970, 18, 260, 35);
        txtSearch.setFont(new Font("Calibri", Font.PLAIN, 18));
        header.add(txtSearch);
        
        lblAdminName = new JLabel("Admin | John Smith");
        lblAdminName.setFont(new Font("Calibri", Font.BOLD, 20));
        lblAdminName.setBounds(1320, 20, 300, 35);
        header.add(lblAdminName);
        
        imgAdmin = new ImageIcon(getClass().getResource("/resources/ADMIN.PHOTO.png"));
        Image imgDoc = imgAdmin.getImage();
        Image imgDocScaled = imgDoc.getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        lblAdminIcon = new JLabel(new ImageIcon(imgDocScaled));
        lblAdminIcon.setBounds(1250, 13, 60, 60);
        header.add(lblAdminIcon);

        // Main content area
        window = new JPanel();
        window.setLayout(null);
        window.setBounds(300, 70, 1620, 930);
        window.setBackground(LightGray);
        add(window);

        turnPage(new Admin_Dashboard());
    }

    public void turnPage(JPanel newPage) {
        window.removeAll();
        newPage.setBounds(0, 0, 1620, 930);
        window.add(newPage);
        window.revalidate();
        window.repaint();
    }
}
