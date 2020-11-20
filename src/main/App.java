package main;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class App extends Application {
    private final int SCENE_WIDTH = 500;
    private final int SCENE_HEIGHT = 250;
    private Calculator calculator = new Calculator();
    private TextField entryTextField;
    private TextField sliderTextField;

    private Boolean shouldClear = false;

    private void updateDisplayedValue() {
        String currentValueStr = Float.toString(calculator.getCurrentValue());
        if (currentValueStr.endsWith(".0"))
            currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 2);
        entryTextField.setText(currentValueStr);
    }

    private void useEquals() {
        float f = Float.parseFloat(entryTextField.getText());
        calculator.equals(f);
        updateDisplayedValue();
    }

    private void useOperator(String operator) {
        float f = Float.parseFloat(entryTextField.getText());
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

    private void useButton(String s) {
        if (shouldClear) {
            shouldClear = false;
            entryTextField.setText(s);
        } else
            entryTextField.setText(entryTextField.getText() + s);
    }

    @Override
    public void start(Stage stage) {
        // Entry Text Field
        entryTextField = new TextField();
        entryTextField.setTranslateX(0);
        entryTextField.setTranslateY(0);

        // Square Root Button
        Button buttonSqrt = new Button();
        buttonSqrt.setText(Calculator.SQRT_OP);
        buttonSqrt.setTranslateX(0);
        buttonSqrt.setTranslateY(25);

        buttonSqrt.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonSqrt.getText());
            }
        });

        // Power Button
        Button buttonPow = new Button();
        buttonPow.setText(Calculator.POW_OP);
        buttonPow.setTranslateX(25);
        buttonPow.setTranslateY(25);

        buttonPow.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonPow.getText());
            }
        });

        // Square Button
        Button buttonSq = new Button();
        buttonSq.setText(Calculator.SQ_OP);
        buttonSq.setTranslateX(50);
        buttonSq.setTranslateY(25);

        buttonSq.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonSq.getText());
            }
        });

        // Negate Button
        Button buttonNeg = new Button();
        buttonNeg.setText(Calculator.NEG_OP);
        buttonNeg.setTranslateX(75);
        buttonNeg.setTranslateY(25);

        buttonNeg.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonNeg.getText());
            }
        });

        // Decimal Button
        Button buttonDec = new Button();
        buttonDec.setText(".");
        buttonDec.setTranslateX(75);
        buttonDec.setTranslateY(50);

        buttonDec.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(buttonDec.getText());
            }
        });

        // Equals Button
        Button buttonEq = new Button();
        buttonEq.setText("=");
        buttonEq.setTranslateX(75);
        buttonEq.setTranslateY(100);

        buttonEq.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useEquals();
            }
        });

        // Mult Button
        Button buttonMult = new Button();
        buttonMult.setText("*");
        buttonMult.setTranslateX(100);
        buttonMult.setTranslateY(25);

        buttonMult.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonMult.getText());
            }
        });

        // Div Button
        Button buttonDiv = new Button();
        buttonDiv.setText(Calculator.DIV_OP);
        buttonDiv.setTranslateX(100);
        buttonDiv.setTranslateY(50);

        buttonDiv.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonDiv.getText());
            }
        });

        // Add Button
        Button buttonPlus = new Button();
        buttonPlus.setText(Calculator.ADD_OP);
        buttonPlus.setTranslateX(100);
        buttonPlus.setTranslateY(75);

        buttonPlus.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonPlus.getText());
            }
        });

        // Subtract Button
        Button buttonMin = new Button();
        buttonMin.setText(Calculator.SUB_OP);
        buttonMin.setTranslateX(100);
        buttonMin.setTranslateY(100);

        buttonMin.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useOperator(buttonMin.getText());
            }
        });
        
        // 7 Button
        Button button7 = new Button();
        button7.setText("7");
        button7.setTranslateX(0);
        button7.setTranslateY(50);

        button7.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button7.getText());
            }
        });

        // 4 Button
        Button button4 = new Button();
        button4.setText("4");
        button4.setTranslateX(0);
        button4.setTranslateY(75);

        button4.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button4.getText());
            }
        });

        // 1 Button
        Button button1 = new Button();
        button1.setText("1");
        button1.setTranslateX(0);
        button1.setTranslateY(100);

        button1.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button1.getText());
            }
        });

        // 8 Button
        Button button8 = new Button();
        button8.setText("8");
        button8.setTranslateX(25);
        button8.setTranslateY(50);

        button8.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button8.getText());
            }
        });

        // 5 Button
        Button button5 = new Button();
        button5.setText("5");
        button5.setTranslateX(25);
        button5.setTranslateY(75);

        button5.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button5.getText());
            }
        });

        // 2 Button
        Button button2 = new Button();
        button2.setText("2");
        button2.setTranslateX(25);
        button2.setTranslateY(100);

        button2.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button2.getText());
            }
        });

        // 9 Button
        Button button9 = new Button();
        button9.setText("9");
        button9.setTranslateX(50);
        button9.setTranslateY(50);

        button9.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button9.getText());
            }
        });

        // 6 Button
        Button button6 = new Button();
        button6.setText("6");
        button6.setTranslateX(50);
        button6.setTranslateY(75);

        button6.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button6.getText());
            }
        });

        // 3 Button
        Button button3 = new Button();
        button3.setText("3");
        button3.setTranslateX(50);
        button3.setTranslateY(100);

        button3.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button3.getText());
            }
        });

        // 0 Button
        Button button0 = new Button();
        button0.setText("0");
        button0.setTranslateX(75);
        button0.setTranslateY(75);

        button0.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(button0.getText());
            }
        });

        // Clear Button
        Button buttonClear = new Button();
        buttonClear.setText("C");
        buttonClear.setTranslateX(125);
        buttonClear.setTranslateY(25);

        buttonClear.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.clear();
                calculator.clearValue();
            }
        });

        // Clear Entry Button
        Button buttonClearEntry = new Button();
        buttonClearEntry.setText("CE");
        buttonClearEntry.setTranslateX(125);
        buttonClearEntry.setTranslateY(50);

        buttonClearEntry.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                entryTextField.clear();
            }
        });

        // slider Button
        Button buttonSlider = new Button();
        buttonSlider.setText("Use Slider");
        buttonSlider.setTranslateX(0);
        buttonSlider.setTranslateY(185);

        buttonSlider.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useButton(sliderTextField.getText());
                sliderTextField.clear();
            }
        });

        // slider Text Field
        sliderTextField = new TextField();
        sliderTextField.setTranslateX(0);
        sliderTextField.setTranslateY(160);

        //slider
        Slider slider = new Slider();
        slider.setMaxWidth( 350 );
        slider.setTranslateX(0);
        slider.setTranslateY(130);
        slider.setStyle("-fx-font-size: 30; -fx-text-fill: #EEEEEE;");

        slider.valueProperty().addListener( new ChangeListener<Number>() {
            @Override
            public void changed( ObservableValue<? extends Number> observableValue,
                                 Number oldValue, Number newValue ) {
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
                        useButton("1");
                        break;
                    case NUMPAD2:
                    case DIGIT2:
                        useButton("2");
                        break;
                    case NUMPAD3:
                    case DIGIT3:
                        useButton("3");
                        break;
                    case NUMPAD4:
                    case DIGIT4:
                        useButton("4");
                        break;
                    case NUMPAD5:
                    case DIGIT5:
                        useButton("5");
                        break;
                    case NUMPAD6:
                    case DIGIT6:
                        useButton("6");
                        break;
                    case NUMPAD7:
                    case DIGIT7:
                        useButton("7");
                        break;
                    case NUMPAD8:
                    case DIGIT8:
                        useButton("8");
                        break;
                    case NUMPAD9:
                    case DIGIT9:
                        useButton("9");
                        break;
                    case NUMPAD0:
                    case DIGIT0:
                        useButton("0");
                        break;
                    default:
                        break;
                }
            }
        });

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
