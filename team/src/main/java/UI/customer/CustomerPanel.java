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
        Button makeBookingButton = new Button("Make Booking");
        Button getBookingsButton = new Button("Get Bookings");
        selectionPanel.getChildren().addAll(
                makeBookingButton,
                getBookingsButton
        );

        getBookings getbookings = new getBookings();
        makeBooking makebooking = new makeBooking();

        main.getChildren().add(selectionPanel);

        makeBookingButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(getbookings.getRoot())){
                main.getChildren().remove(getbookings.getRoot());
            }
            if(!main.getChildren().contains(makebooking.getRoot())){
            main.getChildren().add(makebooking.getRoot());}
        });
        getBookingsButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(makebooking.getRoot())){
                main.getChildren().remove(makebooking.getRoot());
            }
            if(!main.getChildren().contains(getbookings.getRoot())){
                main.getChildren().add(getbookings.getRoot());
            }
        });
        this.scene = new Scene(main,400,350);
    }
    public Scene getScene(){
        return this.scene;
    }
}
