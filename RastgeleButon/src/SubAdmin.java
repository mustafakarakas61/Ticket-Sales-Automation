import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class SubAdmin extends JFrame {
	private DefaultTableModel CinemaModel;
	private DefaultTableModel TheaterModel;
	private DefaultTableModel ConcertModel;
	private Object[] CinemaData = null;
	private Object[] ConcertData = null;
	private Object[] TheaterData = null;
	private JPanel contentPane;
	private JTable table_Cinema;
	private JTable table_Theater;
	private JTable table_Concert;
	private JTextField txt_MovieName;
	private JTextField txt_MovieDirector;
	private static user sub = new user();

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
	 */
	public SubAdmin(user sub) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		CinemaModel = new DefaultTableModel();
		Object[] colCinema = new Object[5];
		colCinema[0] = "Film Adi";
		colCinema[1] = "Film Türü";
		colCinema[2] = "Yönetmen";
		colCinema[3] = "Salon";
		colCinema[4] = "Seans";

		CinemaModel.setColumnIdentifiers(colCinema);
		CinemaData = new Object[5];

		ConcertModel = new DefaultTableModel();
		Object[] colConcert = new Object[5];
		colConcert[0] = "Konser Adi";
		colConcert[1] = "Konser türü";
		colConcert[2] = "Tarih";
		colConcert[3] = "Salon";
		colConcert[4] = "Saat";

		ConcertModel.setColumnIdentifiers(colConcert);
		ConcertData = new Object[5];

		TheaterModel = new DefaultTableModel();
		Object[] colTheater = new Object[5];
		colTheater[0] = "Oyun Adi";
		colTheater[1] = "Oyun Türü";
		colTheater[2] = "Tarih";
		colTheater[3] = "Salon";
		colTheater[4] = "Saat";

		TheaterModel.setColumnIdentifiers(colTheater);
		TheaterData = new Object[5];

		JButton btn_ShowRemoval = new JButton("G\u00F6steri \u00C7\u0131kar");
		btn_ShowRemoval.setBounds(100, 421, 142, 34);
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
		scroll_Cinema.setBounds(0, 0, 400, 327);
		w_paneCinema.add(scroll_Cinema);

		table_Cinema = new JTable(CinemaModel);
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

		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scroll_Theater = new JScrollPane();
		scroll_Theater.setBounds(0, 0, 400, 327);
		w_paneTheater.add(scroll_Theater);

		table_Theater = new JTable(TheaterModel);
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

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(SystemColor.info);
		tabbedPane.addTab("Konser", null, w_paneConcert, null);
		w_paneConcert.setLayout(null);

		JScrollPane scroll_Concert = new JScrollPane();
		scroll_Concert.setBounds(0, 0, 400, 327);
		w_paneConcert.add(scroll_Concert);

		table_Concert = new JTable(ConcertModel);
		scroll_Concert.setViewportView(table_Concert);
		table_Concert.getColumnModel().getColumn(0).setResizable(false);
		table_Concert.getColumnModel().getColumn(1).setPreferredWidth(20);
		table_Concert.getColumnModel().getColumn(1).setResizable(false);
		table_Concert.getColumnModel().getColumn(2).setPreferredWidth(20);
		table_Concert.getColumnModel().getColumn(2).setResizable(false);
		table_Concert.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_Concert.getColumnModel().getColumn(3).setResizable(false);
		table_Concert.getColumnModel().getColumn(4).setPreferredWidth(20);
		table_Concert.getColumnModel().getColumn(4).setResizable(false);

		JPanel paneAddCinema = new JPanel();
		paneAddCinema.setBackground(SystemColor.inactiveCaption);
		paneAddCinema.setBounds(417, 41, 416, 356);
		contentPane.add(paneAddCinema);
		paneAddCinema.setLayout(null);

		JLabel lbl_MovieName = new JLabel("Film Adi:");
		lbl_MovieName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 10, 102, 28);
		paneAddCinema.add(lbl_MovieName);

		JLabel lbl_FilmDirector = new JLabel("Yönetmen:");
		lbl_FilmDirector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_FilmDirector.setBounds(10, 45, 102, 28);
		paneAddCinema.add(lbl_FilmDirector);

		JLabel lbl_MovieType = new JLabel("Film Türü:");
		lbl_MovieType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MovieType.setBounds(10, 72, 102, 28);
		paneAddCinema.add(lbl_MovieType);

		JLabel lbl_CinemaSalon = new JLabel("Salon:");
		lbl_CinemaSalon.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		lblNewLabel_1_1_2_1.setBounds(10, 148, 102, 28);
		paneAddCinema.add(lblNewLabel_1_1_2_1);

		JComboBox comboBox_Salon = new JComboBox();
		comboBox_Salon.setBounds(111, 116, 138, 21);
		paneAddCinema.add(comboBox_Salon);

		JButton btn_AddCinema = new JButton("Film Ekle");
		btn_AddCinema.setBounds(103, 252, 128, 31);
		paneAddCinema.add(btn_AddCinema);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(111, 153, 138, 20);
		paneAddCinema.add(dateChooser);

		JLabel lbl_Poster = new JLabel("");
		lbl_Poster.setBounds(278, 15, 128, 161);
		paneAddCinema.add(lbl_Poster);

		JButton btn_ImageSelect = new JButton("Afi\u015F Se\u00E7");
		btn_ImageSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Bir Resim Seç");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Resim Dosyasý", "jpg", "jpeg", "png");

				fs.setFileFilter(filter);
                int Adress = fs.showOpenDialog(null);
                if (Adress == JFileChooser.APPROVE_OPTION) { {
                      //   System.out.println(fs.getSelectedFile());
                        //w:128 h:161
                	ImageIcon imageIcon = new ImageIcon(fs.getSelectedFile().toString());
					Image image = imageIcon.getImage();
					Image newimg = image.getScaledInstance(128, 161,  java.awt.Image.SCALE_SMOOTH);
					//imageIcon = new ImageIcon(newimg);
                         lbl_Poster.setIcon(new ImageIcon(newimg));
                         BufferedImage bImage = null;
                         try {
                             File initialImage = new File(fs.getSelectedFile().toString());
                             bImage = ImageIO.read(initialImage);
                             ImageIO.write(bImage, "jpg", new File("C://Users/dogak/git/booking2/RastgeleButon/src/Images/image.png"));
                         } catch (IOException j) {
                               System.out.println("Exception occured :" + j.getMessage());
                         }
                         
                  
                         	
                }}
				
			}
		});
		btn_ImageSelect.setBounds(304, 202, 102, 31);
		paneAddCinema.add(btn_ImageSelect);

		JButton btn_AddSeance = new JButton("Seans Ekle");
		btn_AddSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSeance AS = new AddSeance();
				AS.setVisible(true);
			}
		});
		btn_AddSeance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_AddSeance.setBounds(463, 415, 138, 44);
		contentPane.add(btn_AddSeance);

		JButton btn_AddSalon = new JButton("Salon Ekle");
		btn_AddSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSalon A_S = new AddSalon();
				A_S.setVisible(true);

			}
		});
		btn_AddSalon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_AddSalon.setBounds(638, 415, 138, 44);
		contentPane.add(btn_AddSalon);
	}
}