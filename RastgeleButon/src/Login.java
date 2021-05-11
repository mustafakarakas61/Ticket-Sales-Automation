import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField fld_kullanciAdiG;
	private JPasswordField fld_sifreG;
	private JTextField fld_kullaniciAdiY;
	private JPasswordField fld_sifreY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Login Ekran\u0131");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 82, 414, 168);
		contentPane.add(tabbedPane);
		
		JPanel w_paneMusteri = new JPanel();
		w_paneMusteri.setBackground(Color.WHITE);
		tabbedPane.addTab("Giriþ", null, w_paneMusteri, null);
		w_paneMusteri.setLayout(null);
		
		JLabel lbl_KullaniciTC = new JLabel("T.C. Kimlik No:");
		lbl_KullaniciTC.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_KullaniciTC.setBounds(10, 22, 108, 14);
		w_paneMusteri.add(lbl_KullaniciTC);
		
		JLabel lbl_SifreG = new JLabel("\u015Eifre:");
		lbl_SifreG.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_SifreG.setBounds(10, 60, 41, 14);
		w_paneMusteri.add(lbl_SifreG);
		
		fld_kullanciAdiG = new JTextField();
		fld_kullanciAdiG.setBounds(116, 20, 122, 20);
		w_paneMusteri.add(fld_kullanciAdiG);
		fld_kullanciAdiG.setColumns(10);
		
		fld_sifreG = new JPasswordField();
		fld_sifreG.setBounds(116, 58, 122, 20);
		w_paneMusteri.add(fld_sifreG);
		
		JButton btn_kayitOl = new JButton("Kay\u0131t Ol");
		btn_kayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KayitOl ko = new KayitOl();
				ko.setVisible(true);
				dispose();
			}
		});
		btn_kayitOl.setBackground(Color.ORANGE);
		btn_kayitOl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_kayitOl.setBounds(10, 90, 101, 39);
		w_paneMusteri.add(btn_kayitOl);
		
		JButton btn_girisYap = new JButton("Giri\u015F Yap");
		btn_girisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaEkran ae= new AnaEkran();
				ae.setVisible(true);
				dispose();
			}
		});
		btn_girisYap.setBackground(Color.GREEN);
		btn_girisYap.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_girisYap.setBounds(137, 89, 101, 39);
		w_paneMusteri.add(btn_girisYap);
		
		JButton btn_girisYapUyesiz = new JButton("\u00DCyesiz Giri\u015F");
		btn_girisYapUyesiz.setBackground(Color.PINK);
		btn_girisYapUyesiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UyesizAnaEkran uak= new UyesizAnaEkran();
				uak.setVisible(true);
				dispose();
			}
		});
		btn_girisYapUyesiz.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_girisYapUyesiz.setBounds(265, 22, 120, 52);
		w_paneMusteri.add(btn_girisYapUyesiz);
		
		JButton btnNewButton = new JButton("\u015Eifremi Unuttum");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SifremiUnuttum su= new SifremiUnuttum();
				su.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(204, 204, 255));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btnNewButton.setBounds(265, 90, 120, 39);
		w_paneMusteri.add(btnNewButton);
		
		JPanel w_paneYonetici = new JPanel();
		w_paneYonetici.setBackground(Color.WHITE);
		tabbedPane.addTab("Yönetici Giriþi", null, w_paneYonetici, null);
		w_paneYonetici.setLayout(null);
		
		JLabel lbl_YoneticiID = new JLabel("Y\u00F6netici ID:");
		lbl_YoneticiID.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_YoneticiID.setBounds(10, 22, 96, 14);
		w_paneYonetici.add(lbl_YoneticiID);
		
		fld_kullaniciAdiY = new JTextField();
		fld_kullaniciAdiY.setColumns(10);
		fld_kullaniciAdiY.setBounds(116, 20, 122, 20);
		w_paneYonetici.add(fld_kullaniciAdiY);
		
		JLabel lbl_SifreY = new JLabel("\u015Eifre:");
		lbl_SifreY.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lbl_SifreY.setBounds(10, 60, 41, 14);
		w_paneYonetici.add(lbl_SifreY);
		
		fld_sifreY = new JPasswordField();
		fld_sifreY.setBounds(116, 58, 122, 20);
		w_paneYonetici.add(fld_sifreY);
		
		JButton btn_girisYap_1 = new JButton("Giri\u015F Yap");
		btn_girisYap_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btn_girisYap_1.setBounds(137, 89, 101, 39);
		w_paneYonetici.add(btn_girisYap_1);
		
		JLabel lbl_YoneticiUnuttu = new JLabel("\u015Eifrenizi veya ID'nizi unuttu\u011Funuzda l\u00FCtfen ilgili yetkiliye dan\u0131\u015F\u0131n\u0131z.");
		lbl_YoneticiUnuttu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lbl_YoneticiUnuttu.setBounds(10, 127, 389, 14);
		w_paneYonetici.add(lbl_YoneticiUnuttu);
		
		JLabel lblWelcome = new JLabel("Welcome to Ticket Sales System");
		lblWelcome.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		lblWelcome.setBounds(100, 43, 242, 14);
		contentPane.add(lblWelcome);
		
		JLabel lblBGLogo = new JLabel(new ImageIcon(getClass().getResource("sinemabg.png")));
		lblBGLogo.setBounds(12, 31, 90, 60);
		contentPane.add(lblBGLogo);
	}
}
