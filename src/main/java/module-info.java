module com.example.deuxiemeprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires junit;

    opens com.example.deuxiemeprojet to javafx.fxml;
    exports modele;
    exports vue;
    exports controleur;
    exports tests;
}