package main;

public class Calculator {
    public final static String ADD_OP = "+";
    public final static String SUB_OP = "-";
    public final static String MULT_OP = "*";
    public final static String DIV_OP = "/";
    public final static String NEG_OP = "(-)";
    public final static String SQ_OP = "x²";
    public final static String SQRT_OP = "√";
    public final static String POW_OP = "^";

    /**
     * Stores the calculator's current value
     */
    private float currentValue;

    /**
     * Stores the current operator
     */
    private String currentOperator;

    /**
     * Default constructor
     */
    public Calculator() {
        clearValue();
    }

    /**
     * Gets the calculator's current value
     * @return
     */
    public float getCurrentValue() {
        return currentValue;
    }

    public void setCurrentOperator(String op) {
        currentOperator = op;
    }

    /**
     * Sets the calculator's current value
     */
    public void setCurrentValue(float currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Sets currentValue to 0
     */
    public void clearValue() {
        currentValue = 0;
        currentOperator = null;
    }

    /**
     * 
     */
    public void equals(float f) {
        switch (currentOperator) {
            case ADD_OP:
                addValue(f);
                break;
            case SUB_OP:
                subValue(f);
                break;
            case MULT_OP:
                multValue(f);
                break;
            case DIV_OP:
                divValue(f);
                break;
            case POW_OP:
                powValue(f);
                break;
        }
    }

    /**
     * Adds a float to currentValue
     */
    public void addValue(float f) {
        currentValue += f;
    }

    /**
     * Subtracts a float from currentValue
     */
    public void subValue(float f) {
        currentValue -= f;
    }

    /**
     * Multipies a float by currentValue
     */
    public void multValue(float f) {
        currentValue *= f;
    }

    /**
     * Divides currentValue by a float
     */
    public void divValue(float f) {
        currentValue /= f;
    }

    /**
     * Raises currentValue to a power given by float
     */
    public void powValue(float f) {
        currentValue = (float)Math.pow(currentValue, f);
    }
    
    /**
     * Negates currentValue
     */
    public void negValue(float f) {
        currentValue = -f;
    }

    /**
     * Squares currentValue
     */
    public void sqValue(float f) {
        currentValue = f;
        powValue(2);
    }

    /**
     * Square roots currentValue
     */
    public void sqrtValue(float f) {
        currentValue = (float)Math.sqrt(f);
    }
}
