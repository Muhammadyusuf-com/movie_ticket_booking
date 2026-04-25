package UI;

import UI.admin.AdminControlPanel;
import UI.customer.CustomerPanel;
import UI.frontDeskOffice.FrontDesktOfficerPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage{
    private final Scene scene;

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
            try{
                int returned = checkLogin(emailTextField.getText().trim(),passwordTextField.getText().trim());
                switch (returned){
                    case 1:
                        AdminControlPanel adminControlPanel = new AdminControlPanel();
                        stage.setScene(adminControlPanel.getScene());
                        stage.setTitle("Admin Control Panel");
                        break;
                    case 2:
                        CustomerPanel customerPanel = new CustomerPanel();
                        stage.setScene(customerPanel.getScene());
                        stage.setTitle("Customer Panel");
                        break;
                    case 3:
                        FrontDesktOfficerPanel frontDesktOfficerPanel = new FrontDesktOfficerPanel();
                        stage.setScene(frontDesktOfficerPanel.getScene());
                        stage.setTitle("Front Desk Officer Panel");
                        break;
                    case 0:
                        System.out.println("Error type should be shown in alert message");
                        break;
                }
            }catch (FileNotFoundException e){
                new showAlertMessage("System error","Could find the file", Alert.AlertType.ERROR);
            }
        });
        registerButton.setOnMouseClicked(event -> {
            RegisterPage registerPage = new RegisterPage(stage);
            stage.setScene(registerPage.getScene());
            stage.setTitle("Registration Page");
    });
        guestButton.setOnMouseClicked(event -> {
            GuestPage guestPage = new GuestPage();
            stage.setScene(guestPage.getScene());
            stage.setTitle("Guest Page");
    });

    }
    public static int checkLogin(String email, String password) throws FileNotFoundException {
        String[] userLoginInfo = new String[0];
        try(BufferedReader bw = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while((line = bw.readLine()) != null){
                userLoginInfo = line.split("\\|");
                if(email.equals(userLoginInfo[0]) && password.equals(userLoginInfo[1])){
                    new showAlertMessage("Success", "You are successfully signed in", Alert.AlertType.INFORMATION);
                    switch(userLoginInfo[2]){
                        case "admin":
                            return 1;
                        case "customer":
                            return 2;
                        case "frontdesk":
                            return 3;
                    }
                }
            }
        if(email.equals(userLoginInfo[0])){
                new showAlertMessage("Warning","Password doesn't match", Alert.AlertType.WARNING);
        }else{
                new showAlertMessage("Warning","User not found", Alert.AlertType.ERROR);
        }
            return 0;

        } catch (IOException e) {
            new showAlertMessage("Warning","Empty File", Alert.AlertType.WARNING);
            throw new RuntimeException(e);
        }
    }
    public Scene getScene(){
        return this.scene;
    }
}
