package sorting;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.application.Platform;
import java.util.Random;
import java.lang.Thread;

// BUG ORIGINATION
// import javafx.scene.control.Button;
// import javafx.scene.control.TextField;

public class Sorting extends Application {

    private int[] sortedValues;
    private int[] scrambledValues;
    private Elements rectangles;
    private Stats statistics;
    private Background root;
    private Options optionScreen;
    private int size;
    private int swaps;
    private int delay;

    public void start(Stage stage) {
        
        // BUG ORIGINAION
        // Button test = new Button();
        // TextField test2 = new TextField();

        size = 100;
        setValues();
        scrambledValues = scramble(sortedValues);

        optionScreen = new Options();
        rectangles = new Elements(scrambledValues);
        statistics = new Stats(delay, swaps, "Bubble sort", size);
        root = new Background(statistics, rectangles);
        root.setStyle("-fx-background-color: transparent;");


        Scene mainScene = new Scene(root, Color.BLACK);

        stage.setScene(mainScene);
        stage.sizeToScene();
        stage.setTitle("Sorting gui");
        stage.show();

        // bubbleSort();
        selectionSort();


    } // start

    /**
     * Bubble sort implementation.
     *
     */
    public void bubbleSort() {

        Thread thread = new Thread(() -> {
            int temp, loopSwaps = 1;
            swaps = 0;
            delay = 3;

            Platform.runLater(() -> statistics.setDelay(delay));
            sleep(3000);

            // if no swaps are made during for loop, values are in order
            while (loopSwaps != 0) {
                loopSwaps = 0;
                for (int i = 0; i < size - 1; i++) {
                    if (scrambledValues[i] > scrambledValues[i + 1]) {
                        swapValues(i, i + 1);
                        loopSwaps++;
                        swaps++;
                        final int index = i;
                        final int index2 = i + 1;
                        Platform.runLater(() -> {
                            swapRectangles(index, index2);
                        }); // runLater
                        Platform.runLater(() -> statistics.setSwaps(swaps));
                        sleep(delay);
                    } // if
                } // for

            } // while
            for (int i = 0; i < scrambledValues.length; i++) {
                final int index = i;
                Platform.runLater(() -> {
                    rectangles.setRectangle(index, scrambledValues[index], Color.GREEN);
                }); // runLater
                sleep(delay);
            } // for
        }); // thread
        thread.setDaemon(true);
        thread.start();

    } // bubbleSort

    public void selectionSort() {

        Thread thread = new Thread(() -> {
            swaps = 0;
            int min;
            int index;
            delay = 50;

            Platform.runLater(() -> statistics.setDelay(delay));

            sleep(1000);

            for (int i = 0; i < size - 1; i++) {
                min = scrambledValues[swaps];
                index = swaps;
                for (int j = swaps + 1; j < size; j++) {
                    if (scrambledValues[j] < min) {
                        min = scrambledValues[j];
                        index = j;
                    } // if
                } // for
                Platform.runLater(() -> statistics.setSwaps(swaps));

                if (min != scrambledValues[swaps]) {
                    swapValues(swaps, index);
                    final int tempIndex = index;
                    Platform.runLater(() -> swapRectangles(swaps, tempIndex));
                } // if

                sleep(delay);
                swaps++;

            } // for
            for (int i = 0; i < size; i++) {
               // System.out.println(scrambledValues[i]);
            } // for

        }); // thread
        thread.setDaemon(true);
        thread.start();

    } // selectionSort

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            System.out.println("Sleep Interrupted");
        } // try

    } // sleep

    public void swapValues(int index, int index2) {
        int temp = scrambledValues[index];
        scrambledValues[index] = scrambledValues[index2];
        scrambledValues[index2] = temp;
    } // swapValues

    /**
     * Swaps two rectangles from the rectangles object.
     *
     */
    public void swapRectangles(int index, int index2) {
        rectangles.setRectangle(index, scrambledValues[index], Color.WHITE);
        rectangles.setRectangle(index2, scrambledValues[index2], Color.WHITE);

    } // swapRectangles

    /**
     * Sets the values of an array in order.
     *
     */
    public void setValues() {
        sortedValues = new int[size];

        for (int i = 0; i < size; i++) {
            sortedValues[i] = i*5;
        } // for

    } // setValues

    /**
     * Scrambles the values of an array.
     *
     */
    public int[] scramble(int[] array) {
        int[] tempArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArr[i] = array[i];
        } // for

        int index, temp;
        Random rand = new Random();

        for (int i = tempArr.length - 1; i > 0; i--) {
            index = rand.nextInt(i + 1);
            temp = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = temp;
        } // for
        
        return tempArr;

    } // scrambleValues


} // Sorting
