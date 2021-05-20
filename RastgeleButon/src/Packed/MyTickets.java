package Packed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.DbHelper;
import Helper.Metod_Helper;
import Helper.SeatHelper;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;

public class MyTickets extends JFrame {
	private JPanel contentPane;
	public static JLabel lbl_SeatsMember;
	private static DefaultTableModel MyTicketsModel;
	private static Object[] MyTicketsData = null;
	DbHelper dbHelper = new DbHelper();

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyTickets.class.getResource("/Images/ticket.png")));
		setTitle("Bilet Satis Sistemi");
		setResizable(false);

		MyTicketsModel = new DefaultTableModel();
		Object[] colMyTicktes = new Object[2];
		colMyTicktes[0] = "Film Adi";
		colMyTicktes[1] = "Koltuk No";

		MyTicketsModel.setColumnIdentifiers(colMyTicktes);
		MyTicketsData = new Object[2];

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 240, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		lbl_SeatsMember = new JLabel("");
		lbl_SeatsMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SeatsMember.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_SeatsMember.setBounds(10, 11, 204, 44);
		contentPane.add(lbl_SeatsMember);

		JScrollPane scrollPane_MyTickets = new JScrollPane();
		scrollPane_MyTickets.setBounds(10, 10, 204, 265);
		contentPane.add(scrollPane_MyTickets);

		table_MyTickets = new JTable(MyTicketsModel);
		table_MyTickets.setFont(new Font("SansSerif", Font.PLAIN, 13));
		table_MyTickets.setBackground(new Color(245, 255, 250));
		scrollPane_MyTickets.setViewportView(table_MyTickets);

		table_MyTickets.getColumnModel().getColumn(0).setPreferredWidth(55);
		table_MyTickets.getColumnModel().getColumn(0).setResizable(false);
		table_MyTickets.getColumnModel().getColumn(1).setResizable(false);

		try {
			for (int i = 0; i < shelper.userSeatfilmTickets().size(); i++) {

				MyTicketsData[0] = shelper.getFilm(shelper.userSeatfilmTickets().get(i).getFilmID());
				MyTicketsData[1] = shelper.userSeatfilmTickets().get(i).getSeatName();
				MyTicketsModel.addRow(MyTicketsData);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		table_MyTickets.getColumn("Film Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_MyTickets.getColumn("Koltuk No").setCellEditor(new TableEditor(new JCheckBox()));
		JButton btn_cancel = new JButton("Iptal et");
		btn_cancel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_cancel.setBackground(new Color(255, 153, 153));
		btn_cancel.setFocusable(false);
		btn_cancel.setFont(new Font("SansSerif", Font.PLAIN, 15));

		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String seatName;
				int mbrID;

				mbrID = MainScreen.memberID;
				seatName = table_MyTickets.getValueAt(table_MyTickets.getSelectedRow(), 1).toString();

				try {
					boolean control;
					control = shelper.delMemberSeat(mbrID, seatName);
					if (control) {
						Metod_Helper.showMsg(seatName + " biletiniz iptal edildi.");
						updateTicketList();
					} else {

					}

				} catch (SQLException e1) {
					dbHelper.showErrorMessage(e1);
				}

			}
		});
		btn_cancel.setBounds(10, 280, 204, 40);
		contentPane.add(btn_cancel);

	}

	public static void updateTicketList() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_MyTickets.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < shelper.userSeatfilmTickets().size(); i++) {

			MyTicketsData[0] = shelper.getFilm(shelper.userSeatfilmTickets().get(i).getFilmID());
			MyTicketsData[1] = shelper.userSeatfilmTickets().get(i).getSeatName();
			MyTicketsModel.addRow(MyTicketsData);
		}

	}

}