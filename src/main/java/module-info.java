module com.example.conuhacks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.conuhacks to javafx.fxml;
    opens com.example.conuhacks.Controllers to javafx.fxml;
    exports com.example.conuhacks.Controllers;
    exports com.example.conuhacks;

}
