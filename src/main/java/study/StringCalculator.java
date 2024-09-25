package study;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();

        System.out.println("Enter a calculation (e.g., 2+3*4/2): ");
        String input = scanner.nextLine(); // 사용자로부터 입력 받기

        try {
            int result = calculator.calculate(input); // 계산 수행
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }


        String[] tokens = input.split("(?<=[-+*/])|(?=[-+*/])");

        int result = Integer.parseInt(tokens[0]); // 첫 번째 숫자

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i]; // 연산자
            int nextNumber = Integer.parseInt(tokens[i + 1]); // 다음 숫자

            result = applyOperator(result, operator, nextNumber); // 연산 수행
        }

        return result;
    }

    private int applyOperator(int left, String operator, int right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
