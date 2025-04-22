package lv3ref.util;

import lv3ref.arithmeticcalculator.ResultStore;

public class ConsolePrinter {
    public static void welcomeMessage() {
        printLine();
        System.out.println("                   계산기                  ");
        printLine();
    }

    public static void displayResult(Number result, ResultStore resultStore) {
        printLine();
        System.out.println("결과: " + result);
        System.out.println("결과 데이터: " + resultStore.getResultStore());
        printLine();
    }
    public static void displayCommands() {
        System.out.println("                   명령어                  ");
        printLine();
        System.out.println("계속하기: Enter 클릭");
        System.out.println("값 비교: compare ");
        System.out.println("오래된 결과 삭제: delete ");
        System.out.println("모든 결과 삭제: deleteAll ");
        System.out.println("종료: exit ");
        System.out.print("명령어를 입력해 주세요: ");
    }
    public static void printLine() {
        System.out.println("========================================");
    }
}
