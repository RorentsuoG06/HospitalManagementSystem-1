package Prescriptions;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class admin_Prescription extends JPanel implements ActionListener {

    private JButton btnDelete;
    private JTable table;
    private JScrollPane sp;
    private JPanel pnlPrescriptionTable;
    private JLabel lblPrescription;
    private DefaultTableModel model;

    public admin_Prescription() {

        setLayout(null);
        setBounds(0, 0, 1620, 930);

        pnlPrescriptionTable = new JPanel(null);
        pnlPrescriptionTable.setBounds(70, 400, 1060, 500);
        pnlPrescriptionTable.setBackground(Color.WHITE);
        add(pnlPrescriptionTable);

        lblPrescription = new JLabel("Prescription Management");
        lblPrescription.setBounds(20, 20, 400, 30);
        lblPrescription.setFont(new Font("Calibri", Font.BOLD, 24));
        pnlPrescriptionTable.add(lblPrescription);

        String[] col = {"Patient", "Drug", "Dosage", "Frequency", "Duration"};

        model = new DefaultTableModel(col, 0);

        model.addRow(new String[]{
            "John Doe",
            "Paracetamol",
            "500mg",
            "2x/day",
            "5 days"
        });

        table = new JTable(model);
        table.setRowHeight(30);

        sp = new JScrollPane(table);
        sp.setBounds(20, 70, 1020, 300);
        pnlPrescriptionTable.add(sp);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(450, 400, 150, 40);
        btnDelete.setBackground(new Color(0x6F, 0xA8, 0xDC));
        btnDelete.setForeground(Color.WHITE);
        pnlPrescriptionTable.add(btnDelete);

        btnDelete.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnDelete) {

            int row = table.getSelectedRow();

            if (row >= 0) {

                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Select a row first!"
                );
     }
   }
}
}