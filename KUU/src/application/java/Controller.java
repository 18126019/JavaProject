package application.java;
 
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Pane menu;

    @FXML
    private AnchorPane container;
    int i = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        container.setTranslateX(-150);
        container.setMinWidth(1226);
        menu.setOnMouseClicked(event -> {
            if (i == 0) {
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.1));
                slide.setNode(container);

                slide.setToX(0);
                slide.play();

                container.setTranslateX(-150);

                slide.setOnFinished((ActionEvent e) -> {
                    container.setMinWidth(1076);
                    i = 1;
                });

            } else {
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.1));
                slide.setNode(container);

                slide.setToX(-150);
                slide.play();

                container.setTranslateX(0);

                slide.setOnFinished((ActionEvent e) -> {
                    i = 0;
                });

                container.setMinWidth(1226);
            }

        });
    }
}