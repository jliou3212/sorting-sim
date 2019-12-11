package sorting;

import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Elements extends HBox {
    private int size;
    private int width = 700;
    private int height = 500;
    private int[] values = new int[size];

    public Elements(int[] values) {
        this.values = values;
        size = values.length;
        this.setSpacing(1);

        setRectangles(size);

    } // default constructor

    public int getSize() {
        return size;
    } // getSize

    public int getH() {
        return height;
    } // height

    public int getW() {
        return width;
    } // width

    private void setRectangles(int size) {
        for (int i = 0; i < size; i++) {
            addRectangle(i, values[i], Color.WHITE);
        } // for

    } // setRectangles

    public void setRectangle(int index, int val, Color c) {
        Rectangle tempRect = new Rectangle(width / size, val, c);
        tempRect.getTransforms().add(new Rotate(180));
        this.getChildren().set(index, tempRect);
        this.getChildren().get(index).setTranslateY(height);
    } // setRectangle

    private void addRectangle(int index, int val, Color c) {
        Rectangle tempRect = new Rectangle(width / size, val, c);
        tempRect.getTransforms().add(new Rotate(180));
        this.getChildren().add(tempRect);
        this.getChildren().get(index).setTranslateY(height);

    } // addRectangle


} // Elements
