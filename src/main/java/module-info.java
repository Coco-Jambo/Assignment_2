module com.example.task1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens Task1 to javafx.fxml;
    exports Task1;

    opens Task2 to javafx.fxml;
    exports Task2;

    opens Task3 to javafx.fxml;
    exports Task3;

    opens Task4 to javafx.fxml;
    exports Task4;

    opens Task5 to javafx.fxml;
    exports Task5;
}