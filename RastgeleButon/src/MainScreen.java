import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Panel;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
// herkese selam as
public class MainScreen extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel sinemaModel; // tablo sütunlarýný isimlendirmek için
	private DefaultTableModel tiyatroModel;
	private Object[] sinemaData = null; // sqlden veri çekmek için
	private Object[] tiyatroData = null;
	private JTable table_Cinema;
	private JTable table_Theater;
	private JTable table_Concert;
	private JTextField fld_MovieName;
	private JTextField fld_MovieType;
	private JTextField fld_Admin;
	private JTextField fld_Salon;
	private JTextField fld_SelectSeat;
	private JTextField fld_Seance;
	private JTextField fld_Name;
	private JTextField fld_Surname;
	private JTextField fld_Mail;
	private JTextField fld_Price;
	private JTextField fld_cvc;
	private JTextField fld_CartName;
	private JTextField fld_CartNumber;

	private JTextField fld_OyunAdi;
	private JTextField fld_OyunTuru;
	private JTextField fld_Tarih;
	private JTextField fld_Salon2;
	private JTextField fld_KoltukSec2;
	private JTextField fld_Saat;
	private JTextField fld_Ad2;
	private JTextField fld_Soyad2;
	private JTextField fld_Mail2;
	private JTextField fld_Tutar2;
	private JTextField fld_cvc2;
	private JTextField fld_KartIsim2;
	private JTextField fld_KartNo2;

	private JTextField fld_KonserAdi;
	private JTextField fld_KonserTuru;
	private JTextField fld_Tarih2;
	private JTextField fld_Salon3;
	private JTextField fld_KoltukSec3;
	private JTextField fld_Saat2;
	private JTextField fld_Ad3;
	private JTextField fld_Soyad3;
	private JTextField fld_Mail3;
	private JTextField fld_Tutar3;
	private JTextField fld_cvc3;
	private JTextField fld_KartIsim3;
	private JTextField fld_KartNo3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setResizable(false);

//////////////////////////////////////////////////////////////////////////////////Sinema
		sinemaModel = new DefaultTableModel();
		Object[] colSinema = new Object[5]; // tablo sütunlarýna isim vermek için

		colSinema[0] = "Film Adý";
		colSinema[1] = "Film Türü";
		colSinema[2] = "Yönetmen";
		colSinema[3] = "Salon";
		colSinema[4] = "Seans";

		sinemaModel.setColumnIdentifiers(colSinema);
		sinemaData = new Object[5]; // sqlden veri çekmek için

//////////////////////////////////////////////////////////////////////////////////Tiyatro
		tiyatroModel = new DefaultTableModel();
		Object[] colTiyatro = new Object[5];

		colTiyatro[0] = "Oyun Adý";
		colTiyatro[1] = "Oyun Türü";
		colTiyatro[2] = "Tarih";
		colTiyatro[3] = "Salon";
		colTiyatro[4] = "Saat";
		tiyatroModel.setColumnIdentifiers(colTiyatro);
		tiyatroData = new Object[5]; // sqlden veri çekmek için

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600);
		contentPane = new JPanel();
		contentPane.setBorder(
				new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground")));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Se\u00E7");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBounds(197, 526, 89, 30);
		contentPane.add(btnNewButton);

		JButton btn_Exit = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_Exit.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_Exit.setBounds(861, 11, 89, 23);
		contentPane.add(btn_Exit);

		JLabel lbl_Name = new JLabel("Ho\u015Fgeldiniz Say\u0131n");
		lbl_Name.setBounds(10, 11, 147, 14);
		contentPane.add(lbl_Name);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBounds(0, 36, 488, 486);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sinemalar", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scrollPane_Cinema = new JScrollPane();
		scrollPane_Cinema.setBounds(0, 0, 485, 461);
		w_paneCinema.add(scrollPane_Cinema);
///////////////////////////////////////////////////////////////////////////////////Sinema Sütun Özellikleri
		table_Cinema = new JTable(sinemaModel);
		table_Cinema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Cinema.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Cinema.setViewportView(table_Cinema);
		table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Cinema.getColumnModel().getColumn(0).setResizable(false);

		table_Cinema.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Cinema.getColumnModel().getColumn(1).setResizable(false);
		// table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Cinema.getColumnModel().getColumn(2).setResizable(false);
		table_Cinema.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Cinema.getColumnModel().getColumn(3).setResizable(false);
		table_Cinema.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Cinema.getColumnModel().getColumn(4).setResizable(false);

		/************************* Þimdilik Veri Ekliyorum ***************************/
		sinemaData[0] = "Recep Ývedik 7";
		sinemaData[1] = "Komedi";
		sinemaData[2] = "Þahan Gökbakar";
		sinemaData[3] = 1;
		sinemaData[4] = "13:40";
		sinemaModel.addRow(sinemaData);
		sinemaData[0] = "Hýzlý ve Öfkeli 10";
		sinemaData[1] = "Aksiyon";
		sinemaData[2] = "Rob Cohen";
		sinemaData[3] = 4;
		sinemaData[4] = "16:30";
		sinemaModel.addRow(sinemaData);

		/****************************************************/
		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Tiyatrolar", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scrollPane_Theater = new JScrollPane();
		scrollPane_Theater.setBounds(0, 0, 485, 461);
		w_paneTheater.add(scrollPane_Theater);

///////////////////////////////////////////////////////////////////////////////////Tiyatro Sütun Özellikleri
		table_Theater = new JTable(tiyatroModel);
		table_Theater.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Theater.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Theater.setViewportView(table_Theater);
		table_Theater.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Theater.getColumnModel().getColumn(0).setResizable(false);

		table_Theater.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Theater.getColumnModel().getColumn(1).setResizable(false);
		// table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Theater.getColumnModel().getColumn(2).setResizable(false);
		table_Theater.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Theater.getColumnModel().getColumn(3).setResizable(false);
		table_Theater.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Theater.getColumnModel().getColumn(4).setResizable(false);

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Konserler", null, w_paneConcert, null);

		w_paneConcert.setLayout(null);

		JScrollPane scrollPane_Concert = new JScrollPane();
		scrollPane_Concert.setBounds(0, 0, 485, 461);
		w_paneConcert.add(scrollPane_Concert);

		table_Concert = new JTable();
		scrollPane_Concert.setViewportView(table_Concert);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////// PANESÝNEMA///////////////////////////////////////////////////////////////
		JPanel PaneCinema = new JPanel();
		PaneCinema.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneCinema.setBackground(SystemColor.inactiveCaption);
		PaneCinema.setBounds(486, 57, 489, 504);
		contentPane.add(PaneCinema);
		PaneCinema.setLayout(null);

		JButton btn_BuyTicket = new JButton("Bilet Al");
		btn_BuyTicket.setBounds(195, 468, 102, 30);
		PaneCinema.add(btn_BuyTicket);
		btn_BuyTicket.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster = new JLabel("");
		lbl_Poster.setIcon(new ImageIcon(
				"C:\\Users\\musta\\OneDrive\\Masa\u00FCst\u00FC\\Bilet Sat\u0131\u015F Sistemi\\images\\s.png"));
		lbl_Poster.setBounds(324, 35, 128, 161);
		PaneCinema.add(lbl_Poster);

		JLabel lbl_MovieName = new JLabel("Film Ad\u0131:");
		lbl_MovieName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieName.setBounds(33, 50, 107, 18);
		PaneCinema.add(lbl_MovieName);

		JLabel lbl_MovieType = new JLabel("Film T\u00FCr\u00FC:");
		lbl_MovieType.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieType.setBounds(33, 73, 107, 18);
		PaneCinema.add(lbl_MovieType);

		JLabel lbl_Admin = new JLabel("Y\u00F6netmen:");
		lbl_Admin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Admin.setBounds(33, 96, 107, 18);
		PaneCinema.add(lbl_Admin);

		JLabel lbl_Salon = new JLabel("Salon:");
		lbl_Salon.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon.setBounds(33, 119, 107, 18);
		PaneCinema.add(lbl_Salon);

		JLabel lbl_Seance = new JLabel("Seans:");
		lbl_Seance.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Seance.setBounds(33, 143, 107, 18);
		PaneCinema.add(lbl_Seance);

		JButton btn_SelectSeat = new JButton("Koltuk Se\u00E7");
		btn_SelectSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatSelection ks= new SeatSelection();
				ks.setVisible(true);
			}
		});
		btn_SelectSeat.setBounds(33, 164, 95, 23);
		PaneCinema.add(btn_SelectSeat);

		JLabel lbl_PaymentInformation = new JLabel("\u00D6deme Bilgileri");
		lbl_PaymentInformation.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_PaymentInformation.setBounds(33, 208, 128, 23);
		PaneCinema.add(lbl_PaymentInformation);

		JLabel lblMovieInfo = new JLabel("Film Bilgileri");
		lblMovieInfo.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblMovieInfo.setBounds(33, 20, 128, 23);
		PaneCinema.add(lblMovieInfo);

		JLabel lbl_MovieName_1 = new JLabel("Ad:");
		lbl_MovieName_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieName_1.setBounds(33, 238, 107, 18);
		PaneCinema.add(lbl_MovieName_1);

		JLabel lbl_MovieType_1 = new JLabel("Soyad:");
		lbl_MovieType_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieType_1.setBounds(33, 261, 107, 18);
		PaneCinema.add(lbl_MovieType_1);

		JLabel lbl_Admin_1 = new JLabel("E-Mail:");
		lbl_Admin_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Admin_1.setBounds(33, 284, 107, 18);
		PaneCinema.add(lbl_Admin_1);

		fld_MovieName = new JTextField();
		fld_MovieName.setBackground(Color.WHITE);
		fld_MovieName.setEditable(false);
		fld_MovieName.setBounds(140, 51, 128, 20);
		PaneCinema.add(fld_MovieName);
		fld_MovieName.setColumns(10);

		fld_MovieType = new JTextField();
		fld_MovieType.setBackground(Color.WHITE);
		fld_MovieType.setEditable(false);
		fld_MovieType.setColumns(10);
		fld_MovieType.setBounds(140, 74, 128, 20);
		PaneCinema.add(fld_MovieType);

		fld_Admin = new JTextField();
		fld_Admin.setBackground(Color.WHITE);
		fld_Admin.setEditable(false);
		fld_Admin.setColumns(10);
		fld_Admin.setBounds(140, 97, 128, 20);
		PaneCinema.add(fld_Admin);

		fld_Salon = new JTextField();
		fld_Salon.setBackground(Color.WHITE);
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(140, 120, 42, 20);
		PaneCinema.add(fld_Salon);

		fld_SelectSeat = new JTextField();
		fld_SelectSeat.setBackground(Color.WHITE);
		fld_SelectSeat.setEditable(false);
		fld_SelectSeat.setColumns(10);
		fld_SelectSeat.setBounds(140, 165, 42, 20);
		PaneCinema.add(fld_SelectSeat);

		fld_Seance = new JTextField();
		fld_Seance.setBackground(Color.WHITE);
		fld_Seance.setEditable(false);
		fld_Seance.setColumns(10);
		fld_Seance.setBounds(140, 143, 42, 20);
		PaneCinema.add(fld_Seance);

		JLabel lbl_PaymentMethod = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_PaymentMethod.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_PaymentMethod.setBounds(33, 307, 128, 18);
		PaneCinema.add(lbl_PaymentMethod);

		JComboBox comboBox_Yontem = new JComboBox();
		comboBox_Yontem.setBounds(33, 326, 110, 22);
		comboBox_Yontem.addItem("Nakit ödeme");
		comboBox_Yontem.addItem("Kart ile ödeme");
		PaneCinema.add(comboBox_Yontem);

		JPanel w_pane_Kart = new JPanel();
		w_pane_Kart.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart.setBounds(33, 359, 452, 98);
		PaneCinema.add(w_pane_Kart);
		w_pane_Kart.setLayout(null);
		w_pane_Kart.setVisible(false);
		comboBox_Yontem.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Yontem.getSelectedIndex() == 0) {
					w_pane_Kart.setVisible(false);

				} else {
					w_pane_Kart.setVisible(true);
				}
			}
		});

		fld_Name = new JTextField();
		fld_Name.setEditable(false);
		fld_Name.setColumns(10);
		fld_Name.setBackground(Color.WHITE);
		fld_Name.setBounds(140, 238, 128, 20);
		PaneCinema.add(fld_Name);

		fld_Surname = new JTextField();
		fld_Surname.setEditable(false);
		fld_Surname.setColumns(10);
		fld_Surname.setBackground(Color.WHITE);
		fld_Surname.setBounds(140, 261, 128, 20);
		PaneCinema.add(fld_Surname);

		fld_Mail = new JTextField();
		fld_Mail.setEditable(false);
		fld_Mail.setColumns(10);
		fld_Mail.setBackground(Color.WHITE);
		fld_Mail.setBounds(140, 284, 128, 20);
		PaneCinema.add(fld_Mail);

		JLabel lbl_Price = new JLabel("Toplam Tutar");
		lbl_Price.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Price.setBounds(322, 207, 154, 47);
		PaneCinema.add(lbl_Price);

		fld_Price = new JTextField();
		fld_Price.setBackground(Color.WHITE);
		fld_Price.setEditable(false);
		fld_Price.setBounds(322, 247, 130, 55);
		PaneCinema.add(fld_Price);
		fld_Price.setColumns(10);

		JLabel lbl_CartName = new JLabel("Kart \u00FCzerindeki \u0130sim:");
		lbl_CartName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartName.setBounds(10, 11, 123, 14);
		w_pane_Kart.add(lbl_CartName);

		JLabel lbl_CartNumber = new JLabel("Kart Numaras\u0131:");
		lbl_CartNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartNumber.setBounds(10, 34, 123, 14);
		w_pane_Kart.add(lbl_CartNumber);

		JLabel lbl_LastUsageDate = new JLabel("Son Kullan\u0131m Tarihi:");
		lbl_LastUsageDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_LastUsageDate.setBounds(10, 56, 123, 14);
		w_pane_Kart.add(lbl_LastUsageDate);

		JComboBox comboBox_Ay = new JComboBox();
		comboBox_Ay.setBounds(143, 53, 60, 22);
		w_pane_Kart.add(comboBox_Ay);

		JComboBox comboBox_Yil = new JComboBox();
		comboBox_Yil.setBounds(210, 53, 72, 22);
		w_pane_Kart.add(comboBox_Yil);

		JLabel lbl_Cvc = new JLabel("CVC:");
		lbl_Cvc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Cvc.setBounds(317, 56, 46, 14);
		w_pane_Kart.add(lbl_Cvc);

		fld_cvc = new JTextField();
		fld_cvc.setBounds(356, 54, 46, 20);
		w_pane_Kart.add(fld_cvc);
		fld_cvc.setColumns(10);

		fld_CartName = new JTextField();
		fld_CartName.setColumns(10);
		fld_CartName.setBackground(Color.WHITE);
		fld_CartName.setBounds(143, 9, 139, 20);
		w_pane_Kart.add(fld_CartName);

		fld_CartNumber = new JTextField();
		fld_CartNumber.setColumns(10);
		fld_CartNumber.setBackground(Color.WHITE);
		fld_CartNumber.setBounds(143, 31, 139, 20);
		w_pane_Kart.add(fld_CartNumber);

		JButton btn_CancelTicket = new JButton("Bilet \u0130ptal");
		btn_CancelTicket.setForeground(SystemColor.menu);
		btn_CancelTicket.setBackground(SystemColor.textHighlight);
		btn_CancelTicket.setBounds(317, 464, 92, 35);
		PaneCinema.add(btn_CancelTicket);
		btn_CancelTicket.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));

		JButton btn_MyTickets = new JButton("Biletlerim");
		btn_MyTickets.setForeground(SystemColor.menu);
		btn_MyTickets.setBackground(SystemColor.textHighlight);
		btn_MyTickets.setBounds(82, 464, 92, 35);
		PaneCinema.add(btn_MyTickets);
		btn_MyTickets.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		///////////////////////////////////////////////// PANESÝNEMA/////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////// PANETÝYATRO///////////////////////////////////////////////////////////////
		JPanel PaneTheater = new JPanel();
		PaneTheater.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneTheater.setBackground(SystemColor.inactiveCaption);
		PaneTheater.setBounds(486, 57, 489, 504);
		contentPane.add(PaneTheater);
		PaneTheater.setLayout(null);

		JButton btn_BiletAl2 = new JButton("Bilet Al");
		btn_BiletAl2.setBounds(195, 468, 102, 30);
		PaneTheater.add(btn_BiletAl2);
		btn_BiletAl2.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster2 = new JLabel("");
		lbl_Poster2.setIcon(new ImageIcon(
				"C:\\Users\\musta\\OneDrive\\Masa\u00FCst\u00FC\\Bilet Sat\u0131\u015F Sistemi\\images\\s.png"));
		lbl_Poster2.setBounds(324, 35, 128, 161);
		PaneTheater.add(lbl_Poster2);

		JLabel lbl_OyunAdi = new JLabel("Oyun Adý:");
		lbl_OyunAdi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunAdi.setBounds(33, 50, 107, 18);
		PaneTheater.add(lbl_OyunAdi);

		JLabel lbl_OyunTuru = new JLabel("Oyun Türü:");
		lbl_OyunTuru.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunTuru.setBounds(33, 73, 107, 18);
		PaneTheater.add(lbl_OyunTuru);

		JLabel lbl_Tarih = new JLabel("Tarih:");
		lbl_Tarih.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih.setBounds(33, 96, 107, 18);
		PaneTheater.add(lbl_Tarih);

		JLabel lbl_Salon2 = new JLabel("Salon:");
		lbl_Salon2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon2.setBounds(33, 119, 107, 18);
		PaneTheater.add(lbl_Salon2);

		JLabel lbl_Saat = new JLabel("Saat:");
		lbl_Saat.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Saat.setBounds(33, 143, 107, 18);
		PaneTheater.add(lbl_Saat);

		JButton btn_KoltukSec2 = new JButton("Koltuk Seç");
		btn_KoltukSec2.setBounds(33, 164, 95, 23);
		PaneTheater.add(btn_KoltukSec2);

		JLabel lbl_OdemeBilgileri2 = new JLabel("Ödeme Bilgileri");
		lbl_OdemeBilgileri2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_OdemeBilgileri2.setBounds(33, 208, 128, 23);
		PaneTheater.add(lbl_OdemeBilgileri2);

		JLabel lblTiyatroBilgileri = new JLabel("Tiyatro Bilgileri");
		lblTiyatroBilgileri.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblTiyatroBilgileri.setBounds(33, 20, 144, 23);
		PaneTheater.add(lblTiyatroBilgileri);

		JLabel lbl_OyunAdi_2 = new JLabel("Ad:");
		lbl_OyunAdi_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunAdi_2.setBounds(33, 238, 107, 18);
		PaneTheater.add(lbl_OyunAdi_2);

		JLabel lbl_OyunTuru_2 = new JLabel("Soyad:");
		lbl_OyunTuru_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunTuru_2.setBounds(33, 261, 107, 18);
		PaneTheater.add(lbl_OyunTuru_2);

		JLabel lbl_Tarih_2 = new JLabel("E-Mail:");
		lbl_Tarih_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih_2.setBounds(33, 284, 107, 18);
		PaneTheater.add(lbl_Tarih_2);

		fld_OyunAdi = new JTextField();
		fld_OyunAdi.setBackground(Color.WHITE);
		fld_OyunAdi.setEditable(false);
		fld_OyunAdi.setBounds(140, 51, 128, 20);
		PaneTheater.add(fld_OyunAdi);
		fld_OyunAdi.setColumns(10);

		fld_OyunTuru = new JTextField();
		fld_OyunTuru.setBackground(Color.WHITE);
		fld_OyunTuru.setEditable(false);
		fld_OyunTuru.setColumns(10);
		fld_OyunTuru.setBounds(140, 74, 128, 20);
		PaneTheater.add(fld_OyunTuru);

		fld_Tarih = new JTextField();
		fld_Tarih.setBackground(Color.WHITE);
		fld_Tarih.setEditable(false);
		fld_Tarih.setColumns(10);
		fld_Tarih.setBounds(140, 97, 128, 20);
		PaneTheater.add(fld_Tarih);

		fld_Salon2 = new JTextField();
		fld_Salon2.setBackground(Color.WHITE);
		fld_Salon2.setEditable(false);
		fld_Salon2.setColumns(10);
		fld_Salon2.setBounds(140, 120, 42, 20);
		PaneTheater.add(fld_Salon2);

		fld_KoltukSec2 = new JTextField();
		fld_KoltukSec2.setBackground(Color.WHITE);
		fld_KoltukSec2.setEditable(false);
		fld_KoltukSec2.setColumns(10);
		fld_KoltukSec2.setBounds(140, 165, 42, 20);
		PaneTheater.add(fld_KoltukSec2);

		fld_Saat = new JTextField();
		fld_Saat.setBackground(Color.WHITE);
		fld_Saat.setEditable(false);
		fld_Saat.setColumns(10);
		fld_Saat.setBounds(140, 143, 42, 20);
		PaneTheater.add(fld_Saat);

		JLabel lbl_OdemeYontemi2 = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_OdemeYontemi2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OdemeYontemi2.setBounds(33, 307, 128, 18);
		PaneTheater.add(lbl_OdemeYontemi2);

		JComboBox comboBox_Yontem2 = new JComboBox();
		comboBox_Yontem2.setBounds(33, 326, 110, 22);
		comboBox_Yontem2.addItem("Nakit ödeme");
		comboBox_Yontem2.addItem("Kart ile ödeme");
		PaneTheater.add(comboBox_Yontem2);

		JPanel w_pane_Kart2 = new JPanel();
		w_pane_Kart2.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart2.setBounds(33, 359, 452, 98);
		PaneTheater.add(w_pane_Kart2);
		w_pane_Kart2.setLayout(null);
		w_pane_Kart2.setVisible(false);
		comboBox_Yontem2.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Yontem2.getSelectedIndex() == 0) {
					w_pane_Kart2.setVisible(false);

				} else {
					w_pane_Kart2.setVisible(true);
				}
			}
		});

		fld_Ad2 = new JTextField();
		fld_Ad2.setEditable(false);
		fld_Ad2.setColumns(10);
		fld_Ad2.setBackground(Color.WHITE);
		fld_Ad2.setBounds(140, 238, 128, 20);
		PaneTheater.add(fld_Ad2);

		fld_Soyad2 = new JTextField();
		fld_Soyad2.setEditable(false);
		fld_Soyad2.setColumns(10);
		fld_Soyad2.setBackground(Color.WHITE);
		fld_Soyad2.setBounds(140, 261, 128, 20);
		PaneTheater.add(fld_Soyad2);

		fld_Mail2 = new JTextField();
		fld_Mail2.setEditable(false);
		fld_Mail2.setColumns(10);
		fld_Mail2.setBackground(Color.WHITE);
		fld_Mail2.setBounds(140, 284, 128, 20);
		PaneTheater.add(fld_Mail2);

		JLabel lbl_Tutar2 = new JLabel("Toplam Tutar");
		lbl_Tutar2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Tutar2.setBounds(322, 207, 154, 47);
		PaneTheater.add(lbl_Tutar2);

		fld_Tutar2 = new JTextField();
		fld_Tutar2.setBackground(Color.WHITE);
		fld_Tutar2.setEditable(false);
		fld_Tutar2.setBounds(322, 247, 130, 55);
		PaneTheater.add(fld_Tutar2);
		fld_Tutar2.setColumns(10);

		JLabel lbl_KartIsim2 = new JLabel("Kart \u00FCzerindeki \u0130sim:");
		lbl_KartIsim2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KartIsim2.setBounds(10, 11, 123, 14);
		w_pane_Kart2.add(lbl_KartIsim2);

		JLabel lbl_KartNumarasi2 = new JLabel("Kart Numaras\u0131:");
		lbl_KartNumarasi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KartNumarasi2.setBounds(10, 34, 123, 14);
		w_pane_Kart2.add(lbl_KartNumarasi2);

		JLabel lbl_SonKullanmTarihi2 = new JLabel("Son Kullan\u0131m Tarihi:");
		lbl_SonKullanmTarihi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SonKullanmTarihi2.setBounds(10, 56, 123, 14);
		w_pane_Kart2.add(lbl_SonKullanmTarihi2);

		JComboBox comboBox_Ay2 = new JComboBox();
		comboBox_Ay2.setBounds(143, 53, 60, 22);
		w_pane_Kart2.add(comboBox_Ay2);

		JComboBox comboBox_Yil2 = new JComboBox();
		comboBox_Yil2.setBounds(210, 53, 72, 22);
		w_pane_Kart2.add(comboBox_Yil2);

		JLabel lbl_Cvc2 = new JLabel("CVC:");
		lbl_Cvc2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Cvc2.setBounds(317, 56, 46, 14);
		w_pane_Kart2.add(lbl_Cvc2);

		fld_cvc2 = new JTextField();
		fld_cvc2.setBounds(356, 54, 46, 20);
		w_pane_Kart2.add(fld_cvc2);
		fld_cvc2.setColumns(10);

		fld_KartIsim2 = new JTextField();
		fld_KartIsim2.setColumns(10);
		fld_KartIsim2.setBackground(Color.WHITE);
		fld_KartIsim2.setBounds(143, 9, 139, 20);
		w_pane_Kart2.add(fld_KartIsim2);

		fld_KartNo2 = new JTextField();
		fld_KartNo2.setColumns(10);
		fld_KartNo2.setBackground(Color.WHITE);
		fld_KartNo2.setBounds(143, 31, 139, 20);
		w_pane_Kart2.add(fld_KartNo2);

		JButton btn_Biletlerim_1 = new JButton("Biletlerim");
		btn_Biletlerim_1.setForeground(SystemColor.menu);
		btn_Biletlerim_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_Biletlerim_1.setBackground(SystemColor.textHighlight);
		btn_Biletlerim_1.setBounds(82, 464, 92, 35);
		PaneTheater.add(btn_Biletlerim_1);

		JButton btn_BiletIptal_1 = new JButton("Bilet \u0130ptal");
		btn_BiletIptal_1.setForeground(SystemColor.menu);
		btn_BiletIptal_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_BiletIptal_1.setBackground(SystemColor.textHighlight);
		btn_BiletIptal_1.setBounds(317, 464, 92, 35);
		PaneTheater.add(btn_BiletIptal_1);
		PaneTheater.setVisible(false);
		///////////////////////////////////////////////////// PANETÝYATRO////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////// PANEKONSERs///////////////////////////////////////////////////////////////
		JPanel PaneConcert = new JPanel();
		PaneConcert.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneConcert.setBackground(SystemColor.inactiveCaption);
		PaneConcert.setBounds(486, 57, 489, 504);
		contentPane.add(PaneConcert);
		PaneConcert.setLayout(null);

		JButton btn_BiletAl3 = new JButton("Bilet Al");
		btn_BiletAl3.setBounds(195, 468, 102, 30);
		PaneConcert.add(btn_BiletAl3);
		btn_BiletAl3.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster3 = new JLabel("");
		lbl_Poster3.setIcon(new ImageIcon(
				"C:\\Users\\musta\\OneDrive\\Masa\u00FCst\u00FC\\Bilet Sat\u0131\u015F Sistemi\\images\\s.png"));
		lbl_Poster3.setBounds(324, 35, 128, 161);
		PaneConcert.add(lbl_Poster3);

		JLabel lbl_KonserAdi = new JLabel("Konser Adý:");
		lbl_KonserAdi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserAdi.setBounds(33, 50, 107, 18);
		PaneConcert.add(lbl_KonserAdi);

		JLabel lbl_KonserTuru = new JLabel("Konser Türü:");
		lbl_KonserTuru.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserTuru.setBounds(33, 73, 107, 18);
		PaneConcert.add(lbl_KonserTuru);

		JLabel lbl_Tarih2 = new JLabel("Tarih:");
		lbl_Tarih2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih2.setBounds(33, 96, 107, 18);
		PaneConcert.add(lbl_Tarih2);

		JLabel lbl_Salon3 = new JLabel("Salon:");
		lbl_Salon3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon3.setBounds(33, 119, 107, 18);
		PaneConcert.add(lbl_Salon3);

		JLabel lbl_Saat2 = new JLabel("Saat:");
		lbl_Saat2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Saat2.setBounds(33, 143, 107, 18);
		PaneConcert.add(lbl_Saat2);

		JButton btn_KoltukSec3 = new JButton("Koltuk Seç");
		btn_KoltukSec3.setBounds(33, 164, 95, 23);
		PaneConcert.add(btn_KoltukSec3);

		JLabel lbl_OdemeBilgileri3 = new JLabel("Ödeme Bilgileri");
		lbl_OdemeBilgileri3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_OdemeBilgileri3.setBounds(33, 208, 128, 23);
		PaneConcert.add(lbl_OdemeBilgileri3);

		JLabel lblKonserBilgileri = new JLabel("Konser Bilgileri");
		lblKonserBilgileri.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblKonserBilgileri.setBounds(33, 20, 144, 23);
		PaneConcert.add(lblKonserBilgileri);

		JLabel lbl_KonserAdi_2 = new JLabel("Ad:");
		lbl_KonserAdi_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserAdi_2.setBounds(33, 238, 107, 18);
		PaneConcert.add(lbl_KonserAdi_2);

		JLabel lbl_KonserTuru_2 = new JLabel("Soyad:");
		lbl_KonserTuru_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserTuru_2.setBounds(33, 261, 107, 18);
		PaneConcert.add(lbl_KonserTuru_2);

		JLabel lbl_Tarih_3 = new JLabel("E-Mail:");
		lbl_Tarih_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih_3.setBounds(33, 284, 107, 18);
		PaneConcert.add(lbl_Tarih_3);

		fld_KonserAdi = new JTextField();
		fld_KonserAdi.setBackground(Color.WHITE);
		fld_KonserAdi.setEditable(false);
		fld_KonserAdi.setBounds(140, 51, 128, 20);
		PaneConcert.add(fld_KonserAdi);
		fld_KonserAdi.setColumns(10);

		fld_KonserTuru = new JTextField();
		fld_KonserTuru.setBackground(Color.WHITE);
		fld_KonserTuru.setEditable(false);
		fld_KonserTuru.setColumns(10);
		fld_KonserTuru.setBounds(140, 74, 128, 20);
		PaneConcert.add(fld_KonserTuru);

		fld_Tarih2 = new JTextField();
		fld_Tarih2.setBackground(Color.WHITE);
		fld_Tarih2.setEditable(false);
		fld_Tarih2.setColumns(10);
		fld_Tarih2.setBounds(140, 97, 128, 20);
		PaneConcert.add(fld_Tarih2);

		fld_Salon3 = new JTextField();
		fld_Salon3.setBackground(Color.WHITE);
		fld_Salon3.setEditable(false);
		fld_Salon3.setColumns(10);
		fld_Salon3.setBounds(140, 120, 42, 20);
		PaneConcert.add(fld_Salon3);

		fld_KoltukSec3 = new JTextField();
		fld_KoltukSec3.setBackground(Color.WHITE);
		fld_KoltukSec3.setEditable(false);
		fld_KoltukSec3.setColumns(10);
		fld_KoltukSec3.setBounds(140, 165, 42, 20);
		PaneConcert.add(fld_KoltukSec3);

		fld_Saat2 = new JTextField();
		fld_Saat2.setBackground(Color.WHITE);
		fld_Saat2.setEditable(false);
		fld_Saat2.setColumns(10);
		fld_Saat2.setBounds(140, 143, 42, 20);
		PaneConcert.add(fld_Saat2);

		JLabel lbl_OdemeYontemi3 = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_OdemeYontemi3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OdemeYontemi3.setBounds(33, 307, 128, 18);
		PaneConcert.add(lbl_OdemeYontemi3);

		JComboBox comboBox_Yontem3 = new JComboBox();
		comboBox_Yontem3.setBounds(33, 326, 110, 22);
		comboBox_Yontem3.addItem("Nakit ödeme");
		comboBox_Yontem3.addItem("Kart ile ödeme");
		PaneConcert.add(comboBox_Yontem3);

		JPanel w_pane_Kart3 = new JPanel();
		w_pane_Kart3.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart3.setBounds(33, 359, 452, 98);
		PaneConcert.add(w_pane_Kart3);
		w_pane_Kart3.setLayout(null);
		w_pane_Kart3.setVisible(false);
		comboBox_Yontem3.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Yontem3.getSelectedIndex() == 0) {
					w_pane_Kart3.setVisible(false);

				} else {
					w_pane_Kart3.setVisible(true);
				}
			}
		});

		fld_Ad3 = new JTextField();
		fld_Ad3.setEditable(false);
		fld_Ad3.setColumns(10);
		fld_Ad3.setBackground(Color.WHITE);
		fld_Ad3.setBounds(140, 238, 128, 20);
		PaneConcert.add(fld_Ad3);

		fld_Soyad3 = new JTextField();
		fld_Soyad3.setEditable(false);
		fld_Soyad3.setColumns(10);
		fld_Soyad3.setBackground(Color.WHITE);
		fld_Soyad3.setBounds(140, 261, 128, 20);
		PaneConcert.add(fld_Soyad3);

		fld_Mail3 = new JTextField();
		fld_Mail3.setEditable(false);
		fld_Mail3.setColumns(10);
		fld_Mail3.setBackground(Color.WHITE);
		fld_Mail3.setBounds(140, 284, 128, 20);
		PaneConcert.add(fld_Mail3);

		JLabel lbl_Tutar3 = new JLabel("Toplam Tutar");
		lbl_Tutar3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Tutar3.setBounds(322, 207, 154, 47);
		PaneConcert.add(lbl_Tutar3);

		fld_Tutar3 = new JTextField();
		fld_Tutar3.setBackground(Color.WHITE);
		fld_Tutar3.setEditable(false);
		fld_Tutar3.setBounds(322, 247, 130, 55);
		PaneConcert.add(fld_Tutar3);
		fld_Tutar3.setColumns(10);

		JLabel lbl_KartIsim3 = new JLabel("Kart \u00FCzerindeki \u0130sim:");
		lbl_KartIsim3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KartIsim3.setBounds(10, 11, 123, 14);
		w_pane_Kart3.add(lbl_KartIsim3);

		JLabel lbl_KartNumarasi3 = new JLabel("Kart Numaras\u0131:");
		lbl_KartNumarasi3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KartNumarasi3.setBounds(10, 34, 123, 14);
		w_pane_Kart3.add(lbl_KartNumarasi3);

		JLabel lbl_SonKullanmTarihi3 = new JLabel("Son Kullan\u0131m Tarihi:");
		lbl_SonKullanmTarihi3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SonKullanmTarihi3.setBounds(10, 56, 123, 14);
		w_pane_Kart3.add(lbl_SonKullanmTarihi3);

		JComboBox comboBox_Ay3 = new JComboBox();
		comboBox_Ay3.setBounds(143, 53, 60, 22);
		w_pane_Kart3.add(comboBox_Ay3);

		JComboBox comboBox_Yil3 = new JComboBox();
		comboBox_Yil3.setBounds(210, 53, 72, 22);
		w_pane_Kart3.add(comboBox_Yil3);

		JLabel lbl_Cvc3 = new JLabel("CVC:");
		lbl_Cvc3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Cvc3.setBounds(317, 56, 46, 14);
		w_pane_Kart3.add(lbl_Cvc3);

		fld_cvc3 = new JTextField();
		fld_cvc3.setBounds(356, 54, 46, 20);
		w_pane_Kart3.add(fld_cvc3);
		fld_cvc3.setColumns(10);

		fld_KartIsim3 = new JTextField();
		fld_KartIsim3.setColumns(10);
		fld_KartIsim3.setBackground(Color.WHITE);
		fld_KartIsim3.setBounds(143, 9, 139, 20);
		w_pane_Kart3.add(fld_KartIsim3);

		fld_KartNo3 = new JTextField();
		fld_KartNo3.setColumns(10);
		fld_KartNo3.setBackground(Color.WHITE);
		fld_KartNo3.setBounds(143, 31, 139, 20);
		w_pane_Kart3.add(fld_KartNo3);

		JButton btn_Biletlerim_1_1 = new JButton("Biletlerim");
		btn_Biletlerim_1_1.setForeground(SystemColor.menu);
		btn_Biletlerim_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_Biletlerim_1_1.setBackground(SystemColor.textHighlight);
		btn_Biletlerim_1_1.setBounds(82, 464, 92, 35);
		PaneConcert.add(btn_Biletlerim_1_1);

		JButton btn_BiletIptal_1_1 = new JButton("Bilet \u0130ptal");
		btn_BiletIptal_1_1.setForeground(SystemColor.menu);
		btn_BiletIptal_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_BiletIptal_1_1.setBackground(SystemColor.textHighlight);
		btn_BiletIptal_1_1.setBounds(317, 464, 92, 35);
		PaneConcert.add(btn_BiletIptal_1_1);
		PaneConcert.setVisible(false);
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