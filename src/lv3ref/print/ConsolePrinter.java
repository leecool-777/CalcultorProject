package lv3ref.print;

import lv3ref.arithmeticcalculator.ResultStore;

public class ConsolePrinter {
    public void welcomeMessage() {
        System.out.println("==========================================");
        System.out.println("                   계산기                  ");
        System.out.println("==========================================");
    }

    public void displayResult(Number result, ResultStore resultStore) {
        System.out.println("==========================================");
        System.out.println("결과: " + result);
        System.out.println("결과 데이터: " + resultStore.getResultStore());
        System.out.println("==========================================");
    }
    public void displayCommands() {
        System.out.println("                   명령어                  ");
        System.out.println("==========================================");
        System.out.println("계속하기: Enter 클릭");
        System.out.println("값 비교: compare ");
        System.out.println("오래된 결과 삭제: delete ");
        System.out.println("모든 결과 삭제: deleteAll ");
        System.out.println("종료: exit ");
        System.out.print("명령어를 입력해 주세요: ");
    }

}
