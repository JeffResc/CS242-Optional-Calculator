package main;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    private final int SCENE_WIDTH = 325;
    private final int SCENE_HEIGHT = 450;
    private Calculator calculator = new Calculator();
    private TextField entryTextField;
    private TextField sliderTextField;

    private Boolean shouldClear = false;

    private void setOperButtonAction(Button b) {
        b.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                final float f = Float.parseFloat(entryTextField.getText());
                final String operator = b.getText();
                switch (operator) {
                    case Calculator.ADD_OP:
                    case Calculator.SUB_OP:
                    case Calculator.MULT_OP:
                    case Calculator.DIV_OP:
                    case Calculator.POW_OP:
                        calculator.setCurrentOperator(operator);
                        calculator.setCurrentValue(f);
                        entryTextField.setText(entryTextField.getText()+operator);
                        shouldClear = true;
                        break;
                    case Calculator.SQRT_OP:
                        calculator.sqrtValue(f);
                        updateDisplayedValue();
                        break;
                    case Calculator.NEG_OP:
                        calculator.negValue(f);
                        updateDisplayedValue();
                        break;
                    case Calculator.SQ_OP:
                        calculator.sqValue(f);
                        updateDisplayedValue();
                        break;
                }
            }
        });
    }

    private void useEquals() {
        final float f = Float.parseFloat(entryTextField.getText());
        calculator.equals(f);
        updateDisplayedValue();
    }

    private void setNumButtonAction(Button b) {
        b.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useNumButton(b.getText());
            }
        });
    }

    private void useNumButton(String s) {
        if (shouldClear) {
            shouldClear = false;
            entryTextField.setText(s);
        } else
            entryTextField.setText(entryTextField.getText() + s);
    }

    private void setButtonSize(Control c) {
        setSizeMan(c, 1, 1);
    }

    private void setSizeMan(Control c, int x, int y) {
        c.setMinSize(x * 50, y * 50);
        c.setPrefSize(x * 50, y * 50);
        c.setMaxSize(x * 50, y * 50);
    }

    private void setPos(Control c, int x, int y) {
        c.setTranslateX(x * 50);
        c.setTranslateY(y * 50);
    }

    private void updateDisplayedValue() {
        String currentValueStr = Float.toString(calculator.getCurrentValue());
        if (currentValueStr.endsWith(".0"))
            currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 2);
        entryTextField.setText(currentValueStr);
    }

    @Override
    public void start(Stage stage) {
        // Entry Text Field
        entryTextField = new TextField();
        entryTextField.setTranslateX(0);
        entryTextField.setTranslateY(0);
        setSizeMan(entryTextField, 6, 1);

        // Square Root Button
        Button buttonSqrt = new Button();
        buttonSqrt.setText(Calculator.SQRT_OP);
        setPos(buttonSqrt, 0, 1);
        setButtonSize(buttonSqrt);
        setOperButtonAction(buttonSqrt);

        // Power Button
        Button buttonPow = new Button();
        buttonPow.setText(Calculator.POW_OP);
        setPos(buttonPow, 1, 1);
        setButtonSize(buttonPow);
        setOperButtonAction(buttonPow);

        // Square Button
        Button buttonSq = new Button();
        buttonSq.setText(Calculator.SQ_OP);
        setPos(buttonSq, 2, 1);
        setButtonSize(buttonSq);
        setOperButtonAction(buttonSq);

        // Negate Button
        Button buttonNeg = new Button();
        buttonNeg.setText(Calculator.NEG_OP);
        setPos(buttonNeg, 0, 5);
        setButtonSize(buttonNeg);
        setOperButtonAction(buttonNeg);

        // Decimal Button
        Button buttonDec = new Button();
        buttonDec.setText(".");
        setPos(buttonDec, 2, 5);
        setButtonSize(buttonDec);
        setNumButtonAction(buttonDec);

        // Equals Button
        Button buttonEq = new Button();
        buttonEq.setText("=");
        setPos(buttonEq, 3, 5);
        setButtonSize(buttonEq);
        buttonEq.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useEquals();
            }
        });

        // Mult Button
        Button buttonMult = new Button();
        buttonMult.setText(Calculator.MULT_OP);
        setPos(buttonMult, 3, 2);
        setButtonSize(buttonMult);
        setOperButtonAction(buttonMult);

        // Div Button
        Button buttonDiv = new Button();
        buttonDiv.setText(Calculator.DIV_OP);
        setPos(buttonDiv, 3, 1);
        setButtonSize(buttonDiv);
        setOperButtonAction(buttonDiv);

        // Add Button
        Button buttonPlus = new Button();
        buttonPlus.setText(Calculator.ADD_OP);
        setPos(buttonPlus, 3, 4);
        setButtonSize(buttonPlus);
        setOperButtonAction(buttonPlus);

        // Subtract Button
        Button buttonMin = new Button();
        buttonMin.setText(Calculator.SUB_OP);
        setPos(buttonMin, 3, 3);
        setButtonSize(buttonMin);
        setOperButtonAction(buttonMin);
        
        // 7 Button
        Button button7 = new Button();
        button7.setText("7");
        setPos(button7, 0, 2);
        setButtonSize(button7);
        setNumButtonAction(button7);

        // 4 Button
        Button button4 = new Button();
        button4.setText("4");
        setPos(button4, 0, 3);
        setButtonSize(button4);
        setNumButtonAction(button4);

        // 1 Button
        Button button1 = new Button();
        button1.setText("1");
        setPos(button1, 0, 4);
        setButtonSize(button1);
        setNumButtonAction(button1);

        // 8 Button
        Button button8 = new Button();
        button8.setText("8");
        setPos(button8, 1, 2);
        setButtonSize(button8);
        setNumButtonAction(button8);

        // 5 Button
        Button button5 = new Button();
        button5.setText("5");
        setPos(button5, 1, 3);
        setButtonSize(button5);
        setNumButtonAction(button5);

        // 2 Button
        Button button2 = new Button();
        button2.setText("2");
        setPos(button2, 1, 4);
        setButtonSize(button2);
        setNumButtonAction(button2);

        // 9 Button
        Button button9 = new Button();
        button9.setText("9");
        setPos(button9, 2, 2);
        setButtonSize(button9);
        setNumButtonAction(button9);

        // 6 Button
        Button button6 = new Button();
        button6.setText("6");
        setPos(button6, 2, 3);
        setButtonSize(button6);
        setNumButtonAction(button6);

        // 3 Button
        Button button3 = new Button();
        button3.setText("3");
        setPos(button3, 2, 4);
        setButtonSize(button3);
        setNumButtonAction(button3);

        // 0 Button
        Button button0 = new Button();
        button0.setText("0");
        setPos(button0, 1, 5);
        setButtonSize(button0);
        setNumButtonAction(button0);

        // Clear Button
        Button buttonClear = new Button();
        buttonClear.setText("C");
        setPos(buttonClear, 5, 1);
        setButtonSize(buttonClear);
        buttonClear.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.clear();
                sliderTextField.clear();
                calculator.clearValue();
            }
        });

        // Clear Entry Button
        Button buttonClearEntry = new Button();
        buttonClearEntry.setText("CE");
        setPos(buttonClearEntry, 5, 2);
        setButtonSize(buttonClearEntry);
        buttonClearEntry.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.clear();
            }
        });

        // Slider Button
        Button buttonSlider = new Button();
        buttonSlider.setText("Use Slider");
        setPos(buttonSlider, 0, 8);
        setSizeMan(buttonSlider, 4, 1);

        buttonSlider.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useNumButton(sliderTextField.getText());
                sliderTextField.clear();
            }
        });

        // Slider Text Field
        sliderTextField = new TextField();
        setPos(sliderTextField, 0, 7);
        setSizeMan(sliderTextField, 4, 1);

        // Slider
        Slider slider = new Slider();
        setSizeMan(slider, 4, 1);
        setPos(slider, 0, 6);
        slider.setStyle("-fx-font-size: 30; -fx-text-fill: #EEEEEE;");
        slider.valueProperty().addListener( new ChangeListener<Number>() {
            @Override
            public void changed( ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue ) {
                sliderTextField.textProperty().setValue( Integer.toString((int)Math.round((Double) newValue)));
            }
        });

        // Scene
        Group root = new Group(entryTextField, buttonSqrt, buttonPow, buttonSq, buttonNeg, buttonDec, buttonEq, buttonMult, buttonDiv, buttonPlus, buttonMin, button7, button4, button1, button8, button5, button2, button9, button6, button3, button0, buttonClear, buttonClearEntry, buttonSlider, sliderTextField, slider);
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        // Key Events
        root.setOnKeyPressed( new EventHandler<KeyEvent>() {
            // change color of second button to red if r is pressed,
            // green if g is pressed, and blue if b is pressed
            public void handle( KeyEvent ke ) {
                switch (ke.getCode()) {
                    case ENTER:
                        useEquals();
                        break;
                    case NUMPAD1:
                    case DIGIT1:
                        useNumButton("1");
                        break;
                    case NUMPAD2:
                    case DIGIT2:
                        useNumButton("2");
                        break;
                    case NUMPAD3:
                    case DIGIT3:
                        useNumButton("3");
                        break;
                    case NUMPAD4:
                    case DIGIT4:
                        useNumButton("4");
                        break;
                    case NUMPAD5:
                    case DIGIT5:
                        useNumButton("5");
                        break;
                    case NUMPAD6:
                    case DIGIT6:
                        useNumButton("6");
                        break;
                    case NUMPAD7:
                    case DIGIT7:
                        useNumButton("7");
                        break;
                    case NUMPAD8:
                    case DIGIT8:
                        useNumButton("8");
                        break;
                    case NUMPAD9:
                    case DIGIT9:
                        useNumButton("9");
                        break;
                    case NUMPAD0:
                    case DIGIT0:
                        useNumButton("0");
                        break;
                    default:
                        break;
                }
            }
        });

        // Set CSS
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        scene.setFill(Color.rgb(33,33,33));
        root.getStyleClass().add("root");

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
