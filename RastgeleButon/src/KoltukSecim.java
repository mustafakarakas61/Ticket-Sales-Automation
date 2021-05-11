import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KoltukSecim extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KoltukSecim frame = new KoltukSecim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KoltukSecim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel w_panePerde = new JPanel();
		w_panePerde.setBackground(SystemColor.desktop);
		w_panePerde.setBounds(11, 9, 1064, 87);
		contentPane.add(w_panePerde);
		w_panePerde.setLayout(null);
		
		JLabel lbl_Sahne = new JLabel("PERDE");
		lbl_Sahne.setBackground(SystemColor.desktop);
		lbl_Sahne.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Sahne.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 42));
		lbl_Sahne.setBounds(0, 0, 1064, 87);
		w_panePerde.add(lbl_Sahne);
		
		JPanel w_paneKoltuk = new JPanel();
		w_paneKoltuk.setBackground(SystemColor.activeCaption);
		w_paneKoltuk.setBounds(10, 100, 1065, 406);
		contentPane.add(w_paneKoltuk);
		w_paneKoltuk.setLayout(null);
		
		JButton btn_Onayla = new JButton("Onayla");
		btn_Onayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btn_Onayla.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btn_Onayla.setBounds(500, 517, 89, 33);
		contentPane.add(btn_Onayla);
	}
}
