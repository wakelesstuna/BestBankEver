package AdminProgram.Controller;

import Model.Bank;
import Model.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AdminMainController implements Initializable {

    private Bank bank = new Bank();
    private Util u = new Util();

    @FXML
    private Label adminLogin;

    @FXML
    private Label adminName;

    @FXML
    private MenuItem newCustomer;

    @FXML
    private Label logOutLabel;

    @FXML
    private Text dateTimeLabel;

    @FXML
    private Text copyRightLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminLogin.setText(bank.getEmployeeList().get(0).getFirstName() + " " + bank.getEmployeeList().get(0).getLastName());
        adminName.setText(bank.getEmployeeList().get(0).getFirstName() + " " + bank.getEmployeeList().get(0).getLastName());
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        dateTimeLabel.setText(dateTime);
        copyRightLabel.setText(bank.getCopyRightSymbol() + " Best Bank Ever AB (publ)");
    }

    //----------------------------- Under Construction --------------------------------\\
    public void showErrorMessage(){ u.loadErrorMessage(); }

    //--------------------------- Handle Customer Info --------------------------------\\
    public void handleCustomerInfo(){ u.loadViews("admin/AdminHandleLoan", logOutLabel); }

    //--------------------------- Handle Customer Info --------------------------------\\
    public void handleLoan(){ u.loadViews("admin/AdminHandleLoan", logOutLabel); }

    //------------------------------- Handle Account ----------------------------------\\
    public void handleAccount() {
        u.loadViews("admin/AdminHandleAccount", logOutLabel);
    }

    //------------------------ New Customer/Delete Customer ----------------------------\\
    public void newCustomer() {
        u.loadViews("admin/AdminNewCustomer", logOutLabel);
    }

    //-------------------------------- Logout Button ----------------------------------\\

    public void hoverLabelTurnBlue() {
        logOutLabel.setTextFill(Color.rgb(95, 132, 232));
    }

    public void hoverLabelTurnWhite() {
        logOutLabel.setTextFill(Color.WHITE);
    }

    public void logout() {
        u.loadViews("login/Login", logOutLabel);
    }

}
