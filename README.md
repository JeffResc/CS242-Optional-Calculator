# CS242-Optional-Calculator
Optional Extra Credit Project for CS242
Teammates: Jeffrey Rescignano & Nathan Collinsworth

# Report
My approach to creating the GUI was to go with a similar layout to [Windows Calculator](https://www.microsoft.com/en-us/p/windows-calculator/9wzdncrfhvn5) as I thought that their layout was easy to use, which would give users of our project a sense of familiarity. I however, created my own design by trying multiple color combinations until I found the one that I liked.

As for how the issue of getting multiple digits is solved, all buttons just map their value directly to `entryTextField` so having multiple numbers in a String isn't a problem. From there, once an operator or equals button is pressed, the text in `entryTextField` is gathered using `entryTextField.getText()` and is parsed into a Float using `Float.parseFloat(entryTextField.getText())`. If this is the first time the user is using the calculator (i.e. it was previously cleared), when the user presses a binary operator, it just stores that operator in the `currentOperator` variable and the number in `currentValue`. From there, once the equals button is pressed, it will re-read the value of `entryTextField` to get the second number, recall the first number from `currentValue` and then apply the operator using `currentOperator`. After the calculation, `currentValue` is overridden to the new current value and the GUI is updated using the `updateDisplayedValue()` method.

## Icon Attribution
Icon used with permission from [DinosoftLabs](https://www.flaticon.com/authors/dinosoftlabs). Icon made by [DinosoftLabs](https://www.flaticon.com/authors/dinosoftlabs) from [Flaticon](https://www.flaticon.com/).