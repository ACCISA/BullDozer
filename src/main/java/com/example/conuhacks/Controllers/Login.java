package com.example.conuhacks.Controllers;

import Entities.Window;
import Func.Api;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Login {

    @FXML
    private JFXTextField inputLoginUsername;

    @FXML
    private JFXPasswordField inputLoginPassword;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private JFXButton closeButtonMainMenu;

    @FXML
    void closeButtomMainMenuAction(ActionEvent event) {
        Window.Close(registerBtn);
    }

    public void registerButtonActionFromLogin(ActionEvent actionEvent) {
        Window.Close(registerBtn);
        Window register = new Window(300,400,"src/main/resources/com/example/conuhacks/Submenus/register-menu.fxml");
        register.Open();
    }

    public void loginButtonAction(ActionEvent actionEvent) {
        Api api = new Api();
        String status = api.AccountLogin(inputLoginUsername.getText(),inputLoginPassword.getText());
        if (status.equals("false")) {
            System.out.println("invalid login");
            return;
        }
        System.out.println("valid login");
    }
}