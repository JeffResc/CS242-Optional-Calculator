package main;

public class Calculator {
    /**
     * Stores the calculator's current value
     */
    private float currentValue;

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

    /**
     * Sets currentValue to 0
     */
    public void clearValue() {
        currentValue = 0;
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
        // This converts the double to a float which shouldn't change the value in most cases
        currentValue = (float)Math.pow(currentValue, f);
    }
    
    /**
     * Negates currentValue
     */
    public void negValue() {
        currentValue = -currentValue;
    }

    /**
     * Squares currentValue
     */
    public void sqValue() {
        powValue(2);
    }

    /**
     * Square roots currentValue
     */
    public void sqrtValue() {
        // This converts the double to a float which shouldn't change the value in most cases
        currentValue = (float)Math.sqrt(currentValue);
    }
}
