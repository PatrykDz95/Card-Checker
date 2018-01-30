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
        GridPane.setConstraints(CorrectOrNot, 0, 7);

        GridPane.setConstraints(btn, 0, 4);
        btn.setMaxWidth(300);

        btn.setText("Check your credit card!");
        btn.setOnAction(e
                -> isNumber(CardNumInput, CCVInput, DDinput, MMinput, YYYYinput, CardNumInput.getText(), CorrectOrNot));

        grid.getChildren().addAll(CardNumInput, CCVInput, DDinput, MMinput, YYYYinput, btn, CorrectOrNot);

        Scene scene = new Scene(grid, 350, 150);
        window.setScene(scene);

        window.show();
    }

    public boolean isNumber(TextField number, TextField CCV, TextField DDinput, TextField MMinput,
                            TextField YYYYinput, String MSG, TextField CorrectOrNot) {

        String cardNumbWithoutSpaces = number.getText().replaceAll("\\s", "");
        int CCVLenght = CCV.getLength();
        int dayBox = Integer.parseInt(DDinput.getText());
        int monthBox = Integer.parseInt(MMinput.getText());
        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date todaysDate = new Date();
        Checking checking = new Checking();

        try {
//            String cos = null;
//            String co = null;
            Date inputDate = null;
            //checking.ZerosInDate(DDinput, MMinput, YYYYinput, cos, co, inputDate, df);
            inputDate = df.parse( DDinput.getText() + MMinput.getText() + YYYYinput.getText());

            if ((cardNumbWithoutSpaces).matches("^[\\d]{12,19}$") && (CCVLenght == 3) &&
                    (todaysDate.before(inputDate) || df.format(todaysDate).equals(df.format(inputDate))) &&
                    checking.DayMonthInput(dayBox, monthBox) && checking.LuhnAlgorithm(cardNumbWithoutSpaces))
            {
                CorrectOrNot.setText("Card is valid");
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

