package sample;

import javafx.scene.control.TextField;

public class Checking {

    /**
     * Checks the inserted Card number after deleting the spaces (if there were any)
     * and checks which company's card is it
     * @param cardNumbWithoutSpaces Card number without spaces
     * @param Company Text field which displays the company of the card
     */
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

    /**
     * Cheking if the numbers of inserted day's and month's isn't out of range
     * @param dayBox input day from TextField
     * @param monthBox input month from TextField
     * @return true if the the day of month isn't bigger than 31 or lower than 0
     * and the number of months aren't bigger than 12 or less than 1 else return's false
     */
    public boolean DayMonthInput(int dayBox, int monthBox) {
        return dayBox <= 31 && dayBox >0 && monthBox <= 12 && monthBox >0;
    }

    /**
     *  Checks the Luhn algorithm
     * @param CardNumbNoSpace Card number without spaces
     * @return true if the CardNumbNoSpace is correct
     */
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
    }


