
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Mall extends JFrame {

    JPanel PanelDown, panelCenter, PanelUp;

    JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollTable;

    JTextField idTF;
    JTextField TypeDocTF;
    JTextField identificationTF;
    JTextField names;
    JTextField residentTF;
    JTextField reasonTF;
    JTextField dateTF;

    JLabel idL;
    JLabel typeDocL;
    JLabel identificationL;
    JLabel nameL;
    JLabel residentL;
    JLabel reasonL;
    JLabel dateL;

    JButton addButton;
    JButton UpdateButton;
    JButton removeButton;
    JButton cleanButton;

    String[] columns;
    String data[][];
    calendar calendar;

    public Mall() {
        super("Mall/ITL/TAP/DIAZ CERVERA BRIAN NOE");
        this.setLayout(new GridLayout(3, 2));

        initComponents();
        addComponents();
        lauchFrame();
    }

    public final void initComponents() {
        columns = new String[]{"Document type", "Identification", "Names", "Visit to", "Reason", "Date"};
        data = new String[][]{};

        calendar = new calendar();

        PanelDown = new JPanel();
        panelCenter = new JPanel(new GridLayout(3, 4));
        PanelUp = new JPanel(new GridLayout(3, 2));

        idTF = new JTextField();
        idTF.enable(false);
        TypeDocTF = new JTextField();
        identificationTF = new JTextField();
        names = new JTextField();
        residentTF = new JTextField();
        reasonTF = new JTextField();
        dateTF = new JTextField();
        dateTF.enable(false);

        typeDocL = new JLabel("DOCUMENT TYPE");
        identificationL = new JLabel("PERSONAL IDENTIFICATION");
        nameL = new JLabel("NAMES");
        residentL = new JLabel("VISIT TO");
        reasonL = new JLabel("REASON");
        dateL = new JLabel("DATE");

        addButton = new JButton("ADD");
        removeButton = new JButton("REMOVE");
        UpdateButton = new JButton("TO UPDATE");
        cleanButton = new JButton("CLEAR");

        //Add table to controls
        dtm = new DefaultTableModel(columns, 0);
        table = new JTable(dtm);
        scrollTable = new JScrollPane(table);

        try {
            ResultSet rs = CheckIn.getData();
            ResultSetMetaData metaDatos = rs.getMetaData();
            int cols = metaDatos.getColumnCount();

            Object[] etiquetas = new Object[cols];
            for (int i = 0; i < cols; i++) {
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }

            dtm.setColumnIdentifiers(etiquetas);
            table.setAutoCreateRowSorter(true);
            table.setShowGrid(true);
            table.setPreferredScrollableViewportSize(new Dimension(370, 70));
        
            while (rs.next()) {
                Object[] row = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                dtm.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
        }

        table.addKeyListener(new KeyAdapter() {
            public void keyAdapter(KeyEvent e) {
                int row = table.getSelectedRow();
                showTableLine(row);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                showTableLine(row);
            }

            public void keyRelased(KeyEvent e) {
                int row = table.getSelectedRow();
                showTableLine(row);
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                showTableLine(row);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });

        //Process the remove button press
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRow();
            }
        });

        //Process the save button press
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRow();
            }
        });

        //Process the save button press
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanfields();
            }
        });
    }

    public final void addComponents() {
        PanelDown.add(scrollTable, BorderLayout.NORTH);
        panelCenter.add(typeDocL);
        panelCenter.add(TypeDocTF);
        panelCenter.add(identificationL);
        panelCenter.add(identificationTF);
        panelCenter.add(nameL);
        panelCenter.add(names);
        panelCenter.add(residentL);
        panelCenter.add(residentTF);
        panelCenter.add(reasonL);
        panelCenter.add(reasonTF);
        
        addButton.setBackground(Color.green);
        PanelUp.add(addButton);
        
        removeButton.setBackground(Color.red);
        PanelUp.add(removeButton);
        
        cleanButton.setBackground(Color.PINK);
        PanelUp.add(cleanButton);
        
        UpdateButton.setBackground(Color.cyan);
        PanelUp.add(UpdateButton);
        
        
        
        add(PanelUp, BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);
        add(PanelDown, BorderLayout.NORTH);
       
    }

    public final void lauchFrame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(395, 330);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
    }

    public void showTableLine(int renglon) {
        Object value = table.getValueAt(renglon, 1);
        if (value != null) {
            idTF.setText(table.getValueAt(renglon, 0).toString());
            TypeDocTF.setText(table.getValueAt(renglon, 1).toString());
            identificationTF.setText(table.getValueAt(renglon, 2).toString());
            names.setText(table.getValueAt(renglon, 3).toString());
            dateTF.setText(table.getValueAt(renglon, 4).toString());
            residentTF.setText(table.getValueAt(renglon, 5).toString());
            reasonTF.setText(table.getValueAt(renglon, 6).toString());
        } else {
            JOptionPane.showMessageDialog(null,"Select valid line");
        }
    }

    public void AddInTable(int temp) {
        Object row[] = {String.valueOf(temp),
            TypeDocTF.getText(),
            identificationTF.getText(),
            names.getText(),
            calendar.getFecha(),
            residentTF.getText(),
            reasonTF.getText()
        };

        dtm.addRow(row);
    }

    public void Removeintable(int renglon) {
        dtm.removeRow(renglon);
    }

    public void UpdateTable(Integer id, String typeDoc, String identification, String names,
            String resident, String reason, String date) {
        int row = dtm.getRowCount();
        for (int i = 0; i < row; i++) {

            if (dtm.getValueAt(i, 0).equals(id)) {
                table.setValueAt(typeDoc, i, 1);
                table.setValueAt(identification, i, 2);
                table.setValueAt(names, i, 3);
                table.setValueAt(date, i, 4);
                table.setValueAt(resident, i, 5);
                table.setValueAt(reason, i, 6);

                break;
            }
        }
    }

    public void cleanfields() {
        idTF.setText("");
        TypeDocTF.setText("");
        identificationTF.setText("");
        names.setText("");
        residentTF.setText("");
        reasonTF.setText("");
        dateTF.setText("");
    }

    private void addRow() {
        try {
            CheckIn p = new CheckIn();
            int newID = p.GetId() + 1;

            p.setId(newID);
            p.setTipoDocumento(TypeDocTF.getText());
            p.setIdentificacion(identificationTF.getText());
            p.setNombres(names.getText());
            p.setFecha(calendar.getFecha());
            p.setResidente(residentTF.getText());
            p.setMotivo(reasonTF.getText());

            AddInTable(newID);
            p.agregar();
            cleanfields();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    private void editRow() {
        int id = Integer.parseInt(idTF.getText());

        CheckIn p = new CheckIn();
        p.setTipoDocumento(TypeDocTF.getText());
        p.setIdentificacion(identificationTF.getText());
        p.setNombres(names.getText());
        p.setFecha(calendar.getFecha());
        p.setResidente(residentTF.getText());
        p.setMotivo(reasonTF.getText());

        p.update(id);
        UpdateTable(id, TypeDocTF.getText(), identificationTF.getText(), names.getText(),
                calendar.getFecha(), residentTF.getText(), reasonTF.getText());
        cleanfields();
    }

    private void removeRow() {
        int selectedRow = table.getSelectedRow();
        
        if (selectedRow >= 0) {
            CheckIn p = new CheckIn();
            p.remove(Integer.valueOf(idTF.getText()));
            Removeintable(selectedRow);
            cleanfields();

            JOptionPane.showMessageDialog(null, "Successfully removed");
        } else {
            JOptionPane.showMessageDialog(null,"Select nothing to delete");
        }
    }

    public static void main(String[] args) {
        Mall runMall = new Mall();
    }
}
