package lv3;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private List<Number> results = new ArrayList<>();

    public Number calculate(T num1, T num2, OperatorType operatorType){

        Number result; //결과 변수 선언

        /**
         두 개의 입력값 모두 정수일 경우 Integer로 결과 반환 및 저장(나눗셈은 Double)
         실수일 경우 Double로 결과 반환 및 저장
         */
        if (num1 instanceof Integer && num2 instanceof Integer) {
            result = switch (operatorType) {
                case PLUS -> num1.intValue() + num2.intValue();
                case MINUS -> num1.intValue() - num2.intValue();
                case MULTIPLY -> num1.intValue() * num2.intValue();
                case DIVIDE -> {
                    if (num2.intValue() == 0) {
                        throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    yield (double) num1.intValue() / num2.intValue();
                }
            };
        }else {
            result = switch (operatorType) {
                case PLUS -> num1.doubleValue() + num2.doubleValue();
                case MINUS -> num1.doubleValue() - num2.doubleValue();
                case MULTIPLY -> num1.doubleValue() * num2.doubleValue();
                case DIVIDE -> {
                    if (num2.intValue() == 0) {
                        throw new ArithmeticException();
                    }
                    yield num1.doubleValue() / num2.doubleValue();
                }
            };
        }
        results.add(result); //결과값 배열에 추가
        return result; //결과값 반환
    }

    //문자열 파싱
    public Number parseIntegerOrDouble(String input) {
        if (input.contains(".")) {
            return Double.parseDouble(input);
        } else {
            return Integer.parseInt(input);
        }
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

    /*
    입력된 값보다 큰 데이터 조회 메서드
    (실수 비교)
    */
    public List<Number> compareToNum(T compareNum) {
        return results.stream()
                .filter(number -> number.doubleValue() > compareNum.doubleValue())
                .collect(Collectors.toList());

    }
}


