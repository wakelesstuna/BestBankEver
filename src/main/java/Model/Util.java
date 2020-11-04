package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Util {

    public void loadViews(String FXMLFileName, Label logOutLabel){
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) logOutLabel.getScene().getWindow();
            stage.close();

            Parent userLogin = FXMLLoader.load(getClass().getClassLoader().getResource("view/" + FXMLFileName + ".fxml"));
            stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(userLogin));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findCustomerIfThereIsCustomerWithSSC(List<Customer> list, String SSC){
        int counter = 0;
        for (Customer c : list) {
            if (c.getSocialSecurityNumber().equals(SSC)) {
                counter = 1;
                break;
            }
        }
        return counter;
    }

    public void loadErrorMessage(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Under Construction");
        alert.setTitle("Warning");
        alert.show();
    }

}
