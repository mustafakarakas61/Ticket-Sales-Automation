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

public class SeatSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatSelection frame = new SeatSelection();
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
	public SeatSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel w_paneScreen = new JPanel();
		w_paneScreen.setBackground(SystemColor.desktop);
		w_paneScreen.setBounds(11, 9, 1064, 87);
		contentPane.add(w_paneScreen);
		w_paneScreen.setLayout(null);
		
		JLabel lbl_Screen = new JLabel("PERDE");
		lbl_Screen.setBackground(SystemColor.desktop);
		lbl_Screen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Screen.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 42));
		lbl_Screen.setBounds(0, 0, 1064, 87);
		w_paneScreen.add(lbl_Screen);
		
		JPanel w_paneSeat = new JPanel();
		w_paneSeat.setBackground(SystemColor.activeCaption);
		w_paneSeat.setBounds(10, 100, 1065, 406);
		contentPane.add(w_paneSeat);
		w_paneSeat.setLayout(null);
		
		JButton btn_Confirm = new JButton("Onayla");
		btn_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btn_Confirm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btn_Confirm.setBounds(500, 517, 89, 33);
		contentPane.add(btn_Confirm);
	}
}
