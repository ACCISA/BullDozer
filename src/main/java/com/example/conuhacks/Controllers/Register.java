package com.example.conuhacks.Controllers;

import Func.Utils;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Register implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private JFXDialog dialog;

    @FXML
    private JFXButton continueBtn;

    @FXML
    private JFXButton createAccount;

    @FXML
    private JFXTextField inputUsername;

    @FXML
    private JFXPasswordField inputPassword;

    @FXML
    private JFXPasswordField inputConfirmPassword;

    @FXML
    private JFXDialog dialogInvalidValues;

    @FXML
    private AnchorPane registerAnchorPane;



    @FXML
    void actionCreateAccount(ActionEvent event) {
        if (!(Utils.hasValidValues(new String[]{inputUsername.getText(),inputConfirmPassword.getText(),inputPassword.getText()}))){
            dialogInvalidValues.show();
            return;
        }
        if (!(Utils.hasSamePassword(inputPassword.getText(),inputConfirmPassword.getText()))){
            StackPane stackP = new StackPane();
            javafx.scene.layout.AnchorPane.setTopAnchor(stackP,20.0);
            javafx.scene.layout.AnchorPane.setLeftAnchor(stackP, 20.0);
            javafx.scene.layout.AnchorPane.setRightAnchor(stackP, 20.0);
            javafx.scene.layout.AnchorPane.setBottomAnchor(stackP, 20.0);
            registerAnchorPane.getChildren().add(stackP);
            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            Parent parent;
            try{
                URL url = new File("src/main/resources/com/example/conuhacks/Dialogs/dialog-invalid-values.fxml").toURI().toURL();
                parent = FXMLLoader.load(url);
                jfxDialogLayout.getChildren().add(parent);
                JFXDialog jfxDialog = new JFXDialog(stackP,jfxDialogLayout, JFXDialog.DialogTransition.LEFT, true);
                jfxDialog.show();

            } catch (IOException e){
                e.printStackTrace();
            }
            return;
        }

        System.out.println("creation sucesfull");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialog.setTransitionType(JFXDialog.DialogTransition.LEFT);
        dialog.setDialogContainer(root);
        continueBtn.setOnAction(actionEvent -> {
            dialog.close();
        });

        dialogInvalidValues.setTransitionType(JFXDialog.DialogTransition.LEFT);
        dialogInvalidValues.setDialogContainer(root);
        continueBtn.setOnAction(actionEvent -> {
            dialogInvalidValues.close();
        });
    }
}

