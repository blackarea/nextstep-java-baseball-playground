package before;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {

    public int execute() {
        Scanner scanner = new Scanner(System.in);
        String value = null;
        try {
             value = scanner.nextLine();
        }catch (NoSuchElementException e){
            System.out.println("공백은 입력할 수 없습니다.");
            return 0;
        }


        //NoSuchElementException
        String[] values = value.split(" ");

        int result = 0;
        try {
            result = inputStringArray(values);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("띄워쓰기가 잘못되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자 자리에 다른 문자를 입력했거나 띄워쓰기가 잘못되었습니다.");
        }

        scanner.close();
        return result;
    }

    public int inputStringArray(String[] values) {
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = calculate(result, values[i], Integer.parseInt(values[i + 1]));
        }
        return result;
    }

    public int calculate(int first, String operator, int second) {
        switch (operator) {
            case "+":
                return add(first, second);
            case "-":
                return subtract(first, second);
            case "*":
                return multiply(first, second);
            case "/":
                return divide(first, second);
        }
        throw new IllegalArgumentException("연산자 자리에 확인되지 않은 문자가 들어왔습니다. 연산자 : " + operator);
    }

    int add(int first, int second) {
        return first + second;
    }

    int subtract(int first, int second) {
        return first - second;
    }

    int multiply(int first, int second) {
        return first * second;
    }

    int divide(int first, int second) {
        try {
            return first / second;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누는 것은 불가능 합니다");
        }
        return 0;
    }

}
