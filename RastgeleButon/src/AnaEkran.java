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

public class AnaEkran extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel sinemaModel; // tablo sütunlarýný isimlendirmek için
	private DefaultTableModel tiyatroModel;
	private Object[] sinemaData = null; // sqlden veri çekmek için
	private Object[] tiyatroData = null;
	private JTable table_Sinema;
	private JTable table_Tiyatro;
	private JTable table_Konser;
	private JTextField fld_FilmAdi;
	private JTextField fld_FilmTuru;
	private JTextField fld_Yonetmen;
	private JTextField fld_Salon;
	private JTextField fld_KoltukSec;
	private JTextField fld_Seans;
	private JTextField fld_Ad;
	private JTextField fld_Soyad;
	private JTextField fld_Mail;
	private JTextField fld_Tutar;
	private JTextField fld_cvc;
	private JTextField fld_KartIsim;
	private JTextField fld_KartNo;

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
					AnaEkran frame = new AnaEkran();
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
	public AnaEkran() {
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

		JButton btn_cikisYap = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_cikisYap.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btn_cikisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_cikisYap.setBounds(861, 11, 89, 23);
		contentPane.add(btn_cikisYap);

		JLabel lbl_Sayin = new JLabel("Ho\u015Fgeldiniz Say\u0131n");
		lbl_Sayin.setBounds(10, 11, 147, 14);
		contentPane.add(lbl_Sayin);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBounds(0, 36, 488, 486);
		contentPane.add(tabbedPane);

		JPanel w_paneSinema = new JPanel();
		w_paneSinema.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sinemalar", null, w_paneSinema, null);
		w_paneSinema.setLayout(null);

		JScrollPane scrollPane_Sinema = new JScrollPane();
		scrollPane_Sinema.setBounds(0, 0, 485, 461);
		w_paneSinema.add(scrollPane_Sinema);
///////////////////////////////////////////////////////////////////////////////////Sinema Sütun Özellikleri
		table_Sinema = new JTable(sinemaModel);
		table_Sinema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Sinema.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Sinema.setViewportView(table_Sinema);
		table_Sinema.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Sinema.getColumnModel().getColumn(0).setResizable(false);

		table_Sinema.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Sinema.getColumnModel().getColumn(1).setResizable(false);
		// table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Sinema.getColumnModel().getColumn(2).setResizable(false);
		table_Sinema.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Sinema.getColumnModel().getColumn(3).setResizable(false);
		table_Sinema.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Sinema.getColumnModel().getColumn(4).setResizable(false);

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
		JPanel w_paneTiyatro = new JPanel();
		w_paneTiyatro.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Tiyatrolar", null, w_paneTiyatro, null);
		w_paneTiyatro.setLayout(null);

		JScrollPane scrollPane_Tiyatro = new JScrollPane();
		scrollPane_Tiyatro.setBounds(0, 0, 485, 461);
		w_paneTiyatro.add(scrollPane_Tiyatro);

///////////////////////////////////////////////////////////////////////////////////Tiyatro Sütun Özellikleri
		table_Tiyatro = new JTable(tiyatroModel);
		table_Tiyatro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Tiyatro.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Tiyatro.setViewportView(table_Tiyatro);
		table_Tiyatro.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Tiyatro.getColumnModel().getColumn(0).setResizable(false);

		table_Tiyatro.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Tiyatro.getColumnModel().getColumn(1).setResizable(false);
		// table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Tiyatro.getColumnModel().getColumn(2).setResizable(false);
		table_Tiyatro.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Tiyatro.getColumnModel().getColumn(3).setResizable(false);
		table_Tiyatro.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Tiyatro.getColumnModel().getColumn(4).setResizable(false);

		JPanel w_paneKonser = new JPanel();
		w_paneKonser.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Konserler", null, w_paneKonser, null);

		w_paneKonser.setLayout(null);

		JScrollPane scrollPane_Konser = new JScrollPane();
		scrollPane_Konser.setBounds(0, 0, 485, 461);
		w_paneKonser.add(scrollPane_Konser);

		table_Konser = new JTable();
		scrollPane_Konser.setViewportView(table_Konser);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////// PANESÝNEMA///////////////////////////////////////////////////////////////
		JPanel PaneSinema = new JPanel();
		PaneSinema.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneSinema.setBackground(SystemColor.inactiveCaption);
		PaneSinema.setBounds(486, 57, 489, 504);
		contentPane.add(PaneSinema);
		PaneSinema.setLayout(null);

		JButton btn_BiletAl = new JButton("Bilet Al");
		btn_BiletAl.setBounds(195, 468, 102, 30);
		PaneSinema.add(btn_BiletAl);
		btn_BiletAl.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster = new JLabel("");
		lbl_Poster.setIcon(new ImageIcon(
				"C:\\Users\\musta\\OneDrive\\Masa\u00FCst\u00FC\\Bilet Sat\u0131\u015F Sistemi\\images\\s.png"));
		lbl_Poster.setBounds(324, 35, 128, 161);
		PaneSinema.add(lbl_Poster);

		JLabel lbl_FilmAdi = new JLabel("Film Ad\u0131:");
		lbl_FilmAdi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_FilmAdi.setBounds(33, 50, 107, 18);
		PaneSinema.add(lbl_FilmAdi);

		JLabel lbl_FilmTuru = new JLabel("Film T\u00FCr\u00FC:");
		lbl_FilmTuru.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_FilmTuru.setBounds(33, 73, 107, 18);
		PaneSinema.add(lbl_FilmTuru);

		JLabel lbl_Yonetmen = new JLabel("Y\u00F6netmen:");
		lbl_Yonetmen.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Yonetmen.setBounds(33, 96, 107, 18);
		PaneSinema.add(lbl_Yonetmen);

		JLabel lbl_Salon = new JLabel("Salon:");
		lbl_Salon.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon.setBounds(33, 119, 107, 18);
		PaneSinema.add(lbl_Salon);

		JLabel lbl_Seans = new JLabel("Seans:");
		lbl_Seans.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Seans.setBounds(33, 143, 107, 18);
		PaneSinema.add(lbl_Seans);

		JButton btn_KoltukSec = new JButton("Koltuk Se\u00E7");
		btn_KoltukSec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KoltukSecim ks= new KoltukSecim();
				ks.setVisible(true);
			}
		});
		btn_KoltukSec.setBounds(33, 164, 95, 23);
		PaneSinema.add(btn_KoltukSec);

		JLabel lbl_OdemeBilgileri = new JLabel("\u00D6deme Bilgileri");
		lbl_OdemeBilgileri.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_OdemeBilgileri.setBounds(33, 208, 128, 23);
		PaneSinema.add(lbl_OdemeBilgileri);

		JLabel lblFilmBilgileri = new JLabel("Film Bilgileri");
		lblFilmBilgileri.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblFilmBilgileri.setBounds(33, 20, 128, 23);
		PaneSinema.add(lblFilmBilgileri);

		JLabel lbl_FilmAdi_1 = new JLabel("Ad:");
		lbl_FilmAdi_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_FilmAdi_1.setBounds(33, 238, 107, 18);
		PaneSinema.add(lbl_FilmAdi_1);

		JLabel lbl_FilmTuru_1 = new JLabel("Soyad:");
		lbl_FilmTuru_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_FilmTuru_1.setBounds(33, 261, 107, 18);
		PaneSinema.add(lbl_FilmTuru_1);

		JLabel lbl_Yonetmen_1 = new JLabel("E-Mail:");
		lbl_Yonetmen_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Yonetmen_1.setBounds(33, 284, 107, 18);
		PaneSinema.add(lbl_Yonetmen_1);

		fld_FilmAdi = new JTextField();
		fld_FilmAdi.setBackground(Color.WHITE);
		fld_FilmAdi.setEditable(false);
		fld_FilmAdi.setBounds(140, 51, 128, 20);
		PaneSinema.add(fld_FilmAdi);
		fld_FilmAdi.setColumns(10);

		fld_FilmTuru = new JTextField();
		fld_FilmTuru.setBackground(Color.WHITE);
		fld_FilmTuru.setEditable(false);
		fld_FilmTuru.setColumns(10);
		fld_FilmTuru.setBounds(140, 74, 128, 20);
		PaneSinema.add(fld_FilmTuru);

		fld_Yonetmen = new JTextField();
		fld_Yonetmen.setBackground(Color.WHITE);
		fld_Yonetmen.setEditable(false);
		fld_Yonetmen.setColumns(10);
		fld_Yonetmen.setBounds(140, 97, 128, 20);
		PaneSinema.add(fld_Yonetmen);

		fld_Salon = new JTextField();
		fld_Salon.setBackground(Color.WHITE);
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(140, 120, 42, 20);
		PaneSinema.add(fld_Salon);

		fld_KoltukSec = new JTextField();
		fld_KoltukSec.setBackground(Color.WHITE);
		fld_KoltukSec.setEditable(false);
		fld_KoltukSec.setColumns(10);
		fld_KoltukSec.setBounds(140, 165, 42, 20);
		PaneSinema.add(fld_KoltukSec);

		fld_Seans = new JTextField();
		fld_Seans.setBackground(Color.WHITE);
		fld_Seans.setEditable(false);
		fld_Seans.setColumns(10);
		fld_Seans.setBounds(140, 143, 42, 20);
		PaneSinema.add(fld_Seans);

		JLabel lbl_OdemeYontemi = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_OdemeYontemi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OdemeYontemi.setBounds(33, 307, 128, 18);
		PaneSinema.add(lbl_OdemeYontemi);

		JComboBox comboBox_Yontem = new JComboBox();
		comboBox_Yontem.setBounds(33, 326, 110, 22);
		comboBox_Yontem.addItem("Nakit ödeme");
		comboBox_Yontem.addItem("Kart ile ödeme");
		PaneSinema.add(comboBox_Yontem);

		JPanel w_pane_Kart = new JPanel();
		w_pane_Kart.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart.setBounds(33, 359, 452, 98);
		PaneSinema.add(w_pane_Kart);
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

		fld_Ad = new JTextField();
		fld_Ad.setEditable(false);
		fld_Ad.setColumns(10);
		fld_Ad.setBackground(Color.WHITE);
		fld_Ad.setBounds(140, 238, 128, 20);
		PaneSinema.add(fld_Ad);

		fld_Soyad = new JTextField();
		fld_Soyad.setEditable(false);
		fld_Soyad.setColumns(10);
		fld_Soyad.setBackground(Color.WHITE);
		fld_Soyad.setBounds(140, 261, 128, 20);
		PaneSinema.add(fld_Soyad);

		fld_Mail = new JTextField();
		fld_Mail.setEditable(false);
		fld_Mail.setColumns(10);
		fld_Mail.setBackground(Color.WHITE);
		fld_Mail.setBounds(140, 284, 128, 20);
		PaneSinema.add(fld_Mail);

		JLabel lbl_Tutar = new JLabel("Toplam Tutar");
		lbl_Tutar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Tutar.setBounds(322, 207, 154, 47);
		PaneSinema.add(lbl_Tutar);

		fld_Tutar = new JTextField();
		fld_Tutar.setBackground(Color.WHITE);
		fld_Tutar.setEditable(false);
		fld_Tutar.setBounds(322, 247, 130, 55);
		PaneSinema.add(fld_Tutar);
		fld_Tutar.setColumns(10);

		JLabel lbl_KartIsim = new JLabel("Kart \u00FCzerindeki \u0130sim:");
		lbl_KartIsim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KartIsim.setBounds(10, 11, 123, 14);
		w_pane_Kart.add(lbl_KartIsim);

		JLabel lbl_KartNumarasi = new JLabel("Kart Numaras\u0131:");
		lbl_KartNumarasi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_KartNumarasi.setBounds(10, 34, 123, 14);
		w_pane_Kart.add(lbl_KartNumarasi);

		JLabel lbl_SonKullanmTarihi = new JLabel("Son Kullan\u0131m Tarihi:");
		lbl_SonKullanmTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_SonKullanmTarihi.setBounds(10, 56, 123, 14);
		w_pane_Kart.add(lbl_SonKullanmTarihi);

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

		fld_KartIsim = new JTextField();
		fld_KartIsim.setColumns(10);
		fld_KartIsim.setBackground(Color.WHITE);
		fld_KartIsim.setBounds(143, 9, 139, 20);
		w_pane_Kart.add(fld_KartIsim);

		fld_KartNo = new JTextField();
		fld_KartNo.setColumns(10);
		fld_KartNo.setBackground(Color.WHITE);
		fld_KartNo.setBounds(143, 31, 139, 20);
		w_pane_Kart.add(fld_KartNo);

		JButton btn_BiletIptal = new JButton("Bilet \u0130ptal");
		btn_BiletIptal.setForeground(SystemColor.menu);
		btn_BiletIptal.setBackground(SystemColor.textHighlight);
		btn_BiletIptal.setBounds(317, 464, 92, 35);
		PaneSinema.add(btn_BiletIptal);
		btn_BiletIptal.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));

		JButton btn_Biletlerim = new JButton("Biletlerim");
		btn_Biletlerim.setForeground(SystemColor.menu);
		btn_Biletlerim.setBackground(SystemColor.textHighlight);
		btn_Biletlerim.setBounds(82, 464, 92, 35);
		PaneSinema.add(btn_Biletlerim);
		btn_Biletlerim.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		///////////////////////////////////////////////// PANESÝNEMA/////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////// PANETÝYATRO///////////////////////////////////////////////////////////////
		JPanel PaneTiyatro = new JPanel();
		PaneTiyatro.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneTiyatro.setBackground(SystemColor.inactiveCaption);
		PaneTiyatro.setBounds(486, 57, 489, 504);
		contentPane.add(PaneTiyatro);
		PaneTiyatro.setLayout(null);

		JButton btn_BiletAl2 = new JButton("Bilet Al");
		btn_BiletAl2.setBounds(195, 468, 102, 30);
		PaneTiyatro.add(btn_BiletAl2);
		btn_BiletAl2.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster2 = new JLabel("");
		lbl_Poster2.setIcon(new ImageIcon(
				"C:\\Users\\musta\\OneDrive\\Masa\u00FCst\u00FC\\Bilet Sat\u0131\u015F Sistemi\\images\\s.png"));
		lbl_Poster2.setBounds(324, 35, 128, 161);
		PaneTiyatro.add(lbl_Poster2);

		JLabel lbl_OyunAdi = new JLabel("Oyun Adý:");
		lbl_OyunAdi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunAdi.setBounds(33, 50, 107, 18);
		PaneTiyatro.add(lbl_OyunAdi);

		JLabel lbl_OyunTuru = new JLabel("Oyun Türü:");
		lbl_OyunTuru.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunTuru.setBounds(33, 73, 107, 18);
		PaneTiyatro.add(lbl_OyunTuru);

		JLabel lbl_Tarih = new JLabel("Tarih:");
		lbl_Tarih.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih.setBounds(33, 96, 107, 18);
		PaneTiyatro.add(lbl_Tarih);

		JLabel lbl_Salon2 = new JLabel("Salon:");
		lbl_Salon2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon2.setBounds(33, 119, 107, 18);
		PaneTiyatro.add(lbl_Salon2);

		JLabel lbl_Saat = new JLabel("Saat:");
		lbl_Saat.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Saat.setBounds(33, 143, 107, 18);
		PaneTiyatro.add(lbl_Saat);

		JButton btn_KoltukSec2 = new JButton("Koltuk Seç");
		btn_KoltukSec2.setBounds(33, 164, 95, 23);
		PaneTiyatro.add(btn_KoltukSec2);

		JLabel lbl_OdemeBilgileri2 = new JLabel("Ödeme Bilgileri");
		lbl_OdemeBilgileri2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_OdemeBilgileri2.setBounds(33, 208, 128, 23);
		PaneTiyatro.add(lbl_OdemeBilgileri2);

		JLabel lblTiyatroBilgileri = new JLabel("Tiyatro Bilgileri");
		lblTiyatroBilgileri.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblTiyatroBilgileri.setBounds(33, 20, 144, 23);
		PaneTiyatro.add(lblTiyatroBilgileri);

		JLabel lbl_OyunAdi_2 = new JLabel("Ad:");
		lbl_OyunAdi_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunAdi_2.setBounds(33, 238, 107, 18);
		PaneTiyatro.add(lbl_OyunAdi_2);

		JLabel lbl_OyunTuru_2 = new JLabel("Soyad:");
		lbl_OyunTuru_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OyunTuru_2.setBounds(33, 261, 107, 18);
		PaneTiyatro.add(lbl_OyunTuru_2);

		JLabel lbl_Tarih_2 = new JLabel("E-Mail:");
		lbl_Tarih_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih_2.setBounds(33, 284, 107, 18);
		PaneTiyatro.add(lbl_Tarih_2);

		fld_OyunAdi = new JTextField();
		fld_OyunAdi.setBackground(Color.WHITE);
		fld_OyunAdi.setEditable(false);
		fld_OyunAdi.setBounds(140, 51, 128, 20);
		PaneTiyatro.add(fld_OyunAdi);
		fld_OyunAdi.setColumns(10);

		fld_OyunTuru = new JTextField();
		fld_OyunTuru.setBackground(Color.WHITE);
		fld_OyunTuru.setEditable(false);
		fld_OyunTuru.setColumns(10);
		fld_OyunTuru.setBounds(140, 74, 128, 20);
		PaneTiyatro.add(fld_OyunTuru);

		fld_Tarih = new JTextField();
		fld_Tarih.setBackground(Color.WHITE);
		fld_Tarih.setEditable(false);
		fld_Tarih.setColumns(10);
		fld_Tarih.setBounds(140, 97, 128, 20);
		PaneTiyatro.add(fld_Tarih);

		fld_Salon2 = new JTextField();
		fld_Salon2.setBackground(Color.WHITE);
		fld_Salon2.setEditable(false);
		fld_Salon2.setColumns(10);
		fld_Salon2.setBounds(140, 120, 42, 20);
		PaneTiyatro.add(fld_Salon2);

		fld_KoltukSec2 = new JTextField();
		fld_KoltukSec2.setBackground(Color.WHITE);
		fld_KoltukSec2.setEditable(false);
		fld_KoltukSec2.setColumns(10);
		fld_KoltukSec2.setBounds(140, 165, 42, 20);
		PaneTiyatro.add(fld_KoltukSec2);

		fld_Saat = new JTextField();
		fld_Saat.setBackground(Color.WHITE);
		fld_Saat.setEditable(false);
		fld_Saat.setColumns(10);
		fld_Saat.setBounds(140, 143, 42, 20);
		PaneTiyatro.add(fld_Saat);

		JLabel lbl_OdemeYontemi2 = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_OdemeYontemi2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OdemeYontemi2.setBounds(33, 307, 128, 18);
		PaneTiyatro.add(lbl_OdemeYontemi2);

		JComboBox comboBox_Yontem2 = new JComboBox();
		comboBox_Yontem2.setBounds(33, 326, 110, 22);
		comboBox_Yontem2.addItem("Nakit ödeme");
		comboBox_Yontem2.addItem("Kart ile ödeme");
		PaneTiyatro.add(comboBox_Yontem2);

		JPanel w_pane_Kart2 = new JPanel();
		w_pane_Kart2.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart2.setBounds(33, 359, 452, 98);
		PaneTiyatro.add(w_pane_Kart2);
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
		PaneTiyatro.add(fld_Ad2);

		fld_Soyad2 = new JTextField();
		fld_Soyad2.setEditable(false);
		fld_Soyad2.setColumns(10);
		fld_Soyad2.setBackground(Color.WHITE);
		fld_Soyad2.setBounds(140, 261, 128, 20);
		PaneTiyatro.add(fld_Soyad2);

		fld_Mail2 = new JTextField();
		fld_Mail2.setEditable(false);
		fld_Mail2.setColumns(10);
		fld_Mail2.setBackground(Color.WHITE);
		fld_Mail2.setBounds(140, 284, 128, 20);
		PaneTiyatro.add(fld_Mail2);

		JLabel lbl_Tutar2 = new JLabel("Toplam Tutar");
		lbl_Tutar2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Tutar2.setBounds(322, 207, 154, 47);
		PaneTiyatro.add(lbl_Tutar2);

		fld_Tutar2 = new JTextField();
		fld_Tutar2.setBackground(Color.WHITE);
		fld_Tutar2.setEditable(false);
		fld_Tutar2.setBounds(322, 247, 130, 55);
		PaneTiyatro.add(fld_Tutar2);
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
		PaneTiyatro.add(btn_Biletlerim_1);

		JButton btn_BiletIptal_1 = new JButton("Bilet \u0130ptal");
		btn_BiletIptal_1.setForeground(SystemColor.menu);
		btn_BiletIptal_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_BiletIptal_1.setBackground(SystemColor.textHighlight);
		btn_BiletIptal_1.setBounds(317, 464, 92, 35);
		PaneTiyatro.add(btn_BiletIptal_1);
		PaneTiyatro.setVisible(false);
		///////////////////////////////////////////////////// PANETÝYATRO////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////// PANEKONSERs///////////////////////////////////////////////////////////////
		JPanel PaneKonser = new JPanel();
		PaneKonser.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneKonser.setBackground(SystemColor.inactiveCaption);
		PaneKonser.setBounds(486, 57, 489, 504);
		contentPane.add(PaneKonser);
		PaneKonser.setLayout(null);

		JButton btn_BiletAl3 = new JButton("Bilet Al");
		btn_BiletAl3.setBounds(195, 468, 102, 30);
		PaneKonser.add(btn_BiletAl3);
		btn_BiletAl3.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster3 = new JLabel("");
		lbl_Poster3.setIcon(new ImageIcon(
				"C:\\Users\\musta\\OneDrive\\Masa\u00FCst\u00FC\\Bilet Sat\u0131\u015F Sistemi\\images\\s.png"));
		lbl_Poster3.setBounds(324, 35, 128, 161);
		PaneKonser.add(lbl_Poster3);

		JLabel lbl_KonserAdi = new JLabel("Konser Adý:");
		lbl_KonserAdi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserAdi.setBounds(33, 50, 107, 18);
		PaneKonser.add(lbl_KonserAdi);

		JLabel lbl_KonserTuru = new JLabel("Konser Türü:");
		lbl_KonserTuru.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserTuru.setBounds(33, 73, 107, 18);
		PaneKonser.add(lbl_KonserTuru);

		JLabel lbl_Tarih2 = new JLabel("Tarih:");
		lbl_Tarih2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih2.setBounds(33, 96, 107, 18);
		PaneKonser.add(lbl_Tarih2);

		JLabel lbl_Salon3 = new JLabel("Salon:");
		lbl_Salon3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon3.setBounds(33, 119, 107, 18);
		PaneKonser.add(lbl_Salon3);

		JLabel lbl_Saat2 = new JLabel("Saat:");
		lbl_Saat2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Saat2.setBounds(33, 143, 107, 18);
		PaneKonser.add(lbl_Saat2);

		JButton btn_KoltukSec3 = new JButton("Koltuk Seç");
		btn_KoltukSec3.setBounds(33, 164, 95, 23);
		PaneKonser.add(btn_KoltukSec3);

		JLabel lbl_OdemeBilgileri3 = new JLabel("Ödeme Bilgileri");
		lbl_OdemeBilgileri3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_OdemeBilgileri3.setBounds(33, 208, 128, 23);
		PaneKonser.add(lbl_OdemeBilgileri3);

		JLabel lblKonserBilgileri = new JLabel("Konser Bilgileri");
		lblKonserBilgileri.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblKonserBilgileri.setBounds(33, 20, 144, 23);
		PaneKonser.add(lblKonserBilgileri);

		JLabel lbl_KonserAdi_2 = new JLabel("Ad:");
		lbl_KonserAdi_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserAdi_2.setBounds(33, 238, 107, 18);
		PaneKonser.add(lbl_KonserAdi_2);

		JLabel lbl_KonserTuru_2 = new JLabel("Soyad:");
		lbl_KonserTuru_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_KonserTuru_2.setBounds(33, 261, 107, 18);
		PaneKonser.add(lbl_KonserTuru_2);

		JLabel lbl_Tarih_3 = new JLabel("E-Mail:");
		lbl_Tarih_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Tarih_3.setBounds(33, 284, 107, 18);
		PaneKonser.add(lbl_Tarih_3);

		fld_KonserAdi = new JTextField();
		fld_KonserAdi.setBackground(Color.WHITE);
		fld_KonserAdi.setEditable(false);
		fld_KonserAdi.setBounds(140, 51, 128, 20);
		PaneKonser.add(fld_KonserAdi);
		fld_KonserAdi.setColumns(10);

		fld_KonserTuru = new JTextField();
		fld_KonserTuru.setBackground(Color.WHITE);
		fld_KonserTuru.setEditable(false);
		fld_KonserTuru.setColumns(10);
		fld_KonserTuru.setBounds(140, 74, 128, 20);
		PaneKonser.add(fld_KonserTuru);

		fld_Tarih2 = new JTextField();
		fld_Tarih2.setBackground(Color.WHITE);
		fld_Tarih2.setEditable(false);
		fld_Tarih2.setColumns(10);
		fld_Tarih2.setBounds(140, 97, 128, 20);
		PaneKonser.add(fld_Tarih2);

		fld_Salon3 = new JTextField();
		fld_Salon3.setBackground(Color.WHITE);
		fld_Salon3.setEditable(false);
		fld_Salon3.setColumns(10);
		fld_Salon3.setBounds(140, 120, 42, 20);
		PaneKonser.add(fld_Salon3);

		fld_KoltukSec3 = new JTextField();
		fld_KoltukSec3.setBackground(Color.WHITE);
		fld_KoltukSec3.setEditable(false);
		fld_KoltukSec3.setColumns(10);
		fld_KoltukSec3.setBounds(140, 165, 42, 20);
		PaneKonser.add(fld_KoltukSec3);

		fld_Saat2 = new JTextField();
		fld_Saat2.setBackground(Color.WHITE);
		fld_Saat2.setEditable(false);
		fld_Saat2.setColumns(10);
		fld_Saat2.setBounds(140, 143, 42, 20);
		PaneKonser.add(fld_Saat2);

		JLabel lbl_OdemeYontemi3 = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_OdemeYontemi3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_OdemeYontemi3.setBounds(33, 307, 128, 18);
		PaneKonser.add(lbl_OdemeYontemi3);

		JComboBox comboBox_Yontem3 = new JComboBox();
		comboBox_Yontem3.setBounds(33, 326, 110, 22);
		comboBox_Yontem3.addItem("Nakit ödeme");
		comboBox_Yontem3.addItem("Kart ile ödeme");
		PaneKonser.add(comboBox_Yontem3);

		JPanel w_pane_Kart3 = new JPanel();
		w_pane_Kart3.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart3.setBounds(33, 359, 452, 98);
		PaneKonser.add(w_pane_Kart3);
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
		PaneKonser.add(fld_Ad3);

		fld_Soyad3 = new JTextField();
		fld_Soyad3.setEditable(false);
		fld_Soyad3.setColumns(10);
		fld_Soyad3.setBackground(Color.WHITE);
		fld_Soyad3.setBounds(140, 261, 128, 20);
		PaneKonser.add(fld_Soyad3);

		fld_Mail3 = new JTextField();
		fld_Mail3.setEditable(false);
		fld_Mail3.setColumns(10);
		fld_Mail3.setBackground(Color.WHITE);
		fld_Mail3.setBounds(140, 284, 128, 20);
		PaneKonser.add(fld_Mail3);

		JLabel lbl_Tutar3 = new JLabel("Toplam Tutar");
		lbl_Tutar3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Tutar3.setBounds(322, 207, 154, 47);
		PaneKonser.add(lbl_Tutar3);

		fld_Tutar3 = new JTextField();
		fld_Tutar3.setBackground(Color.WHITE);
		fld_Tutar3.setEditable(false);
		fld_Tutar3.setBounds(322, 247, 130, 55);
		PaneKonser.add(fld_Tutar3);
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
		PaneKonser.add(btn_Biletlerim_1_1);

		JButton btn_BiletIptal_1_1 = new JButton("Bilet \u0130ptal");
		btn_BiletIptal_1_1.setForeground(SystemColor.menu);
		btn_BiletIptal_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_BiletIptal_1_1.setBackground(SystemColor.textHighlight);
		btn_BiletIptal_1_1.setBounds(317, 464, 92, 35);
		PaneKonser.add(btn_BiletIptal_1_1);
		PaneKonser.setVisible(false);
///////////////////////////////////////////////////// PANEKONSER////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					PaneSinema.setVisible(true);
					PaneTiyatro.setVisible(false);
					PaneKonser.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 1) {
					PaneTiyatro.setVisible(true);
					PaneSinema.setVisible(false);
					PaneKonser.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					PaneSinema.setVisible(false);
					PaneTiyatro.setVisible(false);
					PaneKonser.setVisible(true);
				}

			}

		});

	}
}
