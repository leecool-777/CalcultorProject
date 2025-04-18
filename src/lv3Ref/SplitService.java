package lv3Ref;

import java.util.Scanner;

public class SplitService {

    ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();

    private Number num1;
    private Number num2;
    private OperatorType operator;

    public Number convertToSend(String input1, String input2, OperatorType operatorType) {
        if (input1.contains(".")) {
            num1 = Double.parseDouble(input1);
        } else {
            num1 = Integer.parseInt(input1);
        }
        if (input2.contains(".")) {
            num2 = Double.parseDouble(input2);
        } else {
            num2 = Integer.parseInt(input2);
        }
        this.operator = operatorType;

        return arithmeticCalculator.calculate(num1, num2, operator);
    }


    public void chooseOption(String option) {
        Scanner scanner = new Scanner(System.in);
        if (option.equals("exit")) {
            System.out.println("계산기를 종료합니다.");
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
    }
}
