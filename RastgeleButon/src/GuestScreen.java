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

public class GuestScreen extends JFrame {

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
					GuestScreen frame = new GuestScreen(member);
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
	public GuestScreen(user member) throws SQLException {
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
		setBounds(100, 100, 624, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(
				new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JLabel lbl_Name = new JLabel("Bilet sat\u0131n almak i\u00E7in l\u00FCtfen giri\u015F yap\u0131n\u0131z.");
		lbl_Name.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl_Name.setBounds(10, 20, 400, 20);
		contentPane.add(lbl_Name);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(new Color(255, 255, 255));

		tabbedPane.setBounds(10, 60, 587, 476);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Sinema", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scrollPane_Cinema = new JScrollPane();
		scrollPane_Cinema.setBounds(0, 0, 582, 448);
		w_paneCinema.add(scrollPane_Cinema);
///////////////////////////////////////////////////////////////////////////////////Sinema Sütun Özellikleri
		table_Cinema = new JTable(cinemaModel);
		table_Cinema.setBackground(new Color(255, 248, 220));
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
		// table_Cinema.getColumnModel().getColumn(0).

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
		w_paneTheater.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scrollPane_Theater = new JScrollPane();
		scrollPane_Theater.setBounds(0, 0, 582, 448);
		w_paneTheater.add(scrollPane_Theater);

///////////////////////////////////////////////////////////////////////////////////Tiyatro Sütun Özellikleri
		table_Theater = new JTable(theaterModel);
		table_Theater.setBackground(new Color(255, 248, 220));
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
			theaterData[0] = tiyatro.theaterList().get(i).getTheaterName();
			theaterData[1] = tiyatro.theaterList().get(i).getTheaterType();
			theaterData[2] = tiyatro.theaterList().get(i).getTheaterDate();
			theaterData[3] = tiyatro.theaterList().get(i).getTheaterSalon();
			theaterData[4] = tiyatro.theaterList().get(i).getTheaterDate();
			theaterModel.addRow(theaterData);
		}

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Konser", null, w_paneConcert, null);

		w_paneConcert.setLayout(null);

		JScrollPane scrollPane_Concert = new JScrollPane();
		scrollPane_Concert.setBounds(0, 0, 582, 448);
		w_paneConcert.add(scrollPane_Concert);

		table_Concert = new JTable(concertModel);
		table_Concert.setBackground(new Color(255, 248, 220));
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
		

		JButton btn_SelectCinema = new JButton("Geri D\u00F6n");
		btn_SelectCinema.setFocusable(false);
		btn_SelectCinema.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_SelectCinema.setForeground(new Color(0, 0, 0));
		btn_SelectCinema.setBackground(new Color(240, 255, 240));
		btn_SelectCinema.setBounds(255, 547, 93, 30);
		contentPane.add(btn_SelectCinema);
		btn_SelectCinema.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_SelectCinema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});

	}
}