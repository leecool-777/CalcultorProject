package lv3ref.app;

import lv3ref.arithmeticcalculator.ArithmeticCalculator;
import lv3ref.arithmeticcalculator.OperatorType;
import lv3ref.arithmeticcalculator.ResultStore;

import java.util.Scanner;

public class CalculationApp {
    //속성
    private final ResultStore resultStore;
    private final ArithmeticCalculator<Number> arithmeticCalculator;


    //생성자
    public CalculationApp(ResultStore resultStore, ArithmeticCalculator<Number> arithmeticCalculator) {
        this.resultStore = resultStore;
        this.arithmeticCalculator = arithmeticCalculator;
    }

    //기능
    //문자열 파싱
    private static Number parseIntegerOrDouble(String input) {
        if (input.contains(".")) {
            return Double.parseDouble(input);
        }
        return Integer.parseInt(input);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("                   계산기                  ");
        System.out.println("==========================================");

        label:
        while (true) {
            try {
                //*입력값 실수 정수 판별
                // 입력 1
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String inputNum1 = scanner.nextLine();
                Number num1 = parseIntegerOrDouble(inputNum1); //문자열 파싱


                //입력 2
                System.out.print("두 번째 숫자를 입력하세요: ");
                String inputNum2 = scanner.nextLine();
                Number num2 = parseIntegerOrDouble(inputNum2); //문자열 파싱


                //사칙연산 입력
                System.out.print("사칙연산 기호를 입력하세요(+ - * /): ");
                char operator = scanner.next().charAt(0);
                scanner.nextLine();

                //입력값 전달 및 연산 결과 반환
                Number result = arithmeticCalculator.calculate(num1, num2, OperatorType.fromSymbol(operator));
                resultStore.addResult(result);

                System.out.println("==========================================");
                System.out.println("결과: " + result);
                System.out.println("결과 데이터: " + resultStore.getResultStore());
                System.out.println("==========================================");


                System.out.print("계속하시려면 엔터를, 종료하려면 'exit', 결과 삭제는 'delete'를, 값 비교는 'compare'를 입력해주세요: ");
                String option = scanner.nextLine();
                switch (option) {
                    case "exit":
                        System.out.println("프로그램을 종료합니다.");
                        break label;
                    case "delete":
                        resultStore.removeFirstResult();
                        break;
                    //값 비교
                    case "compare":
                        System.out.print("결과 데이터에서 비교할 값을 입력해 주세요. 그 값보다 큰 데이터들이 출력됩니다. : ");
                        String inputCompareNum = scanner.nextLine();
                        Number compareNum = parseIntegerOrDouble(inputCompareNum);
                        System.out.println("결과값 중 " + compareNum + "보다 큰 데이터는 "
                                + resultStore.findGreaterThan(compareNum) + "입니다.");
                        break;
                }

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
