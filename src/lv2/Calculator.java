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

        results.add(result); //결과값 배열에 추가
        return result; //결과값 반환
    }

    //Getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    //Setter 메서드
    public void setResults(List<Integer> results) {
        this.results = results;
    }

    //가장 먼저 저장된 데이터 삭제 메서드
    public void removeResult() {
        results.remove(0);
    }
}

