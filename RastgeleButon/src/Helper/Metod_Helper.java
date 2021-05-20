package Helper;

import javax.swing.*;

public class Metod_Helper {

	public static void buttonTextChange() {

		UIManager.put("OptionPane.cancelButtonText", "Ýptal");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");
		UIManager.put("OptionPane.noButtonText", "Hayýr");

	}

	public static void showMsg(String str) {
		String msg;
		buttonTextChange();
		switch (str) {

		case "fill":
			msg = "Lütfen boþ alanlarý doldurunuz";
			break;
		case "succes":
			msg = "Ýþlem baþarýyla tamamlandý";
			break;
		case "error":
			msg = "Tuhaf þeyler oluyor";

		default:
			msg = str;
		}

		JOptionPane.showConfirmDialog(null, msg, "Mesaj", JOptionPane.CLOSED_OPTION);

	}

	public static boolean confirm(String str) {

		String msg;
		buttonTextChange();
		switch (str) {

		case "sure":
			msg = "	Bu iþlemi gerçekleþtirmek istiyormusun";
			break;

		default:
			msg = str;
		}

		int result = JOptionPane.showConfirmDialog(null, msg, "Dikkat!", JOptionPane.YES_NO_OPTION);

		if (result == 0) {

			return true;

		} else {

			return false;

		}

	}

}
