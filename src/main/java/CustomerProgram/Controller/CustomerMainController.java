package CustomerProgram.Controller;

import LoginProgram.Controller.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerMainController{

    LoginController l = new LoginController();

    @FXML
    private Label menuStartLabel;

    @FXML
    private Label userLabel;

    @FXML
    private Label welcomeUser;

    @FXML
    private Label logOutLabel;

    public void initialize(){
        welcomeUser.setText("oscar");
    }


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

            userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
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

    public void loadStartScreen(){
        Parent userLogin;
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) menuStartLabel.getScene().getWindow();
            stage.close();
            System.out.println("Funkar");

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

    public Label getWelcomeUser() {
        return welcomeUser;
    }

}
