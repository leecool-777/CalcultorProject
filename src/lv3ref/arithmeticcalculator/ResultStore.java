package lv3ref.arithmeticcalculator;

import java.util.ArrayList;
import java.util.List;

public class ResultStore {

    //속성
    private final List<Number> resultStore = new ArrayList<>();

    //기능
    //결과 데이터 추가
    public void addResult(Number result) {
        resultStore.add(result);
    }


    //저장결과 조회 메서드
    public List<Number> getResultStore() {
        return resultStore;
    }


    //가장 먼저 저장된 데이터 삭제 메서드
    public void removeFirstResult() {
        resultStore.remove(0);
        System.out.println("결과값을 삭제했습니다.");
        System.out.println("결과 데이터: " + getResultStore());
    }

    public void removeAllResult() {
        resultStore.removeAll(resultStore);
        System.out.println("모든 결과값을 삭제했습니다.");
        System.out.println("결과 데이터: " + getResultStore());
    }


    /*
    입력된 값보다 큰 데이터 조회 메서드
    (실수 비교)
    */
    public void findGreaterThan(Number compareNum) {
        List<Number> filteredNumbers = resultStore.stream() //1. 데이터 준비
                .filter(number -> number.doubleValue() > compareNum.doubleValue()) //2. 중간 연산 등록
                .toList(); //3. 최종 연산

        if (filteredNumbers.isEmpty()) {
            System.out.printf("%n결과값 중 %s보다 큰 데이터는 없습니다.%n", compareNum);
        }
        System.out.printf("%n결과값 중 %s보다 큰 데이터는 %s 입니다.%n",compareNum, filteredNumbers);

    }
}
