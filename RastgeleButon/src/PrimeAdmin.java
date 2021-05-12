
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTextField;

public class PrimeAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table_Customer;
	private JTable table_Admin;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultTableModel customerModel;
	private Object[] customerData = null;
	private DefaultTableModel adminModel;
	private Object[] adminData = null;
	private  static user admin = new user(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeAdmin frame = new PrimeAdmin(admin);
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
	public PrimeAdmin(user admin) {

		customerModel = new DefaultTableModel();
		Object[] colCustomer = new Object[3]; // tablo sütunlarýna isim vermek için

		colCustomer[0] = "T.C. Numarasý";
		colCustomer[1] = "Adý";
		colCustomer[2] = "Soyadý";

		customerModel.setColumnIdentifiers(colCustomer);
		customerData = new Object[3]; // sqlden veri çekmek için

		adminModel = new DefaultTableModel();
		Object[] colAdmin  = new Object[4];
		
		colAdmin[0]="Yönetici ID";
		colAdmin[1]="Adý";
		colAdmin[2]="Soyadý";
		colAdmin[3]="Þifre";
		
		adminModel.setColumnIdentifiers(colAdmin);
		adminData=  new Object[4];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_WelcomePrimeAdmin = new JLabel("Hosgeldiniz Sayin  "+admin.getName());
		lbl_WelcomePrimeAdmin.setBounds(10, 11, 469, 14);
		contentPane.add(lbl_WelcomePrimeAdmin);

		JPanel w_paneCustomer = new JPanel();
		w_paneCustomer.setBackground(SystemColor.activeCaption);
		w_paneCustomer.setBounds(10, 86, 525, 464);
		contentPane.add(w_paneCustomer);
		w_paneCustomer.setLayout(null);

		JButton btnNewButton = new JButton("\u00DCye Sil");
		btnNewButton.setBounds(138, 430, 106, 23);
		w_paneCustomer.add(btnNewButton);

		JButton btnNewButton_1_1 = new JButton("G\u00FCncelle");
		btnNewButton_1_1.setBounds(266, 430, 100, 23);
		w_paneCustomer.add(btnNewButton_1_1);

		JPanel w_paneAltCustomer = new JPanel();
		w_paneAltCustomer.setBackground(SystemColor.text);
		w_paneAltCustomer.setBounds(0, 0, 525, 419);
		w_paneCustomer.add(w_paneAltCustomer);
		w_paneAltCustomer.setLayout(null);

		JScrollPane scrollPane_Customer = new JScrollPane();
		scrollPane_Customer.setBounds(0, 0, 525, 419);
		w_paneAltCustomer.add(scrollPane_Customer);

		table_Customer = new JTable(customerModel);
		table_Customer.getColumnModel().getColumn(0).setResizable(false);
		table_Customer.getColumnModel().getColumn(1).setResizable(false);
		table_Customer.getColumnModel().getColumn(2).setResizable(false);
		table_Customer.setBackground(SystemColor.text);
		scrollPane_Customer.setViewportView(table_Customer);

		JPanel w_paneAdmin = new JPanel();
		w_paneAdmin.setBackground(SystemColor.activeCaption);
		w_paneAdmin.setBounds(549, 86, 525, 464);
		contentPane.add(w_paneAdmin);
		w_paneAdmin.setLayout(null);

		JButton btnkar = new JButton("Ekle");
		btnkar.setBounds(89, 430, 106, 23);
		w_paneAdmin.add(btnkar);

		JButton btnNewButton_1_1_1 = new JButton("G\u00FCncelle");
		btnNewButton_1_1_1.setBounds(217, 430, 100, 23);
		w_paneAdmin.add(btnNewButton_1_1_1);

		JButton btnNewButton_1_2 = new JButton("Sil");
		btnNewButton_1_2.setBounds(337, 430, 106, 23);
		w_paneAdmin.add(btnNewButton_1_2);

		JPanel w_paneAltAdmin = new JPanel();
		w_paneAltAdmin.setLayout(null);
		w_paneAltAdmin.setBackground(Color.WHITE);
		w_paneAltAdmin.setBounds(0, 0, 525, 339);
		w_paneAdmin.add(w_paneAltAdmin);

		JScrollPane scrollPane_Admin = new JScrollPane();
		scrollPane_Admin.setBounds(0, 0, 525, 339);
		w_paneAltAdmin.add(scrollPane_Admin);

		table_Admin = new JTable(adminModel);
		table_Admin.getColumnModel().getColumn(0).setResizable(false);
		table_Admin.getColumnModel().getColumn(1).setResizable(false);
		table_Admin.getColumnModel().getColumn(2).setResizable(false);
		table_Admin.getColumnModel().getColumn(3).setResizable(false);
		scrollPane_Admin.setViewportView(table_Admin);

		Label label = new Label("Ad:");
		label.setFont(new Font("Verdana", Font.PLAIN, 15));
		label.setBounds(45, 345, 88, 22);
		w_paneAdmin.add(label);

		Label label_1 = new Label("Soyad:");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		label_1.setBounds(284, 345, 57, 22);
		w_paneAdmin.add(label_1);

		Label label_2 = new Label("Y\u00F6netici ID:");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		label_2.setBounds(45, 383, 88, 22);
		w_paneAdmin.add(label_2);

		Label label_1_1 = new Label("\u015Eifre:");
		label_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		label_1_1.setBounds(284, 383, 57, 22);
		w_paneAdmin.add(label_1_1);

		textField = new JTextField();
		textField.setBounds(139, 346, 126, 20);
		w_paneAdmin.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(347, 345, 126, 20);
		w_paneAdmin.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 385, 126, 20);
		w_paneAdmin.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(347, 384, 126, 20);
		w_paneAdmin.add(textField_3);

		JLabel lbl_Member = new JLabel("\u00DCye \u0130\u015Flemleri");
		lbl_Member.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 20));
		lbl_Member.setBounds(10, 59, 171, 27);
		contentPane.add(lbl_Member);

		JLabel lbl_SubAdmin = new JLabel("Alt Y\u00F6netici \u0130\u015Flemleri");
		lbl_SubAdmin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 20));
		lbl_SubAdmin.setBounds(549, 59, 209, 27);
		contentPane.add(lbl_SubAdmin);
	}
}
