import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class CheckIn {
    
    calendar calendar2;
    int id;
    String typedoc, identification, names, resident, reason,date;
    
    public CheckIn() {
        calendar2 = new calendar();
    }
    
    public CheckIn(calendar calendar_c, int id_c, String typedoc_c, String identification_c, 
            String namesc, String resident_c, String reason_c, String date_c) {
        this.calendar2 = calendar_c;
        this.id = id_c;
        this.typedoc = typedoc_c;
        this.identification = identification_c;
        this.names = namesc;
        this.resident = resident_c;
        this.reason = reason_c;
        this.date = date_c;
    }

    public calendar getCalendar() {
        return calendar2;
    }

    public int getId() {
        return id;
    }

    public String getTypeDoc() {
        return typedoc;
    }

    public String getIdentification() {
        return identification;
    }

    public String getNames() {
        return names;
    }

    public String getResident() {
        return resident;
    }

    public String getReason() {
        return reason;
    }

    public String getDate() {
        return date;
    }

    public void setCalendario(calendar calendar2) {
        this.calendar2 = calendar2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoDocumento(String typedoc2) {
        this.typedoc = typedoc2;
    }

    public void setIdentificacion(String  identication2) {
        this.identification =  identication2;
    }

    public void setNombres(String name2) {
        this.names = name2;
    }

    public void setResidente(String residentt2) {
        this.resident = residentt2;
    }

    public void setMotivo(String reason2) {
        this.reason = reason2;
    }

    public void setFecha(String date2) {
        this.date = date2;
    }

    
    public boolean agregar() {
        String sql = "INSERT INTO persona VALUES(?, ?, ?, ?, ?, ?, ?);";
        DatabaseAccess.ConnectionDatabase();
        try {
            PreparedStatement ps = DatabaseAccess.c.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, typedoc);
            ps.setString(3, identification);
            ps.setString(4, names);
            ps.setString(5, calendar2.getFecha());
            ps.setString(6, resident);
            ps.setString(7, reason);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int id) {
        String sql = "UPDATE persona SET Tipo_documento=?, Identificacion=?, Nombres=?, Fecha=?, Residente=?, "
                + "Motivo=? WHERE id = " + id + ";";
        DatabaseAccess.ConnectionDatabase();

        try {
            PreparedStatement ps = DatabaseAccess.c.prepareStatement(sql);

            ps.setString(1, typedoc);
            ps.setString(2, identification);
            ps.setString(3, names);
            ps.setString(4, date);
            ps.setString(5, resident);
            ps.setString(6, reason);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
            e.printStackTrace();
            return false;
        }
    }
   
    public int GetId() {
        int v = 0;
        String Mysql = "SELECT id FROM persona;";
        DatabaseAccess.ConnectionDatabase();
        try {
            PreparedStatement ps = DatabaseAccess.c.prepareStatement(Mysql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                v = rs.getRow();
            }
        } catch (SQLException ex) {
        }
        return v;
    }
    public boolean remove(int d) {
        String sql = "DELETE FROM persona WHERE id = " + d + ";";
        DatabaseAccess.ConnectionDatabase();

        try {
            PreparedStatement p = DatabaseAccess.c.prepareStatement(sql);

            p.executeUpdate();
            p.close();
            return true;
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error");
            e.printStackTrace();
            return false;
        }
    }

    public static ResultSet getData() {
        String sql = "SELECT * FROM persona;";
        DatabaseAccess.ConnectionDatabase();
        ResultSet resultado = DatabaseAccess.RunMysqlSelect(sql);
        return resultado;
    }

 

}


