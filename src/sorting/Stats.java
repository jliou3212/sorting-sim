package sorting;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class Stats extends HBox {

    public Stats(int delay, int swaps, String algorithm, int size) {
        this.setSpacing(20);
        Text temp;

        temp = new Text("Delay: " + delay);
        temp.setFill(Color.WHITE);
        this.getChildren().add(temp);

        temp = new Text("Swaps: " + swaps);
        temp.setFill(Color.WHITE);
        this.getChildren().add(temp);

        temp = new Text("Algorithm: " + algorithm);
        temp.setFill(Color.WHITE);
        this.getChildren().add(temp);

        temp = new Text("Size: " + size);
        temp.setFill(Color.WHITE);
        this.getChildren().add(temp);

    } // Stats

    public void setDelay(int d) {
        Text temp = new Text("Delay: " + d + " ms");
        temp.setFill(Color.WHITE);
        this.getChildren().set(0, temp);
    } // setDelay

    public void setSwaps(int s) {
        Text temp = new Text("Swaps: " + s);
        temp.setFill(Color.WHITE);
        this.getChildren().set(1, temp);
    } // setSwaps

} // Stats
