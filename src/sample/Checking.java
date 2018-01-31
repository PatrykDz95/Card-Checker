package sample;

import javafx.scene.control.TextField;
import java.util.ArrayList;

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

    public void ZerosInDate(TextField DDinput, TextField MMinput, TextField YYYYinput,
                            String OneDigitDay, String OneDigitMonth) {
        try {
            if(DDinput.getText().length()==1){
                OneDigitDay = (String.format(0 + DDinput.getText()));
            }else{
                  OneDigitDay = DDinput.getText();
            }
            if(MMinput.getText().length()==1){
                  OneDigitMonth = ( String.format(0 + MMinput.getText()));
            }else{
                 OneDigitMonth = MMinput.getText();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public void CompanyNumbers( String cardNumbWithoutSpaces, TextField Company){
        ArrayList<String> listOfPattern=new ArrayList<>();

        String ptVisa = "^4[0-9]{6,}$";
        listOfPattern.add(ptVisa);
        String ptMasterCard = "^5[1-5][0-9]{5,}$";
        listOfPattern.add(ptMasterCard);
        String ptAmeExp = "^3[47][0-9]{5,}$";
        listOfPattern.add(ptAmeExp);
        String ptDinClb = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$";
        listOfPattern.add(ptDinClb);
        String ptDiscover = "^6(?:011|5[0-9]{2})[0-9]{3,}$";
        listOfPattern.add(ptDiscover);
        String ptJcb = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$";
        listOfPattern.add(ptJcb);

        for(String p : listOfPattern){
            if(cardNumbWithoutSpaces.matches(p)){
                Company.setText(CompanyName(p));
                break;
            }
        }

        }

        String CompanyName (String p){
        if(p.equals("^4[0-9]{6,}$")){
            return "Visa";
        }else if(p.equals("^5[1-5][0-9]{5,}$")){
                return "MasterCard";
        }else if(p.equals("^3[47][0-9]{5,}$")){
                return "American Express";
        }else if(p.equals("^3(?:0[0-5]|[68][0-9])[0-9]{4,}$")){
                return "Diners Club";
        }else if(p.equals("^6(?:011|5[0-9]{2})[0-9]{3,}$")){
            return "Discover";
        }else if(p.equals("^(?:2131|1800|35[0-9]{3})[0-9]{3,}$")){
            return "JCB";
        }
        return p;
        }


    }


