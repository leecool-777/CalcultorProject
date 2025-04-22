package lv3ref.app;

import lv3ref.arithmeticcalculator.Calculator;
import lv3ref.arithmeticcalculator.ResultStore;

public class Main {

    public static void main(String[] args) {
        Calculator<Number> calculator = new Calculator<>();

        ResultStore resultStore = new ResultStore();

        CalculationApp calculationApp = new CalculationApp(resultStore, calculator);
        calculationApp.start();

    }
}
