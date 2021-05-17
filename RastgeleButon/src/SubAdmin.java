import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

//SubAdmin Boþ güncelleme
public class SubAdmin extends JFrame {
	private DefaultTableModel cinemaModel;
	private DefaultTableModel theaterModel;
	private DefaultTableModel concertModel;
	private Object[] cinemaData = null;
	private Object[] concertData = null;
	private Object[] theaterData = null;
	private JPanel contentPane;
	private JTable table_Cinema;
	private JTable table_Theater;
	private JTable table_Concert;
	private JTextField txt_TheaterName;
	private JTextField txt_TheaterType;
	private JTextField txt_ConcertName;
	private JTextField txt_ConcertType;
	private JButton btn_ImageSelect;
	private JLabel lbl_Poster;

	private static user sub = new user();
	private static SubACinema sinema = new SubACinema();
	private static SubATheater tiyatro = new SubATheater();
	private static SubAConcert konser = new SubAConcert();
	private JTextField text_image;
	private JTextField text_image2;
	private JTextField text_image3;
	DbHelper dbhelper = new DbHelper();
	Connection connection = null;
	PreparedStatement pStatement;
	private JTextField txt_MovieName;
	private JTextField txt_MovieDirector;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cinemaModel = new DefaultTableModel();
		Object[] colCinema = new Object[5];
		colCinema[0] = "Film Adý";
		colCinema[1] = "Film Türü";
		colCinema[2] = "Yönetmen";
		colCinema[3] = "Salon";
		colCinema[4] = "Seans";

		cinemaModel.setColumnIdentifiers(colCinema);
		cinemaData = new Object[5];

		concertModel = new DefaultTableModel();
		Object[] colConcert = new Object[4];
		colConcert[0] = "Konser Adý";
		colConcert[1] = "Konser Türü";
		colConcert[2] = "Tarih";
		colConcert[3] = "Saat";

		concertModel.setColumnIdentifiers(colConcert);
		concertData = new Object[4];

		theaterModel = new DefaultTableModel();
		Object[] colTheater = new Object[5];
		colTheater[0] = "Oyun Adý";
		colTheater[1] = "Oyun Türü";
		colTheater[2] = "Tarih";
		colTheater[3] = "Salon";
		colTheater[4] = "Saat";

		theaterModel.setColumnIdentifiers(colTheater);
		theaterData = new Object[5];

		JButton btn_ShowRemoval = new JButton("Gösteri Çýkar");
		btn_ShowRemoval.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_ShowRemoval.setBounds(99, 422, 142, 34);
		contentPane.add(btn_ShowRemoval);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.CYAN);
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tabbedPane.setBounds(0, 41, 407, 371);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sinema", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scroll_Cinema = new JScrollPane();
		scroll_Cinema.setBounds(0, 0, 400, 347);
		w_paneCinema.add(scroll_Cinema);

		table_Cinema = new JTable(cinemaModel);
		table_Cinema.getColumn("Film Adý").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Film Türü").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Yönetmen").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Salon").setCellEditor(new TableEditor(new JCheckBox()));
		table_Cinema.getColumn("Seans").setCellEditor(new TableEditor(new JCheckBox()));
		scroll_Cinema.setViewportView(table_Cinema);
		table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(0).setResizable(false);
		table_Cinema.getColumnModel().getColumn(1).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(1).setResizable(false);
		table_Cinema.getColumnModel().getColumn(2).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(2).setResizable(false);
		table_Cinema.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(3).setResizable(false);
		table_Cinema.getColumnModel().getColumn(4).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(4).setResizable(false);

		for (int i = 0; i < sinema.cinemaList().size(); i++) {
			cinemaData[0] = sinema.cinemaList().get(i).getFilmName();
			cinemaData[1] = sinema.cinemaList().get(i).getFilmType();
			cinemaData[2] = sinema.cinemaList().get(i).getFilmDirector();
			cinemaData[3] = sinema.cinemaList().get(i).getFilmSalon();
			cinemaData[4] = sinema.cinemaList().get(i).getFilmSeans();
			cinemaModel.addRow(cinemaData);
		}

		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scroll_Theater = new JScrollPane();
		scroll_Theater.setBounds(0, 0, 400, 342);

		w_paneTheater.add(scroll_Theater);

		table_Theater = new JTable(theaterModel);
		table_Theater.getColumn("Oyun Adý").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Oyun Türü").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Tarih").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Salon").setCellEditor(new TableEditor(new JCheckBox()));
		table_Theater.getColumn("Saat").setCellEditor(new TableEditor(new JCheckBox()));
		scroll_Theater.setViewportView(table_Theater);
		table_Theater.getColumnModel().getColumn(0).setPreferredWidth(20);
		table_Theater.getColumnModel().getColumn(0).setResizable(false);
		table_Theater.getColumnModel().getColumn(1).setPreferredWidth(20);
		table_Theater.getColumnModel().getColumn(1).setResizable(false);
		table_Theater.getColumnModel().getColumn(2).setPreferredWidth(20);
		table_Theater.getColumnModel().getColumn(2).setResizable(false);
		table_Theater.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_Theater.getColumnModel().getColumn(3).setResizable(false);
		table_Theater.getColumnModel().getColumn(4).setPreferredWidth(20);
		table_Theater.getColumnModel().getColumn(4).setResizable(false);

		for (int j = 0; j < tiyatro.theaterList().size(); j++) {
			theaterData[0] = tiyatro.theaterList().get(j).getTheaterName();
			theaterData[1] = tiyatro.theaterList().get(j).getTheaterType();
			theaterData[2] = tiyatro.theaterList().get(j).getTheaterDate();
			theaterData[3] = tiyatro.theaterList().get(j).getTheaterSalon();
			theaterData[4] = tiyatro.theaterList().get(j).getTheaterHour();
			theaterModel.addRow(theaterData);
		}

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(SystemColor.info);
		tabbedPane.addTab("Konser", null, w_paneConcert, null);
		w_paneConcert.setLayout(null);

		JScrollPane scroll_Concert = new JScrollPane();
		scroll_Concert.setBounds(0, 0, 400, 342);
		w_paneConcert.add(scroll_Concert);

		table_Concert = new JTable(concertModel);
		scroll_Concert.setViewportView(table_Concert);
		table_Concert.getColumnModel().getColumn(0).setResizable(false);
		table_Concert.getColumnModel().getColumn(1).setPreferredWidth(20);
		table_Concert.getColumnModel().getColumn(1).setResizable(false);
		table_Concert.getColumnModel().getColumn(2).setPreferredWidth(20);
		table_Concert.getColumnModel().getColumn(2).setResizable(false);
		table_Concert.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_Concert.getColumnModel().getColumn(3).setResizable(false);

		for (int k = 0; k < konser.concertList().size(); k++) {
			concertData[0] = konser.concertList().get(k).getConcertName();
			concertData[1] = konser.concertList().get(k).getConcertType();
			concertData[2] = konser.concertList().get(k).getConcertDate();
			concertData[3] = konser.concertList().get(k).getConcertTime();
			concertModel.addRow(concertData);
		}

/////////////////////////////PANECÝNEMA///////////////////////////////////////////////////////////////////////////

		JPanel paneAddCinema = new JPanel();
		paneAddCinema.setBackground(new Color(224, 255, 255));
		paneAddCinema.setBounds(417, 41, 416, 438);
		contentPane.add(paneAddCinema);
		paneAddCinema.setLayout(null);

		JLabel lbl_MovieName = new JLabel("Film Adi:");
		lbl_MovieName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 10, 102, 28);
		paneAddCinema.add(lbl_MovieName);

		JLabel lbl_FilmDirector = new JLabel("Yönetmen:");
		lbl_FilmDirector.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_FilmDirector.setBounds(10, 45, 102, 28);
		paneAddCinema.add(lbl_FilmDirector);

		JLabel lbl_MovieType = new JLabel("Film Türü:");
		lbl_MovieType.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MovieType.setBounds(10, 72, 102, 28);
		paneAddCinema.add(lbl_MovieType);

		JLabel lbl_CinemaSalon = new JLabel("Salon:");
		lbl_CinemaSalon.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_CinemaSalon.setBounds(10, 110, 102, 28);
		paneAddCinema.add(lbl_CinemaSalon);

		txt_MovieName = new JTextField();
		txt_MovieName.setBounds(111, 17, 138, 19);
		paneAddCinema.add(txt_MovieName);
		txt_MovieName.setColumns(10);

		txt_MovieDirector = new JTextField();
		txt_MovieDirector.setColumns(10);
		txt_MovieDirector.setBounds(111, 48, 138, 23);
		paneAddCinema.add(txt_MovieDirector);

		JComboBox<String> combo_MovieType = new JComboBox<String>();
		combo_MovieType.setBounds(111, 78, 138, 21);
		paneAddCinema.add(combo_MovieType);
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
//------------------------------------------------------------------------------------------foto ekleme alaný bozma :)
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = dbhelper.getConnection();
					pStatement = connection.prepareStatement("update cinema set pic=? where filmID =?");

					JFileChooser jfc = new JFileChooser();
					jfc.showOpenDialog(null);
					File file = jfc.getSelectedFile();

					FileInputStream fis = new FileInputStream(file);
					pStatement.setBinaryStream(1, fis, fis.available());
					pStatement.setString(2,"1");
					
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

		JLabel lbl_Image = new JLabel("Resim:");
		lbl_Image.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Image.setBounds(10, 181, 50, 28);
		paneAddCinema.add(lbl_Image);

		text_image = new JTextField();
		text_image.setBounds(111, 181, 138, 19);
		paneAddCinema.add(text_image);
		text_image.setColumns(10);

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
		SeanceHours3.add(rdbtn0_0_0);

		JRadioButton rdbtn1_1_1 = new JRadioButton("11:00");
		rdbtn1_1_1.setBounds(122, 6, 103, 21);
		SeanceHours3.add(rdbtn1_1_1);

		JRadioButton rdbtn2_2_2 = new JRadioButton("12:00");
		rdbtn2_2_2.setBounds(238, 6, 103, 21);
		SeanceHours3.add(rdbtn2_2_2);

		JRadioButton rdbtn8_8_8 = new JRadioButton("18:00");
		rdbtn8_8_8.setBounds(238, 76, 103, 21);
		SeanceHours3.add(rdbtn8_8_8);

		JRadioButton rdbtn7_7_7 = new JRadioButton("17:00");
		rdbtn7_7_7.setBounds(122, 76, 103, 21);
		SeanceHours3.add(rdbtn7_7_7);

		JRadioButton rdbtn6_6_6 = new JRadioButton("16:00");
		rdbtn6_6_6.setBounds(6, 76, 103, 21);
		SeanceHours3.add(rdbtn6_6_6);

		JRadioButton rdbtn11_1_1 = new JRadioButton("21:00");
		rdbtn11_1_1.setBounds(238, 112, 103, 21);
		SeanceHours3.add(rdbtn11_1_1);

		JRadioButton rdbtn10_0_0 = new JRadioButton("20:00");
		rdbtn10_0_0.setBounds(122, 112, 103, 21);
		SeanceHours3.add(rdbtn10_0_0);

		JRadioButton rdbtn9_9_9 = new JRadioButton("19:00");
		rdbtn9_9_9.setBounds(6, 112, 103, 21);
		SeanceHours3.add(rdbtn9_9_9);

		JRadioButton rdbtn5_5_5 = new JRadioButton("15:00");
		rdbtn5_5_5.setBounds(238, 41, 103, 21);
		SeanceHours3.add(rdbtn5_5_5);

		JRadioButton rdbtn4_4_4 = new JRadioButton("14:00");
		rdbtn4_4_4.setBounds(122, 41, 103, 21);
		SeanceHours3.add(rdbtn4_4_4);

		JRadioButton rdbtn3_3_3 = new JRadioButton("13:00");
		rdbtn3_3_3.setBounds(6, 41, 103, 21);
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
				if (rdbtn3_3_3.isSelected()) {
					seance = rdbtn3_3_3.getText();
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

				if (seance != "") {

					Metod_Helper.showMsg("Seans baþarýyla kaydedildi");
				} else if (seance == "") {
					Metod_Helper.showMsg("Lütfen Seans seçiniz!");
				}
			}
		});

///////////////////////////////////////////////////////////////PaneCinema//////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////// PaneTheater


		JPanel paneAddTheater = new JPanel();
		paneAddTheater.setBackground(new Color(221, 160, 221));
		paneAddTheater.setBounds(417, 41, 416, 438);
		contentPane.add(paneAddTheater);
		paneAddTheater.setLayout(null);

		JLabel lbl_TheaterName = new JLabel("Oyun Adi:");
		lbl_TheaterName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TheaterName.setBounds(10, 10, 102, 28);
		paneAddTheater.add(lbl_TheaterName);

		JLabel lbl_TheaterType = new JLabel("Oyun T\u00FCr\u00FC");
		lbl_TheaterType.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TheaterType.setBounds(10, 45, 102, 28);
		paneAddTheater.add(lbl_TheaterType);

		JLabel lbl_TheaterSalon = new JLabel("Salon:");
		lbl_TheaterSalon.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_TheaterSalon.setBounds(10, 78, 102, 28);
		paneAddTheater.add(lbl_TheaterSalon);

		txt_TheaterName = new JTextField();
		txt_TheaterName.setBounds(111, 17, 138, 19);
		paneAddTheater.add(txt_TheaterName);
		txt_TheaterName.setColumns(10);

		txt_TheaterType = new JTextField();
		txt_TheaterType.setColumns(10);
		txt_TheaterType.setBounds(111, 48, 138, 23);
		paneAddTheater.add(txt_TheaterType);

		JLabel lbl_TheaterDate = new JLabel("Tarih:");
		lbl_TheaterDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TheaterDate.setBounds(10, 115, 102, 28);
		paneAddTheater.add(lbl_TheaterDate);
		///////////////////////// Trrrrrrrrrrrrrrrr
		JComboBox<String> comboBox_Salon2 = new JComboBox<String>();
		comboBox_Salon2.setBounds(111, 84, 138, 21);
		paneAddTheater.add(comboBox_Salon2);
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
				// ekleme alaný bozma :)
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = dbhelper.getConnection();
					pStatement = connection.prepareStatement("insert into cinema(pic) values(?)");

					JFileChooser jfc2 = new JFileChooser();
					jfc2.showOpenDialog(null);
					File file2 = jfc2.getSelectedFile();

					FileInputStream fis2 = new FileInputStream(file2);
					pStatement.setBinaryStream(1, fis2, fis2.available());

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

		JLabel lbl_Image2 = new JLabel("Resim:");
		lbl_Image2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Image2.setBounds(10, 153, 50, 19);
		paneAddTheater.add(lbl_Image2);

		text_image2 = new JTextField();
		text_image2.setBounds(111, 153, 138, 19);
		paneAddTheater.add(text_image2);
		text_image2.setColumns(10);

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
		TheaterSeanceHours.add(rdbtn02);

		JRadioButton rdbtn13 = new JRadioButton("11:00");
		rdbtn13.setBounds(122, 6, 103, 21);
		TheaterSeanceHours.add(rdbtn13);

		JRadioButton rdbtn24 = new JRadioButton("12:00");
		rdbtn24.setBounds(238, 6, 103, 21);
		TheaterSeanceHours.add(rdbtn24);

		JRadioButton rdbtn810 = new JRadioButton("18:00");
		rdbtn810.setBounds(238, 76, 103, 21);
		TheaterSeanceHours.add(rdbtn810);

		JRadioButton rdbtn79 = new JRadioButton("17:00");
		rdbtn79.setBounds(122, 76, 103, 21);
		TheaterSeanceHours.add(rdbtn79);

		JRadioButton rdbtn68 = new JRadioButton("16:00");
		rdbtn68.setBounds(6, 76, 103, 21);
		TheaterSeanceHours.add(rdbtn68);

		JRadioButton rdbtn111 = new JRadioButton("21:00");
		rdbtn111.setBounds(238, 112, 103, 21);
		TheaterSeanceHours.add(rdbtn111);

		JRadioButton rdbtn102 = new JRadioButton("20:00");
		rdbtn102.setBounds(122, 112, 103, 21);
		TheaterSeanceHours.add(rdbtn102);

		JRadioButton rdbtn911 = new JRadioButton("19:00");
		rdbtn911.setBounds(6, 112, 103, 21);
		TheaterSeanceHours.add(rdbtn911);

		JRadioButton rdbtn57 = new JRadioButton("15:00");
		rdbtn57.setBounds(238, 41, 103, 21);
		TheaterSeanceHours.add(rdbtn57);

		JRadioButton rdbtn46 = new JRadioButton("14:00");
		rdbtn46.setBounds(122, 41, 103, 21);
		TheaterSeanceHours.add(rdbtn46);

		JRadioButton rdbtn35 = new JRadioButton("13:00");
		rdbtn35.setBounds(6, 41, 103, 21);
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
				if (rdbtn35.isSelected()) {
					seance = rdbtn35.getText();
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

				if (seance != "") {

					Metod_Helper.showMsg("Seans baþarýyla kaydedildi");
				} else if (seance == "") {
					Metod_Helper.showMsg("Lütfen Seans seçiniz!");
				}
			}
		});
		paneAddTheater.setVisible(false);

		//////////////////////////////////// PaneTheater////////////////////////////////////////////////////////////////////
		///////////////////////////// PaneConcert
		
		JPanel paneAddConcert = new JPanel();
		paneAddConcert.setBackground(new Color(143, 188, 143));
		paneAddConcert.setBounds(417, 43, 416, 438);
		contentPane.add(paneAddConcert);
		paneAddConcert.setLayout(null);

		JLabel lbl_ConcertName = new JLabel("Konser Ad\u0131:");
		lbl_ConcertName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ConcertName.setBounds(10, 10, 102, 28);
		paneAddConcert.add(lbl_ConcertName);

		JLabel lbl_ArtistName = new JLabel("Sanat\u00E7\u0131 Ad\u0131:");
		lbl_ArtistName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ArtistName.setBounds(10, 45, 102, 28);
		paneAddConcert.add(lbl_ArtistName);

		txt_ConcertName = new JTextField();
		txt_ConcertName.setBounds(111, 17, 138, 23);
		paneAddConcert.add(txt_ConcertName);
		txt_ConcertName.setColumns(10);

		txt_ConcertType = new JTextField();
		txt_ConcertType.setColumns(10);
		txt_ConcertType.setBounds(111, 48, 138, 23);
		paneAddConcert.add(txt_ConcertType);

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
//------------------------------------------------------------------------------------------foto ekleme alaný bozma :)
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = dbhelper.getConnection();
					pStatement = connection.prepareStatement("insert into cinema(pic) values(?)");

					JFileChooser jfc3 = new JFileChooser();
					jfc3.showOpenDialog(null);
					File file3 = jfc3.getSelectedFile();

					FileInputStream fis3 = new FileInputStream(file3);
					pStatement.setBinaryStream(1, fis3, fis3.available());

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

		JLabel lbl_Image3 = new JLabel("Resim:");
		lbl_Image3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Image3.setBounds(10, 153, 50, 23);
		paneAddConcert.add(lbl_Image3);

		text_image3 = new JTextField();
		text_image3.setBounds(111, 153, 138, 19);
		paneAddConcert.add(text_image3);
		text_image3.setColumns(10);

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

		ButtonGroup bgg3 = new ButtonGroup();

		JRadioButton rdbtn01 = new JRadioButton("10:00 ");
		rdbtn01.setBounds(6, 6, 103, 21);
		ConcertSeanceHours.add(rdbtn01);

		JRadioButton rdbtn12 = new JRadioButton("11:00");
		rdbtn12.setBounds(122, 6, 103, 21);
		ConcertSeanceHours.add(rdbtn12);

		JRadioButton rdbtn23 = new JRadioButton("12:00");
		rdbtn23.setBounds(238, 6, 103, 21);
		ConcertSeanceHours.add(rdbtn23);

		JRadioButton rdbtn89 = new JRadioButton("18:00");
		rdbtn89.setBounds(238, 76, 103, 21);
		ConcertSeanceHours.add(rdbtn89);

		JRadioButton rdbtn78 = new JRadioButton("17:00");
		rdbtn78.setBounds(122, 76, 103, 21);
		ConcertSeanceHours.add(rdbtn78);

		JRadioButton rdbtn67 = new JRadioButton("16:00");
		rdbtn67.setBounds(6, 76, 103, 21);
		ConcertSeanceHours.add(rdbtn67);

		JRadioButton rdbtn112 = new JRadioButton("21:00");
		rdbtn112.setBounds(238, 112, 103, 21);
		ConcertSeanceHours.add(rdbtn112);

		JRadioButton rdbtn101 = new JRadioButton("20:00");
		rdbtn101.setBounds(122, 112, 103, 21);
		ConcertSeanceHours.add(rdbtn101);

		JRadioButton rdbtn910 = new JRadioButton("19:00");
		rdbtn910.setBounds(6, 112, 103, 21);
		ConcertSeanceHours.add(rdbtn910);

		JRadioButton rdbtn56 = new JRadioButton("15:00");
		rdbtn56.setBounds(238, 41, 103, 21);
		ConcertSeanceHours.add(rdbtn56);

		JRadioButton rdbtn45 = new JRadioButton("14:00");
		rdbtn45.setBounds(122, 41, 103, 21);
		ConcertSeanceHours.add(rdbtn45);

		JRadioButton rdbtn34 = new JRadioButton("13:00");
		rdbtn34.setBounds(6, 41, 103, 21);
		ConcertSeanceHours.add(rdbtn34);

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
		JButton btn_AddConcert = new JButton("Konser Ekle");
		btn_AddConcert.setBounds(141, 396, 138, 31);
		paneAddConcert.add(btn_AddConcert);

		JLabel lbl_ArtistSurName = new JLabel("Konser Yeri:");
		lbl_ArtistSurName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ArtistSurName.setBounds(10, 83, 108, 28);
		paneAddConcert.add(lbl_ArtistSurName);
		
		JComboBox combo_ConcertPlace = new JComboBox();
		combo_ConcertPlace.setBounds(111, 83, 138, 21);
		paneAddConcert.add(combo_ConcertPlace);
		combo_ConcertPlace.addItem("Babylon");
		combo_ConcertPlace.addItem("Dorock XL");
		combo_ConcertPlace.addItem("Zorlu Center");
		combo_ConcertPlace.addItem("Wolkswagen Arena");
		combo_ConcertPlace.addItem("Jolly Joker");
		combo_ConcertPlace.addItem("Bronx Pi Sahne");
		combo_ConcertPlace.addItem("Shaft");
		
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
				if (rdbtn34.isSelected()) {
					seance = rdbtn34.getText();
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

				if (seance != "") {

					Metod_Helper.showMsg("Seans baþarýyla kaydedildi");
				} else if (seance == "") {
					Metod_Helper.showMsg("Lütfen Seans seçiniz!");
				}
			}
		});
		
		paneAddConcert.setVisible(false);
		
		
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
}

//