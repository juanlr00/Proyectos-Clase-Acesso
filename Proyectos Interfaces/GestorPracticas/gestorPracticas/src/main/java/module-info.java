module com.mycompany.gestorpracticas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.gestorpracticas to javafx.fxml;
    opens models;
    
    exports com.mycompany.gestorpracticas;
}
