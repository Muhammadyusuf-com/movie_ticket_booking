package UI;

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
        scene = new Scene(root,360,600);
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
        root.add(nameLabel,0,2);
        root.add(nameField,1,2);
        root.add(emailLabel,0,3);
        root.add(emailField,1,3);
        root.add(phoneLabel,0,4);
        root.add(phoneField,1,4);
        root.add(streetLabel,0,5);
        root.add(streetField,1,5);
        root.add(cityLabel,0,6);
        root.add(cityField,1,6);
        root.add(regionLabel,0,7);
        root.add(regionField,1,7);
        root.add(zipcodeLabel,0,8);
        root.add(zipcodeField,1,8);
        root.add(countryLabel,0,9);
        root.add(countryField,1,9);
        root.add(goBackToLoginPageButton,0,11);
        root.add(registerButton,1,11);

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

    public boolean isUserExists(String id) throws RuntimeException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.trim().split("\\|");
                if(data[0].equals(id)){
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;

    }

    public void registerUser(Account account) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt",true));
            String line = account.getId()+"|"
                    +account.getPasswrod()+"|"
                    +account.getStatus()+"|"
                    +account.getPerson().getName()+"|"
                    +account.getPerson().getAddress().city()+"|"
                    +account.getPerson().getAddress().streetAddress()+"|"
                    +account.getPerson().getAddress().country()+"|"
                    +account.getPerson().getAddress().State()+"|"
                    +account.getPerson().getAddress().zipcode()+"|"
                    +account.getPerson().getEmail()+"|"
                    +account.getPerson().getPhone();
            bw.write(line);
            bw.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public Scene getScene(){
        return this.scene;
    }
}
