package Helper;

import javax.swing.JButton;

public class SeatHelper extends JButton {
	private int row,col,count;
	private boolean SeatOn,SeatOff,SeatSelect;
	public SeatHelper(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.count = count;
		this.SeatOn = false;
		this.SeatOff = false;
		this.SeatSelect = false;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isSeatOn() {
		return SeatOn;
	}
	public void setSeatOn(boolean seatOn) {
		SeatOn = seatOn;
	}
	public boolean isSeatOff() {
		return SeatOff;
	}
	public void setSeatOff(boolean seatOff) {
		SeatOff = seatOff;
	}
	public boolean isSeatSelect() {
		return SeatSelect;
	}
	public void setSeatSelect(boolean seatSelect) {
		SeatSelect = seatSelect;
	}
}
