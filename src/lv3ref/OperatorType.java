package lv3ref;



public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;


    OperatorType(char operator) {
        this.operator = operator;
    }

    public static OperatorType getOperatorType(char inputOperator) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.operator == inputOperator) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException();
    }
}
