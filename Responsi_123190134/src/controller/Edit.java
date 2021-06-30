package controller;

import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import responsi_123190134.Barang;

public class Edit {
    public boolean Edit(Barang bar) {
    String query = "UPDATE `barang` SET `nama`=?,`massa`=?,`harga`=? WHERE `id`=?";
    PreparedStatement ps;
     System.out.println("idEdit " + bar.getId());
     try {
      DBConnection dbconnection = new DBConnection();
      ps = dbconnection.getConnection().prepareStatement(query);
      ps.setString(1, bar.getnama());
      ps.setInt(2, bar.getmassa());
      ps.setInt(3, bar.getharga());
      ps.setString(4, bar.getId());
      int i = ps.executeUpdate();

      return i == 1;
      
    } catch (SQLException ex) {
      Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}

