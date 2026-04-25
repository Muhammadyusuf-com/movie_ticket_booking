package UI;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.AccountStatus;
import enums.Address;
import identity.Account;
import identity.Person;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;

public class RegisterPage{
    private Scene scene;
    public RegisterPage(Stage stage){
        GridPane root = new GridPane();
        scene = new Scene(root,360,180);
        root.setVgap(12);
        root.setHgap(12);
        root.setPadding(new Insets(20));

        TextField idTextField = new TextField();
        Label idLabel = new Label("id");
        TextField passwordTextField = new TextField();
        Label passwordLabel = new Label("Password");
        Button registerButton = new Button("Register");
        Button goBackToLoginPageButton = new Button("Back to Login");
        Label nameLabel = new Label("Full Name");
        TextField nameField = new TextField();
        Label emailLabel = new Label("email");
        TextField emailField = new TextField();
        Label phoneLabel = new Label("Phone");
        TextField phoneField = new TextField();
        Label streetLabel = new Label("Street Address");
        TextField streetField = new TextField();
        Label cityLabel = new Label("City");
        TextField cityField = new TextField();
        Label regionLabel = new Label("Region");
        TextField regionField = new TextField();
        Label zipcodeLabel = new Label("Zipcode");
        TextField zipcodeField = new TextField();
        Label countryLabel = new Label("Country");
        TextField countryField = new TextField();

        root.add(idLabel,0,0);
        root.add(idTextField,1,0);
        root.add(passwordLabel,0,1);
        root.add(passwordTextField,1,1);
        root.add(registerButton,0,2);
        root.add(nameLabel,0,3);
        root.add(nameField,1,3);
        root.add(emailLabel,0,4);
        root.add(emailField,1,4);
        root.add(phoneLabel,0,5);
        root.add(phoneField,1,5);
        root.add(streetLabel,0,6);
        root.add(streetField,1,6);
        root.add(cityLabel,0,7);
        root.add(cityField,1,7);
        root.add(regionLabel,0,8);
        root.add(regionField,1,8);
        root.add(zipcodeLabel,0,9);
        root.add(zipcodeField,1,9);
        root.add(countryLabel,0,10);
        root.add(countryField,1,10);
        root.add(goBackToLoginPageButton,0,11);

        registerButton.setOnMouseClicked(event -> {
            if(isUserExists(idTextField.getText().trim())){
                new showAlertMessage("Warning","User already exists", Alert.AlertType.WARNING);
            }else{
            Address address = new Address(
                    streetField.getText(),
                    cityField.getText(),
                    regionLabel.getText(),
                    zipcodeField.getText(),
                    countryField.getText());
            Person person = new Person(
                    nameField.getText(),
                    address,
                    emailField.getText(),
                    phoneField.getText());
            Account account = new Account(
                    idTextField.getText(),
                    passwordTextField.getText(),
                    AccountStatus.Active,
                    person
                    );
            registerUser(account);
            }
        });

        goBackToLoginPageButton.setOnMouseClicked(event -> {
            LoginPage loginPage = new LoginPage(stage);
            this.scene = loginPage.getScene();
            stage.setScene(scene);
            stage.setTitle("Login Page");
        });

    }

    public boolean isUserExists(String id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Account user = mapper.readValue(new File("user.json"), Account.class);
            if(user.getId().equals(id)){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void registerUser(Account account) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("users.json"), account);
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Scene getScene(){
        return this.scene;
    }
}
