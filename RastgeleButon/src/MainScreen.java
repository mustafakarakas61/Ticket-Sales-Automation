import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.Metod_Helper;

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
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel cinemaModel; // tablo sütunlarını isimlendirmek için
	private DefaultTableModel theaterModel;
	private DefaultTableModel concertModel;
	private Object[] cinemaData = null; // sqlden veri çekmek için
	private Object[] theaterData = null;
	private Object[] concertData = null;
	private JTable table_Cinema;
	private JTable table_Theater;
	private JTable table_Concert;
	private JTextField fld_concertName;
	private JTextField fld_Artist33;
	private JTextField fld_Seance3;
	private JTextField fld_Name_concert;
	private JTextField fld_Surname_concert;
	private JTextField fld_Mail_concert;
	private JTextField fld_cvc33;
	private JTextField fld_CartName33;
	private JTextField fld_CartNumber33;

	private JTextField fld_MovieName;
	private JTextField fld_MovieType;
	private JTextField fld_GameName;
	private JTextField fld_GameType;

	private JTextField fld_Director2;
	private JTextField fld_Salon2;
	private JTextField fld_Time;
	private JTextField fld_cvc2;
	private JTextField fld_CartNumber2;

	private JTextField fld_ConcertType;

	private JTextField fld_cvc3;
	private JTextField fld_CartNumber3;
	private static user member = new Member();
	private static SubACinema sinema = new SubACinema();
	private static SubATheater tiyatro = new SubATheater();
	private static SubAConcert konser = new SubAConcert();
	private JTextField fld_CinemaDate;

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
		setTitle("Bilet Satış Sistemi");
		setResizable(false);

//////////////////////////////////////////////////////////////////////////////////Sinema
		cinemaModel = new DefaultTableModel();
		Object[] colCinema = new Object[6]; // tablo sütunlarına isim vermek için

		colCinema[0] = "Film Adi";
		colCinema[1] = "Film Turu";
		colCinema[2] = "Yonetmen";
		colCinema[3] = "Tarih";
		colCinema[4] = "Salon";
		colCinema[5] = "Seans";

		cinemaModel.setColumnIdentifiers(colCinema);
		cinemaData = new Object[6]; // sqlden veri çekmek için

//////////////////////////////////////////////////////////////////////////////////Tiyatro
		theaterModel = new DefaultTableModel();
		Object[] colTheater = new Object[5];

		colTheater[0] = "Oyun Adi";
		colTheater[1] = "Oyun Turu";
		colTheater[2] = "Tarih";
		colTheater[3] = "Salon";
		colTheater[4] = "Saat";
		theaterModel.setColumnIdentifiers(colTheater);
		theaterData = new Object[5]; // sqlden veri çekmek için

//////////////////////////////////////////////////////////////////////////////////Konser
		concertModel = new DefaultTableModel();
		Object[] colConcert = new Object[5];

		colConcert[0] = "Konser Adi";
		colConcert[1] = "Konser Yeri";
		colConcert[2] = "Sanatci";
		colConcert[3] = "Tarih";
		colConcert[4] = "Saat";

		concertModel.setColumnIdentifiers(colConcert);
		concertData = new Object[5];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600);
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

		JButton btn_Exit = new JButton("Çıkış Yap");
		btn_Exit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Exit.setBackground(new Color(204, 204, 255));
		btn_Exit.setFocusable(false);
		btn_Exit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_Exit.setBounds(854, 20, 100, 25);
		contentPane.add(btn_Exit);

		JLabel lbl_Name = new JLabel("Hoşgeldiniz Sayın " + member.getName());
		lbl_Name.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Name.setBounds(10, 20, 400, 20);
		contentPane.add(lbl_Name);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(new Color(255, 255, 255));

		tabbedPane.setBounds(10, 60, 410, 476);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Sinema", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scrollPane_Cinema = new JScrollPane();
		scrollPane_Cinema.setBounds(0, 0, 405, 448);
		w_paneCinema.add(scrollPane_Cinema);
///////////////////////////////////////////////////////////////////////////////////Sinema Sütun Özellikleri
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

		for (int i = 0; i < sinema.cinemaList().size(); i++) {
			cinemaData[0] = sinema.cinemaList().get(i).getFilmName();
			cinemaData[1] = sinema.cinemaList().get(i).getFilmType();
			cinemaData[2] = sinema.cinemaList().get(i).getFilmDirector();
			cinemaData[3] = sinema.cinemaList().get(i).getFilmDate();
			cinemaData[4] = sinema.cinemaList().get(i).getFilmSalon();
			cinemaData[5] = sinema.cinemaList().get(i).getFilmSeans();
			cinemaModel.addRow(cinemaData);
		}

		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scrollPane_Theater = new JScrollPane();
		scrollPane_Theater.setBounds(0, 0, 405, 448);
		w_paneTheater.add(scrollPane_Theater);

///////////////////////////////////////////////////////////////////////////////////Tiyatro Sütun Özellikleri
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

		for (int i = 0; i < tiyatro.theaterList().size(); i++) {
			theaterData[0] = tiyatro.theaterList().get(i).getTheaterName();
			theaterData[1] = tiyatro.theaterList().get(i).getTheaterType();
			theaterData[2] = tiyatro.theaterList().get(i).getTheaterDate();
			theaterData[3] = tiyatro.theaterList().get(i).getTheaterSalon();
			theaterData[4] = tiyatro.theaterList().get(i).getTheaterDate();
			theaterModel.addRow(theaterData);
		}

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Konser", null, w_paneConcert, null);

		w_paneConcert.setLayout(null);

		JScrollPane scrollPane_Concert = new JScrollPane();
		scrollPane_Concert.setBounds(0, 0, 405, 448);
		w_paneConcert.add(scrollPane_Concert);

		table_Concert = new JTable(concertModel);
		table_Concert.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Concert.setFont(new Font("SansSerif", Font.PLAIN, 13));

		table_Concert.getColumn("Konser Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Konser Yeri").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Sanatci").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Saat").setCellEditor(new TableEditor(new JCheckBox()));

		scrollPane_Concert.setViewportView(table_Concert);

		table_Concert.getColumnModel().getColumn(0).setResizable(false);
		table_Concert.getColumnModel().getColumn(1).setResizable(false);
		table_Concert.getColumnModel().getColumn(2).setResizable(false);
		table_Concert.getColumnModel().getColumn(3).setResizable(false);

		for (int i = 0; i < konser.concertList().size(); i++) {
			concertData[0] = konser.concertList().get(i).getConcertName();
			concertData[1] = konser.concertList().get(i).getConcertType();
			concertData[2] = konser.concertList().get(i).getConcertDate();
			concertData[3] = konser.concertList().get(i).getConcertTime();
			concertModel.addRow(concertData);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////// PANESİNEMA///////////////////////////////////////////////////////////////
		JPanel PaneCinema = new JPanel();
		PaneCinema.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneCinema.setBackground(new Color(255, 255, 255));
		PaneCinema.setBounds(504, 60, 450, 479);
		contentPane.add(PaneCinema);
		PaneCinema.setLayout(null);

		JLabel lbl_Poster = new JLabel("");
		lbl_Poster.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Poster.setBounds(312, 20, 120, 170);
		PaneCinema.add(lbl_Poster);

		JLabel lbl_MovieName = new JLabel("Film Adi:");
		lbl_MovieName.setBackground(new Color(255, 255, 255));
		lbl_MovieName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 50, 100, 20);
		PaneCinema.add(lbl_MovieName);

		JLabel lbl_MovieType = new JLabel("Film Turu:");
		lbl_MovieType.setBackground(new Color(255, 255, 255));
		lbl_MovieType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieType.setBounds(10, 73, 100, 20);
		PaneCinema.add(lbl_MovieType);

		JLabel lbl_Admin = new JLabel("Yonetmen:");
		lbl_Admin.setBackground(new Color(255, 255, 255));
		lbl_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Admin.setBounds(10, 96, 100, 20);
		PaneCinema.add(lbl_Admin);

		JLabel lbl_Salon = new JLabel("Salon:");
		lbl_Salon.setBackground(new Color(255, 255, 255));
		lbl_Salon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon.setBounds(10, 142, 100, 20);
		PaneCinema.add(lbl_Salon);

		JLabel lbl_Seance = new JLabel("Seans:");
		lbl_Seance.setBackground(new Color(255, 255, 255));
		lbl_Seance.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seance.setBounds(10, 163, 100, 20);
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
		btn_SelectSeat.setBounds(10, 185, 100, 22);
		PaneCinema.add(btn_SelectSeat);

		JLabel lbl_PaymentInformation = new JLabel("Odeme Bilgileri");
		lbl_PaymentInformation.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInformation.setBounds(10, 205, 130, 20);
		PaneCinema.add(lbl_PaymentInformation);

		JLabel lblMovieInfo = new JLabel("Film Bilgileri");
		lblMovieInfo.setBackground(new Color(255, 255, 255));
		lblMovieInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieInfo.setBounds(10, 20, 150, 20);
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
		fld_MovieName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_MovieName.setBackground(new Color(255, 255, 255));
		fld_MovieName.setEditable(false);
		fld_MovieName.setBounds(140, 50, 150, 20);
		PaneCinema.add(fld_MovieName);
		fld_MovieName.setColumns(10);

		fld_MovieType = new JTextField();
		fld_MovieType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_MovieType.setBackground(new Color(255, 255, 255));
		fld_MovieType.setEditable(false);
		fld_MovieType.setColumns(10);
		fld_MovieType.setBounds(140, 73, 150, 20);
		PaneCinema.add(fld_MovieType);

		JTextField fld_Director = new JTextField();
		fld_Director.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Director.setBackground(new Color(255, 255, 255));
		fld_Director.setEditable(false);
		fld_Director.setColumns(10);
		fld_Director.setBounds(140, 96, 150, 20);
		PaneCinema.add(fld_Director);

		JTextField fld_Salon = new JTextField();
		fld_Salon.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Salon.setBackground(new Color(255, 255, 255));
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(140, 142, 75, 20);
		PaneCinema.add(fld_Salon);

		JTextField fld_Seance = new JTextField();
		fld_Seance.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Seance.setBackground(new Color(255, 255, 255));
		fld_Seance.setEditable(false);
		fld_Seance.setColumns(10);
		fld_Seance.setBounds(140, 165, 75, 20);
		PaneCinema.add(fld_Seance);

		JLabel lbl_PaymentMethod = new JLabel("Odeme Yöntemi:");
		lbl_PaymentMethod.setBackground(new Color(255, 255, 255));
		lbl_PaymentMethod.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod.setBounds(10, 304, 120, 20);
		PaneCinema.add(lbl_PaymentMethod);

		JComboBox comboBox_Method = new JComboBox();
		comboBox_Method.setBackground(new Color(255, 255, 255));
		comboBox_Method.setFont(new Font("SansSerif", Font.PLAIN, 15));
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
		fld_Name_cinema.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Name_cinema.setText(member.getName());
		fld_Name_cinema.setEditable(false);
		fld_Name_cinema.setColumns(10);
		fld_Name_cinema.setBackground(new Color(255, 255, 255));
		fld_Name_cinema.setBounds(140, 235, 150, 20);
		PaneCinema.add(fld_Name_cinema);

		JTextField fld_Surname_cinema = new JTextField();
		fld_Surname_cinema.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Surname_cinema.setText(member.getSurname());
		fld_Surname_cinema.setEditable(false);
		fld_Surname_cinema.setColumns(10);
		fld_Surname_cinema.setBackground(new Color(255, 255, 255));
		fld_Surname_cinema.setBounds(140, 258, 150, 20);
		PaneCinema.add(fld_Surname_cinema);

		JTextField fld_Mail_cinema = new JTextField();
		fld_Mail_cinema.setFont(new Font("SansSerif", Font.PLAIN, 14));
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

		JLabel lbl_LastUsageDate = new JLabel("Son Kullanım Tarihi:");
		lbl_LastUsageDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate.setBounds(10, 52, 140, 20);
		w_pane_Kart.add(lbl_LastUsageDate);

		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setModel(new DefaultComboBoxModel(
				new String[] { "Ay", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		comboBox_Month.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Month.setBounds(160, 52, 60, 22);
		comboBox_Month.addItem("Ay");
		w_pane_Kart.add(comboBox_Month);

		JComboBox comboBox_Year = new JComboBox();

		comboBox_Year.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Year.setBounds(235, 52, 72, 22);
		comboBox_Year.setModel(new DefaultComboBoxModel(new String[] { "Yil", "2021", "2022", "2023", "2024", "2025",
				"2026", "2027", "2028", "2029", "2030", "2031" }));

		w_pane_Kart.add(comboBox_Year);

		JLabel lbl_Cvc = new JLabel("CVC:");
		lbl_Cvc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc.setBounds(325, 52, 40, 20);
		w_pane_Kart.add(lbl_Cvc);

		JTextField fld_cvc = new JTextField();
		fld_cvc.setFont(new Font("SansSerif", Font.PLAIN, 14));
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
		fld_CartName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartName.setColumns(10);
		fld_CartName.setBackground(Color.WHITE);
		fld_CartName.setBounds(160, 8, 260, 20);
		fld_CartName.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ı' || ke.getKeyChar() == 'ğ' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'ş' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'İ' || ke.getKeyChar() == 'Ğ' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Ş' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
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
		fld_CartNumber.setFont(new Font("SansSerif", Font.PLAIN, 14));
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
		btn_MyTickets.setFocusable(false);
		btn_MyTickets.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_MyTickets.setBounds(60, 435, 100, 30);
		PaneCinema.add(btn_MyTickets);
		btn_MyTickets.setForeground(new Color(0, 0, 0));
		btn_MyTickets.setBackground(new Color(255, 255, 153));
		btn_MyTickets.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JButton btn_BuyTicket = new JButton("Bilet Al");
		btn_BuyTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
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

					BuyTicket.setlblCard(BuyTicket.getPrice() + " odemeniz vardır. Iyi gunler Dileriz.");
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
								Metod_Helper.showMsg("succes");
								ticket.setVisible(true);
							} else {
								// no option
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
		btn_BuyTicket.setBounds(175, 435, 100, 30);
		PaneCinema.add(btn_BuyTicket);
		btn_BuyTicket.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btn_CancelTicket = new JButton("Bilet İptal");
		btn_CancelTicket.setFocusable(false);
		btn_CancelTicket.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_CancelTicket.setBounds(290, 435, 100, 30);
		PaneCinema.add(btn_CancelTicket);
		btn_CancelTicket.setForeground(new Color(0, 0, 0));
		btn_CancelTicket.setBackground(new Color(255, 153, 153));
		btn_CancelTicket.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lbl_CinemaDate = new JLabel("Tarih:");
		lbl_CinemaDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CinemaDate.setBackground(Color.WHITE);
		lbl_CinemaDate.setBounds(10, 119, 100, 20);
		PaneCinema.add(lbl_CinemaDate);

		fld_CinemaDate = new JTextField();
		fld_CinemaDate.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CinemaDate.setEditable(false);
		fld_CinemaDate.setColumns(10);
		fld_CinemaDate.setBackground(Color.WHITE);
		fld_CinemaDate.setBounds(140, 119, 75, 20);
		PaneCinema.add(fld_CinemaDate);
		BuyTicket.setUser(member.getName() + " ");
		///////////////////////////////////////////////// PANESİNEMA/////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////// PANETİYATRO///////////////////////////////////////////////////////////////
		JPanel PaneTheater = new JPanel();
		PaneTheater.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneTheater.setBackground(new Color(255, 255, 255));
		PaneTheater.setBounds(504, 60, 450, 479);
		contentPane.add(PaneTheater);
		PaneTheater.setLayout(null);

		JLabel lbl_Poster2 = new JLabel("");
		lbl_Poster2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Poster2.setBounds(312, 20, 120, 170);
		PaneTheater.add(lbl_Poster2);

		JLabel lbl_TheaterName = new JLabel("Oyun Adi:");
		lbl_TheaterName.setBackground(new Color(255, 255, 255));
		lbl_TheaterName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TheaterName.setBounds(10, 50, 100, 20);
		PaneTheater.add(lbl_TheaterName);

		JLabel lbl_TheaterType = new JLabel("Oyun Turu:");
		lbl_TheaterType.setBackground(new Color(255, 255, 255));
		lbl_TheaterType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_TheaterType.setBounds(10, 73, 100, 20);
		PaneTheater.add(lbl_TheaterType);

		JLabel lbl_Datee2 = new JLabel("Tarih:");
		lbl_Datee2.setBackground(new Color(255, 255, 255));
		lbl_Datee2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Datee2.setBounds(10, 96, 100, 20);
		PaneTheater.add(lbl_Datee2);

		JLabel lbl_Salon2 = new JLabel("Salon:");
		lbl_Salon2.setBackground(new Color(255, 255, 255));
		lbl_Salon2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon2.setBounds(10, 119, 100, 20);
		PaneTheater.add(lbl_Salon2);

		JLabel lbl_Seance2 = new JLabel("Saat:");
		lbl_Seance2.setBackground(new Color(255, 255, 255));
		lbl_Seance2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seance2.setBounds(10, 142, 100, 20);
		PaneTheater.add(lbl_Seance2);

		JTextField txt_theaterYear = new JTextField();
		txt_theaterYear.setBackground(new Color(255, 255, 255));
		txt_theaterYear.setEditable(false);
		txt_theaterYear.setBounds(140, 96, 75, 20);
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
				SeatSelection ks = new SeatSelection();
				ks.setVisible(true);
			}
		});
		btn_SelectSeat2.setBounds(10, 165, 100, 22);
		PaneTheater.add(btn_SelectSeat2);

		JLabel lbl_PaymentInformation2 = new JLabel("Odeme Bilgileri");
		lbl_PaymentInformation2.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInformation2.setBounds(10, 205, 130, 20);
		PaneTheater.add(lbl_PaymentInformation2);

		JLabel lbl_TheaterInfo = new JLabel("Tiyatro Bilgileri");
		lbl_TheaterInfo.setBackground(new Color(255, 255, 255));
		lbl_TheaterInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_TheaterInfo.setBounds(10, 20, 150, 20);
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
		fld_TheaterName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_TheaterName.setBackground(new Color(255, 255, 255));
		fld_TheaterName.setEditable(false);
		fld_TheaterName.setBounds(140, 50, 150, 20);
		PaneTheater.add(fld_TheaterName);
		fld_TheaterName.setColumns(10);

		JTextField fld_ThetaerType = new JTextField();
		fld_ThetaerType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_ThetaerType.setBackground(new Color(255, 255, 255));
		fld_ThetaerType.setEditable(false);
		fld_ThetaerType.setColumns(10);
		fld_ThetaerType.setBounds(140, 73, 150, 20);
		PaneTheater.add(fld_ThetaerType);

		JTextField fld_Salon22 = new JTextField();
		fld_Salon22.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Salon22.setBackground(new Color(255, 255, 255));
		fld_Salon22.setEditable(false);
		fld_Salon22.setColumns(10);
		fld_Salon22.setBounds(140, 119, 75, 20);
		PaneTheater.add(fld_Salon22);

		JTextField fld_Seance2 = new JTextField();
		fld_Seance2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Seance2.setBackground(new Color(255, 255, 255));
		fld_Seance2.setEditable(false);
		fld_Seance2.setColumns(10);
		fld_Seance2.setBounds(140, 142, 75, 20);
		PaneTheater.add(fld_Seance2);

		JLabel lbl_PaymentMethod2 = new JLabel("Ödeme Yöntemi:");
		lbl_PaymentMethod2.setBackground(new Color(255, 255, 255));
		lbl_PaymentMethod2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod2.setBounds(10, 304, 120, 20);
		PaneTheater.add(lbl_PaymentMethod2);

		JComboBox comboBox_Method2 = new JComboBox();
		comboBox_Method2.setBackground(new Color(255, 255, 255));
		comboBox_Method2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Method2.setBounds(140, 304, 150, 25);
		comboBox_Method2.addItem("Nakit");
		comboBox_Method2.addItem("Banka/Kredi Kartı");
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
		fld_Name_theater.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Name_theater.setText(member.getName());
		fld_Name_theater.setEditable(false);
		fld_Name_theater.setColumns(10);
		fld_Name_theater.setBackground(new Color(255, 255, 255));
		fld_Name_theater.setBounds(140, 235, 150, 20);
		PaneTheater.add(fld_Name_theater);

		JTextField fld_Surname_theater = new JTextField();
		fld_Surname_theater.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Surname_theater.setText(member.getSurname());
		fld_Surname_theater.setEditable(false);
		fld_Surname_theater.setColumns(10);
		fld_Surname_theater.setBackground(new Color(255, 255, 255));
		fld_Surname_theater.setBounds(140, 258, 150, 20);
		PaneTheater.add(fld_Surname_theater);

		JTextField fld_Mail_theater = new JTextField();
		fld_Mail_theater.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Mail_theater.setText(member.getEmail());
		fld_Mail_theater.setEditable(false);
		fld_Mail_theater.setColumns(10);
		fld_Mail_theater.setBackground(new Color(255, 255, 255));
		fld_Mail_theater.setBounds(140, 281, 150, 20);
		PaneTheater.add(fld_Mail_theater);

		JLabel lbl_CartName2 = new JLabel("Kart Üzerindeki İsim:");
		lbl_CartName2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName2.setBounds(10, 8, 140, 20);
		w_pane_Kart2.add(lbl_CartName2);

		JLabel lbl_CartNumber2 = new JLabel("Kart Numarası:");
		lbl_CartNumber2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber2.setBounds(10, 30, 140, 20);
		w_pane_Kart2.add(lbl_CartNumber2);

		JLabel lbl_LastUsageDate2 = new JLabel("Son Kullanım Tarihi:");
		lbl_LastUsageDate2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate2.setBounds(10, 52, 140, 20);
		w_pane_Kart2.add(lbl_LastUsageDate2);

		JComboBox comboBox_Month2 = new JComboBox();
		comboBox_Month2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Month2.setBounds(160, 52, 60, 22);
		comboBox_Month2.setModel(new DefaultComboBoxModel(
				new String[] { "Ay", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		w_pane_Kart2.add(comboBox_Month2);

		JComboBox comboBox_Year2 = new JComboBox();
		comboBox_Year2.setModel(new DefaultComboBoxModel(new String[] { "Yil", "2021", "2022", "2023", "2024", "2025",
				"2026", "2027", "2028", "2029", "2030", "2031" }));
		comboBox_Year2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Year2.setBounds(235, 52, 72, 22);

		w_pane_Kart2.add(comboBox_Year2);

		JLabel lbl_Cvc2 = new JLabel("CVC:");
		lbl_Cvc2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc2.setBounds(325, 52, 40, 20);
		w_pane_Kart2.add(lbl_Cvc2);

		JTextField fld_cvc22 = new JTextField();
		fld_cvc22.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_cvc22.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc22.setBounds(374, 52, 46, 20);
		fld_cvc22.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_cvc22.getText().length() <= 2 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_cvc22.setEditable(true);
					} else {
						fld_cvc22.setEditable(false);
					}

				} else {
					fld_cvc22.setEditable(false);

				}
			}
		});
		w_pane_Kart2.add(fld_cvc22);
		fld_cvc22.setColumns(10);

		JTextField fld_CartName22 = new JTextField();
		fld_CartName22.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartName22.setColumns(10);
		fld_CartName22.setBackground(Color.WHITE);
		fld_CartName22.setBounds(160, 8, 260, 20);
		fld_CartName22.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ı' || ke.getKeyChar() == 'ğ' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'ş' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'İ' || ke.getKeyChar() == 'Ğ' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Ş' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
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
		fld_CartNumber22.setFont(new Font("SansSerif", Font.PLAIN, 14));
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
		btn_MyTickets2.setFocusable(false);
		btn_MyTickets2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_MyTickets2.setBounds(60, 435, 100, 30);
		PaneTheater.add(btn_MyTickets2);
		btn_MyTickets2.setForeground(new Color(0, 0, 0));
		btn_MyTickets2.setBackground(new Color(255, 255, 153));
		btn_MyTickets2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JButton btn_BuyTicket2 = new JButton("Bilet Al");
		btn_BuyTicket2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (comboBox_Method2.getSelectedIndex() == 1) {
					BuyTicket.setlblCard("Ucret, BANKA/KREDI KARTI ile odenmistir. Borcunuz yoktur.");
					BuyTicket.setPrice("Odendi");

					if (fld_TheaterName.getText().length() == 0 || fld_ThetaerType.getText().length() == 0
							|| fld_Salon22.getText().length() == 0 || fld_Seance2.getText().length() == 0
							|| fld_Name_theater.getText().length() == 0 || fld_Surname_theater.getText().length() == 0
							|| fld_Mail_theater.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (fld_CartName22.getText().length() == 0 || fld_CartNumber22.getText().length() == 0
							|| fld_cvc22.getText().length() == 0 || comboBox_Month2.getSelectedIndex() == 0
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
						if (fld_cvc22.getText().length() == 0) {
							fld_cvc22.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_cvc22.getText().length() == 3) {
										fld_cvc22.setBackground(Color.white);
									} else {
										fld_cvc22.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_cvc22.setBackground(Color.white);
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

						} else if (fld_CartNumber2.getText().length() != 16 || fld_cvc2.getText().length() != 3) {
							JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
									JOptionPane.ERROR_MESSAGE);
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
								Metod_Helper.showMsg("Odemeniz Basariyla Gerceklesti");
								ticket.setVisible(true);
							}

						}
					}

				} else {

					BuyTicket.setlblCard(BuyTicket.getPrice() + " odemeniz vardır. Iyi gunler Dileriz.");
					if (fld_TheaterName.getText().length() == 0 || fld_ThetaerType.getText().length() == 0
							|| txt_theaterYear.getText().length() == 0 || fld_Salon22.getText().length() == 0
							|| fld_Seance2.getText().length() == 0 || fld_Name_theater.getText().length() == 0
							|| fld_Surname_theater.getText().length() == 0
							|| fld_Mail_theater.getText().length() == 0) {
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
								Metod_Helper.showMsg("succes");
								ticket.setVisible(true);
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
		btn_BuyTicket2.setBounds(175, 435, 100, 30);
		PaneTheater.add(btn_BuyTicket2);
		btn_BuyTicket2.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btn_CancelTicket2 = new JButton("Bilet Iptal");
		btn_CancelTicket2.setFocusable(false);
		btn_CancelTicket2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_CancelTicket2.setBounds(290, 435, 100, 30);
		PaneTheater.add(btn_CancelTicket2);
		btn_CancelTicket2.setForeground(new Color(0, 0, 0));
		btn_CancelTicket2.setBackground(new Color(255, 153, 153));
		btn_CancelTicket2.setFont(new Font("SansSerif", Font.PLAIN, 15));

		///////////////////////////////////////////////////// PANETİYATRO////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////// PANEKONSER///////////////////////////////////////////////////////////////
		JPanel PaneConcert = new JPanel();
		PaneConcert.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneConcert.setBackground(new Color(255, 255, 255));
		PaneConcert.setBounds(504, 60, 450, 479);
		contentPane.add(PaneConcert);
		PaneConcert.setLayout(null);

		JLabel lbl_Poster3 = new JLabel("");
		lbl_Poster3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Poster3.setBounds(312, 20, 120, 170);
		PaneConcert.add(lbl_Poster3);

		JLabel lbl_ConcertName = new JLabel("Konser Adi:");
		lbl_ConcertName.setBackground(new Color(255, 255, 255));
		lbl_ConcertName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertName.setBounds(10, 50, 100, 20);
		PaneConcert.add(lbl_ConcertName);

		JLabel lbl_ConcertType = new JLabel("Konser Yeri:");
		lbl_ConcertType.setBackground(new Color(255, 255, 255));
		lbl_ConcertType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertType.setBounds(10, 73, 100, 20);
		PaneConcert.add(lbl_ConcertType);

		JLabel lbl_Date3 = new JLabel("Tarih:");
		lbl_Date3.setBackground(new Color(255, 255, 255));
		lbl_Date3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Date3.setBounds(10, 119, 100, 20);
		PaneConcert.add(lbl_Date3);

		JLabel lbl_Salon3 = new JLabel("Sanatci:");
		lbl_Salon3.setBackground(new Color(255, 255, 255));
		lbl_Salon3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon3.setBounds(10, 96, 100, 20);
		PaneConcert.add(lbl_Salon3);

		JLabel lbl_Seance3 = new JLabel("Saat:");
		lbl_Seance3.setBackground(new Color(255, 255, 255));
		lbl_Seance3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seance3.setBounds(10, 142, 100, 20);
		PaneConcert.add(lbl_Seance3);

		JLabel lbl_PaymentInformation3 = new JLabel("Odeme Bilgileri");
		lbl_PaymentInformation3.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInformation3.setBounds(10, 205, 130, 20);
		PaneConcert.add(lbl_PaymentInformation3);

		JLabel lbl_ConcertInfo = new JLabel("Konser Bilgileri");
		lbl_ConcertInfo.setBackground(new Color(255, 255, 255));
		lbl_ConcertInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_ConcertInfo.setBounds(10, 20, 150, 20);
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
		fld_concertName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_concertName.setBackground(new Color(255, 255, 255));
		fld_concertName.setEditable(false);
		fld_concertName.setBounds(140, 50, 150, 20);
		PaneConcert.add(fld_concertName);
		fld_concertName.setColumns(10);

		fld_Artist33 = new JTextField();
		fld_Artist33.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Artist33.setBackground(new Color(255, 255, 255));
		fld_Artist33.setEditable(false);
		fld_Artist33.setColumns(10);
		fld_Artist33.setBounds(140, 96, 150, 20);
		PaneConcert.add(fld_Artist33);

		fld_Seance3 = new JTextField();
		fld_Seance3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Seance3.setBackground(new Color(255, 255, 255));
		fld_Seance3.setEditable(false);
		fld_Seance3.setColumns(10);
		fld_Seance3.setBounds(140, 142, 75, 20);
		PaneConcert.add(fld_Seance3);

		JLabel lbl_PaymentMethod3 = new JLabel("Odeme Yontemi:");
		lbl_PaymentMethod3.setBackground(new Color(255, 255, 255));
		lbl_PaymentMethod3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod3.setBounds(10, 304, 120, 20);
		PaneConcert.add(lbl_PaymentMethod3);

		JComboBox comboBox_Method3 = new JComboBox();
		comboBox_Method3.setBackground(new Color(255, 255, 255));
		comboBox_Method3.setFont(new Font("SansSerif", Font.PLAIN, 15));
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
		fld_Name_concert.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Name_concert.setText(member.getName());
		fld_Name_concert.setEditable(false);
		fld_Name_concert.setColumns(10);
		fld_Name_concert.setBackground(new Color(255, 255, 255));
		fld_Name_concert.setBounds(140, 235, 150, 20);
		PaneConcert.add(fld_Name_concert);

		fld_Surname_concert = new JTextField();
		fld_Surname_concert.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Surname_concert.setText(member.getSurname());
		fld_Surname_concert.setEditable(false);
		fld_Surname_concert.setColumns(10);
		fld_Surname_concert.setBackground(new Color(255, 255, 255));
		fld_Surname_concert.setBounds(140, 258, 150, 20);
		PaneConcert.add(fld_Surname_concert);

		fld_Mail_concert = new JTextField();
		fld_Mail_concert.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Mail_concert.setText(member.getEmail());
		fld_Mail_concert.setEditable(false);
		fld_Mail_concert.setColumns(10);
		fld_Mail_concert.setBackground(new Color(255, 255, 255));
		fld_Mail_concert.setBounds(140, 281, 150, 20);
		PaneConcert.add(fld_Mail_concert);

		JLabel lbl_CartName3 = new JLabel("Kart Üzerindeki İsim:");
		lbl_CartName3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName3.setBounds(10, 8, 140, 20);
		w_pane_Kart3.add(lbl_CartName3);

		JLabel lbl_CartNumber3 = new JLabel("Kart Numarası:");
		lbl_CartNumber3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber3.setBounds(10, 30, 140, 20);
		w_pane_Kart3.add(lbl_CartNumber3);

		JLabel lbl_LastUsageDate3 = new JLabel("Son Kullanım Tarihi:");
		lbl_LastUsageDate3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate3.setBounds(10, 52, 140, 20);
		w_pane_Kart3.add(lbl_LastUsageDate3);

		JComboBox comboBox_Month3 = new JComboBox();
		comboBox_Month3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Month3.setBounds(160, 52, 60, 22);
		comboBox_Month3.setModel(new DefaultComboBoxModel(
				new String[] { "Ay", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		w_pane_Kart3.add(comboBox_Month3);

		JComboBox comboBox_Year3 = new JComboBox();
		comboBox_Year3.setModel(new DefaultComboBoxModel(new String[] { "Yil", "2021", "2022", "2023", "2024", "2025",
				"2026", "2027", "2028", "2029", "2030", "2031" }));
		comboBox_Year3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Year3.setBounds(235, 52, 72, 22);

		w_pane_Kart3.add(comboBox_Year3);

		JLabel lbl_Cvc3 = new JLabel("CVC:");
		lbl_Cvc3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc3.setBounds(325, 52, 40, 20);
		w_pane_Kart3.add(lbl_Cvc3);

		fld_cvc33 = new JTextField();
		fld_cvc33.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_cvc33.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc33.setBounds(374, 52, 46, 20);
		fld_cvc33.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_cvc33.getText().length() <= 2 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_cvc33.setEditable(true);
					} else {
						fld_cvc33.setEditable(false);
					}

				} else {
					fld_cvc33.setEditable(false);

				}
			}
		});
		w_pane_Kart3.add(fld_cvc33);
		fld_cvc33.setColumns(10);

		fld_CartName33 = new JTextField();
		fld_CartName33.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartName33.setColumns(10);
		fld_CartName33.setBackground(Color.WHITE);
		fld_CartName33.setBounds(160, 8, 260, 20);
		fld_CartName33.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ı' || ke.getKeyChar() == 'ğ' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'ş' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'İ' || ke.getKeyChar() == 'Ğ' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Ş' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartName33.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartName33.setEditable(true);
					} else {
						fld_CartName33.setEditable(false);
					}

				} else {
					fld_CartName33.setEditable(false);

				}
			}
		});
		w_pane_Kart3.add(fld_CartName33);

		fld_CartNumber33 = new JTextField();
		fld_CartNumber33.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartNumber33.setColumns(10);
		fld_CartNumber33.setBackground(Color.WHITE);
		fld_CartNumber33.setBounds(160, 30, 260, 20);
		fld_CartNumber33.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartNumber33.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartNumber33.setEditable(true);
					} else {
						fld_CartNumber33.setEditable(false);
					}

				} else {
					fld_CartNumber33.setEditable(false);

				}
			}
		});
		w_pane_Kart3.add(fld_CartNumber33);

		JTextField txt_ConcertYear = new JTextField();
		txt_ConcertYear.setBackground(new Color(255, 255, 255));
		txt_ConcertYear.setEditable(false);
		txt_ConcertYear.setBounds(140, 119, 75, 20);
		PaneConcert.add(txt_ConcertYear);

		JTextField txt_ConcertPlace = new JTextField();
		txt_ConcertPlace.setBackground(new Color(255, 255, 255));
		txt_ConcertPlace.setEditable(false);
		txt_ConcertPlace.setBounds(140, 73, 150, 20);
		PaneConcert.add(txt_ConcertPlace);
		PaneConcert.setVisible(false);

		JButton btn_MyTickets3 = new JButton("Biletlerim");
		btn_MyTickets3.setFocusable(false);
		btn_MyTickets3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_MyTickets3.setBounds(60, 435, 100, 30);
		PaneConcert.add(btn_MyTickets3);
		btn_MyTickets3.setForeground(new Color(0, 0, 0));
		btn_MyTickets3.setBackground(new Color(255, 255, 153));
		btn_MyTickets3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		JButton btn_BuyTicket3 = new JButton("Bilet Al");
		btn_BuyTicket3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (comboBox_Method3.getSelectedIndex() == 1) {
					BuyTicket.setlblCard("Ucret, BANKA/KREDİ KARTI ile ödenmistir. Borcunuz yoktur.");
					BuyTicket.setPrice("Odendi");

					if (fld_concertName.getText().length() == 0 || fld_ThetaerType.getText().length() == 0
							|| fld_Director.getText().length() == 0 || fld_Artist33.getText().length() == 0
							|| fld_Seance3.getText().length() == 0 || fld_Name_concert.getText().length() == 0
							|| fld_Surname_concert.getText().length() == 0
							|| fld_Mail_concert.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}

					if (fld_CartName33.getText().length() == 0 || fld_CartNumber33.getText().length() == 0
							|| fld_cvc33.getText().length() == 0 || comboBox_Month3.getSelectedIndex() == 0
							|| comboBox_Year3.getSelectedIndex() == 0) {
						if (fld_CartName33.getText().length() == 0) {
							fld_CartName33.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_CartName33.getText().length() > 0) {
										fld_CartName33.setBackground(Color.white);
									} else {
										fld_CartName33.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_CartName33.setBackground(Color.white);
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub

								}

							});
						}
						if (fld_CartNumber33.getText().length() == 0) {
							fld_CartNumber33.getDocument()
									.addDocumentListener((DocumentListener) new DocumentListener() {

										@Override
										public void insertUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub
											if (fld_CartNumber33.getText().length() == 16) {
												fld_CartNumber33.setBackground(Color.white);
											} else {
												fld_CartNumber33.setBackground(Color.ORANGE);
											}
										}

										@Override
										public void removeUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub
											fld_CartNumber33.setBackground(Color.white);
										}

										@Override
										public void changedUpdate(DocumentEvent e) {
											// TODO Auto-generated method stub

										}

									});
						}
						if (fld_cvc33.getText().length() == 0) {
							fld_cvc33.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

								@Override
								public void insertUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									if (fld_cvc33.getText().length() == 3) {
										fld_cvc33.setBackground(Color.white);
									} else {
										fld_cvc33.setBackground(Color.ORANGE);
									}
								}

								@Override
								public void removeUpdate(DocumentEvent e) {
									// TODO Auto-generated method stub
									fld_cvc33.setBackground(Color.white);
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

						} else if (fld_CartNumber3.getText().length() != 16 || fld_cvc3.getText().length() != 3) {
							JOptionPane.showMessageDialog(null, "Kart bilgilerinde hatali giris.", "Mesaj",
									JOptionPane.ERROR_MESSAGE);
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
								Metod_Helper.showMsg("Odemeniz Basarıyla Gerceklesti");
								ticket.setVisible(true);
							}
						}
					}

				} else {

					BuyTicket.setlblCard(BuyTicket.getPrice() + " odemeniz vardır. Iyi günler Dileriz.");
					if (fld_concertName.getText().length() == 0 || fld_ThetaerType.getText().length() == 0
							|| fld_Artist33.getText().length() == 0 || txt_ConcertYear.getText().length() == 0
							|| txt_ConcertPlace.getText().length() == 0 || fld_Seance3.getText().length() == 0
							|| fld_Name_concert.getText().length() == 0 || fld_Surname_concert.getText().length() == 0
							|| fld_Mail_concert.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Gerekli birkac bilgi eksik.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						BuyTicket ticket = new BuyTicket();

						if (JOptionPane.showConfirmDialog(null, "Satin Almayi Onayliyor musunuz?", "Dikkat!",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							Metod_Helper.showMsg("succes");
							ticket.setVisible(true);
						}

					}
				}

			}
		});
		btn_BuyTicket3.setFocusable(false);
		btn_BuyTicket3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_BuyTicket3.setForeground(new Color(0, 0, 0));
		btn_BuyTicket3.setBackground(new Color(153, 255, 153));
		btn_BuyTicket3.setBounds(175, 435, 100, 30);
		PaneConcert.add(btn_BuyTicket3);
		btn_BuyTicket3.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btn_CancelTicket3 = new JButton("Bilet Iptal");
		btn_CancelTicket3.setFocusable(false);
		btn_CancelTicket3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_CancelTicket3.setBounds(290, 435, 100, 30);
		PaneConcert.add(btn_CancelTicket3);
		btn_CancelTicket3.setForeground(new Color(0, 0, 0));
		btn_CancelTicket3.setBackground(new Color(255, 153, 153));
		btn_CancelTicket3.setFont(new Font("SansSerif", Font.PLAIN, 15));

///////////////////////////////////////////////////// PANEKONSER////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JButton btn_Select = new JButton("Sec");
		btn_Select.setFocusable(false);
		btn_Select.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Select.setForeground(new Color(0, 0, 0));
		btn_Select.setBackground(new Color(204, 204, 255));
		btn_Select.setBounds(431, 270, 60, 30);
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

						fld_MovieName.setText(selCinemaName);
						fld_MovieType.setText(selCinemaType);
						fld_Director.setText(selCinemaDirector);
						fld_CinemaDate.setText(selCinemaDate);
						fld_Salon.setText(selCinemaSalon);
						fld_Seance.setText(selCinemaSeance);
						lbl_Poster.setText("Poster");// Poster, Film Kay�t i�leminde poster ekledikten sonra
														// ayarlan�lacak

					} else {
						JOptionPane.showMessageDialog(null, "Lutfen bir film seciniz.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				///////////////////////////////////////////////////////////////
				if (tabbedPane.getSelectedIndex() == 1) {
					int selRow1 = table_Theater.getSelectedRow();
					if (selRow1 >= 0) {
						String selTheaterName = table_Theater.getModel().getValueAt(selRow1, 0).toString();
						String selTheaterType = table_Theater.getModel().getValueAt(selRow1, 1).toString();
						String selTheaterDirector = table_Theater.getModel().getValueAt(selRow1, 2).toString();
						String selTheaterSalon = table_Theater.getModel().getValueAt(selRow1, 3).toString();
						String selTheaterTime = table_Theater.getModel().getValueAt(selRow1, 4).toString();

						fld_GameName.setText(selTheaterName);
						fld_GameType.setText(selTheaterType);
						fld_Director2.setText(selTheaterDirector);
						fld_Salon2.setText(selTheaterSalon);
						fld_Time.setText(selTheaterTime);
						lbl_Poster2.setText("Poster1");// Poster, Tiyatro Kay�t i�leminde poster ekledikten sonra
														// ayarlan�lacak

					} else {
						JOptionPane.showMessageDialog(null, "Lutfen Bir Tiyatro Oyunu Seciniz.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				///////////////////////////////////////////
				if (tabbedPane.getSelectedIndex() == 2) {
					int selRow2 = table_Concert.getSelectedRow();
					if (selRow2 >= 0) {
						String selConcertName = table_Concert.getModel().getValueAt(selRow2, 0).toString();
						String selConcertPlace = table_Concert.getModel().getValueAt(selRow2, 1).toString();
						String selConcertArtist = table_Concert.getModel().getValueAt(selRow2, 2).toString();
						String selConcertDate = table_Concert.getModel().getValueAt(selRow2, 3).toString();
						String selTheaterTime = table_Concert.getModel().getValueAt(selRow2, 4).toString();

						fld_concertName.setText(selConcertName);
						txt_ConcertPlace.setText(selConcertPlace);
						fld_Artist33.setText(selConcertArtist);
						txt_ConcertYear.setText(selConcertDate);
						fld_Seance3.setText(selTheaterTime);
						lbl_Poster3.setText("Poster2");// Poster, Konser Kay�t isleminde poster ekledikten sonra
														// ayarlanilacak

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
				} // 1 ve 2 için düzenleme gerekli olabilr
				if (tabbedPane.getSelectedIndex() == 1) {
					btn_SelectSeat.setEnabled(true);
					BuyTicket.setMovie(fld_TheaterName.getText());
					BuyTicket.setSeance(fld_Seance2.getText());
					BuyTicket.setSalon(fld_Salon22.getText());
					BuyTicket.setMovieType(fld_ThetaerType.getText());
				}
				if (tabbedPane.getSelectedIndex() == 2) {
					btn_SelectSeat.setEnabled(true);
					BuyTicket.setMovie(fld_concertName.getText());
					BuyTicket.setSeance(fld_Seance3.getText());
					BuyTicket.setSalon(txt_ConcertPlace.getText());
					BuyTicket.setMovieType(fld_ConcertType.getText());
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
}