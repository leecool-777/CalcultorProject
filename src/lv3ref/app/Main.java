package lv3ref.app;

import lv3ref.arithmeticcalculator.ArithmeticCalculator;
import lv3ref.arithmeticcalculator.ResultStore;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();

        ResultStore resultStore = new ResultStore();

        CalculationApp calculationApp = new CalculationApp(resultStore, arithmeticCalculator);
        calculationApp.start();

    }
}
