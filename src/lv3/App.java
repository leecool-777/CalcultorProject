package lv3;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();

        System.out.println("===========================");
        System.out.println("           계산기           ");
        System.out.println("===========================");

        while (true) {
            try {
                // 매개변수 선언
                Number num1;
                Number num2;

                //*입력값 실수 정수 판별
                // 입력 1
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String inputNum1 = scanner.nextLine();
                if (inputNum1.contains(".")) {
                    num1 = Double.parseDouble(inputNum1);
                } else {
                    num1 = Integer.parseInt(inputNum1);
                }

                //입력 2
                System.out.print("두 번째 숫자를 입력하세요: ");
                String inputNum2 = scanner.nextLine();
                if (inputNum2.contains(".")) {
                    num2 = Double.parseDouble(inputNum2);
                } else {
                    num2 = Integer.parseInt(inputNum2);
                }

                //사칙연산 입력
                System.out.print("사칙연산 기호를 입력하세요(+ - * /): ");
                char operator = scanner.next().charAt(0);
                OperatorType calOperator = OperatorType.findValue(operator);
                scanner.nextLine();//Scanner 버퍼 정리


                //입력값 전달 및 연산 결과 반환
                System.out.println("===========================");
                Number result = arithmeticCalculator.calculate(num1, num2, calOperator);
                System.out.println("결과: " + result);
                System.out.println("결과 데이터: " + arithmeticCalculator.getResults());
                System.out.println("===========================");

                System.out.print("계속하시려면 엔터를, 종료하려면 'exit', 결과 삭제는 'delete'를, 값 비교는 'compare'를 입력해주세요: ");
                String option = scanner.nextLine();

            /*
              옵션
             */
                //종료
                if (option.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                }
                //가장 먼저 저장된 데이터 삭제
                else if (option.equals("delete")) {
                    arithmeticCalculator.removeResult();
                    System.out.println("결과값을 삭제했습니다.");
                    System.out.println("결과 데이터: " + arithmeticCalculator.getResults());
                }
                //값 비교
                else if (option.equals("compare")) {
                    System.out.print("결과 데이터에서 비교할 값을 입력해 주세요. 그 값보다 큰 데이터들이 출력됩니다. : ");
                    Number compareNum;
                    String inputNum3 = scanner.nextLine();
                    if (inputNum3.contains(".")) {
                        compareNum = Double.parseDouble(inputNum3);
                    } else {
                        compareNum = Integer.parseInt(inputNum3);
                    }
                    System.out.println("결과값 중" + compareNum + "보다 큰 데이터는 "
                            + arithmeticCalculator.compareToNum(compareNum) + "입니다.");
                }
                //예외처리
            } catch (Exception e) {
                System.out.println("잘못된 값입니다. 처음부터 다시 시작해주세요.");
            }
        }
    }
}
