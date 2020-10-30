package AdminProgram.Controller;

import Model.Bank;
import Model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminNewCustomerController {

    Bank bank = new Bank();

    @FXML
    private Label logOutLabel;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField socialSecurityNumber;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField customerID;

    @FXML
    private TextField pinCode;

    @FXML
    private TextField delFirstName;

    @FXML
    private TextField delCustomerID;

    @FXML
    private TextField delLastName;

    @FXML
    private TextField delSocialSecurityNumber;


    public void createCustomer(){
        Customer c = new Customer(firstName.getText(), lastName.getText(), socialSecurityNumber.getText(),
                phoneNumber.getText(), Integer.parseInt(customerID.getText()), Integer.parseInt(pinCode.getText()));
        bank.getCustomerList().add(c);
    }

    public void clearAllNewCustomerFields(){
        firstName.setText(null);
        lastName.setText(null);
        socialSecurityNumber.setText(null);
        phoneNumber.setText(null);
        customerID.setText(null);
        pinCode.setText(null);
    }

    public void deleteCustomer(){
        bank.getCustomerList().removeIf(c -> delFirstName.getText().equals(c.getFirstName()) &&
                delLastName.getText().equals(c.getLastName()) &&
                Integer.parseInt(delCustomerID.getText()) == c.getCustomerId() &&
                delSocialSecurityNumber.getText().equals(c.getSocialSecurityNumber()));

        /*for (Customer c :bank.getCustomerList()) {
            if (firstName.getText().equals(c.getFirstName()) &&
                    lastName.getText().equals(c.getLastName()) &&
                    Integer.parseInt(customerID.getText()) == c.getCustomerId() &&
                    socialSecurityNumber.getText().equals(c.getSocialSecurityNumber())){
                bank.getCustomerList().remove(c);
            }
        }*/
    }

    public void clearAllDeleteCustomerFields(){

    }



    //-------------------------------- Logout Button ----------------------------------\\

    public void hoverLabelTurnBlue(){
        logOutLabel.setTextFill(Color.rgb(95,132,232));
    }

    public void hoverLabelTurnWhite(){
        logOutLabel.setTextFill(Color.WHITE);
    }

    public void logout(){
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) logOutLabel.getScene().getWindow();
            stage.close();

            Parent userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/admin/Login.fxml"));
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
