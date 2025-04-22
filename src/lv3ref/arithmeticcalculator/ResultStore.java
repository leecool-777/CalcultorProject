package lv3ref.arithmeticcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultStore {

    //속성
    private final List<Number> resultStore = new ArrayList<>();

    //기능
    //결과 데이터 추가
    void addResult(Number result) {
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



    /*
    입력된 값보다 큰 데이터 조회 메서드
    (실수 비교)
    */
    public List<Number> findGreaterThan(Number compareNum) {
        return resultStore.stream() //1. 데이터 준비
                .filter(number -> number.doubleValue() > compareNum.doubleValue()) //2. 중간 연산 등록
                .collect(Collectors.toList()); //3. 최종 연산
    }
}
