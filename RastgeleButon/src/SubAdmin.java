import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import Helper.DbHelper;
import Helper.Metod_Helper;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
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
	private JTextField txt_MovieName;
	private JTextField txt_MovieDirector;
	private static user sub = new user();
	private static SubACinema sinema = new SubACinema();
	private static SubATheater tiyatro = new SubATheater();
	private static SubAConcert konser = new SubAConcert();
	private JTextField text_image;
	Connection connection = null;
	DbHelper dbHelper = new DbHelper();
	Statement statement;

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
		btn_ShowRemoval.setBounds(100, 438, 142, 34);
		contentPane.add(btn_ShowRemoval);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.CYAN);
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tabbedPane.setBounds(0, 41, 407, 356);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sinema", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scroll_Cinema = new JScrollPane();
		scroll_Cinema.setBounds(10, 10, 400, 337);
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
		scroll_Theater.setBounds(0, 0, 400, 327);
		
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
			theaterData[0] = tiyatro.theaterList().get(j).getTiyatroName();
			theaterData[1] = tiyatro.theaterList().get(j).getTiyatroType();
			theaterData[2] = tiyatro.theaterList().get(j).getTiyatroDate();
			theaterData[3] = tiyatro.theaterList().get(j).getTiyatroSalon();
			theaterData[4] = tiyatro.theaterList().get(j).getTiyatroSaat();
			theaterModel.addRow(theaterData);
		}

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(SystemColor.info);
		tabbedPane.addTab("Konser", null, w_paneConcert, null);
		w_paneConcert.setLayout(null);

		JScrollPane scroll_Concert = new JScrollPane();
		scroll_Concert.setBounds(0, 0, 400, 327);
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

		JPanel paneAddCinema = new JPanel();
		paneAddCinema.setBackground(SystemColor.inactiveCaption);
		paneAddCinema.setBounds(417, 41, 416, 372);
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

		JComboBox combo_MovieType = new JComboBox();
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

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tarih:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(10, 143, 102, 28);
		paneAddCinema.add(lblNewLabel_1_1_2_1);

		JComboBox comboBox_Salon = new JComboBox();
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
		lbl_Poster.setBounds(288, 10, 128, 161);
		paneAddCinema.add(lbl_Poster);

		JButton btn_ImageSelect = new JButton("Afi\u015F Se\u00E7");
		btn_ImageSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Bir Resim SeÃ§");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Resim DosyasÄ±", "jpg", "jpeg", "png");

				fs.setFileFilter(filter);
				int Adress = fs.showOpenDialog(null);
				if (Adress == JFileChooser.APPROVE_OPTION) {
					{
						
						ImageIcon imageIcon = new ImageIcon(fs.getSelectedFile().toString());
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance(128, 161, java.awt.Image.SCALE_SMOOTH);
					
						lbl_Poster.setIcon(new ImageIcon(newimg));
						BufferedImage bImage = null;
						try {
							File initialImage = new File(fs.getSelectedFile().toString());
							bImage = ImageIO.read(initialImage);
							ImageIO.write(bImage, "jpg",
									new File("C://Users/dogak/git/booking2/RastgeleButon/src/Images/image.png"));
						} catch (IOException j) {
							System.out.println("Exception occured :" + j.getMessage());
						}

					}
				}

			}
		});
		btn_ImageSelect.setBounds(314, 182, 102, 31);
		paneAddCinema.add(btn_ImageSelect);

		JLabel lblimage = new JLabel("Resim:");
		lblimage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblimage.setBounds(10, 181, 50, 28);
		paneAddCinema.add(lblimage);

		text_image = new JTextField();
		text_image.setBounds(111, 181, 138, 19);
		paneAddCinema.add(text_image);
		text_image.setColumns(10);

		JLabel lbl_CinemaSeance_1 = new JLabel("Seans:");
		lbl_CinemaSeance_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CinemaSeance_1.setBounds(10, 219, 46, 28);
		paneAddCinema.add(lbl_CinemaSeance_1);
		
		JPanel SeanceHours = new JPanel();
		SeanceHours.setBounds(59, 223, 347, 139);
		paneAddCinema.add(SeanceHours);
		SeanceHours.setLayout(null);
		SeanceHours.setBackground(Color.WHITE);
		
		JRadioButton rdbtn0 = new JRadioButton("10:00 ");
		rdbtn0.setBounds(6, 6, 103, 21);
		SeanceHours.add(rdbtn0);
		
		JRadioButton rdbtn1 = new JRadioButton("11:00");
		rdbtn1.setBounds(122, 6, 103, 21);
		SeanceHours.add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("12:00");
		rdbtn2.setBounds(238, 6, 103, 21);
		SeanceHours.add(rdbtn2);
		
		JRadioButton rdbtn8 = new JRadioButton("18:00");
		rdbtn8.setBounds(238, 76, 103, 21);
		SeanceHours.add(rdbtn8);
		
		JRadioButton rdbtn7 = new JRadioButton("17:00");
		rdbtn7.setBounds(122, 76, 103, 21);
		SeanceHours.add(rdbtn7);
		
		JRadioButton rdbtn6 = new JRadioButton("16:00");
		rdbtn6.setBounds(6, 76, 103, 21);
		SeanceHours.add(rdbtn6);
		
		JRadioButton rdbtn11 = new JRadioButton("21:00");
		rdbtn11.setBounds(238, 112, 103, 21);
		SeanceHours.add(rdbtn11);
		
		JRadioButton rdbtn10 = new JRadioButton("20:00");
		rdbtn10.setBounds(122, 112, 103, 21);
		SeanceHours.add(rdbtn10);
		
		JRadioButton rdbtn9 = new JRadioButton("19:00");
		rdbtn9.setBounds(6, 112, 103, 21);
		SeanceHours.add(rdbtn9);
		
		JRadioButton rdbtn5 = new JRadioButton("15:00");
		rdbtn5.setBounds(238, 41, 103, 21);
		SeanceHours.add(rdbtn5);
		
		JRadioButton rdbtn4 = new JRadioButton("14:00");
		rdbtn4.setBounds(122, 41, 103, 21);
		SeanceHours.add(rdbtn4);
		
		JRadioButton rdbtn3 = new JRadioButton("13:00");
		rdbtn3.setBounds(6, 41, 103, 21);
		SeanceHours.add(rdbtn3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtn0);
		bg.add(rdbtn1);
		bg.add(rdbtn2);
		bg.add(rdbtn3);
		bg.add(rdbtn4);
		bg.add(rdbtn5);
		bg.add(rdbtn6);
		bg.add(rdbtn7);
		bg.add(rdbtn8);
		bg.add(rdbtn9);
		bg.add(rdbtn10);
		bg.add(rdbtn11);
		
				JButton btn_AddCinema = new JButton("Film Ekle");
				btn_AddCinema.setBounds(568, 423, 138, 31);
				contentPane.add(btn_AddCinema);
				btn_AddCinema.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String seance="";
						if(rdbtn0.isSelected()) {seance=rdbtn0.getText();}
						if(rdbtn1.isSelected()) {seance=rdbtn1.getText();}
						if(rdbtn2.isSelected()) {seance=rdbtn2.getText();}
						if(rdbtn3.isSelected()) {seance=rdbtn3.getText();}
						if(rdbtn4.isSelected()) {seance=rdbtn4.getText();}
						if(rdbtn5.isSelected()) {seance=rdbtn5.getText();}
						if(rdbtn6.isSelected()) {seance=rdbtn6.getText();}
						if(rdbtn7.isSelected()) {seance=rdbtn7.getText();}
						if(rdbtn8.isSelected()) {seance=rdbtn8.getText();}
						if(rdbtn9.isSelected()) {seance=rdbtn9.getText();}
						if(rdbtn10.isSelected()) {seance=rdbtn10.getText();}
						if(rdbtn11.isSelected()) {seance=rdbtn11.getText();}
						
						if(seance!="")
						{
											
							Metod_Helper.showMsg("Seans baþarýyla kaydedildi");
						}
						else if(seance=="")
						{
							Metod_Helper.showMsg("Lütfen Seans seçiniz!");
						}
					}
				});
	}
}

//