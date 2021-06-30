package responsi_123190134;
import database.DBConnection;
import controller.Submit;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class InputGUI {
  DBConnection dbconnection = new DBConnection();
  Submit submitan = new Submit();
  Barang bar = new Barang();
  
  JFrame frame = new JFrame("Input Barang");
  JLabel LInput = new JLabel("Input Barang");
  JLabel LNama = new JLabel("Nama");
  JLabel LMassa = new JLabel("Massa (gr)");
  JLabel LHarga = new JLabel("Harga Satuan");
  JTextField tfNama = new JTextField(35);
  JTextField tfMassa = new JTextField(35);
  JTextField tfHarga = new JTextField(35);
  
  JButton btnSubmit = new JButton("Submit");
  JButton btnReset = new JButton("Reset");
  JButton btnBack = new JButton("Kembali");
  
  Container container = new Container();

  private void clearFields(){
      tfNama.setText(null);
      tfMassa.setText(null);
      tfHarga.setText(null);
  }
  
  public InputGUI(){
    frame.setLayout(null);
    frame.setSize(380, 250);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.add(LInput);
    frame.add(LNama);
    frame.add(LMassa);
    frame.add(LHarga);
    
    frame.add(tfNama);
    frame.add(tfMassa);
    frame.add(tfHarga);
    
    frame.add(btnSubmit);
    frame.add(btnReset);
    frame.add(btnBack);
       
    LInput.setBounds(80, 10, 80, 30);
    LNama.setBounds(80, 40, 80, 20);
    tfNama.setBounds(160, 40, 130, 20);
    LMassa.setBounds(80, 70, 80, 20);
    tfMassa.setBounds(160, 70, 130, 20);
    LHarga.setBounds(80, 100, 80, 20);
    tfHarga.setBounds(160, 100, 130, 20);
    
    btnSubmit.setBounds(90, 150, 80, 20);
    btnReset.setBounds(190, 150, 80, 20);
    btnBack.setBounds(20, 180, 330, 20);
    
    btnSubmit.addActionListener((ActionEvent arg0) -> {
      String nama = tfNama.getText();
      int massa, harga;
      
      try {
        harga = Integer.valueOf(tfHarga.getText());
        massa = Integer.valueOf(tfMassa.getText());

        if (nama.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Kolom Nama Harap Di isi");
          tfNama.requestFocusInWindow();
        }else if(harga < 0 || massa < 0){
           JOptionPane.showMessageDialog(null,"Input Massa dan Harga Harus Bilangan Positif");
        }else{
            bar.setBarang(nama, massa, harga);
            if (submitan.Submit(bar)) {
                frame.dispose();
                new MenuGUI();
                JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
          } else {
                JOptionPane.showMessageDialog(null, "Tambah Data Gagal");
          }
        }
      } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null,"Pastikan Semua Kolom Sudah Di isi");
      }
    });
   
    btnReset.addActionListener((ActionEvent arg0) -> {
      clearFields();
    });
    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new MenuGUI();
    });
    }
}