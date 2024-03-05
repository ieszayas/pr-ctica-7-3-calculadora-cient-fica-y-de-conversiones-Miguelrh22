package com.miky.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class CalculadoraConversionController {

    @FXML
    private Label pantalla;
    @FXML
    private Label pantalla2;
    @FXML
    private ComboBox<String> de;
    @FXML
    private ComboBox<String> a;
    @FXML
    private ComboBox<String> tipo;

    private String numero = "";
    private Double resultado = 0.0;

    @FXML
    public void initialize() {
        initializeComboBoxes();
    }

    private void initializeComboBoxes() {
        tipo.getItems().addAll("Longitud", "Volumen", "Temperatura");

        tipo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            de.getItems().clear();
            a.getItems().clear();

            if ("Longitud".equals(newValue)) {
                de.getItems().addAll("Metros", "Kilómetros", "Millas");
                a.getItems().addAll("Metros", "Kilómetros", "Millas");
            } else if ("Volumen".equals(newValue)) {
                de.getItems().addAll("Litros", "Galones", "Cubos");
                a.getItems().addAll("Litros", "Galones", "Cubos");
            } else if ("Temperatura".equals(newValue)) {
                de.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
                a.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
            }
            realizarCalculo();
        });
        de.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            realizarCalculo();
        });

        a.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            realizarCalculo();
        });

        tipo.getSelectionModel().selectFirst();
    }

    @FXML
    public void onNumeroPressed(ActionEvent actionEvent) {
        Button sourceButton = (Button) actionEvent.getSource();
        numero += sourceButton.getText();
        pantalla.setText(numero);
        realizarCalculo();
    }



    @FXML
    public void onResetPressed(ActionEvent actionEvent) {
        numero = "";
        resultado = 0.0;
        pantalla.setText(numero);
        pantalla2.setText("");
    }




    @FXML
    public void onDecimalChange(ActionEvent actionEvent) {
        if(numero.isEmpty()){
            numero = "0.";
        } else if(!numero.contains(".")){
            numero += ".";
        }


        pantalla.setText(numero);
        realizarCalculo();

    }
    @FXML
    public void onDeleteChar(ActionEvent actionEvent) {
        if(!numero.isEmpty()){
            numero = numero.substring(0, numero.length() - 1);
            pantalla.setText(numero);
            realizarCalculo();
        }
    }

    @FXML
    public void onCientifica(ActionEvent actionEvent) {
        GestionVentanas.openCientifica(actionEvent);
    }

    @FXML
    public void onConversiones(ActionEvent actionEvent) {
        GestionVentanas.openConversion(actionEvent);
    }

    @FXML
    public void onInfo(ActionEvent actionEvent) {
        GestionVentanas.openInfo(actionEvent);
    }

    @FXML
    public void onCerrar(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void onNormal(ActionEvent actionEvent) {
        GestionVentanas.openNormal(actionEvent);

    }

    private void realizarCalculo() {
        if (tipo.getValue() != null && de.getValue() != null && a.getValue() != null) {
            try {
                double valor = numero.isEmpty() ? 0.0 : Double.parseDouble(numero);

                switch (tipo.getValue()) {
                    case "Longitud":
                        resultado = MikyMath.convertirLongitud(valor, de.getValue(), a.getValue());
                        break;
                    case "Volumen":
                        resultado = MikyMath.convertirVolumen(valor, de.getValue(), a.getValue());
                        break;
                    case "Temperatura":
                        resultado = MikyMath.convertirTemperatura(valor, de.getValue(), a.getValue());
                        break;
                    default:
                        break;
                }

                pantalla2.setText(String.valueOf(resultado));
            } catch (NumberFormatException e) {
                pantalla2.setText("Error");
            }
        }
    }

    @FXML
    public void onMonedas(ActionEvent actionEvent) {
        GestionVentanas.openMonedas(actionEvent);
    }


}