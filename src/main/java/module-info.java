module sample{
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens AdminProgram;
    opens AdminProgram.Controller;
    opens CustomerProgram;
    opens CustomerProgram.Controller;
    opens LoginProgram;
    opens LoginProgram.Controller;
    opens view.admin;
    opens view.customer;
    opens view.login;

}