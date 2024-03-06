package com.miky.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class CalculadoraMonedasController {

    @FXML
    private Label pantalla;
    @FXML
    private Label pantalla2;

    private String numero = "";
    private Double resultado = 0.0;
    @FXML
    private ComboBox<String> monedaInicial;
    @FXML
    private ComboBox<String> monedaFinal;

    @FXML
    public void initialize() {
        initializeComboBoxes();
    }

    private void initializeComboBoxes() {
        monedaInicial.getItems().addAll("USD", "EUR", "GBP", "JPY");
        monedaFinal.getItems().addAll("USD", "EUR", "GBP", "JPY");

        monedaInicial.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            realizarCalculo();
        });

        monedaFinal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            realizarCalculo();
        });

        monedaInicial.getSelectionModel().selectFirst();
        monedaFinal.getSelectionModel().selectFirst();
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


    private void realizarCalculo() {
        if (monedaInicial.getValue() != null && monedaFinal.getValue() != null) {
            try {
                double valor = numero.isEmpty() ? 0.0 : Double.parseDouble(numero);

                resultado = MikyMath.convertirMoneda(monedaInicial.getValue(), monedaFinal.getValue(), valor);

                pantalla2.setText(String.valueOf(resultado));
            } catch (NumberFormatException e) {
                pantalla2.setText("Error");
            }
        }
    }

}