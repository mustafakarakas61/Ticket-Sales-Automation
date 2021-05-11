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

public class UyesizAnaEkran extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel sinemaModel; //tablo sütunlarýný isimlendirmek için
	private Object[] sinemaData=null; //sqlden veri çekmek için
	private JTable table_Sinema;
	private JTable table_Tiyatro;
	private JTable table_Konser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyesizAnaEkran frame = new UyesizAnaEkran();
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
	public UyesizAnaEkran() {
		setResizable(false);
		
		sinemaModel = new DefaultTableModel();
		Object[] colSinema = new Object[5]; //tablo sütunlarýna isim vermek için
		
		colSinema[0]="Film Adý";
		colSinema[1]="Film Türü";
		colSinema[2]="Yönetmen";
		colSinema[3]="Salon";
		colSinema[4]="Seans";
		
		sinemaModel.setColumnIdentifiers(colSinema);
		sinemaData=new Object[5]; //sqlden veri çekmek için
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_cikisYap = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_cikisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_cikisYap.setBounds(584, 11, 89, 23);
		contentPane.add(btn_cikisYap);
		
		JLabel lbl_Sayin = new JLabel("Bilet Sat\u0131n almak i\u00E7in L\u00FCtfen Giri\u015F Yap\u0131n\u0131z.");
		lbl_Sayin.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lbl_Sayin.setBounds(10, 11, 267, 23);
		contentPane.add(lbl_Sayin);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 36, 694, 525);
		contentPane.add(tabbedPane);
		
		JPanel w_paneSinema = new JPanel();
		w_paneSinema.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sinemalar", null, w_paneSinema, null);
		w_paneSinema.setLayout(null);
		
		JScrollPane scrollPane_Sinema = new JScrollPane();
		scrollPane_Sinema.setBounds(0, 0, 681, 461);
		w_paneSinema.add(scrollPane_Sinema);
		
		table_Sinema = new JTable(sinemaModel);
		table_Sinema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Sinema.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Sinema.setViewportView(table_Sinema);
		
		JButton btn_GeriDon1 = new JButton("Geri D\u00F6n");
		btn_GeriDon1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l= new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_GeriDon1.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btn_GeriDon1.setBounds(285, 464, 99, 30);
		w_paneSinema.add(btn_GeriDon1);
		table_Sinema.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Sinema.getColumnModel().getColumn(0).setResizable(false);
		
		table_Sinema.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Sinema.getColumnModel().getColumn(1).setResizable(false);
		//table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Sinema.getColumnModel().getColumn(2).setResizable(false);
		table_Sinema.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Sinema.getColumnModel().getColumn(3).setResizable(false);
		table_Sinema.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Sinema.getColumnModel().getColumn(4).setResizable(false);
		
		/*************************Þimdilik Veri Ekliyorum***************************/
		sinemaData[0]="Recep Ývedik 7";
		sinemaData[1]="Komedi";
		sinemaData[2]="Þahan Gökbakar";
		sinemaData[3]=1;
		sinemaData[4]=2;
		sinemaModel.addRow(sinemaData);
		sinemaData[0]="Hýzlý ve Öfkeli 10";
		sinemaData[1]="Aksiyon";
		sinemaData[2]="Rob Cohen";
		sinemaData[3]=4;
		sinemaData[4]=1;
		sinemaModel.addRow(sinemaData);
		
		/****************************************************/
		
		JPanel w_paneTiyatro = new JPanel();
		w_paneTiyatro.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Tiyatrolar", null, w_paneTiyatro, null);
		w_paneTiyatro.setLayout(null);
		
		JScrollPane scrollPane_Tiyatro = new JScrollPane();
		scrollPane_Tiyatro.setBounds(0, 0, 681, 461);
		w_paneTiyatro.add(scrollPane_Tiyatro);
		
		table_Tiyatro = new JTable();
		scrollPane_Tiyatro.setViewportView(table_Tiyatro);
		
		JButton btn_GeriDon2 = new JButton("Geri D\u00F6n");
		btn_GeriDon2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l= new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_GeriDon2.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btn_GeriDon2.setBounds(285, 464, 99, 30);
		w_paneTiyatro.add(btn_GeriDon2);
		
		JPanel w_paneKonser = new JPanel();
		w_paneKonser.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Konserler", null, w_paneKonser, null);
		w_paneKonser.setLayout(null);
		
		JScrollPane scrollPane_Konser = new JScrollPane();
		scrollPane_Konser.setBounds(0, 0, 681, 461);
		w_paneKonser.add(scrollPane_Konser);
		
		table_Konser = new JTable();
		scrollPane_Konser.setViewportView(table_Konser);
		
		JButton btn_GeriDon3 = new JButton("Geri D\u00F6n");
		btn_GeriDon3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l= new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_GeriDon3.setFont(new Font("Sitka Display", Font.BOLD, 16));
		btn_GeriDon3.setBounds(285, 464, 99, 30);
		w_paneKonser.add(btn_GeriDon3);
	}
}
