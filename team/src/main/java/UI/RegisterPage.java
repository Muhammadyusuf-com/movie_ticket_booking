package UI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterPage{
    private Scene scene;
    private GridPane root;
    public RegisterPage(Stage stage){
        root = new GridPane();
        scene = new Scene(root,360,180);
        root.setVgap(12);
        root.setHgap(12);
        root.setPadding(new Insets(20));

        TextField emailTextField = new TextField();
        Label emailLabel = new Label("Email");
        TextField passwordTextField = new TextField();
        Label passwordLabel = new Label("Password");
        Button registerButton = new Button("Register");
        Button goBackToLoginPageButton = new Button("Back to Login");

        root.add(emailLabel,0,0);
        root.add(emailTextField,1,0);
        root.add(passwordLabel,0,1);
        root.add(passwordTextField,1,1);
        root.add(registerButton,0,2);
        root.add(goBackToLoginPageButton,0,3);

        registerButton.setOnMouseClicked(event -> {
            //get the text from the TextFields and pass as parameters to the function login
        });
        goBackToLoginPageButton.setOnMouseClicked(event -> {
            LoginPage loginPage = new LoginPage(stage);
            this.scene = loginPage.getScene();
            stage.setScene(scene);
            stage.setTitle("Login Page");
        });


    }
    public Scene getScene(){
        return this.scene;
    }
}
