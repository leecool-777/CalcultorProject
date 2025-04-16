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
                System.out.println("결과: " + result);

                //예외 처리
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 값입니다. 양의 정수를 입력하세요");
                scanner.nextLine(); //Scanner 버퍼 정리
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 값입니다. 사칙연산 기호를 입력해주세요");
                continue;
            }

            System.out.print("더 계산하시겠습니까? (exit 입력시 종료, 계산을 원하시면 엔터를 눌러주세요 !) : ");
            String option = scanner.nextLine();
            if (option.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }
    }
}
