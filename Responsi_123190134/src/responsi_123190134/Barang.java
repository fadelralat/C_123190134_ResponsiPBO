package responsi_123190134;

import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barang {
    private int massa, harga;
    private String id, nama;

    public void setBarang(String nama, int massa, int harga) {
        this.nama = nama;
        this.massa = massa;
        this.harga = harga;
    }

public String getId() {
    return id;
  }    

public String getnama() {
    return nama;
  }

  public int getmassa() {
    return massa;
  }

  public int getharga() {
    return harga;
  }
  
  public void getData(String id) {
    DBConnection dbconnection = new DBConnection();
    PreparedStatement ps;
    ResultSet rs;

    String query = "Select * from `barang` WHERE id=?";

    try {
      ps = dbconnection.getConnection().prepareStatement(query);
      ps.setString(1, id);
      rs = ps.executeQuery();

      if (rs.next()) {
        this.id = id;
        this.nama = rs.getString(2);
        this.massa = rs.getInt(3);
        this.harga = rs.getInt(4);
      }

    } catch (SQLException ex) {
      System.out.println("Data tidak ditemukan");
      Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

public String hitungDiscount(int jml,int harga){
    if(jml < 12){
      harga = harga * jml;
    } else if (jml < 20) {
      harga = jml * harga - (jml * harga * 5 / 100);
    } else if (jml < 144) {
      harga = jml * harga - (jml * harga * 10 / 100);
    } else {
      harga = jml * harga - (jml * harga * 25 / 100);
    }
    return String.valueOf(harga);
  }
    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}