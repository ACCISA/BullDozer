package com.example.conuhacks.Controllers;

import Entities.Window;
import Func.Api;
import Func.Utils;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
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

    @FXML
    private AnchorPane dialogCustom;

    private boolean isDialogShown = false;

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
            //TODO make the dialog looks normal and no white background. well positioned
//            registerAnchorPane.getChildren().add(stackP);
//            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            Parent parent;
            try{
                URL url = new File("src/main/resources/com/example/conuhacks/Dialogs/dialog-invalid-values.fxml").toURI().toURL();
                parent = FXMLLoader.load(url);
                JFXDialogLayout jfxDialogLayout2 = new JFXDialogLayout();
                jfxDialogLayout2.centerShapeProperty();

                jfxDialogLayout2.getChildren().add(parent);
                jfxDialogLayout2.setMaxHeight(50);
                JFXDialog jfxDialog = new JFXDialog(root,jfxDialogLayout2, JFXDialog.DialogTransition.TOP);

                jfxDialog.show();
                isDialogShown = true;
                dialogsArr.add(jfxDialog);



            } catch (IOException e){
                e.printStackTrace();
            }
            return;
        }
        Api api = new Api();
        api.AccountCreation(inputUsername.getText(),inputPassword.getText());

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

    public void onLayoutClicked(MouseEvent mouseEvent) {
        System.out.println("clikced on it");
    }

    public void checkDialog(MouseEvent mouseEvent) {
        if (isDialogShown){
//            jfxDialog.close();
            System.out.println("closed");
        }
    }

    public void closeButtomMainMenuAction(ActionEvent actionEvent) {
        Window.Close(createAccount);
    }
}

