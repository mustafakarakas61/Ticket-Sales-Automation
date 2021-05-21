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
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Toolkit;

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
	private static String theater;
	private static String seance;
	private static String seat;
	private static String price;
	private static String salon;
	private static String theater_type;
	private static String theaterDate;
	private static String seatCount;
	private static String studentCount;
	private static String lblCard;
	private static String lblInfoStudent;
	private static String user;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuyTicketTheater.class.getResource("/Images/ticket.png")));
		setTitle("Bilet Satis Sistemi");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lbl_TheaterName = new JLabel("Oyun Ismi :");
		lbl_TheaterName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TheaterName.setBounds(50, 30, 100, 25);
		panel.add(lbl_TheaterName);

		fld_TheaterName = new JTextField();
		fld_TheaterName.setForeground(new Color(0, 0, 0));
		fld_TheaterName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_TheaterName.setBackground(new Color(255, 255, 255));
		fld_TheaterName.setText(theater);
		fld_TheaterName.setEditable(false);
		fld_TheaterName.setColumns(10);
		fld_TheaterName.setBounds(170, 30, 233, 25);
		panel.add(fld_TheaterName);

		JLabel lbl_Seans = new JLabel("Saat :");
		lbl_Seans.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seans.setBounds(50, 150, 100, 25);
		panel.add(lbl_Seans);

		fld_seance = new JTextField();
		fld_seance.setForeground(new Color(0, 0, 0));
		fld_seance.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_seance.setBackground(new Color(255, 255, 255));
		fld_seance.setText(seance);
		fld_seance.setEditable(false);
		fld_seance.setColumns(10);
		fld_seance.setBounds(170, 150, 233, 25);
		panel.add(fld_seance);

		JLabel lbl_seat = new JLabel();
		try {
			if (Integer.parseInt(seatCount) > 1) {
				lbl_seat.setText("Koltuklar : ");
				lbl_seat.setBounds(49, 180, 82, 29);
			} else {
				lbl_seat.setText("Koltuk : ");
				lbl_seat.setBounds(57, 180, 82, 29);
			}
		} catch (Exception e) {

		}
		lbl_seat.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_seat.setFont(new Font("SansSerif", Font.PLAIN, 15));

		panel.add(lbl_seat);

		JLabel lblcret = new JLabel("Ucret :");
		lblcret.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblcret.setBounds(84, 290, 82, 25);
		panel.add(lblcret);

		fld_price = new JTextField();
		fld_price.setForeground(new Color(0, 0, 0));
		fld_price.setBackground(new Color(255, 255, 255));
		fld_price.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_price.setText(price);
		fld_price.setEditable(false);
		fld_price.setColumns(10);
		fld_price.setBounds(170, 290, 72, 25);
		panel.add(fld_price);

		JLabel lblSalon = new JLabel("Salon :");
		lblSalon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSalon.setBounds(50, 120, 100, 25);
		panel.add(lblSalon);

		fld_Salon = new JTextField();
		fld_Salon.setForeground(new Color(0, 0, 0));
		fld_Salon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_Salon.setBackground(new Color(255, 255, 255));
		fld_Salon.setText(salon);
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(170, 120, 233, 25);
		panel.add(fld_Salon);
		comboBox_seatTheater = new JComboBox();
		comboBox_seatTheater.setForeground(new Color(0, 0, 0));
		comboBox_seatTheater.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_seatTheater.setBackground(new Color(255, 255, 255));
		comboBox_seatTheater.setBounds(170, 180, 100, 25);
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
		lbl_theatertype.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_theatertype.setBounds(50, 60, 100, 25);
		panel.add(lbl_theatertype);

		fld_theater_type = new JTextField();
		fld_theater_type.setForeground(new Color(0, 0, 0));
		fld_theater_type.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_theater_type.setBackground(new Color(255, 255, 255));
		fld_theater_type.setText(theater_type);
		fld_theater_type.setEditable(false);
		fld_theater_type.setColumns(10);
		fld_theater_type.setBounds(170, 60, 233, 25);
		panel.add(fld_theater_type);

		JLabel lbl_seatCount = new JLabel("Koltuk Sayisi :");
		lbl_seatCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_seatCount.setBounds(50, 210, 110, 25);
		panel.add(lbl_seatCount);

		txt_seatCount = new JTextField();
		txt_seatCount.setForeground(new Color(0, 0, 0));
		txt_seatCount.setBackground(new Color(255, 255, 255));
		txt_seatCount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_seatCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txt_seatCount.setText(seatCount);
		txt_seatCount.setEditable(false);
		txt_seatCount.setColumns(10);
		txt_seatCount.setBounds(170, 210, 50, 25);
		panel.add(txt_seatCount);

		lbl_Card = new JLabel();
		lbl_Card.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Card.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbl_Card.setBounds(15, 315, 388, 29);
		lbl_Card.setText(lblCard);
		panel.add(lbl_Card);

		JLabel lbl_Student = new JLabel("Ogrenci Sayisi :");
		lbl_Student.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Student.setBounds(50, 240, 110, 25);
		panel.add(lbl_Student);

		txt_StudentCount = new JTextField();
		txt_StudentCount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_StudentCount.setForeground(new Color(0, 0, 0));
		txt_StudentCount.setBackground(new Color(255, 255, 255));
		txt_StudentCount.setText(studentCount);
		txt_StudentCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txt_StudentCount.setEditable(false);
		txt_StudentCount.setColumns(10);
		txt_StudentCount.setBounds(170, 240, 50, 25);
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
		lbl_InfoStudent.setBounds(15, 268, 388, 20);
		panel.add(lbl_InfoStudent);

		JLabel lbl_theaterDate = new JLabel("Tarih :");
		lbl_theaterDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_theaterDate.setBounds(50, 90, 100, 25);
		panel.add(lbl_theaterDate);

		txt_TheaterDate = new JTextField();
		txt_TheaterDate.setForeground(new Color(0, 0, 0));
		txt_TheaterDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txt_TheaterDate.setBackground(new Color(255, 255, 255));
		txt_TheaterDate.setText(theaterDate);
		txt_TheaterDate.setEditable(false);
		txt_TheaterDate.setColumns(10);
		txt_TheaterDate.setBounds(170, 90, 233, 25);
		panel.add(txt_TheaterDate);

		JButton btn_print = new JButton("Fisi Yazdir");
		btn_print.setFocusable(false);
		btn_print.setBackground(new Color(153, 255, 102));
		btn_print.setFont(new Font("SansSerif", Font.PLAIN, 15));
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
		btn_print.setBounds(137, 355, 150, 35);
		panel.add(btn_print);

	}
}
