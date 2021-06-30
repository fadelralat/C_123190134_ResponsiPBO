package responsi_123190134;
import database.DBConnection;

public class Responsi_123190134 {
    public static void main(String[] args) {
    DBConnection dbconnection = new DBConnection();
    if(dbconnection.getConnection() == null){
    }else{
      new MenuGUI();
    }
    }    
}
