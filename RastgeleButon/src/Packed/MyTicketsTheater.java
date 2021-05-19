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
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyTicketsTheater extends JFrame {
//comboBox_UserSeats.addItem(sh.getMemberSeat(mmbr.getID())+"");
	private JPanel contentPane;
	public static JLabel lbl_SeatsMember;
	private static DefaultTableModel MyTicketsTheaterModel;
	private static Object[] MyTicketsTheaterData = null;
	DbHelper dbHelper = new DbHelper();

	private static SeatHelper shelper = new SeatHelper();
	public static JTable table_MyTicketsTheater;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTicketsTheater frame = new MyTicketsTheater();
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
	public MyTicketsTheater() {
		setResizable(false);

		MyTicketsTheaterModel = new DefaultTableModel();
		Object[] colMyTicktesTheater = new Object[2];
		colMyTicktesTheater[0] = "Oyun Adi";
		colMyTicktesTheater[1] = "Koltuk No";

		MyTicketsTheaterModel.setColumnIdentifiers(colMyTicktesTheater);
		MyTicketsTheaterData = new Object[2];

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 297);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl_SeatsMember = new JLabel("");
		lbl_SeatsMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SeatsMember.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_SeatsMember.setBounds(10, 11, 414, 44);
		contentPane.add(lbl_SeatsMember);

		JScrollPane scrollPane_MyTicketsTheater = new JScrollPane();
		scrollPane_MyTicketsTheater.setBounds(1, 0, 196, 268);
		contentPane.add(scrollPane_MyTicketsTheater);

		table_MyTicketsTheater = new JTable(MyTicketsTheaterModel);
		table_MyTicketsTheater.setBackground(new Color(245, 255, 250));
		scrollPane_MyTicketsTheater.setViewportView(table_MyTicketsTheater);

		table_MyTicketsTheater.getColumnModel().getColumn(0).setPreferredWidth(55);
		table_MyTicketsTheater.getColumnModel().getColumn(0).setResizable(false);
		table_MyTicketsTheater.getColumnModel().getColumn(1).setResizable(false);

		try {
			for (int i = 0; i < shelper.userSeatTheaterTickets().size(); i++) {

				MyTicketsTheaterData[0] = shelper.getTheater(shelper.userSeatTheaterTickets().get(i).getFilmID());
				MyTicketsTheaterData[1] = shelper.userSeatTheaterTickets().get(i).getSeatName();
				MyTicketsTheaterModel.addRow(MyTicketsTheaterData);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		table_MyTicketsTheater.getColumn("Oyun Adi").setCellEditor(new TableEditor(new JCheckBox()));
		table_MyTicketsTheater.getColumn("Koltuk No").setCellEditor(new TableEditor(new JCheckBox()));
		JButton btn_cancel = new JButton("Iptal et");
		btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 17));

		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Kullanýcý ID ve koltuk ismini

				String seatName;
				int mbrID;
				mbrID = MainScreen.memberID;
				seatName = table_MyTicketsTheater.getValueAt(table_MyTicketsTheater.getSelectedRow(), 1).toString();

				try {
					boolean control;
					control = shelper.delMemberSeatTheater(mbrID, seatName);
					if (control) {
						Metod_Helper.showMsg(seatName + " biletiniz iptal edildi.");
						updateTicketListTheater();
					} else {

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					dbHelper.showErrorMessage(e1);
				}

			}
		});
		btn_cancel.setBounds(207, 194, 148, 49);
		contentPane.add(btn_cancel);

	}

	public static void updateTicketListTheater() throws SQLException {
		DefaultTableModel clearList = (DefaultTableModel) table_MyTicketsTheater.getModel();
		clearList.setRowCount(0);
		for (int i = 0; i < shelper.userSeatTheaterTickets().size(); i++) {

			MyTicketsTheaterData[0] = shelper.getTheater(shelper.userSeatTheaterTickets().get(i).getFilmID());
			MyTicketsTheaterData[1] = shelper.userSeatTheaterTickets().get(i).getSeatName();
			MyTicketsTheaterModel.addRow(MyTicketsTheaterData);
		}

	}

}