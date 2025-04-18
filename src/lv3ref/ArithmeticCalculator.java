package lv3ref;

public class ArithmeticCalculator<T extends Number> {

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
}


