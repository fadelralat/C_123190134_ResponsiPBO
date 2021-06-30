package responsi_123190134;

import controller.Read;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ReadGUI {
  Barang bar = new Barang();
  Read r = new Read();
 
  JFrame frame = new JFrame("Lihat Data");
  JTable tabel;
  DefaultTableModel tableModel;
  JScrollPane scrollPane;
  Object namaKolom[] = {"Id", "Nama", "Massa", "Harga"};
  JButton btnBack = new JButton("Kembali");
  JButton btnPilih = new JButton("Pilih");
  
  JLabel LId = new JLabel("Pilih ID Barang : ");
  JTextField tfId = new JTextField(35);
  public ReadGUI() {
    frame.setLayout(null);
    frame.setSize(550, 460);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.add(btnBack);
    frame.add(btnPilih);
    frame.add(tfId);
    frame.add(LId);
 
    btnBack.setBounds(0, 400, 535, 20);
    btnPilih.setBounds(120, 350, 70, 20);
    
    LId.setBounds(20, 300, 120, 30);
    tfId.setBounds(120, 310, 70, 30);
    
    if(r.readAllData() == null){
      JOptionPane.showMessageDialog(null, "Tidak Ada Data");
      tabel = new JTable(null, namaKolom);
    }else{
      tabel = new JTable(r.readAllData(), namaKolom);
    }
    
    scrollPane = new JScrollPane(tabel);
    frame.add(scrollPane);

    scrollPane.setBounds(20, 0, 500, 300);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new MenuGUI();
    });
    btnPilih.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      
      String id = tfId.getText();
      bar.getData(id);
      new DetailGUI(bar);
    });
  }  

    ReadGUI(Barang bar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
