package controller;
import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import responsi_123190134.ReadGUI;

public class Hitung_Baris {
    public int hitungbaris() {
    DBConnection dbconnection = new DBConnection();
    PreparedStatement ps;
    ResultSet rs;
    int  n = 0;
    try {
      String query = "Select * from `barang`";
      ps = dbconnection.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      while (rs.next()) {
        n++;
      }
      return n ;

    } catch (SQLException ex) {
      Logger.getLogger(ReadGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -4;
  }
}
