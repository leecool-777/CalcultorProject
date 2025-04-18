package lv3ref;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultData <T extends Number> {

    private List<Number> results = new ArrayList<>();

    public void add(Number result) {
        results.add(result);
    }


    //저장결과 조회 메서드
    public List<Number> getResults() {
        return results;
    }


    //가장 먼저 저장된 데이터 삭제 메서드
    public void removeResult() {
        results.remove(0);
    }

    /*
    입력된 값보다 큰 데이터 조회 메서드
    (실수 비교)
    */
    public List<Number> findGreaterThan(Number compareNum) {
        return results.stream()
                .filter(number -> number.doubleValue() > compareNum.doubleValue())
                .collect(Collectors.toList());

    }
}
