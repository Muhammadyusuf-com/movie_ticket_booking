package UI.admin;

import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class addShow extends GridPane {
    private GridPane root;
    public addShow(){

        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);

        TextField createdOn = new TextField();
        Label createdOnLabel = new Label("Date created: ");
        TextField startTime = new TextField();
        Label startTimeLabel = new Label("Starting time");
        TextField endTime = new TextField();
        Label endTimeLabel = new Label("Ending time");

        Button addShow = new Button("Add Show");

        root.add(createdOnLabel,0,0);
        root.add(createdOn,1,0);
        root.add(startTimeLabel,0,1);
        root.add(startTime,1,1);
        root.add(endTimeLabel,0,2);
        root.add(endTime,1,2);
        root.add(addShow,1,3);

        addShow.setOnMouseClicked(event -> {
            //save data to the file
        });

    }
    public GridPane getPane(){
        return this.root;
    }
}