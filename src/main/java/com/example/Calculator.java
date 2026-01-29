package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        switch (op) {
            case "add", "add-again":
                return a + b;

            case "sub", "sub-again":
                return a - b;

            case "mul", "mul-again":
                return a * b;

            case "div", "div-again":
                return (b == 0) ? 0 : a / b;

            case "mod":
                return a % b;

            case "pow":
                return (int) Math.pow(a, b);

            default:
                return 0;
        }
    }
}