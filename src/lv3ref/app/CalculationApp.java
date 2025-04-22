package lv3ref.app;

import lv3ref.arithmeticcalculator.Calculator;
import lv3ref.arithmeticcalculator.OperatorType;
import lv3ref.arithmeticcalculator.ResultStore;
import lv3ref.util.ConsolePrinter;

import static lv3ref.util.ParseToIntegerOrDouble.parseToIntegerOrDouble;

import java.util.Scanner;

public class CalculationApp {
    //속성
    private final ResultStore resultStore;
    private final Calculator<Number> calculator;

    //생성자
    public CalculationApp(ResultStore resultStore, Calculator<Number> calculator) {
        this.resultStore = resultStore;
        this.calculator = calculator;
    }

    /**
     * 실행 흐름제어
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        ConsolePrinter.welcomeMessage();

        label:
        while (true) {
            try {
                //*입력값 실수 정수 판별
                // 입력 1
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String inputNum1 = scanner.nextLine();
                Number num1 = parseToIntegerOrDouble(inputNum1); //문자열 파싱

                //입력 2
                System.out.print("두 번째 숫자를 입력하세요: ");
                String inputNum2 = scanner.nextLine();
                Number num2 = parseToIntegerOrDouble(inputNum2); //문자열 파싱

                //사칙연산 입력
                System.out.print("사칙연산 기호를 입력하세요(+ - * /): ");
                char operator = scanner.next().charAt(0);
                scanner.nextLine();

                //입력값 전달 및 연산 결과 반환
                Number result = calculator.calculate(num1, num2, OperatorType.fromSymbol(operator));
                resultStore.addResult(result);

                ConsolePrinter.displayResult(result, resultStore);
                ConsolePrinter.displayCommands();
                String option = scanner.nextLine();

                switch (option) {
                    case "exit":
                        System.out.println("프로그램을 종료합니다.");
                        break label;
                    case "delete":
                        resultStore.removeFirstResult();
                        break;
                    case "deleteAll":
                        resultStore.removeAllResult();
                        break;
                    //값 비교
                    case "compare":
                        System.out.printf("결과 데이터에서 비교할 값을 입력해 주세요.%n그 값보다 큰 데이터들이 출력됩니다: ");
                        String inputCompareNum = scanner.nextLine();
                        resultStore.findGreaterThan(parseToIntegerOrDouble(inputCompareNum));
                        break;
                }
                ConsolePrinter.printLine();

                //예외처리
            } catch (NumberFormatException e) {
                System.out.println("[오류] 잘못된 값입니다. 다시 입력해주세요.");
            } catch (ArithmeticException e) {
                System.out.println("[오류] 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[오류] 잘못된 값입니다. 사칙연산 기호를 입력해주세요.");
            }
        }
    }
}
