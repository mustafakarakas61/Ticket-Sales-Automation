import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemChangeListener implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
	          Object item = e.getItem();
		}		
	}

}
