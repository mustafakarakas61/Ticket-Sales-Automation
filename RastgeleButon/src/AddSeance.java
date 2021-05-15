import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Helper.Metod_Helper;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddSeance extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSeance frame = new AddSeance();
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
	
	public AddSeance() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeance = new JLabel("Seans:");
		lblSeance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeance.setBounds(10, 31, 80, 31);
		contentPane.add(lblSeance);
		
		JPanel SeanceHours = new JPanel();
		SeanceHours.setBackground(Color.WHITE);
		SeanceHours.setBounds(60, 31, 347, 139);
		contentPane.add(SeanceHours);
		SeanceHours.setLayout(null);
		
		JRadioButton rdbtn0 = new JRadioButton("10:00 ");
		rdbtn0.setBounds(6, 6, 103, 21);
		SeanceHours.add(rdbtn0);
		
		
		JRadioButton rdbtn1 = new JRadioButton("11:00");
		rdbtn1.setBounds(122, 6, 103, 21);
		SeanceHours.add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("12:00");
		rdbtn2.setBounds(238, 6, 103, 21);
		SeanceHours.add(rdbtn2);
		
		JRadioButton rdbtn8 = new JRadioButton("18:00");
		rdbtn8.setBounds(238, 76, 103, 21);
		SeanceHours.add(rdbtn8);
		
		JRadioButton rdbtn7 = new JRadioButton("17:00");
		rdbtn7.setBounds(122, 76, 103, 21);
		SeanceHours.add(rdbtn7);
		
		JRadioButton rdbtn6 = new JRadioButton("16:00");
		rdbtn6.setBounds(6, 76, 103, 21);
		SeanceHours.add(rdbtn6);
		
		JRadioButton rdbtn11 = new JRadioButton("21:00");
		rdbtn11.setBounds(238, 112, 103, 21);
		SeanceHours.add(rdbtn11);
		
		JRadioButton rdbtn10 = new JRadioButton("20:00");
		rdbtn10.setBounds(122, 112, 103, 21);
		SeanceHours.add(rdbtn10);
		
		JRadioButton rdbtn9 = new JRadioButton("19:00");
		rdbtn9.setBounds(6, 112, 103, 21);
		SeanceHours.add(rdbtn9);
		
		JRadioButton rdbtn5 = new JRadioButton("15:00");
		rdbtn5.setBounds(238, 41, 103, 21);
		SeanceHours.add(rdbtn5);
		
		JRadioButton rdbtn4 = new JRadioButton("14:00");
		rdbtn4.setBounds(122, 41, 103, 21);
		SeanceHours.add(rdbtn4);
		
		JRadioButton rdbtn3 = new JRadioButton("13:00");
		rdbtn3.setBounds(6, 41, 103, 21);
		SeanceHours.add(rdbtn3);		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtn0);
		bg.add(rdbtn1);
		bg.add(rdbtn2);
		bg.add(rdbtn3);
		bg.add(rdbtn4);
		bg.add(rdbtn5);
		bg.add(rdbtn6);
		bg.add(rdbtn7);
		bg.add(rdbtn8);
		bg.add(rdbtn9);
		bg.add(rdbtn10);
		bg.add(rdbtn11);
		
		JButton btn_AddSeance = new JButton("EKLE");
		btn_AddSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seance="";
				if(rdbtn0.isSelected()) {seance=rdbtn0.getText();}
				if(rdbtn1.isSelected()) {seance=rdbtn1.getText();}
				if(rdbtn2.isSelected()) {seance=rdbtn2.getText();}
				if(rdbtn3.isSelected()) {seance=rdbtn3.getText();}
				if(rdbtn4.isSelected()) {seance=rdbtn4.getText();}
				if(rdbtn5.isSelected()) {seance=rdbtn5.getText();}
				if(rdbtn6.isSelected()) {seance=rdbtn6.getText();}
				if(rdbtn7.isSelected()) {seance=rdbtn7.getText();}
				if(rdbtn8.isSelected()) {seance=rdbtn8.getText();}
				if(rdbtn9.isSelected()) {seance=rdbtn9.getText();}
				if(rdbtn10.isSelected()) {seance=rdbtn10.getText();}
				if(rdbtn11.isSelected()) {seance=rdbtn11.getText();}
				
				if(seance!="")
				{
					//db baðlancak				
					Metod_Helper.showMsg("Seans baþarýyla kaydedildi");
				}
				else if(seance=="")
				{
					Metod_Helper.showMsg("Lütfen Seans seçiniz!");
				}
				
				
				
			}
		});
		btn_AddSeance.setBounds(60, 196, 347, 35);
		contentPane.add(btn_AddSeance);
	}
			
	
}
//