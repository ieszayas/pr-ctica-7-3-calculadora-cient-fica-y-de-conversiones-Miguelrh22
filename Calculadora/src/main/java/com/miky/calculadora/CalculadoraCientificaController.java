package com.miky.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculadoraCientificaController {

    @FXML
    private Label pantalla;

    private Double resultadoTemporal = 0.0;
    private String numero = "";
    private Opera tipoOperacion;
    private double memoria = 0.0;

    private Opera obtenerTipoOperacion(String op) {
        return switch (op){
            case "/" -> Opera.DIVIDIR;
            case "*" -> Opera.MULTIPLICAR;
            case "-" -> Opera.RESTAR;
            default -> Opera.SUMAR;
        };
    }

    @FXML
    public void onNumeroPressed(ActionEvent actionEvent) {
        Button sourceButton = (Button) actionEvent.getSource();
        numero += sourceButton.getText();
        pantalla.setText(numero);
    }

    @FXML
    public void onResultadoPressed(ActionEvent actionEvent) {
        if(tipoOperacion != null){
            if(!numero.isEmpty()) {
                resultadoTemporal = MikyMath.calcular(resultadoTemporal, Double.parseDouble(numero), tipoOperacion);
            }
        } else {
            if(!numero.isEmpty()) {
                resultadoTemporal = Double.parseDouble(numero);
            }
        }
        pantalla.setText(resultadoTemporal+"");
        numero = "";
        tipoOperacion = null;
    }

    @FXML
    public void onResetPressed(ActionEvent actionEvent) {
        numero = "";
        resultadoTemporal = 0.0;
        tipoOperacion = null;
        pantalla.setText(numero);
    }

    @FXML
    public void onOperacionPressed(ActionEvent actionEvent) {
        if(tipoOperacion != null){
            if(!numero.isEmpty()) {
                resultadoTemporal = MikyMath.calcular(resultadoTemporal, Double.parseDouble(numero), tipoOperacion);
            }
        } else {
            if(!numero.isEmpty()) {
                resultadoTemporal = Double.parseDouble(numero);
            }
        }
        Button sourceButton = (Button) actionEvent.getSource();
        tipoOperacion = obtenerTipoOperacion(sourceButton.getText());
        numero = "";
        pantalla.setText(numero);

    }

    @FXML
    public void onSignChange(ActionEvent actionEvent) {
        if (!numero.isEmpty()) {
            double valorNumerico = Double.parseDouble(numero);
            valorNumerico = -valorNumerico;
            numero = Double.toString(valorNumerico);
            pantalla.setText(numero);
        } else {
            resultadoTemporal = -resultadoTemporal;
            pantalla.setText(resultadoTemporal.toString());
        }
    }

    @FXML
    public void onDecimalChange(ActionEvent actionEvent) {
        if(numero.isEmpty()){
            numero = "0.";
        } else if(!numero.contains(".")){
            numero += ".";
        }


        pantalla.setText(numero);

    }

    @FXML
    public void onMemoryDown(ActionEvent actionEvent) {
        double valorNumerico = numero.isEmpty() ? resultadoTemporal : Double.parseDouble(numero);
        memoria -= valorNumerico;
    }

    @FXML
    public void onMemoryUp(ActionEvent actionEvent) {
        double valorNumerico = numero.isEmpty() ? resultadoTemporal : Double.parseDouble(numero);
        memoria += valorNumerico;
    }

    @FXML
    public void onDeleteChar(ActionEvent actionEvent) {
        if(!numero.isEmpty()){
            numero = numero.substring(0, numero.length() - 1);
            pantalla.setText(numero);
        }
    }

    @FXML
    public void onMemoryClean(ActionEvent actionEvent) {
        memoria = 0.0;
    }

    @FXML
    public void onMemoryShow(ActionEvent actionEvent) {
        pantalla.setText(String.valueOf(memoria));
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

    @FXML
    public void onCos(ActionEvent actionEvent) {

        if(!numero.isEmpty()) {
            resultadoTemporal = MikyMath.cos(Double.parseDouble(numero));
        }
        numero = resultadoTemporal+"";
        pantalla.setText(resultadoTemporal+"");
    }

    @FXML
    public void onTan(ActionEvent actionEvent) {
        if(!numero.isEmpty()) {
            resultadoTemporal = MikyMath.tan(Double.parseDouble(numero));
        }
        numero = resultadoTemporal+"";
        pantalla.setText(resultadoTemporal+"");
    }

    @FXML
    public void onExp(ActionEvent actionEvent) {
        if(!numero.isEmpty()) {
            resultadoTemporal = MikyMath.exp(Double.parseDouble(numero));
        }
        numero = resultadoTemporal+"";
        pantalla.setText(resultadoTemporal+"");
    }

    @FXML
    public void onSin(ActionEvent actionEvent) {
        if(!numero.isEmpty()) {
            resultadoTemporal = MikyMath.sin(Double.parseDouble(numero));
        }
        numero = resultadoTemporal+"";
        pantalla.setText(resultadoTemporal+"");
    }

    @FXML
    public void onSqr(ActionEvent actionEvent) {

        if(!numero.isEmpty()) {
            resultadoTemporal = MikyMath.sqrt(Double.parseDouble(numero));
        }
        numero = resultadoTemporal+"";
        pantalla.setText(resultadoTemporal+"");
    }
}