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

public class BuyTicketConcert extends JFrame {

	private JPanel contentPane;
	JTextField fld_ConcertName;
	JTextField fld_hour;
	JTextField fld_price;
	JTextField fld_Artist;
	JTextField fld_concert_Place;
	JTextField txt_ticketCount;
	JTextField txt_StudentCount;
	public static JLabel lbl_Card;
	public static JLabel lbl_InfoStudent;
	private static String concert, hour, artist, price, concert_Date, concert_place, ticketPrice, ticketCount, studentCount, lblCard,
			lblInfoStudent, user;
	private JTextField txt_concertDate;
	private JLabel lbl_TicketPrice;
	private JTextField txt_TicketPrice;

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		BuyTicketConcert.user = user;
	}
	public static String getTicketPrice() {
		return ticketPrice;
	}

	public static void setTicketPrice(String ticketPrice) {
		BuyTicketConcert.ticketPrice = ticketPrice;
	}

	public static String getConcert() {
		return concert;
	}

	public static void setConcert(String concert) {
		BuyTicketConcert.concert = concert;
	}

	public static String getlblCard() {
		return lblCard;
	}

	public static void setlblCard(String lblCard) {
		BuyTicketConcert.lblCard = lblCard;
	}

	public static String getlblInfoStudent() {
		return lblInfoStudent;
	}

	public static void setInfoStudent(String lblInfoStudent) {
		BuyTicketConcert.lblInfoStudent = lblInfoStudent;
	}

	public static String getConcertPlace() {
		return concert_place;
	}

	public static void setConcertPlace(String concert_place) {
		BuyTicketConcert.concert_place = concert_place;
	}

	public static String getConcertDate() {
		return concert_Date;
	}

	public static void setConcertDate(String concert_Date) {
		BuyTicketConcert.concert_Date = concert_Date;
	}

	public static String getHour() {
		return hour;
	}

	public static void setHour(String hour) {
		BuyTicketConcert.hour = hour;
	}

	public static String getArtist() {
		return artist;
	}

	public static void setArtist(String artist) {
		BuyTicketConcert.artist = artist;
	}

	public static String getTicketCount() {
		return ticketCount;
	}

	public static void setTicketCount(String ticketCount) {
		BuyTicketConcert.ticketCount = ticketCount;
	}

	public static String getStudentCount() {
		return studentCount;
	}

	public static void setStudentCount(String studentCount) {
		BuyTicketConcert.studentCount = studentCount;
	}

	public static String getPrice() {
		return price;
	}

	public static void setPrice(String price) {
		BuyTicketConcert.price = price;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyTicketConcert frame = new BuyTicketConcert();
					frame.setVisible(true);
				} catch (Exception e) {

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuyTicketConcert() {

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

		JLabel lbl_ConcertName = new JLabel("Konser Ismi :");
		lbl_ConcertName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ConcertName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertName.setBounds(9, 7, 121, 29);
		panel.add(lbl_ConcertName);

		fld_ConcertName = new JTextField();
		fld_ConcertName.setText(concert);
		fld_ConcertName.setEditable(false);
		fld_ConcertName.setColumns(10);
		fld_ConcertName.setBounds(147, 10, 188, 23);
		panel.add(fld_ConcertName);

		JLabel lbl_Seans = new JLabel("Saat :");
		lbl_Seans.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Seans.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seans.setBounds(54, 115, 82, 29);
		panel.add(lbl_Seans);

		fld_hour = new JTextField();
		fld_hour.setText(hour);
		fld_hour.setEditable(false);
		fld_hour.setColumns(10);
		fld_hour.setBounds(147, 118, 188, 23);
		panel.add(fld_hour);

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

		JLabel lblArtist = new JLabel("Sanatci :");
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblArtist.setBounds(42, 60, 82, 29);
		panel.add(lblArtist);

		fld_Artist = new JTextField();
		fld_Artist.setText(artist);
		fld_Artist.setEditable(false);
		fld_Artist.setColumns(10);
		fld_Artist.setBounds(147, 64, 188, 23);
		panel.add(fld_Artist);

		JLabel lbl_concertPlace = new JLabel("Konser Yeri :");
		lbl_concertPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_concertPlace.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_concertPlace.setBounds(12, 35, 111, 29);
		panel.add(lbl_concertPlace);

		fld_concert_Place = new JTextField();
		fld_concert_Place.setText(concert_place);
		fld_concert_Place.setEditable(false);
		fld_concert_Place.setColumns(10);
		fld_concert_Place.setBounds(147, 37, 188, 23);
		panel.add(fld_concert_Place);

		JLabel lbl_TicketCount = new JLabel("Bilet Adeti :");
		lbl_TicketCount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TicketCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TicketCount.setBounds(25, 194, 118, 29);
		panel.add(lbl_TicketCount);

		txt_ticketCount = new JTextField();
		txt_ticketCount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ticketCount.setFont(new Font("SansSerif", Font.BOLD, 14));
		txt_ticketCount.setText(ticketCount);
		txt_ticketCount.setEditable(false);
		txt_ticketCount.setColumns(10);
		txt_ticketCount.setBounds(147, 198, 37, 23);
		panel.add(txt_ticketCount);

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
				BuyTicketConcert.lblInfoStudent = "Ogrenci, \"Ogrenci Kimligi\"'ni yaninda bulundurmalidir.";
			} else if (Integer.parseInt(txt_StudentCount.getText()) > 1) {
				BuyTicketConcert.lblInfoStudent = "Ogrenciler, \"Ogrenci Kimlik\"'lerini yanlarinda bulundurmalidir.";
			} else {
				BuyTicketConcert.lblInfoStudent = "";
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

		JLabel lbl_concertDate = new JLabel("Tarih :");
		lbl_concertDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_concertDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_concertDate.setBounds(55, 89, 72, 29);
		panel.add(lbl_concertDate);

		txt_concertDate = new JTextField();
		txt_concertDate.setText(concert_Date);
		txt_concertDate.setEditable(false);
		txt_concertDate.setColumns(10);
		txt_concertDate.setBounds(147, 91, 188, 23);
		panel.add(txt_concertDate);
		
		lbl_TicketPrice = new JLabel("Bilet Fiyati :");
		lbl_TicketPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TicketPrice.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TicketPrice.setBounds(24, 155, 118, 29);
		panel.add(lbl_TicketPrice);
		
		txt_TicketPrice = new JTextField();
		txt_TicketPrice.setText(ticketPrice);
		txt_TicketPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txt_TicketPrice.setFont(new Font("SansSerif", Font.BOLD, 14));
		txt_TicketPrice.setEditable(false);
		txt_TicketPrice.setColumns(10);
		txt_TicketPrice.setBounds(147, 159, 37, 23);
		panel.add(txt_TicketPrice);
		
				JButton btn_print = new JButton("Fisi Yazdir");
				btn_print.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btn_print.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							FileWriter myWriter = new FileWriter("Bilet.txt");
							myWriter.write(
									"Alýnan Konser Ismi :" + fld_ConcertName.getText() + "\nBilet Fiyati : " + txt_TicketPrice.getText()
									 + "\nBilet Adeti : " + txt_ticketCount.getText() + "\nToplam Ucret : " + fld_price.getText()
											+ "\nSanatci: " + fld_Artist.getText() + "\nKonser Yeri : " + fld_concert_Place.getText()
											+ "\nTarih : " + txt_concertDate.getText() + "\nSaat : " + fld_hour.getText()
											+ "\n" + lbl_Card.getText() + "\nBu bilet " + user + "adýna kesilmiþtir"
											+"\n------------------------Iyý Eglenceler------------------------");
							myWriter.close();
							System.out.println("Successfully wrote to the file.");
						} catch (IOException e1) {
							System.out.println("An error occurred.");
							e1.printStackTrace();
						}
					}
				});
				btn_print.setBounds(132, 355, 157, 35);
				panel.add(btn_print);

	}
}