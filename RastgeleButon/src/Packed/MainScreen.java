package Packed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.DbHelper;
import Helper.Metod_Helper;
import Helper.SeatHelper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Panel;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

import javax.swing.DefaultComboBoxModel;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel cinemaModel;
	private DefaultTableModel theaterModel;
	private static DefaultTableModel concertModel;
	private Object[] cinemaData = null;
	private Object[] theaterData = null;
	private static Object[] concertData = null;
	public static JTable table_Cinema;
	public static JTable table_Theater;
	public static JTable table_Concert;
	private JTextField fld_concertName;
	private JTextField fld_Artist3;
	private JTextField fld_Seance3;
	private JTextField fld_Name_concert;
	private JTextField fld_Surname_concert;
	private JTextField fld_Mail_concert;
	private JTextField fld_cvc3;
	private JTextField fld_CartName3;
	private JTextField fld_CartNumber3;
	DbHelper dbhelper = new DbHelper();
	private JTextField fld_MovieName;
	private JTextField fld_MovieType;
	private JTextField fld_cvc2;
	SeatHelper sh = new SeatHelper();
	Member mmbr = new Member();
	public static int memberID;
	private static user member = new Member();
	private static SAdmin subadmin = new SAdmin();
	private JTextField fld_CinemaDate;
	private JTextField txt_TicketCount;
	private JTextField txt_StudentCount;
	private JTextField txt_GhostTicketPrice;
	static SeatHelper shelper = new SeatHelper();
	private JTextField txt_Total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen(member);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen(user member) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/Images/ticket.png")));

		setTitle("Bilet Satis Sistemi");
		setResizable(false);
		memberID = member.getId();

		cinemaModel = new DefaultTableModel();
		Object[] colCinema = new Object[6];

		colCinema[0] = "Film Adi";
		colCinema[1] = "Film Turu";
		colCinema[2] = "Yonetmen";
		colCinema[3] = "Tarih";
		colCinema[4] = "Salon";
		colCinema[5] = "Seans";

		cinemaModel.setColumnIdentifiers(colCinema);
		cinemaData = new Object[6];

		theaterModel = new DefaultTableModel();
		Object[] colTheater = new Object[5];

		colTheater[0] = "Oyun Adi";
		colTheater[1] = "Oyun Turu";
		colTheater[2] = "Tarih";
		colTheater[3] = "Salon";
		colTheater[4] = "Saat";
		theaterModel.setColumnIdentifiers(colTheater);
		theaterData = new Object[5];

		concertModel = new DefaultTableModel();
		Object[] colConcert = new Object[7];

		colConcert[0] = "Konser Adi";
		colConcert[1] = "Konser Yeri";
		colConcert[2] = "Sanatci";
		colConcert[3] = "Tarih";
		colConcert[4] = "Saat";
		colConcert[5] = "Bilet Adeti";
		colConcert[6] = "Bilet Fiyati";

		concertModel.setColumnIdentifiers(colConcert);
		concertData = new Object[7];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(
				new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JButton btn_Exit = new JButton("Cikis Yap");
		btn_Exit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Exit.setBackground(new Color(153, 204, 255));
		btn_Exit.setFocusable(false);
		btn_Exit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});

		btn_Exit.setBounds(973, 20, 100, 25);
		contentPane.add(btn_Exit);

		JLabel lbl_Name = new JLabel("Hosgeldiniz Sayin " + member.getName() + " " + member.getSurname());
		lbl_Name.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Name.setBounds(10, 20, 400, 20);
		contentPane.add(lbl_Name);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(new Color(255, 255, 255));

		tabbedPane.setBounds(10, 60, 526, 476);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Sinema", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scrollPane_Cinema = new JScrollPane();
		scrollPane_Cinema.setBounds(0, 0, 521, 448);
		w_paneCinema.add(scrollPane_Cinema);
		table_Cinema = new JTable(cinemaModel);
		table_Cinema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Cinema.setFont(new Font("SansSerif", Font.PLAIN, 13));

		table_Cinema.getColumn("Film Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Film Turu").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Yonetmen").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Salon").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Seans").setCellEditor(new TableEditor(new JCheckBox()));

		scrollPane_Cinema.setViewportView(table_Cinema);

		table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(55);
		table_Cinema.getColumnModel().getColumn(0).setResizable(false);

		table_Cinema.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Cinema.getColumnModel().getColumn(1).setResizable(false);

		table_Cinema.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_Cinema.getColumnModel().getColumn(2).setResizable(false);

		table_Cinema.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(3).setResizable(false);

		table_Cinema.getColumnModel().getColumn(4).setPreferredWidth(5);
		table_Cinema.getColumnModel().getColumn(4).setResizable(false);

		table_Cinema.getColumnModel().getColumn(5).setPreferredWidth(5);
		table_Cinema.getColumnModel().getColumn(5).setResizable(false);

		for (int i = 0; i < subadmin.cinemaList().size(); i++) {
			cinemaData[0] = subadmin.cinemaList().get(i).getFilmName();
			cinemaData[1] = subadmin.cinemaList().get(i).getFilmType();
			cinemaData[2] = subadmin.cinemaList().get(i).getFilmDirector();
			cinemaData[3] = subadmin.cinemaList().get(i).getFilmDate();
			cinemaData[4] = subadmin.cinemaList().get(i).getFilmSalon();
			cinemaData[5] = subadmin.cinemaList().get(i).getFilmSeans();
			cinemaModel.addRow(cinemaData);
		}

		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scrollPane_Theater = new JScrollPane();
		scrollPane_Theater.setBounds(0, 0, 521, 448);
		w_paneTheater.add(scrollPane_Theater);

		table_Theater = new JTable(theaterModel);
		table_Theater.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Theater.setFont(new Font("SansSerif", Font.PLAIN, 13));

		table_Theater.getColumn("Oyun Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Oyun Turu").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Salon").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Saat").setCellEditor(new TableEditor(new JCheckBox()));

		scrollPane_Theater.setViewportView(table_Theater);

		table_Theater.getColumnModel().getColumn(0).setResizable(false);
		table_Theater.getColumnModel().getColumn(1).setResizable(false);
		table_Theater.getColumnModel().getColumn(2).setResizable(false);
		table_Theater.getColumnModel().getColumn(3).setResizable(false);
		table_Theater.getColumnModel().getColumn(4).setResizable(false);

		for (int i = 0; i < subadmin.theaterList().size(); i++) {
			theaterData[0] = subadmin.theaterList().get(i).getTiyatroName();
			theaterData[1] = subadmin.theaterList().get(i).getTiyatroType();
			theaterData[2] = subadmin.theaterList().get(i).getTiyatroDate();
			theaterData[3] = subadmin.theaterList().get(i).getTiyatroSalon();
			theaterData[4] = subadmin.theaterList().get(i).getTiyatroSaat();
			theaterModel.addRow(theaterData);
		}

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Konser", null, w_paneConcert, null);

		w_paneConcert.setLayout(null);

		JScrollPane scrollPane_Concert = new JScrollPane();
		scrollPane_Concert.setBounds(0, 0, 521, 448);
		w_paneConcert.add(scrollPane_Concert);

		table_Concert = new JTable(concertModel);
		table_Concert.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Concert.setFont(new Font("SansSerif", Font.PLAIN, 13));

		table_Concert.getColumn("Konser Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Konser Yeri").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Sanatci").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Saat").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Bilet Adeti").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Bilet Fiyati").setCellEditor(new TableEditor(new JCheckBox()));

		scrollPane_Concert.setViewportView(table_Concert);

		table_Concert.getColumnModel().getColumn(0).setResizable(false);
		table_Concert.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_Concert.getColumnModel().getColumn(1).setResizable(false);
		table_Concert.getColumnModel().getColumn(2).setResizable(false);
		table_Concert.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_Concert.getColumnModel().getColumn(3).setResizable(false);
		table_Concert.getColumnModel().getColumn(4).setResizable(false);
		table_Concert.getColumnModel().getColumn(4).setPreferredWidth(50);
		table_Concert.getColumnModel().getColumn(5).setResizable(false);
		table_Concert.getColumnModel().getColumn(6).setResizable(false);
		table_Concert.getColumnModel().getColumn(6).setPreferredWidth(70);
		for (int i = 0; i < subadmin.concertList().size(); i++) {
			concertData[0] = subadmin.concertList().get(i).getConcertName();
			concertData[1] = subadmin.concertList().get(i).getConcertPlace();
			concertData[2] = subadmin.concertList().get(i).getConcertArtist();
			concertData[3] = subadmin.concertList().get(i).getConcertDate();
			concertData[4] = subadmin.concertList().get(i).getConcertTime();
			concertData[5] = subadmin.concertList().get(i).getTicketCount();
			concertData[6] = subadmin.concertList().get(i).getTicketPrice();
			concertModel.addRow(concertData);
		}
		JPanel PaneCinema = new JPanel();
		PaneCinema.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneCinema.setBackground(new Color(255, 255, 255));
		PaneCinema.setBounds(623, 60, 450, 479);
		contentPane.add(PaneCinema);
		PaneCinema.setLayout(null);

		JLabel lbl_Poster = new JLabel("");
		lbl_Poster.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Poster.setBounds(312, 20, 120, 170);
		PaneCinema.add(lbl_Poster);

		JLabel lbl_MovieName = new JLabel("Film Adi:");
		lbl_MovieName.setBackground(new Color(255, 255, 255));
		lbl_MovieName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 45, 100, 20);
		PaneCinema.add(lbl_MovieName);

		JLabel lbl_MovieType = new JLabel("Film Turu:");
		lbl_MovieType.setBackground(new Color(255, 255, 255));
		lbl_MovieType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieType.setBounds(10, 68, 100, 20);
		PaneCinema.add(lbl_MovieType);

		JLabel lbl_Admin = new JLabel("Yonetmen:");
		lbl_Admin.setBackground(new Color(255, 255, 255));
		lbl_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Admin.setBounds(10, 91, 100, 20);
		PaneCinema.add(lbl_Admin);

		JLabel lbl_Salon = new JLabel("Salon:");
		lbl_Salon.setBackground(new Color(255, 255, 255));
		lbl_Salon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon.setBounds(10, 137, 100, 20);
		PaneCinema.add(lbl_Salon);

		JLabel lbl_Seance = new JLabel("Seans:");
		lbl_Seance.setBackground(new Color(255, 255, 255));
		lbl_Seance.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seance.setBounds(10, 160, 100, 20);
		PaneCinema.add(lbl_Seance);

		JButton btn_SelectSeat = new JButton("Koltuk Sec");
		btn_SelectSeat.setEnabled(false);
		btn_SelectSeat.setFocusable(false);
		btn_SelectSeat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_SelectSeat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_SelectSeat.setBackground(new Color(255, 153, 102));
		btn_SelectSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatSelection ks = new SeatSelection();

				ks.setVisible(true);
			}
		});
		btn_SelectSeat.setBounds(10, 180, 100, 22);
		PaneCinema.add(btn_SelectSeat);

		JLabel lbl_PaymentInformation = new JLabel("Odeme Bilgileri");
		lbl_PaymentInformation.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInformation.setBounds(10, 205, 130, 20);
		PaneCinema.add(lbl_PaymentInformation);

		JLabel lblMovieInfo = new JLabel("Film Bilgileri");
		lblMovieInfo.setBackground(new Color(255, 255, 255));
		lblMovieInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieInfo.setBounds(10, 15, 150, 20);
		PaneCinema.add(lblMovieInfo);

		JLabel lbl_MovieName_1 = new JLabel("Ad:");
		lbl_MovieName_1.setBackground(new Color(255, 255, 255));
		lbl_MovieName_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieName_1.setBounds(10, 235, 100, 20);
		PaneCinema.add(lbl_MovieName_1);

		JLabel lbl_MovieType_1 = new JLabel("Soyad:");
		lbl_MovieType_1.setBackground(new Color(255, 255, 255));
		lbl_MovieType_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieType_1.setBounds(10, 258, 100, 20);
		PaneCinema.add(lbl_MovieType_1);

		JLabel lbl_Admin_1 = new JLabel("E-Mail:");
		lbl_Admin_1.setBackground(new Color(255, 255, 255));
		lbl_Admin_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Admin_1.setBounds(10, 281, 100, 20);
		PaneCinema.add(lbl_Admin_1);

		fld_MovieName = new JTextField();
		fld_MovieName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_MovieName.setBackground(new Color(255, 255, 255));
		fld_MovieName.setEditable(false);
		fld_MovieName.setBounds(140, 45, 150, 20);
		PaneCinema.add(fld_MovieName);
		fld_MovieName.setColumns(10);

		fld_MovieType = new JTextField();
		fld_MovieType.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_MovieType.setBackground(new Color(255, 255, 255));
		fld_MovieType.setEditable(false);
		fld_MovieType.setColumns(10);
		fld_MovieType.setBounds(140, 68, 150, 20);
		PaneCinema.add(fld_MovieType);

		JTextField fld_Director = new JTextField();
		fld_Director.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Director.setBackground(new Color(255, 255, 255));
		fld_Director.setEditable(false);
		fld_Director.setColumns(10);
		fld_Director.setBounds(140, 91, 150, 20);
		PaneCinema.add(fld_Director);

		JTextField fld_Salon = new JTextField();
		fld_Salon.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Salon.setBackground(new Color(255, 255, 255));
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(140, 137, 100, 20);
		PaneCinema.add(fld_Salon);

		JTextField fld_Seance = new JTextField();
		fld_Seance.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Seance.setBackground(new Color(255, 255, 255));
		fld_Seance.setEditable(false);
		fld_Seance.setColumns(10);
		fld_Seance.setBounds(140, 160, 100, 20);
		PaneCinema.add(fld_Seance);

		JLabel lbl_PaymentMethod = new JLabel("Odeme Yontemi:");
		lbl_PaymentMethod.setBackground(new Color(255, 255, 255));
		lbl_PaymentMethod.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod.setBounds(10, 304, 120, 20);
		PaneCinema.add(lbl_PaymentMethod);

		JComboBox comboBox_Method = new JComboBox();
		comboBox_Method.setBackground(new Color(255, 255, 255));
		comboBox_Method.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Method.setBounds(140, 304, 150, 25);
		comboBox_Method.addItem("Nakit");
		comboBox_Method.addItem("Banka/Kredi Karti");
		PaneCinema.add(comboBox_Method);

		JPanel w_pane_Kart = new JPanel();
		w_pane_Kart.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart.setBounds(10, 340, 430, 80);
		PaneCinema.add(w_pane_Kart);
		w_pane_Kart.setLayout(null);
		w_pane_Kart.setVisible(false);
		comboBox_Method.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method.getSelectedIndex() == 0) {
					w_pane_Kart.setVisible(false);

				} else {
					w_pane_Kart.setVisible(true);

				}
			}
		});

		JTextField fld_Name_cinema = new JTextField();
		fld_Name_cinema.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Name_cinema.setText(member.getName());
		fld_Name_cinema.setEditable(false);
		fld_Name_cinema.setColumns(10);
		fld_Name_cinema.setBackground(new Color(255, 255, 255));
		fld_Name_cinema.setBounds(140, 235, 150, 20);
		PaneCinema.add(fld_Name_cinema);

		JTextField fld_Surname_cinema = new JTextField();
		fld_Surname_cinema.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Surname_cinema.setText(member.getSurname());
		fld_Surname_cinema.setEditable(false);
		fld_Surname_cinema.setColumns(10);
		fld_Surname_cinema.setBackground(new Color(255, 255, 255));
		fld_Surname_cinema.setBounds(140, 258, 150, 20);
		PaneCinema.add(fld_Surname_cinema);

		JTextField fld_Mail_cinema = new JTextField();
		fld_Mail_cinema.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Mail_cinema.setText(member.getEmail());
		fld_Mail_cinema.setEditable(false);
		fld_Mail_cinema.setColumns(10);
		fld_Mail_cinema.setBackground(new Color(255, 255, 255));
		fld_Mail_cinema.setBounds(140, 281, 150, 20);
		PaneCinema.add(fld_Mail_cinema);

		JLabel lbl_CartName = new JLabel("Kart Uzerindeki Isim:");
		lbl_CartName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName.setBounds(10, 8, 140, 20);
		w_pane_Kart.add(lbl_CartName);

		JLabel lbl_CartNumber = new JLabel("Kart Numarasi:");
		lbl_CartNumber.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber.setBounds(10, 30, 140, 20);
		w_pane_Kart.add(lbl_CartNumber);

		JLabel lbl_LastUsageDate = new JLabel("Son Kullanim Tarihi:");
		lbl_LastUsageDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate.setBounds(10, 52, 140, 20);
		w_pane_Kart.add(lbl_LastUsageDate);

		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setModel(new DefaultComboBoxModel(
				new String[] { "Ay", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		comboBox_Month.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Month.setBounds(160, 52, 60, 22);
		comboBox_Month.addItem("Ay");
		w_pane_Kart.add(comboBox_Month);

		JComboBox comboBox_Year = new JComboBox();

		comboBox_Year.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Year.setBounds(235, 52, 72, 22);
		comboBox_Year.setModel(new DefaultComboBoxModel(new String[] { "Yil", "2021", "2022", "2023", "2024", "2025",
				"2026", "2027", "2028", "2029", "2030", "2031" }));

		w_pane_Kart.add(comboBox_Year);

		JLabel lbl_Cvc = new JLabel("CVC:");
		lbl_Cvc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc.setBounds(325, 52, 40, 20);
		w_pane_Kart.add(lbl_Cvc);

		JTextField fld_cvc = new JTextField();
		fld_cvc.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_cvc.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc.setBounds(374, 52, 46, 20);
		fld_cvc.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_cvc.getText().length() <= 2 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_cvc.setEditable(true);
					} else {
						fld_cvc.setEditable(false);
					}

				} else {
					fld_cvc.setEditable(false);

				}
			}
		});
		w_pane_Kart.add(fld_cvc);
		fld_cvc.setColumns(10);

		JTextField fld_CartName = new JTextField();
		fld_CartName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_CartName.setColumns(10);
		fld_CartName.setBackground(Color.WHITE);
		fld_CartName.setBounds(160, 8, 260, 20);
		fld_CartName.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartName.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartName.setEditable(true);
					} else {
						fld_CartName.setEditable(false);
					}

				} else {
					fld_CartName.setEditable(false);

				}
			}
		});
		w_pane_Kart.add(fld_CartName);

		JTextField fld_CartNumber = new JTextField();
		fld_CartNumber.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_CartNumber.setColumns(10);
		fld_CartNumber.setBackground(Color.WHITE);
		fld_CartNumber.setBounds(160, 30, 260, 20);
		fld_CartNumber.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartNumber.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartNumber.setEditable(true);
					} else {
						fld_CartNumber.setEditable(false);
					}

				} else {
					fld_CartNumber.setEditable(false);

				}
			}
		});
		w_pane_Kart.add(fld_CartNumber);

		JButton btn_MyTickets = new JButton("Biletlerim");
		btn_MyTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyTickets mT = new MyTickets();

				mT.setVisible(true);
			}
		});
		btn_MyTickets.setFocusable(false);
		btn_MyTickets.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_MyTickets.setBounds(110, 435, 100, 30);
		PaneCinema.add(btn_MyTickets);
		btn_MyTickets.setForeground(new Color(0, 0, 0));
		btn_MyTickets.setBackground(new Color(255, 255, 153));
		btn_MyTickets.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JButton btn_BuyTicket = new JButton("Bilet Al");
		btn_BuyTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

//////////////////////////---------------------------------------

				////////////////////////////////////////////////// -----------------------

				if (comboBox_Method.getSelectedIndex() == 1) {
					BuyTicket.setlblCard("Ucret, BANKA/KREDI KARTI ile odenmistir. Borcunuz yoktur.");
					BuyTicket.setPrice("Odendi");

					if (fld_MovieName.getText().length() == 0 || fld_MovieType.getText().length() == 0
							|| fld_Director.getText().length() == 0 || fld_Salon.getText().length() == 0
							|| fld_Seance.getText().length() == 0 || fld_Name_cinema.getText().length() == 0
							|| fld_Surname_cinema.getText().length() == 0 || fld_Mail_cinema.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (fld_CartName.getText().length() == 0 || fld_CartNumber.getText().length() == 0
							|| fld_cvc.getText().length() == 0 || comboBox_Month.getSelectedIndex() == 0
							|| comboBox_Year.getSelectedIndex() == 0) {
						if (fld_CartName.getText().length() == 0) {
							fld_CartName.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_CartName.getText().length() > 0) {
										fld_CartName.setBackground(Color.white);
									} else {
										fld_CartName.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_CartName.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}
						if (fld_CartNumber.getText().length() == 0) {
							fld_CartNumber.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_CartNumber.getText().length() == 16) {
										fld_CartNumber.setBackground(Color.white);
									} else {
										fld_CartNumber.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_CartNumber.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}
						if (fld_cvc.getText().length() == 0) {
							fld_cvc.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_cvc.getText().length() == 3) {
										fld_cvc.setBackground(Color.white);
									} else {
										fld_cvc.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_cvc.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}

						JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
								JOptionPane.ERROR_MESSAGE);
					}

					else {

						BuyTicket ticket = new BuyTicket();

						if (ticket.comboBox_seat.getItemCount() == 0) {
							JOptionPane.showMessageDialog(null, "Lutfen Koltuk Seciniz.", "Mesaj",
									JOptionPane.INFORMATION_MESSAGE);

						} else if (fld_CartNumber.getText().length() != 16 || fld_cvc.getText().length() != 3) {
							JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
									JOptionPane.ERROR_MESSAGE);
						}

						else {
							if (JOptionPane.showConfirmDialog(null, "Satin Almayi Onayliyor musunuz?", "Dikkat!",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								try {
									int filmID = subadmin.cinemaList().get(MainScreen.table_Cinema.getSelectedRow())
											.getFilmID();
									Arrays.sort(SeatSelection.seats);
									for (String s : SeatSelection.seats) {
										shelper.seatAdd(s, "d", filmID, member.getId());
									}
								} catch (Exception e2) {

								}

								Metod_Helper.showMsg("Odemeniz Aliniyor. Lutfen Bekleyiniz...");
								try {
									TimeUnit.SECONDS.sleep(3);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Metod_Helper.showMsg("Odemeniz Basariyla Gerceklesti");
								ticket.setVisible(true);
							}

						}
					}

				} else {

					BuyTicket.setlblCard(BuyTicket.getPrice() + " odemeniz vardir. Iyi gunler Dileriz.");
					if (fld_MovieName.getText().length() == 0 || fld_MovieType.getText().length() == 0
							|| fld_Director.getText().length() == 0 || fld_Salon.getText().length() == 0
							|| fld_Seance.getText().length() == 0 || fld_Name_cinema.getText().length() == 0
							|| fld_Surname_cinema.getText().length() == 0 || fld_Mail_cinema.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						BuyTicket ticket = new BuyTicket();

						if (ticket.comboBox_seat.getItemCount() == 0) {
							JOptionPane.showMessageDialog(null, "Lutfen Koltuk Seciniz.", "Mesaj",
									JOptionPane.INFORMATION_MESSAGE);

						} else {
							if (JOptionPane.showConfirmDialog(null, "Satin Almayi Onayliyor musunuz?", "Dikkat!",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								try {
									int filmID = subadmin.cinemaList().get(MainScreen.table_Cinema.getSelectedRow())
											.getFilmID();
									Arrays.sort(SeatSelection.seats);
									for (String s : SeatSelection.seats) {
										shelper.seatAdd(s, "d", filmID, member.getId());
									}
								} catch (Exception e2) {

								}
								Metod_Helper.showMsg("succes");
								ticket.setVisible(true);
							} else {
							}

						}
					}
				}

			}
		});
		btn_BuyTicket.setFocusable(false);
		btn_BuyTicket.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_BuyTicket.setForeground(new Color(0, 0, 0));
		btn_BuyTicket.setBackground(new Color(153, 255, 153));
		btn_BuyTicket.setBounds(240, 435, 100, 30);
		PaneCinema.add(btn_BuyTicket);
		btn_BuyTicket.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lbl_CinemaDate = new JLabel("Tarih:");
		lbl_CinemaDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CinemaDate.setBackground(Color.WHITE);
		lbl_CinemaDate.setBounds(10, 114, 100, 20);
		PaneCinema.add(lbl_CinemaDate);

		fld_CinemaDate = new JTextField();
		fld_CinemaDate.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_CinemaDate.setEditable(false);
		fld_CinemaDate.setColumns(10);
		fld_CinemaDate.setBackground(Color.WHITE);
		fld_CinemaDate.setBounds(140, 114, 100, 20);
		PaneCinema.add(fld_CinemaDate);
		BuyTicket.setUser(member.getName() + " " + member.getSurname() + " ");
		BuyTicketTheater.setUser(member.getName() + " " + member.getSurname() + " ");

		JPanel PaneTheater = new JPanel();
		PaneTheater.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneTheater.setBackground(new Color(255, 255, 255));
		PaneTheater.setBounds(623, 60, 450, 479);
		contentPane.add(PaneTheater);
		PaneTheater.setLayout(null);

		JLabel lbl_Poster2 = new JLabel("");
		lbl_Poster2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Poster2.setBounds(312, 20, 120, 170);
		PaneTheater.add(lbl_Poster2);

		JLabel lbl_TheaterName = new JLabel("Oyun Adi:");
		lbl_TheaterName.setBackground(new Color(255, 255, 255));
		lbl_TheaterName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TheaterName.setBounds(10, 45, 100, 20);
		PaneTheater.add(lbl_TheaterName);

		JLabel lbl_TheaterType = new JLabel("Oyun Turu:");
		lbl_TheaterType.setBackground(new Color(255, 255, 255));
		lbl_TheaterType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TheaterType.setBounds(10, 68, 100, 20);
		PaneTheater.add(lbl_TheaterType);

		JLabel lbl_Datee2 = new JLabel("Tarih:");
		lbl_Datee2.setBackground(new Color(255, 255, 255));
		lbl_Datee2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Datee2.setBounds(10, 91, 100, 20);
		PaneTheater.add(lbl_Datee2);

		JLabel lbl_Salon2 = new JLabel("Salon:");
		lbl_Salon2.setBackground(new Color(255, 255, 255));
		lbl_Salon2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon2.setBounds(10, 114, 100, 20);
		PaneTheater.add(lbl_Salon2);

		JLabel lbl_Seance2 = new JLabel("Saat:");
		lbl_Seance2.setBackground(new Color(255, 255, 255));
		lbl_Seance2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seance2.setBounds(10, 137, 100, 20);
		PaneTheater.add(lbl_Seance2);

		JTextField txt_theaterYear = new JTextField();
		txt_theaterYear.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txt_theaterYear.setBackground(new Color(255, 255, 255));
		txt_theaterYear.setEditable(false);
		txt_theaterYear.setBounds(140, 91, 100, 20);
		PaneTheater.add(txt_theaterYear);
		PaneTheater.setVisible(false);

		JButton btn_SelectSeat2 = new JButton("Koltuk Sec");
		btn_SelectSeat2.setEnabled(false);
		btn_SelectSeat2.setFocusable(false);
		btn_SelectSeat2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_SelectSeat2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_SelectSeat2.setBackground(new Color(255, 153, 102));
		btn_SelectSeat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatSelectionTheater ks = new SeatSelectionTheater();
				ks.setVisible(true);
			}
		});
		btn_SelectSeat2.setBounds(10, 160, 100, 22);
		PaneTheater.add(btn_SelectSeat2);

		JLabel lbl_PaymentInformation2 = new JLabel("Odeme Bilgileri");
		lbl_PaymentInformation2.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInformation2.setBounds(10, 205, 130, 20);
		PaneTheater.add(lbl_PaymentInformation2);

		JLabel lbl_TheaterInfo = new JLabel("Tiyatro Bilgileri");
		lbl_TheaterInfo.setBackground(new Color(255, 255, 255));
		lbl_TheaterInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_TheaterInfo.setBounds(10, 15, 150, 20);
		PaneTheater.add(lbl_TheaterInfo);

		JLabel lbl_UserName2 = new JLabel("Ad:");
		lbl_UserName2.setBackground(new Color(255, 255, 255));
		lbl_UserName2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_UserName2.setBounds(10, 235, 100, 20);
		PaneTheater.add(lbl_UserName2);

		JLabel lbl_UserSurname2 = new JLabel("Soyad:");
		lbl_UserSurname2.setBackground(new Color(255, 255, 255));
		lbl_UserSurname2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_UserSurname2.setBounds(10, 258, 100, 20);
		PaneTheater.add(lbl_UserSurname2);

		JLabel lbl_UserMail2 = new JLabel("E-Mail:");
		lbl_UserMail2.setBackground(new Color(255, 255, 255));
		lbl_UserMail2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_UserMail2.setBounds(10, 281, 100, 20);
		PaneTheater.add(lbl_UserMail2);

		JTextField fld_TheaterName = new JTextField();
		fld_TheaterName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_TheaterName.setBackground(new Color(255, 255, 255));
		fld_TheaterName.setEditable(false);
		fld_TheaterName.setBounds(140, 45, 150, 20);
		PaneTheater.add(fld_TheaterName);
		fld_TheaterName.setColumns(10);

		JTextField fld_ThetaerType = new JTextField();
		fld_ThetaerType.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_ThetaerType.setBackground(new Color(255, 255, 255));
		fld_ThetaerType.setEditable(false);
		fld_ThetaerType.setColumns(10);
		fld_ThetaerType.setBounds(140, 68, 150, 20);
		PaneTheater.add(fld_ThetaerType);

		JTextField fld_Salon22 = new JTextField();
		fld_Salon22.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Salon22.setBackground(new Color(255, 255, 255));
		fld_Salon22.setEditable(false);
		fld_Salon22.setColumns(10);
		fld_Salon22.setBounds(140, 114, 100, 20);
		PaneTheater.add(fld_Salon22);

		JTextField fld_Seance2 = new JTextField();
		fld_Seance2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Seance2.setBackground(new Color(255, 255, 255));
		fld_Seance2.setEditable(false);
		fld_Seance2.setColumns(10);
		fld_Seance2.setBounds(140, 137, 100, 20);
		PaneTheater.add(fld_Seance2);

		JLabel lbl_PaymentMethod2 = new JLabel("Odeme Yontemi:");
		lbl_PaymentMethod2.setBackground(new Color(255, 255, 255));
		lbl_PaymentMethod2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod2.setBounds(10, 304, 120, 20);
		PaneTheater.add(lbl_PaymentMethod2);

		JComboBox comboBox_Method2 = new JComboBox();
		comboBox_Method2.setBackground(new Color(255, 255, 255));
		comboBox_Method2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Method2.setBounds(140, 304, 150, 25);
		comboBox_Method2.addItem("Nakit");
		comboBox_Method2.addItem("Banka/Kredi Karti");
		PaneTheater.add(comboBox_Method2);

		JPanel w_pane_Kart2 = new JPanel();
		w_pane_Kart2.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart2.setBounds(10, 340, 430, 80);
		PaneTheater.add(w_pane_Kart2);
		w_pane_Kart2.setLayout(null);
		w_pane_Kart2.setVisible(false);
		comboBox_Method2.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method2.getSelectedIndex() == 0) {
					w_pane_Kart2.setVisible(false);

				} else {
					w_pane_Kart2.setVisible(true);

				}
			}
		});

		JTextField fld_Name_theater = new JTextField();
		fld_Name_theater.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Name_theater.setText(member.getName());
		fld_Name_theater.setEditable(false);
		fld_Name_theater.setColumns(10);
		fld_Name_theater.setBackground(new Color(255, 255, 255));
		fld_Name_theater.setBounds(140, 235, 150, 20);
		PaneTheater.add(fld_Name_theater);

		JTextField fld_Surname_theater = new JTextField();
		fld_Surname_theater.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Surname_theater.setText(member.getSurname());
		fld_Surname_theater.setEditable(false);
		fld_Surname_theater.setColumns(10);
		fld_Surname_theater.setBackground(new Color(255, 255, 255));
		fld_Surname_theater.setBounds(140, 258, 150, 20);
		PaneTheater.add(fld_Surname_theater);

		JTextField fld_Mail_theater = new JTextField();
		fld_Mail_theater.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Mail_theater.setText(member.getEmail());
		fld_Mail_theater.setEditable(false);
		fld_Mail_theater.setColumns(10);
		fld_Mail_theater.setBackground(new Color(255, 255, 255));
		fld_Mail_theater.setBounds(140, 281, 150, 20);
		PaneTheater.add(fld_Mail_theater);

		JLabel lbl_CartName2 = new JLabel("Kart Uzerindeki isim:");
		lbl_CartName2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName2.setBounds(10, 8, 140, 20);
		w_pane_Kart2.add(lbl_CartName2);

		JLabel lbl_CartNumber2 = new JLabel("Kart Numarasi:");
		lbl_CartNumber2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber2.setBounds(10, 30, 140, 20);
		w_pane_Kart2.add(lbl_CartNumber2);

		JLabel lbl_LastUsageDate2 = new JLabel("Son Kullanim Tarihi:");
		lbl_LastUsageDate2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate2.setBounds(10, 52, 140, 20);
		w_pane_Kart2.add(lbl_LastUsageDate2);

		JComboBox comboBox_Month2 = new JComboBox();
		comboBox_Month2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Month2.setBounds(160, 52, 60, 22);
		comboBox_Month2.setModel(new DefaultComboBoxModel(
				new String[] { "Ay", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		w_pane_Kart2.add(comboBox_Month2);

		JComboBox comboBox_Year2 = new JComboBox();
		comboBox_Year2.setModel(new DefaultComboBoxModel(new String[] { "Yil", "2021", "2022", "2023", "2024", "2025",
				"2026", "2027", "2028", "2029", "2030", "2031" }));
		comboBox_Year2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Year2.setBounds(235, 52, 72, 22);

		w_pane_Kart2.add(comboBox_Year2);

		JLabel lbl_Cvc2 = new JLabel("CVC:");
		lbl_Cvc2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc2.setBounds(325, 52, 40, 20);
		w_pane_Kart2.add(lbl_Cvc2);

		fld_cvc2 = new JTextField();
		fld_cvc2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_cvc2.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc2.setBounds(374, 52, 46, 20);
		fld_cvc2.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_cvc2.getText().length() <= 2 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_cvc2.setEditable(true);
					} else {
						fld_cvc2.setEditable(false);
					}

				} else {
					fld_cvc2.setEditable(false);

				}
			}
		});
		w_pane_Kart2.add(fld_cvc2);
		fld_cvc2.setColumns(10);

		JTextField fld_CartName22 = new JTextField();
		fld_CartName22.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_CartName22.setColumns(10);
		fld_CartName22.setBackground(Color.WHITE);
		fld_CartName22.setBounds(160, 8, 260, 20);
		fld_CartName22.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartName22.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartName22.setEditable(true);
					} else {
						fld_CartName22.setEditable(false);
					}

				} else {
					fld_CartName22.setEditable(false);

				}
			}
		});
		w_pane_Kart2.add(fld_CartName22);

		JTextField fld_CartNumber22 = new JTextField();
		fld_CartNumber22.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_CartNumber22.setColumns(10);
		fld_CartNumber22.setBackground(Color.WHITE);
		fld_CartNumber22.setBounds(160, 30, 260, 20);
		fld_CartNumber22.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartNumber22.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartNumber22.setEditable(true);
					} else {
						fld_CartNumber22.setEditable(false);
					}

				} else {
					fld_CartNumber22.setEditable(false);

				}
			}
		});
		w_pane_Kart2.add(fld_CartNumber22);

		JButton btn_MyTickets2 = new JButton("Biletlerim");
		btn_MyTickets2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyTicketsTheater mTT = new MyTicketsTheater();

				mTT.setVisible(true);

			}
		});
		btn_MyTickets2.setFocusable(false);
		btn_MyTickets2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_MyTickets2.setBounds(110, 435, 100, 30);
		PaneTheater.add(btn_MyTickets2);
		btn_MyTickets2.setForeground(new Color(0, 0, 0));
		btn_MyTickets2.setBackground(new Color(255, 255, 153));
		btn_MyTickets2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JButton btn_BuyTicket2 = new JButton("Bilet Al");
		btn_BuyTicket2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

//////////////////////////---------------------------------------

//////////////////////////////////////////////////-----------------------

				if (comboBox_Method2.getSelectedIndex() == 1) {
					BuyTicketTheater.setlblCard("Ucret, BANKA/KREDI KARTI ile odenmistir. Borcunuz yoktur.");
					BuyTicketTheater.setPrice("Odendi");

					if (fld_TheaterName.getText().length() == 0 || fld_ThetaerType.getText().length() == 0
							|| fld_Salon22.getText().length() == 0 || fld_Seance2.getText().length() == 0
							|| fld_Name_theater.getText().length() == 0 || fld_Surname_theater.getText().length() == 0
							|| fld_Mail_theater.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (fld_CartName22.getText().length() == 0 || fld_CartNumber22.getText().length() == 0
							|| fld_cvc2.getText().length() == 0 || comboBox_Month2.getSelectedIndex() == 0
							|| comboBox_Year2.getSelectedIndex() == 0) {
						if (fld_CartName22.getText().length() == 0) {
							fld_CartName22.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_CartName22.getText().length() > 0) {
										fld_CartName22.setBackground(Color.white);
									} else {
										fld_CartName22.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_CartName22.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}
						if (fld_CartNumber22.getText().length() == 0) {
							fld_CartNumber22.getDocument()
									.addDocumentListener((DocumentListener) new DocumentListener() {

										@Override
										public void insertUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub
											if (fld_CartNumber22.getText().length() == 16) {
												fld_CartNumber22.setBackground(Color.white);
											} else {
												fld_CartNumber22.setBackground(Color.ORANGE);
											}
										}

										@Override
										public void removeUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub
											fld_CartNumber22.setBackground(Color.white);
										}

										@Override
										public void changedUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub

										}

									});
						}
						if (fld_cvc2.getText().length() == 0) {
							fld_cvc2.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_cvc2.getText().length() == 3) {
										fld_cvc2.setBackground(Color.white);
									} else {
										fld_cvc2.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_cvc2.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}

						JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
								JOptionPane.ERROR_MESSAGE);
					}

					else {

						BuyTicketTheater ticketTheater = new BuyTicketTheater();

						if (ticketTheater.comboBox_seatTheater.getItemCount() == 0) {
							JOptionPane.showMessageDialog(null, "Lutfen Koltuk Seciniz.", "Mesaj",
									JOptionPane.INFORMATION_MESSAGE);

						} else if (fld_CartNumber22.getText().length() != 16 || fld_cvc2.getText().length() != 3) {
							JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
									JOptionPane.ERROR_MESSAGE);
						}

						else {
							if (JOptionPane.showConfirmDialog(null, "Satin Almayi Onayliyor musunuz?", "Dikkat!",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								try {
									// secilen koltugu dolu olarak ekleme
									int theaterID = subadmin.theaterList()
											.get(MainScreen.table_Theater.getSelectedRow()).getTiyatroID();

									Arrays.sort(SeatSelectionTheater.seats);
									for (String s : SeatSelectionTheater.seats) {
										shelper.seatAddTheater(s, "d", theaterID, member.getId());
									}
								} catch (Exception e2) {

								}

								Metod_Helper.showMsg("Odemeniz Aliniyor. Lutfen Bekleyiniz...");
								try {
									TimeUnit.SECONDS.sleep(3);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Metod_Helper.showMsg("Odemeniz Basariyla Gerceklesti");
								ticketTheater.setVisible(true);
							}

						}
					}

				} else {

					BuyTicketTheater.setlblCard(BuyTicketTheater.getPrice() + " odemeniz vardir. Iyi gunler Dileriz.");
					if (fld_TheaterName.getText().length() == 0 || fld_ThetaerType.getText().length() == 0
							|| txt_theaterYear.getText().length() == 0 || fld_Salon22.getText().length() == 0
							|| fld_Seance2.getText().length() == 0 || fld_Name_theater.getText().length() == 0
							|| fld_Surname_theater.getText().length() == 0
							|| fld_Mail_theater.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						BuyTicketTheater ticketTheater = new BuyTicketTheater();
						if (ticketTheater.comboBox_seatTheater.getItemCount() == 0) {
							JOptionPane.showMessageDialog(null, "Lutfen Koltuk Seciniz.", "Mesaj",
									JOptionPane.INFORMATION_MESSAGE);

						} else {
							if (JOptionPane.showConfirmDialog(null, "Satin Almayi Onayliyor musunuz?", "Dikkat!",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								try {
									// secilen koltugu dolu olarak ekleme
									int theaterID = subadmin.theaterList()
											.get(MainScreen.table_Theater.getSelectedRow()).getTiyatroID();

									Arrays.sort(SeatSelectionTheater.seats);
									for (String s : SeatSelectionTheater.seats) {
										shelper.seatAddTheater(s, "d", theaterID, member.getId());
									}
								} catch (Exception e2) {

								}
								Metod_Helper.showMsg("succes");
								ticketTheater.setVisible(true);
							} else {
								// no option
							}

						}
					}
				}

			}
		});
		btn_BuyTicket2.setFocusable(false);
		btn_BuyTicket2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_BuyTicket2.setForeground(new Color(0, 0, 0));
		btn_BuyTicket2.setBackground(new Color(153, 255, 153));
		btn_BuyTicket2.setBounds(240, 435, 100, 30);
		PaneTheater.add(btn_BuyTicket2);
		btn_BuyTicket2.setFont(new Font("SansSerif", Font.BOLD, 15));

		JPanel PaneConcert = new JPanel();
		PaneConcert.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneConcert.setBackground(new Color(255, 255, 255));
		PaneConcert.setBounds(623, 60, 450, 479);
		contentPane.add(PaneConcert);
		PaneConcert.setLayout(null);

		JLabel lbl_Poster3 = new JLabel("");
		lbl_Poster3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Poster3.setBounds(312, 20, 120, 159);
		PaneConcert.add(lbl_Poster3);

		JLabel lbl_ConcertName = new JLabel("Konser Adi:");
		lbl_ConcertName.setBackground(new Color(255, 255, 255));
		lbl_ConcertName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertName.setBounds(10, 45, 100, 20);
		PaneConcert.add(lbl_ConcertName);

		JLabel lbl_ConcertType = new JLabel("Konser Yeri:");
		lbl_ConcertType.setBackground(new Color(255, 255, 255));
		lbl_ConcertType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertType.setBounds(10, 68, 100, 20);
		PaneConcert.add(lbl_ConcertType);

		JLabel lbl_Date3 = new JLabel("Tarih:");
		lbl_Date3.setBackground(new Color(255, 255, 255));
		lbl_Date3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Date3.setBounds(10, 114, 100, 20);
		PaneConcert.add(lbl_Date3);

		JLabel lbl_Salon3 = new JLabel("Sanatci:");
		lbl_Salon3.setBackground(new Color(255, 255, 255));
		lbl_Salon3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon3.setBounds(10, 91, 100, 20);
		PaneConcert.add(lbl_Salon3);

		JLabel lbl_Seance3 = new JLabel("Saat:");
		lbl_Seance3.setBackground(new Color(255, 255, 255));
		lbl_Seance3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seance3.setBounds(10, 137, 100, 20);
		PaneConcert.add(lbl_Seance3);

		JLabel lbl_PaymentInformation3 = new JLabel("Odeme Bilgileri");
		lbl_PaymentInformation3.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInformation3.setBounds(10, 214, 130, 20);
		PaneConcert.add(lbl_PaymentInformation3);

		JLabel lbl_ConcertInfo = new JLabel("Konser Bilgileri");
		lbl_ConcertInfo.setBackground(new Color(255, 255, 255));
		lbl_ConcertInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_ConcertInfo.setBounds(10, 15, 150, 20);
		PaneConcert.add(lbl_ConcertInfo);

		JLabel lbl_UserName3 = new JLabel("Ad:");
		lbl_UserName3.setBackground(new Color(255, 255, 255));
		lbl_UserName3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_UserName3.setBounds(10, 235, 100, 20);
		PaneConcert.add(lbl_UserName3);

		JLabel lbl_UserSurname3 = new JLabel("Soyad:");
		lbl_UserSurname3.setBackground(new Color(255, 255, 255));
		lbl_UserSurname3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_UserSurname3.setBounds(10, 258, 100, 20);
		PaneConcert.add(lbl_UserSurname3);

		JLabel lbl_UserMail3 = new JLabel("E-Mail:");
		lbl_UserMail3.setBackground(new Color(255, 255, 255));
		lbl_UserMail3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_UserMail3.setBounds(10, 281, 100, 20);
		PaneConcert.add(lbl_UserMail3);

		fld_concertName = new JTextField();
		fld_concertName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_concertName.setBackground(new Color(255, 255, 255));
		fld_concertName.setEditable(false);
		fld_concertName.setBounds(140, 45, 150, 20);
		PaneConcert.add(fld_concertName);
		fld_concertName.setColumns(10);

		fld_Artist3 = new JTextField();
		fld_Artist3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Artist3.setBackground(new Color(255, 255, 255));
		fld_Artist3.setEditable(false);
		fld_Artist3.setColumns(10);
		fld_Artist3.setBounds(140, 91, 150, 20);
		PaneConcert.add(fld_Artist3);

		fld_Seance3 = new JTextField();
		fld_Seance3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Seance3.setBackground(new Color(255, 255, 255));
		fld_Seance3.setEditable(false);
		fld_Seance3.setColumns(10);
		fld_Seance3.setBounds(140, 137, 100, 20);
		PaneConcert.add(fld_Seance3);

		JLabel lbl_PaymentMethod3 = new JLabel("Odeme Yontemi:");
		lbl_PaymentMethod3.setBackground(new Color(255, 255, 255));
		lbl_PaymentMethod3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod3.setBounds(10, 304, 120, 20);
		PaneConcert.add(lbl_PaymentMethod3);

		JComboBox comboBox_Method3 = new JComboBox();
		comboBox_Method3.setBackground(new Color(255, 255, 255));
		comboBox_Method3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Method3.setBounds(140, 304, 150, 25);
		comboBox_Method3.addItem("Nakit");
		comboBox_Method3.addItem("Banka/Kredi Karti");
		PaneConcert.add(comboBox_Method3);

		JPanel w_pane_Kart3 = new JPanel();
		w_pane_Kart3.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart3.setBounds(10, 340, 430, 80);
		PaneConcert.add(w_pane_Kart3);
		w_pane_Kart3.setLayout(null);
		w_pane_Kart3.setVisible(false);
		comboBox_Method3.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method3.getSelectedIndex() == 0) {
					w_pane_Kart3.setVisible(false);

				} else {
					w_pane_Kart3.setVisible(true);

				}
			}
		});

		fld_Name_concert = new JTextField();
		fld_Name_concert.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Name_concert.setText(member.getName());
		fld_Name_concert.setEditable(false);
		fld_Name_concert.setColumns(10);
		fld_Name_concert.setBackground(new Color(255, 255, 255));
		fld_Name_concert.setBounds(140, 235, 150, 20);
		PaneConcert.add(fld_Name_concert);

		fld_Surname_concert = new JTextField();
		fld_Surname_concert.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Surname_concert.setText(member.getSurname());
		fld_Surname_concert.setEditable(false);
		fld_Surname_concert.setColumns(10);
		fld_Surname_concert.setBackground(new Color(255, 255, 255));
		fld_Surname_concert.setBounds(140, 258, 150, 20);
		PaneConcert.add(fld_Surname_concert);

		fld_Mail_concert = new JTextField();
		fld_Mail_concert.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_Mail_concert.setText(member.getEmail());
		fld_Mail_concert.setEditable(false);
		fld_Mail_concert.setColumns(10);
		fld_Mail_concert.setBackground(new Color(255, 255, 255));
		fld_Mail_concert.setBounds(140, 281, 150, 20);
		PaneConcert.add(fld_Mail_concert);

		JLabel lbl_CartName3 = new JLabel("Kart Uzerindeki isim:");
		lbl_CartName3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName3.setBounds(10, 8, 140, 20);
		w_pane_Kart3.add(lbl_CartName3);

		JLabel lbl_CartNumber3 = new JLabel("Kart Numarasi:");
		lbl_CartNumber3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber3.setBounds(10, 30, 140, 20);
		w_pane_Kart3.add(lbl_CartNumber3);

		JLabel lbl_LastUsageDate3 = new JLabel("Son Kullanim Tarihi:");
		lbl_LastUsageDate3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate3.setBounds(10, 52, 140, 20);
		w_pane_Kart3.add(lbl_LastUsageDate3);

		JComboBox comboBox_Month3 = new JComboBox();
		comboBox_Month3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Month3.setBounds(160, 52, 60, 22);
		comboBox_Month3.setModel(new DefaultComboBoxModel(
				new String[] { "Ay", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		w_pane_Kart3.add(comboBox_Month3);

		JComboBox comboBox_Year3 = new JComboBox();
		comboBox_Year3.setModel(new DefaultComboBoxModel(new String[] { "Yil", "2021", "2022", "2023", "2024", "2025",
				"2026", "2027", "2028", "2029", "2030", "2031" }));
		comboBox_Year3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		comboBox_Year3.setBounds(235, 52, 72, 22);

		w_pane_Kart3.add(comboBox_Year3);

		JLabel lbl_Cvc3 = new JLabel("CVC:");
		lbl_Cvc3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc3.setBounds(325, 52, 40, 20);
		w_pane_Kart3.add(lbl_Cvc3);

		fld_cvc3 = new JTextField();
		fld_cvc3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_cvc3.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc3.setBounds(374, 52, 46, 20);
		fld_cvc3.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_cvc3.getText().length() <= 2 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_cvc3.setEditable(true);
					} else {
						fld_cvc3.setEditable(false);
					}

				} else {
					fld_cvc3.setEditable(false);

				}
			}
		});
		w_pane_Kart3.add(fld_cvc3);
		fld_cvc3.setColumns(10);

		fld_CartName3 = new JTextField();
		fld_CartName3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_CartName3.setColumns(10);
		fld_CartName3.setBackground(Color.WHITE);
		fld_CartName3.setBounds(160, 8, 260, 20);
		fld_CartName3.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartName3.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartName3.setEditable(true);
					} else {
						fld_CartName3.setEditable(false);
					}

				} else {
					fld_CartName3.setEditable(false);

				}
			}
		});
		w_pane_Kart3.add(fld_CartName3);

		fld_CartNumber3 = new JTextField();
		fld_CartNumber3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		fld_CartNumber3.setColumns(10);
		fld_CartNumber3.setBackground(Color.WHITE);
		fld_CartNumber3.setBounds(160, 30, 260, 20);
		fld_CartNumber3.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartNumber3.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartNumber3.setEditable(true);
					} else {
						fld_CartNumber3.setEditable(false);
					}

				} else {
					fld_CartNumber3.setEditable(false);

				}
			}
		});
		w_pane_Kart3.add(fld_CartNumber3);

		JTextField txt_ConcertYear = new JTextField();
		txt_ConcertYear.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txt_ConcertYear.setBackground(new Color(255, 255, 255));
		txt_ConcertYear.setEditable(false);
		txt_ConcertYear.setBounds(140, 114, 100, 20);
		PaneConcert.add(txt_ConcertYear);

		JTextField txt_ConcertPlace = new JTextField();
		txt_ConcertPlace.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txt_ConcertPlace.setBackground(new Color(255, 255, 255));
		txt_ConcertPlace.setEditable(false);
		txt_ConcertPlace.setBounds(140, 68, 150, 20);
		PaneConcert.add(txt_ConcertPlace);
		PaneConcert.setVisible(false);

		JLabel lbl_TicketCount = new JLabel("Bilet adeti girin:");
		lbl_TicketCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TicketCount.setBackground(Color.WHITE);
		lbl_TicketCount.setBounds(10, 185, 130, 20);
		PaneConcert.add(lbl_TicketCount);

		txt_TicketCount = new JTextField();
		txt_TicketCount.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txt_TicketCount.setColumns(10);
		txt_TicketCount.setBackground(new Color(255, 255, 255));
		txt_TicketCount.setBounds(140, 185, 50, 20);
		PaneConcert.add(txt_TicketCount);

		JLabel lbl_StudentCount = new JLabel("Ogrenci sayisi:");
		lbl_StudentCount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_StudentCount.setBackground(Color.WHITE);
		lbl_StudentCount.setBounds(200, 185, 130, 20);
		PaneConcert.add(lbl_StudentCount);

		txt_StudentCount = new JTextField("0");
		txt_StudentCount.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txt_StudentCount.setColumns(10);
		txt_StudentCount.setBackground(new Color(255, 255, 255));
		txt_StudentCount.setBounds(315, 185, 50, 20);
		txt_StudentCount.setEditable(false);
		PaneConcert.add(txt_StudentCount);

		txt_GhostTicketPrice = new JTextField();
		txt_GhostTicketPrice.setVisible(false);
		txt_GhostTicketPrice.setEditable(false);
		txt_GhostTicketPrice.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txt_GhostTicketPrice.setColumns(10);
		txt_GhostTicketPrice.setBackground(Color.WHITE);
		txt_GhostTicketPrice.setBounds(392, 195, 34, 20);
		PaneConcert.add(txt_GhostTicketPrice);

		JLabel lbl_Total = new JLabel("Ucret");
		lbl_Total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Total.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_Total.setBackground(Color.WHITE);
		lbl_Total.setBounds(300, 233, 130, 25);
		PaneConcert.add(lbl_Total);

		txt_Total = new JTextField();
		txt_Total.setForeground(new Color(0, 0, 0));
		txt_Total.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txt_Total.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Total.setEditable(false);
		txt_Total.setBackground(new Color(255, 255, 255));
		txt_Total.setBounds(300, 258, 140, 71);
		// txt_StudentCount
		// txt_TicketCount
		// txt_GhostTicketPrice

		txt_StudentCount.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {

				if (Integer.parseInt(txt_TicketCount.getText()) > 0) {
					if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

						if (txt_StudentCount.getText().length() < 4 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
								|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
								|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
							txt_StudentCount.setEditable(true);
						} else {
							txt_StudentCount.setEditable(false);
						}

					} else {
						txt_StudentCount.setEditable(false);

					}

				}

			}
		});
		txt_TicketCount.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
						|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
						|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (txt_TicketCount.getText().length() < 4 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						txt_TicketCount.setEditable(true);
					} else {
						txt_TicketCount.setEditable(false);
					}

				} else {
					txt_TicketCount.setEditable(false);

				}
			}
		});

		txt_StudentCount.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

				txt_Total.setText(Math.round(Double.parseDouble(txt_GhostTicketPrice.getText())
						* Double.parseDouble(txt_TicketCount.getText())
						- ((0.4) * Double.parseDouble(txt_StudentCount.getText())
								* Double.parseDouble(txt_TicketCount.getText())))
						+ "TL");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

		});
		txt_TicketCount.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				txt_StudentCount.setEditable(true);

				// TODO Auto-generated method stub

				txt_Total.setText(Math.round(Double.parseDouble(txt_GhostTicketPrice.getText())
						* Double.parseDouble(txt_TicketCount.getText())
						- ((0.4) * Double.parseDouble(txt_StudentCount.getText())
								* Double.parseDouble(txt_TicketCount.getText())))
						+ "TL");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				txt_StudentCount.setEditable(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}

		});

		PaneConcert.add(txt_Total);
		JButton btn_BuyTicket3 = new JButton("Bilet Al");
		btn_BuyTicket3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BuyTicketConcert ticket = new BuyTicketConcert();
				ticket.setTicketCount(txt_TicketCount.getText());
				ticket.setTicketPrice(txt_GhostTicketPrice.getText());

				ticket.setStudentCount(txt_StudentCount.getText());

				if (txt_TicketCount.getText().length() > 0) {

					ticket.setPrice(txt_Total.getText());
				}
				if (comboBox_Method3.getSelectedIndex() == 1) {
					BuyTicketConcert.setlblCard("Ucret, BANKA/KREDI KARTI ile Odenmistir. Borcunuz yoktur.");
					BuyTicketConcert.setPrice("Odendi");

					if (fld_concertName.getText().length() == 0 || txt_ConcertPlace.getText().length() == 0
							|| fld_Artist3.getText().length() == 0 || txt_ConcertYear.getText().length() == 0
							|| fld_Seance3.getText().length() == 0 || fld_Name_concert.getText().length() == 0
							|| txt_TicketCount.getText().length() == 0 || txt_StudentCount.getText().length() == 0
							|| fld_Surname_concert.getText().length() == 0
							|| fld_Mail_concert.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (fld_CartName3.getText().length() == 0 || fld_CartNumber3.getText().length() == 0
							|| fld_cvc3.getText().length() == 0 || comboBox_Month3.getSelectedIndex() == 0
							|| comboBox_Year3.getSelectedIndex() == 0) {
						if (fld_CartName3.getText().length() == 0) {
							fld_CartName3.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_CartName3.getText().length() > 0) {
										fld_CartName3.setBackground(Color.white);
									} else {
										fld_CartName3.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_CartName3.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}
						if (fld_CartNumber3.getText().length() == 0) {
							fld_CartNumber3.getDocument()
									.addDocumentListener((DocumentListener) new DocumentListener() {

										@Override
										public void insertUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub
											if (fld_CartNumber3.getText().length() == 16) {
												fld_CartNumber3.setBackground(Color.white);
											} else {
												fld_CartNumber3.setBackground(Color.ORANGE);
											}
										}

										@Override
										public void removeUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub
											fld_CartNumber3.setBackground(Color.white);
										}

										@Override
										public void changedUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub

										}

									});
						}
						if (fld_cvc3.getText().length() == 0) {
							fld_cvc3.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_cvc3.getText().length() == 3) {
										fld_cvc3.setBackground(Color.white);
									} else {
										fld_cvc3.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_cvc3.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}

						JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
								JOptionPane.ERROR_MESSAGE);
					}

					else {

						ticket = new BuyTicketConcert();
						if (fld_CartNumber3.getText().length() != 16 || fld_cvc3.getText().length() != 3) {
							JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
									JOptionPane.ERROR_MESSAGE);
						} else if (txt_TicketCount.getText().length() == 0) {
							Metod_Helper.showMsg("Lutfen alacaginiz bilet sayisini giriniz.");
						} else if (txt_TicketCount.getText() == null
								|| Integer.parseInt(txt_TicketCount.getText()) == 0) {
							Metod_Helper.showMsg("Lutfen alacaginiz bilet sayisini giriniz.");
						} else if (Integer.parseInt(txt_TicketCount.getText()) > Integer.parseInt(
								table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 5).toString())) {
							Metod_Helper.showMsg("Lutfen gecerli bir bilet sayisi giriniz.");
						}

						else if (Integer.parseInt(txt_TicketCount.getText()) < Integer
								.parseInt(txt_StudentCount.getText())) {
							Metod_Helper.showMsg("Ogrenci sayisi, bilet sayisindan fazla!");
						}

						else {
							if (JOptionPane.showConfirmDialog(null, "Satin Almayi Onayliyor musunuz?", "Dikkat!",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

								Metod_Helper.showMsg("Odemeniz Aliniyor. Lutfen Bekleyiniz...");
								try {
									TimeUnit.SECONDS.sleep(3);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

								try {

									subadmin.updateConcertTicketCount(
											table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 0)
													.toString(),
											table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 1)
													.toString(),

											table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 3)
													.toString(),
											table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 4)
													.toString(),
											table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 2)
													.toString(),
											Integer.parseInt(table_Concert.getModel()
													.getValueAt(table_Concert.getSelectedRow(), 5).toString())
													- (Integer.parseInt(txt_TicketCount.getText())));
									updateConcertTicket();
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

								Metod_Helper.showMsg("Odemeniz Basariyla Gerceklesti");
								ticket.setVisible(true);
								txt_TicketCount.setText("");
								txt_ConcertPlace.setText("");
								txt_ConcertYear.setText("");
								fld_concertName.setText("");
								fld_Artist3.setText("");
								fld_Seance3.setText("");
							}
						}
					}

				} else {

					BuyTicketConcert.setlblCard(BuyTicketConcert.getPrice() + " odemeniz vardir. Iyi gunler Dileriz.");
					if (fld_concertName.getText().length() == 0 || fld_Artist3.getText().length() == 0
							|| txt_ConcertYear.getText().length() == 0 || txt_ConcertPlace.getText().length() == 0
							|| fld_Seance3.getText().length() == 0 || fld_Name_concert.getText().length() == 0
							|| txt_TicketCount.getText().length() == 0 || txt_StudentCount.getText().length() == 0
							|| fld_Surname_concert.getText().length() == 0
							|| fld_Mail_concert.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (Integer.parseInt(txt_TicketCount.getText()) < Integer
							.parseInt(txt_StudentCount.getText())) {
						Metod_Helper.showMsg("Ogrenci sayisi, bilet sayisindan fazla!");
					} else if (Integer.parseInt(txt_TicketCount.getText()) > Integer.parseInt(
							table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 5).toString())) {
						Metod_Helper.showMsg("Lutfen gecerli bir bilet sayisi giriniz.");
					} else {
						ticket = new BuyTicketConcert();

						if (JOptionPane.showConfirmDialog(null, "Satin Almayi Onayliyor musunuz?", "Dikkat!",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							try {

								subadmin.updateConcertTicketCount(
										table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 0)
												.toString(),
										table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 1)
												.toString(),

										table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 3)
												.toString(),
										table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 4)
												.toString(),
										table_Concert.getModel().getValueAt(table_Concert.getSelectedRow(), 2)
												.toString(),
										Integer.parseInt(table_Concert.getModel()
												.getValueAt(table_Concert.getSelectedRow(), 5).toString())
												- (Integer.parseInt(txt_TicketCount.getText())));
								updateConcertTicket();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							Metod_Helper.showMsg("succes");
							ticket.setVisible(true);
							txt_TicketCount.setText("");
							txt_ConcertPlace.setText("");
							txt_ConcertYear.setText("");
							fld_concertName.setText("");
							fld_Artist3.setText("");
							fld_Seance3.setText("");
						}

					}
				}

				///////////////////////////////////////////////// --------------------------------------------------------Bura

			}
		});
		btn_BuyTicket3.setFocusable(false);
		btn_BuyTicket3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_BuyTicket3.setForeground(new Color(0, 0, 0));
		btn_BuyTicket3.setBackground(new Color(153, 255, 153));
		btn_BuyTicket3.setBounds(175, 435, 100, 30);
		PaneConcert.add(btn_BuyTicket3);
		btn_BuyTicket3.setFont(new Font("SansSerif", Font.BOLD, 15));
		BuyTicketConcert.setUser(member.getName() + " " + member.getSurname() + " ");

		JButton btn_Select = new JButton("Sec");
		btn_Select.setFocusable(false);
		btn_Select.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Select.setForeground(new Color(0, 0, 0));
		btn_Select.setBackground(new Color(153, 204, 255));
		btn_Select.setBounds(550, 270, 60, 30);
		contentPane.add(btn_Select);
		btn_Select.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tabbedPane.getSelectedIndex() == 0) {
					int selRow = table_Cinema.getSelectedRow();
					if (selRow >= 0) {
						String selCinemaName = table_Cinema.getModel().getValueAt(selRow, 0).toString();
						String selCinemaType = table_Cinema.getModel().getValueAt(selRow, 1).toString();
						String selCinemaDirector = table_Cinema.getModel().getValueAt(selRow, 2).toString();
						String selCinemaDate = table_Cinema.getModel().getValueAt(selRow, 3).toString();
						String selCinemaSalon = table_Cinema.getModel().getValueAt(selRow, 4).toString();
						String selCinemaSeance = table_Cinema.getModel().getValueAt(selRow, 5).toString();

						try {
							Connection con = dbhelper.getConnection();
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("select * from cinema where filmID ="
									+ (subadmin.cinemaList().get(selRow).getFilmID()));
							if (rs.next()) {
								byte[] img = rs.getBytes("pic");

								// Resize The ImageIcon
								ImageIcon image = new ImageIcon(img);
								Image im = image.getImage();
								Image myImg = im.getScaledInstance(lbl_Poster.getWidth(), lbl_Poster.getHeight(),
										Image.SCALE_SMOOTH);
								ImageIcon newImage = new ImageIcon(myImg);
								lbl_Poster.setIcon(newImage);
							}

							else {
								JOptionPane.showMessageDialog(null, "No Data");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}

						fld_MovieName.setText(selCinemaName);
						fld_MovieType.setText(selCinemaType);
						fld_Director.setText(selCinemaDirector);
						fld_CinemaDate.setText(selCinemaDate);
						fld_Salon.setText(selCinemaSalon);
						fld_Seance.setText(selCinemaSeance);

					} else {
						JOptionPane.showMessageDialog(null, "Lutfen bir film seciniz.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if (tabbedPane.getSelectedIndex() == 1) {
					int selRow1 = table_Theater.getSelectedRow();
					if (selRow1 >= 0) {
						String selTheaterName = table_Theater.getModel().getValueAt(selRow1, 0).toString();
						String selTheaterType = table_Theater.getModel().getValueAt(selRow1, 1).toString();
						String selTheaterYear = table_Theater.getModel().getValueAt(selRow1, 2).toString();
						String selTheaterSalon = table_Theater.getModel().getValueAt(selRow1, 3).toString();
						String selTheaterTime = table_Theater.getModel().getValueAt(selRow1, 4).toString();

						fld_TheaterName.setText(selTheaterName);
						fld_ThetaerType.setText(selTheaterType);
						txt_theaterYear.setText(selTheaterYear);
						fld_Salon22.setText(selTheaterSalon);
						fld_Seance2.setText(selTheaterTime);
						try {
							Connection con = dbhelper.getConnection();
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("select * from booking.tiyatro where tiyatroID ="
									+ (subadmin.theaterList().get(selRow1).getTiyatroID()));
							if (rs.next()) {
								byte[] img = rs.getBytes("pic");

								ImageIcon image = new ImageIcon(img);
								Image im = image.getImage();
								Image myImg = im.getScaledInstance(lbl_Poster2.getWidth(), lbl_Poster2.getHeight(),
										Image.SCALE_SMOOTH);
								ImageIcon newImage = new ImageIcon(myImg);
								lbl_Poster2.setIcon(newImage);
							}

							else {
								JOptionPane.showMessageDialog(null, "No Data");
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Lutfen Bir Tiyatro Oyunu Seciniz.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if (tabbedPane.getSelectedIndex() == 2) {
					int selRow2 = table_Concert.getSelectedRow();
					if (selRow2 >= 0) {
						String selConcertName = table_Concert.getModel().getValueAt(selRow2, 0).toString();
						String selConcertPlace = table_Concert.getModel().getValueAt(selRow2, 1).toString();
						String selConcertArtist = table_Concert.getModel().getValueAt(selRow2, 2).toString();
						String selConcertDate = table_Concert.getModel().getValueAt(selRow2, 3).toString();
						String selConcertTime = table_Concert.getModel().getValueAt(selRow2, 4).toString();
						String selConcertTicketPrice = table_Concert.getModel().getValueAt(selRow2, 6).toString();
						txt_GhostTicketPrice.setText(selConcertTicketPrice);
						fld_concertName.setText(selConcertName);
						txt_ConcertPlace.setText(selConcertPlace);
						fld_Artist3.setText(selConcertArtist);
						txt_ConcertYear.setText(selConcertDate);
						fld_Seance3.setText(selConcertTime);
						try {
							Connection con = dbhelper.getConnection();
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("select * from booking.concert where concertID ="
									+ (subadmin.concertList().get(selRow2).getConcertID()));
							if (rs.next()) {
								byte[] img = rs.getBytes("pic");

								ImageIcon image = new ImageIcon(img);
								Image im = image.getImage();
								Image myImg = im.getScaledInstance(lbl_Poster3.getWidth(), lbl_Poster3.getHeight(),
										Image.SCALE_SMOOTH);
								ImageIcon newImage = new ImageIcon(myImg);
								lbl_Poster3.setIcon(newImage);
							}

							else {
								JOptionPane.showMessageDialog(null, "No Data");
							}
						} catch (Exception ex) {
						}

					} else {
						JOptionPane.showMessageDialog(null, "Lutfen Bir Konser Seciniz.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

				if (tabbedPane.getSelectedIndex() == 0) {
					btn_SelectSeat.setEnabled(true);
					BuyTicket.setMovie(fld_MovieName.getText());
					BuyTicket.setSeance(fld_Seance.getText());
					BuyTicket.setSalon(fld_Salon.getText());
					BuyTicket.setMovieType(fld_MovieType.getText());
				}
				if (tabbedPane.getSelectedIndex() == 1) {
					btn_SelectSeat2.setEnabled(true);
					BuyTicketTheater.setTheater(fld_TheaterName.getText());
					BuyTicketTheater.setSeance(fld_Seance2.getText());
					BuyTicketTheater.setSalon(fld_Salon22.getText());
					BuyTicketTheater.setTheaterDate(txt_theaterYear.getText());
					BuyTicketTheater.setTheaterType(fld_ThetaerType.getText());

				}
				if (tabbedPane.getSelectedIndex() == 2) {
					BuyTicketConcert.setConcert(fld_concertName.getText());
					BuyTicketConcert.setHour(fld_Seance3.getText());
					BuyTicketConcert.setConcertPlace(txt_ConcertPlace.getText());
					BuyTicketConcert.setArtist(fld_Artist3.getText());
					BuyTicketConcert.setConcertDate(txt_ConcertYear.getText());
					BuyTicketConcert.setStudentCount(txt_StudentCount.getText());

					BuyTicketConcert.setTicketCount(txt_TicketCount.getText());

				}

			}
		});

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					PaneCinema.setVisible(true);
					PaneTheater.setVisible(false);
					PaneConcert.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 1) {
					PaneTheater.setVisible(true);
					PaneCinema.setVisible(false);
					PaneConcert.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					PaneCinema.setVisible(false);
					PaneTheater.setVisible(false);
					PaneConcert.setVisible(true);
				}

			}

		});

	}

	public static void updateConcertTicket() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_Concert.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < subadmin.concertList().size(); i++) {
			concertData[0] = subadmin.concertList().get(i).getConcertName();
			concertData[1] = subadmin.concertList().get(i).getConcertPlace();
			concertData[2] = subadmin.concertList().get(i).getConcertArtist();
			concertData[3] = subadmin.concertList().get(i).getConcertDate();
			concertData[4] = subadmin.concertList().get(i).getConcertTime();
			concertData[5] = subadmin.concertList().get(i).getTicketCount();
			concertData[6] = subadmin.concertList().get(i).getTicketPrice();
			concertModel.addRow(concertData);
		}

	}
}
