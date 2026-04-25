package UI.customer;

import javafx.scene.layout.GridPane;

public class makeBooking extends GridPane {
    GridPane root;
    public makeBooking(){
        root = new GridPane();
    }
    public GridPane getRoot(){
        return this.root;
    }
}
