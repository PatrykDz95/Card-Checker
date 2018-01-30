package sample;

import javafx.scene.control.TextField;
import java.text.DateFormat;
import java.util.Date;

public class Checking {

    public boolean LuhnAlgorithm(String CardNumbNoSpace) {
        int sum = 0;
        boolean alternate = false;
        for (int i = CardNumbNoSpace.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(CardNumbNoSpace.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    public boolean DayMonthInput(int dayBox, int monthBox) {
        return dayBox <= 31 && monthBox <= 12;
    }

    public void ZerosInDate(TextField DDinput, TextField MMinput,
                               TextField YYYYinput, DateFormat df, Date inputDate) {

        try {

            if (DDinput.getText().length() == 1) {
                inputDate = df.parse(0 + DDinput.getText() + MMinput.getText() + YYYYinput.getText());
            } else if (MMinput.getText().length() == 1) {
                inputDate = df.parse(DDinput.getText() + 0 + MMinput.getText() + YYYYinput.getText());
            } else if (DDinput.getText().length() == 1 && MMinput.getText().length() == 1) {
                inputDate = df.parse(0 + DDinput.getText() + 0 + MMinput.getText() + YYYYinput.getText());
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

}
