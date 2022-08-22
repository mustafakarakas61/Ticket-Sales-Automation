package Packed;

import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

public class TableEditor extends DefaultCellEditor {
	public TableEditor(JCheckBox checkBox) {
		super(checkBox);
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		return false;
	}
}