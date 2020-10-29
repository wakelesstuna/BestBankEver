package LoginProgram.Controller;

import Model.Bank;
import Model.Customer;
import Model.Employee;
import Model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private final String copyRightSymbol = "\u00a9";
    private Bank bank;

    @FXML
    private Text copyRightLabel;

    @FXML
    private Text dateTimeLabel;

    @FXML
    private Label loginFadeTextPerNr;

    @FXML
    private Button customerLoginButton;

    @FXML
    private Button adminLoginButton;

    @FXML
    private TextField adminID;

    @FXML
    private PasswordField adminCode;

    @FXML
    private TextField personalNumberInput;

    @FXML
    private TextField pinCodeInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        dateTimeLabel.setText(dateTime);
        copyRightLabel.setText(copyRightSymbol + " Best Bank Ever AB (publ)");
        this.bank = new Bank();
    }

    public void makeTextRed(){
        loginFadeTextPerNr.setTextFill(Color.RED);
        if (Integer.parseInt(personalNumberInput.getText()) == 10)
                loginFadeTextPerNr.setTextFill(Color.BLACK);
    }

    public void ifLoginAreCorrectAdmin(){
        for (Employee e : bank.getEmployeeList()) {
            if (Integer.parseInt(adminID.getText()) == e.getEmployeeID() && Integer.parseInt(adminCode.getText()) == e.getEmployeeCode()) {
                loadAdminView();
            } else {
                System.out.println("funkar ej admin");
            }
        }
    }

    public void ifLoginAreCorrectCustomer(){
        for (Customer e : bank.getCustomerList()) {
            if (personalNumberInput.getText().equals(e.getSocialSecurityNumber()) && Integer.parseInt(pinCodeInput.getText()) == e.getPin()){
                loadCustomerView();
            }else {
                System.out.println("Något gick fel");
            }
        }
        if (personalNumberInput.getText().equals("oscar") && pinCodeInput.getText().equals("1234")){
            loadCustomerView();
        }else{
            System.out.println("funkar ej customer");
        }
    }

    public void loadCustomerView(){
        Parent userLogin;
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) customerLoginButton.getScene().getWindow();
            stage.close();

            userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/CustomerMain.fxml"));
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

    public void loadAdminView(){
        Parent userLogin;
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) adminLoginButton.getScene().getWindow();
            stage.close();

            userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/AdminMain.fxml"));
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

    public TextField getPersonalNumberInput() {
        return personalNumberInput;
    }

}
