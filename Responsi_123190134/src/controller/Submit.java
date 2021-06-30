package controller;
import database.DBConnection;
import java.sql.PreparedStatement;
import responsi_123190134.Barang;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer Aspire
 */
public class Submit {
  public boolean Submit(Barang bar){
    
    DBConnection dbconnection = new DBConnection();
    PreparedStatement ps;    
    
    String query = "INSERT INTO `barang`(`nama`, `massa`, `harga`) VALUES (?,?,?)";
    
    try {
      ps = dbconnection.getConnection().prepareStatement(query);
      ps.setString(1, bar.getnama());
      ps.setInt(2, bar.getmassa());
      ps.setInt(3, bar.getharga());
      
      if (ps.executeUpdate() > 0) {        
        System.out.println("Input berhasil");
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Submit.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
}
