package Prescriptions;

import static Color_Palette.ColorPalette.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class nurse_Prescription extends JPanel {

    private JPanel pnlMain;
    private JTable table;
    private DefaultTableModel model;
   private JTextField txtFreq;
   private JTextField txtDur;
    private JButton btnUpdate;

    public nurse_Prescription() {

        setLayout(null);
        setBackground(veryLightBlue);

        pnlMain = new JPanel(null);
        pnlMain.setBackground(veryLightBlue);
        pnlMain.setBounds(0, 0, 1620, 930);
        add(pnlMain);

        JLabel lblMainTitle = new JLabel("Nurse Prescription");
        lblMainTitle.setBounds(60, 35, 400, 40);
        lblMainTitle.setFont(new Font("Calibri", Font.BOLD, 34));
        pnlMain.add(lblMainTitle);

        createCard(
                pnlMain,
                "Patients Assigned",
                "24",
                LightRed,
                60,
                110
        );

        createCard(
                pnlMain,
                "Today's Tasks",
                "12",
                Blue,
                350,
                110
        );

        createCard(
                pnlMain,
                "Medication Schedule",
                "8",
                Yellow,
                640,
                110
        );

        createCard(
                pnlMain,
                "Critical Cases",
                "3",
                Green,
                930,
                110
        );

        JPanel pnlPrescription = new JPanel(null);
        pnlPrescription.setBounds(60, 270, 1130, 540);
        pnlPrescription.setBackground(Color.WHITE);
        pnlPrescription.setBorder(
                BorderFactory.createLineBorder(
                        new Color(220, 220, 220)
                )
        );

        pnlMain.add(pnlPrescription);

        JLabel lblPrescriptionTitle =
                new JLabel("Prescription Management");

        lblPrescriptionTitle.setFont(
                new Font("Calibri", Font.BOLD, 28)
        );

        lblPrescriptionTitle.setBounds(30, 20, 400, 35);
        pnlPrescription.add(lblPrescriptionTitle);
        
        String[] col = {
            "Patient",
            "Drug",
            "Dosage",
            "Frequency",
            "Duration"
        };

        model = new DefaultTableModel(col, 0);

        model.addRow(new String[]{
            "John Doe",
            "Paracetamol",
            "500mg",
            "2x/day",
            "5 days"
        });

        model.addRow(new String[]{
            "Jane Smith",
            "Amoxicillin",
            "250mg",
            "3x/day",
            "7 days"
        });

        table = new JTable(model);
        table.setRowHeight(32);
        table.setFont(new Font("Calibri", Font.PLAIN, 16));
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Calibri", Font.BOLD, 16));
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30, 80, 1070, 260);
        pnlPrescription.add(sp);


        JLabel lblFreq = new JLabel("Frequency");
        lblFreq.setBounds(250, 390, 100, 25);
        lblFreq.setFont(new Font("Calibri", Font.BOLD, 18));
        pnlPrescription.add(lblFreq);

        txtFreq = new JTextField();
        txtFreq.setBounds(250, 420, 180, 38);
        txtFreq.setFont(new Font("Calibri", Font.PLAIN, 16));
        pnlPrescription.add(txtFreq);

        JLabel lblDur = new JLabel("Duration");
        lblDur.setBounds(500, 390, 100, 25);
        lblDur.setFont(new Font("Calibri", Font.BOLD, 18));
        pnlPrescription.add(lblDur);
        
        txtDur = new JTextField();
        txtDur.setBounds(500, 420, 180, 38);
        txtDur.setFont(new Font("Calibri", Font.PLAIN, 16));
        pnlPrescription.add(txtDur);

        btnUpdate = new JButton("Update Prescription");
        btnUpdate.setBounds(430, 485, 250, 42);
        btnUpdate.setBackground(Blue);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFont(new Font("Calibri", Font.BOLD, 18));
        pnlPrescription.add(btnUpdate);
        
        table.getSelectionModel().addListSelectionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                txtFreq.setText(
                        model.getValueAt(row, 3).toString()
                );

                txtDur.setText(
                        model.getValueAt(row, 4).toString()
                );
            }
        });

        btnUpdate.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                model.setValueAt(
                        txtFreq.getText(),
                        row,
                        3
                );

                model.setValueAt(
                        txtDur.getText(),
                        row,
                        4
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Prescription updated successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Please select a patient first!"
                );
            }
        });
    }
    
    private void createCard(
            JPanel parent,
            String title,
            String count,
            Color bg,
            int x,
            int y
    ) {
        JPanel card = new JPanel(null);
        card.setBounds(x, y, 250, 120);
        card.setBackground(bg);
        JLabel lblTitle = new JLabel(title);
        lblTitle.setBounds(15, 15, 220, 25);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 20));
        card.add(lblTitle);

        JLabel lblCount = new JLabel(count);
        lblCount.setBounds(175, 58, 80, 40);
        lblCount.setForeground(Color.WHITE);
        lblCount.setFont(new Font("Calibri", Font.BOLD, 30));
        card.add(lblCount);
        parent.add(card);
    }    
}