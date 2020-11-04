package AdminProgram.Controller;

import Model.Bank;
import Model.Customer;
import Model.Util;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AdminNewCustomerController implements Initializable {

    Bank bank = new Bank();
    Util u = new Util();

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
    private Label notAllFieldsInputLabel;

    @FXML
    private TextField delFirstName;

    @FXML
    private TextField delCustomerID;

    @FXML
    private TextField delLastName;

    @FXML
    private TextField delSocialSecurityNumber;

    @FXML
    private Text dateTimeLabel;

    @FXML
    private Text copyRightLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        dateTimeLabel.setText(dateTime);
        copyRightLabel.setText(bank.getCopyRightSymbol() + " Best Bank Ever AB (publ)");
    }


    public void createCustomer(){
        bank.deSerialize();
        Customer c = null;
        try{
        c = new Customer(firstName.getText(), lastName.getText(), socialSecurityNumber.getText(),
                phoneNumber.getText(), Integer.parseInt(customerID.getText()), Integer.parseInt(pinCode.getText()));
        }catch (NumberFormatException e){
            notAllFieldsInputLabel.setText("Du måste fylla i alla fält för att skapa en kund");
        }
        if (u.findCustomerIfThereIsCustomerWithSSC(bank.getCustomerList(), socialSecurityNumber.getText()) == 1){
            notAllFieldsInputLabel.setText("Person med " + socialSecurityNumber.getText() + " finns redan som kund");
        }else {
            bank.getCustomerList().add(c);
            bank.serialize();
        }
        System.out.println("new customer created");
    }

    public void clearAllNewCustomerFields(){
        firstName.setText(null);
        lastName.setText(null);
        socialSecurityNumber.setText(null);
        phoneNumber.setText(null);
        customerID.setText(null);
        pinCode.setText(null);
        notAllFieldsInputLabel.setText("");
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
        delFirstName.setText("");
        delLastName.setText("");
        delCustomerID.setText("");
        delSocialSecurityNumber.setText("");
        notAllFieldsInputLabel.setText("");
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

            Parent userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/login/Login.fxml"));
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
