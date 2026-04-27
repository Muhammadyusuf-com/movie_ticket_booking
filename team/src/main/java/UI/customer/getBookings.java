package UI.customer;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class getBookings extends GridPane {
    private GridPane root;
    public getBookings(){
        this.root = new GridPane();
        TextField bookings = new TextField();
        //runs the getBookings function and lists all the data in Text Field
    }
    public GridPane getRoot(){
        return this.root;
    }
}
