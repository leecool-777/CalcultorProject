package lv3ref.util;

public class ParseToIntegerOrDouble {

    //문자열 파싱 기능
    public static Number parseToIntegerOrDouble(String input) {
        if (input.contains(".")) {
            return Double.parseDouble(input);
        }
        return Integer.parseInt(input);
    }
}
