package Entities;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Window {

    private int width;
    private int height;
    private String fxml;
    private String title = "BullDozer";
    private String icon;
    private String styleSheet = "style.css";
    private double x = 0;
    private double y = 0;
    private Stage stage;
    private ArrayList<Stage> allStage;


    public Window(int w, int h, String fxml){
        this.width = w;
        this.height = h;
        this.fxml = fxml;
        this.icon = "bulldozer_logo.png";
        CreateWindow();
    }

    public Window(int w, int h, String fxml, String title, String icon){
        this.width = w;
        this.height = h;
        this.fxml = fxml;
        this.title = title;
        this.icon = icon;
        CreateWindow();
    }

    public static void Close(JFXButton component){
        component.getScene().getWindow().hide();
        System.out.println("[APP] Application has been closed");

    }

    private void CreateWindow(){
        this.stage = new Stage();

        stage.initStyle(StageStyle.UNDECORATED);
        System.out.println(icon);
        File f = new File(fxml);
        String abs = f.getAbsolutePath();
        int fxmlLength = fxml.length();
        int absLength = abs.length();
        String sourcePath = abs.substring(0,absLength-fxmlLength);

        stage.getIcons().add(new Image(sourcePath+"\\src\\main\\resources\\com\\example\\conuhacks\\bulldozer_logo.png"));
        try{

            URL fxmlLocation = getClass().getClassLoader().getResource(fxml);
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            URL url = new File(fxml).toURI().toURL();
            Parent root = FXMLLoader.load(url);
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
            URL urlCSS = new File("src/main/resources/com/example/conuhacks/PTstyle.css").toURI().toURL();
            scene.getStylesheets().add(urlCSS.toExternalForm());
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void Open(){
        stage.show();
        System.out.println("[APP] Opened " +fxml);
    }

    public void Hide(){
        stage.hide();
    }




}
