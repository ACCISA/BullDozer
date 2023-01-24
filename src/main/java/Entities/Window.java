package Entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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


    private void CreateWindow(){
        this.stage = new Stage();

        stage.initStyle(StageStyle.UNDECORATED);
        System.out.println(icon);
        stage.getIcons().add(new Image("C:\\Users\\darra\\IdeaProjects\\hack\\src\\main\\resources\\com\\example\\conuhacks\\bulldozer_logo.png"));
        try{

            URL fxmlLocation = getClass().getClassLoader().getResource(fxml);
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            URL url = new File("src/main/resources/com/example/conuhacks/"+fxml).toURI().toURL();
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
    }

    public void Hide(){
        stage.hide();
    }




}
