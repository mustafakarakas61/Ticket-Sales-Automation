import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;

public class AddSeance extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSeance frame = new AddSeance();
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
	public AddSeance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_MovieName = new JLabel("Film:");
		lbl_MovieName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_MovieName.setBounds(10, 36, 80, 31);
		contentPane.add(lbl_MovieName);
		
		JLabel lbl_Salon = new JLabel("Salon:");
		lbl_Salon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Salon.setBounds(10, 77, 80, 31);
		contentPane.add(lbl_Salon);
		
		JLabel lbl_Date = new JLabel("Tarih:");
		lbl_Date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Date.setBounds(10, 118, 80, 31);
		contentPane.add(lbl_Date);
		
		JLabel lblSeance = new JLabel("Seans:");
		lblSeance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeance.setBounds(10, 159, 80, 31);
		contentPane.add(lblSeance);
		
		JPanel SeanceHours = new JPanel();
		SeanceHours.setBackground(Color.WHITE);
		SeanceHours.setBounds(60, 169, 347, 139);
		contentPane.add(SeanceHours);
		SeanceHours.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("10:00 ");
		rdbtnNewRadioButton.setBounds(6, 6, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("11:00");
		rdbtnNewRadioButton_1.setBounds(122, 6, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("12:00");
		rdbtnNewRadioButton_2.setBounds(238, 6, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("18:00");
		rdbtnNewRadioButton_2_1.setBounds(238, 76, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_2_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("17:00");
		rdbtnNewRadioButton_1_1.setBounds(122, 76, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("16:00");
		rdbtnNewRadioButton_3.setBounds(6, 76, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_2_2 = new JRadioButton("21:00");
		rdbtnNewRadioButton_2_2.setBounds(238, 112, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_2_2);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("20:00");
		rdbtnNewRadioButton_1_2.setBounds(122, 112, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("19:00");
		rdbtnNewRadioButton_4.setBounds(6, 112, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_2_3 = new JRadioButton("15:00");
		rdbtnNewRadioButton_2_3.setBounds(238, 41, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_2_3);
		
		JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("14:00");
		rdbtnNewRadioButton_1_3.setBounds(122, 41, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_1_3);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("13:00");
		rdbtnNewRadioButton_5.setBounds(6, 41, 103, 21);
		SeanceHours.add(rdbtnNewRadioButton_5);
		
		JComboBox combo_MovieName = new JComboBox();
		combo_MovieName.setBounds(60, 43, 123, 21);
		contentPane.add(combo_MovieName);
		
		JComboBox combo_Salon = new JComboBox();
		combo_Salon.setBounds(60, 84, 123, 21);
		contentPane.add(combo_Salon);
		
		JDateChooser DateSelect = new JDateChooser();
		DateSelect.setBounds(59, 125, 124, 20);
		contentPane.add(DateSelect);
		
		JButton btn_AddSeance = new JButton("EKLE");
		btn_AddSeance.setBounds(60, 318, 347, 35);
		contentPane.add(btn_AddSeance);
	}
}