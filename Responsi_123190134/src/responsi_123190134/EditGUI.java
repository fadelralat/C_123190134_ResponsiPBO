package responsi_123190134;

import controller.Edit;
import database.DBConnection;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EditGUI {
  DBConnection dbconnection = new DBConnection();
  Barang bar = new Barang();
  
  JFrame frame = new JFrame("Edit Data Barang");
  JLabel lNama = new JLabel("Nama");
  JLabel lMassa = new JLabel("Massa (gr)");
  JLabel lHarga = new JLabel("Harga");

  JTextField tfNama = new JTextField(200);
  JTextField tfMassa = new JTextField();
  JTextField tfHarga = new JTextField();

  JButton btnEdit = new JButton("Edit");
  JButton btnReset = new JButton("Reset");
  JButton btnBack = new JButton("Kembali");
  
  Edit editan = new Edit();
  
  private void clearFields(){
      tfNama.setText(null);
      tfMassa.setText(null);
      tfHarga.setText(null);
  }
  
  public EditGUI(Barang bar) {
    frame.setLayout(null);
    frame.setSize(380, 200);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    frame.add(lNama);
    frame.add(lMassa);
    frame.add(lHarga);
    frame.add(tfMassa);
    frame.add(tfNama);
    frame.add(tfHarga);
    frame.add(btnEdit);
    frame.add(btnReset);
    frame.add(btnBack);

    lNama.setBounds(80, 20, 70, 20);
    lMassa.setBounds(80, 50, 70, 20);
    lHarga.setBounds(80, 80, 70, 20);

    tfNama.setBounds(170, 20, 120, 20);
    tfMassa.setBounds(170, 50, 120, 20);
    tfHarga.setBounds(170, 80, 120, 20);

    btnEdit.setBounds(240, 120, 80, 20);
    btnReset.setBounds(150, 120, 80, 20);
    btnBack.setBounds(60, 120, 80, 20);
    
    tfNama.setText(bar.getnama());
    tfMassa.setText(String.valueOf(bar.getmassa()));
    tfHarga.setText(String.valueOf(bar.getharga()));
    
    btnEdit.addActionListener((var arg0) -> {
      String nama = tfNama.getText();
      int massa = 0, harga = 0;;
      try {
        harga = Integer.valueOf(tfHarga.getText());
        massa = Integer.valueOf(tfMassa.getText());

        if (nama.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Kolom Nama Harap Di isi");
          tfNama.requestFocusInWindow();
        }else if(harga < 0 || massa < 0){
           JOptionPane.showMessageDialog(null,"Input Massa dan Harga Harus Bilangan Positif");
           tfMassa.requestFocus();
        }else{
          bar.setBarang(nama, massa, harga);
          if (editan.Edit(bar)) {
            frame.dispose();
            new ReadGUI();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
          }
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Pastikan Semua Kolom Sudah Di isi");
      }
    });

    btnReset.addActionListener((ActionEvent arg0) -> {
        clearFields();
    });
    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new ReadGUI();
    });
  }
}
