package lv3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private char oprator;


    OperatorType(char operator) {
        this.oprator = operator;
    }

    public static OperatorType getOperatorType(char intputOprator) {
        for (OperatorType value : OperatorType.values()) {
            if (value.oprator == intputOprator) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
