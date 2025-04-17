package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("===========================");
        System.out.println("           계산기           ");
        System.out.println("===========================");


        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = scanner.nextInt();
                if (num1 < 0) {
                    System.out.println("양의 정수만 입력 가능합니다 !");
                    continue;
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("양의 정수만 입력 가능합니다 !");
                    continue;
                }

                System.out.print("사칙연산 기호를 입력하세요(+ - * /): ");
                char operator = scanner.next().charAt(0);
                scanner.nextLine();//Scanner 버퍼 정리

                //입력값 전달 및 연산 결과 반환
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("===========================");
                System.out.println("결과: " + result);
                System.out.println("결과 데이터: " + calculator.getResults());
                System.out.println("===========================");


                //예외 처리
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); //분모 0 예외처리
                continue;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 값입니다. 양의 정수를 입력하세요"); // 잘못된 값(문자열, 실수 등) 예외처리
                scanner.nextLine(); //Scanner 버퍼 정리
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 값입니다. 사칙연산 기호를 입력해주세요"); //잘못된 값 (사칙연산 외) 예외처리
                continue;
            }


            System.out.print("계속하시려면 엔터를, 종료하려면 'exit', 결과 삭제는 'delete'를 입력하세요: ");
            String option = scanner.nextLine();
            if (option.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            //가장 먼저 저장된 데이터 삭제
            else if (option.equals("delete")) {
                calculator.removeResult();
                System.out.println("결과값을 삭제했습니다.");
                System.out.println("결과 데이터: " + calculator.getResults());
            }
        }
    }
}
