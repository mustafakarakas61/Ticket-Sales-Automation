import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	private JTextField txt_GameName;
	private JTextField txt_director;
	private JTextField txt_ConcertName;

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
		/////////////////////////////////////////PANECONCERT////////////////////////////////////////////////////////////////////////////////
		
		JPanel paneAddConcert = new JPanel();
		paneAddConcert.setBounds(417, 40, 416, 372);
		contentPane.add(paneAddConcert);
		paneAddConcert.setLayout(null);
		
		JLabel lbl_ConcertName = new JLabel("Konser Adi:");
		lbl_ConcertName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ConcertName.setBounds(10, 10, 102, 28);
		paneAddConcert.add(lbl_ConcertName);
		
		JLabel lbl_ConcertDirector = new JLabel("Sanat\u00E7\u0131:");
		lbl_ConcertDirector.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ConcertDirector.setBounds(10, 45, 102, 28);
		paneAddConcert.add(lbl_ConcertDirector);
		
		JLabel lbl_ConcertType = new JLabel("Oyun T\u00FCr\u00FC:");
		lbl_ConcertType.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_ConcertType.setBounds(10, 72, 102, 28);
		paneAddConcert.add(lbl_ConcertType);
		
				JLabel lbl_ConcertSalon = new JLabel("Salon:");
				lbl_ConcertSalon.setFont(new Font("Arial", Font.PLAIN, 15));
				lbl_ConcertSalon.setBounds(10, 110, 102, 28);
				paneAddConcert.add(lbl_ConcertSalon);
				
				txt_ConcertName = new JTextField();
				txt_ConcertName.setBounds(111, 17, 138, 19);
				paneAddConcert.add(txt_ConcertName);
				txt_ConcertName.setColumns(10);
				
				txt_director = new JTextField();
				txt_director.setColumns(10);
				txt_director.setBounds(111, 48, 138, 23);
				paneAddConcert.add(txt_director);
				
				JComboBox combo_ConcertType = new JComboBox();
				combo_ConcertType.setBounds(111, 77, 138, 21);
				paneAddConcert.add(combo_ConcertType);
				combo_ConcertType.addItem("Aksiyon");
				combo_ConcertType.addItem("Bilim/Kurgu");
				combo_ConcertType.addItem("Drama");
				combo_ConcertType.addItem("Fantezi");
				combo_ConcertType.addItem("Gerilim");
				combo_ConcertType.addItem("Gizem");
				combo_ConcertType.addItem("Komedi");
				combo_ConcertType.addItem("Korku");
				combo_ConcertType.addItem("Romantik");
				combo_ConcertType.addItem("Western");
		
				JLabel lblNewLabel_1_1_2_3 = new JLabel("Tarih:");
				lblNewLabel_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_1_1_2_3.setBounds(10, 143, 102, 28);
				paneAddConcert.add(lblNewLabel_1_1_2_3);
				
				JComboBox combo_Salon = new JComboBox();
				combo_Salon.setBounds(111, 110, 138, 21);
				paneAddConcert.add(combo_Salon);
				combo_Salon.addItem("A-1");
				combo_Salon.addItem("A-2");
				combo_Salon.addItem("A-3");
				combo_Salon.addItem("B-1");
				combo_Salon.addItem("B-2");
				combo_Salon.addItem("B-3");
				combo_Salon.addItem("C-1");
				combo_Salon.addItem("C-2");
				combo_Salon.addItem("C-3");
				
				JDateChooser dateChooser = new JDateChooser();
				dateChooser.setBounds(111, 147, 138, 20);
				paneAddConcert.add(dateChooser);
				
						JLabel lbl_Poster = new JLabel("");
						lbl_Poster.setBounds(288, 10, 128, 161);
						paneAddConcert.add(lbl_Poster);
						
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
						paneAddConcert.add(btn_ImageSelect);
						
								JLabel lblimage = new JLabel("Resim:");
								lblimage.setFont(new Font("Tahoma", Font.PLAIN, 14));
								lblimage.setBounds(10, 181, 50, 28);
								paneAddConcert.add(lblimage);
								
										text_image = new JTextField();
										text_image.setBounds(111, 181, 138, 19);
										paneAddConcert.add(text_image);
										text_image.setColumns(10);
										
												JLabel lbl_CinemaSeance_1 = new JLabel("Seans:");
												lbl_CinemaSeance_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
												lbl_CinemaSeance_1.setBounds(10, 219, 46, 28);
												paneAddConcert.add(lbl_CinemaSeance_1);
												
												JPanel SeanceHours = new JPanel();
												SeanceHours.setBounds(59, 223, 347, 139);
												paneAddConcert.add(SeanceHours);
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
												ButtonGroup bggg=new ButtonGroup();
												bggg.add(rdbtn0);
												bggg.add(rdbtn1);
												bggg.add(rdbtn2);
												bggg.add(rdbtn3);
												bggg.add(rdbtn4);
												bggg.add(rdbtn5);
												bggg.add(rdbtn6);
												bggg.add(rdbtn7);
												bggg.add(rdbtn8);
												bggg.add(rdbtn9);
												bggg.add(rdbtn10);
												bggg.add(rdbtn11);
												dateChooser.setBounds(111, 147, 138, 20);
												lbl_Poster.setBounds(288, 10, 128, 161);
									////////////////////////////////////////////////////////CONCERT////////////////////////////			
											
		/////////////////////////PANETHEATRE/////////////////////////////////
		JPanel paneAddTheatre = new JPanel();
		paneAddTheatre.setBounds(417, 41, 416, 372);
		contentPane.add(paneAddTheatre);
		paneAddTheatre.setLayout(null);
		
		JLabel lbl_GameName = new JLabel("Oyun Adi:");
		lbl_GameName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_GameName.setBounds(10, 10, 102, 28);
		paneAddTheatre.add(lbl_GameName);
		
		JLabel lbl_FilmDirector = new JLabel("Yönetmen:");
		lbl_FilmDirector.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_FilmDirector.setBounds(10, 45, 102, 28);
		paneAddTheatre.add(lbl_FilmDirector);
		
				JLabel lbl_GameType = new JLabel("Oyun T\u00FCr\u00FC:");
				lbl_GameType.setFont(new Font("Arial", Font.PLAIN, 15));
				lbl_GameType.setBounds(10, 72, 102, 28);
				paneAddTheatre.add(lbl_GameType);
				
						JLabel lbl_TheatreSalon = new JLabel("Salon:");
						lbl_TheatreSalon.setFont(new Font("Arial", Font.PLAIN, 15));
						lbl_TheatreSalon.setBounds(10, 110, 102, 28);
						paneAddTheatre.add(lbl_TheatreSalon);
						
						txt_GameName = new JTextField();
						txt_GameName.setBounds(111, 17, 138, 19);
						paneAddTheatre.add(txt_GameName);
						txt_GameName.setColumns(10);
						
						txt_director = new JTextField();
						txt_director.setColumns(10);
						txt_director.setBounds(111, 48, 138, 23);
						paneAddTheatre.add(txt_director);
						
						JComboBox combo_GameType = new JComboBox();
						combo_GameType.setBounds(111, 77, 138, 21);
						paneAddTheatre.add(combo_GameType);
						combo_GameType.addItem("Aksiyon");
						combo_GameType.addItem("Bilim/Kurgu");
						combo_GameType.addItem("Drama");
						combo_GameType.addItem("Fantezi");
						combo_GameType.addItem("Gerilim");
						combo_GameType.addItem("Gizem");
						combo_GameType.addItem("Komedi");
						combo_GameType.addItem("Korku");
						combo_GameType.addItem("Romantik");
						combo_GameType.addItem("Western");
						
						JLabel lblNewLabel_1_1_2_1 = new JLabel("Tarih:");
						lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblNewLabel_1_1_2_1.setBounds(10, 143, 102, 28);
						paneAddTheatre.add(lblNewLabel_1_1_2_1);
						
						JComboBox combo_Saloon = new JComboBox();
						combo_Saloon.setBounds(111, 110, 138, 21);
						paneAddTheatre.add(combo_Saloon);
						combo_Saloon.addItem("A-1");
						combo_Saloon.addItem("A-2");
						combo_Saloon.addItem("A-3");
						combo_Saloon.addItem("B-1");
						combo_Saloon.addItem("B-2");
						combo_Saloon.addItem("B-3");
						combo_Saloon.addItem("C-1");
						combo_Saloon.addItem("C-2");
						combo_Saloon.addItem("C-3");
						
						JDateChooser dateChooserr = new JDateChooser();
						dateChooserr.setBounds(111, 147, 138, 20);
						paneAddTheatre.add(dateChooserr);
						
								JLabel lbl_Posterr = new JLabel("");
								lbl_Posterr.setBounds(288, 10, 128, 161);
								paneAddTheatre.add(lbl_Posterr);
								
								JButton btn_ImageSelectt = new JButton("Afi\u015F Se\u00E7");
								btn_ImageSelectt.addActionListener(new ActionListener() {
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
								
								btn_ImageSelectt.setBounds(314, 182, 102, 31);
								paneAddTheatre.add(btn_ImageSelectt);
								
										JLabel lblimagee = new JLabel("Resim:");
										lblimagee.setFont(new Font("Tahoma", Font.PLAIN, 14));
										lblimagee.setBounds(10, 181, 50, 28);
										paneAddTheatre.add(lblimagee);
										
												text_image = new JTextField();
												text_image.setBounds(111, 181, 138, 19);
												paneAddTheatre.add(text_image);
												text_image.setColumns(10);
														
														ButtonGroup bg = new ButtonGroup();
														
														JLabel lbl_CinemaSeance_2 = new JLabel("Seans:");
														lbl_CinemaSeance_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
														lbl_CinemaSeance_2.setBounds(10, 219, 46, 28);
														paneAddTheatre.add(lbl_CinemaSeance_2);
														
														JPanel SeanceHours22 = new JPanel();
														SeanceHours22.setBounds(59, 223, 347, 139);
														paneAddTheatre.add(SeanceHours22);
														SeanceHours22.setLayout(null);
														SeanceHours22.setBackground(Color.WHITE);
														
														JRadioButton rdbtn0_0 = new JRadioButton("10:00 ");
														rdbtn0_0.setBounds(6, 6, 103, 21);
														SeanceHours22.add(rdbtn0_0);
														
														JRadioButton rdbtn1_1 = new JRadioButton("11:00");
														rdbtn1_1.setBounds(122, 6, 103, 21);
														SeanceHours22.add(rdbtn1_1);
														
														JRadioButton rdbtn2_2 = new JRadioButton("12:00");
														rdbtn2_2.setBounds(238, 6, 103, 21);
														SeanceHours22.add(rdbtn2_2);
														
														JRadioButton rdbtn8_8 = new JRadioButton("18:00");
														rdbtn8_8.setBounds(238, 76, 103, 21);
														SeanceHours22.add(rdbtn8_8);
														
														JRadioButton rdbtn7_7 = new JRadioButton("17:00");
														rdbtn7_7.setBounds(122, 76, 103, 21);
														SeanceHours22.add(rdbtn7_7);
														
														JRadioButton rdbtn6_6 = new JRadioButton("16:00");
														rdbtn6_6.setBounds(6, 76, 103, 21);
														SeanceHours22.add(rdbtn6_6);
														
														JRadioButton rdbtn11_1 = new JRadioButton("21:00");
														rdbtn11_1.setBounds(238, 112, 103, 21);
														SeanceHours22.add(rdbtn11_1);
														
														JRadioButton rdbtn10_0 = new JRadioButton("20:00");
														rdbtn10_0.setBounds(122, 112, 103, 21);
														SeanceHours22.add(rdbtn10_0);
														
														JRadioButton rdbtn9_9 = new JRadioButton("19:00");
														rdbtn9_9.setBounds(6, 112, 103, 21);
														SeanceHours22.add(rdbtn9_9);
														
														JRadioButton rdbtn5_5 = new JRadioButton("15:00");
														rdbtn5_5.setBounds(238, 41, 103, 21);
														SeanceHours22.add(rdbtn5_5);
														
														JRadioButton rdbtn4_4 = new JRadioButton("14:00");
														rdbtn4_4.setBounds(122, 41, 103, 21);
														SeanceHours22.add(rdbtn4_4);
														
														JRadioButton rdbtn3_3 = new JRadioButton("13:00");
														rdbtn3_3.setBounds(6, 41, 103, 21);
														SeanceHours22.add(rdbtn3_3);
														
														bg.add(rdbtn0_0);
														bg.add(rdbtn1_1);
														bg.add(rdbtn2_2);
														bg.add(rdbtn3_3);
														bg.add(rdbtn4_4);
														bg.add(rdbtn5_5);
														bg.add(rdbtn6_6);
														bg.add(rdbtn7_7);
														bg.add(rdbtn8_8);
														bg.add(rdbtn9_9);
														bg.add(rdbtn10_0);
														bg.add(rdbtn11_1);
														dateChooser.setBounds(111, 147, 138, 20);
														lbl_Poster.setBounds(288, 10, 128, 161);														
														

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
		
		
		
				JButton btn_AddTheatre = new JButton("Oyun Ekle");
				btn_AddTheatre.setBounds(568, 423, 138, 31);
				contentPane.add(btn_AddTheatre);
				btn_AddTheatre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String seance="";
						if(rdbtn0_0.isSelected()) {seance=rdbtn0_0.getText();}
						if(rdbtn1_1.isSelected()) {seance=rdbtn1_1.getText();}
						if(rdbtn2_2.isSelected()) {seance=rdbtn2_2.getText();}
						if(rdbtn3_3.isSelected()) {seance=rdbtn3_3.getText();}
						if(rdbtn4_4.isSelected()) {seance=rdbtn4_4.getText();}
						if(rdbtn5_5.isSelected()) {seance=rdbtn5_5.getText();}
						if(rdbtn6_6.isSelected()) {seance=rdbtn6_6.getText();}
						if(rdbtn7_7.isSelected()) {seance=rdbtn7_7.getText();}
						if(rdbtn8_8.isSelected()) {seance=rdbtn8_8.getText();}
						if(rdbtn9_9.isSelected()) {seance=rdbtn9_9.getText();}
						if(rdbtn10_0.isSelected()) {seance=rdbtn10_0.getText();}
						if(rdbtn11_1.isSelected()) {seance=rdbtn11_1.getText();}
						
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
				
		
/////////////////////////////PANECÝNEMA///////////////////////////////////////////////////////////////////////////
		
		JPanel paneAddCinema = new JPanel();
		paneAddCinema.setBackground(SystemColor.inactiveCaption);
		paneAddCinema.setBounds(417, 41, 416, 372);
		contentPane.add(paneAddCinema);
		paneAddCinema.setLayout(null);

		JLabel lbl_MovieName = new JLabel("Film Adi:");
		lbl_MovieName.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 10, 102, 28);
		paneAddCinema.add(lbl_MovieName);

		JLabel lbl_FilmDirectorr = new JLabel("Yönetmen:");
		lbl_FilmDirectorr.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_FilmDirectorr.setBounds(10, 45, 102, 28);
		paneAddCinema.add(lbl_FilmDirectorr);

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

		JLabel lblNewLabel_1_1_2 = new JLabel("Tarih:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(10, 143, 102, 28);
		paneAddCinema.add(lblNewLabel_1_1_2);
/////////////////////////Trrrrrrrrrrrrrrrr
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

		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(111, 147, 138, 20);
		paneAddCinema.add(dateChooser2);

		JLabel lbl_Poster_r = new JLabel("");
		paneAddCinema.add(lbl_Poster_r);

		JButton btn_ImageSelect_t = new JButton("Afi\u015F Se\u00E7");
		btn_ImageSelect_t.addActionListener(new ActionListener() {
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
		btn_ImageSelect_t.setBounds(314, 182, 102, 31);
		paneAddCinema.add(btn_ImageSelect_t);

		JLabel lblimage_e = new JLabel("Resim:");
		lblimage_e.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblimage_e.setBounds(10, 181, 50, 28);
		paneAddCinema.add(lblimage_e);

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
		dateChooser.setBounds(111, 147, 138, 20);
		lbl_Poster.setBounds(288, 10, 128, 161);	
		
				JButton btn_AddCinema = new JButton("Film Ekle");
				btn_AddCinema.setBounds(568, 423, 138, 31);
				contentPane.add(btn_AddCinema);
				btn_AddCinema.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String seance="";
						if(rdbtn0_0_0.isSelected()) {seance=rdbtn0_0_0.getText();}
						if(rdbtn1_1_1.isSelected()) {seance=rdbtn1_1_1.getText();}
						if(rdbtn2_2_2.isSelected()) {seance=rdbtn2_2_2.getText();}
						if(rdbtn3_3_3.isSelected()) {seance=rdbtn3_3_3.getText();}
						if(rdbtn3_3_3.isSelected()) {seance=rdbtn3_3_3.getText();}
						if(rdbtn5_5_5.isSelected()) {seance=rdbtn5_5_5.getText();}
						if(rdbtn6_6_6.isSelected()) {seance=rdbtn6_6_6.getText();}
						if(rdbtn7_7_7.isSelected()) {seance=rdbtn7_7_7.getText();}
						if(rdbtn8_8_8.isSelected()) {seance=rdbtn8_8_8.getText();}
						if(rdbtn9_9_9.isSelected()) {seance=rdbtn9_9_9.getText();}
						if(rdbtn10_0_0.isSelected()) {seance=rdbtn10_0_0.getText();}
						if(rdbtn11_1_1.isSelected()) {seance=rdbtn11_1_1.getText();}
						
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
				
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				tabbedPane.addChangeListener((ChangeListener) new ChangeListener() {

		            @Override
		            public void stateChanged(ChangeEvent e) {
		                if (tabbedPane.getSelectedIndex() == 0) {
		                    paneAddCinema.setVisible(true);
		                    paneAddTheatre.setVisible(false);
		                    paneAddConcert.setVisible(false);
		                } else if (tabbedPane.getSelectedIndex() == 1) {
		                	paneAddTheatre.setVisible(true);
		                	paneAddCinema.setVisible(false);
		                    paneAddConcert.setVisible(false);
		                } else if (tabbedPane.getSelectedIndex() == 2) {
		                	paneAddCinema.setVisible(false);
		                    paneAddTheatre.setVisible(false);
		                    paneAddConcert.setVisible(true);
		                }

		            }

		        });
				
	}
}

//