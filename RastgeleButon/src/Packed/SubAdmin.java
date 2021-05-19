package Packed;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.DateFormatter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import Helper.DbHelper;
import Helper.Metod_Helper;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.EventObject;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SubAdmin extends JFrame {
	private static DefaultTableModel cinemaModel;
	private static DefaultTableModel theaterModel;
	private static DefaultTableModel concertModel;
	private static Object[] cinemaData = null;
	private static Object[] concertData = null;
	private static Object[] theaterData = null;
	private JPanel contentPane;
	private static JTable table_Cinema;
	private static JTable table_Theater;
	private static JTable table_Concert;
	private JTextField txt_TheaterName;
	private JTextField txt_ConcertName;
	private JTextField txt_ConcertType;
	private JButton btn_ImageSelect;
	private JLabel lbl_Poster;

	private static user sub = new user();
	private static SAdmin subadmin = new SAdmin();
	DbHelper dbhelper = new DbHelper();
	Connection connection = null;
	PreparedStatement pStatement;
	private JTextField txt_MovieName;
	private JTextField txt_MovieDirector;
	private JTextField txt_TicketCount;
	private JTextField txt_TicketPrice;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubAdmin frame = new SubAdmin(sub);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public SubAdmin(user sub) throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		cinemaModel = new DefaultTableModel();
		Object[] colCinema = new Object[7];
		colCinema[0] = "Film ID";
		colCinema[1] = "Film Adi";
		colCinema[2] = "Film Tarihi";
		colCinema[3] = "Yonetmen";
		colCinema[4] = "Tarih";
		colCinema[5] = "Salon";
		colCinema[6] = "Seans";

		cinemaModel.setColumnIdentifiers(colCinema);
		cinemaData = new Object[7];

		concertModel = new DefaultTableModel();
		Object[] colConcert = new Object[8];
		colConcert[0] = "Konser ID";
		colConcert[1] = "Konser Adi";
		colConcert[2] = "Konser Yeri";
		colConcert[3] = "Sanatci";
		colConcert[4] = "Tarih";
		colConcert[5] = "Saat";
		colConcert[6] = "Bilet Adeti";
		colConcert[7] = "Bilet Fiyati";

		concertModel.setColumnIdentifiers(colConcert);
		concertData = new Object[8];

		theaterModel = new DefaultTableModel();
		Object[] colTheater = new Object[6];
		colTheater[0] = "Oyun ID";
		colTheater[1] = "Oyun Adi";
		colTheater[2] = "Oyun Tarihi";
		colTheater[3] = "Tarih";
		colTheater[4] = "Salon";
		colTheater[5] = "Saat";

		theaterModel.setColumnIdentifiers(colTheater);
		theaterData = new Object[6];

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.CYAN);
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tabbedPane.setBounds(0, 41, 651, 438);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Sinema", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scroll_Cinema = new JScrollPane();
		scroll_Cinema.setBounds(0, 0, 644, 355);
		w_paneCinema.add(scroll_Cinema);

		table_Cinema = new JTable(cinemaModel);
		table_Cinema.getColumn("Film ID").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Film Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Film Tarihi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Yonetmen").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Salon").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Seans").setCellEditor(new TableEditor(new JCheckBox()));
		scroll_Cinema.setViewportView(table_Cinema);

		JButton btn_ShowRemoval = new JButton("Gosteri cikar");
		btn_ShowRemoval.setBounds(243, 365, 142, 34);
		w_paneCinema.add(btn_ShowRemoval);
		btn_ShowRemoval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_Cinema.getSelectionModel().isSelectionEmpty()) {
					Metod_Helper.showMsg("Lutfen silmek istediginiz gosteriyi seciniz!");
				} else {
					if (Metod_Helper.confirm("sure")) {
						int selectedRow = Integer
								.parseInt(table_Cinema.getValueAt(table_Cinema.getSelectedRow(), 0).toString());
						try {
							boolean control = subadmin.delCinema(selectedRow);
							if (control) {
								Metod_Helper.showMsg("succes");
								updateCinemaList();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_ShowRemoval.setFont(new Font("Arial", Font.PLAIN, 11));
		table_Cinema.getColumnModel().getColumn(0).setResizable(false);
		table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_Cinema.getColumnModel().getColumn(1).setResizable(false);
		table_Cinema.getColumnModel().getColumn(2).setResizable(false);
		table_Cinema.getColumnModel().getColumn(3).setResizable(false);
		table_Cinema.getColumnModel().getColumn(4).setResizable(false);
		table_Cinema.getColumnModel().getColumn(5).setResizable(false);

		for (int i = 0; i < subadmin.cinemaList().size(); i++) {
			cinemaData[0] = subadmin.cinemaList().get(i).getFilmID();
			cinemaData[1] = subadmin.cinemaList().get(i).getFilmName();
			cinemaData[2] = subadmin.cinemaList().get(i).getFilmType();
			cinemaData[3] = subadmin.cinemaList().get(i).getFilmDirector();
			cinemaData[4] = subadmin.cinemaList().get(i).getFilmDate();
			cinemaData[5] = subadmin.cinemaList().get(i).getFilmSalon();
			cinemaData[6] = subadmin.cinemaList().get(i).getFilmSeans();
			cinemaModel.addRow(cinemaData);
		}

		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(new Color(221, 160, 221));
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scroll_Theater = new JScrollPane();
		scroll_Theater.setBounds(0, 0, 644, 355);

		w_paneTheater.add(scroll_Theater);

		table_Theater = new JTable(theaterModel);
		table_Theater.getColumn("Oyun ID").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Oyun Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Oyun Tarihi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Salon").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Saat").setCellEditor(new TableEditor(new JCheckBox()));
		scroll_Theater.setViewportView(table_Theater);

		JButton btn_ShowRemoval_1 = new JButton("Gosteriyi cikar");
		btn_ShowRemoval_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_Theater.getSelectionModel().isSelectionEmpty()) {
					Metod_Helper.showMsg("Lutfen silmek istediginiz gosteriyi seciniz!");
				} else {
					if (Metod_Helper.confirm("sure")) {
						int selectedRow = Integer
								.parseInt(table_Theater.getValueAt(table_Theater.getSelectedRow(), 0).toString());
						try {
							boolean control = subadmin.delTheater(selectedRow);
							if (control) {
								Metod_Helper.showMsg("succes");
								updateTheaterList();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_ShowRemoval_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_ShowRemoval_1.setBounds(243, 365, 142, 34);
		w_paneTheater.add(btn_ShowRemoval_1);
		table_Theater.getColumnModel().getColumn(0).setResizable(false);
		table_Theater.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_Theater.getColumnModel().getColumn(1).setResizable(false);
		table_Theater.getColumnModel().getColumn(2).setResizable(false);
		table_Theater.getColumnModel().getColumn(3).setResizable(false);
		table_Theater.getColumnModel().getColumn(4).setResizable(false);

		for (int j = 0; j < subadmin.theaterList().size(); j++) {
			theaterData[0] = subadmin.theaterList().get(j).getTiyatroID();
			theaterData[1] = subadmin.theaterList().get(j).getTiyatroName();
			theaterData[2] = subadmin.theaterList().get(j).getTiyatroType();
			theaterData[3] = subadmin.theaterList().get(j).getTiyatroDate();
			theaterData[4] = subadmin.theaterList().get(j).getTiyatroSalon();
			theaterData[5] = subadmin.theaterList().get(j).getTiyatroSaat();
			theaterModel.addRow(theaterData);
		}

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(new Color(143, 188, 143));
		tabbedPane.addTab("Konser", null, w_paneConcert, null);
		w_paneConcert.setLayout(null);

		JScrollPane scroll_Concert = new JScrollPane();
		scroll_Concert.setBounds(0, 0, 644, 355);
		w_paneConcert.add(scroll_Concert);

		table_Concert = new JTable(concertModel);
		table_Concert.getColumn("Konser ID").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Konser Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Konser Yeri").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Sanatci").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Saat").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Bilet Adeti").setCellEditor(new TableEditor(new JCheckBox()));
		table_Concert.getColumn("Bilet Fiyati").setCellEditor(new TableEditor(new JCheckBox()));
		scroll_Concert.setViewportView(table_Concert);

		JButton btn_ShowRemoval_1_1 = new JButton("Gosteri cikar");
		btn_ShowRemoval_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_Concert.getSelectionModel().isSelectionEmpty()) {
					Metod_Helper.showMsg("Lutfen silmek istediginiz gosteriyi seciniz!");
				} else {
					if (Metod_Helper.confirm("sure")) {
						int selectedRow = Integer
								.parseInt(table_Concert.getValueAt(table_Concert.getSelectedRow(), 0).toString());
						try {
							boolean control = subadmin.delConcert(selectedRow);
							if (control) {
								Metod_Helper.showMsg("succes");
								updateConcertList();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}

		});
		btn_ShowRemoval_1_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_ShowRemoval_1_1.setBounds(243, 365, 142, 34);
		w_paneConcert.add(btn_ShowRemoval_1_1);
		table_Concert.getColumnModel().getColumn(0).setResizable(false);
		table_Concert.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_Concert.getColumnModel().getColumn(1).setResizable(false);
		table_Concert.getColumnModel().getColumn(2).setResizable(false);
		table_Concert.getColumnModel().getColumn(3).setResizable(false);
		table_Concert.getColumnModel().getColumn(4).setResizable(false);
		table_Concert.getColumnModel().getColumn(5).setResizable(false);
		table_Concert.getColumnModel().getColumn(6).setResizable(false);
		table_Concert.getColumnModel().getColumn(7).setResizable(false);

		for (int k = 0; k < subadmin.concertList().size(); k++) {
			concertData[0] = subadmin.concertList().get(k).getConcertID();
			concertData[1] = subadmin.concertList().get(k).getConcertName();
			concertData[2] = subadmin.concertList().get(k).getConcertPlace();
			concertData[3] = subadmin.concertList().get(k).getConcertArtist();
			concertData[4] = subadmin.concertList().get(k).getConcertDate();
			concertData[5] = subadmin.concertList().get(k).getConcertTime();
			concertData[6] = subadmin.concertList().get(k).getTicketCount();
			concertData[7] = subadmin.concertList().get(k).getTicketPrice();
			concertModel.addRow(concertData);
		}

	

/////////////////////////////PANECINEMA///////////////////////////////////////////////////////////////////////////

		JPanel paneAddCinema = new JPanel();
		paneAddCinema.setBackground(new Color(224, 255, 255));
		paneAddCinema.setBounds(661, 41, 423, 438);
		contentPane.add(paneAddCinema);
		paneAddCinema.setLayout(null);

		JLabel lbl_MovieName = new JLabel("Film Adi:");
		lbl_MovieName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 10, 102, 28);
		paneAddCinema.add(lbl_MovieName);

		JLabel lbl_FilmDirector = new JLabel("Yonetmen:");
		lbl_FilmDirector.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_FilmDirector.setBounds(10, 45, 102, 28);
		paneAddCinema.add(lbl_FilmDirector);

		JLabel lbl_MovieType = new JLabel("Film Tarihi:");
		lbl_MovieType.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MovieType.setBounds(10, 72, 102, 28);
		paneAddCinema.add(lbl_MovieType);

		JLabel lbl_CinemaSalon = new JLabel("Salon:");
		lbl_CinemaSalon.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_CinemaSalon.setBounds(10, 110, 102, 28);
		paneAddCinema.add(lbl_CinemaSalon);

		txt_MovieName = new JTextField();
		txt_MovieName.setBounds(111, 17, 138, 20);
		paneAddCinema.add(txt_MovieName);
		txt_MovieName.setColumns(10);

		txt_MovieDirector = new JTextField();
		txt_MovieDirector.setColumns(10);
		txt_MovieDirector.setBounds(111, 48, 138, 23);
		paneAddCinema.add(txt_MovieDirector);

		JComboBox<String> combo_MovieType = new JComboBox<String>();
		combo_MovieType.setBounds(111, 78, 138, 21);
		paneAddCinema.add(combo_MovieType);
		combo_MovieType.addItem(null);
		combo_MovieType.addItem("Aksiyon");
		combo_MovieType.addItem("Bilim/Kurgu");
		combo_MovieType.addItem("Drama");
		combo_MovieType.addItem("Fantezi");
		combo_MovieType.addItem("Gerilim");
		combo_MovieType.addItem("Gizem");
		combo_MovieType.addItem("Komedi");
		combo_MovieType.addItem("Korku");
		combo_MovieType.addItem("Romantik");
		combo_MovieType.addItem("Western");

		JLabel lbl_MovieDate = new JLabel("Tarih:");
		lbl_MovieDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MovieDate.setBounds(10, 143, 102, 28);
		paneAddCinema.add(lbl_MovieDate);
/////////////////////////Trrrrrrrrrrrrrrrr
		JComboBox<String> comboBox_Salon = new JComboBox<String>();
		comboBox_Salon.setBounds(111, 116, 138, 21);
		paneAddCinema.add(comboBox_Salon);
		comboBox_Salon.addItem(null);
		comboBox_Salon.addItem("A-1");
		comboBox_Salon.addItem("A-2");
		comboBox_Salon.addItem("A-3");
		comboBox_Salon.addItem("B-1");
		comboBox_Salon.addItem("B-2");
		comboBox_Salon.addItem("B-3");
		comboBox_Salon.addItem("C-1");
		comboBox_Salon.addItem("C-2");
		comboBox_Salon.addItem("C-3");

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(111, 147, 138, 20);
		paneAddCinema.add(dateChooser);

		JLabel lbl_Poster = new JLabel("");
		paneAddCinema.add(lbl_Poster);

		JButton btn_ImageSelect = new JButton("Afis Sec");
		btn_ImageSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//------------------------------------------------------------------------------------------foto ekleme alanÃ½ bozma :)
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					String id = (subadmin.getFilmID()+1)+"";

					connection = dbhelper.getConnection();
					pStatement = connection.prepareStatement("update cinema set pic=? where filmID =?");

					JFileChooser jfc = new JFileChooser();
					jfc.showOpenDialog(null);
					File file = jfc.getSelectedFile();

					FileInputStream fis = new FileInputStream(file);
					pStatement.setBinaryStream(1, fis, fis.available());
					pStatement.setString(2, id);

					pStatement.executeUpdate();

					Metod_Helper.showMsg("succes");

				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}

//-----------------------------------------------------------------------------------------------------------------	
				

			}
		});

		btn_ImageSelect.setBounds(304, 182, 102, 31);
		paneAddCinema.add(btn_ImageSelect);

		JLabel lbl_CinemaSeance = new JLabel("Seans:");
		lbl_CinemaSeance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CinemaSeance.setBounds(10, 219, 46, 28);
		paneAddCinema.add(lbl_CinemaSeance);

		JPanel SeanceHours3 = new JPanel();
		SeanceHours3.setBounds(59, 223, 347, 139);
		paneAddCinema.add(SeanceHours3);
		SeanceHours3.setLayout(null);
		SeanceHours3.setBackground(Color.WHITE);

		ButtonGroup bgg = new ButtonGroup();

		JRadioButton rdbtn0_0_0 = new JRadioButton("10:00 ");
		rdbtn0_0_0.setBounds(6, 6, 103, 21);
		rdbtn0_0_0.setActionCommand(rdbtn0_0_0.getText());
		SeanceHours3.add(rdbtn0_0_0);

		JRadioButton rdbtn1_1_1 = new JRadioButton("11:00");
		rdbtn1_1_1.setBounds(122, 6, 103, 21);
		rdbtn1_1_1.setActionCommand(rdbtn1_1_1.getText());
		SeanceHours3.add(rdbtn1_1_1);

		JRadioButton rdbtn2_2_2 = new JRadioButton("12:00");
		rdbtn2_2_2.setBounds(238, 6, 103, 21);
		rdbtn2_2_2.setActionCommand(rdbtn2_2_2.getText());
		SeanceHours3.add(rdbtn2_2_2);

		JRadioButton rdbtn8_8_8 = new JRadioButton("18:00");
		rdbtn8_8_8.setBounds(238, 76, 103, 21);
		rdbtn8_8_8.setActionCommand(rdbtn8_8_8.getText());
		SeanceHours3.add(rdbtn8_8_8);

		JRadioButton rdbtn7_7_7 = new JRadioButton("17:00");
		rdbtn7_7_7.setBounds(122, 76, 103, 21);
		rdbtn7_7_7.setActionCommand(rdbtn7_7_7.getText());
		SeanceHours3.add(rdbtn7_7_7);

		JRadioButton rdbtn6_6_6 = new JRadioButton("16:00");
		rdbtn6_6_6.setBounds(6, 76, 103, 21);
		rdbtn6_6_6.setActionCommand(rdbtn6_6_6.getText());
		SeanceHours3.add(rdbtn6_6_6);

		JRadioButton rdbtn11_1_1 = new JRadioButton("21:00");
		rdbtn11_1_1.setBounds(238, 112, 103, 21);
		rdbtn11_1_1.setActionCommand(rdbtn11_1_1.getText());
		SeanceHours3.add(rdbtn11_1_1);

		JRadioButton rdbtn10_0_0 = new JRadioButton("20:00");
		rdbtn10_0_0.setBounds(122, 112, 103, 21);
		rdbtn10_0_0.setActionCommand(rdbtn10_0_0.getText());
		SeanceHours3.add(rdbtn10_0_0);

		JRadioButton rdbtn9_9_9 = new JRadioButton("19:00");
		rdbtn9_9_9.setBounds(6, 112, 103, 21);
		rdbtn9_9_9.setActionCommand(rdbtn9_9_9.getText());
		SeanceHours3.add(rdbtn9_9_9);

		JRadioButton rdbtn5_5_5 = new JRadioButton("15:00");
		rdbtn5_5_5.setBounds(238, 41, 103, 21);
		rdbtn5_5_5.setActionCommand(rdbtn5_5_5.getText());
		SeanceHours3.add(rdbtn5_5_5);

		JRadioButton rdbtn4_4_4 = new JRadioButton("14:00");
		rdbtn4_4_4.setBounds(122, 41, 103, 21);
		rdbtn4_4_4.setActionCommand(rdbtn4_4_4.getText());
		SeanceHours3.add(rdbtn4_4_4);

		JRadioButton rdbtn3_3_3 = new JRadioButton("13:00");
		rdbtn3_3_3.setBounds(6, 41, 103, 21);
		rdbtn3_3_3.setActionCommand(rdbtn3_3_3.getText());
		SeanceHours3.add(rdbtn3_3_3);

		bgg.add(rdbtn0_0_0);
		bgg.add(rdbtn1_1_1);
		bgg.add(rdbtn2_2_2);
		bgg.add(rdbtn3_3_3);
		bgg.add(rdbtn4_4_4);
		bgg.add(rdbtn5_5_5);
		bgg.add(rdbtn6_6_6);
		bgg.add(rdbtn7_7_7);
		bgg.add(rdbtn8_8_8);
		bgg.add(rdbtn9_9_9);
		bgg.add(rdbtn10_0_0);
		bgg.add(rdbtn11_1_1);

		JButton btn_AddCinema = new JButton("Film Ekle");
		btn_AddCinema.setBounds(141, 396, 138, 31);
		paneAddCinema.add(btn_AddCinema);

		JLabel lbl_MoviePitcure = new JLabel("");
		lbl_MoviePitcure.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MoviePitcure.setBounds(288, 17, 125, 148);
		paneAddCinema.add(lbl_MoviePitcure);
		btn_AddCinema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String seance = "";

				if (rdbtn0_0_0.isSelected()) {
					seance = rdbtn0_0_0.getText();
				}
				if (rdbtn1_1_1.isSelected()) {
					seance = rdbtn1_1_1.getText();
				}
				if (rdbtn2_2_2.isSelected()) {
					seance = rdbtn2_2_2.getText();
				}
				if (rdbtn3_3_3.isSelected()) {
					seance = rdbtn3_3_3.getText();
				}
				if (rdbtn4_4_4.isSelected()) {
					seance = rdbtn4_4_4.getText();
				}
				if (rdbtn5_5_5.isSelected()) {
					seance = rdbtn5_5_5.getText();
				}
				if (rdbtn6_6_6.isSelected()) {
					seance = rdbtn6_6_6.getText();
				}
				if (rdbtn7_7_7.isSelected()) {
					seance = rdbtn7_7_7.getText();
				}
				if (rdbtn8_8_8.isSelected()) {
					seance = rdbtn8_8_8.getText();
				}
				if (rdbtn9_9_9.isSelected()) {
					seance = rdbtn9_9_9.getText();
				}
				if (rdbtn10_0_0.isSelected()) {
					seance = rdbtn10_0_0.getText();
				}
				if (rdbtn11_1_1.isSelected()) {
					seance = rdbtn11_1_1.getText();
				}

				if (txt_MovieName.getText().length() == 0 || txt_MovieDirector.getText().length() == 0
						|| combo_MovieType.getSelectedIndex() == -1 || comboBox_Salon.getSelectedIndex() == -1
						|| dateChooser.getDate() == null || seance.length() == 0) {
					Metod_Helper.showMsg("fill");
					if (seance == "") {
						Metod_Helper.showMsg("Lutfen Seans seciniz!");
					}
				} else {
					
					String cboxMovieType = String.valueOf(combo_MovieType.getSelectedItem());
					String cboxSalon = String.valueOf(comboBox_Salon.getSelectedItem());

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String date = dateFormat.format(dateChooser.getDate());

					String selSeans = "" + bgg.getSelection().getActionCommand();
					try {
						boolean control = subadmin.addCinema(txt_MovieName.getText(), cboxMovieType,
								txt_MovieDirector.getText(), date, cboxSalon, selSeans);
						if (control) {
							Metod_Helper.showMsg("succes");
							txt_MovieName.setText(null);
							cboxMovieType = "";
							txt_MovieDirector.setText(null);
							date = null;
							cboxSalon = null;
							selSeans = null;
							updateCinemaList();

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		/////////////////////////////////////////////////////////////// PaneCinema//////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////// PaneTheater

		JPanel paneAddTheater = new JPanel();
		paneAddTheater.setBackground(new Color(221, 160, 221));
		paneAddTheater.setBounds(661, 41, 423, 438);
		contentPane.add(paneAddTheater);
		paneAddTheater.setLayout(null);

		JLabel lbl_TheaterName = new JLabel("Oyun Adi:");
		lbl_TheaterName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TheaterName.setBounds(10, 10, 102, 28);
		paneAddTheater.add(lbl_TheaterName);

		JLabel lbl_TheaterType = new JLabel("Oyun Tarihi:");
		lbl_TheaterType.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TheaterType.setBounds(10, 45, 102, 28);
		paneAddTheater.add(lbl_TheaterType);

		JComboBox comboBox_TheaterType = new JComboBox();
		comboBox_TheaterType.setBounds(111, 49, 138, 22);
		paneAddTheater.add(comboBox_TheaterType);
		comboBox_TheaterType.addItem(null);
		comboBox_TheaterType.addItem("Bale");
		comboBox_TheaterType.addItem("Golge Oyunu");
		comboBox_TheaterType.addItem("Komedi");
		comboBox_TheaterType.addItem("Muzikal");
		comboBox_TheaterType.addItem("Opera");
		comboBox_TheaterType.addItem("Trajedi");

		JLabel lbl_TheaterSalon = new JLabel("Salon:");
		lbl_TheaterSalon.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TheaterSalon.setBounds(10, 78, 102, 28);
		paneAddTheater.add(lbl_TheaterSalon);

		txt_TheaterName = new JTextField();
		txt_TheaterName.setBounds(111, 17, 138, 20);
		paneAddTheater.add(txt_TheaterName);
		txt_TheaterName.setColumns(10);

		JLabel lbl_TheaterDate = new JLabel("Tarih:");
		lbl_TheaterDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TheaterDate.setBounds(10, 115, 102, 28);
		paneAddTheater.add(lbl_TheaterDate);
		///////////////////////// Trrrrrrrrrrrrrrrr
		JComboBox<String> comboBox_Salon2 = new JComboBox<String>();
		comboBox_Salon2.setBounds(111, 84, 138, 21);
		paneAddTheater.add(comboBox_Salon2);
		comboBox_Salon2.addItem(null);
		comboBox_Salon2.addItem("A-1");
		comboBox_Salon2.addItem("A-2");
		comboBox_Salon2.addItem("A-3");
		comboBox_Salon2.addItem("B-1");
		comboBox_Salon2.addItem("B-2");
		comboBox_Salon2.addItem("B-3");
		comboBox_Salon2.addItem("C-1");
		comboBox_Salon2.addItem("C-2");
		comboBox_Salon2.addItem("C-3");

		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(111, 119, 138, 20);
		paneAddTheater.add(dateChooser2);

		JLabel lbl_Poster2 = new JLabel("");
		paneAddTheater.add(lbl_Poster2);

		JButton btn_ImageSelect2 = new JButton("Afis Sec");
		btn_ImageSelect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ------------------------------------------------------------------------------------------foto
				// ekleme alanÃ½ bozma :)
				try {
					String id = (subadmin.getTiyatroID()+1)+"";
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = dbhelper.getConnection();
					pStatement = connection.prepareStatement("insert into tiyatro(pic) values(?)");

					JFileChooser jfc2 = new JFileChooser();
					jfc2.showOpenDialog(null);
					File file2 = jfc2.getSelectedFile();

					FileInputStream fis2 = new FileInputStream(file2);
					pStatement.setBinaryStream(1, fis2, fis2.available());
					pStatement.setString(2, id);
					
					pStatement.executeUpdate();

					Metod_Helper.showMsg("succes");

				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}

				// -----------------------------------------------------------------------------------------------------------------

			}
		});

		btn_ImageSelect2.setBounds(304, 182, 102, 31);
		paneAddTheater.add(btn_ImageSelect2);

		JLabel lbl_TheaterSeance = new JLabel("Saat:");
		lbl_TheaterSeance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TheaterSeance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TheaterSeance.setBounds(10, 219, 46, 28);
		paneAddTheater.add(lbl_TheaterSeance);

		JPanel TheaterSeanceHours = new JPanel();
		TheaterSeanceHours.setBounds(59, 223, 347, 139);
		paneAddTheater.add(TheaterSeanceHours);
		TheaterSeanceHours.setLayout(null);
		TheaterSeanceHours.setBackground(Color.WHITE);

		ButtonGroup bgg2 = new ButtonGroup();

		JRadioButton rdbtn02 = new JRadioButton("10:00 ");
		rdbtn02.setBounds(6, 6, 103, 21);
		rdbtn02.setActionCommand(rdbtn02.getText());
		TheaterSeanceHours.add(rdbtn02);

		JRadioButton rdbtn13 = new JRadioButton("11:00");
		rdbtn13.setBounds(122, 6, 103, 21);
		rdbtn13.setActionCommand(rdbtn13.getText());
		TheaterSeanceHours.add(rdbtn13);

		JRadioButton rdbtn24 = new JRadioButton("12:00");
		rdbtn24.setBounds(238, 6, 103, 21);
		rdbtn24.setActionCommand(rdbtn24.getText());
		TheaterSeanceHours.add(rdbtn24);

		JRadioButton rdbtn810 = new JRadioButton("18:00");
		rdbtn810.setBounds(238, 76, 103, 21);
		rdbtn810.setActionCommand(rdbtn810.getText());
		TheaterSeanceHours.add(rdbtn810);

		JRadioButton rdbtn79 = new JRadioButton("17:00");
		rdbtn79.setBounds(122, 76, 103, 21);
		rdbtn79.setActionCommand(rdbtn79.getText());
		TheaterSeanceHours.add(rdbtn79);

		JRadioButton rdbtn68 = new JRadioButton("16:00");
		rdbtn68.setBounds(6, 76, 103, 21);
		rdbtn68.setActionCommand(rdbtn68.getText());
		TheaterSeanceHours.add(rdbtn68);

		JRadioButton rdbtn111 = new JRadioButton("21:00");
		rdbtn111.setBounds(238, 112, 103, 21);
		rdbtn111.setActionCommand(rdbtn111.getText());
		TheaterSeanceHours.add(rdbtn111);

		JRadioButton rdbtn102 = new JRadioButton("20:00");
		rdbtn102.setBounds(122, 112, 103, 21);
		rdbtn102.setActionCommand(rdbtn102.getText());
		TheaterSeanceHours.add(rdbtn102);

		JRadioButton rdbtn911 = new JRadioButton("19:00");
		rdbtn911.setBounds(6, 112, 103, 21);
		rdbtn911.setActionCommand(rdbtn911.getText());
		TheaterSeanceHours.add(rdbtn911);

		JRadioButton rdbtn57 = new JRadioButton("15:00");
		rdbtn57.setBounds(238, 41, 103, 21);
		rdbtn57.setActionCommand(rdbtn57.getText());
		TheaterSeanceHours.add(rdbtn57);

		JRadioButton rdbtn46 = new JRadioButton("14:00");
		rdbtn46.setBounds(122, 41, 103, 21);
		rdbtn46.setActionCommand(rdbtn46.getText());
		TheaterSeanceHours.add(rdbtn46);

		JRadioButton rdbtn35 = new JRadioButton("13:00");
		rdbtn35.setBounds(6, 41, 103, 21);
		rdbtn35.setActionCommand(rdbtn35.getText());
		TheaterSeanceHours.add(rdbtn35);

		bgg2.add(rdbtn02);
		bgg2.add(rdbtn13);
		bgg2.add(rdbtn24);
		bgg2.add(rdbtn35);
		bgg2.add(rdbtn46);
		bgg2.add(rdbtn57);
		bgg2.add(rdbtn68);
		bgg2.add(rdbtn79);
		bgg2.add(rdbtn810);
		bgg2.add(rdbtn911);
		bgg2.add(rdbtn102);
		bgg2.add(rdbtn111);

		JButton btn_AddTheater = new JButton("Oyun Ekle");
		btn_AddTheater.setBounds(141, 396, 138, 31);
		paneAddTheater.add(btn_AddTheater);

		JLabel lbl_TheatrePitcure = new JLabel("");
		lbl_TheatrePitcure.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TheatrePitcure.setBounds(288, 10, 125, 148);
		paneAddTheater.add(lbl_TheatrePitcure);

		//////////////////////////////////// PaneTheater////////////////////////////////////////////////////////////////////
		///////////////////////////// PaneConcert

		JPanel paneAddConcert = new JPanel();
		paneAddConcert.setBackground(new Color(143, 188, 143));
		paneAddConcert.setBounds(661, 41, 423, 438);
		contentPane.add(paneAddConcert);
		paneAddConcert.setLayout(null);

		JLabel lbl_ConcertName = new JLabel("Konser Adi:");
		lbl_ConcertName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ConcertName.setBounds(10, 10, 102, 28);
		paneAddConcert.add(lbl_ConcertName);

		JLabel lbl_ArtistName = new JLabel("Sanatci Adi:");
		lbl_ArtistName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ArtistName.setBounds(10, 45, 102, 28);
		paneAddConcert.add(lbl_ArtistName);

		txt_ConcertName = new JTextField();
		txt_ConcertName.setBounds(111, 17, 138, 20);
		paneAddConcert.add(txt_ConcertName);
		txt_ConcertName.setColumns(10);

		txt_ConcertType = new JTextField();
		txt_ConcertType.setColumns(10);
		txt_ConcertType.setBounds(111, 48, 138, 20);
		paneAddConcert.add(txt_ConcertType);

		JLabel lbl_ConcertPlace = new JLabel("Konser Yeri:");
		lbl_ConcertPlace.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ConcertPlace.setBounds(10, 83, 108, 28);
		paneAddConcert.add(lbl_ConcertPlace);

		JComboBox combo_ConcertPlace = new JComboBox();
		combo_ConcertPlace.setBounds(111, 83, 138, 21);
		paneAddConcert.add(combo_ConcertPlace);
		combo_ConcertPlace.addItem(null);
		combo_ConcertPlace.addItem("Babylon");
		combo_ConcertPlace.addItem("Dorock XL");
		combo_ConcertPlace.addItem("Zorlu Center");
		combo_ConcertPlace.addItem("Wolkswagen Arena");
		combo_ConcertPlace.addItem("Jolly Joker");
		combo_ConcertPlace.addItem("Bronx Pi Sahne");
		combo_ConcertPlace.addItem("Shaft");

		JLabel lbl_ConcertDate = new JLabel("Tarih:");
		lbl_ConcertDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ConcertDate.setBounds(10, 115, 102, 28);
		paneAddConcert.add(lbl_ConcertDate);

		JDateChooser dateChooser3 = new JDateChooser();
		dateChooser3.setBounds(111, 119, 138, 20);
		paneAddConcert.add(dateChooser3);

		JLabel lbl_Poster3 = new JLabel("");
		paneAddConcert.add(lbl_Poster3);

		JButton btn_ImageSelect3 = new JButton("Afis Sec");
		btn_ImageSelect3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//------------------------------------------------------------------------------------------foto ekleme alanÃ½ bozma :)
				try {
					String id = (subadmin.getConcertID()+1)+"";
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = dbhelper.getConnection();
					pStatement = connection.prepareStatement("insert into concert(pic) values(?)");

					JFileChooser jfc3 = new JFileChooser();
					jfc3.showOpenDialog(null);
					File file3 = jfc3.getSelectedFile();

					FileInputStream fis3 = new FileInputStream(file3);
					pStatement.setBinaryStream(1, fis3, fis3.available());
					pStatement.setString(2, id);
					pStatement.executeUpdate();

					Metod_Helper.showMsg("succes");

				} catch (Exception e3) {
					// TODO: handle exception
					System.out.println(e3);
				}

//-----------------------------------------------------------------------------------------------------------------								

			}
		});

		btn_ImageSelect3.setBounds(304, 182, 102, 31);
		paneAddConcert.add(btn_ImageSelect3);

		JLabel lbl_ConcertSeance = new JLabel("Saat:");
		lbl_ConcertSeance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ConcertSeance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ConcertSeance.setBounds(10, 219, 46, 28);
		paneAddConcert.add(lbl_ConcertSeance);

		JPanel ConcertSeanceHours = new JPanel();
		ConcertSeanceHours.setBounds(59, 223, 347, 139);
		paneAddConcert.add(ConcertSeanceHours);
		ConcertSeanceHours.setLayout(null);
		ConcertSeanceHours.setBackground(Color.WHITE);

		JRadioButton rdbtn01 = new JRadioButton("10:00 ");
		rdbtn01.setBounds(6, 6, 103, 21);
		rdbtn01.setActionCommand(rdbtn01.getText());
		ConcertSeanceHours.add(rdbtn01);

		JRadioButton rdbtn12 = new JRadioButton("11:00");
		rdbtn12.setBounds(122, 6, 103, 21);
		rdbtn12.setActionCommand(rdbtn12.getText());
		ConcertSeanceHours.add(rdbtn12);

		JRadioButton rdbtn23 = new JRadioButton("12:00");
		rdbtn23.setBounds(238, 6, 103, 21);
		rdbtn23.setActionCommand(rdbtn23.getText());
		ConcertSeanceHours.add(rdbtn23);

		JRadioButton rdbtn89 = new JRadioButton("18:00");
		rdbtn89.setBounds(238, 76, 103, 21);
		rdbtn89.setActionCommand(rdbtn89.getText());
		ConcertSeanceHours.add(rdbtn89);

		JRadioButton rdbtn78 = new JRadioButton("17:00");
		rdbtn78.setBounds(122, 76, 103, 21);
		rdbtn78.setActionCommand(rdbtn78.getText());
		ConcertSeanceHours.add(rdbtn78);

		JRadioButton rdbtn67 = new JRadioButton("16:00");
		rdbtn67.setBounds(6, 76, 103, 21);
		rdbtn67.setActionCommand(rdbtn67.getText());
		ConcertSeanceHours.add(rdbtn67);

		JRadioButton rdbtn112 = new JRadioButton("21:00");
		rdbtn112.setBounds(238, 112, 103, 21);
		rdbtn112.setActionCommand(rdbtn112.getText());
		ConcertSeanceHours.add(rdbtn112);

		JRadioButton rdbtn101 = new JRadioButton("20:00");
		rdbtn101.setBounds(122, 112, 103, 21);
		rdbtn101.setActionCommand(rdbtn101.getText());
		ConcertSeanceHours.add(rdbtn101);

		JRadioButton rdbtn910 = new JRadioButton("19:00");
		rdbtn910.setBounds(6, 112, 103, 21);
		rdbtn910.setActionCommand(rdbtn910.getText());
		ConcertSeanceHours.add(rdbtn910);

		JRadioButton rdbtn56 = new JRadioButton("15:00");
		rdbtn56.setBounds(238, 41, 103, 21);
		rdbtn56.setActionCommand(rdbtn56.getText());
		ConcertSeanceHours.add(rdbtn56);

		JRadioButton rdbtn45 = new JRadioButton("14:00");
		rdbtn45.setBounds(122, 41, 103, 21);
		rdbtn45.setActionCommand(rdbtn45.getText());
		ConcertSeanceHours.add(rdbtn45);

		JRadioButton rdbtn34 = new JRadioButton("13:00");
		rdbtn34.setBounds(6, 41, 103, 21);
		rdbtn34.setActionCommand(rdbtn34.getText());
		ConcertSeanceHours.add(rdbtn34);
	
		
		
		JButton btn_AddConcert = new JButton("Konser Ekle");
		btn_AddConcert.setBounds(141, 396, 138, 31);
		paneAddConcert.add(btn_AddConcert);

		JLabel lbl_ConcertPitcure = new JLabel("");
		lbl_ConcertPitcure.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ConcertPitcure.setBounds(288, 10, 125, 148);
		paneAddConcert.add(lbl_ConcertPitcure);

		JLabel lbl_TicketCount = new JLabel("Bilet Adeti:");
		lbl_TicketCount.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TicketCount.setBounds(10, 145, 102, 28);
		paneAddConcert.add(lbl_TicketCount);

		txt_TicketCount = new JTextField();
		txt_TicketCount.setColumns(10);
		txt_TicketCount.setBounds(111, 148, 70, 20);
		paneAddConcert.add(txt_TicketCount);

		JLabel lbl_TicketPrice = new JLabel("Bilet Fiyati:");
		lbl_TicketPrice.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TicketPrice.setBounds(10, 178, 102, 28);
		paneAddConcert.add(lbl_TicketPrice);

		txt_TicketPrice = new JTextField();
		txt_TicketPrice.setColumns(10);
		txt_TicketPrice.setBounds(111, 182, 70, 20);
		paneAddConcert.add(txt_TicketPrice);
		ButtonGroup bgg3 = new ButtonGroup();
		bgg3.add(rdbtn01);
		bgg3.add(rdbtn12);
		bgg3.add(rdbtn23);
		bgg3.add(rdbtn34);
		bgg3.add(rdbtn45);
		bgg3.add(rdbtn56);
		bgg3.add(rdbtn67);
		bgg3.add(rdbtn78);
		bgg3.add(rdbtn89);
		bgg3.add(rdbtn910);
		bgg3.add(rdbtn101);
		bgg3.add(rdbtn112);
		
		JLabel lbl_ArtistName_1_1 = new JLabel("TL");
		lbl_ArtistName_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ArtistName_1_1.setBounds(186, 177, 46, 28);
		paneAddConcert.add(lbl_ArtistName_1_1);
		btn_AddConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String seance = "";

				if (rdbtn01.isSelected()) {
					seance = rdbtn01.getText();
				}
				if (rdbtn12.isSelected()) {
					seance = rdbtn12.getText();
				}
				if (rdbtn23.isSelected()) {
					seance = rdbtn23.getText();
				}
				if (rdbtn34.isSelected()) {
					seance = rdbtn34.getText();
				}
				if (rdbtn45.isSelected()) {
					seance = rdbtn45.getText();
				}
				if (rdbtn56.isSelected()) {
					seance = rdbtn56.getText();
				}
				if (rdbtn67.isSelected()) {
					seance = rdbtn67.getText();
				}
				if (rdbtn78.isSelected()) {
					seance = rdbtn78.getText();
				}
				if (rdbtn89.isSelected()) {
					seance = rdbtn89.getText();
				}
				if (rdbtn910.isSelected()) {
					seance = rdbtn910.getText();
				}
				if (rdbtn101.isSelected()) {
					seance = rdbtn101.getText();
				}
				if (rdbtn112.isSelected()) {
					seance = rdbtn112.getText();
				}

				if (txt_ConcertName.getText().length() == 0 || txt_ConcertType.getText().length() == 0 || txt_TicketCount.getText().length()==0
						|| txt_TicketPrice.getText().length()==0
						|| combo_ConcertPlace.getSelectedIndex() == -1 || dateChooser3.getDate() == null
						|| seance.length() == 0) {
					Metod_Helper.showMsg("fill");
					if (seance == "") {
						Metod_Helper.showMsg("Lutfen Seans seciniz!");
					}
				} else {

					String cboxConcertPlace = String.valueOf(combo_ConcertPlace.getSelectedItem());

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String dateConcert = dateFormat.format(dateChooser3.getDate());

					String selConcertSaat = "" + bgg3.getSelection().getActionCommand();

					try {
						boolean control = subadmin.addConcert(txt_ConcertName.getText(), cboxConcertPlace,
								txt_ConcertType.getText(), dateConcert, selConcertSaat,Integer.parseInt(txt_TicketCount.getText()),txt_TicketPrice.getText());
						if (control) {
							Metod_Helper.showMsg("succes");
							txt_ConcertName.setText(null);
							txt_ConcertType.setText(null);
							txt_TicketCount.setText(null);
							txt_TicketPrice.setText(null);
							cboxConcertPlace = null;
							dateConcert = null;
							selConcertSaat = null;
							updateConcertList();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		});

		paneAddConcert.setVisible(false);
		btn_AddTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String seance = "";

				if (rdbtn02.isSelected()) {
					seance = rdbtn02.getText();
				}
				if (rdbtn13.isSelected()) {
					seance = rdbtn13.getText();
				}
				if (rdbtn24.isSelected()) {
					seance = rdbtn24.getText();
				}
				if (rdbtn35.isSelected()) {
					seance = rdbtn35.getText();
				}
				if (rdbtn46.isSelected()) {
					seance = rdbtn46.getText();
				}
				if (rdbtn57.isSelected()) {
					seance = rdbtn57.getText();
				}
				if (rdbtn68.isSelected()) {
					seance = rdbtn68.getText();
				}
				if (rdbtn79.isSelected()) {
					seance = rdbtn79.getText();
				}
				if (rdbtn810.isSelected()) {
					seance = rdbtn810.getText();
				}
				if (rdbtn911.isSelected()) {
					seance = rdbtn911.getText();
				}
				if (rdbtn102.isSelected()) {
					seance = rdbtn102.getText();
				}
				if (rdbtn111.isSelected()) {
					seance = rdbtn111.getText();
				}

				if (txt_TheaterName.getText().length() == 0 || comboBox_TheaterType.getSelectedIndex() == -1
						|| comboBox_Salon2.getSelectedIndex() == -1 || dateChooser2.getDate() == null
						|| seance.length() == 0) {
					Metod_Helper.showMsg("fill");
					if (seance == "") {
						Metod_Helper.showMsg("Lutfen Seans seciniz!");
					}
				} else {

					String cboxTheaterType = String.valueOf(comboBox_TheaterType.getSelectedItem());
					String cboxTheaterSalon = String.valueOf(comboBox_Salon2.getSelectedItem());

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String dateTheater = dateFormat.format(dateChooser2.getDate());

					String selSaat = "" + bgg2.getSelection().getActionCommand();

					try {
						boolean control = subadmin.addTheater(txt_TheaterName.getText(), cboxTheaterType, dateTheater,
								cboxTheaterSalon, selSaat);
						if (control) {
							Metod_Helper.showMsg("succes");
							txt_TheaterName = null;
							cboxTheaterType = null;
							cboxTheaterSalon = null;
							dateTheater = null;
							selSaat = null;
							updateTheaterList();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		paneAddTheater.setVisible(false);

		
		//////////////////////////////////// PaneConcert////////////////////////////////////////////////////////////////////

		tabbedPane.addChangeListener((ChangeListener) new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					paneAddCinema.setVisible(true);
					paneAddTheater.setVisible(false);
					paneAddConcert.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 1) {
					paneAddTheater.setVisible(true);
					paneAddCinema.setVisible(false);
					paneAddConcert.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					paneAddCinema.setVisible(false);
					paneAddTheater.setVisible(false);
					paneAddConcert.setVisible(true);
				}

			}

		});

	}

	public static void updateCinemaList() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_Cinema.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < subadmin.cinemaList().size(); i++) {
			cinemaData[0] = subadmin.cinemaList().get(i).getFilmID();
			cinemaData[1] = subadmin.cinemaList().get(i).getFilmName();
			cinemaData[2] = subadmin.cinemaList().get(i).getFilmType();
			cinemaData[3] = subadmin.cinemaList().get(i).getFilmDirector();
			cinemaData[4] = subadmin.cinemaList().get(i).getFilmDate();
			cinemaData[5] = subadmin.cinemaList().get(i).getFilmSalon();
			cinemaData[6] = subadmin.cinemaList().get(i).getFilmSeans();
			cinemaModel.addRow(cinemaData);
		}
	}

	public static void updateTheaterList() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_Theater.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < subadmin.theaterList().size(); i++) {
			theaterData[0] = subadmin.theaterList().get(i).getTiyatroID();
			theaterData[1] = subadmin.theaterList().get(i).getTiyatroName();
			theaterData[2] = subadmin.theaterList().get(i).getTiyatroType();
			theaterData[3] = subadmin.theaterList().get(i).getTiyatroDate();
			theaterData[4] = subadmin.theaterList().get(i).getTiyatroSalon();
			theaterData[5] = subadmin.theaterList().get(i).getTiyatroSaat();
			theaterModel.addRow(theaterData);
		}
	}

	public static void updateConcertList() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_Concert.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < subadmin.concertList().size(); i++) {
			concertData[0] = subadmin.concertList().get(i).getConcertID();
			concertData[1] = subadmin.concertList().get(i).getConcertName();
			concertData[2] = subadmin.concertList().get(i).getConcertPlace();
			concertData[3] = subadmin.concertList().get(i).getConcertArtist();
			concertData[4] = subadmin.concertList().get(i).getConcertDate();
			concertData[5] = subadmin.concertList().get(i).getConcertTime();
			concertData[6] = subadmin.concertList().get(i).getTicketCount();
			concertData[7] = subadmin.concertList().get(i).getTicketPrice();
			concertModel.addRow(concertData);
		}
	}
}

//
