import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class AddSalon extends JFrame {

    private JPanel contentPane;
    private JTextField txt_Salon;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddSalon frame = new AddSalon();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public AddSalon() {
    	setResizable(false);
    	setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 274, 192);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_SalonName = new JLabel("Salon Ad\u0131:");
        lbl_SalonName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl_SalonName.setBounds(28, 50, 82, 14);
        contentPane.add(lbl_SalonName);

        txt_Salon = new JTextField();
        txt_Salon.setBounds(115, 46, 112, 20);
        contentPane.add(txt_Salon);
        txt_Salon.setColumns(10);

        JButton btn_Ekle = new JButton("Ekle");
        btn_Ekle.setFont(new Font("Tahoma", Font.BOLD, 15));
        btn_Ekle.setBounds(84, 95, 89, 41);
        contentPane.add(btn_Ekle);
    }
}
