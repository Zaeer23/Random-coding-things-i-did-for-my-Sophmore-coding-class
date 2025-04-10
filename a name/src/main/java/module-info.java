module com.example.aname {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.aname to javafx.fxml;
    exports com.example.aname;
}