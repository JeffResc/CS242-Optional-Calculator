package main;

import java.util.LinkedList;
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
    /**
     * Sets the scene width
     */
    private final int SCENE_WIDTH = 325;

    /**
     * Sets the scene height
     */
    private final int SCENE_HEIGHT = 450;

    /**
     * Creates a Calculator instance
     */
    private Calculator calculator = new Calculator();

    /**
     * Creates the main text field
     */
    private TextField entryTextField;

    /**
     * Creates the slider text field
     */
    private TextField sliderTextField;

    /**
     * Sets if the main text field should clear on next input
     */
    private Boolean shouldClear = false;

    /**
     * Method that the equals button calls
     */
    private void useEquals() {
        final float f = Float.parseFloat(entryTextField.getText());
        calculator.equals(f);
        updateDisplayedValue();
    }

    /**
     * Method that the backspace button calls
     */
    private void useBackspace() {
        entryTextField.setText(entryTextField.getText().substring(0, entryTextField.getText().length()-1));
    }

    /**
     * Method that any number or decimal button calls
     */
    private void useNumButton(String s) {
        if (shouldClear) {
            shouldClear = false;
            entryTextField.setText(s);
        } else
            entryTextField.setText(entryTextField.getText() + s);
    }

    /**
     * Sets the default size of a button
     * @param c
     */
    private void setButtonSize(Control c) {
        setSizeMan(c, 1, 1);
    }

    /**
     * Manually sets the size of a button
     * @param c
     * @param x
     * @param y
     */
    private void setSizeMan(Control c, int x, int y) {
        c.setMinSize(x * 50, y * 50);
        c.setPrefSize(x * 50, y * 50);
        c.setMaxSize(x * 50, y * 50);
    }

    /**
     * Sets the position of a button
     * @param c
     * @param x
     * @param y
     */
    private void setPos(Control c, int x, int y) {
        c.setTranslateX(x * 50);
        c.setTranslateY(y * 50);
    }

    /**
     * Updates the value shown in the entryTextField
     */
    private void updateDisplayedValue() {
        String currentValueStr = Float.toString(calculator.getCurrentValue());
        if (currentValueStr.endsWith(".0"))
            currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 2);
        entryTextField.setText(currentValueStr);
    }

    /**
     * Creates a number button and returns it
     * @param s
     * @param x
     * @param y
     */
    private Button createNumButton(String s, int x, int y) {
        Button b = createButton(s, x, y);
        b.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useNumButton(b.getText());
            }
        });
        return b;
    }

    /**
     * Creates an operator button and returns it
     * @param s
     * @param x
     * @param y
     */
    private Button createOperButton(String s, int x, int y) {
        Button b = createButton(s, x, y);
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
        return b;
    }

    /**
     * Creates a generic button and returns the it
     * @param s
     * @param x
     * @param y
     * @return
     */
    private Button createButton(String s, int x, int y) {
        Button b = new Button();
        b.setText(s);
        setPos(b, x, y);
        setButtonSize(b);
        return b;
    }

    /**
     * Do not allow Control to be selected
     */
    private void doNotSelect(Control c, Group r) {
        entryTextField.focusedProperty().addListener((ob,  ov,  nv) -> {
            r.requestFocus(); // Delegate the focus to root
        });
    }

    /**
     * Starts the application
     */
    @Override
    public void start(Stage stage) {
        // Entry Text Field
        entryTextField = new TextField();
        entryTextField.setEditable(false);
        setPos(entryTextField, 0, 0);
        setSizeMan(entryTextField, 6, 1);

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

        // Backspace Button
        Button buttonBackspace = new Button();
        buttonBackspace.setText("⇦");
        setPos(buttonBackspace, 5, 3);
        setButtonSize(buttonBackspace);
        buttonBackspace.setOnAction( new EventHandler<ActionEvent>() {
            public void handle( ActionEvent ae ) {
                useBackspace();
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
        sliderTextField.setEditable(false);
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

        // Create list to store number and operator buttons
        LinkedList<Control> rootControls = new LinkedList<Control>(); 

        // Create all number buttons
        rootControls.add(createNumButton("0", 1, 5)); // 0 Button
        rootControls.add(createNumButton("1", 0, 4)); // 1 Button
        rootControls.add(createNumButton("2", 1, 4)); // 2 Button
        rootControls.add(createNumButton("3", 2, 4)); // 3 Button
        rootControls.add(createNumButton("4", 0, 3)); // 4 Button
        rootControls.add(createNumButton("5", 1, 3)); // 5 Button
        rootControls.add(createNumButton("6", 2, 3)); // 6 Button
        rootControls.add(createNumButton("7", 0, 2)); // 7 Button
        rootControls.add(createNumButton("8", 1, 2)); // 8 Button
        rootControls.add(createNumButton("9", 2, 2)); // 9 Button
        rootControls.add(createNumButton(".", 2, 5)); // Decimal Button

        // Create all operator buttons
        rootControls.add(createOperButton(Calculator.ADD_OP, 3, 4));       // Add Button
        rootControls.add(createOperButton(Calculator.SUB_OP, 3, 3));       // Subtract Button
        rootControls.add(createOperButton(Calculator.MULT_OP, 3, 2));      // Multiply Button
        rootControls.add(createOperButton(Calculator.DIV_OP, 3, 1));       // Divide Button
        rootControls.add(createOperButton(Calculator.NEG_OP, 0, 5));       // Negate Button
        rootControls.add(createOperButton(Calculator.SQ_OP, 2, 1));        // Square Button
        rootControls.add(createOperButton(Calculator.POW_OP, 1, 1));       // Power Button
        rootControls.add(createOperButton(Calculator.SQRT_OP, 0, 1));      // Square Root Button

        // Scene
        Group root = new Group(entryTextField, buttonEq, buttonClear, buttonClearEntry, buttonBackspace, buttonSlider, sliderTextField, slider);
        root.getChildren().addAll(rootControls);
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
                    case BACK_SPACE:
                        useBackspace();
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

        // Do not select entryTextField or sliderTextField, delegrate it to root
        doNotSelect(entryTextField, root);
        doNotSelect(sliderTextField, root);
    }

    /**
     * Main method that gets called when the program is started. Launches the application.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Launch App
        launch(args);
    }
}
