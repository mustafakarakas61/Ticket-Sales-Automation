import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.DbHelper;
import Helper.Metod_Helper;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField fld_Name;
	private JTextField fld_Surname;
	private JPasswordField passfld_p1;
	private JPasswordField passfld_p2;
	private JTextField fld_mail;
	private JTextField fld_TCNo;
	private DbHelper dbhelper = new DbHelper();
	private Member member ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setResizable(false);
		setTitle("Kay\u0131t Ol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Name = new JLabel("Ad:");
		lbl_Name.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Name.setBounds(32, 50, 160, 24);
		contentPane.add(lbl_Name);
		
		JLabel lbl_Surname = new JLabel("Soyad:");
		lbl_Surname.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Surname.setBounds(32, 73, 160, 24);
		contentPane.add(lbl_Surname);
		
		JLabel lbl_Password1 = new JLabel("\u015Eifreniz:");
		lbl_Password1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Password1.setBounds(32, 121, 160, 24);
		contentPane.add(lbl_Password1);
		
		JLabel lbl_Password2 = new JLabel("\u015Eifrenizi Tekrar giriniz:");
		lbl_Password2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Password2.setBounds(32, 144, 160, 24);
		contentPane.add(lbl_Password2);
		
		JLabel lbl_Name_Email = new JLabel("E-Mail Adresiniz:");
		lbl_Name_Email.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_Name_Email.setBounds(32, 167, 160, 24);
		contentPane.add(lbl_Name_Email);
		
		JCheckBox chckbx_Confirm = new JCheckBox("\u00DCyelik Bilgilerimin, bu veritaban\u0131nda saklanmas\u0131na izin veriyorum.");
		chckbx_Confirm.setBackground(SystemColor.inactiveCaption);
		chckbx_Confirm.setFont(new Font("Tahoma", Font.ITALIC, 12));
		chckbx_Confirm.setBounds(32, 198, 365, 23);
		contentPane.add(chckbx_Confirm);
		
		JButton btn_Register = new JButton("Kay\u0131t Ol");
		btn_Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (fld_Name.getText().length()==0 
						|| fld_Surname.getText().length()==0 
						|| fld_TCNo.getText().length()==0
						||fld_mail.getText().length()==0
						|| passfld_p1.getText().length()==0
						||passfld_p2.getText().length()==0)  {
					Metod_Helper.showMsg("fill");
					
				}else {  
					boolean control = member.register(fld_TCNo.getText()
							, passfld_p1.getText()
							, fld_Name.getText());
					
					if (control) {
						Metod_Helper.showMsg("succes");
//						LoginGUI login = new LoginGUI();
//						login.setVisible(true);
						dispose();
						
					}else {
						Metod_Helper.showMsg("Hasta daha önce kaydedilmiþ veya hatalý veri");
					}
					
				}
				
				
			}
		});
		btn_Register.setBackground(SystemColor.inactiveCaption);
		btn_Register.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btn_Register.setBounds(175, 221, 89, 39);
		contentPane.add(btn_Register);
		
		JButton btn_GoBack = new JButton("Geri D\u00F6n");
		btn_GoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btn_GoBack.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_GoBack.setBackground(SystemColor.inactiveCaption);
		btn_GoBack.setBounds(340, 11, 83, 24);
		contentPane.add(btn_GoBack);
		
		fld_Name = new JTextField();
		fld_Name.setBounds(189, 49, 208, 20);
		contentPane.add(fld_Name);
		fld_Name.setColumns(10);
		
		fld_Surname = new JTextField();
		fld_Surname.setColumns(10);
		fld_Surname.setBounds(189, 72, 208, 20);
		contentPane.add(fld_Surname);
		
		passfld_p1 = new JPasswordField();
		passfld_p1.setBounds(189, 120, 208, 20);
		contentPane.add(passfld_p1);
		
		passfld_p2 = new JPasswordField();
		passfld_p2.setBounds(189, 143, 208, 20);
		contentPane.add(passfld_p2);
		
		fld_mail = new JTextField();
		fld_mail.setColumns(10);
		fld_mail.setBounds(189, 166, 208, 20);
		contentPane.add(fld_mail);
		
		JLabel lbl_TCNo = new JLabel("T.C. Numaras\u0131:");
		lbl_TCNo.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lbl_TCNo.setBounds(32, 96, 160, 24);
		contentPane.add(lbl_TCNo);
		
		fld_TCNo = new JTextField();
		fld_TCNo.setColumns(10);
		fld_TCNo.setBounds(189, 95, 208, 20);
		contentPane.add(fld_TCNo);
	}
}
