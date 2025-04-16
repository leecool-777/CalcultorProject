package lv2;

public class Calculator {

    private int result;

    public int calculate(int num1, int num2, char operator) {

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 값입니다. 다시 입력해주세요 !");

        }

        return result;
    }



    }

