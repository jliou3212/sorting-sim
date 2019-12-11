package sorting;

import javafx.scene.layout.VBox;

public class Background extends VBox {

    public Background(Stats stat, Elements rects) {
        this.getChildren().add(stat);
        this.getChildren().add(rects);
    } // default constructor

} // Background
