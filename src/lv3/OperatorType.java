package lv3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLE('*'),
    DIV('/');

    private char cal;


    OperatorType(char a) {
        this.cal = a;
    }

    public static OperatorType findValue(char c) {
        for (OperatorType value : OperatorType.values()) {
            if (value.cal == c) {
                return value;
            }
        }throw new IllegalArgumentException();
    }

}
