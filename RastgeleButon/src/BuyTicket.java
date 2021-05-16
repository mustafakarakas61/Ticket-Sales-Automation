import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class BuyTicket extends JFrame {

	private JPanel contentPane;
	 JTextField fld_movie_name;
	 JTextField fld_seance;
	 JTextField fld_seat;
	 JTextField fld_price;
	 public static String movie ,seance , seat ,price;

	public static String getMovie() {
		return movie;
	}

	public static void setMovie(String movie) {
		BuyTicket.movie = movie;
	}

	public static String getSeance() {
		return seance;
	}

	public static void setSeance(String seance) {
		BuyTicket.seance = seance;
	}

	public static String getSeat() {
		return seat;
	}

	public static void setSeat(String seats) {
		BuyTicket.seat = seats;
	}

	public static String getPrice() {
		return price;
	}

	public static void setPrice(String price) {
		BuyTicket.price = price;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyTicket frame = new BuyTicket();
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
	public BuyTicket() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Film : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(42, 31, 82, 29);
		panel.add(lblNewLabel);
		
		fld_movie_name = new JTextField();
		fld_movie_name.setText(movie);
		fld_movie_name.setEditable(false);
		fld_movie_name.setColumns(10);
		fld_movie_name.setBounds(126, 37, 188, 23);
		panel.add(fld_movie_name);
		
		JLabel lblSeans = new JLabel("Seans :");
		lblSeans.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeans.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSeans.setBounds(42, 73, 82, 29);
		panel.add(lblSeans);
		
		fld_seance = new JTextField();
		fld_seance.setText(seance);
		fld_seance.setEditable(false);
		fld_seance.setColumns(10);
		fld_seance.setBounds(126, 79, 188, 23);
		panel.add(fld_seance);
		
		JLabel lblKoltuklar = new JLabel("Koltuk/lar : ");
		lblKoltuklar.setHorizontalAlignment(SwingConstants.CENTER);
		lblKoltuklar.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblKoltuklar.setBounds(42, 114, 82, 29);
		panel.add(lblKoltuklar);
		
		fld_seat = new JTextField();
		fld_seat.setText(seat);
		fld_seat.setEditable(false);
		fld_seat.setColumns(10);
		fld_seat.setBounds(126, 120, 188, 23);
		panel.add(fld_seat);
		
		JLabel lblcret = new JLabel("\u00DCcret :");
		lblcret.setHorizontalAlignment(SwingConstants.CENTER);
		lblcret.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblcret.setBounds(42, 167, 82, 29);
		panel.add(lblcret);
		
		fld_price = new JTextField();
		fld_price.setText(price);
		fld_price.setEditable(false);
		fld_price.setColumns(10);
		fld_price.setBounds(126, 167, 188, 23);
		panel.add(fld_price);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(139, 312, 157, 29);
		panel.add(btnNewButton);
	}
}
