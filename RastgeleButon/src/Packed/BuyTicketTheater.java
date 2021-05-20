package Packed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Helper.Metod_Helper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class BuyTicketTheater extends JFrame {

	private JPanel contentPane;
	JTextField fld_TheaterName;
	JTextField fld_seance;
	JTextField fld_price;
	JTextField fld_Salon;
	JTextField fld_theater_type;
	JTextField txt_seatCount;
	JTextField txt_StudentCount;
	public static JLabel lbl_Card;
	public static JLabel lbl_InfoStudent;
	public static String[] seats;
	private static String theater, seance, seat, price, salon, theater_type, theaterDate, seatCount, studentCount,
			lblCard, lblInfoStudent, user;
	public static JComboBox comboBox_seatTheater;
	private JTextField txt_TheaterDate;

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		BuyTicketTheater.user = user;
	}

	public static String getTheaterDate() {
		return theaterDate;
	}

	public static void setTheaterDate(String theaterDate) {
		BuyTicketTheater.theaterDate = theaterDate;
	}

	public static String getTheater() {
		return theater;
	}

	public static void setTheater(String theater) {
		BuyTicketTheater.theater = theater;
	}

	public static String getlblCard() {
		return lblCard;
	}

	public static void setlblCard(String lblCard) {
		BuyTicketTheater.lblCard = lblCard;
	}

	public static String getlblInfoStudent() {
		return lblInfoStudent;
	}

	public static void setInfoStudent(String lblInfoStudent) {
		BuyTicketTheater.lblInfoStudent = lblInfoStudent;
	}

	public static String getTheaterType() {
		return theater_type;
	}

	public static void setTheaterType(String theater_type) {
		BuyTicketTheater.theater_type = theater_type;
	}

	public static String getSalon() {
		return salon;
	}

	public static void setSalon(String salon) {
		BuyTicketTheater.salon = salon;
	}

	public static String getSeance() {
		return seance;
	}

	public static void setSeance(String seance) {
		BuyTicketTheater.seance = seance;
	}

	public static String getSeat() {
		return seat;
	}

	public static void setSeat(String seats) {
		BuyTicketTheater.seat = seats;
	}

	public static String getSeatCount() {
		return seatCount;
	}

	public static void setSeatCount(String seatCount) {
		BuyTicketTheater.seatCount = seatCount;
	}

	public static String getStudentCount() {
		return studentCount;
	}

	public static void setStudentCount(String studentCount) {
		BuyTicketTheater.studentCount = studentCount;
	}

	public static String getPrice() {
		return price;
	}

	public static void setPrice(String price) {
		BuyTicketTheater.price = price;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyTicketTheater frame = new BuyTicketTheater();
					frame.setVisible(true);
				} catch (Exception e) {

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuyTicketTheater() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lbl_TheaterName = new JLabel("Oyun Ismi :");
		lbl_TheaterName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TheaterName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TheaterName.setBounds(34, 7, 82, 29);
		panel.add(lbl_TheaterName);

		fld_TheaterName = new JTextField();
		fld_TheaterName.setText(theater);
		fld_TheaterName.setEditable(false);
		fld_TheaterName.setColumns(10);
		fld_TheaterName.setBounds(147, 10, 188, 23);
		panel.add(fld_TheaterName);

		JLabel lbl_Seans = new JLabel("Saat :");
		lbl_Seans.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Seans.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seans.setBounds(54, 115, 82, 29);
		panel.add(lbl_Seans);

		fld_seance = new JTextField();
		fld_seance.setText(seance);
		fld_seance.setEditable(false);
		fld_seance.setColumns(10);
		fld_seance.setBounds(147, 118, 188, 23);
		panel.add(fld_seance);

		JLabel lbl_seat = new JLabel();
		try {
			if (Integer.parseInt(seatCount) > 1) {
				lbl_seat.setText("Koltuklar : ");
				lbl_seat.setBounds(49, 145, 82, 29);
			} else {
				lbl_seat.setText("Koltuk : ");
				lbl_seat.setBounds(57, 145, 82, 29);
			}
		} catch (Exception e) {

		}
		lbl_seat.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_seat.setFont(new Font("SansSerif", Font.PLAIN, 15));

		panel.add(lbl_seat);

		JLabel lblcret = new JLabel("Ucret :");
		lblcret.setHorizontalAlignment(SwingConstants.CENTER);
		lblcret.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblcret.setBounds(49, 280, 82, 29);
		panel.add(lblcret);

		fld_price = new JTextField();
		fld_price.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fld_price.setText(price);
		fld_price.setEditable(false);
		fld_price.setColumns(10);
		fld_price.setBounds(147, 276, 72, 35);
		panel.add(fld_price);

		JLabel lblSalon = new JLabel("Salon :");
		lblSalon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSalon.setBounds(49, 89, 82, 29);
		panel.add(lblSalon);

		fld_Salon = new JTextField();
		fld_Salon.setText(salon);
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(147, 91, 188, 23);
		panel.add(fld_Salon);
		comboBox_seatTheater = new JComboBox();
		comboBox_seatTheater.setBounds(147, 148, 57, 23);
		int count = 0;

		if (seat != null) {
			for (int i = 0; i < seat.length(); i++) {
				if (seat.charAt(i) == '*') {

					count++;
				}
			}

			seats = new String[count];
			int k = 0;

			if (seat.length() <= 3) {
				for (int i = 0; i < seat.length(); i++) {

					if (seat.charAt(i) == '*') {
						seats[k] = seat.charAt(i + 1) + "" + seat.charAt(i + 2);
						k++;
					}

				}
			} else if (seat.length() > 3) {
				for (int i = 0; i < seat.length(); i++) {

					try {
						if (seat.charAt(i) == '*') {
							if (seat.charAt(i + 3) == '*') {
								seats[k] = seat.charAt(i + 1) + "" + seat.charAt(i + 2);
							} else {
								seats[k] = seat.charAt(i + 1) + "" + seat.charAt(i + 2) + "" + seat.charAt(i + 3);
							}
							k++;
						}
					} catch (Exception e) {
						if (seat.charAt(i) == '*') {

							seats[k] = seat.charAt(i + 1) + "" + seat.charAt(i + 2);

							k++;
						}
					}
				}
			}

			Arrays.sort(seats);
			for (String s : seats) {
				comboBox_seatTheater.addItem(s);
			}

		}

		panel.add(comboBox_seatTheater);

		JLabel lbl_theatertype = new JLabel("Oyun Turu :");
		lbl_theatertype.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_theatertype.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_theatertype.setBounds(32, 35, 82, 29);
		panel.add(lbl_theatertype);

		fld_theater_type = new JTextField();
		fld_theater_type.setText(theater_type);
		fld_theater_type.setEditable(false);
		fld_theater_type.setColumns(10);
		fld_theater_type.setBounds(147, 37, 188, 23);
		panel.add(fld_theater_type);

		JLabel lbl_seatCount = new JLabel("Koltuk Sayisi :");
		lbl_seatCount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_seatCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_seatCount.setBounds(15, 194, 118, 29);
		panel.add(lbl_seatCount);

		txt_seatCount = new JTextField();
		txt_seatCount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_seatCount.setFont(new Font("SansSerif", Font.BOLD, 14));
		txt_seatCount.setText(seatCount);
		txt_seatCount.setEditable(false);
		txt_seatCount.setColumns(10);
		txt_seatCount.setBounds(147, 198, 37, 23);
		panel.add(txt_seatCount);

		lbl_Card = new JLabel();
		lbl_Card.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Card.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbl_Card.setBounds(15, 315, 388, 29);
		lbl_Card.setText(lblCard);
		panel.add(lbl_Card);

		JLabel lbl_Student = new JLabel("Ogrenci Sayisi :");
		lbl_Student.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Student.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Student.setBounds(3, 223, 130, 29);
		panel.add(lbl_Student);

		txt_StudentCount = new JTextField();
		txt_StudentCount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_StudentCount.setForeground(Color.BLUE);
		txt_StudentCount.setBackground(UIManager.getColor("Button.background"));
		txt_StudentCount.setText(studentCount);
		txt_StudentCount.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		txt_StudentCount.setEditable(false);
		txt_StudentCount.setColumns(10);
		txt_StudentCount.setBounds(147, 227, 37, 23);
		panel.add(txt_StudentCount);

		try {
			if (Integer.parseInt(txt_StudentCount.getText()) > 0 && Integer.parseInt(txt_StudentCount.getText()) < 2) {
				BuyTicketTheater.lblInfoStudent = "Ogrenci, \"Ogrenci Kimligi\"'ni yaninda bulundurmalidir.";
			} else if (Integer.parseInt(txt_StudentCount.getText()) > 1) {
				BuyTicketTheater.lblInfoStudent = "Ogrenciler, \"Ogrenci Kimlik\"'lerini yanlarinda bulundurmalidir.";
			} else {
				BuyTicketTheater.lblInfoStudent = "";
			}
		} catch (Exception e2) {
		}

		lbl_InfoStudent = new JLabel();
		lbl_InfoStudent.setForeground(new Color(255, 0, 0));
		lbl_InfoStudent.setText(lblInfoStudent);
		lbl_InfoStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InfoStudent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_InfoStudent.setBounds(15, 251, 388, 20);
		panel.add(lbl_InfoStudent);

		JLabel lbl_theaterDate = new JLabel("Tarih :");
		lbl_theaterDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_theaterDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_theaterDate.setBounds(55, 60, 72, 29);
		panel.add(lbl_theaterDate);

		txt_TheaterDate = new JTextField();
		txt_TheaterDate.setText(theaterDate);
		txt_TheaterDate.setEditable(false);
		txt_TheaterDate.setColumns(10);
		txt_TheaterDate.setBounds(147, 64, 188, 23);
		panel.add(txt_TheaterDate);

		JButton btn_print = new JButton("Fisi Yazdir");
		btn_print.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter myWriter = new FileWriter("Bilet.txt");
					myWriter.write(
							"Alınan Tiyatro Oyunu :" + fld_TheaterName.getText() + "\nFiyati : " + fld_price.getText()
									+ "\nSalon: " + fld_Salon.getText() + "\nKoltuklar : " + txt_seatCount.getText()
									+ "\nTarih : " + txt_TheaterDate.getText() + "\nSeans : " + fld_seance.getText()
									+ "\n" + lbl_Card.getText() + "\nBu bilet " + user + "adina kesilmistir");
					myWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_print.setBounds(132, 355, 157, 35);
		panel.add(btn_print);

	}
}
