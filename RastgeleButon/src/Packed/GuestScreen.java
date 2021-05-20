package Packed;

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
	private DefaultTableModel cinemaModel;
	private DefaultTableModel theaterModel;
	private static DefaultTableModel concertModel;
	private Object[] cinemaData = null;
	private Object[] theaterData = null;
	private static Object[] concertData = null;
	private static JTable table_Cinema;
	private static JTable table_Theater;
	private static JTable table_Concert;
	private static user member = new Member();
	private static SAdmin subadmin = new SAdmin();

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuestScreen.class.getResource("/Images/ticket.png")));
		setTitle("Bilet Satis Sistemi");
		setResizable(false);

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
		setBounds(100, 100, 624, 630);
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

		JLabel lbl_Name = new JLabel("Bilet satin almak icin lutfen giris yapiniz.");
		lbl_Name.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lbl_Name.setBounds(10, 20, 587, 20);
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
		w_paneTheater.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scrollPane_Theater = new JScrollPane();
		scrollPane_Theater.setBounds(0, 0, 582, 448);
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
		w_paneConcert.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Konser", null, w_paneConcert, null);

		w_paneConcert.setLayout(null);

		JScrollPane scrollPane_Concert = new JScrollPane();
		scrollPane_Concert.setBounds(0, 0, 582, 448);
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

		JButton btn_SelectCinema = new JButton("Geri Don");
		btn_SelectCinema.setFocusable(false);
		btn_SelectCinema.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_SelectCinema.setForeground(new Color(0, 0, 0));
		btn_SelectCinema.setBackground(new Color(153, 204, 255));
		btn_SelectCinema.setBounds(262, 547, 93, 30);
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