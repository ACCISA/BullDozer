package com.example.conuhacks;

import Entities.Window;
import Func.Utils;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    private double x = 0;
    private double y = 0;
    @Override
    public void start(Stage stage) throws IOException {
        Window main = new Window(600,313,"src/main/resources/com/example/conuhacks/main-menu.fxml");
        main.Open();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }


}