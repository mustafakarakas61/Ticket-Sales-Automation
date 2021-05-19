package Packed;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.SeatHelper;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyTickets extends JFrame {
//comboBox_UserSeats.addItem(sh.getMemberSeat(mmbr.getID())+"");
	private JPanel contentPane;
	public static JLabel lbl_SeatsMember;
	private DefaultTableModel MyTicketsModel;
	private Object[] MyTicketsData = null;
	private static SeatHelper shelper = new SeatHelper();
	public static JTable table_MyTickets;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTickets frame = new MyTickets();
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
	public MyTickets() {
		
		MyTicketsModel = new DefaultTableModel();
		Object[] colMyTicktes = new Object[2];
		colMyTicktes[0] = "Film Adi";
		colMyTicktes[1] = "Koltuk No";
		
		MyTicketsModel.setColumnIdentifiers(colMyTicktes);
		MyTicketsData = new Object[2]; 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 297);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	    lbl_SeatsMember = new JLabel("");
		lbl_SeatsMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SeatsMember.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_SeatsMember.setBounds(10, 11, 414, 44);
		contentPane.add(lbl_SeatsMember);
		
		JScrollPane scrollPane_MyTickets = new JScrollPane();
		scrollPane_MyTickets.setBounds(1, 0, 157, 257);
		contentPane.add(scrollPane_MyTickets);
		
		table_MyTickets = new JTable(MyTicketsModel);
		scrollPane_MyTickets.setViewportView(table_MyTickets);
		

		table_MyTickets.getColumnModel().getColumn(0).setPreferredWidth(55);
		table_MyTickets.getColumnModel().getColumn(0).setResizable(false);
		table_MyTickets.getColumnModel().getColumn(1).setResizable(false);
		
		try {
			for (int i = 0; i < shelper.userSeatfilmTickets().size(); i++) {
				 
				MyTicketsData[0] =shelper.getFilm(shelper.userSeatfilmTickets().get(i).getFilmID());
				MyTicketsData[1] = shelper.userSeatfilmTickets().get(i).getSeatName();
				MyTicketsModel.addRow(MyTicketsData);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton btn_cancel = new JButton("Iptal et");
		btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	shelper.delMemberSeat(user, getName())
				
			}
		});
		btn_cancel.setBounds(178, 198, 148, 49);
		contentPane.add(btn_cancel);
		table_MyTickets.getColumn("Film Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_MyTickets.getColumn("Koltuk No").setCellEditor(new TableEditor(new JCheckBox()));
		
		
	}
}
