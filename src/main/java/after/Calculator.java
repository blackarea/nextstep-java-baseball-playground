package after;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {

    public int execute() {
        Scanner scanner = new Scanner(System.in);
        String value;
        try {
            value = scanner.nextLine();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("공백은 입력할 수 없습니다.");
        }
        scanner.close();
        String[] values = value.split(" ");

        return throwMethod(values);
    }

    public int throwMethod(String[] values){
        try {
            return calculate(values);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("입력이 잘못되었습니다.");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 자리에 다른 문자를 입력했거나 띄워쓰기가 잘못되었습니다.");
        }
    }

    public int calculate(String[] values) {
        Operator operator;
        int result = Integer.parseInt(values[0]);
        int nextValue;
        for (int i = 1; i < values.length; i += 2) {
            String symbol = values[i];
            nextValue = Integer.parseInt(values[i + 1]);

            operator = Operator.findOperator(symbol);
            result = operator.operate(result, nextValue);
        }
        return result;
    }

}
