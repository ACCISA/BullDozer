package com.example.conuhacks;

import Entities.Window;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;


public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    private JFXButton closeButtonMainMenu;

    @FXML
    private JFXButton openPasswordGenerator;

    @FXML
    private JFXButton openPasswordTest;

    @FXML
    private BorderPane dragBar;

    private double x = 0;
    private double y = 0;

    @FXML
    protected void closeButtonMainMenuAction(ActionEvent event) {
        System.out.println("clicked");
    }
   
    @FXML
    protected void openPasswordTestAction() {
        System.out.println("[APP] Opening Password Testing Menu");
        openPasswordGenerator.getScene().getWindow().hide();
        Window pt = new Window(600,400,"src/main/resources/com/example/conuhacks/pt-menu.fxml");
        pt.Open();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void closeButtomMainMenuAction(ActionEvent actionEvent) {
        Func.Utils.logClose();
    }

    public void openPasswordGeneratorMenu(ActionEvent actionEvent) {
        System.out.println("[APP] Password Generator Menu Opened");
        openPasswordGenerator.getScene().getWindow().hide();
        Window pgMenu = new Window(600,400,"src/main/resources/com/example/conuhacks/pg-menu.fxml");
        pgMenu.Open();
    }


    public void openRegisterMenu(ActionEvent actionEvent) {
        Window register = new Window(300,400,"src/main/resources/com/example/conuhacks/register-menu.fxml");
        openPasswordGenerator.getScene().getWindow().hide();
        register.Open();
    }

    public void openLoginMenu(ActionEvent actionEvent) {
    }
}