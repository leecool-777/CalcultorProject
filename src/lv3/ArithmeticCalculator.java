package lv3;


import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

    private List<Number> results = new ArrayList<>();

    public Number calculate(T num1, T num2, OperatorType operator) {

        Number result;

        if (num1 instanceof Integer && num2 instanceof Integer) {
            result = switch (operator) {
                case PLUS -> num1.intValue() + num2.intValue();
                case MINUS -> num1.intValue() - num2.intValue();
                case MULTIPLE -> num1.intValue() * num2.intValue();
                case DIV -> (double) num1.intValue() / num2.intValue();
                default -> throw new IllegalArgumentException();
            };
        } else {
            result = switch (operator) {
                case PLUS -> num1.doubleValue() + num2.doubleValue();
                case MINUS -> num1.doubleValue() - num2.doubleValue();
                case MULTIPLE -> num1.doubleValue() * num2.doubleValue();
                case DIV -> num1.doubleValue() / num2.doubleValue();
                default -> throw new IllegalArgumentException();
            };
        }
        results.add(result); //결과값 배열에 추가
        return result;
    }

    public List<Number> getResults() {
        return results;
    }
}

