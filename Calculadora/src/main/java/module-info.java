module com.miky.calculadora {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.miky.calculadora to javafx.fxml;
    exports com.miky.calculadora;
}