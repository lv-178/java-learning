public class Arithmetic {

    private int firstNumber;
    private int secondNumber;
    private int result = 0;

    public Arithmetic(int writeFirst, int writeSecond) {
        firstNumber = writeFirst;
        secondNumber = writeSecond;
    }

    public void sum() {
        result = firstNumber + secondNumber;
    }

    public void sub() {
        result = firstNumber - secondNumber;
    }

    public void min() {
        if (firstNumber < secondNumber) {
            result = firstNumber;
        } else {
            result = secondNumber;
        }
    }

    public void max() {
        if (firstNumber > secondNumber) {
            result = firstNumber;
        } else {
            result = secondNumber;
        }
    }

    public int getResult(String operation) {
        switch (operation) {
            case "+" -> sum();
            case "-" -> sub();
            case "min" -> min();
            case "max" -> max();
        }
        return result;
    }
}