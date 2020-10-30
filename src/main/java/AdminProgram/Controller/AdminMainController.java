package AdminProgram.Controller;

import Model.Bank;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainController implements Initializable {

    Bank b = new Bank();

    @FXML
    private Label adminLogin;

    @FXML
    private Label adminName;

    @FXML
    private MenuItem newCustomer;

    @FXML
    private Label logOutLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminLogin.setText(b.getEmployeeList().get(0).getFirstName() + " " + b.getEmployeeList().get(0).getLastName());
        adminName.setText(b.getEmployeeList().get(0).getFirstName() + " " + b.getEmployeeList().get(0).getLastName());
    }

    public void handleLoan(){
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) logOutLabel.getScene().getWindow();
            stage.close();

            Parent userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/admin/AdminHandleLoan.fxml"));
            stage = new Stage();
            stage.setTitle("Loan");
            stage.setResizable(false);
            stage.setScene(new Scene(userLogin));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    //-------------------------------- New Customer ----------------------------------\\

    public void newCustomer(){
        Parent userLogin;
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) logOutLabel.getScene().getWindow();
            stage.close();

            userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/admin/AdminNewCustomer.fxml"));
            stage = new Stage();
            stage.setTitle("Member");
            stage.setResizable(false);
            stage.setScene(new Scene(userLogin));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //-------------------------------- Logout Button ----------------------------------\\

    public void hoverLabelTurnBlue(){
        logOutLabel.setTextFill(Color.rgb(95,132,232));
    }

    public void hoverLabelTurnWhite(){
        logOutLabel.setTextFill(Color.WHITE);
    }

    public void logout(){
        Parent userLogin;
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) logOutLabel.getScene().getWindow();
            stage.close();

            userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/login/Login.fxml"));
            stage = new Stage();
            stage.setTitle("Member");
            stage.setResizable(false);
            stage.setScene(new Scene(userLogin));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
