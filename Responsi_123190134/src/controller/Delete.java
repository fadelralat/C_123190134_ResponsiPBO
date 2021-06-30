package controller;

import database.DBConnection;
import responsi_123190134.Barang;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Delete {
  public boolean deletedata(Barang bar){
    String query = "DELETE FROM `barang` WHERE `id`=?";
    PreparedStatement ps;

     try {
      DBConnection dbconnection = new DBConnection();
      ps = dbconnection.getConnection().prepareStatement(query);
      ps.setString(1, bar.getId());

      int i = ps.executeUpdate();

      return i == 1;
      
    } catch (SQLException ex) {
      Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
