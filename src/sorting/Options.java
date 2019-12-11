package sorting;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class Options extends HBox {

    private VBox buttons;
    private VBox stats;
    private Button bubbleButton;
    private Button selectionButton;

    public Options() {

        setButtons();
        // left side vbox
        buttons = new VBox(20);
        
        buttons.getChildren().add(bubbleButton);
        buttons.getChildren().add(selectionButton);
        
        // right side vbox
        stats = new VBox(20);

        //hbox creation
        HBox delayBox = new HBox();
        HBox sizeBox = new HBox();

        //set delaybox
        delayBox.getChildren().add(new Label("Delay(ms): "));
        TextField delayText = new TextField("50");
        delayBox.getChildren().add(delayText);
        
        //set sizebox
        sizeBox.getChildren().add(new Label("Size: "));
        TextField sizeText = new TextField("100");
        sizeBox.getChildren().add(sizeText);

        stats.getChildren().add(delayBox);
        stats.getChildren().add(sizeBox);
        
        this.getChildren().add(buttons);
        this.getChildren().add(stats);
        Button test = new Button();

    } // default constructor

    private void setButtons() {
        
        bubbleButton = new Button("Bubble sort");
        selectionButton = new Button("Selection sort");

    } // setButtons

} // home
