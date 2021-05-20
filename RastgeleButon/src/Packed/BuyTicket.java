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
import java.awt.Toolkit;

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
import javax.swing.border.BevelBorder;

public class BuyTicket extends JFrame {

	private JPanel contentPane;
	JTextField fld_movie_name;
	JTextField fld_seance;
	JTextField fld_price;
	JTextField fld_Salon;
	JTextField fld_movie_type;
	JTextField txt_seatCount;
	JTextField txt_StudentCount;
	public static JLabel lbl_Card;
	public static String[] seats;
	public static JLabel lbl_InfoStudent;
	private static String movie;
	private static String seance;
	private static String seat;
	private static String price;
	private static String salon;
	private static String movie_type;
	private static String seatCount;
	private static String studentCount;
	private static String lblCard;
	private static String lblInfoStudent;
	private static String user;
	public static JComboBox comboBox_seat;

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		BuyTicket.user = user;
	}

	public static String getMovie() {
		return movie;
	}

	public static void setMovie(String movie) {
		BuyTicket.movie = movie;
	}

	public static String getlblCard() {
		return lblCard;
	}

	public static void setlblCard(String lblCard) {
		BuyTicket.lblCard = lblCard;
	}

	public static String getlblInfoStudent() {
		return lblInfoStudent;
	}

	public static void setInfoStudent(String lblInfoStudent) {
		BuyTicket.lblInfoStudent = lblInfoStudent;
	}

	public static String getMovieType() {
		return movie_type;
	}

	public static void setMovieType(String movie_type) {
		BuyTicket.movie_type = movie_type;
	}

	public static String getSalon() {
		return salon;
	}

	public static void setSalon(String salon) {
		BuyTicket.salon = salon;
	}

	public static String getSeance() {
		return seance;
	}

	public static void setSeance(String seance) {
		BuyTicket.seance = seance;
	}

	public static String getSeat() {
		return seat;
	}

	public static void setSeat(String seats) {
		BuyTicket.seat = seats;
	}

	public static String getSeatCount() {
		return seatCount;
	}

	public static void setSeatCount(String seatCount) {
		BuyTicket.seatCount = seatCount;
	}

	public static String getStudentCount() {
		return studentCount;
	}

	public static void setStudentCount(String studentCount) {
		BuyTicket.studentCount = studentCount;
	}

	public static String getPrice() {
		return price;
	}

	public static void setPrice(String price) {
		BuyTicket.price = price;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyTicket frame = new BuyTicket();
					frame.setVisible(true);
				} catch (Exception e) {

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuyTicket() {
		setTitle("Bilet Satis Sistemi");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuyTicket.class.getResource("/Images/ticket.png")));

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 460);
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

		JLabel lblNewLabel = new JLabel("Film : ");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(50, 30, 110, 25);
		panel.add(lblNewLabel);

		fld_movie_name = new JTextField();
		fld_movie_name.setBackground(new Color(255, 255, 255));
		fld_movie_name.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_movie_name.setText(movie);
		fld_movie_name.setEditable(false);
		fld_movie_name.setColumns(10);
		fld_movie_name.setBounds(181, 30, 222, 25);
		panel.add(fld_movie_name);

		JLabel lblSeans = new JLabel("Seans :");
		lblSeans.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSeans.setBounds(50, 120, 110, 25);
		panel.add(lblSeans);

		fld_seance = new JTextField();
		fld_seance.setBackground(new Color(255, 255, 255));
		fld_seance.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_seance.setText(seance);
		fld_seance.setEditable(false);
		fld_seance.setColumns(10);
		fld_seance.setBounds(181, 120, 222, 25);
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
		lblcret.setBounds(90, 280, 80, 25);
		panel.add(lblcret);

		fld_price = new JTextField();
		fld_price.setBackground(new Color(255, 255, 255));
		fld_price.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_price.setText(price);
		fld_price.setEditable(false);
		fld_price.setColumns(10);
		fld_price.setBounds(181, 280, 100, 25);
		panel.add(fld_price);

		JLabel lblSalon = new JLabel("Salon :");
		lblSalon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSalon.setBounds(50, 90, 110, 25);
		panel.add(lblSalon);

		fld_Salon = new JTextField();
		fld_Salon.setBackground(new Color(255, 255, 255));
		fld_Salon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_Salon.setText(salon);
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(181, 90, 222, 25);
		panel.add(fld_Salon);

		JButton btn_print = new JButton("Fisi Yazdir");
		btn_print.setFocusable(false);
		btn_print.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_print.setBackground(new Color(153, 255, 102));
		btn_print.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter myWriter = new FileWriter("Bilet.txt");
					myWriter.write("Alinan film :" + fld_movie_name.getText() + "\nFiyati : " + fld_price.getText()
							+ "\nSAlon: " + fld_Salon.getText() + "\nKoltuklar : " + txt_seatCount.getText()
							+ "\nSeans : " + fld_seance.getText() + "\n" + lbl_Card.getText() + "\nBu bilet " + user
							+ "adina kesilmistir.");
					myWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_print.setBounds(142, 355, 150, 35);
		panel.add(btn_print);
		comboBox_seat = new JComboBox();
		comboBox_seat.setFocusable(false);
		comboBox_seat.setBackground(new Color(255, 255, 255));
		comboBox_seat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_seat.setBounds(181, 153, 100, 25);
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
				comboBox_seat.addItem(s);
			}

		}

		panel.add(comboBox_seat);

		JLabel lbl_moviyetype = new JLabel("Film Turu :");
		lbl_moviyetype.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_moviyetype.setBounds(50, 60, 110, 25);
		panel.add(lbl_moviyetype);

		fld_movie_type = new JTextField();
		fld_movie_type.setBackground(new Color(255, 255, 255));
		fld_movie_type.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_movie_type.setText(movie_type);
		fld_movie_type.setEditable(false);
		fld_movie_type.setColumns(10);
		fld_movie_type.setBounds(181, 60, 222, 25);
		panel.add(fld_movie_type);

		JLabel lbl_seatCount = new JLabel("Koltuk Sayisi :");
		lbl_seatCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_seatCount.setBounds(50, 200, 110, 25);
		panel.add(lbl_seatCount);

		txt_seatCount = new JTextField();
		txt_seatCount.setBackground(new Color(255, 255, 255));
		txt_seatCount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_seatCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txt_seatCount.setText(seatCount);
		txt_seatCount.setEditable(false);
		txt_seatCount.setColumns(10);
		txt_seatCount.setBounds(180, 200, 50, 25);
		panel.add(txt_seatCount);

		lbl_Card = new JLabel();
		lbl_Card.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Card.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbl_Card.setBounds(15, 315, 388, 29);
		lbl_Card.setText(lblCard);
		panel.add(lbl_Card);

		JLabel lbl_Student = new JLabel("Ogrenci Sayisi :");
		lbl_Student.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Student.setBounds(50, 230, 110, 25);
		panel.add(lbl_Student);

		txt_StudentCount = new JTextField();
		txt_StudentCount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_StudentCount.setForeground(Color.BLUE);
		txt_StudentCount.setBackground(new Color(255, 255, 255));
		txt_StudentCount.setText(studentCount);
		txt_StudentCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txt_StudentCount.setEditable(false);
		txt_StudentCount.setColumns(10);
		txt_StudentCount.setBounds(180, 230, 50, 25);
		panel.add(txt_StudentCount);

		try {
			if (Integer.parseInt(txt_StudentCount.getText()) > 0 && Integer.parseInt(txt_StudentCount.getText()) < 2) {
				BuyTicket.lblInfoStudent = "Ogrenci, Ogrenci Kimligini yaninda bulundurmalidir.";
			} else if (Integer.parseInt(txt_StudentCount.getText()) > 1) {
				BuyTicket.lblInfoStudent = "Ogrenciler, Ogrenci Kimliklerini yanlarinda bulundurmalidir.";
			} else {
				BuyTicket.lblInfoStudent = "";
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

	}
}
