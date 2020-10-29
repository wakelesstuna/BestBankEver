module sample{
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens AdminProgram;
    opens CustomerProgram;
    opens CustomerProgram.Controller;
    opens LoginProgram;
    opens LoginProgram.Controller;
    opens view;
}