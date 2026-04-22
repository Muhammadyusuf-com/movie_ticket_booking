package UI.admin;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminControlPanel {
    private Scene scene;
    public AdminControlPanel(){
        HBox main = new HBox(20);
        main.setPadding(new Insets(10));
        VBox selectionPanel = new VBox(15);
        selectionPanel.setPadding(new Insets(10));
        Button addMovieButton = new Button("Add Movie");
        Button addShowButton = new Button("Add Show");
        Button blockUserButton = new Button("Block User");
        selectionPanel.getChildren().addAll(
                addMovieButton,
                addShowButton,
                blockUserButton
        );
        addShow addshow = new addShow();
        blockUser blockuser = new blockUser();
        addMovie addmovie = new addMovie();

        addMovieButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(addshow)){
                main.getChildren().remove(addshow);
            }
            if(main.getChildren().contains(blockuser)){
                main.getChildren().remove(blockuser);
            }
            main.getChildren().add(addmovie);
        });
        addShowButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(addmovie)){
                main.getChildren().remove(addmovie);
            }
            if(main.getChildren().contains(blockuser)){
                main.getChildren().remove(blockuser);
            }
            main.getChildren().add(addshow);
        });
        blockUserButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(addshow)){
                main.getChildren().remove(addshow);
            }
            if(main.getChildren().contains(addmovie)){
                main.getChildren().remove(addmovie);
            }
            main.getChildren().add(blockuser);
        });

    }
    public Scene getScene(){
        return this.scene;
    }

}