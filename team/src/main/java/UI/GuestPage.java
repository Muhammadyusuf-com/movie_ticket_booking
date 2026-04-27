package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GuestPage {
    private final Scene scene;
    private String searchKey;
    public GuestPage(){
        GridPane searchBar = new GridPane();
        searchBar.setVgap(10);
        searchBar.setHgap(10);
        searchBar.setPadding(new Insets(15));
        TextField searchTile = new TextField();
        String[] searchOptions = {"Title","Genre","Language","ReleaseDate","CityName"};
        ChoiceBox c = new ChoiceBox(FXCollections.observableArrayList(searchOptions));
        Label searchTileTitle = new Label("Select the Search Option");
        Label choiceboxLabel = new Label("Search Options");
        Button searchButton = new Button("Search");
        c.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                searchTileTitle.setText(searchOptions[new_value.intValue()]);
            }
        });

        searchBar.add(searchTile, 0,1);
        searchBar.add(c, 1,1);
        searchBar.add(searchTileTitle, 0,0);
        searchBar.add(choiceboxLabel, 1,0);
        searchBar.add(searchButton,0,2);
        this.scene = new Scene(searchBar,360,180);

        searchButton.setOnMouseClicked(event -> {
            //search for the movie using searchKey
        });

    }
    public Scene getScene(){
        return this.scene;
    }
}
