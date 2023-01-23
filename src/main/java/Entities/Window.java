package Entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class Window {

    private int width;
    private int height;
    private String fxml;
    private String title = "BullDozer";
    private String icon = "bulldozer_logo.png";
    private String styleSheet = "style.css";
    private double x = 0;
    private double y = 0;
    private Stage stage;


    public Window(int w, int h, String fxml){
        this.width = w;
        this.height = h;
        this.fxml = fxml;
    }

    public Window(int w, int h, String fxml, String title, String icon){
        this.width = w;
        this.height = h;
        this.fxml = fxml;
        this.title = title;
        this.icon = icon;
    }

    private void CreateWindow(){
        this.stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image(getClass().getResource(icon).toString()));
        try{
            URL fxmlLocation = Window.class.getResource(fxml);
            FXMLLoader loader = new FXMLLoader(fxmlLocation);

            Parent root = loader.load(fxmlLocation);
            Scene scene = new Scene(root,width,height);


            scene.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            scene.setOnMouseDragged(mouseEvent -> {
                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);
            });
            stage.setTitle(title);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource(styleSheet).toExternalForm());
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Open(){
        stage.show();
    }

}
