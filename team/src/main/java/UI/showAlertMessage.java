package UI;

import javafx.scene.control.Alert;

public class showAlertMessage {
    public showAlertMessage(String title,String alertText,Alert.AlertType alertType){
        Alert alert = new Alert(alertType,alertText);
        alert.setTitle(title);
        alert.show();
    }
}
