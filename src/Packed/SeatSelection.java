package Packed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Helper.DbHelper;
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
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

public class SeatSelection extends JFrame implements MouseListener {

	private JPanel contentPane;
	SeatHelper[][] seat = new SeatHelper[10][15];
	public static String[] seats;
	public JTextField txt_TotalSeats;
	private JTextField txt_TotalStudent;
	private JTextField txt_Total;
	private static SAdmin subadmin = new SAdmin();
	private JTextField txt_SelectedSeatsNumbers;
	String seatName = null;
	SeatHelper shelper = new SeatHelper();
	DbHelper dbhelper = new DbHelper();
	Connection connection = null;
	Statement statement;
	PreparedStatement pStatement;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeatSelection.class.getResource("/Images/ticket.png")));
		setTitle("Bilet Satis Sistemi");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 628);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JPanel w_paneScreen = new JPanel();
		w_paneScreen.setBackground(new Color(220, 20, 60));
		w_paneScreen.setBounds(11, 9, 1064, 72);
		contentPane.add(w_paneScreen);
		w_paneScreen.setLayout(null);

		JLabel lbl_Screen = new JLabel("PERDE");
		lbl_Screen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Screen.setFont(new Font("Script MT Bold", Font.ITALIC, 45));
		lbl_Screen.setBounds(0, 0, 1064, 72);
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
					w_paneSeat.add(s);
					try {
						String roww = "";
						if (row == 0) {
							roww = "A";
						} else if (row == 1) {
							roww = "B";
						} else if (row == 2) {
							roww = "C";
						} else if (row == 3) {
							roww = "D";
						} else if (row == 4) {
							roww = "E";
						} else if (row == 5) {
							roww = "F";
						} else if (row == 6) {
							roww = "G";
						} else if (row == 7) {
							roww = "H";
						} else if (row == 8) {
							roww = "I";
						} else if (row == 9) {
							roww = "J";
						}
						String typess = "d";
						String rows = roww;
						String seatNames = "";
						int filmID = subadmin.cinemaList().get(MainScreen.table_Cinema.getSelectedRow()).getFilmID();
						if (col > 7) {
							String cols = (col) + "";

							seatNames = rows + cols;

						} else if (col < 7) {
							String cols = (col + 1) + "";

							seatNames = rows + cols;
						}
						boolean control = shelper.seatGet(seatNames, typess, filmID);
						if (control) {
							ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOff.png"));

							s.setBackground(Color.white);
							s.setIcon(imageIcon);

							s.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

						} else {
							ImageIcon imageIcon = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOn.png"));

							s.setBackground(Color.white);
							s.setIcon(imageIcon);

							s.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
							s.addMouseListener(this);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

		JPanel w_paneTopNumber = new JPanel();
		w_paneTopNumber.setBackground(new Color(0, 0, 255));
		w_paneTopNumber.setBounds(11, 81, 1064, 20);
		contentPane.add(w_paneTopNumber);
		w_paneTopNumber.setLayout(null);

		JLabel lbl_TopNumber = new JLabel(
				"           1                    2                     3                   4                     5                    6                    7                                            8                    9                   10                  11                   12                   13                14");
		lbl_TopNumber.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_TopNumber.setBackground(new Color(0, 0, 255));
		lbl_TopNumber.setBounds(21, 3, 1043, 14);
		w_paneTopNumber.add(lbl_TopNumber);

		JPanel w_paneLeftChars = new JPanel();
		w_paneLeftChars.setBackground(new Color(0, 0, 255));
		w_paneLeftChars.setBounds(11, 96, 21, 410);
		contentPane.add(w_paneLeftChars);
		w_paneLeftChars.setLayout(null);

		JLabel lbl_A = new JLabel("A");
		lbl_A.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_A.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_A.setBounds(0, 19, 21, 14);
		w_paneLeftChars.add(lbl_A);

		JLabel lbl_B = new JLabel("B");
		lbl_B.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_B.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_B.setBounds(0, 59, 21, 14);
		w_paneLeftChars.add(lbl_B);

		JLabel lbl_C = new JLabel("C");
		lbl_C.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_C.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_C.setBounds(0, 99, 21, 14);
		w_paneLeftChars.add(lbl_C);

		JLabel lbl_D = new JLabel("D");
		lbl_D.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_D.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_D.setBounds(0, 139, 21, 14);
		w_paneLeftChars.add(lbl_D);

		JLabel lbl_E = new JLabel("E");
		lbl_E.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_E.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_E.setBounds(0, 176, 21, 14);
		w_paneLeftChars.add(lbl_E);

		JLabel lbl_F = new JLabel("F");
		lbl_F.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_F.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_F.setBounds(0, 217, 21, 14);
		w_paneLeftChars.add(lbl_F);

		JLabel lbl_G = new JLabel("G");
		lbl_G.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_G.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_G.setBounds(0, 257, 21, 14);
		w_paneLeftChars.add(lbl_G);

		JLabel lbl_H = new JLabel("H");
		lbl_H.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_H.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_H.setBounds(0, 298, 21, 14);
		w_paneLeftChars.add(lbl_H);

		JLabel lbl_I = new JLabel("I");
		lbl_I.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_I.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_I.setBounds(0, 335, 21, 14);
		w_paneLeftChars.add(lbl_I);

		JLabel lbl_J = new JLabel("J");
		lbl_J.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_J.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_J.setBounds(0, 374, 21, 14);
		w_paneLeftChars.add(lbl_J);

		JPanel w_paneLeftChars_1 = new JPanel();
		w_paneLeftChars_1.setLayout(null);
		w_paneLeftChars_1.setBackground(new Color(0, 0, 255));
		w_paneLeftChars_1.setBounds(1054, 96, 21, 410);
		contentPane.add(w_paneLeftChars_1);

		JLabel lbl_A_1 = new JLabel("A");
		lbl_A_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_A_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_A_1.setBounds(0, 19, 21, 14);
		w_paneLeftChars_1.add(lbl_A_1);

		JLabel lbl_B_1 = new JLabel("B");
		lbl_B_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_B_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_B_1.setBounds(0, 59, 21, 14);
		w_paneLeftChars_1.add(lbl_B_1);

		JLabel lbl_C_1 = new JLabel("C");
		lbl_C_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_C_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_C_1.setBounds(0, 99, 21, 14);
		w_paneLeftChars_1.add(lbl_C_1);

		JLabel lbl_D_1 = new JLabel("D");
		lbl_D_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_D_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_D_1.setBounds(0, 139, 21, 14);
		w_paneLeftChars_1.add(lbl_D_1);

		JLabel lbl_E_1 = new JLabel("E");
		lbl_E_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_E_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_E_1.setBounds(0, 176, 21, 14);
		w_paneLeftChars_1.add(lbl_E_1);

		JLabel lbl_F_1 = new JLabel("F");
		lbl_F_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_F_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_F_1.setBounds(0, 217, 21, 14);
		w_paneLeftChars_1.add(lbl_F_1);

		JLabel lbl_G_1 = new JLabel("G");
		lbl_G_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_G_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_G_1.setBounds(0, 257, 21, 14);
		w_paneLeftChars_1.add(lbl_G_1);

		JLabel lbl_H_1 = new JLabel("H");
		lbl_H_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_H_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_H_1.setBounds(0, 298, 21, 14);
		w_paneLeftChars_1.add(lbl_H_1);

		JLabel lbl_I_1 = new JLabel("I");
		lbl_I_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_I_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_I_1.setBounds(0, 335, 21, 14);
		w_paneLeftChars_1.add(lbl_I_1);

		JLabel lbl_J_1 = new JLabel("J");
		lbl_J_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_J_1.setFont(new Font("SansSerif", Font.BOLD, 12));
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
		lbl_TakenSeatLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_TakenSeatLabel.setBounds(35, 515, 94, 14);
		contentPane.add(lbl_TakenSeatLabel);

		JLabel lbl_EmptySeatIcon = new JLabel();

		ImageIcon imageIcon2 = new ImageIcon(SeatSelection.class.getResource("/Images/SeatOn.png"));
		Image image2 = imageIcon2.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);

		lbl_EmptySeatIcon.setIcon(new ImageIcon(newimg2));
		lbl_EmptySeatIcon.setBounds(11, 533, 21, 28);
		contentPane.add(lbl_EmptySeatIcon);

		JLabel lbl_EmptySeatLabel = new JLabel("Bos Koltuk");
		lbl_EmptySeatLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_EmptySeatLabel.setBounds(35, 540, 94, 14);
		contentPane.add(lbl_EmptySeatLabel);

		JLabel lbl_SelectedSeatIcon = new JLabel();

		ImageIcon imageIcon3 = new ImageIcon(SeatSelection.class.getResource("/Images/SeatSelect.png"));
		Image image3 = imageIcon3.getImage();
		Image newimg3 = image3.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);

		lbl_SelectedSeatIcon.setIcon(new ImageIcon(newimg3));
		lbl_SelectedSeatIcon.setBounds(11, 559, 21, 28);
		contentPane.add(lbl_SelectedSeatIcon);

		JLabel lbl_SelectedSeatLabel = new JLabel("Secili Koltuk");
		lbl_SelectedSeatLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_SelectedSeatLabel.setBounds(35, 565, 94, 14);
		contentPane.add(lbl_SelectedSeatLabel);

		JLabel lbl_SelectedTotalSeat = new JLabel("Secilen Koltuk Sayisi");
		lbl_SelectedTotalSeat.setFont(new Font("SansSerif", Font.ITALIC, 13));
		lbl_SelectedTotalSeat.setBounds(628, 513, 170, 20);
		contentPane.add(lbl_SelectedTotalSeat);

		JLabel lbl_SelectedSeatsNumbers = new JLabel("Secilen Koltuk Numaralari :");
		lbl_SelectedSeatsNumbers.setFont(new Font("SansSerif", Font.ITALIC, 13));
		lbl_SelectedSeatsNumbers.setBounds(628, 536, 170, 23);
		contentPane.add(lbl_SelectedSeatsNumbers);

		txt_TotalSeats = new JTextField();
		txt_TotalSeats.setEditable(false);
		txt_TotalSeats.setFont(new Font("SansSerif", Font.BOLD, 15));
		txt_TotalSeats.setBackground(new Color(255, 255, 255));
		txt_TotalSeats.setBounds(800, 513, 65, 20);
		txt_TotalSeats.setText("0");
		contentPane.add(txt_TotalSeats);
		txt_TotalSeats.setColumns(10);

		JLabel lbl_TicketPrice = new JLabel("Bilet Fiyati : 20TL");
		lbl_TicketPrice.setFont(new Font("SansSerif", Font.BOLD, 15));
		lbl_TicketPrice.setBounds(161, 522, 170, 20);
		contentPane.add(lbl_TicketPrice);

		JLabel lbl_StudentTicketPrice = new JLabel("Ogrenci Bilet Fiyati : 13TL");
		lbl_StudentTicketPrice.setFont(new Font("SansSerif", Font.BOLD, 15));
		lbl_StudentTicketPrice.setBounds(161, 550, 186, 23);
		contentPane.add(lbl_StudentTicketPrice);

		JLabel lbl_TotalStudentLabel = new JLabel("Ogrenci Sayisi :");
		lbl_TotalStudentLabel.setFont(new Font("SansSerif", Font.ITALIC, 13));
		lbl_TotalStudentLabel.setBounds(628, 559, 170, 23);
		contentPane.add(lbl_TotalStudentLabel);

		txt_TotalStudent = new JTextField("0");
		txt_TotalStudent.setFont(new Font("SansSerif", Font.BOLD, 15));
		txt_TotalStudent.setColumns(10);
		txt_TotalStudent.setBackground(Color.WHITE);
		txt_TotalStudent.setBounds(800, 561, 65, 20);

		contentPane.add(txt_TotalStudent);

		JLabel lblNewLabel = new JLabel("Tutar:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel.setBounds(884, 530, 55, 39);
		contentPane.add(lblNewLabel);

		txt_Total = new JTextField();

		txt_Total.setBackground(new Color(255, 255, 255));
		txt_Total.setEditable(false);
		txt_Total.setForeground(new Color(0, 204, 0));
		txt_Total.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 25));
		txt_Total.setHorizontalAlignment(SwingConstants.CENTER);

		txt_Total.setBounds(954, 530, 100, 40);

		contentPane.add(txt_Total);
		txt_Total.setColumns(10);

		txt_SelectedSeatsNumbers = new JTextField();
		txt_SelectedSeatsNumbers.setFont(new Font("SansSerif", Font.BOLD, 15));
		txt_SelectedSeatsNumbers.setEditable(false);
		txt_SelectedSeatsNumbers.setColumns(10);
		txt_SelectedSeatsNumbers.setBackground(Color.WHITE);
		txt_SelectedSeatsNumbers.setBounds(800, 537, 65, 20);
		contentPane.add(txt_SelectedSeatsNumbers);

		JButton btn_Confirm = new JButton("Onayla");
		btn_Confirm.setFocusable(false);
		btn_Confirm.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Confirm.setBackground(new Color(153, 255, 102));
		btn_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int count = 0;

				if (txt_SelectedSeatsNumbers.getText() != null) {
					for (int i = 0; i < txt_SelectedSeatsNumbers.getText().length(); i++) {
						if (txt_SelectedSeatsNumbers.getText().charAt(i) == '*') {

							count++;
						}
					}
					seats = new String[count];
					int k = 0;

					if (txt_SelectedSeatsNumbers.getText().length() <= 3) {
						for (int i = 0; i < txt_SelectedSeatsNumbers.getText().length(); i++) {

							if (txt_SelectedSeatsNumbers.getText().charAt(i) == '*') {
								seats[k] = txt_SelectedSeatsNumbers.getText().charAt(i + 1) + ""
										+ txt_SelectedSeatsNumbers.getText().charAt(i + 2);
								k++;
							}

						}
					} else if (txt_SelectedSeatsNumbers.getText().length() > 3) {
						for (int i = 0; i < txt_SelectedSeatsNumbers.getText().length(); i++) {

							try {
								if (txt_SelectedSeatsNumbers.getText().charAt(i) == '*') {
									if (txt_SelectedSeatsNumbers.getText().charAt(i + 3) == '*') {
										seats[k] = txt_SelectedSeatsNumbers.getText().charAt(i + 1) + ""
												+ txt_SelectedSeatsNumbers.getText().charAt(i + 2);
									} else {
										seats[k] = txt_SelectedSeatsNumbers.getText().charAt(i + 1) + ""
												+ txt_SelectedSeatsNumbers.getText().charAt(i + 2) + ""
												+ txt_SelectedSeatsNumbers.getText().charAt(i + 3);
									}
									k++;
								}
							} catch (Exception e2) {
								if (txt_SelectedSeatsNumbers.getText().charAt(i) == '*') {

									seats[k] = txt_SelectedSeatsNumbers.getText().charAt(i + 1) + ""
											+ txt_SelectedSeatsNumbers.getText().charAt(i + 2);

									k++;
								}
							}
						}
					}

				}

				BuyTicket.setSeat(txt_SelectedSeatsNumbers.getText());
				BuyTicket.setPrice(txt_Total.getText());
				BuyTicket.setSeatCount(txt_TotalSeats.getText());
				BuyTicket.setStudentCount(txt_TotalStudent.getText());

				if (txt_TotalStudent.getText().length() == 0) {
					BuyTicket.setStudentCount("0");

				}
				dispose();
			}
		});
		btn_Confirm.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_Confirm.setBounds(467, 525, 150, 40);
		contentPane.add(btn_Confirm);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SeatHelper s = (SeatHelper) e.getComponent();

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
				txt_SelectedSeatsNumbers.setText(txt_SelectedSeatsNumbers.getText() + "*" + seatName);

				String sentence = txt_SelectedSeatsNumbers.getText();
				int charCount = 0;
				for (int i = 0; i < sentence.length(); i++) {

					if (sentence.charAt(i) == '*') {

						txt_TotalSeats.setText("" + (charCount + 1));
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

				txt_SelectedSeatsNumbers.setText(txt_SelectedSeatsNumbers.getText().replace("*" + seatName, ""));
				int totalSeatsCount = Integer.parseInt(txt_TotalSeats.getText());
				int newCount = totalSeatsCount - 1;
				txt_TotalSeats.setText("" + newCount);
				s.setSeatSelect(false);

			}

		}
		txt_TotalStudent.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (txt_TotalStudent.getText().length() <= 4 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

						txt_TotalStudent.setEditable(true);
					} else {
						txt_TotalStudent.setEditable(false);
					}

				} else {
					txt_TotalStudent.setEditable(false);

				}
			}
		});
		if (Integer.parseInt(txt_TotalSeats.getText()) >= Integer.parseInt("0" + txt_TotalStudent.getText())) {
			txt_Total.setText("" + Math.abs(
					((Integer.parseInt(txt_TotalSeats.getText()) - Integer.parseInt("0" + txt_TotalStudent.getText()))
							* 20 + Integer.parseInt("0" + txt_TotalStudent.getText()) * 13))
					+ "TL");
		} else {
			txt_Total.setText("");
		}
		txt_TotalStudent.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				txt_TotalStudent.addKeyListener(new KeyAdapter() {

					public void keyPressed(KeyEvent ke) {
						if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
								|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

							if (txt_TotalStudent.getText().length() <= 4 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

								txt_TotalStudent.setEditable(true);
							} else {
								txt_TotalStudent.setEditable(false);
							}

						} else {
							txt_TotalStudent.setEditable(false);

						}
					}
				});

				if (Integer.parseInt(txt_TotalSeats.getText()) >= Integer.parseInt("0" + txt_TotalStudent.getText())) {
					txt_Total.setText("" + Math.abs(((Integer.parseInt(txt_TotalSeats.getText())
							- Integer.parseInt("0" + txt_TotalStudent.getText())) * 20
							+ Integer.parseInt("0" + txt_TotalStudent.getText()) * 13)) + "TL");
				}

				else {
					txt_Total.setText("");
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (Integer.parseInt(txt_TotalSeats.getText()) >= Integer.parseInt("0" + txt_TotalStudent.getText())) {
					txt_Total.setText("" + Math.abs(((Integer.parseInt(txt_TotalSeats.getText())
							- Integer.parseInt("0" + txt_TotalStudent.getText())) * 20
							+ Integer.parseInt("0" + txt_TotalStudent.getText()) * 13)) + "TL");
				}

				else {
					txt_Total.setText("");
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

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
