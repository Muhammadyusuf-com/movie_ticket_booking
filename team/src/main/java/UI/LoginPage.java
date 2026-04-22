package UI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage{
    private Scene scene;

    public LoginPage(Stage stage){
        GridPane root = new GridPane();
        scene = new Scene(root,280,180);
        root.setVgap(12);
        root.setHgap(12);
        root.setPadding(new Insets(20));

        TextField emailTextField = new TextField();
        Label emailLabel = new Label("Email");
        TextField passwordTextField = new TextField();
        Label passwordLabel = new Label("Password");
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        Button guestButton = new Button("Guest");

        root.add(emailLabel,0,0);
        root.add(emailTextField,1,0);
        root.add(passwordLabel,0,1);
        root.add(passwordTextField,1,1);
        root.add(registerButton,0,2);
        root.add(loginButton,1,2);
        root.add(guestButton,0,3);

        loginButton.setOnMouseClicked(event -> {
        //get the text from the TextFields and pass as parameters to the function logins
    });
        registerButton.setOnMouseClicked(event -> {
            RegisterPage registerPage = new RegisterPage(stage);
            this.scene = registerPage.getScene();
            stage.setScene(scene);
            stage.setTitle("Registration Page");
    });
        guestButton.setOnMouseClicked(event -> {
            GuestPage guestPage = new GuestPage();
            this.scene = guestPage.getScene();
            stage.setScene(scene);
            stage.setTitle("Guest Page");
    });

    }
    public Scene getScene(){
        return this.scene;
    }
}
