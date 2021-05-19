import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.SeatHelper;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CancelTicket extends JFrame {
//comboBox_UserSeats.addItem(sh.getMemberSeat(mmbr.getID())+"");
	private JPanel contentPane;
	public static JLabel lbl_SeatsMember;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelTicket frame = new CancelTicket();
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
	public CancelTicket() {
		SeatHelper sh = new SeatHelper();
		Member  mmbr = new Member();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 262);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Info = new JLabel("Iptal etmek istediginiz koltugun numarasini secin:");
		lbl_Info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Info.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_Info.setBounds(10, 53, 414, 55);
		contentPane.add(lbl_Info);
		
		JButton btn_cancel = new JButton("Iptal et");
		btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cancel.setBounds(127, 157, 177, 55);
		contentPane.add(btn_cancel);
		
		JLabel lbl_UserSeats = new JLabel("Satin aldiginiz koltuklar:");
		lbl_UserSeats.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_UserSeats.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_UserSeats.setBounds(20, 98, 209, 55);
		contentPane.add(lbl_UserSeats);
		
		
	    lbl_SeatsMember = new JLabel("");
		lbl_SeatsMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SeatsMember.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_SeatsMember.setBounds(10, 11, 414, 44);
		contentPane.add(lbl_SeatsMember);
		
	}
}
