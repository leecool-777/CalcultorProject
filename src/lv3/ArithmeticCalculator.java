package lv3;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private List<Number> results = new ArrayList<>();

    public Number calculate(T num1, T num2, OperatorType operator) {

        Number result;

        if (num1 instanceof Integer && num2 instanceof Integer) {
            result = switch (operator) {
                case PLUS -> num1.intValue() + num2.intValue();
                case MINUS -> num1.intValue() - num2.intValue();
                case MULTIPLE -> num1.intValue() * num2.intValue();
                case DIV ->  num1.intValue() / num2.intValue();
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

    //저장결과 조회 메서드
    public List<Number> getResults() {

        return results;
    }

    //Setter 메서드
    public void setResults(List<Number> results) {
        this.results = results;
    }

    //가장 먼저 저장된 데이터 삭제 메서드
    public void removeResult() {
        results.remove(0);
    }

    public List<Number>  compareToNum(T compareNum) {
        return results.stream()
                .filter(number -> number.doubleValue() > compareNum.doubleValue())
                .collect(Collectors.toList());

    }
}


