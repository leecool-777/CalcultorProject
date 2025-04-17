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
            Number num1;
            Number num2;
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String inputNum1 = scanner.nextLine();
            if (inputNum1.contains(".")) {
                 num1 = Double.parseDouble(inputNum1);
            } else {
                 num1 = Integer.parseInt(inputNum1);
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            String inputNum2 = scanner.nextLine();
            if (inputNum2.contains(".")) {
                 num2 = Double.parseDouble(inputNum2);
            } else {
                 num2 = Integer.parseInt(inputNum2);
            }
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

        }
    }
}
