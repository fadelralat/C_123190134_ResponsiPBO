package controller;
import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import responsi_123190134.ReadGUI;

public class Read {
    public String[][] readAllData() {
    Hitung_Baris cr = new Hitung_Baris();
    String data[][] = new String[cr.hitungbaris()][4];

    try {
      DBConnection dbconnection = new DBConnection();
      PreparedStatement ps;
      ResultSet rs;

      String query = "Select * from `barang`";
      ps = dbconnection.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      int n = 0;
      while (rs.next()) {
        data[n][0] = rs.getString(1);
        data[n][1] = rs.getString(2);
        data[n][2] = rs.getString(3);
        data[n][3] = rs.getString(4);
        n++;
      }
      return data;
    } catch (SQLException ex) {
      System.out.println("Read Data Gagal");
      Logger.getLogger(ReadGUI.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
}
