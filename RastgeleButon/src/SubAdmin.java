import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

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
		
		JButton btnShowRemoval = new JButton("G\u00F6steri \u00C7\u0131kar");
		btnShowRemoval.setBounds(100, 421, 142, 34);
		contentPane.add(btnShowRemoval);
		
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
		table_Cinema.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(4).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(2).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(20);
		table_Cinema.getColumnModel().getColumn(1).setPreferredWidth(20);




		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Tiyatro", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);
		
		JScrollPane scroll_Theater = new JScrollPane();
		scroll_Theater.setBounds(0, 0, 431, 327);
		w_paneTheater.add(scroll_Theater);
		
		table_Theater = new JTable(TheaterModel);
		scroll_Theater.setViewportView(table_Theater);
		
		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(SystemColor.info);
		tabbedPane.addTab("Konser", null, w_paneConcert, null);
		w_paneConcert.setLayout(null);
		
		JScrollPane scroll_Concert = new JScrollPane();
		scroll_Concert.setBounds(0, 0, 431, 327);
		w_paneConcert.add(scroll_Concert);
		
		table_Concert = new JTable(ConcertModel);
		scroll_Concert.setViewportView(table_Concert);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(417, 41, 416, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_MovieName = new JLabel("Film Adi:");
		lbl_MovieName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MovieName.setBounds(10, 10, 102, 28);
		panel.add(lbl_MovieName);
		
		JLabel lbl_FilmDirector = new JLabel("Yönetmen:");
		lbl_FilmDirector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_FilmDirector.setBounds(10, 45, 102, 28);
		panel.add(lbl_FilmDirector);
		
		JLabel lbl_MovieType = new JLabel("Film Türü:");
		lbl_MovieType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MovieType.setBounds(10, 72, 102, 28);
		panel.add(lbl_MovieType);
		
		JLabel lbl_CinemaSalon = new JLabel("Salon:");
		lbl_CinemaSalon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CinemaSalon.setBounds(10, 110, 102, 28);
		panel.add(lbl_CinemaSalon);
		
		txt_MovieName = new JTextField();
		txt_MovieName.setBounds(111, 17, 138, 19);
		panel.add(txt_MovieName);
		txt_MovieName.setColumns(10);
		
		txt_MovieDirector = new JTextField();
		txt_MovieDirector.setColumns(10);
		txt_MovieDirector.setBounds(111, 48, 138, 23);
		panel.add(txt_MovieDirector);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(111, 78, 138, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tarih:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(10, 148, 102, 28);
		panel.add(lblNewLabel_1_1_2_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(111, 116, 138, 21);
		panel.add(comboBox_1_1);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setBounds(111, 154, 138, 21);
		panel.add(comboBox_1_2);
		
		JButton btn_AddCinema = new JButton("Film Ekle");
		btn_AddCinema.setBounds(103, 252, 128, 31);
		panel.add(btn_AddCinema);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(259, 17, 147, 175);
		panel.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("Afi\u015F Se\u00E7");
		btnNewButton_2.setBounds(304, 202, 102, 31);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Seans Ekle");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(463, 415, 138, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Salon Ekle");
		btnNewButton.setBounds(638, 415, 138, 44);
		contentPane.add(btnNewButton);
	}
}