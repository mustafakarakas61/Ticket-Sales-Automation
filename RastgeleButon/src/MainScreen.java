import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel cinemaModel; // tablo sütunlarýný isimlendirmek için
	private DefaultTableModel theaterModel;
	private DefaultTableModel concertModel;
	private Object[] cinemaData = null; // sqlden veri çekmek için
	private Object[] theaterData = null;
	private Object[] concertData = null;
	private JTable table_Cinema;
	private JTable table_Theater;
	private JTable table_Concert;
	private JTextField fld_MovieName;
	private JTextField fld_MovieType;
	private JTextField fld_Director;
	private JTextField fld_Salon;
	private JTextField fld_Seance;
	private JTextField fld_Name_cinema;
	private JTextField fld_Surname_cinema;
	private JTextField fld_Mail_cinema;
	private JTextField fld_cvc;
	private JTextField fld_CartName;
	private JTextField fld_CartNumber;

	private JTextField fld_GameName;
	private JTextField fld_GameType;
	private JTextField fld_Director2;
	private JTextField fld_Salon2;
	private JTextField fld_SeatSelection2;
	private JTextField fld_Time;
	private JTextField fld_Name2;
	private JTextField fld_Surname2;
	private JTextField fld_Mail2;
	private JTextField fld_Price2;
	private JTextField fld_cvc2;
	private JTextField fld_CartName2;
	private JTextField fld_CartNumber2;

	private JTextField fld_ConcertName;
	private JTextField fld_ConcertType;
	private JTextField fld_Date2;
	private JTextField fld_Salon3;
	private JTextField fld_SeatSelection3;
	private JTextField fld_Time2;
	private JTextField fld_Name3;
	private JTextField fld_Surname3;
	private JTextField fld_Mail3;
	private JTextField fld_Price3;
	private JTextField fld_cvc3;
	private JTextField fld_CartName3;
	private JTextField fld_CartNumber3;
	private static user member = new Member();
	private static SubACinema sinema = new SubACinema();
	private static SubATheater tiyatro = new SubATheater();
	private static SubAConcert konser = new SubAConcert();

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

	/**
	 * Create the frame.
	 */
	/**
	 * @param member
	 */
	/**
	 * @param member
	 * @throws SQLException
	 */
	public MainScreen(user member) throws SQLException {
		setTitle("Bilet Satýþ Sistemi");
		setResizable(false);

//////////////////////////////////////////////////////////////////////////////////Sinema
		cinemaModel = new DefaultTableModel();
		Object[] colCinema = new Object[6]; // tablo sütunlarýna isim vermek için

		colCinema[0] = "Film Adý";
		colCinema[1] = "Tür";
		colCinema[2] = "Yönetmen";
		colCinema[3] = "Tarih";
		colCinema[4] = "Salon";
		colCinema[5] = "Seans";

		cinemaModel.setColumnIdentifiers(colCinema);
		cinemaData = new Object[6]; // sqlden veri çekmek için

//////////////////////////////////////////////////////////////////////////////////Tiyatro
		theaterModel = new DefaultTableModel();
		Object[] colTheater = new Object[5];

		colTheater[0] = "Oyun Adý";
		colTheater[1] = "Tür";
		colTheater[2] = "Tarih";
		colTheater[3] = "Salon";
		colTheater[4] = "Saat";
		theaterModel.setColumnIdentifiers(colTheater);
		theaterData = new Object[5]; // sqlden veri çekmek için

//////////////////////////////////////////////////////////////////////////////////Konser
		concertModel = new DefaultTableModel();
		Object[] colConcert = new Object[4];

		colConcert[0] = "Konser Adý";
		colConcert[1] = "Tür";
		colConcert[2] = "Tarihi";
		colConcert[3] = "Saat";

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

		JButton btn_Exit = new JButton("Çýkýþ Yap");
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

		JLabel lbl_Name = new JLabel("Hoþgeldiniz Sayýn " + member.getName());
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

		table_Cinema.getColumn("Film Adý").setCellEditor(new TableEditor(new JCheckBox()));
        table_Cinema.getColumn("Tür").setCellEditor(new TableEditor(new JCheckBox()));
        table_Cinema.getColumn("Yönetmen").setCellEditor(new TableEditor(new JCheckBox()));
        table_Cinema.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
        table_Cinema.getColumn("Salon").setCellEditor(new TableEditor(new JCheckBox()));
        table_Cinema.getColumn("Seans").setCellEditor(new TableEditor(new JCheckBox()));
		
    	scrollPane_Cinema.setViewportView(table_Cinema);
     
    	table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(55);
        table_Cinema.getColumnModel().getColumn(0).setResizable(false);
    //    table_Cinema.getColumnModel().getColumn(0).

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

		/************************* Þimdilik Veri Ekliyorum ***************************/
		/*
		 * cinemaData[0] = "Recep Ývedik 7"; cinemaData[1] = "Komedi"; cinemaData[2] =
		 * "Þahan Gökbakar"; cinemaData[3] = 1; cinemaData[4] = "13:40";
		 * cinemaModel.addRow(cinemaData); cinemaData[0] = "Hýzlý ve Öfkeli 10";
		 * cinemaData[1] = "Aksiyon"; cinemaData[2] = "Rob Cohen"; cinemaData[3] = 4;
		 * cinemaData[4] = "16:30"; cinemaModel.addRow(cinemaData);
		 */

		/****************************************************/
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
		scrollPane_Theater.setViewportView(table_Theater);

		/*
		 * table_Theater.getColumnModel().getColumn(0).setPreferredWidth(60);
		 * table_Theater.getColumnModel().getColumn(0).setResizable(false);
		 * 
		 * table_Theater.getColumnModel().getColumn(1).setPreferredWidth(30);
		 * table_Theater.getColumnModel().getColumn(1).setResizable(false); //
		 * table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		 * table_Theater.getColumnModel().getColumn(2).setResizable(false);
		 * table_Theater.getColumnModel().getColumn(3).setPreferredWidth(10);
		 * table_Theater.getColumnModel().getColumn(3).setResizable(false);
		 * table_Theater.getColumnModel().getColumn(4).setPreferredWidth(10);
		 * table_Theater.getColumnModel().getColumn(4).setResizable(false);
		 */

		for (int i = 0; i < tiyatro.theaterList().size(); i++) {
			theaterData[0] = tiyatro.theaterList().get(i).getTiyatroName();
			theaterData[1] = tiyatro.theaterList().get(i).getTiyatroType();
			theaterData[2] = tiyatro.theaterList().get(i).getTiyatroDate();
			theaterData[3] = tiyatro.theaterList().get(i).getTiyatroSalon();
			theaterData[4] = tiyatro.theaterList().get(i).getTiyatroSaat();
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
		scrollPane_Concert.setViewportView(table_Concert);
		table_Concert.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Concert.getColumnModel().getColumn(0).setResizable(false);

		table_Concert.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Concert.getColumnModel().getColumn(1).setResizable(false);

		table_Concert.getColumnModel().getColumn(2).setPreferredWidth(10);
		table_Concert.getColumnModel().getColumn(2).setResizable(false);

		table_Concert.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Concert.getColumnModel().getColumn(3).setResizable(false);

		for (int i = 0; i < konser.concertList().size(); i++) {
			concertData[0] = konser.concertList().get(i).getConcertName();
			concertData[1] = konser.concertList().get(i).getConcertType();
			concertData[2] = konser.concertList().get(i).getConcertDate();
			concertData[3] = konser.concertList().get(i).getConcertTime();
			concertModel.addRow(concertData);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////// PANESÝNEMA///////////////////////////////////////////////////////////////
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

		JLabel lbl_MovieName = new JLabel("Film Adý:");
		lbl_MovieName.setBackground(new Color(255, 255, 255));
		lbl_MovieName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 50, 100, 20);
		PaneCinema.add(lbl_MovieName);

		JLabel lbl_MovieType = new JLabel("Film Türü:");
		lbl_MovieType.setBackground(new Color(255, 255, 255));
		lbl_MovieType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_MovieType.setBounds(10, 73, 100, 20);
		PaneCinema.add(lbl_MovieType);

		JLabel lbl_Admin = new JLabel("Yönetmen:");
		lbl_Admin.setBackground(new Color(255, 255, 255));
		lbl_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Admin.setBounds(10, 96, 100, 20);
		PaneCinema.add(lbl_Admin);

		JLabel lbl_Salon = new JLabel("Salon:");
		lbl_Salon.setBackground(new Color(255, 255, 255));
		lbl_Salon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon.setBounds(10, 119, 100, 20);
		PaneCinema.add(lbl_Salon);

		JLabel lbl_Seance = new JLabel("Seans:");
		lbl_Seance.setBackground(new Color(255, 255, 255));
		lbl_Seance.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Seance.setBounds(10, 142, 100, 20);
		PaneCinema.add(lbl_Seance);

		JButton btn_SelectSeat = new JButton("Koltuk Seç");
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
		btn_SelectSeat.setBounds(10, 165, 100, 22);
		PaneCinema.add(btn_SelectSeat);

		JLabel lbl_PaymentInformation = new JLabel("Ödeme Bilgileri");
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

		fld_Director = new JTextField();
		fld_Director.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Director.setBackground(new Color(255, 255, 255));
		fld_Director.setEditable(false);
		fld_Director.setColumns(10);
		fld_Director.setBounds(140, 96, 150, 20);
		PaneCinema.add(fld_Director);

		fld_Salon = new JTextField();
		fld_Salon.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Salon.setBackground(new Color(255, 255, 255));
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(140, 119, 75, 20);
		PaneCinema.add(fld_Salon);

		fld_Seance = new JTextField();
		fld_Seance.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Seance.setBackground(new Color(255, 255, 255));
		fld_Seance.setEditable(false);
		fld_Seance.setColumns(10);
		fld_Seance.setBounds(140, 142, 75, 20);
		PaneCinema.add(fld_Seance);

		JLabel lbl_PaymentMethod = new JLabel("Ödeme Yöntemi:");
		lbl_PaymentMethod.setBackground(new Color(255, 255, 255));
		lbl_PaymentMethod.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod.setBounds(10, 304, 120, 20);
		PaneCinema.add(lbl_PaymentMethod);

		JComboBox comboBox_Method = new JComboBox();
		comboBox_Method.setBackground(new Color(255, 255, 255));
		comboBox_Method.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Method.setBounds(140, 304, 130, 25);
		comboBox_Method.addItem("Nakit");
		comboBox_Method.addItem("Banka/Kredi Kartý");
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

		fld_Name_cinema = new JTextField();
		fld_Name_cinema.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Name_cinema.setText(member.getName());
		fld_Name_cinema.setEditable(false);
		fld_Name_cinema.setColumns(10);
		fld_Name_cinema.setBackground(new Color(255, 255, 255));
		fld_Name_cinema.setBounds(140, 235, 150, 20);
		PaneCinema.add(fld_Name_cinema);

		fld_Surname_cinema = new JTextField();
		fld_Surname_cinema.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Surname_cinema.setText(member.getSurname());
		fld_Surname_cinema.setEditable(false);
		fld_Surname_cinema.setColumns(10);
		fld_Surname_cinema.setBackground(new Color(255, 255, 255));
		fld_Surname_cinema.setBounds(140, 258, 150, 20);
		PaneCinema.add(fld_Surname_cinema);

		fld_Mail_cinema = new JTextField();
		fld_Mail_cinema.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Mail_cinema.setText(member.getEmail());
		fld_Mail_cinema.setEditable(false);
		fld_Mail_cinema.setColumns(10);
		fld_Mail_cinema.setBackground(new Color(255, 255, 255));
		fld_Mail_cinema.setBounds(140, 281, 150, 20);
		PaneCinema.add(fld_Mail_cinema);

		JLabel lbl_CartName = new JLabel("Kart Üzerindeki Ýsim:");
		lbl_CartName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName.setBounds(10, 8, 140, 20);
		w_pane_Kart.add(lbl_CartName);

		JLabel lbl_CartNumber = new JLabel("Kart Numarasý:");
		lbl_CartNumber.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber.setBounds(10, 30, 140, 20);
		w_pane_Kart.add(lbl_CartNumber);

		JLabel lbl_LastUsageDate = new JLabel("Son Kullaným Tarihi:");
		lbl_LastUsageDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate.setBounds(10, 52, 140, 20);
		w_pane_Kart.add(lbl_LastUsageDate);

		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Month.setBounds(160, 52, 60, 22);
		comboBox_Month.addItem("Ay");
		w_pane_Kart.add(comboBox_Month);

		JComboBox comboBox_Year = new JComboBox();
		comboBox_Year.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Year.setBounds(235, 52, 72, 22);
		comboBox_Year.addItem("Yýl");

		w_pane_Kart.add(comboBox_Year);

		JLabel lbl_Cvc = new JLabel("CVC:");
		lbl_Cvc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc.setBounds(325, 52, 40, 20);
		w_pane_Kart.add(lbl_Cvc);

		fld_cvc = new JTextField();
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

		fld_CartName = new JTextField();
		fld_CartName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartName.setColumns(10);
		fld_CartName.setBackground(Color.WHITE);
		fld_CartName.setBounds(160, 8, 260, 20);
		fld_CartName.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ý' || ke.getKeyChar() == 'ð' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'þ' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'Ý' || ke.getKeyChar() == 'Ð' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Þ' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
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

		fld_CartNumber = new JTextField();
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
				BuyTicket ticket = new BuyTicket();
				
				ticket.setVisible(true);
			}
		});
		btn_BuyTicket.setFocusable(false);
		btn_BuyTicket.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_BuyTicket.setForeground(new Color(0, 0, 0));
		btn_BuyTicket.setBackground(new Color(153, 255, 153));
		btn_BuyTicket.setBounds(175, 435, 100, 30);
		PaneCinema.add(btn_BuyTicket);
		btn_BuyTicket.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btn_CancelTicket = new JButton("Bilet Ýptal");
		btn_CancelTicket.setFocusable(false);
		btn_CancelTicket.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_CancelTicket.setBounds(290, 435, 100, 30);
		PaneCinema.add(btn_CancelTicket);
		btn_CancelTicket.setForeground(new Color(0, 0, 0));
		btn_CancelTicket.setBackground(new Color(255, 153, 153));
		btn_CancelTicket.setFont(new Font("SansSerif", Font.PLAIN, 15));
		///////////////////////////////////////////////// PANESÝNEMA/////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////// PANETÝYATRO///////////////////////////////////////////////////////////////
		JPanel PaneTheater = new JPanel();
		PaneTheater.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneTheater.setBackground(Color.WHITE);
		PaneTheater.setBounds(504, 60, 450, 479);
		contentPane.add(PaneTheater);
		PaneTheater.setLayout(null);

		JButton btn_BuyTicket2 = new JButton("Bilet Al");
		btn_BuyTicket2.setFocusable(false);
		btn_BuyTicket2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_BuyTicket2.setForeground(new Color(0, 0, 0));
		btn_BuyTicket2.setBackground(new Color(153, 255, 153));
		btn_BuyTicket2.setBounds(175, 435, 100, 30);
		PaneTheater.add(btn_BuyTicket2);
		btn_BuyTicket2.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lbl_Poster2 = new JLabel("");
		lbl_Poster2.setBounds(312, 20, 120, 170);
		PaneTheater.add(lbl_Poster2);

		JLabel lbl_GameName = new JLabel("Oyun Adý:");
		lbl_GameName.setBackground(Color.WHITE);
		lbl_GameName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_GameName.setBounds(10, 50, 100, 20);
		PaneTheater.add(lbl_GameName);

		JLabel lbl_GameType = new JLabel("Oyun Türü:");
		lbl_GameType.setBackground(Color.WHITE);
		lbl_GameType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_GameType.setBounds(10, 73, 100, 20);
		PaneTheater.add(lbl_GameType);

		JLabel lbl_Date = new JLabel("Tarih:");
		lbl_Date.setBackground(Color.WHITE);
		lbl_Date.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Date.setBounds(10, 96, 100, 20);
		PaneTheater.add(lbl_Date);

		JLabel lbl_Salon2 = new JLabel("Salon:");
		lbl_Salon2.setBackground(Color.WHITE);
		lbl_Salon2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon2.setBounds(10, 119, 100, 20);
		PaneTheater.add(lbl_Salon2);

		JLabel lbl_Time = new JLabel("Saat:");
		lbl_Time.setBackground(Color.WHITE);
		lbl_Time.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Time.setBounds(10, 142, 100, 20);
		PaneTheater.add(lbl_Time);

		JButton btn_SelectSeat2 = new JButton("Koltuk Seç");
		btn_SelectSeat2.setFocusable(false);
		btn_SelectSeat2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_SelectSeat2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_SelectSeat2.setBackground(new Color(255, 153, 102));
		btn_SelectSeat2.setBounds(10, 165, 100, 22);
		PaneTheater.add(btn_SelectSeat2);

		JLabel lbl_PaymentInfo2 = new JLabel("Ödeme Bilgileri");
		lbl_PaymentInfo2.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInfo2.setBounds(10, 205, 130, 20);
		PaneTheater.add(lbl_PaymentInfo2);

		JLabel lblTheaterInfo = new JLabel("Tiyatro Bilgileri");
		lblTheaterInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblTheaterInfo.setBounds(10, 20, 150, 20);
		PaneTheater.add(lblTheaterInfo);

		JLabel lbl_GameName_2 = new JLabel("Ad:");
		lbl_GameName_2.setBackground(Color.WHITE);
		lbl_GameName_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_GameName_2.setBounds(10, 235, 100, 20);
		PaneTheater.add(lbl_GameName_2);

		JLabel lbl_GameType_2 = new JLabel("Soyad:");
		lbl_GameType_2.setBackground(Color.WHITE);
		lbl_GameType_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_GameType_2.setBounds(10, 258, 100, 20);
		PaneTheater.add(lbl_GameType_2);

		JLabel lbl_Date_2 = new JLabel("E-Mail:");
		lbl_Date_2.setBackground(Color.WHITE);
		lbl_Date_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Date_2.setBounds(10, 281, 100, 20);
		PaneTheater.add(lbl_Date_2);

		fld_GameName = new JTextField();
		fld_GameName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_GameName.setBackground(Color.WHITE);
		fld_GameName.setEditable(false);
		fld_GameName.setBounds(140, 50, 150, 20);
		PaneTheater.add(fld_GameName);
		fld_GameName.setColumns(10);

		fld_GameType = new JTextField();
		fld_GameType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_GameType.setBackground(Color.WHITE);
		fld_GameType.setEditable(false);
		fld_GameType.setColumns(10);
		fld_GameType.setBounds(140, 73, 150, 20);
		PaneTheater.add(fld_GameType);

		fld_Director2 = new JTextField();
		fld_Director2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Director2.setBackground(Color.WHITE);
		fld_Director2.setEditable(false);
		fld_Director2.setColumns(10);
		fld_Director2.setBounds(140, 96, 150, 20);
		PaneTheater.add(fld_Director2);

		fld_Salon2 = new JTextField();
		fld_Salon2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Salon2.setBackground(Color.WHITE);
		fld_Salon2.setEditable(false);
		fld_Salon2.setColumns(10);
		fld_Salon2.setBounds(140, 119, 75, 20);
		PaneTheater.add(fld_Salon2);

		fld_SeatSelection2 = new JTextField();
		fld_SeatSelection2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_SeatSelection2.setBackground(Color.WHITE);
		fld_SeatSelection2.setEditable(false);
		fld_SeatSelection2.setColumns(10);
		fld_SeatSelection2.setBounds(140, 165, 75, 20);
		PaneTheater.add(fld_SeatSelection2);

		fld_Time = new JTextField();
		fld_Time.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Time.setBackground(Color.WHITE);
		fld_Time.setEditable(false);
		fld_Time.setColumns(10);
		fld_Time.setBounds(140, 142, 75, 20);
		PaneTheater.add(fld_Time);

		JLabel lbl_PaymentMethod2 = new JLabel("Ödeme Yöntemi:");
		lbl_PaymentMethod2.setBackground(Color.WHITE);
		lbl_PaymentMethod2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod2.setBounds(10, 304, 120, 20);
		PaneTheater.add(lbl_PaymentMethod2);

		JComboBox comboBox_Method2 = new JComboBox();
		comboBox_Method2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Method2.setBackground(Color.WHITE);
		comboBox_Method2.setBounds(140, 304, 130, 25);
		comboBox_Method2.addItem("Nakit");
		comboBox_Method2.addItem("Banka/Kredi Kartý");
		PaneTheater.add(comboBox_Method2);

		JPanel w_pane_Cart2 = new JPanel();
		w_pane_Cart2.setBackground(SystemColor.inactiveCaption);
		w_pane_Cart2.setBounds(10, 340, 430, 80);
		PaneTheater.add(w_pane_Cart2);
		w_pane_Cart2.setLayout(null);
		w_pane_Cart2.setVisible(false);
		comboBox_Method2.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method2.getSelectedIndex() == 0) {
					w_pane_Cart2.setVisible(false);

				} else {
					w_pane_Cart2.setVisible(true);
				}
			}
		});

		fld_Name2 = new JTextField();
		fld_Name2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Name2.setEditable(false);
		fld_Name2.setColumns(10);
		fld_Name2.setBackground(Color.WHITE);
		fld_Name2.setBounds(140, 235, 150, 20);
		PaneTheater.add(fld_Name2);

		fld_Surname2 = new JTextField();
		fld_Surname2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Surname2.setEditable(false);
		fld_Surname2.setColumns(10);
		fld_Surname2.setBackground(Color.WHITE);
		fld_Surname2.setBounds(140, 258, 150, 20);
		PaneTheater.add(fld_Surname2);

		fld_Mail2 = new JTextField();
		fld_Mail2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Mail2.setEditable(false);
		fld_Mail2.setColumns(10);
		fld_Mail2.setBackground(Color.WHITE);
		fld_Mail2.setBounds(140, 281, 150, 20);
		PaneTheater.add(fld_Mail2);

		JLabel lbl_Price2 = new JLabel("Toplam Tutar");
		lbl_Price2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Price2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Price2.setBounds(308, 260, 100, 20);
		PaneTheater.add(lbl_Price2);

		fld_Price2 = new JTextField();
		fld_Price2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_Price2.setBackground(Color.WHITE);
		fld_Price2.setEditable(false);
		fld_Price2.setBounds(310, 280, 100, 30);
		PaneTheater.add(fld_Price2);
		fld_Price2.setColumns(10);

		JLabel lbl_CartName2 = new JLabel("Kart Üzerindeki Ýsim:");
		lbl_CartName2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName2.setBounds(10, 8, 140, 20);
		w_pane_Cart2.add(lbl_CartName2);

		JLabel lbl_CartNumber2 = new JLabel("Kart Numarasý:");
		lbl_CartNumber2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber2.setBounds(10, 30, 140, 20);
		w_pane_Cart2.add(lbl_CartNumber2);

		JLabel lbl_LastUsageDate2 = new JLabel("Son Kullaným Tarihi:");
		lbl_LastUsageDate2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate2.setBounds(10, 52, 140, 20);
		w_pane_Cart2.add(lbl_LastUsageDate2);

		JComboBox comboBox_Month2 = new JComboBox();
		comboBox_Month2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Month2.setBounds(160, 52, 60, 22);
		comboBox_Month2.addItem("Ay");
		w_pane_Cart2.add(comboBox_Month2);

		JComboBox comboBox_Year2 = new JComboBox();
		comboBox_Year2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Year2.setBounds(235, 52, 72, 22);
		comboBox_Year2.addItem("Yýl");
		w_pane_Cart2.add(comboBox_Year2);

		JLabel lbl_Cvc2 = new JLabel("CVC:");
		lbl_Cvc2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc2.setBounds(325, 52, 40, 20);
		w_pane_Cart2.add(lbl_Cvc2);

		fld_cvc2 = new JTextField();
		fld_cvc2.setFont(new Font("SansSerif", Font.PLAIN, 14));
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
		w_pane_Cart2.add(fld_cvc2);
		fld_cvc2.setColumns(10);

		fld_CartName2 = new JTextField();
		fld_CartName2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartName2.setColumns(10);
		fld_CartName2.setBackground(Color.WHITE);
		fld_CartName2.setBounds(160, 8, 260, 20);
		fld_CartName2.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ý' || ke.getKeyChar() == 'ð' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'þ' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'Ý' || ke.getKeyChar() == 'Ð' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Þ' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartName2.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartName2.setEditable(true);
					} else {
						fld_CartName2.setEditable(false);
					}

				} else {
					fld_CartName2.setEditable(false);

				}
			}
		});

		w_pane_Cart2.add(fld_CartName2);

		fld_CartNumber2 = new JTextField();
		fld_CartNumber2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartNumber2.setColumns(10);
		fld_CartNumber2.setBackground(Color.WHITE);
		fld_CartNumber2.setBounds(160, 30, 260, 20);
		fld_CartNumber2.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

					if (fld_CartNumber2.getText().length() <= 15 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						fld_CartNumber2.setEditable(true);
					} else {
						fld_CartNumber2.setEditable(false);
					}

				} else {
					fld_CartNumber2.setEditable(false);

				}
			}
		});
		w_pane_Cart2.add(fld_CartNumber2);

		JButton btn_MyTickets_1 = new JButton("Biletlerim");
		btn_MyTickets_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_MyTickets_1.setFocusable(false);
		btn_MyTickets_1.setForeground(new Color(0, 0, 0));
		btn_MyTickets_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_MyTickets_1.setBackground(new Color(255, 255, 153));
		btn_MyTickets_1.setBounds(60, 435, 100, 30);
		PaneTheater.add(btn_MyTickets_1);

		JButton btn_TicketCancel_1 = new JButton("Bilet Ýptal");
		btn_TicketCancel_1.setFocusable(false);
		btn_TicketCancel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_TicketCancel_1.setForeground(new Color(0, 0, 0));
		btn_TicketCancel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_TicketCancel_1.setBackground(new Color(255, 153, 153));
		btn_TicketCancel_1.setBounds(290, 435, 100, 30);
		PaneTheater.add(btn_TicketCancel_1);
		PaneTheater.setVisible(false);
		///////////////////////////////////////////////////// PANETÝYATRO////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////// PANEKONSERs///////////////////////////////////////////////////////////////
		JPanel PaneConcert = new JPanel();
		PaneConcert.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PaneConcert.setBackground(new Color(255, 255, 255));
		PaneConcert.setBounds(504, 60, 450, 479);
		contentPane.add(PaneConcert);
		PaneConcert.setLayout(null);

		JButton btn_BuyTicket3 = new JButton("Bilet Al");
		btn_BuyTicket3.setFocusable(false);
		btn_BuyTicket3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_BuyTicket3.setForeground(new Color(0, 0, 0));
		btn_BuyTicket3.setBackground(new Color(153, 255, 153));
		btn_BuyTicket3.setBounds(175, 435, 100, 30);
		PaneConcert.add(btn_BuyTicket3);
		btn_BuyTicket3.setFont(new Font("SansSerif", Font.BOLD, 15));

		JLabel lbl_Poster3 = new JLabel("");
		lbl_Poster3.setBounds(324, 35, 128, 161);
		PaneConcert.add(lbl_Poster3);

		JLabel lbl_ConcertName = new JLabel("Konser Adý:");
		lbl_ConcertName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertName.setBounds(10, 50, 100, 20);
		PaneConcert.add(lbl_ConcertName);

		JLabel lbl_ConcertType = new JLabel("Konser Türü:");
		lbl_ConcertType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertType.setBounds(10, 73, 100, 20);
		PaneConcert.add(lbl_ConcertType);

		JLabel lbl_Date2 = new JLabel("Tarih:");
		lbl_Date2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Date2.setBounds(10, 96, 100, 20);
		PaneConcert.add(lbl_Date2);

		JLabel lbl_Salon3 = new JLabel("Salon:");
		lbl_Salon3.setEnabled(false);
		lbl_Salon3.setFocusable(false);
		lbl_Salon3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Salon3.setBounds(10, 119, 100, 20);
		PaneConcert.add(lbl_Salon3);

		JLabel lbl_Time2 = new JLabel("Saat:");
		lbl_Time2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Time2.setBounds(10, 142, 100, 20);
		PaneConcert.add(lbl_Time2);

		JButton btn_SeatSelection3 = new JButton("Koltuk Seç");
		btn_SeatSelection3.setFocusable(false);
		btn_SeatSelection3.setEnabled(false);
		btn_SeatSelection3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_SeatSelection3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_SeatSelection3.setBounds(10, 165, 100, 22);
		PaneConcert.add(btn_SeatSelection3);

		JLabel lbl_PaymentInfo3 = new JLabel("Ödeme Bilgileri");
		lbl_PaymentInfo3.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_PaymentInfo3.setBounds(10, 205, 130, 20);
		PaneConcert.add(lbl_PaymentInfo3);

		JLabel lblConcertInfo = new JLabel("Konser Bilgileri");
		lblConcertInfo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblConcertInfo.setBounds(10, 20, 150, 20);
		PaneConcert.add(lblConcertInfo);

		JLabel lbl_ConcertName_2 = new JLabel("Ad:");
		lbl_ConcertName_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertName_2.setBounds(10, 235, 100, 20);
		PaneConcert.add(lbl_ConcertName_2);

		JLabel lbl_ConcertType_2 = new JLabel("Soyad:");
		lbl_ConcertType_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_ConcertType_2.setBounds(10, 258, 100, 20);
		PaneConcert.add(lbl_ConcertType_2);

		JLabel lbl_Date_3 = new JLabel("E-Mail:");
		lbl_Date_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Date_3.setBounds(10, 281, 100, 20);
		PaneConcert.add(lbl_Date_3);

		fld_ConcertName = new JTextField();
		fld_ConcertName.setForeground(new Color(0, 0, 0));
		fld_ConcertName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_ConcertName.setBackground(new Color(255, 255, 255));
		fld_ConcertName.setEditable(false);
		fld_ConcertName.setBounds(140, 50, 150, 20);
		PaneConcert.add(fld_ConcertName);
		fld_ConcertName.setColumns(10);

		fld_ConcertType = new JTextField();
		fld_ConcertType.setForeground(new Color(0, 0, 0));
		fld_ConcertType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_ConcertType.setBackground(new Color(255, 255, 255));
		fld_ConcertType.setEditable(false);
		fld_ConcertType.setColumns(10);
		fld_ConcertType.setBounds(140, 73, 150, 20);
		PaneConcert.add(fld_ConcertType);

		fld_Date2 = new JTextField();
		fld_Date2.setForeground(new Color(0, 0, 0));
		fld_Date2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Date2.setBackground(new Color(255, 255, 255));
		fld_Date2.setEditable(false);
		fld_Date2.setColumns(10);
		fld_Date2.setBounds(140, 96, 150, 20);
		PaneConcert.add(fld_Date2);

		fld_Salon3 = new JTextField();
		fld_Salon3.setForeground(new Color(0, 0, 0));
		fld_Salon3.setEnabled(false);
		fld_Salon3.setFocusable(false);
		fld_Salon3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Salon3.setBackground(new Color(255, 255, 255));
		fld_Salon3.setEditable(false);
		fld_Salon3.setColumns(10);
		fld_Salon3.setBounds(140, 119, 75, 20);
		PaneConcert.add(fld_Salon3);

		fld_SeatSelection3 = new JTextField();
		fld_SeatSelection3.setForeground(new Color(0, 0, 0));
		fld_SeatSelection3.setEnabled(false);
		fld_SeatSelection3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_SeatSelection3.setBackground(new Color(255, 255, 255));
		fld_SeatSelection3.setEditable(false);
		fld_SeatSelection3.setColumns(10);
		fld_SeatSelection3.setBounds(140, 165, 75, 20);
		PaneConcert.add(fld_SeatSelection3);

		fld_Time2 = new JTextField();
		fld_Time2.setForeground(new Color(0, 0, 0));
		fld_Time2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Time2.setBackground(new Color(255, 255, 255));
		fld_Time2.setEditable(false);
		fld_Time2.setColumns(10);
		fld_Time2.setBounds(140, 142, 75, 20);
		PaneConcert.add(fld_Time2);

		JLabel lbl_PaymentMethod3 = new JLabel("Ödeme Yöntemi:");
		lbl_PaymentMethod3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_PaymentMethod3.setBounds(10, 304, 120, 20);
		PaneConcert.add(lbl_PaymentMethod3);

		JComboBox comboBox_Method3 = new JComboBox();
		comboBox_Method3.setForeground(new Color(0, 0, 0));
		comboBox_Method3.setBackground(new Color(255, 255, 255));
		comboBox_Method3.setFocusable(false);
		comboBox_Method3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Method3.setBounds(140, 304, 130, 25);
		comboBox_Method3.addItem("Nakit");
		comboBox_Method3.addItem("Banka/Kredi Kartý");
		PaneConcert.add(comboBox_Method3);

		JPanel w_pane_Cart3 = new JPanel();
		w_pane_Cart3.setBackground(SystemColor.inactiveCaption);
		w_pane_Cart3.setBounds(10, 340, 430, 80);
		PaneConcert.add(w_pane_Cart3);
		w_pane_Cart3.setLayout(null);
		w_pane_Cart3.setVisible(false);
		comboBox_Method3.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method3.getSelectedIndex() == 0) {
					w_pane_Cart3.setVisible(false);

				} else {
					w_pane_Cart3.setVisible(true);
				}
			}
		});

		fld_Name3 = new JTextField();
		fld_Name3.setForeground(new Color(0, 0, 0));
		fld_Name3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Name3.setEditable(false);
		fld_Name3.setColumns(10);
		fld_Name3.setBackground(new Color(255, 255, 255));
		fld_Name3.setBounds(140, 235, 150, 20);
		PaneConcert.add(fld_Name3);

		fld_Surname3 = new JTextField();
		fld_Surname3.setForeground(new Color(0, 0, 0));
		fld_Surname3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Surname3.setEditable(false);
		fld_Surname3.setColumns(10);
		fld_Surname3.setBackground(new Color(255, 255, 255));
		fld_Surname3.setBounds(140, 258, 150, 20);
		PaneConcert.add(fld_Surname3);

		fld_Mail3 = new JTextField();
		fld_Mail3.setForeground(new Color(0, 0, 0));
		fld_Mail3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_Mail3.setEditable(false);
		fld_Mail3.setColumns(10);
		fld_Mail3.setBackground(new Color(255, 255, 255));
		fld_Mail3.setBounds(140, 281, 150, 20);
		PaneConcert.add(fld_Mail3);

		JLabel lbl_Price3 = new JLabel("Toplam Tutar");
		lbl_Price3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Price3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Price3.setBounds(308, 260, 100, 20);
		PaneConcert.add(lbl_Price3);

		fld_Price3 = new JTextField();
		fld_Price3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		fld_Price3.setBackground(Color.WHITE);
		fld_Price3.setEditable(false);
		fld_Price3.setBounds(310, 280, 100, 30);
		PaneConcert.add(fld_Price3);
		fld_Price3.setColumns(10);

		JLabel lbl_CartName3 = new JLabel("Kart Üzerindeki Ýsim:");
		lbl_CartName3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartName3.setBounds(10, 8, 140, 20);
		w_pane_Cart3.add(lbl_CartName3);

		JLabel lbl_CartNumber3 = new JLabel("Kart Numarasý:");
		lbl_CartNumber3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_CartNumber3.setBounds(10, 30, 140, 20);
		w_pane_Cart3.add(lbl_CartNumber3);

		JLabel lbl_LastUsageDate3 = new JLabel("Son Kullaným Tarihi:");
		lbl_LastUsageDate3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_LastUsageDate3.setBounds(10, 52, 140, 20);
		w_pane_Cart3.add(lbl_LastUsageDate3);

		JComboBox comboBox_Month3 = new JComboBox();
		comboBox_Month3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Month3.setBounds(160, 52, 60, 22);
		comboBox_Month3.addItem("Ay");
		w_pane_Cart3.add(comboBox_Month3);

		JComboBox comboBox_Year3 = new JComboBox();
		comboBox_Year3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Year3.setBounds(235, 52, 72, 22);
		comboBox_Year3.addItem("Yýl");
		w_pane_Cart3.add(comboBox_Year3);

		JLabel lbl_Cvc3 = new JLabel("CVC:");
		lbl_Cvc3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Cvc3.setBounds(325, 52, 40, 20);
		w_pane_Cart3.add(lbl_Cvc3);

		fld_cvc3 = new JTextField();
		fld_cvc3.setFont(new Font("SansSerif", Font.PLAIN, 14));
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
		w_pane_Cart3.add(fld_cvc3);
		fld_cvc3.setColumns(10);

		fld_CartName3 = new JTextField();
		fld_CartName3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fld_CartName3.setColumns(10);
		fld_CartName3.setBackground(Color.WHITE);
		fld_CartName3.setBounds(160, 8, 260, 20);
		fld_CartName3.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' '
						|| (ke.getKeyChar() == 'ý' || ke.getKeyChar() == 'ð' || ke.getKeyChar() == 'ü'
								|| ke.getKeyChar() == 'þ' || ke.getKeyChar() == 'ö' || ke.getKeyChar() == 'ç'
								|| ke.getKeyChar() == 'Ý' || ke.getKeyChar() == 'Ð' || ke.getKeyChar() == 'Ü'
								|| ke.getKeyChar() == 'Þ' || ke.getKeyChar() == 'Ö' || ke.getKeyChar() == 'Ç')
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
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
		w_pane_Cart3.add(fld_CartName3);

		fld_CartNumber3 = new JTextField();
		fld_CartNumber3.setFont(new Font("SansSerif", Font.PLAIN, 14));
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
		w_pane_Cart3.add(fld_CartNumber3);

		JButton btn_MyTickets_1_1 = new JButton("Biletlerim");
		btn_MyTickets_1_1.setFocusable(false);
		btn_MyTickets_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_MyTickets_1_1.setForeground(new Color(0, 0, 0));
		btn_MyTickets_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_MyTickets_1_1.setBackground(new Color(255, 255, 153));
		btn_MyTickets_1_1.setBounds(60, 435, 100, 30);
		PaneConcert.add(btn_MyTickets_1_1);

		JButton btn_TicketCancel_1_1 = new JButton("Bilet Ýptal");
		btn_TicketCancel_1_1.setFocusable(false);
		btn_TicketCancel_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_TicketCancel_1_1.setForeground(new Color(0, 0, 0));
		btn_TicketCancel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_TicketCancel_1_1.setBackground(new Color(255, 153, 153));
		btn_TicketCancel_1_1.setBounds(290, 435, 100, 30);
		PaneConcert.add(btn_TicketCancel_1_1);
		PaneConcert.setVisible(false);
		for (int m = 1; m <= 12; m++) {
			comboBox_Month.addItem(m);
		}
		for (int y = 2021; y <= 2030; y++) {
			comboBox_Year.addItem(y);
		}
		for (int m2 = 1; m2 <= 12; m2++) {
			comboBox_Month2.addItem(m2);
		}
		for (int y2 = 2021; y2 <= 2030; y2++) {
			comboBox_Year2.addItem(y2);
		}
		for (int m3 = 1; m3 <= 12; m3++) {
			comboBox_Month3.addItem(m3);
		}
		for (int y3 = 2021; y3 <= 2030; y3++) {
			comboBox_Year3.addItem(y3);
		}

		JButton btn_SelectCinema = new JButton("Seç");
		btn_SelectCinema.setFocusable(false);
		btn_SelectCinema.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_SelectCinema.setForeground(new Color(0, 0, 0));
		btn_SelectCinema.setBackground(new Color(204, 204, 255));
		btn_SelectCinema.setBounds(432, 270, 60, 30);
		contentPane.add(btn_SelectCinema);
		btn_SelectCinema.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_SelectCinema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					int selRow = table_Cinema.getSelectedRow();
					if (selRow >= 0) {
						String selCinemaName = table_Cinema.getModel().getValueAt(selRow, 0).toString();
						String selCinemaType = table_Cinema.getModel().getValueAt(selRow, 1).toString();
						String selCinemaDirector = table_Cinema.getModel().getValueAt(selRow, 2).toString();
						String selCinemaSalon = table_Cinema.getModel().getValueAt(selRow, 3).toString();
						String selCinemaSeance = table_Cinema.getModel().getValueAt(selRow, 4).toString();

						fld_MovieName.setText(selCinemaName);
						fld_MovieType.setText(selCinemaType);
						fld_Director.setText(selCinemaDirector);
						fld_Salon.setText(selCinemaSalon);
						fld_Seance.setText(selCinemaSeance);
						lbl_Poster.setText("Poster");// Poster, Film Kayýt iþleminde poster ekledikten sonra
														// ayarlanýlacak

					} else {
						JOptionPane.showMessageDialog(null, "Lütfen Bir Sinema Seçiniz.", "Mesaj",
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
						lbl_Poster2.setText("Poster1");// Poster, Film Kayýt iþleminde poster ekledikten sonra
														// ayarlanýlacak

					} else {
						JOptionPane.showMessageDialog(null, "Lütfen Bir Tiyatro Oyunu Seçiniz.", "Mesaj",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				
				BuyTicket ticket = new BuyTicket();
				BuyTicket.movie=fld_MovieName.getText();
				BuyTicket.seance=fld_Seance.getText();
				btn_SelectSeat.setEnabled(true);
				
				///////////////////////////////////////////////////////////////// Konser için
				///////////////////////////////////////////////////////////////// henüz
				///////////////////////////////////////////////////////////////// oluþturulmadý.
			}
		});
///////////////////////////////////////////////////// PANEKONSER////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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