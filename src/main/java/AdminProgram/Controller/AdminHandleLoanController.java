package AdminProgram.Controller;

import LoginProgram.Controller.LoginController;
import Model.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AdminHandleLoanController {

    Bank bank = new Bank();
    LoginController login = new LoginController();
    Customer c;
    int selectedLoanIndex;

    @FXML
    private Label logOutLabel;

    @FXML
    private Label regNewCustomerLabel;

    @FXML
    private TextField customerSocialSecurityNumber;

    @FXML
    private Button getCustomer;

    @FXML
    private TableView<Loan> loansOverview;

    @FXML
    private TableColumn<Loan, Integer> loanIdCol;

    @FXML
    private TableColumn<Loan, LocalDate> loanDateCol;

    @FXML
    private TableColumn<Loan, Double> loanAmountCol;

    @FXML
    private TableColumn<Loan, Double> interestRateCol;

    @FXML
    private TableColumn<Loan, Double> amortizationCol;

    @FXML
    private TableColumn<Loan, Double> loanRemainingAmountCol;

    @FXML
    private TextField loanIDInput;

    @FXML

    private Label loanIdLabel;

    @FXML
    private TextField changeRateInput;

    @FXML
    private TextField employeeIdInput;

    @FXML
    private Label employeeIDChangeRateLabel;

    @FXML
    private TextField loanIdOutput;

    @FXML
    private TextField loanDateOutput;

    @FXML
    private TextField loanAmountOutput;

    @FXML
    private TextField loanRateOutput;

    @FXML
    private TextField loanAmortizationOutput;

    @FXML
    private TextField loanRemainingAmountOutput;

    public void displayLoansToTable() {
        bank.deSerialize();
        loansOverview.getItems().clear();
        for (Customer c : bank.getCustomerList()) {
            if (customerSocialSecurityNumber.getText().equals(c.getSocialSecurityNumber())) {
                this.c = c;
                loanIdCol.setCellValueFactory(loan -> new SimpleIntegerProperty(loan.getValue().getLoanID()).asObject());
                loanDateCol.setCellValueFactory(loan -> new SimpleObjectProperty<>(loan.getValue().getLoanDate()));
                loanAmountCol.setCellValueFactory(loan -> new SimpleDoubleProperty(loan.getValue().getAmount()).asObject());
                interestRateCol.setCellValueFactory(loan -> new SimpleDoubleProperty(loan.getValue().getInterestRate()).asObject());
                amortizationCol.setCellValueFactory(loan -> new SimpleDoubleProperty(loan.getValue().getAmortization()).asObject());
                loanRemainingAmountCol.setCellValueFactory(loan -> new SimpleDoubleProperty(loan.getValue().getRemainingAmount()).asObject());

                loansOverview.setItems(FXCollections.observableList(c.getLoans()));
            }
        }
    }


    public void displaySelectedLoanToTable() {
        boolean bool = false;
        for (int i = 0; i < c.getLoans().size(); i++) {
            if (Integer.parseInt(loanIDInput.getText()) == c.getLoans().get(i).getLoanID()) {
                selectedLoanIndex = i;
                loanIdOutput.setText("" + c.getLoans().get(i).getLoanID());
                loanDateOutput.setText(c.getLoans().get(i).getLoanDate().toString());
                loanAmountOutput.setText("" + c.getLoans().get(i).getAmount());
                loanRateOutput.setText("" + c.getLoans().get(i).getInterestRate());
                loanAmortizationOutput.setText("" + c.getLoans().get(i).getAmortization());
                loanRemainingAmountOutput.setText("" + c.getLoans().get(i).getRemainingAmount());
                bool = true;
                loanIdLabel.setText("");
                break;
            }
        }
        if (!bool) {
            loanIdLabel.setText("Du har mata in ett felaktigt LånID");
        }

    }

    public void changeInterestRateOnLoan() {
        int loggedInEmployee;
        double newRate = Double.parseDouble(changeRateInput.getText());
        if (employeeIdInput.getText().isEmpty()) {
            employeeIDChangeRateLabel.setTextFill(Color.RED);
            employeeIDChangeRateLabel.setText("Du måste fylla i ett AnställningsID för att kunna ändra ränta");
        } else if (Integer.parseInt(employeeIdInput.getText()) == findEmployeeID()) {
            loggedInEmployee = Integer.parseInt(employeeIdInput.getText());
            c.getLoans().get(selectedLoanIndex).setInterestRate(newRate);
            c.getLoans().get(selectedLoanIndex).getLoanChanges().add(new LoanChanges(bank.getEmployeeList().get(getEmployeeIndexInList(loggedInEmployee)), newRate));
            employeeIDChangeRateLabel.setTextFill(Color.GREEN);
            employeeIDChangeRateLabel.setText("Räntan ändrad till 3%");
        }
        System.out.println(c.getLoans().get(selectedLoanIndex).getInterestRate());
        System.out.println(c.getLoans().get(selectedLoanIndex).getLoanChanges().toString());

        bank.serialize();
    }

    public int getEmployeeIndexInList(int employeeID) {
        int index = 0;
        for (int i = 0; i < bank.getEmployeeList().size(); i++) {
            if (employeeID == bank.getEmployeeList().get(i).getEmployeeID()) {
                index = i;
            }
        }
        return index;
    }

    public int findEmployeeID() {
        for (Employee e : bank.getEmployeeList()) {
            return e.getEmployeeID();
        }
        return 0;
    }


    //-------------------------------- Logout Button ----------------------------------\\

    public void hoverLabelTurnBlue() {
        logOutLabel.setTextFill(Color.rgb(95, 132, 232));
    }

    public void hoverLabelTurnWhite() {
        logOutLabel.setTextFill(Color.WHITE);
    }

    public void logout() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

