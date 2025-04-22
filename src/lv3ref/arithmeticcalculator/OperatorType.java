package lv3ref.arithmeticcalculator;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromSymbol(char inputSymbol) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.symbol == inputSymbol) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException();
    }
}
