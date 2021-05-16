import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Helper.Metod_Helper;
import Helper.SeatHelper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SeatSelection extends JFrame implements MouseListener {

	private JPanel contentPane;
	SeatHelper[][] seat = new SeatHelper[10][15];
	private JTextField txt_TotalSeats;
	private JTextField txt_TotalStudent;
	private JTextField txt_Total;
	private JTextField txt_SelectedSeatsNumbers;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 628);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel w_paneScreen = new JPanel();
		w_paneScreen.setBackground(new Color(204, 0, 0));
		w_paneScreen.setBounds(11, 9, 1064, 72);
		contentPane.add(w_paneScreen);
		w_paneScreen.setLayout(null);

		JLabel lbl_Screen = new JLabel("PERDE");
		lbl_Screen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Screen.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 42));
		lbl_Screen.setBounds(0, 0, 1064, 92);
		w_paneScreen.add(lbl_Screen);

		JPanel w_paneSeat = new JPanel();
		w_paneSeat.setBackground(SystemColor.activeCaption);
		w_paneSeat.setBounds(31, 100, 1023, 406);

		contentPane.add(w_paneSeat);
		w_paneSeat.setLayout(new GridLayout(seat.length, seat[0].length));
		for (int row = 0; row < seat.length; row++) {
			for (int col = 0; col < seat[0].length; col++) {
				if (col == 7) {
					if (row == 0) {
						JLabel lbl_SalonText = new JLabel("S");
						lbl_SalonText.setHorizontalAlignment(SwingConstants.CENTER);
						lbl_SalonText.setVerticalAlignment(SwingConstants.BOTTOM);
						lbl_SalonText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
						w_paneSeat.add(lbl_SalonText);
					} else if (row == 2) {
						JLabel lbl_SalonText = new JLabel("A");
						lbl_SalonText.setHorizontalAlignment(SwingConstants.CENTER);
						lbl_SalonText.setVerticalAlignment(SwingConstants.BOTTOM);
						lbl_SalonText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
						w_paneSeat.add(lbl_SalonText);
					} else if (row == 4) {
						JLabel lbl_SalonText = new JLabel("L");
						lbl_SalonText.setHorizontalAlignment(SwingConstants.CENTER);
						lbl_SalonText.setVerticalAlignment(SwingConstants.BOTTOM);
						lbl_SalonText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
						w_paneSeat.add(lbl_SalonText);
					} else if (row == 6) {
						JLabel lbl_SalonText = new JLabel("O");
						lbl_SalonText.setHorizontalAlignment(SwingConstants.CENTER);
						lbl_SalonText.setVerticalAlignment(SwingConstants.BOTTOM);
						lbl_SalonText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
						w_paneSeat.add(lbl_SalonText);
					} else if (row == 8) {
						JLabel lbl_SalonText = new JLabel("N");
						lbl_SalonText.setHorizontalAlignment(SwingConstants.CENTER);
						lbl_SalonText.setVerticalAlignment(SwingConstants.BOTTOM);
						lbl_SalonText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
						w_paneSeat.add(lbl_SalonText);
					} else {
						JLabel lbl_SalonText = new JLabel("");
						lbl_SalonText.setHorizontalAlignment(SwingConstants.CENTER);
						lbl_SalonText.setVerticalAlignment(SwingConstants.BOTTOM);
						lbl_SalonText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
						w_paneSeat.add(lbl_SalonText);
					}
				} else {
					SeatHelper s = new SeatHelper(row, col);
					s.setSize(50, 45);
					s.setText("");
					ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOn.png"));
					s.setBackground(Color.white);
					s.setIcon(imageIcon);
					s.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
					w_paneSeat.add(s);
					s.addMouseListener(this);
				}
			}
		}

		JButton btn_Confirm = new JButton("Onayla");
		btn_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyTicket.seat=txt_SelectedSeatsNumbers.getText();
				BuyTicket.price=txt_Total.getText();
				dispose();
			}
		});
		btn_Confirm.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btn_Confirm.setBounds(492, 525, 100, 44);
		contentPane.add(btn_Confirm);

		JPanel w_paneTopNumber = new JPanel();
		w_paneTopNumber.setBackground(SystemColor.desktop);
		w_paneTopNumber.setBounds(11, 81, 1064, 20);
		contentPane.add(w_paneTopNumber);
		w_paneTopNumber.setLayout(null);

		JLabel lbl_TopNumber = new JLabel(
				"           1                    2                     3                   4                     5                    6                    7                                            8                    9                   10                  11                   12                   13                14");
		lbl_TopNumber.setFont(new Font("Arial", Font.BOLD, 11));
		lbl_TopNumber.setBackground(SystemColor.desktop);
		lbl_TopNumber.setBounds(21, 3, 1043, 14);
		w_paneTopNumber.add(lbl_TopNumber);

		JPanel w_paneLeftChars = new JPanel();
		w_paneLeftChars.setBackground(SystemColor.desktop);
		w_paneLeftChars.setBounds(11, 96, 21, 410);
		contentPane.add(w_paneLeftChars);
		w_paneLeftChars.setLayout(null);

		JLabel lbl_A = new JLabel("A");
		lbl_A.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_A.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_A.setBounds(0, 19, 21, 14);
		w_paneLeftChars.add(lbl_A);

		JLabel lbl_B = new JLabel("B");
		lbl_B.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_B.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_B.setBounds(0, 59, 21, 14);
		w_paneLeftChars.add(lbl_B);

		JLabel lbl_C = new JLabel("C");
		lbl_C.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_C.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_C.setBounds(0, 99, 21, 14);
		w_paneLeftChars.add(lbl_C);

		JLabel lbl_D = new JLabel("D");
		lbl_D.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_D.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_D.setBounds(0, 139, 21, 14);
		w_paneLeftChars.add(lbl_D);

		JLabel lbl_E = new JLabel("E");
		lbl_E.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_E.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_E.setBounds(0, 176, 21, 14);
		w_paneLeftChars.add(lbl_E);

		JLabel lbl_F = new JLabel("F");
		lbl_F.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_F.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_F.setBounds(0, 217, 21, 14);
		w_paneLeftChars.add(lbl_F);

		JLabel lbl_G = new JLabel("G");
		lbl_G.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_G.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_G.setBounds(0, 257, 21, 14);
		w_paneLeftChars.add(lbl_G);

		JLabel lbl_H = new JLabel("H");
		lbl_H.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_H.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_H.setBounds(0, 298, 21, 14);
		w_paneLeftChars.add(lbl_H);

		JLabel lbl_I = new JLabel("I");
		lbl_I.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_I.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_I.setBounds(0, 335, 21, 14);
		w_paneLeftChars.add(lbl_I);

		JLabel lbl_J = new JLabel("J");
		lbl_J.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_J.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_J.setBounds(0, 374, 21, 14);
		w_paneLeftChars.add(lbl_J);

		JPanel w_paneLeftChars_1 = new JPanel();
		w_paneLeftChars_1.setLayout(null);
		w_paneLeftChars_1.setBackground(SystemColor.desktop);
		w_paneLeftChars_1.setBounds(1054, 96, 21, 410);
		contentPane.add(w_paneLeftChars_1);

		JLabel lbl_A_1 = new JLabel("A");
		lbl_A_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_A_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_A_1.setBounds(0, 19, 21, 14);
		w_paneLeftChars_1.add(lbl_A_1);

		JLabel lbl_B_1 = new JLabel("B");
		lbl_B_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_B_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_B_1.setBounds(0, 59, 21, 14);
		w_paneLeftChars_1.add(lbl_B_1);

		JLabel lbl_C_1 = new JLabel("C");
		lbl_C_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_C_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_C_1.setBounds(0, 99, 21, 14);
		w_paneLeftChars_1.add(lbl_C_1);

		JLabel lbl_D_1 = new JLabel("D");
		lbl_D_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_D_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_D_1.setBounds(0, 139, 21, 14);
		w_paneLeftChars_1.add(lbl_D_1);

		JLabel lbl_E_1 = new JLabel("E");
		lbl_E_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_E_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_E_1.setBounds(0, 176, 21, 14);
		w_paneLeftChars_1.add(lbl_E_1);

		JLabel lbl_F_1 = new JLabel("F");
		lbl_F_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_F_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_F_1.setBounds(0, 217, 21, 14);
		w_paneLeftChars_1.add(lbl_F_1);

		JLabel lbl_G_1 = new JLabel("G");
		lbl_G_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_G_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_G_1.setBounds(0, 257, 21, 14);
		w_paneLeftChars_1.add(lbl_G_1);

		JLabel lbl_H_1 = new JLabel("H");
		lbl_H_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_H_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_H_1.setBounds(0, 298, 21, 14);
		w_paneLeftChars_1.add(lbl_H_1);

		JLabel lbl_I_1 = new JLabel("I");
		lbl_I_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_I_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_I_1.setBounds(0, 335, 21, 14);
		w_paneLeftChars_1.add(lbl_I_1);

		JLabel lbl_J_1 = new JLabel("J");
		lbl_J_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_J_1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_J_1.setBounds(0, 374, 21, 14);
		w_paneLeftChars_1.add(lbl_J_1);

		JLabel lbl_TakenSeatIcon = new JLabel();

		ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOff.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);

		lbl_TakenSeatIcon.setIcon(new ImageIcon(newimg));
		lbl_TakenSeatIcon.setBounds(11, 508, 21, 28);
		contentPane.add(lbl_TakenSeatIcon);

		JLabel lbl_TakenSeatLabel = new JLabel("Dolu Koltuk");
		lbl_TakenSeatLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_TakenSeatLabel.setBounds(35, 515, 80, 14);
		contentPane.add(lbl_TakenSeatLabel);

		JLabel lbl_EmptySeatIcon = new JLabel();

		ImageIcon imageIcon2 = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOn.png"));
		Image image2 = imageIcon2.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);

		lbl_EmptySeatIcon.setIcon(new ImageIcon(newimg2));
		lbl_EmptySeatIcon.setBounds(11, 533, 21, 28);
		contentPane.add(lbl_EmptySeatIcon);

		JLabel lbl_EmptySeatLabel = new JLabel("Boþ Koltuk");
		lbl_EmptySeatLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_EmptySeatLabel.setBounds(35, 540, 80, 14);
		contentPane.add(lbl_EmptySeatLabel);

		JLabel lbl_SelectedSeatIcon = new JLabel();

		ImageIcon imageIcon3 = new ImageIcon(SeatSelection.class.getResource("/Images/SeatSelect.png"));
		Image image3 = imageIcon3.getImage();
		Image newimg3 = image3.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);

		lbl_SelectedSeatIcon.setIcon(new ImageIcon(newimg3));
		lbl_SelectedSeatIcon.setBounds(11, 559, 21, 28);
		contentPane.add(lbl_SelectedSeatIcon);

		JLabel lbl_SelectedSeatLabel = new JLabel("Seçili Koltuk");
		lbl_SelectedSeatLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_SelectedSeatLabel.setBounds(35, 565, 80, 14);
		contentPane.add(lbl_SelectedSeatLabel);

		JLabel lbl_SelectedTotalSeat = new JLabel("Secilen Koltuk Sayýsý:");
		lbl_SelectedTotalSeat.setFont(new Font("Arial", Font.ITALIC, 13));
		lbl_SelectedTotalSeat.setBounds(620, 513, 170, 20);
		contentPane.add(lbl_SelectedTotalSeat);

		JLabel lbl_SelectedSeatsNumbers = new JLabel("Seçilen Koltuk Numaralari :");
		lbl_SelectedSeatsNumbers.setFont(new Font("Arial", Font.ITALIC, 13));
		lbl_SelectedSeatsNumbers.setBounds(620, 536, 170, 23);
		contentPane.add(lbl_SelectedSeatsNumbers);

		txt_TotalSeats = new JTextField();
		txt_TotalSeats.setEditable(false);
		txt_TotalSeats.setFont(new Font("Arial", Font.BOLD, 15));
		txt_TotalSeats.setBackground(new Color(255, 255, 255));
		txt_TotalSeats.setBounds(792, 513, 65, 20);
		txt_TotalSeats.setText("0");
		contentPane.add(txt_TotalSeats);
		txt_TotalSeats.setColumns(10);

		JLabel lbl_TicketPrice = new JLabel("Bilet Fiyati : 20TL");
		lbl_TicketPrice.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_TicketPrice.setBounds(161, 522, 170, 20);
		contentPane.add(lbl_TicketPrice);

		JLabel lbl_StudentTicketPrice = new JLabel("Öðrenci Bilet Fiyati : 13TL");
		lbl_StudentTicketPrice.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_StudentTicketPrice.setBounds(161, 550, 186, 23);
		contentPane.add(lbl_StudentTicketPrice);

		JLabel lbl_TotalStudentLabel = new JLabel("Öðrenci Sayisi :");
		lbl_TotalStudentLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		lbl_TotalStudentLabel.setBounds(620, 559, 170, 23);
		contentPane.add(lbl_TotalStudentLabel);

		txt_TotalStudent = new JTextField();
		txt_TotalStudent.setFont(new Font("Arial", Font.BOLD, 15));
		txt_TotalStudent.setColumns(10);
		txt_TotalStudent.setBackground(Color.WHITE);
		txt_TotalStudent.setBounds(792, 561, 65, 20);
	
		contentPane.add(txt_TotalStudent);
		
		JLabel lblNewLabel = new JLabel("Tutar:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(884, 530, 55, 39);
		contentPane.add(lblNewLabel);

		txt_Total = new JTextField();
		
		txt_Total.setBackground(new Color(255, 255, 255));
		txt_Total.setEditable(false);
		txt_Total.setForeground(new Color(0, 128, 0));
		txt_Total.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 26));
		txt_Total.setHorizontalAlignment(SwingConstants.CENTER);
	
		txt_Total.setBounds(949, 517, 125, 61);
		
		
		contentPane.add(txt_Total);
		txt_Total.setColumns(10);

		txt_SelectedSeatsNumbers = new JTextField();
		txt_SelectedSeatsNumbers.setFont(new Font("Arial", Font.BOLD, 15));
		txt_SelectedSeatsNumbers.setEditable(false);
		txt_SelectedSeatsNumbers.setColumns(10);
		txt_SelectedSeatsNumbers.setBackground(Color.WHITE);
		txt_SelectedSeatsNumbers.setBounds(792, 537, 65, 20);
		contentPane.add(txt_SelectedSeatsNumbers);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SeatHelper s = (SeatHelper) e.getComponent();
		String seatName = null;
		
		if (e.getButton() == 1) {
			if (!(s.isSeatSelect())) {
				ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/SeatSelect.png"));
				if (s.getRow() == 0 && s.getCol() < 7) {
					seatName = ("A" + (s.getCol() + 1));

				}
				if (s.getRow() == 1 && s.getCol() < 7) {
					seatName = ("B" + (s.getCol() + 1));

				}
				if (s.getRow() == 2 && s.getCol() < 7) {
					seatName = ("C" + (s.getCol() + 1));

				}
				if (s.getRow() == 3 && s.getCol() < 7) {
					seatName = ("D" + (s.getCol() + 1));

				}
				if (s.getRow() == 4 && s.getCol() < 7) {
					seatName = ("E" + (s.getCol() + 1));

				}
				if (s.getRow() == 5 && s.getCol() < 7) {
					seatName = ("F" + (s.getCol() + 1));

				}
				if (s.getRow() == 6 && s.getCol() < 7) {
					seatName = ("G" + (s.getCol() + 1));

				}
				if (s.getRow() == 7 && s.getCol() < 7) {
					seatName = ("H" + (s.getCol() + 1));

				}
				if (s.getRow() == 8 && s.getCol() < 7) {
					seatName = ("I" + (s.getCol() + 1));

				}
				if (s.getRow() == 9 && s.getCol() < 7) {
					seatName = ("J" + (s.getCol() + 1));

				}
				if (s.getRow() == 0 && s.getCol() > 7) {
					seatName = ("A" + (s.getCol()));

				}
				if (s.getRow() == 1 && s.getCol() > 7) {
					seatName = ("B" + (s.getCol()));

				}
				if (s.getRow() == 2 && s.getCol() > 7) {
					seatName = ("C" + (s.getCol()));

				}
				if (s.getRow() == 3 && s.getCol() > 7) {
					seatName = ("D" + (s.getCol()));

				}
				if (s.getRow() == 4 && s.getCol() > 7) {
					seatName = ("E" + (s.getCol()));

				}
				if (s.getRow() == 5 && s.getCol() > 7) {
					seatName = ("F" + (s.getCol()));

				}
				if (s.getRow() == 6 && s.getCol() > 7) {
					seatName = ("G" + (s.getCol()));

				}
				if (s.getRow() == 7 && s.getCol() > 7) {
					seatName = ("H" + (s.getCol()));

				}
				if (s.getRow() == 8 && s.getCol() > 7) {
					seatName = ("I" + (s.getCol()));

				}
				if (s.getRow() == 9 && s.getCol() > 7) {
					seatName = ("J" + (s.getCol()));

				}
				
				
				txt_SelectedSeatsNumbers.setText(txt_SelectedSeatsNumbers.getText()+"*"+seatName);
				
				String sentence=txt_SelectedSeatsNumbers.getText();
				int charCount=0;
				System.out.println(sentence);
				for(int i=0;i<sentence.length();i++)
				{
					
					if(sentence.charAt(i)=='*')
					{
						
						txt_TotalSeats.setText(""+(charCount+1));
						charCount++;
					}
				}
				
				
				s.setIcon(imageIcon);
				
				s.setSeatSelect(true);
				
			} else {
				if (s.getRow() == 0 && s.getCol() < 7) {
					seatName = ("A" + (s.getCol() + 1));

				}
				if (s.getRow() == 1 && s.getCol() < 7) {
					seatName = ("B" + (s.getCol() + 1));

				}
				if (s.getRow() == 2 && s.getCol() < 7) {
					seatName = ("C" + (s.getCol() + 1));

				}
				if (s.getRow() == 3 && s.getCol() < 7) {
					seatName = ("D" + (s.getCol() + 1));

				}
				if (s.getRow() == 4 && s.getCol() < 7) {
					seatName = ("E" + (s.getCol() + 1));

				}
				if (s.getRow() == 5 && s.getCol() < 7) {
					seatName = ("F" + (s.getCol() + 1));

				}
				if (s.getRow() == 6 && s.getCol() < 7) {
					seatName = ("G" + (s.getCol() + 1));

				}
				if (s.getRow() == 7 && s.getCol() < 7) {
					seatName = ("H" + (s.getCol() + 1));

				}
				if (s.getRow() == 8 && s.getCol() < 7) {
					seatName = ("I" + (s.getCol() + 1));

				}
				if (s.getRow() == 9 && s.getCol() < 7) {
					seatName = ("J" + (s.getCol() + 1));

				}
				if (s.getRow() == 0 && s.getCol() > 7) {
					seatName = ("A" + (s.getCol()));

				}
				if (s.getRow() == 1 && s.getCol() > 7) {
					seatName = ("B" + (s.getCol()));

				}
				if (s.getRow() == 2 && s.getCol() > 7) {
					seatName = ("C" + (s.getCol()));

				}
				if (s.getRow() == 3 && s.getCol() > 7) {
					seatName = ("D" + (s.getCol()));

				}
				if (s.getRow() == 4 && s.getCol() > 7) {
					seatName = ("E" + (s.getCol()));

				}
				if (s.getRow() == 5 && s.getCol() > 7) {
					seatName = ("F" + (s.getCol()));

				}
				if (s.getRow() == 6 && s.getCol() > 7) {
					seatName = ("G" + (s.getCol()));

				}
				if (s.getRow() == 7 && s.getCol() > 7) {
					seatName = ("H" + (s.getCol()));

				}
				if (s.getRow() == 8 && s.getCol() > 7) {
					seatName = ("I" + (s.getCol()));

				}
				if (s.getRow() == 9 && s.getCol() > 7) {
					seatName = ("J" + (s.getCol()));

				}
				
				ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOn.png"));
				s.setIcon(imageIcon);
				
				txt_SelectedSeatsNumbers.setText(txt_SelectedSeatsNumbers.getText().replace("*"+seatName, ""));
				int totalSeatsCount=Integer.parseInt(txt_TotalSeats.getText());
				int newCount=totalSeatsCount-1;
				txt_TotalSeats.setText(""+newCount);
				s.setSeatSelect(false);
			
			}
			
		}
		txt_TotalStudent.addKeyListener(new KeyAdapter(){
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( txt_TotalStudent.getText().length()<=4 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {	
	            	
	            	txt_TotalStudent.setEditable(true);
	            }
	            else {
	            	txt_TotalStudent.setEditable(false);
	            }
	            
	            } else{
	            	txt_TotalStudent.setEditable(false);
	            	
	            }
	         }
	      });
		if(Integer.parseInt(txt_TotalSeats.getText())>=Integer.parseInt("0"+txt_TotalStudent.getText()))
		{
		txt_Total.setText(""+Math.abs(((Integer.parseInt(txt_TotalSeats.getText())-Integer.parseInt("0"+txt_TotalStudent.getText()))*20+Integer.parseInt("0"+txt_TotalStudent.getText())*13))+"TL");
		}
		else {
			txt_Total.setText("");
		}
		txt_TotalStudent.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				txt_TotalStudent.addKeyListener(new KeyAdapter(){
					
			         public void keyPressed(KeyEvent ke) {
			            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
			            	
			            if( txt_TotalStudent.getText().length()<=4 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
			            {	
			            	
			            	txt_TotalStudent.setEditable(true);
			            }
			            else {
			            	txt_TotalStudent.setEditable(false);
			            }
			            
			            } else{
			            	txt_TotalStudent.setEditable(false);
			            	
			            }
			         }
			      });
				
				if(Integer.parseInt(txt_TotalSeats.getText())>=Integer.parseInt("0"+txt_TotalStudent.getText()))
				{
				txt_Total.setText(""+Math.abs(((Integer.parseInt(txt_TotalSeats.getText())-Integer.parseInt("0"+txt_TotalStudent.getText()))*20+Integer.parseInt("0"+txt_TotalStudent.getText())*13))+"TL");
				}
			
				else {
					txt_Total.setText("");
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(Integer.parseInt(txt_TotalSeats.getText())>=Integer.parseInt("0"+txt_TotalStudent.getText()))
				{
				txt_Total.setText(""+Math.abs(((Integer.parseInt(txt_TotalSeats.getText())-Integer.parseInt("0"+txt_TotalStudent.getText()))*20+Integer.parseInt("0"+txt_TotalStudent.getText())*13))+"TL");
				}
			
				else {
					txt_Total.setText("");
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			 
				});
	}
 
	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		SeatHelper s = (SeatHelper) e.getComponent();
		s.setBackground(new Color(173, 216, 230));
		s.setBorder(null);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		SeatHelper s = (SeatHelper) e.getComponent();
		s.setBackground(Color.white);
		s.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		
	}
}
