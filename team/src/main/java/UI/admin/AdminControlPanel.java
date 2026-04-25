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
        this.scene = new Scene(main,600,400);
        main.setPadding(new Insets(10));
        VBox selectionPanel = new VBox(15);
        main.getChildren().add(selectionPanel);
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
            if(main.getChildren().contains(addshow.getPane())){
                main.getChildren().remove(addshow.getPane());
            }
            if(main.getChildren().contains(blockuser.getRoot())){
                main.getChildren().remove(blockuser.getRoot());
            }
            if(!main.getChildren().contains(addmovie.getPane())){
            main.getChildren().add(addmovie.getPane());}
        });
        addShowButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(addmovie.getPane())){
                main.getChildren().remove(addmovie.getPane());
            }
            if(main.getChildren().contains(blockuser.getRoot())){
                main.getChildren().remove(blockuser.getRoot());
            }
            if(!main.getChildren().contains(addshow.getPane())){
                main.getChildren().add(addshow.getPane());
            }
        });
        blockUserButton.setOnMouseClicked(event -> {
            if(main.getChildren().contains(addshow.getPane())){
                main.getChildren().remove(addshow.getPane());
            }
            if(main.getChildren().contains(addmovie.getPane())){
                main.getChildren().remove(addmovie.getPane());
            }
            if(!main.getChildren().contains(blockuser.getRoot())){
                main.getChildren().add(blockuser.getRoot());
            }
        });

    }
    public Scene getScene(){
        return this.scene;
    }

}