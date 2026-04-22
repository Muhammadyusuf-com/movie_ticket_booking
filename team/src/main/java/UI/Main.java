package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage){
        LoginPage loginPage = new LoginPage(stage);
        stage.setScene(loginPage.getScene());
        stage.setTitle("Login Page");
        stage.show();
    }
}
