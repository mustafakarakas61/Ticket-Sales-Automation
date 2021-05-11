import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Main extends JFrame implements MouseListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		Connection conn;

		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3361/myfirstschema?user=root&password=Muskar61ts862.");
			System.out.println("Baðlanýldý");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Baðlanýlamadý");
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Main() throws SQLException {
		Connection conn;

		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3361/myfirstschema?user=root&password=Muskar61ts862.");
			System.out.println("Baðlanýldý");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Baðlanýlamadý");
		}

		///////////////////// *************************************************************//////////////////////////

		int sayi;
		sayi=getkoltukList(3);
	
		JButton btn = null;

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(9, 9, 8, 10));
		for (int i = 0; i < sayi; i++) {
			if (i < 10) {
				btn = new JButton("A" + i);
				contentPane.add(btn);
				try {
					ButonEkle("A" + i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 20) {
				btn = new JButton("B" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("B" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 30) {
				btn = new JButton("C" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("C" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 40) {
				btn = new JButton("D" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("D" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 50) {
				btn = new JButton("E" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("E" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 60) {
				btn = new JButton("F" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("F" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 70) {
				btn = new JButton("G" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("G" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 80) {
				btn = new JButton("H" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("H" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 90) {
				btn = new JButton("I" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("I" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i < 100) {
				btn = new JButton("J" + i % 10);
				contentPane.add(btn);
				try {
					ButonEkle("J" + i % 10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			btn.addMouseListener(this);

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		dispose();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getComponent();

		b.setBackground(Color.green);
		JPopupMenu pm = new JPopupMenu();
		JMenuItem satinAl = new JMenuItem("Satýn Al");
		pm.add(satinAl);
		b.setComponentPopupMenu(pm);
		satinAl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				dispose();
			}
		});
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getComponent();
		b.setBackground(null);

	}

	// -------------------------**********************************************------------------------------------
	public boolean ButonEkle(String Name) throws SQLException {
		int key = 0;
		String sorgu = "INSERT INTO butonolay" + "(Name) VALUES" + "(?)";
		boolean duplicate = false;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		Connection conn;
		conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3361/myfirstschema?user=root&password=Muskar61ts862.");
		st = conn.createStatement();
		rs = st.executeQuery("SELECT * FROM butonolay WHERE Name='" + Name + "'");
		while (rs.next()) {
			duplicate = true;

			break;
		}
		if (!duplicate) {
			preparedStatement = conn.prepareStatement(sorgu);
			preparedStatement.setString(1, Name);
			preparedStatement.executeUpdate();
			key = 1;
		}
		if (key == 1)
			return true;
		else
			return false;
	}

public  int getkoltukList(int idkoltuksayisi) throws SQLException {

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	Connection conn;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3361/myfirstschema?user=root&password=Muskar61ts862.");

	try {
		st = conn.createStatement();
		rs = st.executeQuery("SELECT * FROM koltuksayisi WHERE  idkoltuksayisi= " + idkoltuksayisi);
		while (rs.next()) {
		return	rs.getInt("koltuksayisi");
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return 1;


}
}
