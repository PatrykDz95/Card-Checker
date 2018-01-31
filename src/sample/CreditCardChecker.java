package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCardChecker extends Application {


    Stage window;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        Button btn = new Button();
        GridPane grid = new GridPane();

        grid.setVgap(5);
        grid.setHgap(5);

        grid.setPadding(new Insets(10, 10, 10, 10));


        TextField CardNumInput = new TextField();
        CardNumInput.setPromptText("Card Number");
        GridPane.setConstraints(CardNumInput, 0, 0);

        TextField CCVInput = new TextField();
        CCVInput.setPromptText("CCV");
        CCVInput.setPrefWidth(40);
        GridPane.setConstraints(CCVInput, 1, 0);


        TextField DDinput = new TextField();
        DDinput.setPromptText("DD");

        DDinput.setMaxWidth(37);
        GridPane.setConstraints(DDinput, 4, 0);


        TextField MMinput = new TextField();
        MMinput.setPromptText("MM");
        MMinput.setMaxWidth(37);
        GridPane.setConstraints(MMinput, 5, 0);


        TextField YYYYinput = new TextField();
        YYYYinput.setPromptText("YYYY");
        YYYYinput.setMaxWidth(43);
        GridPane.setConstraints(YYYYinput, 6, 0);


        TextField CorrectOrNot = new TextField();
        CorrectOrNot.setEditable(false);
        GridPane.setConstraints(CorrectOrNot, 0, 7);

        TextField Company = new TextField();
        Company.setPromptText("Company");
        Company.setMaxWidth(150);
        Company.setEditable(false);
        GridPane.setConstraints(Company, 0,8);


        GridPane.setConstraints(btn, 0, 4);
        btn.setMaxWidth(300);

        btn.setText("Check your credit card!");
        btn.setOnAction(e
                -> isNumber(CardNumInput, CCVInput, DDinput, MMinput, YYYYinput, CorrectOrNot , Company));

        grid.getChildren().addAll(CardNumInput, CCVInput, DDinput, MMinput, YYYYinput, btn, CorrectOrNot, Company);

        Scene scene = new Scene(grid, 400, 200);
        window.setScene(scene);

        window.show();
    }

    public boolean isNumber(TextField number, TextField CCV, TextField DDinput, TextField MMinput,
                            TextField YYYYinput, TextField CorrectOrNot, TextField Company) {

        String cardNumbWithoutSpaces = number.getText().replaceAll("\\s", "");
        int CCVLenght = CCV.getLength();
        int dayBox = Integer.parseInt(DDinput.getText());
        int monthBox = Integer.parseInt(MMinput.getText());
        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date todaysDate = new Date();
        Checking checking = new Checking();




        try {
            String OneDigitDay;
            String OneDigitMonth;
            Date inputDate;

           // checking.ZerosInDate(DDinput, MMinput, YYYYinput, OneDigitDay, OneDigitMonth);

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

            inputDate = df.parse(OneDigitDay + OneDigitMonth + YYYYinput.getText());

            if ((cardNumbWithoutSpaces).matches("^[\\d]{12,19}$") && (CCVLenght == 3) &&
                    (todaysDate.before(inputDate) || df.format(todaysDate).equals(df.format(inputDate))) &&
                    checking.DayMonthInput(dayBox, monthBox) && checking.LuhnAlgorithm(cardNumbWithoutSpaces))
            {
                CorrectOrNot.setText("Your card is valid");
                checking.CompanyNumbers(cardNumbWithoutSpaces, Company);
            } else {
                CorrectOrNot.setText("Error");
            }
            return true;

        } catch (Exception e) {
            CorrectOrNot.setText("Error");
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

