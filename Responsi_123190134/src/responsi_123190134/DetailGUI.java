package responsi_123190134;

import controller.Delete;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DetailGUI {
  Barang brg = new Barang();
  Delete delete = new Delete();
  
  JLabel LNama = new JLabel("Nama               :");
  JLabel LMassa = new JLabel("Massa (gr)      :");
  JLabel LHarga = new JLabel("Harga Satuan :");
  JLabel LJumlah = new JLabel("Banyak");

  JLabel LDataNama = new JLabel();
  JLabel LDataMassa = new JLabel();
  JLabel LDataHarga = new JLabel();
  JLabel LTotal = new JLabel("Total Harga");
  JLabel LHasilTotal = new JLabel();

  JTextField tfJumlah = new JTextField();
  
  JButton btnHapus = new JButton("Hapus");
  JButton btnEdit = new JButton("Edit");
  JButton btnBack = new JButton("Kembali");
  JButton btnTotalHarga = new JButton("Total Harga");
  
   public DetailGUI(Barang bar) {
    JFrame frame = new JFrame(bar.getnama());
    frame.setLayout(null);
    frame.setSize(380, 340);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.add(LNama);
    frame.add(LMassa);
    frame.add(LHarga);
    frame.add(LJumlah);
    frame.add(tfJumlah);
    frame.add(LDataMassa);
    frame.add(LDataNama);
    frame.add(LDataHarga);
    frame.add(LTotal);
    frame.add(LHasilTotal);
    frame.add(btnHapus);
    frame.add(btnEdit);
    frame.add(btnBack);
    frame.add(btnTotalHarga);

    LNama.setBounds(80, 20, 200, 30);
    LMassa.setBounds(80, 45, 100, 30);
    LHarga.setBounds(80, 70, 200, 30);
    LJumlah.setBounds(80, 100, 70, 30);
    LTotal.setBounds(80, 130, 70, 30);

    LDataNama.setBounds(170, 20, 120, 30);
    LDataMassa.setBounds(170, 45, 120, 30);
    LDataHarga.setBounds(170, 70, 120, 30);
    tfJumlah.setBounds(170, 100, 120, 30);
    LHasilTotal.setBounds(170, 130, 120, 30);

    btnHapus.setBounds(235, 260, 80, 20);
    btnEdit.setBounds(145, 260, 80, 20);
    btnBack.setBounds(55, 260, 80, 20);
    btnTotalHarga.setBounds(135, 220, 100, 20);
    
    //Memasukkan Data ke Label Masing - Masing
    LDataNama.setText(bar.getnama());
    LDataMassa.setText(String.valueOf(bar.getmassa()));
    LDataHarga.setText(String.valueOf(bar.getharga()));
    LHasilTotal.setVisible(false);
    LTotal.setVisible(false);
    
    btnHapus.addActionListener((ActionEvent arg0) -> {
      if(delete.deletedata(bar)){
        JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
      }else{
        JOptionPane.showMessageDialog(null, "Hapus Data Gagal");
      }
      frame.dispose();
      new ReadGUI();
    });

    btnEdit.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new EditGUI(bar);
    });
    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new ReadGUI();
    });
    btnTotalHarga.addActionListener((ActionEvent arg0) -> {
      try{
        int jumlah = Integer.valueOf(tfJumlah.getText());
        
        LHasilTotal.setText(brg.hitungDiscount(jumlah, bar.getharga()));
        LHasilTotal.setVisible(true);
        LTotal.setVisible(true);
      }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Pastikan Kolom Jumlah Sudah Di isi");
        tfJumlah.requestFocus();
      } 
    });

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.out.println("Closed");
      }
    });
   }
}