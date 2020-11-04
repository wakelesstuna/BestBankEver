package AdminProgram.Controller;

import Model.Bank;
import Model.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AdminHandleAccountController implements Initializable {

    Bank bank = new Bank();
    Util u = new Util();

    @FXML
    private Label logOutLabel;

    @FXML
    private Text dateTimeLabel;

    @FXML
    private Text copyRightLabel;

    @FXML
    private Button tryButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        dateTimeLabel.setText(dateTime);
        copyRightLabel.setText(bank.getCopyRightSymbol() + " Best Bank Ever AB (publ)");
    }

    //-------------------------------- Logout Button ----------------------------------\\

    public void hoverLabelTurnBlue(){
        logOutLabel.setTextFill(Color.rgb(95,132,232));
    }

    public void hoverLabelTurnWhite(){
        logOutLabel.setTextFill(Color.WHITE);
    }

    public void logout(){ u.loadViews("Login", logOutLabel); }

    public void loadErrorMessage(ActionEvent actionEvent) {
    }
}
