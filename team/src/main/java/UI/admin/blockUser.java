package UI.admin;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class blockUser extends GridPane {
    private GridPane root;
    public blockUser(){
        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);

        TextField search = new TextField();
        Label searchLabel = new Label("Search Bar");
        Button searchButton = new Button("Search");
        Button blockUser = new Button("Block User");
        TextField information = new TextField();
        information.setEditable(false);
        information.setVisible(false);
        root.add(searchLabel,0,0);
        root.add(search,0,1);
        root.add(searchButton,0,2);
        root.add(information,0,3);
        root.add(blockUser,0,4);

        //not Visible while not found
        blockUser.setVisible(false);

        searchButton.setOnMouseClicked(event -> {
            //search from the users file and show information found inside the Text Field
            //if user is found set the visibility of the blockUser to true
            //if not found show the information or alert message
        });

    }
    public GridPane getRoot(){
        return this.root;
    }
}