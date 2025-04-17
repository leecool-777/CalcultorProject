package lv3;


import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

    private List<Number> results = new ArrayList<>();

    public Number calculate(T num1, T num2, OperatorType operator) {

        Number result;

        if (num1 instanceof Integer && num2 instanceof Integer) {
            switch (operator) {
                case PLUS:
                    result = num1.intValue() + num2.intValue();
                    break;
                case MINUS:
                    result = num1.intValue() - num2.intValue();
                    break;
                case MULTIPLE:
                    result = num1.intValue() * num2.intValue();
                    break;
                case DIV:
                    result = (double) num1.intValue() / num2.intValue();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            switch (operator) {
                case PLUS:
                    result = num1.doubleValue() + num2.doubleValue();
                    break;
                case MINUS:
                    result = num1.doubleValue() - num2.doubleValue();
                    break;
                case MULTIPLE:
                    result = num1.doubleValue() * num2.doubleValue();
                    break;
                case DIV:
                    result = num1.doubleValue() / num2.doubleValue();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        results.add(result); //결과값 배열에 추가
        return result;
    }

    public List<Number> getResults() {
        return results;
    }
}

