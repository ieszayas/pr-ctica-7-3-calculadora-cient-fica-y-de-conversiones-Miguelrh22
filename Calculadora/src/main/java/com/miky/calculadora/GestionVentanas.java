package com.miky.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionVentanas {



    public static void openNormal(ActionEvent actionEvent){
        try{
            MenuItem menuItem = (MenuItem) actionEvent.getSource();

            // Obtén la referencia al ContextMenu asociado con el MenuItem
            ContextMenu contextMenu = menuItem.getParentPopup();

            // Obtén la referencia al Owner Node (puede ser el contenido de la ventana)
            Node ownerNode = contextMenu.getOwnerNode();

            // Obtén la referencia al Stage actual
            Stage currentStage = (Stage) ownerNode.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(GestionVentanas.class.getResource("calculadora-view.fxml"));
            Pane root = (Pane) loader.load();

            Scene scene = new Scene(root);
            Stage stageWindow = new Stage();
            stageWindow.getIcons().add(new Image(GestionVentanas.class.getResourceAsStream("icon.png")));
            stageWindow.setTitle(Macros.getAppName());
            stageWindow.setScene(scene);
            stageWindow.show();

            currentStage.close();
        } catch (IOException e){

        }
    }

    public static void openCientifica(ActionEvent actionEvent){
        try{
            MenuItem menuItem = (MenuItem) actionEvent.getSource();

            // Obtén la referencia al ContextMenu asociado con el MenuItem
            ContextMenu contextMenu = menuItem.getParentPopup();

            // Obtén la referencia al Owner Node (puede ser el contenido de la ventana)
            Node ownerNode = contextMenu.getOwnerNode();

            // Obtén la referencia al Stage actual
            Stage currentStage = (Stage) ownerNode.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(GestionVentanas.class.getResource("calculadora-cientifica-view.fxml"));
            Pane root = (Pane) loader.load();

            Scene scene = new Scene(root);
            Stage stageWindow = new Stage();
            stageWindow.getIcons().add(new Image(GestionVentanas.class.getResourceAsStream("icon.png")));
            stageWindow.setTitle(Macros.getAppName());
            stageWindow.setScene(scene);
            stageWindow.show();

            currentStage.close();
        } catch (IOException e){

        }
    }

    public static void openConversion(ActionEvent actionEvent){
        try{
            MenuItem menuItem = (MenuItem) actionEvent.getSource();

            // Obtén la referencia al ContextMenu asociado con el MenuItem
            ContextMenu contextMenu = menuItem.getParentPopup();

            // Obtén la referencia al Owner Node (puede ser el contenido de la ventana)
            Node ownerNode = contextMenu.getOwnerNode();

            // Obtén la referencia al Stage actual
            Stage currentStage = (Stage) ownerNode.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(GestionVentanas.class.getResource("calculadora-conversion-view.fxml"));
            Pane root = (Pane) loader.load();

            Scene scene = new Scene(root);
            Stage stageWindow = new Stage();
            stageWindow.getIcons().add(new Image(GestionVentanas.class.getResourceAsStream("icon.png")));
            stageWindow.setTitle(Macros.getAppName());
            stageWindow.setScene(scene);
            stageWindow.show();

            currentStage.close();
        } catch (IOException e){

        }
    }

    public static void openMonedas(ActionEvent actionEvent){
        try{

            FXMLLoader loader = new FXMLLoader(GestionVentanas.class.getResource("calculadora-monedas-view.fxml"));
            Pane root = (Pane) loader.load();

            Scene scene = new Scene(root);


            Stage stageWindow = new Stage();
            stageWindow.getIcons().add(new Image(GestionVentanas.class.getResourceAsStream("icon.png")));
            stageWindow.setTitle(Macros.getAppName());
            stageWindow.initModality(Modality.APPLICATION_MODAL);
            stageWindow.setScene(scene);
            stageWindow.show();


        } catch (IOException e){

        }
    }


    public static void openInfo(ActionEvent actionEvent){
        try{
            MenuItem menuItem = (MenuItem) actionEvent.getSource();

            // Obtén la referencia al ContextMenu asociado con el MenuItem
            ContextMenu contextMenu = menuItem.getParentPopup();

            // Obtén la referencia al Owner Node (puede ser el contenido de la ventana)
            Node ownerNode = contextMenu.getOwnerNode();

            // Obtén la referencia al Stage actual
            Stage currentStage = (Stage) ownerNode.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(GestionVentanas.class.getResource("calculadora-conversion-view.fxml"));
            Pane root = (Pane) loader.load();

            Scene scene = new Scene(root);
            Stage stageWindow = new Stage();
            stageWindow.getIcons().add(new Image(GestionVentanas.class.getResourceAsStream("icon.png")));
            stageWindow.setTitle(Macros.getAppName());
            stageWindow.setScene(scene);
            stageWindow.show();

            currentStage.close();
        } catch (IOException e){

        }
    }
}
