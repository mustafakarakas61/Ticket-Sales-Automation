package Helper;

import javax.swing.*;

public class Metod_Helper {

	public static void buttonTextChange() {

		UIManager.put("OptionPane.cancelButtonText", "Iptal");
		UIManager.put("OptionPane.okButtonText", "Tamam");
		UIManager.put("OptionPane.yesButtonText", "Evet");
		UIManager.put("OptionPane.noButtonText", "Hayir");

	}

	public static void showMsg(String str) {
		String msg;
		buttonTextChange();
		switch (str) {

		case "fill":
			msg = "Lutfen bos alanlari doldurunuz";
			break;
		case "succes":
			msg = "Islem basariyla tamamlandi.";
			break;
		case "error":
			msg = "Tuhaf Seyler oluyor";

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
			msg = "	Bu islemi gerceklestirmek istiyor musunuz";
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
