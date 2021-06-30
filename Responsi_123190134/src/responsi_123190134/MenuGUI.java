package responsi_123190134;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuGUI extends JFrame{
  JFrame frame = new JFrame("");

  JButton btnInput = new JButton("Tambah Barang");
  JButton btnRead = new JButton("Lihat Barang");
  
  JLabel Title1 = new JLabel("Main Menu");
  
  public MenuGUI(){
    frame.setLayout(null);
    frame.setSize(350, 150);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    frame.add(btnInput);
    frame.add(btnRead);
    frame.add(Title1);
    
    Title1.setBounds(130, 5, 200, 30);
    btnInput.setBounds(100, 30, 130, 30);
    btnRead.setBounds(90, 70, 150, 30);
    
    btnInput.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new InputGUI();

    });
    btnRead.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new ReadGUI();
    });
  }  
}
