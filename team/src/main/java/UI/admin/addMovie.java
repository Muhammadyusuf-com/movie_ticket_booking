package UI.admin;

import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class addMovie extends GridPane {
    private GridPane root;
    public addMovie(){

        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);

        TextField titleField = new TextField();
        Label titleLabel = new Label();

        TextField descriptionField = new TextField();
        Label descriptionLabel = new Label();

        TextField durationField = new TextField();
        Label durationLabel = new Label();

        TextField languageField = new TextField();
        Label languageLabel = new Label();

        DateCell releaseDate = new DateCell();
        Label releaseLabel = new Label();

        TextField country = new TextField();
        Label countryLabel = new Label();

        TextField genre = new TextField();
        Label genreLabel = new Label();
        Button addMovie = new Button("Add Movie");

        root.add(titleLabel,0,0);
        root.add(titleField,1,0);
        root.add(descriptionLabel,0,1);
        root.add(descriptionField,1,1);
        root.add(durationLabel,0,2);
        root.add(durationField,1,2);
        root.add(languageLabel,0,3);
        root.add(languageField,1,3);
        root.add(releaseLabel,0,4);
        root.add(releaseDate,1,4);
        root.add(countryLabel,0,5);
        root.add(country,1,5);
        root.add(genreLabel,0,6);
        root.add(genre,1,6);
        root.add(addMovie,1,7);


        addMovie.setOnMouseClicked(event -> {
            //pass the data collected to the file storage
        });

    }
    public GridPane getPane(){
        return this.root;
    }
}