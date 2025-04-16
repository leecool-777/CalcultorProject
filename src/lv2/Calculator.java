package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //결과값 저장 배열 필드
    private List<Integer> results = new ArrayList<>();

    //사칙연산 메서드
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException();
        }

        results.add(result);
        return result;
    }

    //Getter
    public List<Integer> getResults() {
        return results;
    }

    //Setter
    public void setResults(List<Integer> results) {
        this.results = results;
    }
}

