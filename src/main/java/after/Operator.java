package after;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (first, second) -> first + second),
    SUBTRACT("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    });

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation){
        this.symbol = symbol;
        this.operation = operation;
    }

    public int operate(int first, int second){
        return operation.apply(first, second);
    }

    public static Operator findOperator(String symbol){
        for(Operator operator : Operator.values()) {
            if (symbol.equals(operator.symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
}
