package Entities;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Dialog implements Initializable {
    private String message;
    private JFXDialog dialog = new JFXDialog();
    private JFXButton contineBtn = new JFXButton("Continue");
    private Group rootContinue = new Group(contineBtn);

    public Dialog(String message, Scene scene){
        this.message = message;
    }
    public static void openDialog(String message, String type, StackPane root){
        if (type.equals("continue")){
            JFXDialog dialog = new JFXDialog();
            dialog.setTransitionType(JFXDialog.DialogTransition.LEFT);
            dialog.setDialogContainer(root);
            JFXButton continueBtn = new JFXButton("Continue");
            continueBtn.setOnAction(actionEvent -> {
                System.out.println("this dialog was clicked");
                dialog.close();
            });
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
