import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
// herkese selam as
public class MainScreen extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel sinemaModel; // tablo sütunlarýný isimlendirmek için
	private DefaultTableModel tiyatroModel;
	private Object[] sinemaData = null; // sqlden veri çekmek için
	private Object[] tiyatroData = null;
	private JTable table_Cinema;
	private JTable table_Theater;
	private JTable table_Concert;
	private JTextField fld_MovieName;
	private JTextField fld_MovieType;
	private JTextField fld_Director;
	private JTextField fld_Salon;
	private JTextField fld_SelectSeat;
	private JTextField fld_Seance;
	private JTextField fld_Name;
	private JTextField fld_Surname;
	private JTextField fld_Mail;
	private JTextField fld_Price;
	private JTextField fld_cvc;
	private JTextField fld_CartName;
	private JTextField fld_CartNumber;

	private JTextField fld_GameName;
	private JTextField fld_GameType;
	private JTextField fld_Director2;
	private JTextField fld_Salon2;
	private JTextField fld_SeatSelection2;
	private JTextField fld_Time;
	private JTextField fld_Name2;
	private JTextField fld_Surname2;
	private JTextField fld_Mail2;
	private JTextField fld_Price2;
	private JTextField fld_cvc2;
	private JTextField fld_CartName2;
	private JTextField fld_CartNumber2;

	private JTextField fld_ConcertName;
	private JTextField fld_ConcertType;
	private JTextField fld_Date2;
	private JTextField fld_Salon3;
	private JTextField fld_SeatSelection3;
	private JTextField fld_Time2;
	private JTextField fld_Name3;
	private JTextField fld_Surname3;
	private JTextField fld_Mail3;
	private JTextField fld_Price3;
	private JTextField fld_cvc3;
	private JTextField fld_CartName3;
	private JTextField fld_CartNumber3;
	private static user member = new Member();
			

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen(member);
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
	public MainScreen(user member) {
		setResizable(false);

//////////////////////////////////////////////////////////////////////////////////Sinema
		sinemaModel = new DefaultTableModel();
		Object[] colSinema = new Object[5]; // tablo sütunlarýna isim vermek için

		colSinema[0] = "Film Adý";
		colSinema[1] = "Film Türü";
		colSinema[2] = "Yönetmen";
		colSinema[3] = "Salon";
		colSinema[4] = "Seans";

		sinemaModel.setColumnIdentifiers(colSinema);
		sinemaData = new Object[5]; // sqlden veri çekmek için

//////////////////////////////////////////////////////////////////////////////////Tiyatro
		tiyatroModel = new DefaultTableModel();
		Object[] colTiyatro = new Object[5];

		colTiyatro[0] = "Oyun Adý";
		colTiyatro[1] = "Oyun Türü";
		colTiyatro[2] = "Tarih";
		colTiyatro[3] = "Salon";
		colTiyatro[4] = "Saat";
		tiyatroModel.setColumnIdentifiers(colTiyatro);
		tiyatroData = new Object[5]; // sqlden veri çekmek için

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 600);
		contentPane = new JPanel();
		contentPane.setBorder(
				new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground"),
						UIManager.getColor("InternalFrame.activeTitleBackground")));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_Exit = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btn_Exit.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btn_Exit.setBounds(861, 11, 89, 23);
		contentPane.add(btn_Exit);

		JLabel lbl_Name = new JLabel("Ho\u015Fgeldiniz Say\u0131n " + member.getName());
		lbl_Name.setBounds(10, 11, 193, 14);
		contentPane.add(lbl_Name);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBounds(0, 36, 488, 486);
		contentPane.add(tabbedPane);

		JPanel w_paneCinema = new JPanel();
		w_paneCinema.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sinemalar", null, w_paneCinema, null);
		w_paneCinema.setLayout(null);

		JScrollPane scrollPane_Cinema = new JScrollPane();
		scrollPane_Cinema.setBounds(0, 0, 485, 461);
		w_paneCinema.add(scrollPane_Cinema);
///////////////////////////////////////////////////////////////////////////////////Sinema Sütun Özellikleri
		table_Cinema = new JTable(sinemaModel);
		table_Cinema.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Cinema.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Cinema.setViewportView(table_Cinema);
		table_Cinema.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Cinema.getColumnModel().getColumn(0).setResizable(false);

		table_Cinema.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Cinema.getColumnModel().getColumn(1).setResizable(false);
		// table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Cinema.getColumnModel().getColumn(2).setResizable(false);
		table_Cinema.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Cinema.getColumnModel().getColumn(3).setResizable(false);
		table_Cinema.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Cinema.getColumnModel().getColumn(4).setResizable(false);

		/************************* Þimdilik Veri Ekliyorum ***************************/
		sinemaData[0] = "Recep Ývedik 7";
		sinemaData[1] = "Komedi";
		sinemaData[2] = "Þahan Gökbakar";
		sinemaData[3] = 1;
		sinemaData[4] = "13:40";
		sinemaModel.addRow(sinemaData);
		sinemaData[0] = "Hýzlý ve Öfkeli 10";
		sinemaData[1] = "Aksiyon";
		sinemaData[2] = "Rob Cohen";
		sinemaData[3] = 4;
		sinemaData[4] = "16:30";
		sinemaModel.addRow(sinemaData);

		/****************************************************/
		JPanel w_paneTheater = new JPanel();
		w_paneTheater.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Tiyatrolar", null, w_paneTheater, null);
		w_paneTheater.setLayout(null);

		JScrollPane scrollPane_Theater = new JScrollPane();
		scrollPane_Theater.setBounds(0, 0, 485, 461);
		w_paneTheater.add(scrollPane_Theater);

///////////////////////////////////////////////////////////////////////////////////Tiyatro Sütun Özellikleri
		table_Theater = new JTable(tiyatroModel);
		table_Theater.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_Theater.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrollPane_Theater.setViewportView(table_Theater);
		table_Theater.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_Theater.getColumnModel().getColumn(0).setResizable(false);

		table_Theater.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_Theater.getColumnModel().getColumn(1).setResizable(false);
		// table_Sinema.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Theater.getColumnModel().getColumn(2).setResizable(false);
		table_Theater.getColumnModel().getColumn(3).setPreferredWidth(10);
		table_Theater.getColumnModel().getColumn(3).setResizable(false);
		table_Theater.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_Theater.getColumnModel().getColumn(4).setResizable(false);

		JPanel w_paneConcert = new JPanel();
		w_paneConcert.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Konserler", null, w_paneConcert, null);

		w_paneConcert.setLayout(null);

		JScrollPane scrollPane_Concert = new JScrollPane();
		scrollPane_Concert.setBounds(0, 0, 485, 461);
		w_paneConcert.add(scrollPane_Concert);

		table_Concert = new JTable();
		scrollPane_Concert.setViewportView(table_Concert);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////// PANESÝNEMA///////////////////////////////////////////////////////////////
		JPanel PaneCinema = new JPanel();
		PaneCinema.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneCinema.setBackground(SystemColor.inactiveCaption);
		PaneCinema.setBounds(486, 57, 489, 504);
		contentPane.add(PaneCinema);
		PaneCinema.setLayout(null);

		JButton btn_BuyTicket = new JButton("Bilet Al");
		btn_BuyTicket.setBounds(195, 468, 102, 30);
		PaneCinema.add(btn_BuyTicket);
		btn_BuyTicket.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster = new JLabel("");
		lbl_Poster.setBounds(324, 35, 128, 161);
		PaneCinema.add(lbl_Poster);

		JLabel lbl_MovieName = new JLabel("Film Ad\u0131:");
		lbl_MovieName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieName.setBounds(33, 50, 107, 18);
		PaneCinema.add(lbl_MovieName);

		JLabel lbl_MovieType = new JLabel("Film T\u00FCr\u00FC:");
		lbl_MovieType.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieType.setBounds(33, 73, 107, 18);
		PaneCinema.add(lbl_MovieType);

		JLabel lbl_Admin = new JLabel("Y\u00F6netmen:");
		lbl_Admin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Admin.setBounds(33, 96, 107, 18);
		PaneCinema.add(lbl_Admin);

		JLabel lbl_Salon = new JLabel("Salon:");
		lbl_Salon.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon.setBounds(33, 119, 107, 18);
		PaneCinema.add(lbl_Salon);

		JLabel lbl_Seance = new JLabel("Seans:");
		lbl_Seance.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Seance.setBounds(33, 143, 107, 18);
		PaneCinema.add(lbl_Seance);

		JButton btn_SelectSeat = new JButton("Koltuk Se\u00E7");
		btn_SelectSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeatSelection ks= new SeatSelection();
				ks.setVisible(true);
			}
		});
		btn_SelectSeat.setBounds(33, 164, 95, 23);
		PaneCinema.add(btn_SelectSeat);

		JLabel lbl_PaymentInformation = new JLabel("\u00D6deme Bilgileri");
		lbl_PaymentInformation.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_PaymentInformation.setBounds(33, 208, 128, 23);
		PaneCinema.add(lbl_PaymentInformation);

		JLabel lblMovieInfo = new JLabel("Film Bilgileri");
		lblMovieInfo.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblMovieInfo.setBounds(33, 20, 128, 23);
		PaneCinema.add(lblMovieInfo);

		JLabel lbl_MovieName_1 = new JLabel("Ad:");
		lbl_MovieName_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieName_1.setBounds(33, 238, 107, 18);
		PaneCinema.add(lbl_MovieName_1);

		JLabel lbl_MovieType_1 = new JLabel("Soyad:");
		lbl_MovieType_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_MovieType_1.setBounds(33, 261, 107, 18);
		PaneCinema.add(lbl_MovieType_1);

		JLabel lbl_Admin_1 = new JLabel("E-Mail:");
		lbl_Admin_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Admin_1.setBounds(33, 284, 107, 18);
		PaneCinema.add(lbl_Admin_1);

		fld_MovieName = new JTextField();
		fld_MovieName.setBackground(Color.WHITE);
		fld_MovieName.setEditable(false);
		fld_MovieName.setBounds(140, 51, 128, 20);
		PaneCinema.add(fld_MovieName);
		fld_MovieName.setColumns(10);

		fld_MovieType = new JTextField();
		fld_MovieType.setBackground(Color.WHITE);
		fld_MovieType.setEditable(false);
		fld_MovieType.setColumns(10);
		fld_MovieType.setBounds(140, 74, 128, 20);
		PaneCinema.add(fld_MovieType);

		fld_Director = new JTextField();
		fld_Director.setBackground(Color.WHITE);
		fld_Director.setEditable(false);
		fld_Director.setColumns(10);
		fld_Director.setBounds(140, 97, 128, 20);
		PaneCinema.add(fld_Director);

		fld_Salon = new JTextField();
		fld_Salon.setBackground(Color.WHITE);
		fld_Salon.setEditable(false);
		fld_Salon.setColumns(10);
		fld_Salon.setBounds(140, 120, 42, 20);
		PaneCinema.add(fld_Salon);

		fld_SelectSeat = new JTextField();
		fld_SelectSeat.setBackground(Color.WHITE);
		fld_SelectSeat.setEditable(false);
		fld_SelectSeat.setColumns(10);
		fld_SelectSeat.setBounds(140, 165, 42, 20);
		PaneCinema.add(fld_SelectSeat);

		fld_Seance = new JTextField();
		fld_Seance.setBackground(Color.WHITE);
		fld_Seance.setEditable(false);
		fld_Seance.setColumns(10);
		fld_Seance.setBounds(140, 143, 42, 20);
		PaneCinema.add(fld_Seance);

		JLabel lbl_PaymentMethod = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_PaymentMethod.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_PaymentMethod.setBounds(33, 307, 128, 18);
		PaneCinema.add(lbl_PaymentMethod);

		JComboBox comboBox_Method = new JComboBox();
		comboBox_Method.setBounds(33, 326, 110, 22);
		comboBox_Method.addItem("Nakit ödeme");
		comboBox_Method.addItem("Kart ile ödeme");
		PaneCinema.add(comboBox_Method);

		JPanel w_pane_Kart = new JPanel();
		w_pane_Kart.setBackground(SystemColor.inactiveCaption);
		w_pane_Kart.setBounds(33, 359, 452, 98);
		PaneCinema.add(w_pane_Kart);
		w_pane_Kart.setLayout(null);
		w_pane_Kart.setVisible(false);
		comboBox_Method.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method.getSelectedIndex() == 0) {
					w_pane_Kart.setVisible(false);

				} else {
					w_pane_Kart.setVisible(true);
				}
			}
		});

		fld_Name = new JTextField();
		fld_Name.setText(member.getName());
		fld_Name.setEditable(false);
		fld_Name.setColumns(10);
		fld_Name.setBackground(Color.WHITE);
		fld_Name.setBounds(140, 238, 128, 20);
		PaneCinema.add(fld_Name);

		fld_Surname = new JTextField();
		fld_Surname.setText(member.getSurname());
		fld_Surname.setEditable(false);
		fld_Surname.setColumns(10);
		fld_Surname.setBackground(Color.WHITE);
		fld_Surname.setBounds(140, 261, 128, 20);
		PaneCinema.add(fld_Surname);

		fld_Mail = new JTextField();
		fld_Mail.setText(member.getEmail());
		fld_Mail.setEditable(false);
		fld_Mail.setColumns(10);
		fld_Mail.setBackground(Color.WHITE);
		fld_Mail.setBounds(140, 284, 128, 20);
		PaneCinema.add(fld_Mail);

		JLabel lbl_Price = new JLabel("Toplam Tutar");
		lbl_Price.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Price.setBounds(322, 207, 154, 47);
		PaneCinema.add(lbl_Price);

		fld_Price = new JTextField();
		fld_Price.setBackground(Color.WHITE);
		fld_Price.setEditable(false);
		fld_Price.setBounds(322, 247, 130, 55);
		PaneCinema.add(fld_Price);
		fld_Price.setColumns(10);

		JLabel lbl_CartName = new JLabel("Kart \u00FCzerindeki \u0130sim:");
		lbl_CartName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartName.setBounds(10, 11, 123, 14);
		w_pane_Kart.add(lbl_CartName);

		JLabel lbl_CartNumber = new JLabel("Kart Numaras\u0131:");
		lbl_CartNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartNumber.setBounds(10, 34, 123, 14);
		w_pane_Kart.add(lbl_CartNumber);

		JLabel lbl_LastUsageDate = new JLabel("Son Kullan\u0131m Tarihi:");
		lbl_LastUsageDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_LastUsageDate.setBounds(10, 56, 123, 14);
		w_pane_Kart.add(lbl_LastUsageDate);

		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setBounds(143, 53, 60, 22);
		comboBox_Month.addItem("Ay");
		for(int m=1;m<=12;m++)
		{
		comboBox_Month.addItem(m);
		}
		w_pane_Kart.add(comboBox_Month);

		JComboBox comboBox_Year = new JComboBox();
		comboBox_Year.setBounds(210, 53, 72, 22);
		comboBox_Year.addItem("Yýl");
		for(int y=2021;y<=2030;y++)
		{
		comboBox_Year.addItem(y);
		}
	
		w_pane_Kart.add(comboBox_Year);

		JLabel lbl_Cvc = new JLabel("CVC:");
		lbl_Cvc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Cvc.setBounds(317, 56, 46, 14);
		w_pane_Kart.add(lbl_Cvc);

		fld_cvc = new JTextField();
		fld_cvc.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc.setBounds(356, 54, 46, 20);
		fld_cvc.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_cvc.getText().length()<=2 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_cvc.setEditable(true);
	            }
	            else {
	            	fld_cvc.setEditable(false);
	            }
	            
	            } else{
	            	fld_cvc.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Kart.add(fld_cvc);
		fld_cvc.setColumns(10);
		

		fld_CartName = new JTextField();
		fld_CartName.setColumns(10);
		fld_CartName.setBackground(Color.WHITE);
		fld_CartName.setBounds(143, 9, 139, 20);
		fld_CartName.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar()==' '|| (ke.getKeyChar()=='ý'|| ke.getKeyChar()=='ð' || ke.getKeyChar()=='ü' || ke.getKeyChar()=='þ' || ke.getKeyChar()=='ö' || ke.getKeyChar()=='ç'||ke.getKeyChar()=='Ý'|| ke.getKeyChar()=='Ð' || ke.getKeyChar()=='Ü' || ke.getKeyChar()=='Þ' || ke.getKeyChar()=='Ö' || ke.getKeyChar()=='Ç'  )||(ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') || (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_CartName.getText().length()<=15 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_CartName.setEditable(true);
	            }
	            else {
	            	fld_CartName.setEditable(false);
	            }
	            
	            } else{
	            	fld_CartName.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Kart.add(fld_CartName);
		
		fld_CartNumber = new JTextField();
		fld_CartNumber.setColumns(10);
		fld_CartNumber.setBackground(Color.WHITE);
		fld_CartNumber.setBounds(143, 31, 139, 20);
		fld_CartNumber.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_CartNumber.getText().length()<=15 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_CartNumber.setEditable(true);
	            }
	            else {
	            	fld_CartNumber.setEditable(false);
	            }
	            
	            } else{
	            	fld_CartNumber.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Kart.add(fld_CartNumber);

		JButton btn_CancelTicket = new JButton("Bilet \u0130ptal");
		btn_CancelTicket.setForeground(SystemColor.menu);
		btn_CancelTicket.setBackground(SystemColor.textHighlight);
		btn_CancelTicket.setBounds(317, 464, 92, 35);
		PaneCinema.add(btn_CancelTicket);
		btn_CancelTicket.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));

		JButton btn_MyTickets = new JButton("Biletlerim");
		btn_MyTickets.setForeground(SystemColor.menu);
		btn_MyTickets.setBackground(SystemColor.textHighlight);
		btn_MyTickets.setBounds(82, 464, 92, 35);
		PaneCinema.add(btn_MyTickets);
		btn_MyTickets.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		///////////////////////////////////////////////// PANESÝNEMA/////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////// PANETÝYATRO///////////////////////////////////////////////////////////////
		JPanel PaneTheater = new JPanel();
		PaneTheater.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneTheater.setBackground(SystemColor.inactiveCaption);
		PaneTheater.setBounds(486, 57, 489, 504);
		contentPane.add(PaneTheater);
		PaneTheater.setLayout(null);

		JButton btn_BuyTicket2 = new JButton("Bilet Al");
		btn_BuyTicket2.setBounds(195, 468, 102, 30);
		PaneTheater.add(btn_BuyTicket2);
		btn_BuyTicket2.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster2 = new JLabel("");
		lbl_Poster2.setBounds(324, 35, 128, 161);
		PaneTheater.add(lbl_Poster2);

		JLabel lbl_GameName = new JLabel("Oyun Adý:");
		lbl_GameName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_GameName.setBounds(33, 50, 107, 18);
		PaneTheater.add(lbl_GameName);

		JLabel lbl_GameType = new JLabel("Oyun Türü:");
		lbl_GameType.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_GameType.setBounds(33, 73, 107, 18);
		PaneTheater.add(lbl_GameType);

		JLabel lbl_Date = new JLabel("Tarih:");
		lbl_Date.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Date.setBounds(33, 96, 107, 18);
		PaneTheater.add(lbl_Date);

		JLabel lbl_Salon2 = new JLabel("Salon:");
		lbl_Salon2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon2.setBounds(33, 119, 107, 18);
		PaneTheater.add(lbl_Salon2);

		JLabel lbl_Time = new JLabel("Saat:");
		lbl_Time.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Time.setBounds(33, 143, 107, 18);
		PaneTheater.add(lbl_Time);

		JButton btn_SelectSeat2 = new JButton("Koltuk Seç");
		btn_SelectSeat2.setBounds(33, 164, 95, 23);
		PaneTheater.add(btn_SelectSeat2);

		JLabel lbl_PaymentInfo2 = new JLabel("Ödeme Bilgileri");
		lbl_PaymentInfo2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_PaymentInfo2.setBounds(33, 208, 128, 23);
		PaneTheater.add(lbl_PaymentInfo2);

		JLabel lblTheaterInfo = new JLabel("Tiyatro Bilgileri");
		lblTheaterInfo.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblTheaterInfo.setBounds(33, 20, 144, 23);
		PaneTheater.add(lblTheaterInfo);

		JLabel lbl_GameName_2 = new JLabel("Ad:");
		lbl_GameName_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_GameName_2.setBounds(33, 238, 107, 18);
		PaneTheater.add(lbl_GameName_2);

		JLabel lbl_GameType_2 = new JLabel("Soyad:");
		lbl_GameType_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_GameType_2.setBounds(33, 261, 107, 18);
		PaneTheater.add(lbl_GameType_2);

		JLabel lbl_Date_2 = new JLabel("E-Mail:");
		lbl_Date_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Date_2.setBounds(33, 284, 107, 18);
		PaneTheater.add(lbl_Date_2);

		fld_GameName = new JTextField();
		fld_GameName.setBackground(Color.WHITE);
		fld_GameName.setEditable(false);
		fld_GameName.setBounds(140, 51, 128, 20);
		PaneTheater.add(fld_GameName);
		fld_GameName.setColumns(10);

		fld_GameType = new JTextField();
		fld_GameType.setBackground(Color.WHITE);
		fld_GameType.setEditable(false);
		fld_GameType.setColumns(10);
		fld_GameType.setBounds(140, 74, 128, 20);
		PaneTheater.add(fld_GameType);

		fld_Director2 = new JTextField();
		fld_Director2.setBackground(Color.WHITE);
		fld_Director2.setEditable(false);
		fld_Director2.setColumns(10);
		fld_Director2.setBounds(140, 97, 128, 20);
		PaneTheater.add(fld_Director2);

		fld_Salon2 = new JTextField();
		fld_Salon2.setBackground(Color.WHITE);
		fld_Salon2.setEditable(false);
		fld_Salon2.setColumns(10);
		fld_Salon2.setBounds(140, 120, 42, 20);
		PaneTheater.add(fld_Salon2);

		fld_SeatSelection2 = new JTextField();
		fld_SeatSelection2.setBackground(Color.WHITE);
		fld_SeatSelection2.setEditable(false);
		fld_SeatSelection2.setColumns(10);
		fld_SeatSelection2.setBounds(140, 165, 42, 20);
		PaneTheater.add(fld_SeatSelection2);

		fld_Time = new JTextField();
		fld_Time.setBackground(Color.WHITE);
		fld_Time.setEditable(false);
		fld_Time.setColumns(10);
		fld_Time.setBounds(140, 143, 42, 20);
		PaneTheater.add(fld_Time);

		JLabel lbl_PaymentMethod2 = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_PaymentMethod2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_PaymentMethod2.setBounds(33, 307, 128, 18);
		PaneTheater.add(lbl_PaymentMethod2);

		JComboBox comboBox_Method2 = new JComboBox();
		comboBox_Method2.setBounds(33, 326, 110, 22);
		comboBox_Method2.addItem("Nakit ödeme");
		comboBox_Method2.addItem("Kart ile ödeme");
		PaneTheater.add(comboBox_Method2);

		JPanel w_pane_Cart2 = new JPanel();
		w_pane_Cart2.setBackground(SystemColor.inactiveCaption);
		w_pane_Cart2.setBounds(33, 359, 452, 98);
		PaneTheater.add(w_pane_Cart2);
		w_pane_Cart2.setLayout(null);
		w_pane_Cart2.setVisible(false);
		comboBox_Method2.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method2.getSelectedIndex() == 0) {
					w_pane_Cart2.setVisible(false);

				} else {
					w_pane_Cart2.setVisible(true);
				}
			}
		});

		fld_Name2 = new JTextField();
		fld_Name2.setEditable(false);
		fld_Name2.setColumns(10);
		fld_Name2.setBackground(Color.WHITE);
		fld_Name2.setBounds(140, 238, 128, 20);
		PaneTheater.add(fld_Name2);

		fld_Surname2 = new JTextField();
		fld_Surname2.setEditable(false);
		fld_Surname2.setColumns(10);
		fld_Surname2.setBackground(Color.WHITE);
		fld_Surname2.setBounds(140, 261, 128, 20);
		PaneTheater.add(fld_Surname2);

		fld_Mail2 = new JTextField();
		fld_Mail2.setEditable(false);
		fld_Mail2.setColumns(10);
		fld_Mail2.setBackground(Color.WHITE);
		fld_Mail2.setBounds(140, 284, 128, 20);
		PaneTheater.add(fld_Mail2);

		JLabel lbl_Price2 = new JLabel("Toplam Tutar");
		lbl_Price2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Price2.setBounds(322, 207, 154, 47);
		PaneTheater.add(lbl_Price2);

		fld_Price2 = new JTextField();
		fld_Price2.setBackground(Color.WHITE);
		fld_Price2.setEditable(false);
		fld_Price2.setBounds(322, 247, 130, 55);
		PaneTheater.add(fld_Price2);
		fld_Price2.setColumns(10);

		JLabel lbl_CartName2 = new JLabel("Kart \u00FCzerindeki \u0130sim:");
		lbl_CartName2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartName2.setBounds(10, 11, 123, 14);
		w_pane_Cart2.add(lbl_CartName2);

		JLabel lbl_CartNumber2 = new JLabel("Kart Numaras\u0131:");
		lbl_CartNumber2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartNumber2.setBounds(10, 34, 123, 14);
		w_pane_Cart2.add(lbl_CartNumber2);

		JLabel lbl_LastUsageDate2 = new JLabel("Son Kullan\u0131m Tarihi:");
		lbl_LastUsageDate2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_LastUsageDate2.setBounds(10, 56, 123, 14);
		w_pane_Cart2.add(lbl_LastUsageDate2);

		JComboBox comboBox_Month2 = new JComboBox();
		comboBox_Month2.setBounds(143, 53, 60, 22);
		comboBox_Month2.addItem("Ay");
		for(int m2=1;m2<=12;m2++)
		{
		comboBox_Month2.addItem(m2);
		}
		w_pane_Cart2.add(comboBox_Month2);

		JComboBox comboBox_Year2 = new JComboBox();
		comboBox_Year2.setBounds(210, 53, 72, 22);
		comboBox_Year2.addItem("Yýl");
		for(int y2=2021;y2<=2030;y2++)
		{
		comboBox_Year2.addItem(y2);
		}
		w_pane_Cart2.add(comboBox_Year2);

		JLabel lbl_Cvc2 = new JLabel("CVC:");
		lbl_Cvc2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Cvc2.setBounds(317, 56, 46, 14);
		w_pane_Cart2.add(lbl_Cvc2);

		fld_cvc2 = new JTextField();
		fld_cvc2.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc2.setBounds(356, 54, 46, 20);
		fld_cvc2.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_cvc2.getText().length()<=2 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_cvc2.setEditable(true);
	            }
	            else {
	            	fld_cvc2.setEditable(false);
	            }
	            
	            } else{
	            	fld_cvc2.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Cart2.add(fld_cvc2);
		fld_cvc2.setColumns(10);

		fld_CartName2 = new JTextField();
		fld_CartName2.setColumns(10);
		fld_CartName2.setBackground(Color.WHITE);
		fld_CartName2.setBounds(143, 9, 139, 20);
		fld_CartName2.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar()==' '|| (ke.getKeyChar()=='ý'|| ke.getKeyChar()=='ð' || ke.getKeyChar()=='ü' || ke.getKeyChar()=='þ' || ke.getKeyChar()=='ö' || ke.getKeyChar()=='ç'||ke.getKeyChar()=='Ý'|| ke.getKeyChar()=='Ð' || ke.getKeyChar()=='Ü' || ke.getKeyChar()=='Þ' || ke.getKeyChar()=='Ö' || ke.getKeyChar()=='Ç'  )||(ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') || (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_CartName2.getText().length()<=15 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_CartName2.setEditable(true);
	            }
	            else {
	            	fld_CartName2.setEditable(false);
	            }
	            
	            } else{
	            	fld_CartName2.setEditable(false);
	            	
	            }
	         }
	      });
		
		w_pane_Cart2.add(fld_CartName2);

		fld_CartNumber2 = new JTextField();
		fld_CartNumber2.setColumns(10);
		fld_CartNumber2.setBackground(Color.WHITE);
		fld_CartNumber2.setBounds(143, 31, 139, 20);
		fld_CartNumber2.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_CartNumber2.getText().length()<=15 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_CartNumber2.setEditable(true);
	            }
	            else {
	            	fld_CartNumber2.setEditable(false);
	            }
	            
	            } else{
	            	fld_CartNumber2.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Cart2.add(fld_CartNumber2);

		JButton btn_MyTickets_1 = new JButton("Biletlerim");
		btn_MyTickets_1.setForeground(SystemColor.menu);
		btn_MyTickets_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_MyTickets_1.setBackground(SystemColor.textHighlight);
		btn_MyTickets_1.setBounds(82, 464, 92, 35);
		PaneTheater.add(btn_MyTickets_1);

		JButton btn_TicketCancel_1 = new JButton("Bilet \u0130ptal");
		btn_TicketCancel_1.setForeground(SystemColor.menu);
		btn_TicketCancel_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_TicketCancel_1.setBackground(SystemColor.textHighlight);
		btn_TicketCancel_1.setBounds(317, 464, 92, 35);
		PaneTheater.add(btn_TicketCancel_1);
		PaneTheater.setVisible(false);
		///////////////////////////////////////////////////// PANETÝYATRO////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////// PANEKONSERs///////////////////////////////////////////////////////////////
		JPanel PaneConcert = new JPanel();
		PaneConcert.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209),
				new Color(153, 180, 209), new Color(153, 180, 209)));
		PaneConcert.setBackground(SystemColor.inactiveCaption);
		PaneConcert.setBounds(486, 57, 489, 504);
		contentPane.add(PaneConcert);
		PaneConcert.setLayout(null);

		JButton btn_BuyTicket3 = new JButton("Bilet Al");
		btn_BuyTicket3.setBounds(195, 468, 102, 30);
		PaneConcert.add(btn_BuyTicket3);
		btn_BuyTicket3.setFont(new Font("Sitka Display", Font.BOLD, 18));

		JLabel lbl_Poster3 = new JLabel("");
		lbl_Poster3.setBounds(324, 35, 128, 161);
		PaneConcert.add(lbl_Poster3);

		JLabel lbl_ConcertName = new JLabel("Konser Adý:");
		lbl_ConcertName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_ConcertName.setBounds(33, 50, 107, 18);
		PaneConcert.add(lbl_ConcertName);

		JLabel lbl_ConcertType = new JLabel("Konser Türü:");
		lbl_ConcertType.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_ConcertType.setBounds(33, 73, 107, 18);
		PaneConcert.add(lbl_ConcertType);

		JLabel lbl_Date2 = new JLabel("Tarih:");
		lbl_Date2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Date2.setBounds(33, 96, 107, 18);
		PaneConcert.add(lbl_Date2);

		JLabel lbl_Salon3 = new JLabel("Salon:");
		lbl_Salon3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Salon3.setBounds(33, 119, 107, 18);
		PaneConcert.add(lbl_Salon3);

		JLabel lbl_Time2 = new JLabel("Saat:");
		lbl_Time2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Time2.setBounds(33, 143, 107, 18);
		PaneConcert.add(lbl_Time2);

		JButton btn_SeatSelection3 = new JButton("Koltuk Seç");
		btn_SeatSelection3.setBounds(33, 164, 95, 23);
		PaneConcert.add(btn_SeatSelection3);

		JLabel lbl_PaymentInfo3 = new JLabel("Ödeme Bilgileri");
		lbl_PaymentInfo3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lbl_PaymentInfo3.setBounds(33, 208, 128, 23);
		PaneConcert.add(lbl_PaymentInfo3);

		JLabel lblConcertInfo = new JLabel("Konser Bilgileri");
		lblConcertInfo.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblConcertInfo.setBounds(33, 20, 144, 23);
		PaneConcert.add(lblConcertInfo);

		JLabel lbl_ConcertName_2 = new JLabel("Ad:");
		lbl_ConcertName_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_ConcertName_2.setBounds(33, 238, 107, 18);
		PaneConcert.add(lbl_ConcertName_2);

		JLabel lbl_ConcertType_2 = new JLabel("Soyad:");
		lbl_ConcertType_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_ConcertType_2.setBounds(33, 261, 107, 18);
		PaneConcert.add(lbl_ConcertType_2);

		JLabel lbl_Date_3 = new JLabel("E-Mail:");
		lbl_Date_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_Date_3.setBounds(33, 284, 107, 18);
		PaneConcert.add(lbl_Date_3);

		fld_ConcertName = new JTextField();
		fld_ConcertName.setBackground(Color.WHITE);
		fld_ConcertName.setEditable(false);
		fld_ConcertName.setBounds(140, 51, 128, 20);
		PaneConcert.add(fld_ConcertName);
		fld_ConcertName.setColumns(10);

		fld_ConcertType = new JTextField();
		fld_ConcertType.setBackground(Color.WHITE);
		fld_ConcertType.setEditable(false);
		fld_ConcertType.setColumns(10);
		fld_ConcertType.setBounds(140, 74, 128, 20);
		PaneConcert.add(fld_ConcertType);

		fld_Date2 = new JTextField();
		fld_Date2.setBackground(Color.WHITE);
		fld_Date2.setEditable(false);
		fld_Date2.setColumns(10);
		fld_Date2.setBounds(140, 97, 128, 20);
		PaneConcert.add(fld_Date2);

		fld_Salon3 = new JTextField();
		fld_Salon3.setBackground(Color.WHITE);
		fld_Salon3.setEditable(false);
		fld_Salon3.setColumns(10);
		fld_Salon3.setBounds(140, 120, 42, 20);
		PaneConcert.add(fld_Salon3);

		fld_SeatSelection3 = new JTextField();
		fld_SeatSelection3.setBackground(Color.WHITE);
		fld_SeatSelection3.setEditable(false);
		fld_SeatSelection3.setColumns(10);
		fld_SeatSelection3.setBounds(140, 165, 42, 20);
		PaneConcert.add(fld_SeatSelection3);

		fld_Time2 = new JTextField();
		fld_Time2.setBackground(Color.WHITE);
		fld_Time2.setEditable(false);
		fld_Time2.setColumns(10);
		fld_Time2.setBounds(140, 143, 42, 20);
		PaneConcert.add(fld_Time2);

		JLabel lbl_PaymentMethod3 = new JLabel("\u00D6deme Y\u00F6ntemi");
		lbl_PaymentMethod3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		lbl_PaymentMethod3.setBounds(33, 307, 128, 18);
		PaneConcert.add(lbl_PaymentMethod3);

		JComboBox comboBox_Method3 = new JComboBox();
		comboBox_Method3.setBounds(33, 326, 110, 22);
		comboBox_Method3.addItem("Nakit ödeme");
		comboBox_Method3.addItem("Kart ile ödeme");
		PaneConcert.add(comboBox_Method3);

		JPanel w_pane_Cart3 = new JPanel();
		w_pane_Cart3.setBackground(SystemColor.inactiveCaption);
		w_pane_Cart3.setBounds(33, 359, 452, 98);
		PaneConcert.add(w_pane_Cart3);
		w_pane_Cart3.setLayout(null);
		w_pane_Cart3.setVisible(false);
		comboBox_Method3.addItemListener(new ItemChangeListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (comboBox_Method3.getSelectedIndex() == 0) {
					w_pane_Cart3.setVisible(false);

				} else {
					w_pane_Cart3.setVisible(true);
				}
			}
		});

		fld_Name3 = new JTextField();
		fld_Name3.setEditable(false);
		fld_Name3.setColumns(10);
		fld_Name3.setBackground(Color.WHITE);
		fld_Name3.setBounds(140, 238, 128, 20);
		PaneConcert.add(fld_Name3);

		fld_Surname3 = new JTextField();
		fld_Surname3.setEditable(false);
		fld_Surname3.setColumns(10);
		fld_Surname3.setBackground(Color.WHITE);
		fld_Surname3.setBounds(140, 261, 128, 20);
		PaneConcert.add(fld_Surname3);

		fld_Mail3 = new JTextField();
		fld_Mail3.setEditable(false);
		fld_Mail3.setColumns(10);
		fld_Mail3.setBackground(Color.WHITE);
		fld_Mail3.setBounds(140, 284, 128, 20);
		PaneConcert.add(fld_Mail3);

		JLabel lbl_Price3 = new JLabel("Toplam Tutar");
		lbl_Price3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_Price3.setBounds(322, 207, 154, 47);
		PaneConcert.add(lbl_Price3);

		fld_Price3 = new JTextField();
		fld_Price3.setBackground(Color.WHITE);
		fld_Price3.setEditable(false);
		fld_Price3.setBounds(322, 247, 130, 55);
		PaneConcert.add(fld_Price3);
		fld_Price3.setColumns(10);

		JLabel lbl_CartName3 = new JLabel("Kart \u00FCzerindeki \u0130sim:");
		lbl_CartName3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartName3.setBounds(10, 11, 123, 14);
		w_pane_Cart3.add(lbl_CartName3);

		JLabel lbl_CartNumber3 = new JLabel("Kart Numaras\u0131:");
		lbl_CartNumber3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_CartNumber3.setBounds(10, 34, 123, 14);
		w_pane_Cart3.add(lbl_CartNumber3);

		JLabel lbl_LastUsageDate3 = new JLabel("Son Kullan\u0131m Tarihi:");
		lbl_LastUsageDate3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_LastUsageDate3.setBounds(10, 56, 123, 14);
		w_pane_Cart3.add(lbl_LastUsageDate3);

		JComboBox comboBox_Month3 = new JComboBox();
		comboBox_Month3.setBounds(143, 53, 60, 22);
		comboBox_Month3.addItem("Ay");
		for(int m3=1;m3<=12;m3++)
		{
		comboBox_Month3.addItem(m3);
		}
		w_pane_Cart3.add(comboBox_Month3);

		JComboBox comboBox_Year3 = new JComboBox();
		comboBox_Year3.setBounds(210, 53, 72, 22);
		comboBox_Year3.addItem("Yýl");
		for(int y3=2021;y3<=2030;y3++)
		{
		comboBox_Year3.addItem(y3);
		}
		w_pane_Cart3.add(comboBox_Year3);

		JLabel lbl_Cvc3 = new JLabel("CVC:");
		lbl_Cvc3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Cvc3.setBounds(317, 56, 46, 14);
		w_pane_Cart3.add(lbl_Cvc3);

		fld_cvc3 = new JTextField();
		fld_cvc3.setHorizontalAlignment(SwingConstants.CENTER);
		fld_cvc3.setBounds(356, 54, 46, 20);
		fld_cvc3.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_cvc3.getText().length()<=2 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_cvc3.setEditable(true);
	            }
	            else {
	            	fld_cvc3.setEditable(false);
	            }
	            
	            } else{
	            	fld_cvc3.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Cart3.add(fld_cvc3);
		fld_cvc3.setColumns(10);

		fld_CartName3 = new JTextField();
		fld_CartName3.setColumns(10);
		fld_CartName3.setBackground(Color.WHITE);
		fld_CartName3.setBounds(143, 9, 139, 20);
		fld_CartName3.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar()==' '|| (ke.getKeyChar()=='ý'|| ke.getKeyChar()=='ð' || ke.getKeyChar()=='ü' || ke.getKeyChar()=='þ' || ke.getKeyChar()=='ö' || ke.getKeyChar()=='ç'||ke.getKeyChar()=='Ý'|| ke.getKeyChar()=='Ð' || ke.getKeyChar()=='Ü' || ke.getKeyChar()=='Þ' || ke.getKeyChar()=='Ö' || ke.getKeyChar()=='Ç'  )||(ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') || (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_CartName3.getText().length()<=15 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_CartName3.setEditable(true);
	            }
	            else {
	            	fld_CartName3.setEditable(false);
	            }
	            
	            } else{
	            	fld_CartName3.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Cart3.add(fld_CartName3);

		fld_CartNumber3 = new JTextField();
		fld_CartNumber3.setColumns(10);
		fld_CartNumber3.setBackground(Color.WHITE);
		fld_CartNumber3.setBounds(143, 31, 139, 20);
		fld_CartNumber3.addKeyListener(new KeyAdapter() {
			
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE ) {
	            	
	            if( fld_CartNumber3.getText().length()<=15 || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE )	
	            {
	            	fld_CartNumber3.setEditable(true);
	            }
	            else {
	            	fld_CartNumber3.setEditable(false);
	            }
	            
	            } else{
	            	fld_CartNumber3.setEditable(false);
	            	
	            }
	         }
	      });
		w_pane_Cart3.add(fld_CartNumber3);

		JButton btn_MyTickets_1_1 = new JButton("Biletlerim");
		btn_MyTickets_1_1.setForeground(SystemColor.menu);
		btn_MyTickets_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_MyTickets_1_1.setBackground(SystemColor.textHighlight);
		btn_MyTickets_1_1.setBounds(82, 464, 92, 35);
		PaneConcert.add(btn_MyTickets_1_1);

		JButton btn_TicketCancel_1_1 = new JButton("Bilet \u0130ptal");
		btn_TicketCancel_1_1.setForeground(SystemColor.menu);
		btn_TicketCancel_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btn_TicketCancel_1_1.setBackground(SystemColor.textHighlight);
		btn_TicketCancel_1_1.setBounds(317, 464, 92, 35);
		PaneConcert.add(btn_TicketCancel_1_1);
		
				JButton btn_SelectCinema = new JButton("Se\u00E7");
				btn_SelectCinema.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				btn_SelectCinema.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tabbedPane.getSelectedIndex()==0) {
						int selRow=table_Cinema.getSelectedRow();
						if (selRow >= 0) {
							String selCinemaName = table_Cinema.getModel().getValueAt(selRow, 0).toString();
							String selCinemaType = table_Cinema.getModel().getValueAt(selRow, 1).toString();
							String selCinemaDirector = table_Cinema.getModel().getValueAt(selRow, 2).toString();
							String selCinemaSalon = table_Cinema.getModel().getValueAt(selRow, 3).toString();
							String selCinemaSeance = table_Cinema.getModel().getValueAt(selRow, 4).toString();
							
							fld_MovieName.setText(selCinemaName);
							fld_MovieType.setText(selCinemaType);
							fld_Director.setText(selCinemaDirector);
							fld_Salon.setText(selCinemaSalon);
							fld_Seance.setText(selCinemaSeance);
							lbl_Poster.setText("Poster");//Poster, Film Kayýt iþleminde poster ekledikten sonra ayarlanýlacak
						
						} else {
							JOptionPane.showMessageDialog(null, "Lütfen Bir Sinema Seçiniz.","Mesaj",JOptionPane.INFORMATION_MESSAGE);
						}
						}
						///////////////////////////////////////////////////////////////
						if(tabbedPane.getSelectedIndex()==1) {
						int selRow1=table_Theater.getSelectedRow();
						if (selRow1 >= 0) {
							String selTheaterName = table_Theater.getModel().getValueAt(selRow1, 0).toString();
							String selTheaterType = table_Theater.getModel().getValueAt(selRow1, 1).toString();
							String selTheaterDirector = table_Theater.getModel().getValueAt(selRow1, 2).toString();
							String selTheaterSalon = table_Theater.getModel().getValueAt(selRow1, 3).toString();
							String selTheaterTime = table_Theater.getModel().getValueAt(selRow1, 4).toString();
							
							fld_GameName.setText(selTheaterName);
							fld_GameType.setText(selTheaterType);
							fld_Director2.setText(selTheaterDirector);
							fld_Salon2.setText(selTheaterSalon);
							fld_Time.setText(selTheaterTime);
							lbl_Poster2.setText("Poster1");//Poster, Film Kayýt iþleminde poster ekledikten sonra ayarlanýlacak
						
						} else {
							JOptionPane.showMessageDialog(null, "Lütfen Bir Tiyatro Oyunu Seçiniz.","Mesaj",JOptionPane.INFORMATION_MESSAGE);
						}
						}
						/////////////////////////////////////////////////////////////////Konser için henüz oluþturulmadý.
					}
				});
				btn_SelectCinema.setBounds(197, 526, 89, 30);
				contentPane.add(btn_SelectCinema);
		PaneConcert.setVisible(false);
///////////////////////////////////////////////////// PANEKONSER////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					PaneCinema.setVisible(true);
					PaneTheater.setVisible(false);
					PaneConcert.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 1) {
					PaneTheater.setVisible(true);
					PaneCinema.setVisible(false);
					PaneConcert.setVisible(false);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					PaneCinema.setVisible(false);
					PaneTheater.setVisible(false);
					PaneConcert.setVisible(true);
				}

			}

		});

	}
}