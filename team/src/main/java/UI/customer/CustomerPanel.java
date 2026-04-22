package UI.customer;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomerPanel {
    private Scene scene;
    public CustomerPanel(){
        HBox main = new HBox(20);
        main.setPadding(new Insets(10));
        VBox selectionPanel = new VBox(15);
        selectionPanel.setPadding(new Insets(10));
        Button makeBookingButton = new Button("Add Movie");
        Button getBookingsButton = new Button("Add Show");
        selectionPanel.getChildren().addAll(
                makeBookingButton,
                getBookingsButton
        );

        getBookings getbookings = new getBookings();
        makeBooking makebooking = new makeBooking();

        makeBookingButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(getbookings)){
                main.getChildren().remove(getbookings);
            }
            main.getChildren().add(makebooking);
        });
        getBookingsButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(makebooking)){
                main.getChildren().remove(makebooking);
            }
            main.getChildren().add(getbookings);
        });
    }
    public Scene getScene(){
        return this.scene;
    }
}
