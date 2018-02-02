package sample;

import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.util.Date;

public class Checking {

    public void CompanyName(String cardNumbWithoutSpaces, TextField Company){

        if(cardNumbWithoutSpaces.matches("^4[0-9]{6,}$")){
            Company.setText("Visa");
        }else if(cardNumbWithoutSpaces.matches("^5[1-5][0-9]{5,}$")){
            Company.setText("MasterCard");
        }else if(cardNumbWithoutSpaces.matches("^3[47][0-9]{5,}$")){
            Company.setText("American Express");
        }else if(cardNumbWithoutSpaces.matches("^3(?:0[0-5]|[68][0-9])[0-9]{4,}$")){
            Company.setText("Diners Club");
        }else if(cardNumbWithoutSpaces.matches("^6(?:011|5[0-9]{2})[0-9]{3,}$")){
            Company.setText("Discover");
        }else if(cardNumbWithoutSpaces.matches("^(?:2131|1800|35[0-9]{3})[0-9]{3,}$")){
            Company.setText("JCB");
        }else {
            Company.setText("Not Available");
        }
    }

    public boolean DayMonthInput(int dayBox, int monthBox) {
        return dayBox <= 31 && monthBox <= 12;
    }


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

    public Date ZerosInDate(TextField DDinput, TextField MMinput, TextField YYYYinput,
                            String OneDigitDay, String OneDigitMonth, Date inputDate,  DateFormat df) {
        try {
            if(DDinput.getText().length()==1){
                OneDigitDay = (String.format( 0 + DDinput.getText()));
            }else{
                OneDigitDay = DDinput.getText();
            }
            if(MMinput.getText().length()==1){
                OneDigitMonth = (String.format( 0 + MMinput.getText()));
            }else{
                OneDigitMonth = MMinput.getText();
            }

            inputDate = df.parse(OneDigitDay + OneDigitMonth + YYYYinput.getText());
        } catch (Exception e) {
            e.getStackTrace();
        }
        return inputDate;
    }
    }


