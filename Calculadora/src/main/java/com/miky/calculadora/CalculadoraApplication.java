package com.miky.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculadoraApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculadoraApplication.class.getResource("calculadora-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Macros.getWindowWidth(), Macros.getWindowHeight());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        stage.setTitle(Macros.getAppName());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}