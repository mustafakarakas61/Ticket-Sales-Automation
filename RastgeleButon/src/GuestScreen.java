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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestScreen extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel cinemaModel; //tablo sütunlarýný isimlendirmek için
	private Object[] cinemaData=null; //sqlden veri çekmek için
	private JTable table_Cinema;
	private JTable table_Theater;
	private JTable table_Concert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestScreen frame = new GuestScreen();
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
	public GuestScreen() {
		setResizable(false);
		
		cinemaModel = new DefaultTableModel();
		Object[] colCinema = new Object[5]; //tablo sütunlarýna isim vermek için
		
		colCinema[0]="Film Adý";
		colCinema[1]="Film Türü";
		colCinema[2]="Yönetmen";
		colCinema[3]="Salon";
		colCinema[4]="Seans";
		
		cinemaModel.setColumnIdentifiers(colCinema);
		cinemaData=new Object[5]; //sqlden veri çekmek için
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Exit = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_Exit.setBounds(584, 11, 89, 23);
		contentPane.add(btn_Exit);
		
		JLabel lbl_info = new JLabel("Bilet Sat\u0131n almak i\u00E7in L\u00FCtfen Giri\u015F Yap\u0131n\u0131z.");
		lbl_info.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_info.setBounds(10, 11, 267, 23);
		contentPane.add(lbl_info);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 36, 694, 525);
		contentPane.add(tabbedPane);
		
		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sinemalar", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);
		
		JScrollPane scrollPane_Cinema = new JScrollPane();
		scrollPane_Cinema.setBounds(0, 0, 681, 461);
		w_paneCinema.add(scrollPane_Cinema);
		
		table_Cinema = new JTable(cinemaModel);
		table_Cinema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Cinema.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Cinema.setViewportView(table_Cinema);
		
		JButton btn_GoBack1 = new JButton("Geri D\u00F6n");
		btn_GoBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l= new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_GoBack1.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btn_GoBack1.setBounds(285, 464, 99, 30);
		w_paneCinema.add(btn_GoBack1);
		table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Cinema.getColumnModel().getColumn(0).setResizable(false);
		
		table_Cinema.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Cinema.getColumnModel().getColumn(1).setResizable(false);
		//table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Cinema.getColumnModel().getColumn(2).setResizable(false);
		table_Cinema.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Cinema.getColumnModel().getColumn(3).setResizable(false);
		table_Cinema.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Cinema.getColumnModel().getColumn(4).setResizable(false);
		
		/*************************Þimdilik Veri Ekliyorum***************************/
		cinemaData[0]="Recep Ývedik 7";
		cinemaData[1]="Komedi";
		cinemaData[2]="Þahan Gökbakar";
		cinemaData[3]=1;
		cinemaData[4]=2;
		cinemaModel.addRow(cinemaData);
		cinemaData[0]="Hýzlý ve Öfkeli 10";
		cinemaData[1]="Aksiyon";
		cinemaData[2]="Rob Cohen";
		cinemaData[3]=4;
		cinemaData[4]=1;
		cinemaModel.addRow(cinemaData);
		
		/****************************************************/
		
		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Tiyatrolar", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);
		
		JScrollPane scrollPane_Theater = new JScrollPane();
		scrollPane_Theater.setBounds(0, 0, 681, 461);
		w_paneTheater.add(scrollPane_Theater);
		
		table_Theater = new JTable();
		scrollPane_Theater.setViewportView(table_Theater);
		
		JButton btn_GoBack2= new JButton("Geri D\u00F6n");
		btn_GoBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l= new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_GoBack2.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btn_GoBack2.setBounds(285, 464, 99, 30);
		w_paneTheater.add(btn_GoBack2);
		
		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Konserler", null, w_paneConcert, null);
		w_paneConcert.setLayout(null);
		
		JScrollPane scrollPane_Concert = new JScrollPane();
		scrollPane_Concert.setBounds(0, 0, 681, 461);
		w_paneConcert.add(scrollPane_Concert);
		
		table_Concert = new JTable();
		scrollPane_Concert.setViewportView(table_Concert);
		
		JButton btn_GoBack3 = new JButton("Geri D\u00F6n");
		btn_GoBack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l= new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_GoBack3.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btn_GoBack3.setBounds(285, 464, 99, 30);
		w_paneConcert.add(btn_GoBack3);
	}
}
