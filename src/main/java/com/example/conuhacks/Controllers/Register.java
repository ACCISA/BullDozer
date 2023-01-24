package com.example.conuhacks.Controllers;

import Func.Utils;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private StackPane stackP;

    @FXML
    private JFXDialogLayout dialogLayout;

    private ArrayList<JFXDialog> dialogsArr = new ArrayList<>();
    @FXML
    void actionCreateAccount(ActionEvent event) {
        if (!(dialogsArr.size()==0)) {
            for (int i = 0; i < dialogsArr.size(); i++) {
                dialogsArr.get(i).close();
                System.out.println("closed");
            }
        }
        if (!(Utils.hasValidValues(new String[]{inputUsername.getText(),inputConfirmPassword.getText(),inputPassword.getText()}))){
            dialogInvalidValues.show();
            return;
        }
        if (!(Utils.hasSamePassword(inputPassword.getText(),inputConfirmPassword.getText()))){

//            registerAnchorPane.getChildren().add(stackP);
//            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            Parent parent;
            try{
                URL url = new File("src/main/resources/com/example/conuhacks/Dialogs/dialog-invalid-values.fxml").toURI().toURL();
                parent = FXMLLoader.load(url);
                dialogLayout.getChildren().add(parent);
                JFXDialog jfxDialog = new JFXDialog(root,dialogLayout, JFXDialog.DialogTransition.NONE, true);
                jfxDialog.show();
                dialogsArr.add(jfxDialog);



            } catch (IOException e){
                e.printStackTrace();
            }
            return;
        }

        System.out.println("creation sucesfull");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        dialog.setTransitionType(JFXDialog.DialogTransition.LEFT);
//        dialog.setDialogContainer(root);
//        continueBtn.setOnAction(actionEvent -> {
//            dialog.close();
//        });
//
//        dialogInvalidValues.setTransitionType(JFXDialog.DialogTransition.LEFT);
//        dialogInvalidValues.setDialogContainer(root);
//        continueBtn.setOnAction(actionEvent -> {
//            dialogInvalidValues.close();
//        });
    }
}

