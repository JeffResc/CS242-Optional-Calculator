package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import main.Compute;

public class App extends Application {
    private final int SCENE_WIDTH = 500;
    private final int SCENE_HEIGHT = 250;
    private Compute compute = new Compute();
    private TextField entryTextField;

    @Override
    public void start(Stage stage) {
        // Entry Text Field
        entryTextField = new TextField();
        entryTextField.setTranslateX(0);
        entryTextField.setTranslateY(0);

        entryTextField.setOnKeyPressed( new EventHandler<KeyEvent>() {
            // change color of second button to red if r is pressed,
            // green if g is pressed, and blue if b is pressed
            public void handle( KeyEvent ke ) {
                if ( ke.getCode() == KeyCode.ENTER ) {
                    entryTextField.clear();
                }
            }
        });

        // Square Root Button
        Button buttonSqrt = new Button();
        buttonSqrt.setText("√");
        buttonSqrt.setTranslateX(0);
        buttonSqrt.setTranslateY(25);

        buttonSqrt.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "√" );
            }
        });

        // Power Button
        Button buttonPow = new Button();
        buttonPow.setText("^");
        buttonPow.setTranslateX(25);
        buttonPow.setTranslateY(25);

        buttonPow.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "^" );
            }
        });

        // Square Button
        Button buttonSq = new Button();
        buttonSq.setText("x²");
        buttonSq.setTranslateX(50);
        buttonSq.setTranslateY(25);

        buttonSq.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "²" );
            }
        });

        // Negate Button
        Button buttonNeg = new Button();
        buttonNeg.setText("(-)");
        buttonNeg.setTranslateX(75);
        buttonNeg.setTranslateY(25);

        buttonNeg.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "(-)" );
            }
        });

        // Mult Button
        Button buttonMult = new Button();
        buttonMult.setText("*");
        buttonMult.setTranslateX(100);
        buttonMult.setTranslateY(25);

        buttonMult.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "*" );
            }
        });

        // Div Button
        Button buttonDiv = new Button();
        buttonDiv.setText("/");
        buttonDiv.setTranslateX(100);
        buttonDiv.setTranslateY(50);

        buttonDiv.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "/" );
            }
        });

        // Plus Button
        Button buttonPlus = new Button();
        buttonPlus.setText("+");
        buttonPlus.setTranslateX(100);
        buttonPlus.setTranslateY(75);

        buttonPlus.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "+" );
            }
        });

        // Minus Button
        Button buttonMin = new Button();
        buttonMin.setText("-");
        buttonMin.setTranslateX(100);
        buttonMin.setTranslateY(100);

        buttonMin.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "-" );
            }
        });
        
        // 7 Button
        Button button7 = new Button();
        button7.setText("7");
        button7.setTranslateX(0);
        button7.setTranslateY(50);

        button7.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "7" );
            }
        });

        // 4 Button
        Button button4 = new Button();
        button4.setText("4");
        button4.setTranslateX(0);
        button4.setTranslateY(75);

        button4.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "4" );
            }
        });

        // 1 Button
        Button button1 = new Button();
        button1.setText("1");
        button1.setTranslateX(0);
        button1.setTranslateY(100);

        button1.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "1" );
            }
        });

        // 8 Button
        Button button8 = new Button();
        button8.setText("8");
        button8.setTranslateX(25);
        button8.setTranslateY(50);

        button8.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "8" );
            }
        });

        // 5 Button
        Button button5 = new Button();
        button5.setText("5");
        button5.setTranslateX(25);
        button5.setTranslateY(75);

        button5.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "5" );
            }
        });

        // 2 Button
        Button button2 = new Button();
        button2.setText("2");
        button2.setTranslateX(25);
        button2.setTranslateY(100);

        button2.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "2" );
            }
        });

        // 9 Button
        Button button9 = new Button();
        button9.setText("9");
        button9.setTranslateX(50);
        button9.setTranslateY(50);

        button9.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "9" );
            }
        });

        // 6 Button
        Button button6 = new Button();
        button6.setText("6");
        button6.setTranslateX(50);
        button6.setTranslateY(75);

        button6.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "6" );
            }
        });

        // 3 Button
        Button button3 = new Button();
        button3.setText("3");
        button3.setTranslateX(50);
        button3.setTranslateY(100);

        button3.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.setText( entryTextField.getText() + "3" );
            }
        });

        // Scene
        Group root = new Group(entryTextField, buttonSqrt, buttonPow, buttonSq, buttonNeg, buttonMult, buttonDiv, buttonPlus, buttonMin, button7, button4, button1, button8, button5, button2, button9, button6, button3);
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        // Stage
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) throws Exception {
        // Launch App
        launch(args);
    }
}
