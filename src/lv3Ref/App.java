package lv3Ref;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SplitService splitService = new SplitService();

        System.out.println("===========================");
        System.out.println("           계산기           ");
        System.out.println("===========================");

        while (true) {
            try {
                //*입력값 실수 정수 판별
                // 입력 1
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String inputNum1 = scanner.nextLine();


                //입력 2
                System.out.print("두 번째 숫자를 입력하세요: ");
                String inputNum2 = scanner.nextLine();


                //사칙연산 입력
                System.out.print("사칙연산 기호를 입력하세요(+ - * /): ");
                char operator = scanner.next().charAt(0);
                OperatorType calOperator = OperatorType.findValue(operator);
                scanner.nextLine();//Scanner 버퍼 정리

                Number result = splitService.convertToSend(inputNum1, inputNum2, calOperator);


                //입력값 전달 및 연산 결과 반환
                System.out.println("===========================");
                System.out.println("결과: " + result);
                System.out.println("결과 데이터: " + splitService.arithmeticCalculator.getResults());
                System.out.println("===========================");


                System.out.print("계속하시려면 엔터를, 종료하려면 'exit', 결과 삭제는 'delete'를, 값 비교는 'compare'를 입력해주세요: ");
                String option = scanner.nextLine();
                splitService.chooseOption(option);



                //예외처리
            } catch (NumberFormatException e) {
                System.out.println("잘못된 값입니다. 다시 입력해주세요.");
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 값입니다. 사칙연산 기호를 입력해주세요");
                scanner.nextLine();
            }
        }
    }
}