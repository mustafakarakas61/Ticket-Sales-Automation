package Packed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

import Helper.*;

public class PrimeAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table_Member;
	private static JTable table_Admin;
	private JTextField tf_Ad;
	private JTextField tf_Soyad;
	private static JTextField tf_yoneticiID;
	private JTextField tf_Pass;
	private DefaultTableModel customerModel;
	private Object[] customerData = null;
	private static DefaultTableModel adminModel;
	private static Object[] adminData = null;
	private static user user = new user();
	private static Member uye = new Member();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeAdmin frame = new PrimeAdmin(user);
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

	public PrimeAdmin(user admin) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrimeAdmin.class.getResource("/Images/ticket.png")));

		setTitle("Bilet Satis Sistemi");
		setResizable(false);

		customerModel = new DefaultTableModel();
		Object[] colCustomer = new Object[4]; 

		colCustomer[0] = "ID";
		colCustomer[1] = "T.C. Kimlik Numarasi";
		colCustomer[2] = "Ad";
		colCustomer[3] = "Soyad";

		customerModel.setColumnIdentifiers(colCustomer);
		customerData = new Object[4]; 

		adminModel = new DefaultTableModel();
		Object[] colAdmin = new Object[5];

		colAdmin[0] = "ID";
		colAdmin[1] = "Ad";
		colAdmin[2] = "Soyad";
		colAdmin[3] = "Sifre";
		colAdmin[4] = "Yonetici ID";

		adminModel.setColumnIdentifiers(colAdmin);
		adminData = new Object[5];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JLabel lbl_WelcomePrimeAdmin = new JLabel("Hosgeldiniz Sayin " + admin.getName() + " " + admin.getSurname());
		lbl_WelcomePrimeAdmin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_WelcomePrimeAdmin.setBounds(10, 20, 500, 20);
		contentPane.add(lbl_WelcomePrimeAdmin);

		JPanel w_paneMember = new JPanel();
		w_paneMember.setBackground(new Color(204, 204, 255));
		w_paneMember.setBounds(10, 86, 525, 464);
		contentPane.add(w_paneMember);
		w_paneMember.setLayout(null);

		JButton btnNewButton = new JButton("Sil");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_Member.getSelectionModel().isSelectionEmpty()) {
					Metod_Helper.showMsg("Lutfen silmek istediginiz kullaniciyi seciniz!");
				} else {
					if (Metod_Helper.confirm("sure")) {
						int selectedRow = table_Member.getSelectedRow();
						try {
							boolean control = uye.delMember(selectedRow);
							if (control) {
								Metod_Helper.showMsg("succes");
								updateMemberList();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

		btnNewButton.setBounds(202, 425, 120, 30);
		w_paneMember.add(btnNewButton);

		JPanel w_paneAltCustomer = new JPanel();
		w_paneAltCustomer.setBackground(SystemColor.text);
		w_paneAltCustomer.setBounds(0, 0, 525, 410);
		w_paneMember.add(w_paneAltCustomer);
		w_paneAltCustomer.setLayout(null);

		JScrollPane scrollPane_Customer = new JScrollPane();
		scrollPane_Customer.setBounds(0, 0, 525, 410);
		w_paneAltCustomer.add(scrollPane_Customer);

		table_Member = new JTable(customerModel);
		table_Member.setFont(new Font("SansSerif", Font.PLAIN, 15));
		table_Member.setBackground(SystemColor.text);
		scrollPane_Customer.setViewportView(table_Member);

		for (int i = 0; i < uye.memberList().size(); i++) {
			customerData[0] = uye.memberList().get(i).getID();
			customerData[1] = uye.memberList().get(i).getTC_No();
			customerData[2] = uye.memberList().get(i).getName();
			customerData[3] = uye.memberList().get(i).getSurname();
			customerModel.addRow(customerData);
		}

		JPanel w_paneAdmin = new JPanel();
		w_paneAdmin.setBackground(new Color(204, 204, 255));
		w_paneAdmin.setBounds(549, 86, 525, 464);
		contentPane.add(w_paneAdmin);
		w_paneAdmin.setLayout(null);

		JButton btn_addSubAdmin = new JButton("Ekle");
		btn_addSubAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_Ad.getText().length() == 0 || tf_Soyad.getText().length() == 0
						|| tf_Pass.getText().length() == 0) {
					Helper.Metod_Helper.showMsg("fill");
				} else {
					try {
						boolean control = admin.addSubAdmin(tf_Ad.getText(), tf_Soyad.getText(), tf_Pass.getText(),
								(tf_Ad.getText() + "-" + tf_Soyad.getText()));
						if (control) {
							Metod_Helper.showMsg("succes");
							tf_Ad.setText(null);
							tf_Soyad.setText(null);
							tf_Pass.setText(null);
							updateSubAdminList();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_addSubAdmin.setBackground(new Color(153, 255, 102));
		btn_addSubAdmin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_addSubAdmin.setFocusable(false);
		btn_addSubAdmin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_addSubAdmin.setBounds(10, 425, 120, 30);
		w_paneAdmin.add(btn_addSubAdmin);

		JButton btn_delSubAdmin = new JButton("Sil");
		btn_delSubAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_yoneticiID.getText().length() == 0) {
					Metod_Helper.showMsg("Lutfen silmek istediginiz kaydin ID bilgisini giriniz");
				} else {
					if (Metod_Helper.confirm("sure")) {

						int selectedID = Integer.parseInt(tf_yoneticiID.getText());
						try {
							boolean control = admin.delSubAdmin(selectedID);
							if (control) {
								Metod_Helper.showMsg("succes");
								tf_yoneticiID.setText(null);
								updateSubAdminList();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_delSubAdmin.setBackground(new Color(255, 102, 102));
		btn_delSubAdmin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_delSubAdmin.setFocusable(false);
		btn_delSubAdmin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_delSubAdmin.setBounds(395, 425, 120, 30);
		w_paneAdmin.add(btn_delSubAdmin);

		JPanel w_paneAltAdmin = new JPanel();
		w_paneAltAdmin.setLayout(null);
		w_paneAltAdmin.setBackground(Color.WHITE);
		w_paneAltAdmin.setBounds(0, 0, 525, 339);
		w_paneAdmin.add(w_paneAltAdmin);

		JScrollPane scrollPane_Admin = new JScrollPane();
		scrollPane_Admin.setBounds(0, 0, 525, 339);
		w_paneAltAdmin.add(scrollPane_Admin);

		table_Admin = new JTable(adminModel);
		table_Admin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		table_Admin.getColumnModel().getColumn(0).setResizable(false);
		table_Admin.getColumnModel().getColumn(1).setResizable(false);
		table_Admin.getColumnModel().getColumn(2).setResizable(false);
		table_Admin.getColumnModel().getColumn(3).setResizable(false);
		table_Admin.getColumnModel().getColumn(4).setResizable(false);
		scrollPane_Admin.setViewportView(table_Admin);

		for (int i = 0; i < admin.subadminList().size(); i++) {
			adminData[0] = admin.subadminList().get(i).getId();
			adminData[1] = admin.subadminList().get(i).getName();
			adminData[2] = admin.subadminList().get(i).getSurname();
			adminData[3] = admin.subadminList().get(i).getPass();
			adminData[4] = admin.subadminList().get(i).getUsername();
			adminModel.addRow(adminData);
		}

		Label label = new Label("Ad:");
		label.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label.setBounds(45, 345, 80, 20);
		w_paneAdmin.add(label);

		Label label_1 = new Label("Soyad:");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label_1.setBounds(285, 345, 57, 22);
		w_paneAdmin.add(label_1);

		Label label_2 = new Label("Yonetici ID:");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label_2.setBounds(45, 385, 80, 20);
		w_paneAdmin.add(label_2);

		Label label_1_1 = new Label("Sifre:");
		label_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label_1_1.setBounds(284, 385, 57, 22);
		w_paneAdmin.add(label_1_1);

		tf_Ad = new JTextField();
		tf_Ad.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_Ad.setBounds(131, 345, 130, 20);
		w_paneAdmin.add(tf_Ad);
		tf_Ad.setColumns(10);

		tf_Soyad = new JTextField();
		tf_Soyad.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_Soyad.setColumns(10);
		tf_Soyad.setBounds(348, 345, 130, 20);
		w_paneAdmin.add(tf_Soyad);

		tf_yoneticiID = new JTextField();
		tf_yoneticiID.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_yoneticiID.setColumns(10);
		tf_yoneticiID.setBounds(131, 385, 130, 20);
		w_paneAdmin.add(tf_yoneticiID);

		tf_Pass = new JTextField();
		tf_Pass.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tf_Pass.setColumns(10);
		tf_Pass.setBounds(348, 385, 130, 20);
		w_paneAdmin.add(tf_Pass);

		JButton btn_updateSubAdmin = new JButton("Guncelle");
		btn_updateSubAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_Admin.getSelectionModel().isSelectionEmpty()) {
					Metod_Helper.showMsg("Lutfen guncellemek istediginiz kaydi seciniz!");
				} else {
					UpdateGUI upGUI = new UpdateGUI();
					upGUI.setVisible(true);
				}
			}
		});
		btn_updateSubAdmin.setBackground(new Color(255, 255, 102));
		btn_updateSubAdmin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_updateSubAdmin.setFocusable(false);
		btn_updateSubAdmin.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_updateSubAdmin.setBounds(202, 425, 120, 30);
		w_paneAdmin.add(btn_updateSubAdmin);

		JLabel lbl_Member = new JLabel("Uye Yonetimi");
		lbl_Member.setFont(new Font("SansSerif", Font.BOLD, 15));
		lbl_Member.setBounds(10, 60, 150, 20);
		contentPane.add(lbl_Member);

		JLabel lbl_SubAdmin = new JLabel("Alt Yonetici Yonetimi");
		lbl_SubAdmin.setFont(new Font("SansSerif", Font.BOLD, 15));
		lbl_SubAdmin.setBounds(550, 60, 150, 20);
		contentPane.add(lbl_SubAdmin);

		JButton btn_Exit = new JButton("Cikis Yap");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lGUI = new Login();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btn_Exit.setFocusable(false);
		btn_Exit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_Exit.setBackground(new Color(204, 204, 255));
		btn_Exit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btn_Exit.setBounds(974, 20, 100, 25);
		contentPane.add(btn_Exit);

		table_Admin.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					tf_yoneticiID.setText(table_Admin.getValueAt(table_Admin.getSelectedRow(), 0).toString());
				} catch (Exception e1) {

				}
			}
		});

	}

	public static void updateSubAdminList() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_Admin.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < user.subadminList().size(); i++) {
			adminData[0] = user.subadminList().get(i).getId();
			adminData[1] = user.subadminList().get(i).getName();
			adminData[2] = user.subadminList().get(i).getSurname();
			adminData[3] = user.subadminList().get(i).getPass();
			adminData[4] = user.subadminList().get(i).getUsername();
			adminModel.addRow(adminData);
		}
	}

	public void updateMemberList() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_Member.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < uye.memberList().size(); i++) {
			customerData[0] = uye.memberList().get(i).getID();
			customerData[1] = uye.memberList().get(i).getTC_No();
			customerData[2] = uye.memberList().get(i).getName();
			customerData[3] = uye.memberList().get(i).getSurname();
			customerModel.addRow(customerData);
		}
	}

	public static JTextField getTf_yoneticiID() {
		return tf_yoneticiID;
	}

	public static void setTf_yoneticiID(JTextField tf_yoneticiID) {
		PrimeAdmin.tf_yoneticiID = tf_yoneticiID;
	}

}